package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 失衡弹药：击败目标会让附近生物获得不稳定效果 **/
public class DestabilizingRoundsEnchantment extends BaseTBZEnchantment {

    public DestabilizingRoundsEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("destabilizing_rounds"), "DESTABILIZING_ROUNDS");
    }
}