package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 直击要害：瞄准可提升身体射击伤害 **/
public class GutshotStraightEnchantment extends BaseTBZEnchantment {

    public GutshotStraightEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("gutshot_straight"), "GUTSHOT_STRAIGHT");
    }
}