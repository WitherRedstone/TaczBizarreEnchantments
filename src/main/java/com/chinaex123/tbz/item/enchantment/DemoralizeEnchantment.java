package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 瓦解：精准最后一击会使附近目标变得虚弱 **/
public class DemoralizeEnchantment extends BaseTBZEnchantment {

    public DemoralizeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("demoralize"), "DEMORALIZE");
    }
}
