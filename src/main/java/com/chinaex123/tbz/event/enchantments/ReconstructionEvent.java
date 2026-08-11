package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 重建附魔的事件处理类
 * <p>
 * 功能：此武器会缓慢填装子弹，直至两倍弹匣容量
 * <p>
 * 机制：
 * <ol>
 *   <li>射击时记录最后一次射击时间</li>
 *   <li>玩家Tick中检查是否满足自动装填条件：
 *     <ol type="a">
 *       <li>距离上次射击已超过冷却时间（从配置读取）</li>
 *       <li>距离上次自动装填已超过间隔时间（从配置读取）</li>
 *       <li>当前弹药未达到最大上限（弹匣容量 × 2倍）</li>
 *       <li>背包中有可用弹药</li>
 *     </ol>
 *   </li>
 *   <li>满足条件时执行自动装填：
 *     <ol type="a">
 *       <li>计算本次转移弹药量 = min(所需弹药, 每次装填量, 背包可用量)</li>
 *       <li>从背包扣除弹药并装填到枪械</li>
 *       <li>记录本次自动装填时间</li>
 *     </ol>
 *   </li>
 *   <li>最大弹药上限为弹匣容量的2倍（可超出标准弹匣容量）</li>
 *   <li>每次自动装填的弹药量从配置读取</li>
 *   <li>射击后冷却期间不会触发自动装填</li>
 * </ol>
 */
public class ReconstructionEvent {

    /** NBT存储键：上次自动装填时间 */
    private static final String LAST_RELOAD_TIME_TAG = "ReconstructionLastReloadTime";
    /** NBT存储键：上次射击时间 */
    private static final String LAST_SHOOT_TIME_TAG = "ReconstructionLastShootTime";
    /** 最大弹匣容量倍数 */
    private static final int MAX_MAGAZINE_MULTIPLIER = 2;

    /**
     * 枪械伤害事件：重建
     * 记录最后一次射击的时间，用于判断是否处于射击冷却状态
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.RECONSTRUCTION.get());
        if (enchantLevel <= 0) return;

        // 记录本次射击时间（游戏刻）
        CompoundTag tag = gun.getOrCreateTag();
        tag.putLong(LAST_SHOOT_TIME_TAG, player.level().getGameTime());
    }

    /**
     * 玩家Tick事件：重建
     * 检查条件并自动从背包补充弹药到枪械
     *
     * @param player 玩家实体
     */
    public static void onPlayerTick(Player player) {
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = mainHand.getEnchantmentLevel(TBZEnchantments.RECONSTRUCTION.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(mainHand);
        if (iGun == null) return;

        long currentTime = player.level().getGameTime();

        CompoundTag tag = mainHand.getOrCreateTag();
        long lastShootTime = tag.getLong(LAST_SHOOT_TIME_TAG);
        long lastReloadTime = tag.getLong(LAST_RELOAD_TIME_TAG);

        // 从配置获取冷却时间参数
        int shootCooldown = TBZServerConfig.RECONSTRUCTION_SHOOT_COOLDOWN.get();
        int reloadInterval = TBZServerConfig.RECONSTRUCTION_RELOAD_INTERVAL.get();

        // 条件1：射击冷却期间不进行自动装填
        if (currentTime - lastShootTime < shootCooldown) {
            return;
        }

        // 条件2：两次自动装填之间需要间隔
        if (currentTime - lastReloadTime < reloadInterval) {
            return;
        }

        // 获取枪械数据
        int magazineSize = GunEnchantmentHelper.getMagazineSize(mainHand);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(mainHand);
        Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(mainHand);
        if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;

        int maxAmmo = magazineSize * MAX_MAGAZINE_MULTIPLIER;

        // 条件3：已达到最大弹药上限，无需补充
        if (currentAmmo >= maxAmmo) return;

        // 检查玩家背包中该弹药的可用数量
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId.get());
        if (availableAmmo <= 0) return;

        // 每次自动装填的弹药数量
        int ammoPerReload = TBZServerConfig.RECONSTRUCTION_AMMO_PER_RELOAD.get();

        // 计算需要补充的弹药量
        int ammoNeeded = maxAmmo - currentAmmo;

        // 实际转移弹药量 = 取最小值(需要量, 每次装填量, 背包可用量)
        int ammoToTransfer = Math.min(ammoNeeded, Math.min(ammoPerReload, availableAmmo));

        // 从玩家背包扣除弹药
        ResourceLocation ammoIdValue = ammoId.get();
        AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);

        // 装填到枪械
        int newAmmo = currentAmmo + ammoToTransfer;
        iGun.setCurrentAmmoCount(mainHand, newAmmo);

        // 记录本次自动装填时间，用于下次间隔判断
        tag.putLong(LAST_RELOAD_TIME_TAG, currentTime);
    }
}