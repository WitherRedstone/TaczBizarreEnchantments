package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 重建：此武器会缓慢填装子弹，直至两倍弹匣容量 **/
public class ReconstructionEnchantment extends BaseTBZEnchantment {

    public ReconstructionEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("reconstruction"), "RECONSTRUCTION");
    }
}