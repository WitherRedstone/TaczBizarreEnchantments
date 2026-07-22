package com.chinaex123.tbz.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 弹药工具类
 * <p>
 * 功能：统计和扣除玩家背包中的指定类型弹药
 */
public class AmmoUtils {

    /**
     * 统计玩家背包中指定弹药类型的总数量
     * 弹药物品通过 NBT 标签中的 "AmmoId" 来识别类型
     * 弹药盒（tacz:ammo_box）会累加其包含的子弹数量
     * 创造模式下返回 Integer.MAX_VALUE（无限弹药）
     *
     * @param player 目标玩家
     * @param ammoId 弹药类型ID
     * @return 背包中该类型弹药的总数量（创造模式下为无限）
     */
    public static int countAmmoInInventory(Player player, ResourceLocation ammoId) {
        // 创造模式下返回无限弹药
        if (player.isCreative()) {
            return Integer.MAX_VALUE;
        }

        int count = 0;

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem().toString().contains("ammo")) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains("AmmoId") && tag.getString("AmmoId").equals(ammoId.toString())) {
                    // 检查是否是弹药盒（包含 AmmoCount 标签）
                    if (tag.contains("AmmoCount")) {
                        // 弹药盒：累加其包含的子弹数量
                        count += tag.getInt("AmmoCount");
                    } else {
                        // 普通弹药物品：累加物品数量
                        count += stack.getCount();
                    }
                }
            }
        }

        return count;
    }

    /**
     * 从玩家背包中扣除指定数量的弹药
     * 按照物品栏顺序依次扣除，优先消耗靠前的物品栈
     * 弹药盒（tacz:ammo_box）会减少其包含的子弹数量，而不是消耗整个弹药盒
     * 创造模式下不扣除弹药
     *
     * @param player 目标玩家
     * @param ammoId 弹药类型ID
     * @param amount 需要扣除的数量
     */
    public static void consumeAmmoFromInventory(Player player, ResourceLocation ammoId, int amount) {
        // 创造模式下不扣除弹药
        if (player.isCreative()) {
            return;
        }

        int remaining = amount;

        for (int i = 0; i < player.getInventory().getContainerSize() && remaining > 0; i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem().toString().contains("ammo")) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains("AmmoId") && tag.getString("AmmoId").equals(ammoId.toString())) {
                    // 检查是否是弹药盒（包含 AmmoCount 标签）
                    if (tag.contains("AmmoCount")) {
                        // 弹药盒：减少其包含的子弹数量
                        int ammoCount = tag.getInt("AmmoCount");
                        int toRemove = Math.min(ammoCount, remaining);
                        tag.putInt("AmmoCount", ammoCount - toRemove);
                        remaining -= toRemove;

                        // 如果弹药盒为空，则移除
                        if (tag.getInt("AmmoCount") <= 0) {
                            player.getInventory().setItem(i, ItemStack.EMPTY);
                        }
                    } else {
                        // 普通弹药物品：消耗物品数量
                        int toRemove = Math.min(stack.getCount(), remaining);
                        stack.shrink(toRemove);
                        remaining -= toRemove;

                        if (stack.isEmpty()) {
                            player.getInventory().setItem(i, ItemStack.EMPTY);
                        }
                    }
                }
            }
        }
    }
}