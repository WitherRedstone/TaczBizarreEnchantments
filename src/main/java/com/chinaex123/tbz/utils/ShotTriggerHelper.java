package com.chinaex123.tbz.utils;

import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/**
 * 射击触发辅助类
 * <p>
 * 功能：处理霰弹枪等武器每次射击触发多次效果的问题
 */
public class ShotTriggerHelper {

    /**
     * 检查并标记当前射击是否已触发效果
     *
     * @param gun 枪械物品
     * @param tagPrefix 附魔专用的标签前缀（避免不同附魔冲突）
     * @return true=已触发（跳过），false=未触发（可以执行效果）
     */
    public static boolean checkAndMarkTriggered(ItemStack gun, String tagPrefix) {
        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return false;

        CompoundTag tag = gun.getOrCreateTag();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt(tagPrefix + "PrevAmmo");
        tag.putInt(tagPrefix + "PrevAmmo", currentAmmo);

        // 检测射击：弹药减少时重置触发标志
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            tag.putBoolean(tagPrefix + "Triggered", false);
        }

        // 检查当前射击是否已触发
        if (tag.getBoolean(tagPrefix + "Triggered")) {
            return true;
        }

        // 标记当前射击已触发
        tag.putBoolean(tagPrefix + "Triggered", true);
        return false;
    }

    /**
     * 强制重置触发状态
     *
     * @param gun       枪械物品
     * @param tagPrefix 附魔专用的标签前缀
     */
    public static void resetTrigger(ItemStack gun, String tagPrefix) {
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(tagPrefix + "Triggered", false);
    }
}