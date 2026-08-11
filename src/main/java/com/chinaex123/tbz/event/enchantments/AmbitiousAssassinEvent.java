package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 刺客野心附魔的事件处理类
 * <p>
 * 功能：根据填装之前完成的击杀数可过量填充弹匣
 * <p>
 * 机制：
 * <ol>
 *   <li>每击杀一个敌人增加1层连续击杀计数
 *   <li>换弹时根据累积的击杀数计算额外弹药量：基础值 + 击杀数 × 每击杀增量
 *   <li>额外弹药量受最大上限限制
 *   <li>计算后的额外弹药量暂存至枪械NBT，待弹匣装填满后自动应用
 *   <li>应用成功后重置击杀计数和暂存标记
 *   <li>若弹匣未满则保留暂存标记，等待下次满弹时应用
 * </ol>
 */
public class AmbitiousAssassinEvent {

    /** NBT存储键：待应用的刺客野心数量 */
    private static final String OVERFILL_TAG = "AmbitiousAssassinOverfill";

    /** 记录每个玩家当前的连续击杀数 */
    private static final Map<UUID, Integer> killCountMap = new ConcurrentHashMap<>();

    /**
     * 实体死亡事件：刺客野心
     * 增加当前玩家的击杀计数
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.AMBITIOUS_ASSASSIN.get());
        if (enchantLevel <= 0) return;

        UUID playerId = player.getUUID();

        // 击杀数+1
        int currentKills = killCountMap.getOrDefault(playerId, 0) + 1;
        killCountMap.put(playerId, currentKills);
    }

    /**
     * 换弹开始事件：刺客野心
     * 根据累积的击杀数计算刺客野心量，并存储到枪械NBT中，然后重置击杀计数
     *
     * @param player 换弹的玩家
     * @param gun 正在换弹的枪械
     */
    public static void onGunReload(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.AMBITIOUS_ASSASSIN.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        UUID playerId = player.getUUID();
        int kills = killCountMap.getOrDefault(playerId, 0);
        if (kills <= 0) return;

        // 检查枪械数据是否有效
        if (GunEnchantmentHelper.getMagazineSize(gun) <= 0) return;

        // 从配置获取刺客野心参数
        int baseOverfill = TBZServerConfig.AMBITIOUS_ASSASSIN_BASE_OVERFILL.get(); // 基础刺客野心
        int overfillPerKill = TBZServerConfig.AMBITIOUS_ASSASSIN_OVERFILL_PER_KILL.get(); // 每击杀额外弹药
        int maxOverfill = TBZServerConfig.AMBITIOUS_ASSASSIN_MAX_OVERFILL.get(); // 最大刺客野心上限

        // 计算总刺客野心量 = 基础值 + 击杀数 × 每击杀增量
        int totalOverfill = baseOverfill + (kills * overfillPerKill);
        totalOverfill = Math.min(totalOverfill, maxOverfill);  // 限制最大超额量

        // 将刺客野心量存入枪械NBT，待下次装填时应用
        CompoundTag tag = gun.getOrCreateTag();
        tag.putInt(OVERFILL_TAG, totalOverfill);

        // 重置击杀计数
        killCountMap.put(playerId, 0);
    }

    /**
     * 玩家Tick事件：刺客野心
     * 在弹药装填完成后调用，将刺客野心添加到弹匣中
     * 注意：仅当弹匣已满（currentAmmo >= magazineSize）时才应用刺客野心
     *
     * @param gun 枪械物品
     */
    public static void onPlayerTick(ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.AMBITIOUS_ASSASSIN.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getTag();
        if (tag == null || !tag.contains(OVERFILL_TAG)) return;

        int overfill = tag.getInt(OVERFILL_TAG);
        if (overfill <= 0) {
            tag.remove(OVERFILL_TAG);  // 清理无效标签
            return;
        }

        // 获取弹匣容量和当前弹药数量
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        if (magazineSize <= 0 || currentAmmo < 0) return;

        // 仅在弹匣已满时应用刺客野心（避免覆盖未满弹匣）
        if (currentAmmo >= magazineSize) {
            int newAmmo = magazineSize + overfill;  // 新弹药数 = 弹匣容量 + 刺客野心
            iGun.setCurrentAmmoCount(gun, newAmmo);

            tag.remove(OVERFILL_TAG);  // 应用后清除标签
        }
        // 如果弹匣未满，则保留OVERFILL_TAG，等待下次满弹时应用
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
     * 获取枪械上待应用的刺客野心数量
     *
     * @param gun 枪械物品
     * @return 刺客野心数，如果没有则返回0
     */
    public static int getPendingOverfill(ItemStack gun) {
        CompoundTag tag = gun.getTag();
        if (tag == null || !tag.contains(OVERFILL_TAG)) return 0;
        return tag.getInt(OVERFILL_TAG);
    }
}