package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.api.IShootIntervalAdjuster;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.FireRateSyncPacket;
import com.chinaex123.tbz.network.PacketHandler;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.entity.shooter.ShooterDataHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

/**
 * 柔缓附魔的事件处理类
 * <p>
 * 功能：在击败目标后，此武器的射速减慢，但是会在短时间内造成额外伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>击杀敌人后激活柔缓状态，持续一段时间
 *   <li>激活期间增加伤害，降低射速
 *   <li>伤害加成和射速降低程度随附魔等级提升
 *   <li>状态信息存储在物品NBT中，通过网络同步
 * </ol>
 */
public class AdagioEvent {

    /** 柔缓状态是否激活 */
    public static final String ADAGIO_ACTIVE = "adagio_active";
    /** 柔缓状态开始时间 */
    public static final String ADAGIO_START_TIME = "adagio_start_time";
    /** 击杀计数 */
    public static final String ADAGIO_KILL_COUNT = "adagio_kill_count";
    /** 附魔等级 */
    public static final String ADAGIO_LEVEL = "adagio_level";
    /** 状态持续时间 */
    public static final String ADAGIO_DURATION = "adagio_duration";
    /** 射速降低百分比 */
    public static final String ADAGIO_SLOW_PERCENT = "adagio_slow_percent";

    /**
     * 枪械伤害事件：柔缓
     * 检查是否激活柔缓状态，如果是则增加伤害
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) {
            return;
        }

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) {
            return;
        }

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
        if (enchantLevel <= 0) {
            return;
        }

        // 如果柔缓状态激活，增加伤害
        if (isAdagioActive(gun)) {
            float bonusDamage = TBZServerConfig.ADAGIO_BONUS_DAMAGE.get().floatValue() * enchantLevel;
            float originalDamage = event.getBaseAmount();
            float newDamage = originalDamage * (1.0f + bonusDamage);
            event.setBaseAmount(newDamage);
        }
    }

    /**
     * 实体死亡事件：柔缓
     * 触发柔缓状态的激活或刷新
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

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
        if (enchantLevel <= 0) {
            return;
        }

        // 应用射速减缓效果
        IShootIntervalAdjuster adjuster = getShootAdjuster(player);
        if (adjuster != null) {
            adjuster.tbz$RestoreFireRate(); // 重置之前的柔缓状态
            
            // 使用通用方法应用射速修改
            float slowPercent = TBZServerConfig.ADAGIO_FIRE_RATE_SLOWDOWN.get().floatValue();
            adjuster.tbz$ApplyFireRateModifier(player, enchantLevel, gun, slowPercent, TBZServerConfig.ADAGIO_DURATION.get());

            // 通过网络同步射速调整数据
            long additionalInterval = adjuster.tbz$GetAdditionalInterval();
            long endTime = System.currentTimeMillis() + (long)(TBZServerConfig.ADAGIO_DURATION.get() * 1000L);

            PacketHandler.INSTANCE.send(
                    PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player),
                    new FireRateSyncPacket(player.getUUID(), additionalInterval, endTime)
            );
        }

        // 更新枪械NBT数据，记录柔缓状态
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(ADAGIO_ACTIVE, true);
        tag.putLong(ADAGIO_START_TIME, System.currentTimeMillis());
        tag.putInt(ADAGIO_LEVEL, enchantLevel);
        tag.putLong(ADAGIO_DURATION, (long)(TBZServerConfig.ADAGIO_DURATION.get() * 1000L));
        tag.putFloat(ADAGIO_SLOW_PERCENT, TBZServerConfig.ADAGIO_FIRE_RATE_SLOWDOWN.get().floatValue() * enchantLevel);

        // 增加击杀计数
        int killCount = tag.getInt(ADAGIO_KILL_COUNT) + 1;
        tag.putInt(ADAGIO_KILL_COUNT, killCount);
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
     * 玩家每帧更新事件：柔缓
     * 管理柔缓状态的持续和清理
     *
     * @param player 玩家对象
     */
    public static void onPlayerTick(Player player) {
        if (player == null) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
        if (enchantLevel <= 0) {
            // 如果物品没有附魔但仍有柔缓数据，清理数据
            if (gun.getTag() != null && gun.getTag().getBoolean(ADAGIO_ACTIVE)) {
                clearAdagioData(gun);
            }
            return;
        }

        // 如果柔缓状态未激活，重置射击调整器状态
        if (!isAdagioActive(gun)) {
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
            deactivateAdagio(gun);
            return;
        }

        // 柔缓状态激活中，更新状态
        IShootIntervalAdjuster adjuster = getShootAdjuster(player);
        if (adjuster != null) {
            adjuster.tbz$UpdateFireRateState();
        }
    }

    /**
     * 检查柔缓状态是否激活且未超时
     *
     * @param gun 枪械物品
     * @return 柔缓状态是否激活
     */
    public static boolean isAdagioActive(ItemStack gun) {
        if (gun.isEmpty()) {
            return false;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return false;
        }

        if (!tag.getBoolean(ADAGIO_ACTIVE)) {
            return false;
        }

        long startTime = tag.getLong(ADAGIO_START_TIME);
        long currentTime = System.currentTimeMillis();
        long duration = tag.getLong(ADAGIO_DURATION);

        if (duration <= 0) {
            duration = (long)(TBZServerConfig.ADAGIO_DURATION.get() * 1000L);
        }

        // 检查是否在有效时间内
        return currentTime - startTime < duration;
    }

    /**
     * 停用柔缓状态（不清理数据，仅标记为未激活）
     *
     * @param gun 枪械物品
     */
    public static void deactivateAdagio(ItemStack gun) {
        if (gun.isEmpty()) {
            return;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return;
        }

        tag.putBoolean(ADAGIO_ACTIVE, false);
    }

    /**
     * 清除所有柔缓相关的NBT数据
     *
     * @param gun 枪械物品
     */
    public static void clearAdagioData(ItemStack gun) {
        if (gun.isEmpty()) {
            return;
        }

        CompoundTag tag = gun.getTag();
        if (tag == null) {
            return;
        }

        tag.remove(ADAGIO_ACTIVE);
        tag.remove(ADAGIO_START_TIME);
        tag.remove(ADAGIO_LEVEL);
        tag.remove(ADAGIO_DURATION);
        tag.remove(ADAGIO_SLOW_PERCENT);
        tag.remove(ADAGIO_KILL_COUNT);
    }
}