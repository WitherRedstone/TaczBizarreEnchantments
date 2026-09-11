package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 燃烧野心：造成持续伤害会点燃目标 */
public class BurningAmbitionEnchantment extends BaseTBZEnchantment {

    public BurningAmbitionEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("burning_ambition"), "BURNING_AMBITION");
    }
}