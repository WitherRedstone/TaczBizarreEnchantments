package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 精准工具：造成精准伤害会提升爆头倍率 **/
public class PrecisionInstrumentEnchantment extends BaseTBZEnchantment {

    public PrecisionInstrumentEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("precision_instrument"), "PRECISION_INSTRUMENT");
    }
}