package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 防护编织附魔的事件处理类
 * <p>
 * 功能：击杀生物获得织造铠甲，当你拥有织造铠甲时会造成更多伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀敌人时触发效果检测</li>
 *   <li>判断玩家当前是否已有织造铠甲效果：
 *     <ol type="a">
 *       <li>已有织造铠甲 → 延长效果持续时间（不超过最大持续时间上限）</li>
 *       <li>无织造铠甲 → 检查冷却时间是否结束</li>
 *     </ol>
 *   </li>
 *   <li>冷却时间内击杀不会施加新效果（防止频繁触发）</li>
 *   <li>施加新效果时持续时间和等级从配置读取</li>
 *   <li>延长效果时保持原有效果等级不变，仅增加持续时间</li>
 *   <li>拥有织造铠甲效果时，所有枪械伤害获得固定比例加成</li>
 *   <li>伤害加成比例从配置读取（固定值，不随附魔等级变化）</li>
 *   <li>最终伤害 = 原伤害 × (1 + 伤害加成比例)</li>
 * </ol>
 */
public class ProtectiveWeaveEvent {

    /** 记录上次击杀时间 */
    private static final String LAST_KILL_TIME_TAG = "ProtectiveWeaveLastKillTime";

    /**
     * 实体死亡事件：防护编织
     * 给予玩家织造铠甲效果，或延长已有效果的持续时间
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查是否有防护编织附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PROTECTIVE_WEAVE.get());
        if (enchantLevel <= 0) return;

        long currentTime = player.level().getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastKillTime = tag.getLong(LAST_KILL_TIME_TAG);

        // 检查玩家当前是否已有织造铠甲效果
        MobEffectInstance currentEffect = player.getEffect(FELEffects.WOVEN_MAIL.get());

        if (currentEffect != null) {
            // 已有织造铠甲效果 → 延长持续时间
            int extendDuration = TBZServerConfig.PROTECTIVE_WEAVE_EXTEND_DURATION.get();
            int maxDuration = TBZServerConfig.PROTECTIVE_WEAVE_MAX_DURATION.get();
            int newDuration = Math.min(currentEffect.getDuration() + extendDuration, maxDuration);
            int wovenMailAmplifier = TBZServerConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER.get();

            // 重新添加效果，保持等级不变，只更新持续时间
            player.addEffect(new MobEffectInstance(
                    FELEffects.WOVEN_MAIL.get(),
                    newDuration,
                    wovenMailAmplifier,
                    false,
                    true
            ));
            // 更新击杀时间
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        } else {
            // 无织造铠甲效果 → 检查冷却时间
            int cooldownTicks = TBZServerConfig.PROTECTIVE_WEAVE_COOLDOWN_TICKS.get();
            if (currentTime - lastKillTime < cooldownTicks) {
                // 冷却中，不施加新效果
                return;
            }

            // 冷却结束，施加新的织造铠甲效果
            int wovenMailDuration = TBZServerConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_DURATION.get();
            int wovenMailAmplifier = TBZServerConfig.PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER.get();
            MobEffectInstance wovenMail = new MobEffectInstance(
                    FELEffects.WOVEN_MAIL.get(),
                    wovenMailDuration,
                    wovenMailAmplifier,
                    false,
                    true
            );

            player.addEffect(wovenMail);
            // 记录本次击杀时间
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);
        }
    }

    /**
     * 枪械伤害事件：防护编织
     * 如果玩家拥有织造铠甲，增加伤害
     *
     * @param event 枪械伤害事件
     * @param gun 使用的枪械
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event, ItemStack gun) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        // 检查玩家是否拥有织造铠甲效果
        if (!player.hasEffect(FELEffects.WOVEN_MAIL.get())) {
            return;
        }

        // 检查是否有防护编织附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PROTECTIVE_WEAVE.get());
        if (enchantLevel <= 0) return;

        // 从配置获取伤害加成比例
        float damageBonus = TBZServerConfig.PROTECTIVE_WEAVE_DAMAGE_BONUS.get().floatValue();
        // 计算新伤害：原始伤害 × (1 + 伤害加成比例)
        float newDamage = event.getBaseAmount() * (1.0f + damageBonus);

        // 设置修改后的伤害
        event.setBaseAmount(newDamage);
    }
}