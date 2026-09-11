package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 命运的逆转：射偏2发子弹会在短时间后将1发子弹返回弹匣 **/
public class ReversalOfFortuneEnchantment extends BaseTBZEnchantment {

    public ReversalOfFortuneEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("reversal_of_fortune"), "REVERSAL_OF_FORTUNE");
    }
}