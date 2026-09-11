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
 * 切割附魔的事件处理类
 * <p>
 * 功能：持续攻击可对目标施加瓦解效果
 * <p>
 * 机制：
 * <ol>
 *   <li>每次命中目标时独立计算触发概率</li>
 *   <li>触发后判断目标当前是否已有瓦解效果：
 *     <ol type="a">
 *       <li>已有瓦解效果 → 延长效果持续时间（不超过最大持续时间上限）</li>
 *       <li>无瓦解效果 → 检查是否在冷却时间内，若冷却结束则施加新效果</li>
 *     </ol>
 *   </li>
 *   <li>施加新效果时，效果等级在配置的最小/最大等级范围内随机生成</li>
 *   <li>每次成功触发（无论是施加还是延长）都会更新冷却计时</li>
 *   <li>冷却期间命中目标不会施加新瓦解效果，但延长效果不受冷却影响</li>
 *   <li>延长效果时保持原有效果等级不变，仅增加持续时间</li>
 * </ol>
 */
public class SliceEvent {

    /** NBT存储键：记录上次触发效果的命中时间 */
    private static final String LAST_HIT_TIME_TAG = "SliceLastHitTime";

    /**
     * 处理枪械伤害事件：切割
     * 概率触发并施加瓦解效果给目标
     *
     * @param event 伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        // 获取攻击者
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        // 获取目标
        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 获取枪械
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SLICE.get());
        if (enchantLevel <= 0) return;

        // 触发概率判定：每次命中独立计算（从配置读取）
        double triggerChance = TBZServerConfig.SLICE_TRIGGER_CHANCE.get();
        if (player.getRandom().nextDouble() >= triggerChance) return;

        // 获取时间和标签
        Level level = player.level();
        long currentTime = level.getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastHitTime = tag.getLong(LAST_HIT_TIME_TAG);

        // 检查目标是否已有瓦解效果
        MobEffectInstance currentEffect = target.getEffect(FELEffects.SEVER.get());

        if (currentEffect != null) {
            // 情况1：已有瓦解效果 -> 延长持续时间
            int extendDuration = TBZServerConfig.SLICE_EXTEND_DURATION.get();
            int maxDuration = TBZServerConfig.SLICE_MAX_DURATION.get();
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

            // 保留原有效果的等级（不改变效果强度）
            int severAmplifier = currentEffect.getAmplifier();

            // 施加新的瓦解效果（覆盖旧的，持续时间延长）
            target.addEffect(new MobEffectInstance(
                FELEffects.SEVER.get(), newDuration, severAmplifier, false, true
            ));
        } else {
            // 情况2：没有瓦解效果 -> 检查冷却，尝试施加新效果
            int cooldownTicks = TBZServerConfig.SLICE_COOLDOWN_TICKS.get();

            // 如果在上次触发后的冷却时间内，不触发新效果
            if (currentTime - lastHitTime < cooldownTicks) {
                return;
            }

            // 获取瓦解效果的持续时间和等级范围
            int severDuration = TBZServerConfig.SLICE_SEVER_DURATION.get();
            int severMinAmplifier = TBZServerConfig.SLICE_SEVER_MIN_AMPLIFIER.get();
            int severMaxAmplifier = TBZServerConfig.SLICE_SEVER_MAX_AMPLIFIER.get();

            // 随机生成效果等级（在最小和最大之间随机）
            int severAmplifier = severMinAmplifier + player.getRandom().nextInt(severMaxAmplifier - severMinAmplifier + 1);

            // 创建新的瓦解效果
            MobEffectInstance severEffect = new MobEffectInstance(
                FELEffects.SEVER.get(), severDuration, severAmplifier, false, true
            );

            // 施加效果
            target.addEffect(severEffect);
        }

        // 更新最后命中时间（用于冷却判断）
        tag.putLong(LAST_HIT_TIME_TAG, currentTime);
    }
}