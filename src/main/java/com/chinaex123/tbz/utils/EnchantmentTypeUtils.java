package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

/**
 * 附魔类型工具类
 * <p>
 * 提供附魔分类和类型检查功能
 */
public class EnchantmentTypeUtils {

    /** 所有异域类附魔的集合 */
    private static final Set<RegistryObject<? extends Enchantment>> EXOTIC_ENCHANTMENTS = new HashSet<>();

    static {
        initializeExoticEnchantments();
    }

    /**
     * 初始化异域类附魔集合
     */
    private static void initializeExoticEnchantments() {
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.PROTECTIVE_WEAVE);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.REIGN_HAVOC);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.SUROS_LEGACY);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.PRIMEVALS_TORMENT);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.FULL_STOP);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.CREEPING_ATTRITION);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.TOUCH_OF_MALICE);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.THE_RIGHT_CHOICE);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.VEXADECIMAL);
        EXOTIC_ENCHANTMENTS.add(TBZEnchantments.PERSONAL_ASSISTANT);
    }

    /**
     * 检查是否是异域类附魔
     * @param enchantment 附魔RegistryObject
     * @return true表示是异域类附魔
     */
    public static boolean isExoticEnchantment(RegistryObject<? extends Enchantment> enchantment) {
        return EXOTIC_ENCHANTMENTS.contains(enchantment);
    }

    /**
     * 获取所有异域类附魔
     * @return 不可修改的异域类附魔集合
     */
    public static Set<RegistryObject<? extends Enchantment>> getExoticEnchantments() {
        return Collections.unmodifiableSet(EXOTIC_ENCHANTMENTS);
    }

    /**
     * 计算异域类附魔的数量
     * @param enchantments 附魔集合
     * @return 异域类附魔数量
     */
    public static int countExoticEnchantments(Collection<Enchantment> enchantments) {
        if (enchantments == null) return 0;

        int count = 0;
        for (Enchantment enchantment : enchantments) {
            if (isExoticEnchantment(enchantment)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 检查是否是异域类附魔（重载方法，接受Enchantment对象）
     * @param enchantment 附魔对象
     * @return true表示是异域类附魔
     */
    public static boolean isExoticEnchantment(Enchantment enchantment) {
        if (enchantment == null) return false;
        
        return EXOTIC_ENCHANTMENTS.stream()
                .anyMatch(registryObject -> registryObject.isPresent() && registryObject.get() == enchantment);
    }
}