package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 斗剑士：击杀生物后增加对目标的伤害 **/
public class SwashbucklerEnchantment extends BaseTBZEnchantment {

    public SwashbucklerEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("swashbuckler"), "SWASHBUCKLER");
    }
}