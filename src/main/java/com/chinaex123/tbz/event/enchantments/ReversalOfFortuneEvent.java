package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 命运的逆转附魔的事件处理类
 * <p>
 * 功能：射偏2发子弹会在3秒内返还1发子弹到弹匣
 * <p>
 * 机制：
 * <ol>
 *   <li>开枪没有击中任何实体时开始计时3秒（从第一次射偏开始）</li>
 *   <li>在这3秒内如果有第二发子弹没有击中目标，直接返还一发子弹到弹匣</li>
 *   <li>返还后清除计时，进入1.5秒冷却期</li>
 *   <li>若3秒内没有第二发射偏，则计数重置，等待下一次射偏重新计时</li>
 *   <li>冷却期间不触发任何判定（射偏不计数、不计时）</li>
 *   <li>仅当弹匣未满时才返还弹药（防止溢出）</li>
 *   <li>每次射击独立检测，命中事件会重置计时器（非冷却期间）</li>
 * </ol>
 */
public class ReversalOfFortuneEvent {

    /** 累计射偏次数 */
    private static final String MISS_COUNT_TAG = "ReversalOfFortuneMissCount";
    /** 第一次射偏的时间戳（毫秒） */
    private static final String FIRST_MISS_TIME_TAG = "ReversalOfFortuneFirstMissTime";
    /** 上次触发返还的时间戳（毫秒） */
    private static final String LAST_REFUND_TIME_TAG = "ReversalOfFortuneLastRefundTime";
    /** 冷却结束的时间戳（毫秒） */
    private static final String COOLDOWN_UNTIL_TAG = "ReversalOfFortuneCooldownUntil";
    /** 待检测的开火时间戳（毫秒） */
    private static final String PENDING_SHOT_TIME_TAG = "ReversalOfFortunePendingShotTime";

    /** 记录每个玩家最后一次开火时间，用于在命中事件中清除待检测状态 */
    private static final Map<UUID, Long> lastShotTimeMap = new ConcurrentHashMap<>();

    /**
     * 枪械伤害事件：命运的逆转
     * 如果该玩家有待检测的开火记录，说明这发子弹命中了目标，不是射偏。
     * 因此清除待检测状态，避免被误判为射偏。
     *
     * @param event 枪械命中事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        // 只处理玩家开枪命中
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        // 获取玩家手中的枪械
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否持有命运的逆转附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REVERSAL_OF_FORTUNE.get());
        if (enchantLevel <= 0) return;

        // 如果该玩家有待检测的开火记录，说明这发子弹命中了，清除待检测状态
        UUID playerId = player.getUUID();
        if (lastShotTimeMap.containsKey(playerId)) {
            CompoundTag tag = gun.getOrCreateTag();
            lastShotTimeMap.remove(playerId);
            tag.remove(PENDING_SHOT_TIME_TAG);
        }
    }

    /**
     * 玩家每帧更新事件：命运的逆转
     * 开火时如果子弹在3秒内射偏两发，则立马回复一发子弹
     *
     * @param player 玩家对象
     */
    public static void onPlayerTick(Player player) {
        // 获取玩家手中的枪械
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否持有命运的逆转附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REVERSAL_OF_FORTUNE.get());
        if (enchantLevel <= 0) return;

        // 获取枪械接口
        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 数据准备
        CompoundTag tag = gun.getOrCreateTag();
        UUID playerId = player.getUUID();
        long currentTime = System.currentTimeMillis();

        // 获取配置参数
        long missTimeout = (long) (TBZServerConfig.REVERSAL_OF_FORTUNE_MISS_TIMEOUT.get() * 1000);
        long cooldown = (long) (TBZServerConfig.REVERSAL_OF_FORTUNE_COOLDOWN.get() * 1000);
        int requiredMisses = TBZServerConfig.REVERSAL_OF_FORTUNE_REQUIRED_MISSES.get();

        // 获取当前弹匣弹药数，并与上一 tick 对比检测是否开火
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt("ReversalOfFortunePrevAmmo");
        tag.putInt("ReversalOfFortunePrevAmmo", currentAmmo);

        // 冷却期间直接清除所有待检测状态，不进行任何处理
        long cooldownUntil = tag.getLong(COOLDOWN_UNTIL_TAG);
        if (currentTime < cooldownUntil) {
            lastShotTimeMap.remove(playerId);
            tag.remove(PENDING_SHOT_TIME_TAG);
            return;
        }

