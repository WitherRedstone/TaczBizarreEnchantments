package com.chinaex123.tbz.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/** 弹药工具类 - 统计和扣除玩家背包中的指定类型弹药 **/
public class AmmoUtils {

    /**
     * 统计玩家背包中指定弹药类型的总数量
     * 弹药物品通过 NBT 标签中的 "AmmoId" 来识别类型
     *
     * @param player 目标玩家
     * @param ammoId 弹药类型ID
     * @return 背包中该类型弹药的总数量
     */
    public static int countAmmoInInventory(Player player, ResourceLocation ammoId) {
        int count = 0;

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem().toString().contains("ammo")) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains("AmmoId") && tag.getString("AmmoId").equals(ammoId.toString())) {
                    count += stack.getCount();
                }
            }
        }

        return count;
    }

    /**
     * 从玩家背包中扣除指定数量的弹药
     * 按照物品栏顺序依次扣除，优先消耗靠前的物品栈
     *
     * @param player 目标玩家
     * @param ammoId 弹药类型ID
     * @param amount 需要扣除的数量
     */
    public static void consumeAmmoFromInventory(Player player, ResourceLocation ammoId, int amount) {
        int remaining = amount;

        for (int i = 0; i < player.getInventory().getContainerSize() && remaining > 0; i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem().toString().contains("ammo")) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains("AmmoId") && tag.getString("AmmoId").equals(ammoId.toString())) {
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