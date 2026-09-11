package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 速射瞄准：大幅提高瞄准速度 **/
public class SnapshotSightsEnchantment extends BaseTBZEnchantment {

    public SnapshotSightsEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("snapshot_sights"), "SNAPSHOT_SIGHTS");
    }
}