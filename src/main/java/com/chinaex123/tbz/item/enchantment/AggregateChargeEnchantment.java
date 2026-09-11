package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 聚合充能：根据目标身上的负面效果造成更多伤害 */
public class AggregateChargeEnchantment extends BaseTBZEnchantment {

    public AggregateChargeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("aggregate_charge"), "AGGREGATE_CHARGE");
    }
}