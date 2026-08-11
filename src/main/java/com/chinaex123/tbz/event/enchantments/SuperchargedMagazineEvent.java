package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * 超充弹匣附魔的事件处理类
 * <p>
 * 功能：处于增幅状态时，弹药会逐渐从备弹转移到弹匣中
 * <p>
 * 机制：
 * <ol>
 *   <li>在增幅状态下，每1.5秒为弹匣补充5%的弹药</li>
 *   <li>弹药从备弹中扣除，如果备弹不足则补充可用的弹药</li>
 *   <li>补充的弹药量基于弹匣容量计算</li>
 *   <li>每次补充都会检查是否处于增幅状态</li>
 * </ol>
 */
public class SuperchargedMagazineEvent {

    /** 记录每个玩家上次补充弹药的时间戳 */
    private static final Map<UUID, Long> lastReloadTimeMap = new HashMap<>();

    /**
     * 玩家Tick事件：超充弹匣
     * 检查玩家主手的武器是否拥有超充弹匣附魔，并在满足条件时执行弹药补充
     *
     * @param player 需要检查的玩家对象
     */
    public static void onPlayerTick(Player player) {
        ItemStack mainHand = player.getMainHandItem();

        // 检查主手物品是否拥有超充弹匣附魔，如果没有则直接返回
        int enchantLevel = mainHand.getEnchantmentLevel(TBZEnchantments.SUPERCHARGED_MAGAZINE.get());
        if (enchantLevel <= 0) return;

        // 获取枪械数据
        int magazineSize = GunEnchantmentHelper.getMagazineSize(mainHand);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(mainHand);
        Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(mainHand);
        if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;

        // 如果弹匣已满，无需补充弹药，直接返回
        if (currentAmmo >= magazineSize) return;

        if (!player.hasEffect(FELEffects.AMPLIFIED.get())) return;

        // 检查是否已达到弹药补充的冷却时间
        UUID playerId = player.getUUID();
        long currentTime = System.currentTimeMillis();
        long lastReloadTime = lastReloadTimeMap.getOrDefault(playerId, 0L);
        long reloadInterval = (long) (TBZServerConfig.SUPERCHARGED_MAGAZINE_RELOAD_INTERVAL.get() * 1000);

        // 如果距离上次补充时间小于冷却间隔，则跳过本次补充
        if (currentTime - lastReloadTime < reloadInterval) return;

        // 计算应该补充的弹药数量
        double reloadPercentage = TBZServerConfig.SUPERCHARGED_MAGAZINE_RELOAD_PERCENTAGE.get();
        // 计算理论补充量 = 弹匣容量 × 补充百分比，向上取整
        int ammoToReload = (int) Math.ceil(magazineSize * reloadPercentage);
        // 计算弹匣还需要的弹药数量
        int ammoNeeded = magazineSize - currentAmmo;
        // 实际补充量取理论补充量和需求量的较小值，避免超出弹匣容量
        int actualReload = Math.min(ammoToReload, ammoNeeded);

        // 如果实际补充量小于等于0，无需补充
        if (actualReload <= 0) return;

        // 检查玩家背包中是否有足够的备弹
        ResourceLocation ammoIdValue = ammoId.get();
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoIdValue);
        if (availableAmmo <= 0) return;

        // 计算实际可从背包转移到弹匣的弹药数量（取补充量和可用备弹的较小值）
        int ammoToTransfer = Math.min(actualReload, availableAmmo);

        // 从玩家背包中消耗对应的弹药
        AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);

        // 更新枪械弹匣中的弹药数量
        int newAmmo = currentAmmo + ammoToTransfer;
        IGun iGun = GunEnchantmentHelper.getIGun(mainHand);
        if (iGun != null) {
            iGun.setCurrentAmmoCount(mainHand, newAmmo);
        }

        // 记录本次补充的时间戳，用于计算下一次补充的冷却时间
        lastReloadTimeMap.put(playerId, currentTime);
    }
}