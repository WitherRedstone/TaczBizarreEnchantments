package com.chinaex123.tbz.utils;

import net.minecraft.world.entity.player.Player;

/**
 * 换弹上下文持有器
 * <p>
 * 使用 ThreadLocal 存储当前正在执行换弹操作的玩家对象
 * 用于在服务端 Mixin 中获取玩家上下文，因为 Mixin 无法直接访问玩家参数
 * 需要在调用前通过 setPlayer() 设置，使用后通过 clear() 清理
 */
public class ReloadContextHolder {

    // ThreadLocal 用于存储当前线程的玩家对象
    private static final ThreadLocal<Player> CURRENT_PLAYER = new ThreadLocal<>();

    /**
     * 设置当前线程的玩家对象
     *
     * @param player 玩家对象
     */
    public static void setPlayer(Player player) {
        CURRENT_PLAYER.set(player);
    }

    /**
     * 获取当前线程的玩家对象
     *
     * @return 玩家对象，如果未设置则返回 null
     */
    public static Player getPlayer() {
        return CURRENT_PLAYER.get();
    }

    /**
     * 清除当前线程的玩家对象
     * 防止内存泄漏，应在使用完毕后调用
     */
    public static void clear() {
        CURRENT_PLAYER.remove();
    }
}