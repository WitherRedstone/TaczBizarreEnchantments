package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.EnchantmentStatusSyncPacket;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.network.PacketDistributor;

/**
 * 斗剑士附魔的事件处理类
 * <p>
 * 功能：击杀生物后增加对目标的伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>击杀生物叠加一层，上限5层</li>
 *   <li>未击杀生物时每2.5秒降低一层</li>
 *   <li>伤害加成：1层6.3%，2层13.3%，3层20%，4层26.6%，5层33.3%</li>
 *   <li>层数存储在枪械NBT中</li>
 * </ol>
 */
public class SwashbucklerEvent {

    /** NBT存储键：当前层数 */
    private static final String STACK_TAG = "SwashbucklerStack";
    /** NBT存储键：上次击杀时间（游戏刻） */
    private static final String LAST_KILL_TIME_TAG = "SwashbucklerLastKillTime";

    /**
     * 生物死亡事件：斗剑士
     * 击杀生物时增加层数
     *
     * @param event 生物死亡事件
     */
    public static void onLivingDeath(LivingDeathEvent event) {
        // 检查攻击者是否是玩家
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SWASHBUCKLER.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        long currentTime = player.level().getGameTime();

        // 增加层数
        int currentStack = tag.getInt(STACK_TAG);
        int maxStacks = TBZServerConfig.SWASHBUCKLER_MAX_STACKS.get();
        int newStack = Math.min(currentStack + 1, maxStacks);
        tag.putInt(STACK_TAG, newStack);
        tag.putLong(LAST_KILL_TIME_TAG, currentTime);

        // 同步到客户端
        if (player instanceof ServerPlayer serverPlayer) {
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new EnchantmentStatusSyncPacket(player.getUUID(), "swashbuckler", newStack, currentTime, ItemStack.EMPTY)
            );
        }
    }

    /**
     * 枪械伤害事件：斗剑士
     * 应用伤害加成
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SWASHBUCKLER.get());
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
     * 玩家Tick事件：斗剑士
     * 定期检查并降低层数
     *
     * @param event 玩家Tick事件
     */
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SWASHBUCKLER.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentStack = tag.getInt(STACK_TAG);

        // 如果没有层数，不需要处理
        if (currentStack <= 0) return;

        long currentTime = player.level().getGameTime();
        long lastKillTime = tag.getLong(LAST_KILL_TIME_TAG);

        // 检查是否超时
        if (currentTime - lastKillTime >= TBZServerConfig.SWASHBUCKLER_DECREASE_INTERVAL_TICKS.get()) {
            // 超时，清空所有层数
            tag.putInt(STACK_TAG, 0);
            tag.putLong(LAST_KILL_TIME_TAG, currentTime);

            // 同步到客户端
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "swashbuckler", 0, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 装备变更事件：斗剑士
     * 切换到没有斗剑士附魔的武器时，清除HUD显示
     *
     * @param event 装备变更事件
     */
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        // 只处理主手装备变更
        if (event.getSlot() != EquipmentSlot.MAINHAND) return;

        ItemStack fromItem = event.getFrom();
        ItemStack toItem = event.getTo();

        // 检查是否从有斗剑士附魔的武器切换到没有斗剑士附魔的武器
        boolean fromHasSwashbuckler = !fromItem.isEmpty() && fromItem.getEnchantmentLevel(TBZEnchantments.SWASHBUCKLER.get()) > 0;
        boolean toHasSwashbuckler = !toItem.isEmpty() && toItem.getEnchantmentLevel(TBZEnchantments.SWASHBUCKLER.get()) > 0;

        // 只有从有斗剑士切换到没有斗剑士时才清除HUD显示
        if (fromHasSwashbuckler && !toHasSwashbuckler) {
            // 同步到客户端，清除HUD显示（但不清除NBT中的层数）
            if (player instanceof ServerPlayer serverPlayer) {
                long currentTime = player.level().getGameTime();
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "swashbuckler", 0, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 根据层数获取伤害加成
     * 1层6.3%，2层13.3%，3层20%，4层26.6%，5层33.3%
     *
     * @param stack 层数
     * @return 伤害加成比例
     */
    private static double getDamageBonus(int stack) {
        return switch (stack) {
            case 1 -> 0.063;
            case 2 -> 0.133;
            case 3 -> 0.20;
            case 4 -> 0.266;
            case 5 -> 0.333;
            default -> 0.0;
        };
    }
}