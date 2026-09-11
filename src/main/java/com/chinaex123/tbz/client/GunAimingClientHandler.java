package com.chinaex123.tbz.client;

import com.chinaex123.tbz.capability.ModCapabilities;
import net.minecraft.client.Minecraft;

import java.util.UUID;

/**
 * 枪械瞄准客户端处理器
 * <p>
 * 功能：在客户端处理瞄准状态同步
 * 此类只在客户端加载，避免服务端加载客户端类
 */
public class GunAimingClientHandler {

    /**
     * 处理瞄准状态同步
     * 更新客户端玩家的瞄准状态 Capability
     *
     * @param playerId 玩家UUID
     * @param isAiming 瞄准状态
     */
    public static void handleSync(UUID playerId, boolean isAiming) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && mc.player.getUUID().equals(playerId)) {
            mc.player.getCapability(ModCapabilities.GUN_AIMING).ifPresent(cap -> {
                cap.setAiming(isAiming);
            });
        }
    }
}