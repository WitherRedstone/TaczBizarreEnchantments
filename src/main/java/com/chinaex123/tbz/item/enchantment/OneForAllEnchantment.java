package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 我为人人：命中不同的三个目标可在短时间内提高伤害 **/
public class OneForAllEnchantment extends BaseTBZEnchantment {

    public OneForAllEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("one_for_all"), "ONE_FOR_ALL");
    }
}