package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 冲击支撑：消灭虚空减益目标可提供覆盖护盾 */
public class RepulsorBraceEnchantment extends BaseTBZEnchantment {

    public RepulsorBraceEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("repulsor_brace"), "REPULSOR_BRACE");
    }
}
