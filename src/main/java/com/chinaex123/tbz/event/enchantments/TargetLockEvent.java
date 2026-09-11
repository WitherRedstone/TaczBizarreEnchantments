package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.EnchantmentStatusSyncPacket;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

import java.util.Optional;
import java.util.UUID;

/**
 * 目标锁定附魔的事件处理类
 * <p>
 * 功能：随着此武器准星在目标上停留的时间增加伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>每次命中目标时增加1层命中计数</li>
 *   <li>命中计数达到"弹匣容量 × 配置比例"时触发伤害加成叠加</li>
 *   <li>每达到一个触发阈值增加1层伤害加成</li>
 *   <li>伤害加成计算：每层加成 = 层数 × 每层加成比例 × 附魔等级</li>
 *   <li>最终伤害 = 原伤害 × (1 + 总加成比例)</li>
 *   <li>以下情况会重置所有加成和锁定状态：
 *     <ol type="a">
 *       <li>切换到不同的目标</li>
 *       <li>超过20刻（1秒）未命中当前目标</li>
 *       <li>进行换弹操作</li>
 *     </ol>
 *   </li>
 *   <li>锁定状态（目标UUID、命中计数、伤害层数、最后命中时间）存储在枪械NBT中</li>
 * </ol>
 */
public class TargetLockEvent {

    /** NBT存储键：当前锁定的目标UUID */
    private static final String TARGET_UUID_TAG = "TargetLockTargetUUID";
    /** NBT存储键：当前弹匣内命中同一目标的次数 */
    private static final String HIT_COUNT_TAG = "TargetLockHitCount";
    /** NBT存储键：伤害加成层数 */
    private static final String DAMAGE_STACK_TAG = "TargetLockDamageStack";
    /** NBT存储键：上次命中的时间（游戏刻） */
    private static final String LAST_HIT_TIME_TAG = "TargetLockLastHitTime";

    /**
     * 枪械伤害事件：目标锁定
     * 追踪命中目标，累积伤害加成层数
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TARGET_LOCK.get());
        if (enchantLevel <= 0) return;

        // 检查目标是否是生物实体
        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        CompoundTag tag = gun.getOrCreateTag();
        long currentTime = player.level().getGameTime();

        // 获取目标信息
        UUID targetUUID = target.getUUID();
        UUID storedTargetUUID = tag.hasUUID(TARGET_UUID_TAG) ? tag.getUUID(TARGET_UUID_TAG) : null;

        // 条件1：检查是否切换了目标
        if (storedTargetUUID == null || !storedTargetUUID.equals(targetUUID)) {
            // 切换到新目标，重置所有状态
            resetLock(tag, player);
            tag.putUUID(TARGET_UUID_TAG, targetUUID);
        }

        // 条件2：检查是否超过超时时间
        long lastHitTime = tag.getLong(LAST_HIT_TIME_TAG);

        long timeoutTicks = (long) (TBZServerConfig.TARGET_LOCK_TIMEOUT_SECONDS.get());
        if (currentTime - lastHitTime > timeoutTicks) {
            // 超时未命中，重置所有状态
            resetLock(tag, player);
            tag.putUUID(TARGET_UUID_TAG, targetUUID);
        }

        // 更新命中次数
        int hitCount = tag.getInt(HIT_COUNT_TAG) + 1;
        tag.putInt(HIT_COUNT_TAG, hitCount);
        tag.putLong(LAST_HIT_TIME_TAG, currentTime);

        // 获取弹匣信息
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        if (magazineSize <= 0) return;

        // 计算触发所需命中次数 = 弹匣容量 × 配置比例（向上取整）
        double requiredPercent = TBZServerConfig.TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT.get();
        int requiredHits = (int) Math.ceil(magazineSize * requiredPercent);
        // 确保至少需要命中1次才能触发
        requiredHits = Math.max(requiredHits, 1);

        // 检查是否达到触发条件
        if (hitCount >= requiredHits) {
            // 计算伤害加成层数：每达到一个"requiredHits"就增加一层
            // 例如：requiredHits=5，hitCount=12 -> (12-5)/5 + 1 = 2层
            int damageStack = (hitCount - requiredHits) / requiredHits + 1;
            // 限制最大层数
            int maxStacks = TBZServerConfig.TARGET_LOCK_MAX_STACKS.get();
            damageStack = Math.min(damageStack, maxStacks);
            tag.putInt(DAMAGE_STACK_TAG, damageStack);

            // 同步目标锁定状态到客户端
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "target_lock", damageStack, currentTime, ItemStack.EMPTY)
                );
            }

            // 应用伤害加成：每层增加固定比例的伤害 × 附魔等级
            // 公式：原伤害 × (1 + 层数 × 每层加成 × 附魔等级)
            double damageBonus = damageStack
                    * TBZServerConfig.TARGET_LOCK_DAMAGE_BONUS_PER_STACK.get()
                    * enchantLevel;

            float currentDamage = event.getBaseAmount();
            float newDamage = currentDamage * (float) (1.0 + damageBonus);
            event.setBaseAmount(newDamage);
        }
    }

    /**
     * 换弹开始事件：目标锁定
     * 换弹时重置锁定状态（失去所有累积的加成）
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TARGET_LOCK.get());
        if (enchantLevel <= 0) return;

        // 换弹时重置所有锁定状态
        resetLock(gun.getOrCreateTag(), player);
    }


    /**
     * 重置锁定状态
     * 清除目标UUID、命中计数、伤害层数和最后命中时间
     *
     * @param tag 枪械的NBT标签
     * @param player 玩家对象，用于发送网络包
     */
    private static void resetLock(CompoundTag tag, Player player) {
        tag.remove(TARGET_UUID_TAG); // 移除目标UUID
        tag.putInt(HIT_COUNT_TAG, 0); // 重置命中计数
        tag.putInt(DAMAGE_STACK_TAG, 0); // 重置伤害层数
        tag.putLong(LAST_HIT_TIME_TAG, 0); // 重置最后命中时间

        // 同步重置状态到客户端
        if (player instanceof ServerPlayer serverPlayer) {
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new EnchantmentStatusSyncPacket(player.getUUID(), "target_lock", 0, 0, ItemStack.EMPTY)
            );
        }
    }
}