package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 重新调度：子弹未命中时有几率直接向弹匣返还弹药 **/
public class MulliganEnchantment extends BaseTBZEnchantment {

    public MulliganEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("mulligan"), "MULLIGAN");
    }
}