package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 风暴之眼：生命值越低，武器的瞄准精度越好并略微降低水平后坐力 **/
public class EyeOfStormEyeEnchantment extends BaseTBZEnchantment {

    public EyeOfStormEyeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("eye_of_storm_eye"), "EYE_OF_STORM_EYE");
    }
}