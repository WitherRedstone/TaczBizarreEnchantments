package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 刺客野心：根据填装之前完成的击杀数可过量填充弹匣 **/
public class AmbitiousAssassinEnchantment extends BaseTBZEnchantment {

    public AmbitiousAssassinEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("ambitious_assassin"), "AMBITIOUS_ASSASSIN");
    }
}