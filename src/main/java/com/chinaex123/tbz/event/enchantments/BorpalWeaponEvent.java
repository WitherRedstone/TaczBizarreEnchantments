package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.enchantment.BorpalWeaponEnchantment;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;

/**
 * 斩首武器附魔的事件处理类
 * <p>
 * 功能：对Boss生物造成额外伤害
 * 机制：
 * 1. 检测被射击目标是否为Boss类实体（通过Tags.EntityTypes.BOSSES标签）
 * 2. 非Boss目标不触发任何效果
 * 3. 对Boss目标根据附魔等级计算伤害倍率：基础伤害 × (1 + 每级加成值 × 等级)
 * 4. 将计算后的伤害值直接覆盖原伤害，实现伤害倍率调整
 * 5. 伤害加成仅作用于Boss目标，对普通实体无任何影响
 */
public class BorpalWeaponEvent {

    /**
     * 应用斩首武器的伤害加成效果
     * 当目标为Boss实体时，根据附魔等级提高造成的伤害
     *
     * @param event  枪械伤害事件（Pre阶段，可修改伤害值）
     * @param gun    使用的枪械物品
     * @param target 被击中的目标实体
     */
    public static void apply(EntityHurtByGunEvent.Pre event, ItemStack gun, LivingEntity target) {
        // 检查目标是否为Boss类实体
        boolean isBoss = target.getType().is(Tags.EntityTypes.BOSSES);
        if (!isBoss) return;

        // 获取斩首武器附魔实例
        BorpalWeaponEnchantment borpal = TBZEnchantments.BORPAL_WEAPON.get();

        // 检查枪械上的附魔等级
        int level = gun.getEnchantmentLevel(borpal);
        if (level <= 0) return;

        // 根据附魔等级计算对Boss的伤害倍率
        float multiplier = 1.0f + TBZConfig.BORPAL_WEAPON_BOSS_DAMAGE_BONUS.get().floatValue() * level;

        // 计算加成后的新伤害 = 原伤害 × 倍率
        float newDamage = event.getBaseAmount() * multiplier;

        // 修改事件中的伤害值
        event.setBaseAmount(newDamage);
    }
}