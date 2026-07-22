package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

/**
 * 辉耀炽热附魔的事件处理类
 * <p>
 * 功能：击败目标会让附近生物获得灼烧效果
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀目标时触发效果检测</li>
 *   <li>以被击杀目标为中心，在配置范围内搜索所有生物实体</li>
 *   <li>排除被击杀目标和击杀者本人</li>
 *   <li>对范围内的每个生物判断是否已有灼烧效果：
 *     <ol type="a">
 *       <li>已有灼烧效果 → 延长效果持续时间（不超过最大持续时间上限）</li>
 *       <li>无灼烧效果 → 施加新的灼烧效果（持续时间和等级从配置读取）</li>
 *     </ol>
 *   </li>
 *   <li>延长效果时使用配置的固定效果等级（不改变原有效果等级）</li>
 *   <li>范围检测使用立方体区域（AABB），而非球形范围</li>
 * </ol>
 */
public class IncandescentEvent {

    /**
     * 实体死亡事件：辉耀炽热
     * 在击杀目标位置附近产生范围效果，对周围生物施加灼烧效果
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.INCANDESCENT.get());
        if (enchantLevel <= 0) return;

        // 获取效果范围
        double range = TBZConfig.INCANDESCENT_RANGE.get();

        // 创建一个以目标为中心的立方体碰撞箱（AABB）
        AABB aabb = new AABB(
                target.getX() - range,
                target.getY() - range,
                target.getZ() - range,
                target.getX() + range,
                target.getY() + range,
                target.getZ() + range
        );

        // 获取范围内所有生物实体
        for (LivingEntity nearbyEntity : player.level().getEntitiesOfClass(LivingEntity.class, aabb)) {
            // 排除被击杀的目标本身
            if (nearbyEntity == target) continue;
            // 排除击杀者本人（避免自伤）
            if (nearbyEntity == player) continue;

            // 检查该生物是否已有"灼烧"效果
            MobEffectInstance currentEffect = nearbyEntity.getEffect(FELEffects.SCORCH.get());

            if (currentEffect != null) {
                // 情况1：已有灼烧效果 -> 延长持续时间
                int extendDuration = TBZConfig.INCANDESCENT_EXTEND_DURATION.get();   // 每次延长的刻数
                int maxDuration = TBZConfig.INCANDESCENT_MAX_DURATION.get(); // 最大持续时间（刻）
                int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

                // 获取效果等级
                int scorchAmplifier = TBZConfig.INCANDESCENT_SCORCH_AMPLIFIER.get();

                // 施加新的灼烧效果
                nearbyEntity.addEffect(new MobEffectInstance(
                        FELEffects.SCORCH.get(), newDuration, scorchAmplifier, false, true
                ));
            } else {
                // 情况2：没有灼烧效果 -> 给予新效果
                // 获取灼烧效果的持续时间和等级
                int scorchDuration = TBZConfig.INCANDESCENT_SCORCH_DURATION.get();
                int scorchAmplifier = TBZConfig.INCANDESCENT_SCORCH_AMPLIFIER.get();

                // 创建新的灼烧效果
                MobEffectInstance scorchEffect = new MobEffectInstance(
                        FELEffects.SCORCH.get(), scorchDuration, scorchAmplifier, false, true
                );

                // 施加效果
                nearbyEntity.addEffect(scorchEffect);
            }
        }
    }
}