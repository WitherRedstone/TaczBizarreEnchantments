package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * 冰冷弹匣附魔的事件处理类
 * <p>
 * 功能：持续攻击可对目标施加减速效果
 * <p>
 * 机制：
 * <ol>
 *   <li>每次命中目标时独立计算触发概率
 *   <li>触发后判断目标当前是否已有霜寒效果：
 *     <ol type="a">
 *       <li>已有霜寒效果 → 延长效果持续时间（不超过最大持续时间上限）</li>
 *       <li>无霜寒效果 → 检查是否在冷却时间内，若冷却结束则施加新效果</li>
 *     </ol>
 *   </li>
 *   <li>施加新效果时，效果等级在配置的最小/最大等级范围内随机生成</li>
 *   <li>每次成功触发（无论是施加还是延长）都会更新冷却计时</li>
 *   <li>冷却期间命中目标不会施加新霜寒效果，但延长效果不受冷却影响</li>
 *   <li>延长效果时保持原有效果等级不变，仅增加持续时间</li>
 * </ol>
 */
public class ChillClipEvent {

    /** NBT存储键：记录上次触发效果的命中时间 */
    private static final String LAST_HIT_TIME_TAG = "ChillClipLastHitTime";

    /**
     * 枪械伤害事件：冰冷弹匣
     * 概率触发并施加霜寒效果给目标
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.CHILL_CLIP.get());
        if (enchantLevel <= 0) return;

        // 触发概率判定：每次命中独立计算
        double triggerChance = TBZServerConfig.CHILL_CLIP_TRIGGER_CHANCE.get();
        if (player.getRandom().nextDouble() >= triggerChance) return;

        Level level = player.level();
        long currentTime = level.getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastHitTime = tag.getLong(LAST_HIT_TIME_TAG);

        // 检查目标是否已有"减速"效果
        MobEffectInstance currentEffect = target.getEffect(FELEffects.SLOW.get());

        if (currentEffect != null) {
            // 情况1：已有霜寒效果 -> 延长持续时间
            int extendDuration = TBZServerConfig.CHILL_CLIP_EXTEND_DURATION.get();
            int maxDuration = TBZServerConfig.CHILL_CLIP_MAX_DURATION.get();
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

            // 保留原有效果的等级（不改变效果强度）
            int slowAmplifier = currentEffect.getAmplifier();

            // 施加新的减速效果（覆盖旧的，持续时间延长）
            target.addEffect(new MobEffectInstance(
                    FELEffects.SLOW.get(), newDuration, slowAmplifier, false, true
            ));
        } else {
            // 情况2：没有减速效果 -> 检查冷却，尝试施加新效果
            int cooldownTicks = TBZServerConfig.CHILL_CLIP_COOLDOWN_TICKS.get();

            // 如果在上次触发后的冷却时间内，不触发新效果
            if (currentTime - lastHitTime < cooldownTicks) {
                return;
            }

            // 获取减速效果的持续时间和等级范围
            int slowDuration = TBZServerConfig.CHILL_CLIP_SLOW_DURATION.get();
            int slowMinAmplifier = TBZServerConfig.CHILL_CLIP_SLOW_MIN_AMPLIFIER.get();
            int slowMaxAmplifier = TBZServerConfig.CHILL_CLIP_SLOW_MAX_AMPLIFIER.get();

            // 随机生成效果等级（在最小和最大之间随机）
            int slowAmplifier = slowMinAmplifier + player.getRandom().nextInt(slowMaxAmplifier - slowMinAmplifier + 1);

            // 创建新的减速效果
            MobEffectInstance slowEffect = new MobEffectInstance(
                    FELEffects.SLOW.get(), slowDuration, slowAmplifier, false, true
            );

            // 施加效果
            target.addEffect(slowEffect);
        }

        // 更新最后命中时间
        tag.putLong(LAST_HIT_TIME_TAG, currentTime);
    }
}