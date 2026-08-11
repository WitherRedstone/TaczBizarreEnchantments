package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.server.AmmoHitBlockEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * 边打边劫附魔的事件处理类
 * <p>
 * 功能：子弹击中方块时，自动拾取附近的掉落物和经验球
 * <p>
 * 机制：
 * <ol>
 *   <li>子弹击中任意方块时触发效果</li>
 *   <li>在击中位置周围指定范围内搜索掉落物和经验球</li>
 *   <li>每个物品按配置的几率判定是否拾取</li>
 *   <li>拾取的物品直接进入玩家背包，经验球直接给予玩家经验</li>
 *   <li>拾取范围、几率和是否拾取经验球均可配置</li>
 * </ol>
 */
public class ShootTpLootEvent {

    /**
     * 子弹击中方块事件 - 边打边劫
     * 在子弹命中位置拾取范围内的掉落物和经验球
     *
     * @param event 子弹击中方块事件
     */
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {
        // 获取子弹的发射者
        Entity owner = event.getAmmo().getOwner();
        if (!(owner instanceof Player player)) {
            return;
        }

        // 获取玩家主手武器
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) {
            return;
        }

        // 检查是否为枪械
        if (IGun.getIGunOrNull(gun) == null) {
            return;
        }

        // 检查是否有边打边劫附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SHOOT_TP_LOOT.get());
        if (enchantLevel <= 0) {
            return;
        }

        try {
            // 获取子弹命中位置
            Vec3 hitPos = event.getHitResult().getLocation();

            double pickupRange = TBZServerConfig.SHOOT_TP_LOOT_PICKUP_RANGE.get();
            boolean canPickupXpOrb = TBZServerConfig.SHOOT_TP_LOOT_CAN_PICKUP_XP_ORB.get();
            boolean limitOneItemType = TBZServerConfig.SHOOT_TP_LOOT_LIMIT_ONE_ITEM_TYPE.get();

            // 创建搜索区域（以命中位置为中心的立方体区域）
            AABB searchArea = new AABB(
                    hitPos.x - pickupRange, hitPos.y - pickupRange, hitPos.z - pickupRange,
                    hitPos.x + pickupRange, hitPos.y + pickupRange, hitPos.z + pickupRange
            );

            Item allowedItemType = null;
            for (ItemEntity itemEntity : player.level().getEntities(EntityType.ITEM, searchArea, e -> true)) {
                ItemStack itemStack = itemEntity.getItem();
                if (itemStack.isEmpty()) {
                    continue;
                }

                // 根据配置的几率判定是否拾取
                float pickupChance = TBZServerConfig.SHOOT_TP_LOOT_PICKUP_CHANCE.get().floatValue();
                if (player.level().random.nextFloat() > pickupChance) {
                    continue;
                }

                // 限制物品种类：只拾取一种物品（数量不限）
                if (limitOneItemType) {
                    net.minecraft.world.item.Item currentItemType = itemStack.getItem();
                    if (allowedItemType == null) {
                        allowedItemType = currentItemType;
                    } else if (currentItemType != allowedItemType) {
                        continue;
                    }
                }

                // 尝试将物品加入玩家背包
                if (!player.getInventory().add(itemStack.copy())) {
                    // 背包已满，跳过该物品
                    continue;
                }

                // 拾取成功，移除地上的物品实体
                itemEntity.discard();
            }

            if (canPickupXpOrb) {
                for (ExperienceOrb xpOrb : player.level().getEntities(EntityType.EXPERIENCE_ORB, searchArea, e -> true)) {
                    // 根据配置的几率判定是否拾取
                    float pickupChance = TBZServerConfig.SHOOT_TP_LOOT_PICKUP_CHANCE.get().floatValue();
                    if (player.level().random.nextFloat() > pickupChance) {
                        continue;
                    }

                    // 获取经验值并给予玩家
                    int xpValue = xpOrb.getValue();
                    player.giveExperiencePoints(xpValue);
                    // 移除经验球实体
                    xpOrb.discard();
                }
            }
        } catch (Exception e) {
            // ，避免影响游戏运行
        }
    }
}