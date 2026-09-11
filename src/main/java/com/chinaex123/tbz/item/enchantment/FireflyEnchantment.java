package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 萤火虫：完成精准击杀可以提高填装速度并使目标爆炸 **/
public class FireflyEnchantment extends BaseTBZEnchantment {

    public FireflyEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("firefly"), "FIREFLY");
    }
}