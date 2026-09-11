package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** SUROS遗产：弹匣后半子弹造成额外伤害，击杀时有几率恢复血量 **/
public class SurosLegacyEnchantment extends BaseTBZEnchantment {

    public SurosLegacyEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("suros_legacy"), "SUROS_LEGACY");
    }
}