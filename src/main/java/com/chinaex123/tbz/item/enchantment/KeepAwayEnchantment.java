package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 切勿靠近：若附近无目标，提升优势射程和瞄准精度 **/
public class KeepAwayEnchantment extends BaseTBZEnchantment {

    public KeepAwayEnchantment(Enchantment.Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("keep_away"), "KEEP_AWAY");
    }
}
