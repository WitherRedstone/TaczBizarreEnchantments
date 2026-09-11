package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.EnchantmentStatusSyncPacket;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 我为人人附魔的事件处理类
 * <p>
 * 功能：命中不同的三个目标可在短时间内提高伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>命中不同的三个目标后，激活效果</li>
 *   <li>增加20%伤害，持续6秒</li>
 *   <li>生效期间不能再次续时间</li>
 *   <li>层数存储在枪械NBT中</li>
 * </ol>
 */
public class OneForAllEvent {

    /** NBT存储键：最近命中的目标ID集合 **/
    private static final String HIT_TARGETS_TAG = "OneForAllHitTargets";
    /** NBT存储键：效果激活状态 **/
    private static final String ACTIVE_TAG = "OneForAllActive";
    /** NBT存储键：效果开始时间（游戏刻） **/
    private static final String START_TIME_TAG = "OneForAllStartTime";

    /**
     * 枪械伤害事件：我为人人
     * 应用伤害加成和记录命中目标
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ONE_FOR_ALL.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        Entity target = event.getHurtEntity();
        if (target == null) return;

        // 检查效果是否激活
        boolean isActive = tag.getBoolean(ACTIVE_TAG);

        if (isActive) {
            // 效果激活中，应用伤害加成
            double damageBonus = TBZServerConfig.ONE_FOR_ALL_DAMAGE_BONUS.get();
            float currentDamage = event.getBaseAmount();
            float newDamage = currentDamage * (float) (1.0 + damageBonus);
            event.setBaseAmount(newDamage);
        } else {
            // 效果未激活，记录命中目标
            Set<UUID> hitTargets = getHitTargets(tag);
            UUID targetId = target.getUUID();

            // 如果是新目标，添加到集合中
            if (!hitTargets.contains(targetId)) {
                hitTargets.add(targetId);
                saveHitTargets(tag, hitTargets);

                // 检查是否达到激活条件
                if (hitTargets.size() >= TBZServerConfig.ONE_FOR_ALL_REQUIRED_HITS.get()) {
                    // 激活效果
                    long currentTime = player.level().getGameTime();
                    tag.putBoolean(ACTIVE_TAG, true);
                    tag.putLong(START_TIME_TAG, currentTime);

                    // 清空命中目标集合
                    saveHitTargets(tag, new HashSet<>());

                    // 同步到客户端
                    if (player instanceof ServerPlayer serverPlayer) {
                        HUDPacketHandler.INSTANCE.send(
                                PacketDistributor.PLAYER.with(() -> serverPlayer),
                                new EnchantmentStatusSyncPacket(player.getUUID(), "one_for_all", 3, currentTime, ItemStack.EMPTY)
                        );
                    }
                }
            }
        }
    }

    /**
     * 玩家Tick事件：我为人人
     * 检查效果是否过期
     *
     * @param event 玩家Tick事件
     */
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ONE_FOR_ALL.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isActive = tag.getBoolean(ACTIVE_TAG);

        // 如果效果未激活，不需要处理
        if (!isActive) return;

        long currentTime = player.level().getGameTime();
        long startTime = tag.getLong(START_TIME_TAG);

        // 检查效果是否过期
        if (currentTime - startTime >= TBZServerConfig.ONE_FOR_ALL_DURATION_SECONDS.get()) {
            // 效果过期，清除激活状态
            tag.putBoolean(ACTIVE_TAG, false);
            tag.remove(START_TIME_TAG);

            // 同步到客户端
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "one_for_all", 0, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 装备变更事件：我为人人
     * 切换到没有我为人人附魔的武器时，清除HUD显示
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

        // 检查是否从有我为人人附魔的武器切换到没有我为人人附魔的武器
        boolean fromHasOneForAll = !fromItem.isEmpty() && fromItem.getEnchantmentLevel(TBZEnchantments.ONE_FOR_ALL.get()) > 0;
        boolean toHasOneForAll = !toItem.isEmpty() && toItem.getEnchantmentLevel(TBZEnchantments.ONE_FOR_ALL.get()) > 0;

        // 只有从有我为人人切换到没有我为人人时才清除HUD显示
        if (fromHasOneForAll && !toHasOneForAll) {
            // 同步到客户端，清除HUD显示（但不清除NBT中的数据）
            if (player instanceof ServerPlayer serverPlayer) {
                long currentTime = player.level().getGameTime();
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new EnchantmentStatusSyncPacket(player.getUUID(), "one_for_all", 0, currentTime, ItemStack.EMPTY)
                );
            }
        }
    }

    /**
     * 从NBT中获取命中的目标集合
     *
     * @param tag NBT标签
     * @return 命中的目标集合
     */
    private static Set<UUID> getHitTargets(CompoundTag tag) {
        Set<UUID> hitTargets = new HashSet<>();
        if (tag.contains(HIT_TARGETS_TAG, 9)) { // 9 = List tag type
            net.minecraft.nbt.ListTag list = tag.getList(HIT_TARGETS_TAG, 11); // 11 = IntArray tag type
            for (int i = 0; i < list.size(); i++) {
                int[] uuidArray = list.getIntArray(i);
                if (uuidArray.length == 4) {
                    UUID uuid = new UUID(
                            (long) uuidArray[0] << 32 | (uuidArray[1] & 0xFFFFFFFFL),
                            (long) uuidArray[2] << 32 | (uuidArray[3] & 0xFFFFFFFFL)
                    );
                    hitTargets.add(uuid);
                }
            }
        }
        return hitTargets;
    }

    /**
     * 将命中的目标集合保存到NBT
     *
     * @param tag NBT标签
     * @param hitTargets 命中的目标集合
     */
    private static void saveHitTargets(CompoundTag tag, Set<UUID> hitTargets) {
        net.minecraft.nbt.ListTag list = new net.minecraft.nbt.ListTag();
        for (UUID uuid : hitTargets) {
            long mostSigBits = uuid.getMostSignificantBits();
            long leastSigBits = uuid.getLeastSignificantBits();
            int[] uuidArray = new int[]{
                    (int) (mostSigBits >> 32),
                    (int) mostSigBits,
                    (int) (leastSigBits >> 32),
                    (int) leastSigBits
            };
            list.add(new net.minecraft.nbt.IntArrayTag(uuidArray));
        }
        tag.put(HIT_TARGETS_TAG, list);
    }
}