package com.chinaex123.tbz.recoil;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 后坐力修改注册中心
 * <p>
 * 允许各附魔注册自己的后坐力修改逻辑
 */
public class RecoilModifierRegistry {
    private static final List<RecoilModifier> MODIFIERS = new ArrayList<>();

    /** 注册一个后坐力修改器 **/
    public static void register(RecoilModifier modifier) {
        MODIFIERS.add(modifier);
    }

    /**
     * 应用所有已注册的修改器
     * @param value 原始后坐力值
     * @param type 后坐力类型
     * @param player 玩家
     * @param itemStack 枪械物品
     * @return 修改后的值
     */
    public static double applyModifiers(double value, RecoilType type, LivingEntity player, ItemStack itemStack) {
        double result = value;
        for (RecoilModifier modifier : MODIFIERS) {
            if (modifier.shouldApply(type, player, itemStack)) {
                result = modifier.apply(result, type, player, itemStack);
            }
        }
        return result;
    }

    /** 后坐力类型 **/
    public enum RecoilType {
        PITCH,  // 垂直
        YAW     // 水平
    }

    /** 后坐力修改器接口 **/
    @FunctionalInterface
    public interface RecoilModifier {
        /** 是否应用此修改器 **/
        default boolean shouldApply(RecoilType type, LivingEntity player, ItemStack itemStack) {
            return true;
        }

        /** 应用修改 **/
        double apply(double value, RecoilType type, LivingEntity player, ItemStack itemStack);
    }
}