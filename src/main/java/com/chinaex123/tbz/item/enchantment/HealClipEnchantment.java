package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 治疗弹匣：最后一击后2秒内换弹触发治愈效果 **/
public class HealClipEnchantment extends BaseTBZEnchantment {

    public HealClipEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("heal_clip"), "HEAL_CLIP");
    }
}