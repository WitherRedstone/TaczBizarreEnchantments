package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 事不过四：快速精准命中目标会向弹匣里返还两枚弹药 **/
public class FourthTimeTheCharmEnchantment extends BaseTBZEnchantment {

    public FourthTimeTheCharmEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("fourth_time_the_charm"), "FOURTH_TIME_THE_CHARM");
    }
}