package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 柔缓：击败目标后，此武器的射速减慢，但是会在短时间内造成额外伤害 **/
public class AdagioEnchantment extends BaseTBZEnchantment {

    public AdagioEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("adagio"), "ADAGIO");
    }
}