package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.item.enchantment.BorpalWeaponEnchantment;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;

/**
 * 斩首武器附魔的事件处理类
 * <p>
 * 功能：对Boss生物造成额外伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>检测被射击目标是否为Boss类实体
 *   <li>非Boss目标不触发任何效果
 *   <li>对Boss目标根据附魔等级计算伤害倍率：基础伤害 × (1 + 每级加成值 × 等级)
 *   <li>将计算后的伤害值直接覆盖原伤害，实现伤害倍率调整
 *   <li>伤害加成仅作用于Boss目标，对普通实体无任何影响
 * </ol>
 */
public class BorpalWeaponEvent {

    /**
     * 枪械伤害事件：斩首武器
     * 当目标为Boss实体时，根据附魔等级提高造成的伤害
     *
     * @param event 枪械伤害事件
     * @param gun 使用的枪械物品
     * @param target 被击中的目标实体
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event, ItemStack gun, LivingEntity target) {
        // 检查目标是否为Boss类实体
        boolean isBoss = target.getType().is(Tags.EntityTypes.BOSSES);
        if (!isBoss) return;

        // 获取斩首武器附魔实例
        BorpalWeaponEnchantment borpal = TBZEnchantments.BORPAL_WEAPON.get();

        // 检查枪械上的附魔等级
        int level = gun.getEnchantmentLevel(borpal);
        if (level <= 0) return;

        // 根据附魔等级计算对Boss的伤害倍率
        float multiplier = 1.0f + TBZServerConfig.BORPAL_WEAPON_BOSS_DAMAGE_BONUS.get().floatValue() * level;

        // 计算加成后的新伤害 = 原伤害 × 倍率
        float newDamage = event.getBaseAmount() * multiplier;

        // 修改事件中的伤害值
        event.setBaseAmount(newDamage);
    }
}