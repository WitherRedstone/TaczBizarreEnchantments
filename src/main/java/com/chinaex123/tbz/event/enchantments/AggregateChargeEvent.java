package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 聚合充能附魔的事件处理类
 * <p>
 * 功能：根据目标身上的负面效果造成更多伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>检查目标身上的所有效果</li>
 *   <li>统计负面效果数量（动态判断，不硬编码）</li>
 *   <li>根据负面效果数量增加伤害：1种=11%，2种=22%，...，6种=66%（上限）</li>
 * </ol>
 */
public class AggregateChargeEvent {

    /** 最大生效的负面效果数量 **/
    private static final int MAX_DEBUFF_COUNT = 6;

    /**
     * 枪械伤害事件：聚合充能
     * 根据目标身上的负面效果造成更多伤害
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.AGGREGATE_CHARGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 统计目标身上的负面效果数量
        int debuffCount = 0;
        for (MobEffectInstance effectInstance : target.getActiveEffects()) {
            MobEffect effect = effectInstance.getEffect();
            // 动态判断是否为负面效果（isBeneficial返回false）
            if (!effect.isBeneficial()) {
                debuffCount++;
            }
        }

        // 如果没有负面效果，不增加伤害
        if (debuffCount <= 0) return;

        // 限制最大生效的负面效果数量为6
        int effectiveDebuffCount = Math.min(debuffCount, MAX_DEBUFF_COUNT);

        // 获取配置的伤害增加百分比
        float damageBonusPerDebuff = TBZServerConfig.AGGREGATE_CHARGE_DAMAGE_BONUS_PERCENT.get().floatValue();

        // 计算总伤害加成：负面效果数量 × 每种减益的伤害增加百分比
        float totalDamageBonus = event.getBaseAmount() * damageBonusPerDebuff * effectiveDebuffCount;

        // 应用伤害加成
        event.setBaseAmount(event.getBaseAmount() + totalDamageBonus);
    }
}