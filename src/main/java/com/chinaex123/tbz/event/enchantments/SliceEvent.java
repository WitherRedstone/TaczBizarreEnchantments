package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
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
 * 切割的事件处理类
 * <p>
 * 功能：持续攻击可对目标施加瓦解效果
 * 机制：
 * 1. 每次命中目标时独立计算触发概率
 * 2. 触发后判断目标当前是否已有瓦解效果：
 *    a. 已有瓦解效果 → 延长效果持续时间（不超过最大持续时间上限）
 *    b. 无瓦解效果 → 检查是否在冷却时间内，若冷却结束则施加新效果
 * 3. 施加新效果时，效果等级在配置的最小/最大等级范围内随机生成
 * 4. 每次成功触发（无论是施加还是延长）都会更新冷却计时
 * 5. 冷却期间命中目标不会施加新瓦解效果，但延长效果不受冷却影响
 * 6. 延长效果时保持原有效果等级不变，仅增加持续时间
 */
public class SliceEvent {

    // NBT标签：记录上次触发效果的命中时间（游戏刻）
    private static final String LAST_HIT_TIME_TAG = "SliceLastHitTime";

    /**
     * 处理枪械命中事件
     * 概率触发并施加瓦解效果给目标
     *
     * @param event 伤害事件（Pre阶段）
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
        double triggerChance = TBZConfig.SLICE_TRIGGER_CHANCE.get();
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
            int extendDuration = TBZConfig.SLICE_EXTEND_DURATION.get();   // 每次延长的刻数
            int maxDuration = TBZConfig.SLICE_MAX_DURATION.get();         // 最大持续时间（刻）
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);

            // 保留原有效果的等级（不改变效果强度）
            int severAmplifier = currentEffect.getAmplifier();

            // 施加新的瓦解效果（覆盖旧的，持续时间延长）
            target.addEffect(new MobEffectInstance(
                FELEffects.SEVER.get(), newDuration, severAmplifier, false, true
            ));
        } else {
            // 情况2：没有瓦解效果 -> 检查冷却，尝试施加新效果
            int cooldownTicks = TBZConfig.SLICE_COOLDOWN_TICKS.get();

            // 如果在上次触发后的冷却时间内，不触发新效果
            if (currentTime - lastHitTime < cooldownTicks) {
                return;
            }

            // 获取瓦解效果的持续时间和等级范围（从配置读取）
            int severDuration = TBZConfig.SLICE_SEVER_DURATION.get();
            int severMinAmplifier = TBZConfig.SLICE_SEVER_MIN_AMPLIFIER.get();  // 最小等级
            int severMaxAmplifier = TBZConfig.SLICE_SEVER_MAX_AMPLIFIER.get();  // 最大等级

            // 随机生成效果等级（在最小和最大之间随机）
            int severAmplifier = severMinAmplifier
                    + player.getRandom().nextInt(severMaxAmplifier - severMinAmplifier + 1);

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