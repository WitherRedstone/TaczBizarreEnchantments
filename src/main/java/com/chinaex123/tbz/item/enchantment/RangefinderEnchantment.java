package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 测距仪：瞄准可提高优势射程和瞄准精度，同时减少垂直后坐力 **/
public class RangefinderEnchantment extends BaseTBZEnchantment {

    public RangefinderEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
            super(rarity, category, slots, TBZMod.id("rangefinder"), "RANGEFINDER");
        }
}
