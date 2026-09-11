package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 盒式呼吸法：瞄准此武器一小段时间而不射击，会提高精准伤害 **/
public class BoxBreathingEnchantment extends BaseTBZEnchantment {

    public BoxBreathingEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("box_breathing"), "BOX_BREATHING");
    }
}