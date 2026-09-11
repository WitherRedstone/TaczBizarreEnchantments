package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 冰冷弹匣：持续攻击可对目标施加霜寒效果 **/
public class ChillClipEnchantment extends BaseTBZEnchantment {

    public ChillClipEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("chill_clip"), "CHILL_CLIP");
    }
}