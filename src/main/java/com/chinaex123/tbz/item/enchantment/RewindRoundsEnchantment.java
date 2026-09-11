package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 回转弹药：射空此武器的弹匣时，会根据命中次数从储存弹药中填装 **/
public class RewindRoundsEnchantment extends BaseTBZEnchantment {

    public RewindRoundsEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("rewind_rounds"), "REWIND_ROUNDS");
    }
}