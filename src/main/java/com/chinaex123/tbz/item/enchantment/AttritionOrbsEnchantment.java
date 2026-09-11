package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 羸弱能量球：对同一目标造成持续伤害会生成经验球 **/
public class AttritionOrbsEnchantment extends BaseTBZEnchantment {

    public AttritionOrbsEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("attrition_orbs"), "ATTRITION_ORBS");
    }
}