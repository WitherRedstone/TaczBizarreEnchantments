package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 霜华窃取者附魔的事件处理类
 * <p>
 * 功能：使用此武器击败拥有霜寒效果的目标可获得冰霜护甲
 * 机制：
 * 1. 玩家击杀目标时检测目标是否拥有霜寒效果
 * 2. 目标无霜寒效果 → 不触发任何效果
 * 3. 目标有霜寒效果 → 判断玩家当前是否已有冰霜护甲效果：
 *    a. 已有冰霜护甲 → 延长效果持续时间（不超过最大持续时间上限）
 *    b. 无冰霜护甲 → 检查冷却时间是否结束
 * 4. 冷却时间内击杀不会施加新效果（防止频繁触发）
 * 5. 施加新效果时持续时间和等级从配置读取
 * 6. 延长效果时保持原有效果等级不变，仅增加持续时间
 * 7. 触发后更新最后击杀时间（用于冷却判断）
 */
public class RimestealerEvent {

    // NBT标签：记录上次触发效果的击杀时间（游戏刻）
    private static final String LAST_KILL_TIME_TAG = "RimestealerLastKillTime";

    /**
     * 击杀事件处理
     * 如果目标拥有霜寒效果，则给予玩家冰霜护甲效果
     *
     * @param player 击杀者
     * @param gun    使用的枪械（用于检查附魔等级和存储NBT数据）
     * @param target 被击杀的目标（需要检查是否拥有霜寒效果）
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.RIMESTEALER.get());
        if (enchantLevel <= 0) return;

        // 关键条件：目标必须拥有"霜寒"效果
        if (!target.hasEffect(FELEffects.FROSTBITE.get())) return;

        long currentTime = player.level().getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastKillTime = tag.getLong(LAST_KILL_TIME_TAG);

        // 检查玩家是否已有"冰霜护甲"效果
        MobEffectInstance currentEffect = player.getEffect(FELEffects.FROST_ARMOR.get());

        if (currentEffect != null) {
            // 情况1：已有冰霜护甲效果 -> 延长持续时间
            int extendDuration = TBZConfig.RIMESTEALER_EXTEND_DURATION.get();   // 每次延长的刻数
            int maxDuration = TBZConfig.RIMESTEALER_MAX_DURATION.get(); // 最大持续时间
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

            // 获取效果等级
            int frostArmorAmplifier = TBZConfig.RIMESTEALER_FROST_ARMOR_AMPLIFIER.get();

            // 施加新的冰霜护甲效果
            player.addEffect(new MobEffectInstance(
                    FELEffects.FROST_ARMOR.get(), newDuration, frostArmorAmplifier, false, true
            ));

            // 更新最后击杀时间
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        } else {
            // 情况2：没有冰霜护甲效果 -> 检查冷却，尝试施加新效果
            int cooldownTicks = TBZConfig.RIMESTEALER_COOLDOWN_TICKS.get();

            // 如果在冷却时间内，不触发效果
            if (currentTime - lastKillTime < cooldownTicks) {
                return;
            }

            // 获取冰霜护甲效果的持续时间和等级
            int frostArmorDuration = TBZConfig.RIMESTEALER_FROST_ARMOR_DURATION.get();
            int frostArmorAmplifier = TBZConfig.RIMESTEALER_FROST_ARMOR_AMPLIFIER.get();

            // 创建新的冰霜护甲效果
            MobEffectInstance frostArmor = new MobEffectInstance(
                    FELEffects.FROST_ARMOR.get(), frostArmorDuration, frostArmorAmplifier, false, true
            );

            // 施加效果
            player.addEffect(frostArmor);

            // 记录本次击杀时间
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        }
    }
}