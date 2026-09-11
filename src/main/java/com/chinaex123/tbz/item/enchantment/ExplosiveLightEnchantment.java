package com.chinaex123.tbz.item.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.extend.BaseTBZEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/** 爆炸光能：每拾取25点经验都会增加下一枚射弹的伤害 **/
public class ExplosiveLightEnchantment extends BaseTBZEnchantment {

    public ExplosiveLightEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots, TBZMod.id("explosive_light"), "EXPLOSIVE_LIGHT");
    }
}