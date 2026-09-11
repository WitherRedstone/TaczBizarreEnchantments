package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 私人助手：显示目标生命值和距离，震颤目标 */
public class PersonalAssistantEnchantment extends BaseTBZEnchantment {

    public PersonalAssistantEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("personal_assistant"), "PERSONAL_ASSISTANT");
    }
}