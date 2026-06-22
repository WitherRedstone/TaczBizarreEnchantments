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
 * 防护编织附魔的事件处理类
 * <p>
 * 功能：击杀生物获得织造铠甲，当你拥有织造铠甲时会造成更多伤害
 * 机制：
 * 1. 玩家击杀敌人时触发效果检测
 * 2. 判断玩家当前是否已有织造铠甲效果：
 *    a. 已有织造铠甲 → 延长效果持续时间（不超过最大持续时间上限）
 *    b. 无织造铠甲 → 检查冷却时间是否结束
 * 3. 冷却时间内击杀不会施加新效果（防止频繁触发）
 * 4. 施加新效果时持续时间和等级从配置读取
 * 5. 延长效果时保持原有效果等级不变，仅增加持续时间
 * 6. 拥有织造铠甲效果时，所有枪械伤害获得固定比例加成
 * 7. 伤害加成比例从配置读取（固定值，不随附魔等级变化）
 * 8. 最终伤害 = 原伤害 × (1 + 伤害加成比例)
 */
public class ProtectiveWeaveEvent {

    private static final String LAST_KILL_TIME_TAG = "ProtectiveWeaveLastKillTime";

    /**
     * 击杀事件处理
     * 给予玩家织造铠甲效果，或延长已有效果的持续时间
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PROTECTIVE_WEAVE.get());
        if (enchantLevel <= 0) return;

        long currentTime = player.level().getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastKillTime = tag.getLong(LAST_KILL_TIME_TAG);

        MobEffectInstance currentEffect = player.getEffect(FELEffects.WOVEN_MAIL.get());

        if (currentEffect != null) {
            int extendDuration = TBZConfig.PROTECTIVE_WEAVE_EXTEND_DURATION.get();
            int maxDuration = TBZConfig.PROTECTIVE_WEAVE_MAX_DURATION.get();
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);
            int wovenMailAmplifier = TBZConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER.get();
            player.addEffect(new MobEffectInstance(
                FELEffects.WOVEN_MAIL.get(),
                newDuration,
                wovenMailAmplifier,
                false,
                true
            ));
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        } else {
            int cooldownTicks = TBZConfig.PROTECTIVE_WEAVE_COOLDOWN_TICKS.get();
            if (currentTime - lastKillTime < cooldownTicks) {
                return;
            }

            int wovenMailDuration = TBZConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_DURATION.get();
            int wovenMailAmplifier = TBZConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER.get();
            MobEffectInstance wovenMail = new MobEffectInstance(
                FELEffects.WOVEN_MAIL.get(),
                wovenMailDuration,
                wovenMailAmplifier,
                false,
                true
            );

            player.addEffect(wovenMail);
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        }
    }

    /**
     * 枪械伤害事件处理
     * 如果玩家拥有织造铠甲，增加伤害
     *
     * @param event 枪械伤害事件
     * @param gun    使用的枪械
     */
    public static void onEntityHurtByGun(com.tacz.guns.api.event.common.EntityHurtByGunEvent.Pre event, ItemStack gun) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        if (!player.hasEffect(FELEffects.WOVEN_MAIL.get())) {
            return;
        }

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PROTECTIVE_WEAVE.get());
        if (enchantLevel <= 0) return;

        float damageBonus = TBZConfig.PROTECTIVE_WEAVE_DAMAGE_BONUS.get().floatValue();
        float newDamage = event.getBaseAmount() * (1.0f + damageBonus);

        event.setBaseAmount(newDamage);
    }
}