package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ExplosionUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 巨脉蜻蜓附魔的事件处理类
 * <p>
 * 功能：精准最后一击会产生爆炸伤害，该爆炸会根据先前造成的精准命中次数造成额外伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>每次爆头命中时增加爆头计数，并更新最后一次爆头时间</li>
 *   <li>非爆头命中时仅检查时间窗口，不增加计数</li>
 *   <li>爆头计数在60刻（3秒）内无任何爆头命中时自动重置</li>
 *   <li>击杀目标时根据累积的爆头次数计算爆炸伤害加成：
 *     <ol type="a">
 *       <li>每达到配置的阈值次数（默认5次）获得一档伤害加成</li>
 *       <li>每档加成比例为配置值（默认5%），有最大加成上限（默认25%）</li>
 *       <li>最终爆炸伤害 = 基础伤害 × (1 + 伤害加成百分比)</li>
 *     </ol>
 *   </li>
 *   <li>触发爆炸后重置爆头计数和时间记录</li>
 *   <li>若击杀时无爆头记录或在时间窗口外，不触发爆炸效果</li>
 *   <li>玩家Tick中持续检查时间窗口，超时自动重置计数（防止玩家挂机累积）</li>
 * </ol>
 */
public class MeganeuraEvent {

    /** 爆头命中次数 */
    public static final String HEADSHOT_COUNT_TAG = "MeganeuraHeadshotCount";
    /** 最后一次爆头时间 */
    public static final String LAST_HEADSHOT_TIME_TAG = "MeganeuraLastHeadshotTime";
    /** 有效时间窗口 */
    public static final int VALID_KILL_TICKS = 60;

    /**
     * 枪械伤害事件：巨脉蜻蜓
     * 记录爆头命中次数，并检查是否超过有效时间窗口
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MEGANEURA.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        long currentTime = player.level().getGameTime();

        // 仅处理爆头命中
        if (event.isHeadShot()) {
            // 检查是否超过有效时间窗口
            if (tag.contains(LAST_HEADSHOT_TIME_TAG)) {
                long lastHeadshotTime = tag.getLong(LAST_HEADSHOT_TIME_TAG);
                if (currentTime - lastHeadshotTime > VALID_KILL_TICKS) {
                    // 超过有效时间窗口，重置爆头次数
                    tag.putInt(HEADSHOT_COUNT_TAG, 0);
                }
            }

            // 增加爆头命中次数
            int headshotCount = tag.getInt(HEADSHOT_COUNT_TAG);
            tag.putInt(HEADSHOT_COUNT_TAG, headshotCount + 1);
            // 更新最后一次爆头时间
            tag.putLong(LAST_HEADSHOT_TIME_TAG, currentTime);
        } else {
            // 非爆头命中，检查是否超过有效时间窗口
            if (tag.contains(LAST_HEADSHOT_TIME_TAG)) {
                long lastHeadshotTime = tag.getLong(LAST_HEADSHOT_TIME_TAG);
                if (currentTime - lastHeadshotTime > VALID_KILL_TICKS) {
                    // 超过有效时间窗口，重置爆头次数
                    tag.putInt(HEADSHOT_COUNT_TAG, 0);
                    tag.remove(LAST_HEADSHOT_TIME_TAG);
                }
            }
        }
    }

    /**
     * 实体死亡事件：巨脉蜻蜓
     * 验证爆头命中是否导致了击杀，如果有效则根据爆头次数计算伤害加成并触发爆炸效果
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MEGANEURA.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        int headshotCount = tag.getInt(HEADSHOT_COUNT_TAG);

        // 没有爆头命中记录，忽略
        if (headshotCount <= 0) return;

        // 检查是否超过有效时间窗口
        if (tag.contains(LAST_HEADSHOT_TIME_TAG)) {
            long currentTime = player.level().getGameTime();
            long lastHeadshotTime = tag.getLong(LAST_HEADSHOT_TIME_TAG);
            if (currentTime - lastHeadshotTime > VALID_KILL_TICKS) {
                // 超过有效时间窗口，重置爆头次数
                tag.putInt(HEADSHOT_COUNT_TAG, 0);
                tag.remove(LAST_HEADSHOT_TIME_TAG);
                return;
            }
        }

        // 计算伤害加成
        int threshold = TBZConfig.MEGANEURA_HEADSHOT_THRESHOLD.get();
        double bonusPerThreshold = TBZConfig.MEGANEURA_DAMAGE_BONUS_PER_THRESHOLD.get();
        double maxBonus = TBZConfig.MEGANEURA_MAX_DAMAGE_BONUS.get();

        // 计算阈值数量（每5次爆头为一个阈值）
        int thresholdCount = headshotCount / threshold;
        // 计算伤害加成百分比（上限25%）
        double damageBonus = Math.min(thresholdCount * bonusPerThreshold, maxBonus);

        // 计算最终伤害
        float baseDamage = TBZConfig.MEGANEURA_BASE_DAMAGE.get().floatValue();
        float finalDamage = baseDamage * (1.0f + (float) damageBonus);

        // 获取溅射伤害范围和数值
        float splashMin = TBZConfig.MEGANEURA_SPLASH_MIN.get().floatValue();
        float splashMax = TBZConfig.MEGANEURA_SPLASH_MAX.get().floatValue();
        double range = TBZConfig.MEGANEURA_RANGE.get();

        // 触发爆炸效果
        ExplosionUtils.dealSmallExplosionDamage(target, finalDamage, splashMin, splashMax, range);

        // 重置爆头命中次数
        tag.putInt(HEADSHOT_COUNT_TAG, 0);
        tag.remove(LAST_HEADSHOT_TIME_TAG);
    }

    /**
     * 玩家每帧更新事件：巨脉蜻蜓
     * 检查是否超过有效时间窗口，如果超过则重置爆头次数
     *
     * @param player 玩家
     * @param gun 玩家主手物品
     */
    public static void onPlayerTick(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MEGANEURA.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();

        // 没有爆头命中记录，忽略
        if (!tag.contains(LAST_HEADSHOT_TIME_TAG)) return;

        long currentTime = player.level().getGameTime();
        long lastHeadshotTime = tag.getLong(LAST_HEADSHOT_TIME_TAG);

        // 检查是否超过有效时间窗口
        if (currentTime - lastHeadshotTime > VALID_KILL_TICKS) {
            // 超过有效时间窗口，重置爆头次数
            tag.putInt(HEADSHOT_COUNT_TAG, 0);
            tag.remove(LAST_HEADSHOT_TIME_TAG);
        }
    }
}