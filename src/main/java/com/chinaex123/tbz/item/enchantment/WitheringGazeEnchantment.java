package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 枯萎凝视：瞄准此武器一小段时间而不射击，你将能够削弱下一个目标 **/
public class WitheringGazeEnchantment extends BaseTBZEnchantment {

    public WitheringGazeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("withering_gaze"), "WITHERING_GAZE");
    }
}