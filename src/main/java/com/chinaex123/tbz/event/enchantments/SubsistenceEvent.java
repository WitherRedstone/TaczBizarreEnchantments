package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 维持生计附魔的事件处理类
 * <p>
 * 功能：消灭目标会使弹药从储存弹药中转移并填装部分弹匣
 * <p>
 * 机制：
 * <ol>
 *   <li>每次击杀敌人增加1层连续击杀计数</li>
 *   <li>击杀计数达到配置的阈值时触发弹药补充效果</li>
 *   <li>触发后重置击杀计数，开始新一轮累计</li>
 *   <li>弹药补充量计算：
 *     <ol type="a">
 *       <li>根据附魔等级计算补充百分比：基础百分比 + (等级 - 1) × 每级增量</li>
 *       <li>补充弹药量 = 弹匣容量 × 补充百分比（至少1发）</li>
 *       <li>不超过弹匣剩余空间和背包可用弹药量</li>
 *     </ol>
 *   </li>
 *   <li>从玩家背包扣除对应弹药并装填到枪械</li>
 *   <li>若弹匣已满或背包无弹药则不补充</li>
 *   <li>每个玩家独立维护击杀计数，互不干扰</li>
 * </ol>
 */
public class SubsistenceEvent {

    /** 记录每个玩家当前的连续击杀数 */
    private static final Map<UUID, Integer> killCountMap = new ConcurrentHashMap<>();

    /**
     * 实体死亡事件：维持生计
     * 累计击杀数，达到阈值时触发弹药补充
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SUBSISTENCE.get());
        if (enchantLevel <= 0) {
            return;
        }

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) {
            return;
        }

        UUID playerId = player.getUUID();
        // 击杀数+1
        int currentKills = killCountMap.getOrDefault(playerId, 0) + 1;
        killCountMap.put(playerId, currentKills);

        // 获取触发弹药补充所需的击杀阈值（从配置读取）
        int threshold = TBZServerConfig.SUBSISTENCE_KILL_THRESHOLD.get();

        // 未达到阈值，继续累积
        if (currentKills < threshold) {
            return;
        }

        // 达到阈值，重置击杀计数
        killCountMap.put(playerId, 0);

        // 获取枪械数据
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(gun);
        if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;

        int ammoNeeded = magazineSize - currentAmmo;  // 需要补充的弹药量

        // 弹匣已满，无需补充
        if (ammoNeeded <= 0) {
            return;
        }

        // 检查玩家背包中该弹药的可用数量
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId.get());
        if (availableAmmo <= 0) {
            return;
        }

        // 根据附魔等级计算应补充的弹药百分比
        int percentage = getAmmoPercentage(enchantLevel);

        // 计算理论补充弹药量 = 弹匣容量 × 百分比
        // 限制：至少1发，最多不超过需要量
        int ammoToTransfer = Math.min(ammoNeeded, Math.max(1, (int)(magazineSize * percentage / 100.0)));
        // 再限制：不超过背包可用弹药量
        ammoToTransfer = Math.min(ammoToTransfer, availableAmmo);

        // 从玩家背包扣除弹药
        ResourceLocation ammoIdValue = ammoId.get();
        AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);

        // 装填到枪械
        int newAmmo = currentAmmo + ammoToTransfer;
        iGun.setCurrentAmmoCount(gun, newAmmo);
    }

    /**
     * 清除玩家的击杀计数
     *
     * @param playerId 玩家UUID
     */
    public static void clearKillCount(UUID playerId) {
        killCountMap.remove(playerId);
    }

    /**
     * 获取玩家的当前击杀计数
     *
     * @param playerId 玩家UUID
     * @return 当前连续击杀数
     */
    public static int getKillCount(UUID playerId) {
        return killCountMap.getOrDefault(playerId, 0);
    }

    /**
     * 根据附魔等级计算弹药补充百分比
     * 公式：基础百分比 + (等级 - 1) × 每级增量
     *
     * @param level 附魔等级
     * @return 弹药补充百分比（0-100）
     */
    private static int getAmmoPercentage(int level) {
        int basePercentage = TBZServerConfig.SUBSISTENCE_BASE_AMMO_PERCENTAGE.get();
        int incrementPerLevel = TBZServerConfig.SUBSISTENCE_AMMO_PERCENTAGE_PER_LEVEL.get();
        return basePercentage + (level - 1) * incrementPerLevel;
    }
}