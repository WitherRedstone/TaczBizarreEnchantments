package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 风暴涌动附魔的事件处理类
 * <p>
 * 功能：最后一击会提供增幅效果
 * 机制：
 * 1. 玩家击杀敌人时触发效果检测
 * 2. 判断玩家当前是否已有增幅效果：
 *    a. 已有增幅效果 → 延长效果持续时间（不超过最大持续时间上限）
 *    b. 无增幅效果 → 检查冷却时间是否结束
 * 3. 冷却时间内击杀不会施加新效果（防止频繁触发）
 * 4. 施加新效果时持续时间和等级从配置读取
 * 5. 延长效果时保持原有效果等级不变，仅增加持续时间
 * 6. 触发后更新最后击杀时间（用于冷却判断）
 * 7. 通过连续击杀维持增幅效果，击杀间隔过长则效果自然消失后需要重新冷却
 */
public class RollingStormEvent {

    // NBT标签：记录上次触发增幅效果的击杀时间（游戏刻）
    private static final String LAST_KILL_TIME_TAG = "RollingStormLastKillTime";

    /**
     * 击杀事件处理
     * 根据当前是否已有增幅效果，决定是延长效果还是重新施加效果
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ROLLING_STORM.get());
        if (enchantLevel <= 0) return;

        long currentTime = player.level().getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastKillTime = tag.getLong(LAST_KILL_TIME_TAG);

        // 检查玩家当前是否已拥有增幅效果
        MobEffectInstance currentEffect = player.getEffect(FELEffects.AMPLIFIED.get());

        if (currentEffect != null) {
            // 情况1：已有增幅效果 -> 延长持续时间
            // 从配置获取延长时间和最大持续时间
            int extendDuration = TBZConfig.ROLLING_STORM_EXTEND_DURATION.get(); // 每次击杀延长的刻数
            int maxDuration = TBZConfig.ROLLING_STORM_MAX_DURATION.get(); // 最大持续时间（刻）
            // 计算新持续时间：不超过最大限制
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

            // 获取增幅效果等级
            int amplifiedAmplifier = TBZConfig.ROLLING_STORM_AMPLIFIED_AMPLIFIER.get();

            // 施加新的增幅效果
            player.addEffect(new MobEffectInstance(FELEffects.AMPLIFIED.get(), newDuration, amplifiedAmplifier, false, true));

            // 更新最后击杀时间
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        } else {
            // 情况2：没有增幅效果 -> 检查冷却，尝试施加新效果
            int cooldownTicks = TBZConfig.ROLLING_STORM_COOLDOWN_TICKS.get();        // 冷却时间（刻）

            // 如果在冷却时间内，不触发效果（防止过快连续触发）
            if (currentTime - lastKillTime < cooldownTicks) {
                return;
            }

            // 获取增幅效果的持续时间和等级
            int amplifiedDuration = TBZConfig.ROLLING_STORM_AMPLIFIED_DURATION.get(); // 持续时间（刻）
            int amplifiedAmplifier = TBZConfig.ROLLING_STORM_AMPLIFIED_AMPLIFIER.get(); // 放大器等级

            // 创建新的增幅效果
            MobEffectInstance amplified = new MobEffectInstance(FELEffects.AMPLIFIED.get(),
                    amplifiedDuration, amplifiedAmplifier, false, true);

            // 施加效果
            player.addEffect(amplified);

            // 记录本次击杀时间（用于冷却判断）
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        }
    }
}