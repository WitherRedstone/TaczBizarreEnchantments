package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 泉源：使用此武器造成击杀会产生经验球 **/
public class WellspringEnchantment extends BaseTBZEnchantment {

    public WellspringEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("wellspring"), "WELLSPRING");
    }
}