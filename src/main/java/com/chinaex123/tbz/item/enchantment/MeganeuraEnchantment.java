package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 巨脉蜻蜓：精准最后一击会产生爆炸伤害，该爆炸会根据先前造成的精准命中次数造成额外伤害 **/
public class MeganeuraEnchantment extends BaseTBZEnchantment {

    public MeganeuraEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("meganeura"), "MEGANEURA");
    }
}