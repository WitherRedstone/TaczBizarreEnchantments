package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 霜华窃取者：使用此武器击败拥有霜寒效果的目标可获得冰霜护甲 **/
public class RimestealerEnchantment extends BaseTBZEnchantment {

    public RimestealerEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("rimestealer"), "RIMESTEALER");
    }
}