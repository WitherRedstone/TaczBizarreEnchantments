package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.EnchantmentStatusSyncPacket;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.network.PacketDistributor;

/**
 * 武器大师附魔的事件处理类
 * <p>
 * 功能：击杀生物时短时间内提升这把武器的伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>完成击杀可获得“武器大师x1”，伤害提高15%，持续7秒</li>
 *   <li>在“武器大师”激活期间再次使用任意武器完成击杀，可获得“武器大师x2”，伤害提高25%，持续4秒</li>
 *   <li>“武器大师x2”结束后，会恢复为“武器大师x1”</li>
 *   <li>层数存储在枪械NBT中</li>
 * </ol>
 */
public class MasterOfArmsEvent {

    /** NBT存储键：当前层数 **/
    private static final String STACK_TAG = "MasterOfArmsStack";
    /** NBT存储键：效果开始时间（游戏刻） **/
    private static final String START_TIME_TAG = "MasterOfArmsStartTime";
    /** NBT存储键：是否是x2层数 **/
    private static final String IS_STACK_2_TAG = "MasterOfArmsIsStack2";

    /**
     * 枪械伤害事件：武器大师
     * 应用伤害加成
     *
     * @param event 枪械伤害事件
     * @param gun 使用的枪械
     */
    public static void onEntityHurtByGun(com.tacz.guns.api.event.common.EntityHurtByGunEvent.Pre event, ItemStack gun) {
        net.minecraft.world.entity.LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MASTER_OF_ARMS.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        int stack = tag.getInt(STACK_TAG);

        // 如果没有层数，不应用加成
        if (stack <= 0) return;

        // 获取伤害加成
        double damageBonus = getDamageBonus(stack);

        // 应用伤害加成
        float currentDamage = event.getBaseAmount();
        float newDamage = currentDamage * (float) (1.0 + damageBonus);
        event.setBaseAmount(newDamage);
    }

    /**
     * 生物死亡事件：武器大师
     * 击杀生物时增加层数
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MASTER_OF_ARMS.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        long currentTime = player.level().getGameTime();

        int currentStack = tag.getInt(STACK_TAG);
        boolean isStack2 = tag.getBoolean(IS_STACK_2_TAG);

        if (currentStack == 0) {
            // 没有层数，激活x1
            tag.putInt(STACK_TAG, 1);
            tag.putBoolean(IS_STACK_2_TAG, false);
            tag.putLong(START_TIME_TAG, currentTime);
        } else if (currentStack == 1 && !isStack2) {
            // x1期间，升级到x2
            tag.putInt(STACK_TAG, 2);
            tag.putBoolean(IS_STACK_2_TAG, true);
            tag.putLong(START_TIME_TAG, currentTime);
        } else if (currentStack == 2 && isStack2) {
            // x2期间，刷新x2时间
            tag.putLong(START_TIME_TAG, currentTime);
        }

        // 同步到客户端
        if (player instanceof ServerPlayer serverPlayer) {
            int newStack = tag.getInt(STACK_TAG);
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new EnchantmentStatusSyncPacket(player.getUUID(), "master_of_arms", newStack, currentTime, gun)
            );
        }
    }

    /**
     * 玩家Tick事件：武器大师
     * 检查效果是否过期
     *
     * @param player 玩家
     * @param gun 使用的枪械
     */
    public static void onPlayerTick(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MASTER_OF_ARMS.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentStack = tag.getInt(STACK_TAG);

        // 如果没有层数，不需要处理
        if (currentStack <= 0) return;

        long currentTime = player.level().getGameTime();
        long startTime = tag.getLong(START_TIME_TAG);
        boolean isStack2 = tag.getBoolean(IS_STACK_2_TAG);

        // 获取持续时间
        double durationSeconds = isStack2 ?
                TBZServerConfig.MASTER_OF_ARMS_STACK_2_DURATION_SECONDS.get() :
                TBZServerConfig.MASTER_OF_ARMS_STACK_1_DURATION_SECONDS.get();
        long durationTicks = (long) (durationSeconds * 20);

        // 检查效果是否过期
        if (currentTime - startTime >= durationTicks) {
            if (currentStack == 2 && isStack2) {
                // x2过期，恢复为x1
                tag.putInt(STACK_TAG, 1);
                tag.putBoolean(IS_STACK_2_TAG, false);
                tag.putLong(START_TIME_TAG, currentTime);
            } else {
                // x1过期，清除效果
                tag.putInt(STACK_TAG, 0);
                tag.remove(START_TIME_TAG);
                tag.remove(IS_STACK_2_TAG);
            }

            // 同步到客户端
            if (player instanceof ServerPlayer serverPlayer) {
                int newStack = tag.getInt(STACK_TAG);
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "master_of_arms", newStack, currentTime, gun)
                );
            }
        }
    }

    /**
     * 装备变更事件：武器大师
     * 切换到没有武器大师附魔的武器时，清除HUD显示
     *
     * @param event 装备变更事件
     */
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        net.minecraft.world.entity.LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack fromItem = event.getFrom();
        ItemStack toItem = event.getTo();

        // 检查是否从有武器大师附魔的武器切换到没有武器大师附魔的武器
        boolean fromHasMasterOfArms = !fromItem.isEmpty() && fromItem.getEnchantmentLevel(TBZEnchantments.MASTER_OF_ARMS.get()) > 0;
        boolean toHasMasterOfArms = !toItem.isEmpty() && toItem.getEnchantmentLevel(TBZEnchantments.MASTER_OF_ARMS.get()) > 0;

        // 只有从有武器大师切换到没有武器大师时才清除HUD显示
        if (fromHasMasterOfArms && !toHasMasterOfArms) {
            // 同步到客户端，清除HUD显示（但不清除NBT中的数据）
            if (player instanceof ServerPlayer serverPlayer) {
                long currentTime = player.level().getGameTime();
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "master_of_arms", 0, currentTime, fromItem)
                );
            }
        }
    }

    /**
     * 根据层数获取伤害加成
     * x1: 15%, x2: 25%
     *
     * @param stack 层数
     * @return 伤害加成比例
     */
    private static double getDamageBonus(int stack) {
        return switch (stack) {
            case 1 -> TBZServerConfig.MASTER_OF_ARMS_STACK_1_DAMAGE_BONUS.get();
            case 2 -> TBZServerConfig.MASTER_OF_ARMS_STACK_2_DAMAGE_BONUS.get();
            default -> 0.0;
        };
    }
}