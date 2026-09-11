package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 蝴蝶：瞄准此武器一小段时间而不射击会使你的目标在你剩余弹匣内造成最后一击时爆炸 **/
public class ButterflyEnchantment extends BaseTBZEnchantment {

    public ButterflyEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("butterfly"), "BUTTERFLY");
    }
}