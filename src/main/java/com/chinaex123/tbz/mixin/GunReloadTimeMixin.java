package com.chinaex123.tbz.mixin;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ReloadContextHolder;
import com.tacz.guns.resource.pojo.data.gun.GunReloadTime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * 枪械换弹时间混入类
 * <p>
 * 功能：用于修改枪械的换弹时间。
 * 修改空仓换弹（emptyTime）和战术换弹（tacticalTime）两种时间
 */
@Mixin(value = GunReloadTime.class, remap = false)
public class GunReloadTimeMixin {

    // 空仓换弹时间（子弹打空时的换弹时间）
    @Shadow
    private float emptyTime;

    // 战术换弹时间（子弹未打空时的换弹时间）
    @Shadow
    private float tacticalTime;

    /**
     * 判断是否应该加速换弹
     * 检查玩家是否持有带有亡命之徒附魔且拥有有效加速标记的武器
     *
     * @return true表示应加速换弹，false表示不加速
     */
    @Unique
    private boolean tbz$shouldAccelerate() {
        try {
            Player player = ReloadContextHolder.getPlayer();

            if (player == null) return false;

            // 获取玩家主手武器
            ItemStack weapon = player.getMainHandItem();
            if (weapon.isEmpty()) return false;

            // 检查是否有亡命之徒附魔
            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
            if (level <= 0) return false;

            // 检查是否有换弹加速标记
            var tag = weapon.getOrCreateTag();
            return tag.getBoolean("OutlawReloadSpeed");

        } catch (Exception e) {
            // 发生异常时返回false，保证游戏正常运行
            return false;
        }
    }

    /**
     * 修改空仓换弹时间
     * 在原始方法返回后，如果有加速标记则缩短换弹时间
     *
     * @param cir 回调信息返回对象，包含原始换弹时间
     */
    @Inject(
            method = "getEmptyTime",
            at = @At("RETURN"),
            remap = false,
            cancellable = true
    )
    private void onGetEmptyTime(CallbackInfoReturnable<Float> cir) {
        try {
            // 获取原始空仓换弹时间
            float original = cir.getReturnValue();
            if (original <= 0) return;

            // 判断是否需要加速
            if (tbz$shouldAccelerate()) {
                // 从配置获取加速比例
                float multiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
                // 限制范围避免负值
                float clamped = Math.min(Math.max(multiplier, 0.0f), 0.99f);
                // 计算新的换弹时间：原始时间 * (1 - 加速比例)，最小为0.01秒
                float newTime = Math.max(original * (1.0f - clamped), 0.01f);

                // 设置修改后的换弹时间
                cir.setReturnValue(newTime);
            }
        } catch (Exception e) {
            // 忽略异常，保持原有行为
        }
    }

    /**
     * 修改战术换弹时间
     * 在原始方法返回后，如果有加速标记则缩短换弹时间
     *
     * @param cir 回调信息返回对象，包含原始换弹时间
     */
    @Inject(
            method = "getTacticalTime",
            at = @At("RETURN"),
            remap = false,
            cancellable = true
    )
    private void onGetTacticalTime(CallbackInfoReturnable<Float> cir) {
        try {
            // 获取原始战术换弹时间
            float original = cir.getReturnValue();
            if (original <= 0) return;

            // 判断是否需要加速
            if (tbz$shouldAccelerate()) {
                // 从配置获取加速比例
                float multiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
                // 限制范围避免负值
                float clamped = Math.min(Math.max(multiplier, 0.0f), 0.99f);
                // 计算新的换弹时间：原始时间 * (1 - 加速比例)，最小为0.01秒
                float newTime = Math.max(original * (1.0f - clamped), 0.01f);

                // 设置修改后的换弹时间
                cir.setReturnValue(newTime);
            }
        } catch (Exception e) {
            // 忽略异常，保持原有行为
        }
    }
}