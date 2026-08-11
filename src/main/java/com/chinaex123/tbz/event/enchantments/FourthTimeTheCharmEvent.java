package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.network.hud.TriggeredEnchantmentSyncPacket;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.chinaex123.tbz.utils.ShotTriggerHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 事不过四附魔的事件处理类
 * <p>
 * 功能：快速精准命中目标会向弹匣里返还两枚弹药
 * <p>
 * 机制：
 * <ol>
 *   <li>每次爆头命中时记录当前游戏刻时间戳</li>
 *   <li>定期清理超出时间窗口的旧记录（时间窗口从配置读取）</li>
 *   <li>统计时间窗口内的爆头总数，达到配置要求的数量时触发效果</li>
 *   <li>触发后回复固定数量的弹药到弹匣（不超过弹匣容量上限）</li>
 *   <li>触发后立即清空该玩家的所有爆头记录，防止连续触发</li>
 *   <li>若弹匣已满则不回复弹药，但爆头记录仍会被清空</li>
 *   <li>时间窗口和所需爆头次数均可通过配置调整</li>
 *   <li>每个玩家独立维护爆头记录列表，互不干扰</li>
 *   <li>每次射击只触发一次，防止霰弹枪多次触发</li>
 * </ol>
 */
public class FourthTimeTheCharmEvent {

    /** NBT存储键：射击触发标签前缀 */
    private static final String TRIGGER_TAG_PREFIX = "FourthTimeTheCharm";

    /** 记录每个玩家的爆头时间戳列表 */
    private static final Map<UUID, List<Long>> headshotTimesMap = new ConcurrentHashMap<>();

    /**
     * 枪械伤害事件：事不过四
     * 检测爆头并记录时间，在满足条件时触发弹药回复
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FOURTH_TIME_THE_CHARM.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 检查当前射击是否已触发
        if (ShotTriggerHelper.checkAndMarkTriggered(gun, TRIGGER_TAG_PREFIX)) {
            return;
        }

        UUID playerId = player.getUUID();
        long currentTime = player.level().getGameTime();  // 使用游戏刻作为时间单位

        // 获取或创建该玩家的爆头时间记录列表
        List<Long> headshotTimes = headshotTimesMap.computeIfAbsent(playerId, k -> new ArrayList<>());
        headshotTimes.add(currentTime);  // 记录本次爆头时间

        // 从配置获取时间窗口（刻）和所需爆头次数
        int timeWindow = TBZServerConfig.FOURTH_TIME_THE_CHARM_TIME_WINDOW.get();
        int requiredHits = TBZServerConfig.FOURTH_TIME_THE_CHARM_HIT_COUNT.get();

        // 清理超出时间窗口的旧记录
        headshotTimes.removeIf(time -> currentTime - time > timeWindow);

        // 检查是否达到触发条件
        if (headshotTimes.size() >= requiredHits) {
            addAmmo(gun, iGun); // 回复弹药
            headshotTimes.clear(); // 重置爆头记录，防止连续触发

            // 同步到客户端，显示事不过四触发
            if (player instanceof ServerPlayer serverPlayer) {
                HUDPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new TriggeredEnchantmentSyncPacket(player.getUUID(), "fourth_time_the_charm", currentTime)
                );
            }
        }
    }

    /**
     * 添加弹药到枪械
     * 根据配置回复指定数量的弹药，但不超过弹匣容量上限
     *
     * @param gun  枪械物品
     * @param iGun 枪械接口实例
     */
    private static void addAmmo(ItemStack gun, IGun iGun) {
        // 获取枪械数据以读取弹匣容量
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        if (magazineSize <= 0 || currentAmmo < 0) return;

        // 获取每次触发回复的弹药量（从配置读取）
        int ammoToReturn = TBZServerConfig.FOURTH_TIME_THE_CHARM_AMMO_RETURN.get();

        // 仅在未达到弹匣容量时添加弹药（避免溢出）
        if (currentAmmo < magazineSize) {
            int newAmmo = Math.min(currentAmmo + ammoToReturn, magazineSize);
            iGun.setCurrentAmmoCount(gun, newAmmo);
        }
        // 如果弹匣已满，则不回复弹药
    }

    /**
     * 清除玩家数据（用于玩家退出等场景，防止内存泄漏）
     *
     * @param playerId 玩家UUID
     */
    public static void clearPlayerData(UUID playerId) {
        headshotTimesMap.remove(playerId);
    }

    /**
     * 获取玩家在时间窗口内的最近爆头次数
     * 用于调试或显示UI
     *
     * @param playerId    玩家UUID
     * @param currentTime 当前游戏时间（刻）
     * @return 时间窗口内的爆头次数
     */
    public static int getRecentHeadshotCount(UUID playerId, long currentTime) {
        List<Long> headshotTimes = headshotTimesMap.get(playerId);
        if (headshotTimes == null || headshotTimes.isEmpty()) return 0;

        int timeWindow = TBZServerConfig.FOURTH_TIME_THE_CHARM_TIME_WINDOW.get();
        // 统计仍在时间窗口内的爆头数量
        return (int) headshotTimes.stream()
                .filter(time -> currentTime - time <= timeWindow)
                .count();
    }
}