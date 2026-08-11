package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.Random;

/**
 * 小丑皇弹药筒附魔的事件处理类
 * <p>
 * 功能：装填时随机从备弹中多填装弹药
 * <p>
 * 机制：
 * <ol>
 *   <li>监听枪械装填完成事件</li>
 *   <li>计算弹匣容量的10%-50%之间的随机值</li>
 *   <li>从玩家背包中扣除对应弹药</li>
 *   <li>超量装填到枪械中</li>
 * </ol>
 */
public class ClownCartridgeEvent {

    /** 随机数生成器 **/
    private static final Random RANDOM = new Random();
    /** NBT存储键：超量装填数量 **/
    private static final String OVERFILL_TAG = "ClownCartridgeOverfill";

    /**
     * 枪械装填事件处理 - 小丑皇弹药筒
     * 装填完成后随机从备弹中多填装弹药
     *
     * @param event 枪械装填事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有小丑皇弹药筒附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.CLOWN_CARTRIDGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 获取枪械数据
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(gun);
        if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;

        // 检查玩家背包中该弹药的可用数量
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId.get());
        if (availableAmmo <= 0) return;

        // 从配置读取百分比范围
        double minPercentage = TBZServerConfig.CLOWN_CARTRIDGE_MIN_PERCENTAGE.get();
        double maxPercentage = TBZServerConfig.CLOWN_CARTRIDGE_MAX_PERCENTAGE.get();
        // 计算额外装填的弹药量
        int extraAmmo = calculateExtraAmmo(magazineSize, minPercentage, maxPercentage);

        if (extraAmmo <= 0) return;

        // 实际转移弹药量 = 取最小值(额外装填量, 背包可用量)
        int ammoToTransfer = Math.min(extraAmmo, availableAmmo);

        // 从玩家背包扣除弹药
        ResourceLocation ammoIdValue = ammoId.get();
        AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);

        // 存储超量装填数量到NBT标签
        CompoundTag tag = gun.getOrCreateTag();
        tag.putInt(OVERFILL_TAG, ammoToTransfer);
    }

    /**
     * 玩家Tick事件：应用超量装填
     * 在弹匣已满时将超量装填添加到弹匣中
     *
     * @param gun 枪械物品
     */
    public static void onPlayerTick(ItemStack gun) {
        // 检查是否有小丑皇弹药筒附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.CLOWN_CARTRIDGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getTag();
        if (tag == null || !tag.contains(OVERFILL_TAG)) return;

        int overfill = tag.getInt(OVERFILL_TAG);
        if (overfill <= 0) {
            tag.remove(OVERFILL_TAG);
            return;
        }

        // 获取弹匣容量和当前弹药数量
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        if (magazineSize <= 0 || currentAmmo < 0) return;

        // 仅在弹匣已满时应用超量装填
        if (currentAmmo >= magazineSize) {
            int newAmmo = magazineSize + overfill;
            iGun.setCurrentAmmoCount(gun, newAmmo);
            tag.remove(OVERFILL_TAG);
        }
    }

    /**
     * 计算额外装填的弹药量
     * <p>
     * 对于多弹匣武器：计算弹匣容量的 minPercentage-maxPercentage 之间的随机值
     * 对于单发武器（弹匣容量=1）：80%概率装填2发，20%概率装填3发
     *
     * @param magazineSize    弹匣容量
     * @param minPercentage   最小百分比（0.1表示10%）
     * @param maxPercentage   最大百分比（0.5表示50%）
     * @return 额外装填的弹药量
     */
    private static int calculateExtraAmmo(int magazineSize, double minPercentage, double maxPercentage) {
        if (magazineSize <= 0) {
            return 0;
        }

        // 单发武器（弹匣容量=1）：80%概率额外装填1发，20%概率额外装填2发
        if (magazineSize == 1) {
            double chance = RANDOM.nextDouble();
            return chance < 0.8 ? 1 : 2;
        }

        // 多弹匣武器：计算随机百分比
        double randomPercentage = minPercentage + (maxPercentage - minPercentage) * RANDOM.nextDouble();
        return (int) (magazineSize * randomPercentage);
    }
}