package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 涓流充能附魔的事件处理类
 * <p>
 * 功能：接收或释放电光充能会从备弹中填装弹匣的一部分
 * <p>
 * 机制：
 * <ol>
 *   <li>接收电光充能时，为弹匣补充10%弹药</li>
 *   <li>释放电光充能时，为弹匣补充20%弹药</li>
 *   <li>弹药从备弹中扣除，如果备弹不足则补充可用的弹药</li>
 *   <li>补充的弹药量基于弹匣容量计算</li>
 *   <li>每次接收或释放电光充能都会触发，无冷却限制</li>
 * </ol>
 */
public class TrickleChargeEvent {

    /**
     * 接收电光充能事件处理
     * 为弹匣补充10%弹药
     *
     * @param player 玩家
     * @param gun 使用的枪械
     * @param chargeAmount 接收的电光充能数量
     */
    public static void onChargeReceived(Player player, ItemStack gun, int chargeAmount) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TRICKLE_CHARGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 获取枪械数据
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        if (gunIndexOpt.isEmpty()) return;

        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);

        // 计算需要补充的弹药量（弹匣容量的10%）
        double reloadPercentage = TBZServerConfig.TRICKLE_CHARGE_RECEIVE_PERCENTAGE.get();
        int ammoToReload = (int) Math.ceil(magazineSize * reloadPercentage);

        // 计算实际可补充的弹药量（不超过弹匣容量）
        int ammoNeeded = magazineSize - currentAmmo;
        int actualReload = Math.min(ammoToReload, ammoNeeded);

        if (actualReload <= 0) {
            return;
        }

        // 获取该枪械使用的弹药类型
        ResourceLocation ammoId = gunIndexOpt.get().getGunData().getAmmoId();

        // 检查玩家背包中该弹药的可用数量
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);
        if (availableAmmo <= 0) {
            return;
        }

        // 实际转移弹药量 = 取最小值(需要量, 背包可用量)
        int ammoToTransfer = Math.min(actualReload, availableAmmo);

        // 从玩家背包扣除弹药
        AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToTransfer);

        // 装填到枪械
        int newAmmo = currentAmmo + ammoToTransfer;
        iGun.setCurrentAmmoCount(gun, newAmmo);
    }

    /**
     * 释放电光充能事件处理
     * 为弹匣补充20%弹药
     *
     * @param player 玩家
     * @param gun 使用的枪械
     * @param chargeAmount 释放的电光充能数量
     */
    public static void onChargeReleased(Player player, ItemStack gun, int chargeAmount) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TRICKLE_CHARGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 获取枪械数据
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        if (gunIndexOpt.isEmpty()) return;

        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);

        // 计算需要补充的弹药量（弹匣容量的20%）
        double reloadPercentage = TBZServerConfig.TRICKLE_CHARGE_RELEASE_PERCENTAGE.get();
        int ammoToReload = (int) Math.ceil(magazineSize * reloadPercentage);

        // 计算实际可补充的弹药量（不超过弹匣容量）
        int ammoNeeded = magazineSize - currentAmmo;
        int actualReload = Math.min(ammoToReload, ammoNeeded);

        if (actualReload <= 0) {
            return;
        }

        // 获取该枪械使用的弹药类型
        ResourceLocation ammoId = gunIndexOpt.get().getGunData().getAmmoId();

        // 检查玩家背包中该弹药的可用数量
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);
        if (availableAmmo <= 0) {
            return;
        }

        // 实际转移弹药量 = 取最小值(需要量, 背包可用量)
        int ammoToTransfer = Math.min(actualReload, availableAmmo);

        // 从玩家背包扣除弹药
        AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToTransfer);

        // 装填到枪械
        int newAmmo = currentAmmo + ammoToTransfer;
        iGun.setCurrentAmmoCount(gun, newAmmo);
    }
}