package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 小丑皇弹药筒：装填时随机从备弹中多填装弹药 */
public class ClownCartridgeEnchantment extends BaseTBZEnchantment {

    public ClownCartridgeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("clown_cartridge"), "CLOWN_CARTRIDGE");
    }
}
