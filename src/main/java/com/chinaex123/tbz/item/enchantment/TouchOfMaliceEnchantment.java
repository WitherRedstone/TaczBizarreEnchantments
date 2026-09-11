package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 恶意触碰：弹匣中的最后一发弹药会吸收使用者的生命力来造成额外伤害 */
public class TouchOfMaliceEnchantment extends BaseTBZEnchantment {

    public TouchOfMaliceEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("touch_of_malice"), "TOUCH_OF_MALICE");
    }
}