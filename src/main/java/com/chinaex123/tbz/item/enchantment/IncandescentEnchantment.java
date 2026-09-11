package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 辉耀炽热：击败目标会让附近生物获得灼烧效果 **/
public class IncandescentEnchantment extends BaseTBZEnchantment {

    public IncandescentEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("incandescent"), "INCANDESCENT");
    }
}