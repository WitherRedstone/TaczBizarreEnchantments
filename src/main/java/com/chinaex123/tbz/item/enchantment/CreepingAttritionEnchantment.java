package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 蔓延羸弱：快速精准命中会使目标进入减速状态 **/
public class CreepingAttritionEnchantment extends BaseTBZEnchantment {

    public CreepingAttritionEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("creeping_attrition"), "CREEPING_ATTRITION");
    }
}
