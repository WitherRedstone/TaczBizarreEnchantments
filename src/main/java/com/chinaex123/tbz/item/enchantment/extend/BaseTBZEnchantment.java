package com.chinaex123.tbz.item.enchantment.extend;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

/**
 * TBZ附魔基类
 * <p>
 * 功能：提供所有自定义枪械附魔的通用行为
 * <p>
 * 机制：
 * <ol>
 *   <li>从配置文件读取附魔属性（最小附魔等级、最大附魔等级、附魔跨度）</li>
 *   <li>限制附魔只能应用于枪械</li>
 *   <li>限制附魔只能应用于特定武器类型（通过GunEnchantmentHelper）</li>
 *   <li>限制每把枪械的附魔数量</li>
 * </ol>
 */
public abstract class BaseTBZEnchantment extends Enchantment {

    /** 附魔的注册ID **/
    private final ResourceLocation enchantmentId;
    /** 配置前缀 **/
    private final String configPrefix;

    public BaseTBZEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots,
                              ResourceLocation enchantmentId, String configPrefix) {
        super(rarity, category, slots);
        this.enchantmentId = enchantmentId;
        this.configPrefix = configPrefix;
    }

    /**
     * 获取最小附魔等级消耗
     * <p>
     * 计算公式：基础值 + (等级 - 1) × 每级增加值
     *
     * @param level 附魔等级
     * @return 最小附魔等级消耗
     */
    @Override
    public int getMinCost(int level) {
        try {
            // 从配置读取基础附魔等级和每级附魔等级
            String baseKey = configPrefix + "_BASE_ENCHANTABILITY";
            String levelKey = configPrefix + "_LEVEL_ENCHANTABILITY";

            Field baseField = TBZServerConfig.class.getField(baseKey);
            Field levelField = TBZServerConfig.class.getField(levelKey);

            if (baseField.getType() == ForgeConfigSpec.IntValue.class &&
                    levelField.getType() == ForgeConfigSpec.IntValue.class) {
                ForgeConfigSpec.IntValue baseValue = (ForgeConfigSpec.IntValue) baseField.get(null);
                ForgeConfigSpec.IntValue levelValue = (ForgeConfigSpec.IntValue) levelField.get(null);
                return baseValue.get() + (level - 1) * levelValue.get();
            }
        } catch (Exception e) {
            TBZMod.LOGGER.error("[BaseTBZEnchantment.getMinCost]获取 {} 的基础附魔等级配置失败", configPrefix, e);
        }
        // 默认值
        return 20 + (level - 1) * 10;
    }

    /**
     * 获取最大附魔等级消耗
     * <p>
     * 计算公式：最小附魔等级消耗 + 附魔跨度
     *
     * @param level 附魔等级
     * @return 最大附魔等级消耗
     */
    @Override
    public int getMaxCost(int level) {
        try {
            // 从配置读取附魔跨度
            String spanKey = configPrefix + "_ENCHANTABILITY_SPAN";
            Field spanField = TBZServerConfig.class.getField(spanKey);

            if (spanField.getType() == ForgeConfigSpec.IntValue.class) {
                ForgeConfigSpec.IntValue spanValue = (ForgeConfigSpec.IntValue) spanField.get(null);
                return this.getMinCost(level) + spanValue.get();
            }
        } catch (Exception e) {
            TBZMod.LOGGER.error("[BaseTBZEnchantment.getMaxCost]获取 {} 的附魔跨度配置失败", configPrefix, e);
        }
        // 默认值
        return this.getMinCost(level) + 30;
    }

    /**
     * 获取最大附魔等级
     *
     * @return 最大附魔等级
     */
    @Override
    public int getMaxLevel() {
        try {
            // 从配置读取最大等级
            String maxLevelKey = configPrefix + "_MAX_LEVEL";
            Field maxLevelField = TBZServerConfig.class.getField(maxLevelKey);

            if (maxLevelField.getType() == ForgeConfigSpec.IntValue.class) {
                ForgeConfigSpec.IntValue maxLevelValue = (ForgeConfigSpec.IntValue) maxLevelField.get(null);
                return maxLevelValue.get();
            }
        } catch (Exception e) {
            TBZMod.LOGGER.error("[BaseTBZEnchantment.getMaxLevel]获取 {} 的最大等级配置失败", configPrefix, e);
        }
        return 1;
    }

    /**
     * 判断物品是否为枪械
     *
     * @param stack 物品堆栈
     * @return true表示是枪械
     */
    private boolean isGun(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return IGun.getIGunOrNull(stack) != null;
    }

    /**
     * 判断附魔是否可以应用到物品上
     *
     * @param stack 物品堆栈
     * @return true表示可以应用
     */
    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        // 必须是枪械
        if (!isGun(stack)) return false;

        // 检查武器类型是否匹配
        if (!GunEnchantmentHelper.canApplyEnchantmentToGunWithWeaponType(enchantmentId, stack)) {
            return false;
        }

        // 检查是否可以添加更多TBZ附魔
        return GunEnchantmentHelper.canAddMoreTBZEnchantments(stack);
    }

    /**
     * 判断附魔是否可以在附魔台上应用
     *
     * @param stack 物品堆栈
     * @return true表示可以应用
     */
    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return canEnchant(stack);
    }

    /**
     * 判断附魔是否允许出现在附魔书上
     *
     * @return true表示允许
     */
    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    /**
     * 判断附魔是否可交易
     * <p>
     * 返回 false 阻止附魔出现在原版图书管理员交易中
     * 附魔仍然可以通过火星锻造师职业获得
     *
     * @return false 表示不可交易
     */
    @Override
    public boolean isTradeable() {
        return false;
    }

    /**
     * 获取本附魔的互斥附魔集合。
     * <p>
     * 默认返回空集合，表示不与任何附魔互斥。
     * 子类可重写此方法声明互斥关系。
     *
     * @return 与本附魔互斥的附魔集合（不应为 null）
     */
    protected @NotNull Set<Enchantment> getIncompatibleEnchantments() {
        return Collections.emptySet();
    }

    /**
     * 判断本附魔是否能与另一个附魔共存。
     * <p>
     * 规则：
     * <ol>
     *   <li>不能与自身共存（父类规则）</li>
     *   <li>若 {@code other} 在本附魔的互斥集合中，则不兼容</li>
     *   <li>若本附魔在 {@code other} 的互斥集合中，也不兼容（对称检查）</li>
     * </ol>
     */
    @Override
    protected boolean checkCompatibility(@NotNull Enchantment other) {
        // 父类规则：不能是同一个附魔
        if (!super.checkCompatibility(other)) {
            return false;
        }

        // 本附魔声明的互斥
        if (getIncompatibleEnchantments().contains(other)) {
            return false;
        }

        // 对方声明的互斥
        if (other instanceof BaseTBZEnchantment tbzOther
                && tbzOther.getIncompatibleEnchantments().contains(this)) {
            return false;
        }

        return true;
    }

    /**
     * 判断本附魔是否为宝藏附魔。
     * <p>
     * 宝藏附魔无法通过附魔台获得。
     * 默认返回 false（非宝藏），子类可重写为 true。
     */
    @Override
    public boolean isTreasureOnly() {
        return this.getRarity() == Rarity.VERY_RARE;
    }

    /**
     * 判断本附魔是否可被随机机制发现。
     * <p>
     * 影响附魔台随机池、战利品表随机附魔等。
     * 默认返回 true，子类可重写为 false，
     * 使其只能通过特定途径获得。
     */
    @Override
    public boolean isDiscoverable() {
        return true;
    }
}