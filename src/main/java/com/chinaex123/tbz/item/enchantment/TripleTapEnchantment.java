package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 精准连击：快速精准命中目标会向弹匣里填装一枚弹药 **/
public class TripleTapEnchantment extends BaseTBZEnchantment {

    public TripleTapEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("triple_tap"), "TRIPLE_TAP");
    }
}