package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 超充弹匣：处于增幅状态时，弹药会逐渐从备弹转移到弹匣中 **/
public class SuperchargedMagazineEnchantment extends BaseTBZEnchantment {

    public SuperchargedMagazineEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("supercharged_magazine"), "SUPERCHARGED_MAGAZINE");
    }
}