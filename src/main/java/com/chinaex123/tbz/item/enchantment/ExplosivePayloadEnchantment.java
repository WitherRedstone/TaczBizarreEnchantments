package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 高爆载荷：弹药在命中时爆炸，产生范围效果 **/
public class ExplosivePayloadEnchantment extends BaseTBZEnchantment {

    public ExplosivePayloadEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("explosive_payload"), "EXPLOSIVE_PAYLOAD");
    }
}