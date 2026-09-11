package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 热能雾化：在高热量状态下，此武器造成更高伤害，并使目标在被击败时爆炸 */
public class ThermalAtomizationEnchantment extends BaseTBZEnchantment {

    public ThermalAtomizationEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("thermal_atomization"), "THERMAL_ATOMIZATION");
    }
}