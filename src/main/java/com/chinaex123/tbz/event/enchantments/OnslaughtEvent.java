package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.api.IShootIntervalAdjuster;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.FireRateSyncPacket;
import com.chinaex123.tbz.network.PacketHandler;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.entity.shooter.ShooterDataHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

/**
 * 猛攻附魔的事件处理类
 * <p>
 * 功能：击杀敌人后进入猛攻状态，提升射速
 * <p>
 * 机制：
 * <ol>
 *   <li>击杀敌人后激活猛攻状态，持续一段时间</li>
 *   <li>激活期间提升射速（每级25%）</li>
 *   <li>射速提升程度随附魔等级提升</li>
 *   <li>状态信息存储在物品NBT中，通过网络同步</li>
 * </ol>
 */
public class OnslaughtEvent {

    /** 猛攻状态是否激活 */
    public static final String ONSLAUGHT_ACTIVE = "onslaught_active";
    /** 猛攻状态开始时间 */
    public static final String ONSLAUGHT_START_TIME = "onslaught_start_time";
    /** 击杀计数 */
    public static final String ONSLAUGHT_KILL_COUNT = "onslaught_kill_count";
    /** 附魔等级 */
    public static final String ONSLAUGHT_LEVEL = "onslaught_level";
    /** 状态持续时间 */
    public static final String ONSLAUGHT_DURATION = "onslaught_duration";
    /** 射速提升百分比 */
    public static final String ONSLAUGHT_BOOST_PERCENT = "onslaught_boost_percent";

    /**
     * 实体死亡事件：猛攻
     * 触发猛攻状态的激活或刷新
     *
     * @param player 击杀者玩家
     * @param gun 使用的枪械物品
     * @param victim 被击杀者
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity victim) {
        // 确认目标已死亡
        if (!victim.isDeadOrDying()) {
            return;
        }

        // 检查是否有猛攻附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ONSLAUGHT.get());
        if (enchantLevel <= 0) {
            return;
        }

        // 应用射速提升效果
        IShootIntervalAdjuster adjuster = getShootAdjuster(player);
        if (adjuster != null) {
            // 先恢复之前的射速修改，再应用新的
            adjuster.tbz$RestoreFireRate();

            // 从配置获取射速提升百分比（负值表示加速）
            float boostPercent = TBZServerConfig.ONSLAUGHT_FIRE_RATE_BOOST.get().floatValue();
            // 应用射速修改器：传入选中的玩家、附魔等级、武器、提升百分比和持续时间
            adjuster.tbz$ApplyFireRateModifier(player, enchantLevel, gun, -boostPercent, TBZServerConfig.ONSLAUGHT_DURATION.get());

            // 获取调整后的额外间隔和结束时间
            long additionalInterval = adjuster.tbz$GetAdditionalInterval();
            long endTime = System.currentTimeMillis() + TBZServerConfig.ONSLAUGHT_DURATION.get();

            // 通过网络同步射速数据到客户端
            PacketHandler.INSTANCE.send(
                    PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player),
                    new FireRateSyncPacket(player.getUUID(), additionalInterval, endTime)
            );
        }

        // 更新枪械NBT数据，记录猛攻状态
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(ONSLAUGHT_ACTIVE, true);
        tag.putLong(ONSLAUGHT_START_TIME, System.currentTimeMillis());
        tag.putInt(ONSLAUGHT_LEVEL, enchantLevel);
        tag.putLong(ONSLAUGHT_DURATION, TBZServerConfig.ONSLAUGHT_DURATION.get());
        tag.putFloat(ONSLAUGHT_BOOST_PERCENT, TBZServerConfig.ONSLAUGHT_FIRE_RATE_BOOST.get().floatValue() * enchantLevel);

        // 增加击杀计数
        int killCount = tag.getInt(ONSLAUGHT_KILL_COUNT) + 1;
        tag.putInt(ONSLAUGHT_KILL_COUNT, killCount);
    }

    /**
     * 获取玩家的射击调整器实例
     *
     * @param player 玩家对象
     * @return 射击调整器实例，失败时返回null
     */
    private static IShootIntervalAdjuster getShootAdjuster(Player player) {
        try {
            IGunOperator gunOperator = IGunOperator.fromLivingEntity(player);
            ShooterDataHolder dataHolder = gunOperator.getDataHolder();

            if (dataHolder == null) {
                return null;
            }

            return (IShootIntervalAdjuster) dataHolder;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 玩家Tick事件：猛攻
     * 管理猛攻状态的持续和清理
     *
     * @param player 玩家对象
     */
    public static void onPlayerTick(Player player) {
        if (player == null) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ONSLAUGHT.get());
        if (enchantLevel <= 0) {
            // 如果物品没有附魔但仍有猛攻数据，清理数据
            if (gun.getTag() != null && gun.getTag().getBoolean(ONSLAUGHT_ACTIVE)) {
                clearOnslaughtData(gun);
            }
            return;
        }

        // 如果猛攻状态未激活，重置射击调整器状态
        if (!isOnslaughtActive(gun)) {
            IShootIntervalAdjuster adjuster = getShootAdjuster(player);
            if (adjuster != null) {
                adjuster.tbz$RestoreFireRate();
                // 通知客户端恢复射速
                if (player instanceof ServerPlayer serverPlayer) {
                    PacketHandler.INSTANCE.send(
                            PacketDistributor.PLAYER.with(() -> serverPlayer),
                            new FireRateSyncPacket(player.getUUID(), 0, 0)
                    );
                }
            }
            deactivateOnslaught(gun);
            return;
        }

        // 猛攻状态激活中，更新状态
        IShootIntervalAdjuster adjuster = getShootAdjuster(player);
        if (adjuster != null) {
            adjuster.tbz$UpdateFireRateState();
        }
    }

    /**
     * 检查猛攻状态是否激活且未超时
     *
     * @param gun 枪械物品
     * @return 猛攻状态是否激活
     */
    public static boolean isOnslaughtActive(ItemStack gun) {
        if (gun.isEmpty()) {
            return false;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return false;
        }

        if (!tag.getBoolean(ONSLAUGHT_ACTIVE)) {
            return false;
        }

        long startTime = tag.getLong(ONSLAUGHT_START_TIME);
        long currentTime = System.currentTimeMillis();
        long duration = tag.getLong(ONSLAUGHT_DURATION);

        if (duration <= 0) {
            duration = TBZServerConfig.ONSLAUGHT_DURATION.get();
        }

        // 检查是否在有效时间内
        return currentTime - startTime < duration;
    }

    /**
     * 停用猛攻状态（不清理数据，仅标记为未激活）
     *
     * @param gun 枪械物品
     */
    public static void deactivateOnslaught(ItemStack gun) {
        if (gun.isEmpty()) {
            return;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return;
        }

        tag.putBoolean(ONSLAUGHT_ACTIVE, false);
    }

    /**
     * 清除所有猛攻相关的NBT数据
     *
     * @param gun 枪械物品
     */
    public static void clearOnslaughtData(ItemStack gun) {
        if (gun.isEmpty()) {
            return;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return;
        }

        tag.remove(ONSLAUGHT_ACTIVE);
        tag.remove(ONSLAUGHT_START_TIME);
        tag.remove(ONSLAUGHT_LEVEL);
        tag.remove(ONSLAUGHT_DURATION);
        tag.remove(ONSLAUGHT_BOOST_PERCENT);
        tag.remove(ONSLAUGHT_KILL_COUNT);
    }
}