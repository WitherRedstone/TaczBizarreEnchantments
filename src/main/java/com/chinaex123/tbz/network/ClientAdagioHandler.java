package com.chinaex123.tbz.network;

import com.chinaex123.tbz.api.IShootIntervalAdjuster;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.entity.shooter.ShooterDataHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

/**
 * 客户端射速调整处理器
 * <p>
 * 功能：在客户端接收并管理射速调整数据
 * <p>
 * 机制：
 * <ol>
 *   <li>接收服务端发送的射速同步包（FireRateSyncPacket）</li>
 *   <li>将调整值应用到本地玩家的射击调整器中</li>
 *   <li>在客户端Tick中检查效果是否过期，过期后自动恢复</li>
 * </ol>
 */
public class ClientAdagioHandler {

    /** 额外的射击间隔（毫秒） */
    private static long clientAdditionalInterval = 0;
    /** 效果结束时间戳 */
    private static long clientEndTime = 0;
    /** true表示射速调整激活中 */
    private static boolean clientActive = false;

    /**
     * 处理射速同步包
     * 将服务端同步的射速调整数据应用到本地玩家
     *
     * @param packet 射速同步包
     */
    public static void handleSync(FireRateSyncPacket packet) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || !player.getUUID().equals(packet.playerId())) {
            return;
        }

        try {
            // 获取玩家的射击数据持有者
            IGunOperator gunOperator = IGunOperator.fromLivingEntity(player);
            ShooterDataHolder dataHolder = gunOperator.getDataHolder();

            if (dataHolder instanceof IShootIntervalAdjuster adjuster) {
                long additionalInterval = packet.additionalInterval();
                long endTime = packet.endTime();

                if (additionalInterval != 0) {
                    // 有调整值：应用射速修改
                    adjuster.tbz$SetAdditionalInterval(additionalInterval);
                    adjuster.tbz$SetEndTime(endTime);
                    adjuster.tbz$SetActive(true);

                    // 更新客户端缓存
                    clientAdditionalInterval = additionalInterval;
                    clientEndTime = endTime;
                    clientActive = true;
                } else {
                    // 调整值为0：清除射速修改
                    adjuster.tbz$SetAdditionalInterval(0);
                    adjuster.tbz$SetActive(false);
                    adjuster.tbz$SetEndTime(0);

                    // 清除客户端缓存
                    clientAdditionalInterval = 0;
                    clientEndTime = 0;
                    clientActive = false;
                }
            }
        } catch (Exception e) {
            // 忽略异常，避免影响游戏运行
        }
    }

    /**
     * 客户端Tick更新
     * 检查射速调整效果是否过期，过期则自动恢复
     */
    public static void tick() {
        if (clientActive) {
            long currentTime = System.currentTimeMillis();
            // 检查是否超过结束时间
            if (currentTime >= clientEndTime) {
                LocalPlayer player = Minecraft.getInstance().player;
                if (player != null) {
                    try {
                        // 获取射击数据持有者并清除调整
                        IGunOperator gunOperator = IGunOperator.fromLivingEntity(player);
                        ShooterDataHolder dataHolder = gunOperator.getDataHolder();
                        if (dataHolder instanceof IShootIntervalAdjuster adjuster) {
                            adjuster.tbz$SetAdditionalInterval(0);
                            adjuster.tbz$SetActive(false);
                            adjuster.tbz$SetEndTime(0);
                        }
                    } catch (Exception e) {
                        // 忽略异常
                    }
                }
                // 清除客户端缓存
                clientActive = false;
                clientAdditionalInterval = 0;
                clientEndTime = 0;
            }
        }
    }

    /**
     * 检查客户端射速调整是否激活
     *
     * @return true表示射速调整激活中
     */
    public static boolean isClientActive() {
        return clientActive;
    }

    /**
     * 获取客户端当前的额外射击间隔
     *
     * @return 额外射击间隔（毫秒）
     */
    public static long getClientAdditionalInterval() {
        return clientAdditionalInterval;
    }
}