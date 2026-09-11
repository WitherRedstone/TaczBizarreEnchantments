package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 古昧的折磨：射出的子弹有概率会对目标或命中点附近区域造成凋零效果 **/
public class PrimevalsTormentEnchantment extends BaseTBZEnchantment {

    public PrimevalsTormentEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("primevals_torment"), "PRIMEVALS_TORMENT");
    }
}