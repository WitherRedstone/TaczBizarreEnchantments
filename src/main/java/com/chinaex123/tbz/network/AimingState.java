package com.chinaex123.tbz.network;

import net.minecraft.world.entity.player.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 瞄准状态管理类（服务端）
 * <p>
 * 功能：在服务端跟踪玩家的瞄准状态，并带有超时清理机制
 * 说明：这是一个简单的替代方案，用于在不使用 Capability 的情况下管理瞄准状态
 * 注意：此类仅存储服务端数据，不涉及客户端同步
 */
public class AimingState {

    // 存储每个玩家的瞄准状态和最后更新时间（游戏刻）
    private static final Map<UUID, Long> aimingPlayers = new HashMap<>();

    // 如果超过此时间没有更新，视为玩家已停止瞄准
    private static final long AIMING_TIMEOUT_TICKS = 100; // 瞄准状态超时时间

    /**
     * 设置玩家的瞄准状态
     * 当玩家开始瞄准时记录当前时间，停止瞄准时移除记录
     *
     * @param player   目标玩家
     * @param isAiming 是否正在瞄准
     */
    public static void setAiming(Player player, boolean isAiming) {
        if (isAiming) {
            // 开始瞄准：记录当前游戏时间
            aimingPlayers.put(player.getUUID(), player.level().getGameTime());
        } else {
            // 停止瞄准：移除记录
            aimingPlayers.remove(player.getUUID());
        }
    }

    /**
     * 检查玩家是否正在瞄准
     * 会同时检查超时：如果长时间未更新状态，自动清理并返回 false
     *
     * @param player 目标玩家
     * @return true=正在瞄准，false=未瞄准或已超时
     */
    public static boolean isAiming(Player player) {
        UUID playerId = player.getUUID();

        // 没有记录，视为未瞄准
        if (!aimingPlayers.containsKey(playerId)) {
            return false;
        }

        // 获取上次更新时间
        long lastUpdateTime = aimingPlayers.get(playerId);
        long currentTime = player.level().getGameTime();

        // 检查是否超时（例如玩家断线或数据包丢失导致状态未更新）
        if (currentTime - lastUpdateTime > AIMING_TIMEOUT_TICKS) {
            // 超时自动清理，防止内存泄漏
            aimingPlayers.remove(playerId);
            return false;
        }

        // 在有效时间内，视为正在瞄准
        return true;
    }

    /**
     * 清理所有瞄准状态数据
     * 在服务器关闭或需要重置时调用
     */
    public static void cleanup() {
        aimingPlayers.clear();
    }
}