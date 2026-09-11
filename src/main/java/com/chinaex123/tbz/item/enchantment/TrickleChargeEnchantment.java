package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 涓流充能：接收或释放电光充能会从备弹中填装弹匣的一部分 **/
public class TrickleChargeEnchantment extends BaseTBZEnchantment {

    public TrickleChargeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("trickle_charge"), "TRICKLE_CHARGE");
    }
}