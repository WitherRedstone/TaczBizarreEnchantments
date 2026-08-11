package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.EnchantmentStatusSyncPacket;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.utils.ShotTriggerHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.network.PacketDistributor;

/**
 * 爆炸光能附魔的事件处理类
 * <p>
 * 功能：每拾取25点经验都会增加下一枚射弹的伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家拾取经验球时累计经验值</li>
 *   <li>每25点经验值自动增加1层（最多6层）</li>
 *   <li>每层提供35%伤害加成（但每次只消耗1层）</li>
 *   <li>射击命中敌人后消耗1层</li>
 *   <li>切换武器时隐藏HUD但保留NBT数据</li>
 * </ol>
 */
public class ExplosiveLightEvent {

    /** NBT存储键：累计经验值 **/
    private static final String ACCUMULATED_XP_TAG = "explosive_light_accumulated_xp";
    /** NBT存储键：当前层数 **/
    private static final String STACKS_TAG = "explosive_light_stacks";
    /** 射击触发标签前缀 **/
    private static final String TRIGGER_TAG_PREFIX = "ExplosiveLight";

    /**
     * 玩家拾取经验值事件：爆炸光能
     * 累计经验值，每25点经验值增加1层
     *
     * @param event 玩家经验值拾取事件
     */
    public static void onPlayerPickupXp(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有爆炸光能附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_LIGHT.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 从配置读取参数
        int xpPerStack = TBZServerConfig.EXPLOSIVE_LIGHT_XP_PER_STACK.get();
        int maxStacks = TBZServerConfig.EXPLOSIVE_LIGHT_MAX_STACKS.get();

        CompoundTag tag = gun.getOrCreateTag();
        int accumulatedXp = tag.getInt(ACCUMULATED_XP_TAG);
        int stacks = tag.getInt(STACKS_TAG);

        // 如果已达到最大层数，不再累计经验值
        if (stacks >= maxStacks) {
            return;
        }

        // 累加经验值
        int xpGained = event.getOrb().getValue();
        accumulatedXp += xpGained;

        // 计算可以增加的层数
        int stacksToAdd = Math.min(accumulatedXp / xpPerStack, maxStacks - stacks);

        // 更新层数和经验值
        if (stacksToAdd > 0) {
            stacks += stacksToAdd;
            accumulatedXp -= stacksToAdd * xpPerStack;
        }

        // 保存到NBT
        tag.putInt(ACCUMULATED_XP_TAG, accumulatedXp);
        tag.putInt(STACKS_TAG, stacks);

        // 同步到客户端HUD
        long currentTime = player.level().getGameTime();
        int combinedValue = (stacks << 16) | (accumulatedXp & 0xFFFF);
        if (player instanceof ServerPlayer serverPlayer) {
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new EnchantmentStatusSyncPacket(player.getUUID(), "explosive_light", combinedValue, currentTime, ItemStack.EMPTY)
            );
        }
    }

    /**
     * 枪械伤害事件：爆炸光能
     * 如果有层数，应用伤害加成并消耗1层
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有爆炸光能附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_LIGHT.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int stacks = tag.getInt(STACKS_TAG);

        // 如果有层数，应用伤害加成
        if (stacks > 0) {
            // 从配置获取每层伤害加成比例
            double damageBonus = TBZServerConfig.EXPLOSIVE_LIGHT_DAMAGE_BONUS.get();
            float baseDamage = event.getBaseAmount();
            // 计算额外伤害：基础伤害 × 伤害加成（每次只消耗1层）
            float bonusDamage = (float) (baseDamage * damageBonus);
            event.setBaseAmount(baseDamage + bonusDamage);

            // 消耗1层
            stacks--;
            tag.putInt(STACKS_TAG, stacks);

            // 标记当前射击已处理（防止爆炸伤害重复消耗）
            ShotTriggerHelper.checkAndMarkTriggered(gun, TRIGGER_TAG_PREFIX);

            // 同步到客户端HUD
            long currentTime = player.level().getGameTime();
            int combinedValue = (stacks << 16) | (tag.getInt(ACCUMULATED_XP_TAG) & 0xFFFF);
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "explosive_light", combinedValue, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 通用伤害事件：爆炸光能
     * 处理爆炸伤害加成
     *
     * @param event 伤害事件
     */
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        // 检查伤害来源是否是玩家
        if (source.getEntity() == null || !(source.getEntity() instanceof Player player)) return;

        // 检查伤害来源是否是爆炸伤害
        String msgId = source.getMsgId();
        if (!msgId.contains("explosion")) {
            return;
        }

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_LIGHT.get());
        if (enchantLevel <= 0) {
            return;
        }

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int stacks = tag.getInt(STACKS_TAG);

        // 检查当前射击是否已处理（防止重复消耗层数）
        boolean alreadyProcessed = ShotTriggerHelper.checkAndMarkTriggered(gun, TRIGGER_TAG_PREFIX);

        // 如果有层数，应用伤害加成
        if (stacks > 0) {
            // 从配置获取每层伤害加成比例
            double damageBonus = TBZServerConfig.EXPLOSIVE_LIGHT_DAMAGE_BONUS.get();
            float baseDamage = event.getAmount();
            // 计算额外伤害：基础伤害 × 伤害加成（每次只消耗1层）
            float bonusDamage = (float) (baseDamage * damageBonus);
            float newDamage = baseDamage + bonusDamage;
            event.setAmount(newDamage);

            // 只有未处理过才消耗层数
            if (!alreadyProcessed) {
                stacks--;
                tag.putInt(STACKS_TAG, stacks);
            }

            // 同步到客户端HUD
            long currentTime = player.level().getGameTime();
            int combinedValue = (stacks << 16) | (tag.getInt(ACCUMULATED_XP_TAG) & 0xFFFF);
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "explosive_light", combinedValue, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 装备变更事件：爆炸光能
     * 切换武器时隐藏HUD显示，但保留NBT数据
     * 切换到有爆炸光能的武器时，重新显示HUD
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

        // 检查是否从有爆炸光能附魔的武器切换到没有爆炸光能附魔的武器
        boolean fromHasExplosiveLight = !fromItem.isEmpty() && fromItem.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_LIGHT.get()) > 0;
        boolean toHasExplosiveLight = !toItem.isEmpty() && toItem.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_LIGHT.get()) > 0;

        if (fromHasExplosiveLight && !toHasExplosiveLight) {
            // 从有爆炸光能切换到没有爆炸光能：清除HUD显示
            if (player instanceof ServerPlayer serverPlayer) {
                long currentTime = player.level().getGameTime();
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "explosive_light", 0, currentTime, fromItem)
                );
            }
        } else if (!fromHasExplosiveLight && toHasExplosiveLight) {
            // 从没有爆炸光能切换到有爆炸光能：重新显示HUD
            CompoundTag tag = toItem.getOrCreateTag();
            int stacks = tag.getInt(STACKS_TAG);
            int accumulatedXp = tag.getInt(ACCUMULATED_XP_TAG);
            int combinedValue = (stacks << 16) | (accumulatedXp & 0xFFFF);

            if (player instanceof ServerPlayer serverPlayer) {
                long currentTime = player.level().getGameTime();
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "explosive_light", combinedValue, currentTime, toItem)
                );
            }
        }
    }
}