package com.chinaex123.tbz.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

/**
 * 枪械换弹速度客户端处理器
 * <p>
 * 功能：在客户端处理换弹加速标记同步
 * 此类只在客户端加载，避免服务端加载客户端类
 */
public class GunReloadSpeedClientHandler {

    /**
     * 处理换弹加速标记同步
     * 设置客户端玩家主手武器的加速标记
     *
     * @param speedTag 加速标记的NBT键名
     */
    public static void handleSync(String speedTag) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            ItemStack weapon = mc.player.getMainHandItem();
            if (!weapon.isEmpty()) {
                var tag = weapon.getOrCreateTag();
                tag.putBoolean(speedTag, true);
            }
        }
    }
}