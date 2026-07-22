package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.network.GunReloadSpeedPacket;
import com.chinaex123.tbz.network.PacketHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

/**
 * 枪械换弹速度辅助工具类
 * <p>
 * 提供统一的NBT操作方法来管理换弹加速相关的标记和时间数据
 */
public class GunReloadSpeedHelper {

    /**
     * 记录命中事件
     * 在武器NBT中设置命中标记和当前游戏时间
     *
     * @param gun 武器物品
     * @param player 玩家对象
     * @param hitTag 命中标记的NBT键名
     * @param timeTag 时间戳的NBT键名
     */
    public static void recordHit(ItemStack gun, Player player, String hitTag, String timeTag) {
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(hitTag, true);
        tag.putLong(timeTag, player.level().getGameTime());
    }

    /**
     * 验证击杀并设置换弹加速标记
     * 检查命中标记是否在有效时间窗口内，如果是则设置加速标记
     *
     * @param gun 武器物品
     * @param player 玩家对象
     * @param hitTag 命中标记的NBT键名
     * @param speedTag 加速标记的NBT键名
     * @param timeTag 时间戳的NBT键名
     * @param validTicks 有效时间窗口（游戏刻）
     */
    public static void validateKillAndSetSpeed(ItemStack gun, Player player, String hitTag, String speedTag, String timeTag, int validTicks) {
        CompoundTag tag = gun.getOrCreateTag();

        // 如果没有命中标记，直接返回
        if (!tag.getBoolean(hitTag)) {
            return;
        }

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(timeTag);

        // 检查是否超过有效时间窗口
        if (currentTime - killTime > validTicks) {
            // 超时，清除命中标记
            tag.putBoolean(hitTag, false);
            return;
        }

        // 有效击杀，清除命中标记并设置加速标记
        tag.putBoolean(hitTag, false);
        tag.putBoolean(speedTag, true);
        tag.putLong(timeTag, currentTime);
    }

    /**
     * 检查并触发换弹加速
     * 验证加速标记是否在有效期内，如果是则触发换弹加速
     *
     * @param gun 武器物品
     * @param player 玩家对象
     * @param speedTag 加速标记的NBT键名
     * @param timeTag 时间戳的NBT键名
     * @param validTicks 有效时间窗口（游戏刻）
     */
    public static void checkAndTriggerSpeed(ItemStack gun, Player player, String speedTag, String timeTag, int validTicks) {
        CompoundTag tag = gun.getOrCreateTag();

        // 如果没有加速标记，直接返回
        if (!tag.getBoolean(speedTag)) {
            return;
        }

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(timeTag);

        // 检查是否超过有效时间窗口
        if (currentTime - killTime > validTicks) {
            // 超时，清除加速标记
            tag.putBoolean(speedTag, false);
            return;
        }

        // 有效加速标记，设置换弹上下文并发送网络包同步到客户端
        ReloadContextHolder.setPlayer(player);
        PacketHandler.INSTANCE.send(
                PacketDistributor.ALL.noArg(),
                new GunReloadSpeedPacket(true, gun.copy(), speedTag)
        );
    }

    /**
     * 清除换弹加速标记
     *
     * @param gun 武器物品
     * @param speedTag 加速标记的NBT键名
     */
    public static void clearSpeed(ItemStack gun, String speedTag) {
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(speedTag, false);
    }

    /**
     * 检查是否有换弹加速标记
     *
     * @param gun 武器物品
     * @param speedTag 加速标记的NBT键名
     * @return true表示有加速标记
     */
    public static boolean hasSpeed(ItemStack gun, String speedTag) {
        return gun.getOrCreateTag().getBoolean(speedTag);
    }

    /**
     * 检查是否有命中标记
     *
     * @param gun 武器物品
     * @param hitTag 命中标记的NBT键名
     * @return true表示有命中标记
     */
    public static boolean hasHit(ItemStack gun, String hitTag) {
        return gun.getOrCreateTag().getBoolean(hitTag);
    }

    /**
     * 获取存储的时间戳
     *
     * @param gun 武器物品
     * @param timeTag 时间戳的NBT键名
     * @return 存储的游戏时间（刻）
     */
    public static long getTime(ItemStack gun, String timeTag) {
        return gun.getOrCreateTag().getLong(timeTag);
    }

    /**
     * 设置换弹加速标记并触发同步
     * 直接设置加速标记，并发送网络包同步到客户端
     *
     * @param gun 武器物品
     * @param player 玩家对象
     * @param speedTag 加速标记的NBT键名
     * @param timeTag 时间戳的NBT键名
     */
    public static void setSpeed(ItemStack gun, Player player, String speedTag, String timeTag) {
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(speedTag, true);
        tag.putLong(timeTag, player.level().getGameTime());

        // 设置换弹上下文并发送网络包
        ReloadContextHolder.setPlayer(player);
        PacketHandler.INSTANCE.send(
                PacketDistributor.ALL.noArg(),
                new GunReloadSpeedPacket(true, gun.copy(), speedTag)
        );
    }

    /**
     * 清除所有相关NBT标记
     * 一次性清除命中标记、加速标记和时间戳
     *
     * @param gun 武器物品
     * @param hitTag 命中标记的NBT键名
     * @param speedTag 加速标记的NBT键名
     * @param timeTag 时间戳的NBT键名
     */
    public static void clearAllTags(ItemStack gun, String hitTag, String speedTag, String timeTag) {
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(hitTag, false);
        tag.putBoolean(speedTag, false);
        tag.putLong(timeTag, 0);
    }
}