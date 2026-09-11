package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 稳若磐石：潜行射击时可提高瞄准精度并减少垂直后坐力 **/
public class FirmlyPlantedEnchantment extends BaseTBZEnchantment {

    public FirmlyPlantedEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("firmly_planted"), "FIRMLY_PLANTED");
    }
}