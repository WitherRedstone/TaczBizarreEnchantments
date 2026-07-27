package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 回转弹药附魔的事件处理类
 * <p>
 * 功能：射空此武器的弹匣时，会根据命中次数从储存弹药中填装
 * <p>
 * 机制：
 * <ol>
 *   <li>换弹时重置所有计数，记录当前弹匣容量</li>
 *   <li>射击时累计射击次数（每次减少的弹药量累加）</li>
 *   <li>命中时累计命中次数（每次命中+1）</li>
 *   <li>弹匣打空时（弹药从1变为0）触发恢复判定：
 *     <ol type="a">
 *       <li>检查射击次数是否达到最低要求（弹匣容量 × 最小射击比例）</li>
 *       <li>未达到最低射击次数 → 不恢复弹药，等待下次换弹重置</li>
 *       <li>达到最低射击次数 → 计算恢复弹药量 = 命中次数 × 恢复比例（四舍五入）</li>
 *     </ol>
 *   </li>
 *   <li>从背包扣除对应弹药并装填到枪械</li>
 *   <li>恢复后重置所有计数，以本次恢复的弹药量作为新的弹匣容量</li>
 *   <li>恢复弹药量受背包可用弹药限制</li>
 *   <li>不满足条件时不恢复弹药，计数在下次换弹时重置</li>
 * </ol>
 */
public class RewindRoundsEvent {

    /** 当前弹匣累计命中次数 */
    private static final String HIT_COUNT_TAG = "RewindRoundsHitCount";
    /** 弹匣容量 */
    private static final String MAGAZINE_SIZE_TAG = "RewindRoundsMagazineSize";
    /** 当前弹匣累计射击次数 */
    private static final String SHOTS_FIRED_TAG = "RewindRoundsShotsFired";
    /** 上一tick的弹药数 */
    private static final String PREV_AMMO_TAG = "RewindRoundsPrevAmmo";

    /**
     * 换弹开始事件：回转弹药
     * 重置所有计数，记录新的弹匣容量
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否拥有回转弹药附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REWIND_ROUNDS.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();

        // 获取当前弹匣弹药数并保存为弹匣容量
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        tag.putInt(MAGAZINE_SIZE_TAG, currentAmmo);
        tag.putInt(HIT_COUNT_TAG, 0); // 重置命中计数
        tag.putInt(SHOTS_FIRED_TAG, 0); // 重置射击计数
    }

    /**
     * 枪械伤害事件：回转弹药
     * 增加当前弹匣的命中计数
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REWIND_ROUNDS.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();

        // 命中次数+1
        int hitCount = tag.getInt(HIT_COUNT_TAG) + 1;
        tag.putInt(HIT_COUNT_TAG, hitCount);
    }

    /**
     * 玩家每帧更新事件：回转弹药
     * 检测射击行为并累计射击次数，当弹药从1变为0时，判断是否满足恢复条件并执行弹药恢复
     */
    public static void onPlayerTick(Player player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REWIND_ROUNDS.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt(PREV_AMMO_TAG);
        tag.putInt(PREV_AMMO_TAG, currentAmmo);

        // 检测射击：弹药减少时累计射击次数
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            int shotsFired = tag.getInt(SHOTS_FIRED_TAG) + (prevAmmo - currentAmmo);
            tag.putInt(SHOTS_FIRED_TAG, shotsFired);

            // 首次射击时自动设置弹匣容量（用于兜底）
            if (tag.getInt(MAGAZINE_SIZE_TAG) == 0) {
                tag.putInt(MAGAZINE_SIZE_TAG, prevAmmo);
            }
        }

        // 弹匣打空时触发弹药恢复判定（弹药从1变为0）
        if (prevAmmo == 1 && currentAmmo == 0) {
            int magazineSize = tag.getInt(MAGAZINE_SIZE_TAG);
            if (magazineSize == 0) return;  // 无效弹匣容量，跳过

            int shotsFired = tag.getInt(SHOTS_FIRED_TAG);
            // 从配置获取最小射击比例，计算恢复弹药所需的最低射击次数
            double minFirePercentage = TBZServerConfig.REWIND_ROUNDS_MIN_FIRE_PERCENTAGE.get();
            int minShotsRequired = (int) Math.ceil(magazineSize * minFirePercentage);

            // 判断射击次数是否达到最低要求
            if (shotsFired >= minShotsRequired) {
                int hitCount = tag.getInt(HIT_COUNT_TAG);
                // 根据配置的恢复比例，计算应恢复的弹药数 = 命中次数 × 恢复比例
                double restorePercentage = TBZServerConfig.REWIND_ROUNDS_RESTORE_PERCENTAGE.get();
                int ammoToRestore = (int) Math.round(hitCount * restorePercentage);

                // 获取枪械使用的弹药类型
                Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
                if (gunIndexOpt.isEmpty()) return;

                ResourceLocation ammoId = gunIndexOpt.get().getGunData().getAmmoId();
                // 检查玩家背包中该弹药的可用数量
                int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);

                if (availableAmmo > 0) {
                    // 获取枪械的弹匣容量上限
                    int maxMagazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
                    // 实际恢复数不能超过：背包可用弹药、弹匣容量上限
                    ammoToRestore = Math.min(ammoToRestore, availableAmmo);
                    ammoToRestore = Math.min(ammoToRestore, maxMagazineSize);
                    // 从背包扣除弹药
                    AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToRestore);
                    // 装填到枪械
                    iGun.setCurrentAmmoCount(gun, ammoToRestore);

                    // 重置所有计数，并将本次恢复的弹药数作为新的弹匣容量
                    tag.putInt(MAGAZINE_SIZE_TAG, ammoToRestore);
                    tag.putInt(HIT_COUNT_TAG, 0);
                    tag.putInt(SHOTS_FIRED_TAG, 0);
                }
            }
            // 不满足射击次数要求时，不恢复弹药，计数会在下次换弹时重置
        }
    }
}