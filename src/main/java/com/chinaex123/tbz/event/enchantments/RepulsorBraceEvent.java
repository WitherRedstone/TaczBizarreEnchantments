package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 冲击支撑附魔的事件处理类
 * <p>
 * 功能：消灭带有虚空减益目标的生物可提供覆盖护盾
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀敌人时检查敌人是否带有特定的虚空减益效果</li>
 *   <li>如果敌人带有以下效果之一，则给玩家添加覆盖护盾效果：</li>
 *   <ul>
 *     <li>FELEffect.Volatile（易爆）</li>
 *     <li>FELEffect.Suppression（压制）</li>
 *     <li>FELEffect.Vulnerable（脆弱）</li>
 *   </ul>
 *   <li>覆盖护盾效果的持续时间和等级从配置读取</li>
 *   <li>覆盖护盾效果会覆盖玩家已有的相同效果</li>
 * </ol>
 */
public class RepulsorBraceEvent {

    /**
     * 实体死亡事件：冲击支撑
     * 检查被击杀的生物是否带有虚空减益效果，如果有则给玩家添加覆盖护盾效果
     *
     * @param player 击杀者
     * @param entity 被击杀的生物
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, LivingEntity entity, ItemStack gun) {
        // 检查是否有冲击支撑附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REPULSOR_BRACE.get());
        if (enchantLevel <= 0) return;

        // 检查被击杀的生物是否带有虚空减益效果
        boolean hasVoidDebuff = entity.hasEffect(FELEffects.VOLATILE.get()) ||
                              entity.hasEffect(FELEffects.SUPPRESSION.get()) ||
                              entity.hasEffect(FELEffects.VULNERABLE.get());

        if (!hasVoidDebuff) return;

        // 给玩家添加覆盖护盾效果
        int overshieldDuration = TBZServerConfig.REPULSOR_BRACE_OVERSHIELD_DURATION.get();
        int overshieldAmplifier = TBZServerConfig.REPULSOR_BRACE_OVERSHIELD_LEVEL.get() - 1;
        MobEffectInstance overshield = new MobEffectInstance(FELEffects.OVERSHIELD.get(), overshieldDuration, overshieldAmplifier, false, true);

        player.addEffect(overshield);
    }
}