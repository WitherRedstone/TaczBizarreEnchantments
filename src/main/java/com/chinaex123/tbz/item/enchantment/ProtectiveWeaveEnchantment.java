package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 防护编织：击杀生物获得织造铠甲，拥有织造铠甲时造成更多伤害 **/
public class ProtectiveWeaveEnchantment extends BaseTBZEnchantment {

    public ProtectiveWeaveEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("protective_weave"), "PROTECTIVE_WEAVE");
    }
}