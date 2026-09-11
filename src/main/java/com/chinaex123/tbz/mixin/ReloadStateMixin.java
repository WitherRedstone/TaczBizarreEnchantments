package com.chinaex123.tbz.mixin;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.event.enchantments.OutlawEvent;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.chinaex123.tbz.utils.ReloadContextHolder;
import com.tacz.guns.api.entity.ReloadState;
import com.tacz.guns.api.item.IGun;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

/**
 * 换弹状态混入类
 * <p>
 * 功能：用于修改换弹倒计时，实现换弹加速
 * 修改 ReloadState.setCountDown 方法中的 countDown 参数
 */
@Mixin(value = ReloadState.class, remap = false)
public class ReloadStateMixin {

    @Shadow
    protected ReloadState.StateType stateType;

    @Shadow
    protected long countDown;

    /**
     * 获取当前玩家
     * 通过 ReloadContextHolder 获取玩家
     *
     * @return 当前玩家，如果没有则返回null
     */
    @Unique
    private Player tbz$getCurrentPlayer() {
        return ReloadContextHolder.getPlayer();
    }

    /**
     * 修改换弹倒计时
     * 当玩家拥有不法之徒附魔的换弹加速标记时，缩短换弹倒计时
     *
     * @param countDown 原始倒计时
     * @return 修改后的倒计时
     */
    @ModifyVariable(
            method = "setCountDown",
            at = @At("HEAD"),
            remap = false,
            argsOnly = true
    )
    private long modifyReloadCountDown(long countDown) {
        try {
            // 如果不在换弹状态，直接返回原始值
            if (!stateType.isReloading()) {
                return countDown;
            }

            // 获取当前玩家
            Player player = tbz$getCurrentPlayer();
            if (player == null) {
                return countDown;
            }

            // 获取玩家主手武器
            ItemStack weapon = player.getMainHandItem();
            if (weapon.isEmpty()) return countDown;

            // 检查是否有不法之徒附魔
            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
            if (level <= 0) return countDown;

            // 检查是否有换弹加速标记
            var tag = weapon.getOrCreateTag();
            boolean hasSpeedTag = tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG);
            if (!hasSpeedTag) return countDown;

            // 从配置获取加速比例
            float speedMultiplier = TBZServerConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
            // 计算加速后的倒计时：原始时间 * (1 - 加速比例)
            float clamped = Math.min(Math.max(speedMultiplier, 0.0f), 0.99f);
            long acceleratedTime = (long) (countDown * (1.0f - clamped));

            return Math.max(acceleratedTime, 1);

        } catch (Exception e) {
            // 发生异常时返回原始值，保证游戏正常运行
            return countDown;
        }
    }

    /**
     * 换弹状态改变事件
     * 当换弹完成或取消时，清除换弹加速标记和上下文，并手动补充子弹（如果是加速换弹）
     *
     * @param stateType 新的换弹状态
     * @param ci 回调信息
     */
    @Inject(method = "setStateType", at = @At("TAIL"), remap = false)
    private void onStateTypeChange(ReloadState.StateType stateType, CallbackInfo ci) {
        // 当换弹完成或取消时，清除标记和上下文
        if (stateType == ReloadState.StateType.NOT_RELOADING) {
            try {
                Player player = tbz$getCurrentPlayer();
                if (player != null) {
                    ItemStack gun = player.getMainHandItem();
                    if (!gun.isEmpty()) {
                        var tag = gun.getOrCreateTag();
                        boolean hadSpeedTag = tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG);
                        
                        // 清除加速标记
                        tag.putBoolean(OutlawEvent.RELOAD_SPEED_TAG, false);
                        
                        // 如果是加速换弹完成，手动补充子弹
                        if (hadSpeedTag) {
                            tbz$manualReloadAmmo(player, gun);
                        }
                    }
                }
            } catch (Exception e) {
                // 忽略异常，保证游戏正常运行
            } finally {
                ReloadContextHolder.clear();
            }
        }
    }
    
    /**
     * 手动从后备中补充子弹到弹匣
     * 用于加速换弹时立即补充子弹，而不等待原始换弹时间结束
     * 
     * @param player 玩家
     * @param gun 枪械物品
     */
    @Unique
    private void tbz$manualReloadAmmo(Player player, ItemStack gun) {
        try {
            IGun iGun = IGun.getIGunOrNull(gun);
            if (iGun == null) return;
            
            // 获取枪械数据
            int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
            int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
            Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(gun);
            
            if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;
            
            int ammoNeeded = magazineSize - currentAmmo;
            
            // 弹匣已满，无需补充
            if (ammoNeeded <= 0) return;
            
            // 检查玩家背包中该弹药的可用数量
            int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId.get());
            if (availableAmmo <= 0) return;
            
            // 计算实际补充的弹药量
            int ammoToTransfer = Math.min(ammoNeeded, availableAmmo);
            
            // 从玩家背包扣除弹药
            ResourceLocation ammoIdValue = ammoId.get();
            AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);
            
            // 装填到枪械
            int newAmmo = currentAmmo + ammoToTransfer;
            iGun.setCurrentAmmoCount(gun, newAmmo);
            
        } catch (Exception e) {
            // 忽略异常，保证游戏正常运行
        }
    }
}