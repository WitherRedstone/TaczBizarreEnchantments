package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 武器大师：击杀生物时短时间内提升这把武器的伤害 **/
public class MasterOfArmsEnchantment extends BaseTBZEnchantment {

    public MasterOfArmsEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("master_of_arms"), "MASTER_OF_ARMS");
    }
}