package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 冷却饰物：收集经验球有概率降低武器热量 **/
public class CoolingBaublesEnchantment extends BaseTBZEnchantment {

    public CoolingBaublesEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("cooling_baubles"), "COOLING_BAUBLES");
    }
}
