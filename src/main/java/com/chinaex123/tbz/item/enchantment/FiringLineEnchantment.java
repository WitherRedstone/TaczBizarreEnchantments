package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 火线：在两个或更多玩家身边时，武器造成的精准伤害增加 */
public class FiringLineEnchantment extends BaseTBZEnchantment {

    public FiringLineEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("firing_line"), "FIRING_LINE");
    }
}