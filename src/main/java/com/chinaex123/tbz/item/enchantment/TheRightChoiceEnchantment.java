package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 正确抉择：每第七发子弹会弹向附近目标 */
public class TheRightChoiceEnchantment extends BaseTBZEnchantment {

    public TheRightChoiceEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("the_right_choice"), "THE_RIGHT_CHOICE");
    }
}