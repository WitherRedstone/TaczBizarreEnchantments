package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 斩首武器：对Boss生物造成额外伤害 **/
public class BorpalWeaponEnchantment extends BaseTBZEnchantment {

    public BorpalWeaponEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("borpal_weapon"), "BORPAL_WEAPON");
    }
}