package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

/**
 * 失衡弹药附魔的事件处理类
 * <p>
 * 功能：击败目标会让附近生物获得不稳定效果
 * 机制：
 * 1. 玩家击杀目标时触发效果检测
 * 2. 以被击杀目标为中心，在配置范围内搜索所有生物实体
 * 3. 排除被击杀目标和击杀者本人
 * 4. 对范围内的每个生物判断是否已有不稳定效果：
 *    a. 已有不稳定效果 → 延长效果持续时间（不超过最大持续时间上限）
 *    b. 无不稳定效果 → 施加新的不稳定效果（持续时间和等级从配置读取）
 * 5. 延长效果时使用配置的固定效果等级（不改变原有效果等级）
 * 6. 范围检测使用立方体区域（AABB），而非球形范围
 */
public class DestabilizingRoundsEvent {

    /**
     * 击杀事件处理
     * 在击杀目标位置附近产生范围效果，对周围生物施加不稳定效果
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.DESTABILIZING_ROUNDS.get());
        if (enchantLevel <= 0) return;

        // 获取效果范围
        double range = TBZConfig.DESTABILIZING_ROUNDS_RANGE.get();

        // 创建一个以目标为中心的立方体碰撞箱
        AABB aabb = new AABB(
                target.getX() - range, // 最小X
                target.getY() - range, // 最小Y
                target.getZ() - range, // 最小Z
                target.getX() + range, // 最大X
                target.getY() + range, // 最大Y
                target.getZ() + range // 最大Z
        );

        // 获取范围内所有生物实体
        for (LivingEntity nearbyEntity : player.level().getEntitiesOfClass(LivingEntity.class, aabb)) {
            // 排除被击杀的目标本身
            if (nearbyEntity == target) continue;
            // 排除击杀者本人
            if (nearbyEntity == player) continue;

            // 检查该生物是否已有"不稳定"效果
            MobEffectInstance currentEffect = nearbyEntity.getEffect(FELEffects.VOLATILE.get());

            if (currentEffect != null) {
                // 情况1：已有不稳定效果 -> 延长持续时间
                int extendDuration = TBZConfig.DESTABILIZING_ROUNDS_EXTEND_DURATION.get(); // 每次延长的刻数
                int maxDuration = TBZConfig.DESTABILIZING_ROUNDS_MAX_DURATION.get(); // 最大持续时间
                int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

                // 获取效果等级
                int volatileAmplifier = TBZConfig.DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER.get();

                // 施加新的不稳定效果
                nearbyEntity.addEffect(new MobEffectInstance(
                        FELEffects.VOLATILE.get(), newDuration, volatileAmplifier, false, true
                ));
            } else {
                // 情况2：没有不稳定效果 -> 给予新效果
                // 获取不稳定效果的持续时间和等级
                int volatileDuration = TBZConfig.DESTABILIZING_ROUNDS_VOLATILE_DURATION.get();
                int volatileAmplifier = TBZConfig.DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER.get();

                // 创建新的不稳定效果
                MobEffectInstance volatileEffect = new MobEffectInstance(
                        FELEffects.VOLATILE.get(), volatileDuration, volatileAmplifier, false, true
                );

                // 施加效果
                nearbyEntity.addEffect(volatileEffect);
            }
        }
    }
}