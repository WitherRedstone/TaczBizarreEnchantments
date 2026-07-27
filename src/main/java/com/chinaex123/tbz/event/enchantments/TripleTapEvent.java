package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ShotTriggerHelper;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 精准连击附魔的事件处理类
 * <p>
 * 功能：快速精准命中目标会向弹匣里填装一枚弹药
 * 机制：
 * 1. 每次爆头命中时记录当前游戏刻时间戳
 * 2. 定期清理超出时间窗口的旧记录（时间窗口从配置读取）
 * 3. 统计时间窗口内的爆头总数，达到配置要求的数量时触发效果
 * 4. 触发后回复1发弹药到弹匣（不超过弹匣容量上限）
 * 5. 触发后立即清空该玩家的所有爆头记录，防止连续触发
 * 6. 若弹匣已满则不回复弹药，但爆头记录仍会被清空
 * 7. 时间窗口和所需爆头次数均可通过配置调整
 * 8. 每个玩家独立维护爆头记录列表，互不干扰
 * 9. 每次射击只触发一次，防止霰弹枪多次触发
 */
public class TripleTapEvent {

    /** 射击触发标签前缀 */
    private static final String TRIGGER_TAG_PREFIX = "TripleTap";

    /** 记录每个玩家的爆头时间戳列表 */
    private static final Map<UUID, List<Long>> headshotTimesMap = new ConcurrentHashMap<>();

    /**
     * 枪械伤害事件：精准连击
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TRIPLE_TAP.get());
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
        int timeWindow = TBZServerConfig.TRIPLE_TAP_TIME_WINDOW.get();
        int requiredHits = TBZServerConfig.TRIPLE_TAP_HIT_COUNT.get();

        // 清理超出时间窗口的旧记录
        headshotTimes.removeIf(time -> currentTime - time > timeWindow);

        // 检查是否达到触发条件
        if (headshotTimes.size() >= requiredHits) {
            addAmmo(gun, iGun); // 回复弹药
            headshotTimes.clear(); // 重置爆头记录，防止连续触发
        }
    }

    /**
     * 添加弹药到枪械
     * 回复1发弹药，但不超过弹匣容量上限
     *
     * @param gun  枪械物品
     * @param iGun 枪械接口实例
     */
    private static void addAmmo(ItemStack gun, IGun iGun) {
        // 获取枪械数据以读取弹匣容量
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        if (gunIndexOpt.isEmpty()) return;

        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);

        // 仅在未达到弹匣容量时添加弹药
        if (currentAmmo < magazineSize) {
            iGun.setCurrentAmmoCount(gun, currentAmmo + 1);
        }
        // 如果弹匣已满，则不回复弹药
    }

    /**
     * 清除玩家数据
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

        int timeWindow = TBZServerConfig.TRIPLE_TAP_TIME_WINDOW.get();
        // 统计仍在时间窗口内的爆头数量
        return (int) headshotTimes.stream()
                .filter(time -> currentTime - time <= timeWindow)
                .count();
    }
}