        // 当弹匣弹药减少时，说明玩家开火了，记录待检测状态
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            lastShotTimeMap.put(playerId, currentTime);
            tag.putLong(PENDING_SHOT_TIME_TAG, currentTime);
        }

        // 如果有待检测的开火记录，且超过0.5秒仍未命中，判定为射偏
        if (tag.contains(PENDING_SHOT_TIME_TAG)) {
            long shotTime = tag.getLong(PENDING_SHOT_TIME_TAG);
            long checkTimeout = 500; // 0.5秒判定阈值

            if (currentTime - shotTime >= checkTimeout) {
                // 清除待检测状态
                tag.remove(PENDING_SHOT_TIME_TAG);
                lastShotTimeMap.remove(playerId);

                int missCount = tag.getInt(MISS_COUNT_TAG) + 1;
                tag.putInt(MISS_COUNT_TAG, missCount);

                // 如果是第一次射偏，记录时间开始计时窗口
                if (missCount == 1) {
                    tag.putLong(FIRST_MISS_TIME_TAG, currentTime);
                }

                // 检查是否达到返还条件（射偏次数 >= 所需次数）
                if (missCount >= requiredMisses) {
                    long firstMissTime = tag.getLong(FIRST_MISS_TIME_TAG);
                    long lastRefundTime = tag.contains(LAST_REFUND_TIME_TAG) ? tag.getLong(LAST_REFUND_TIME_TAG) : 0;

                    // 条件1：第二次射偏必须在第一次射偏后的3秒窗口内
                    boolean withinWindow = (currentTime - firstMissTime <= missTimeout);

                    // 条件2：必须不在冷却中（已在上层检查过，但这里再次确认）
                    boolean notInCooldown = (currentTime - lastRefundTime >= cooldown);

                    if (withinWindow && notInCooldown) {
                        // 触发子弹返还
                        int refundAmount = refundAmmo(player, gun, iGun);

                        // 重置射偏计数（无论返还成功与否都重置）
                        tag.putInt(MISS_COUNT_TAG, 0);
                        tag.remove(FIRST_MISS_TIME_TAG);

                        // 返还成功则记录返还时间和冷却
                        if (refundAmount > 0) {
                            tag.putLong(LAST_REFUND_TIME_TAG, currentTime);
                            tag.putLong(COOLDOWN_UNTIL_TAG, currentTime + cooldown);
                        }
                    } else {
                        // 不满足条件：重置计数，重新开始检测
                        tag.putInt(MISS_COUNT_TAG, 0);
                        tag.remove(FIRST_MISS_TIME_TAG);
                    }
                }
            }
        }

        // 如果第一次射偏后超过3秒没有第二次射偏，重置计数
        if (tag.contains(FIRST_MISS_TIME_TAG)) {
            long firstMissTime = tag.getLong(FIRST_MISS_TIME_TAG);
            if (currentTime - firstMissTime >= missTimeout) {
                tag.putInt(MISS_COUNT_TAG, 0);
                tag.remove(FIRST_MISS_TIME_TAG);
            }
        }
    }

    /**
     * 返还弹药到弹匣
     * <p>
     * 从玩家背包中扣除对应弹药，并填充到枪械弹匣中。
     *
     * @param player 玩家
     * @param gun    枪械物品
     * @param iGun   枪械接口
     * @return 实际返还的子弹数量（0 表示返还失败）
     */
    private static int refundAmmo(Player player, ItemStack gun, IGun iGun) {
        // 获取枪械数据
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        if (gunIndexOpt.isEmpty()) return 0;

        // 获取弹匣容量和当前弹药数
        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);

        // 弹匣已满，无需返还
        if (currentAmmo >= magazineSize) return 0;

        // 获取弹药 ID 和背包可用弹药数
        ResourceLocation ammoId = gunIndexOpt.get().getGunData().getAmmoId();
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);
        if (availableAmmo <= 0) return 0;

        // 计算实际返还数量（取 配置返还量 / 弹匣空位 / 背包可用 的最小值）
        int ammoToRefund = TBZServerConfig.REVERSAL_OF_FORTUNE_REFUND_AMOUNT.get();
        int ammoNeeded = magazineSize - currentAmmo;
        int actualRefund = Math.min(ammoToRefund, ammoNeeded);
        int ammoToTransfer = Math.min(actualRefund, availableAmmo);

        // 从背包扣除弹药，填充到弹匣
        AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToTransfer);
        int newAmmo = currentAmmo + ammoToTransfer;
        iGun.setCurrentAmmoCount(gun, newAmmo);

        return ammoToTransfer;
    }
}