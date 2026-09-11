package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 维持生计：消灭目标会使弹药从储存弹药中转移并填装部分弹匣 **/
public class SubsistenceEnchantment extends BaseTBZEnchantment {

    public SubsistenceEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("subsistence"), "SUBSISTENCE");
    }
}