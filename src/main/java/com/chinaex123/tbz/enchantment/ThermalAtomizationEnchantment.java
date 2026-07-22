package com.chinaex123.tbz.enchantment;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

/** 热能雾化：在高热量状态下，此武器造成更高伤害，并使目标在被击败时爆炸 */
public class ThermalAtomizationEnchantment extends Enchantment {

    public ThermalAtomizationEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots);
    }

    /** 最小附魔成本 **/
    @Override
    public int getMinCost(int level) {
        return TBZConfig.THERMAL_ATOMIZATION_BASE_ENCHANTABILITY.get() + (level - 1) * TBZConfig.THERMAL_ATOMIZATION_LEVEL_ENCHANTABILITY.get();
    }

    /** 最大附魔成本 **/
    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + TBZConfig.THERMAL_ATOMIZATION_ENCHANTABILITY_SPAN.get();
    }

    /** 最大附魔等级 **/
    @Override
    public int getMaxLevel() {
        return TBZConfig.THERMAL_ATOMIZATION_MAX_LEVEL.get();
    }

    /** 检查物品是否是枪械 **/
    private boolean isGun(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return IGun.getIGunOrNull(stack) != null;
    }

    /** 检查物品是否可以附魔到枪械 **/
    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        if (!isGun(stack)) return false;
        if (!GunEnchantmentHelper.canApplyEnchantmentToGunWithWeaponType(
                TBZMod.id("thermal_atomization"),
                stack
        )) {
            return false;
        }
        return GunEnchantmentHelper.canAddMoreTBZEnchantments(stack);
    }

    /** 检查是否可以在附魔台附魔 **/
    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return canEnchant(stack);
    }

    /** 检查是否可以在附魔书上附魔 **/
    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
}