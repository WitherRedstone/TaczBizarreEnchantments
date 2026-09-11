package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 目标锁定：随着准星在目标上停留的时间增加伤害 **/
public class TargetLockEnchantment extends BaseTBZEnchantment {

    public TargetLockEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("target_lock"), "TARGET_LOCK");
    }
}