package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 猛攻：使用此武器完成最后一击可提高其射速 **/
public class OnslaughtEnchantment extends BaseTBZEnchantment {

    public OnslaughtEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("onslaught"), "ONSLAUGHT");
    }
}