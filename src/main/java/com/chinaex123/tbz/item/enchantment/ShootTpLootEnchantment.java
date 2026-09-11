package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 边打边劫：远程射击物品和经验球会立即将其拾起并放到物品栏内 **/
public class ShootTpLootEnchantment extends BaseTBZEnchantment {

    public ShootTpLootEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("shoot_tp_loot"), "SHOOT_TP_LOOT");
    }
}