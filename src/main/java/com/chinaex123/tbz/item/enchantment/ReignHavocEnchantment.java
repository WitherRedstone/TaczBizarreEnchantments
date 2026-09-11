package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 统治浩劫：持续造成精准伤害或造成最后一击可产生从天而降的闪电打击，并填装部分弹匣。闪电打击会提供1层电光充能 **/
public class ReignHavocEnchantment extends BaseTBZEnchantment {

    public ReignHavocEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("reign_havoc"), "REIGN_HAVOC");
    }
}