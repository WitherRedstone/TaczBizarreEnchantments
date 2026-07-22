package com.chinaex123.tbz.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 射速同步包（服务端 → 客户端）
 * <p>
 * 用于同步射速修改效果（如猛攻附魔的加速、缓射附魔的减速）
 * <p>
 * 字段说明：
 * <ul>
 *   <li>playerId - 玩家唯一标识，用于确定效果应用到哪个玩家</li>
 *   <li>additionalInterval - 额外的射击间隔（毫秒），正数=减速，0=恢复</li>
 *   <li>endTime - 效果结束时间戳（毫秒），用于客户端自动超时恢复</li>
 * </ul>
 */
public record FireRateSyncPacket(UUID playerId, long additionalInterval, long endTime) {

    /**
     * 编码方法 - 将包数据写入字节缓冲区
     * 用于网络传输前的序列化
     *
     * @param msg 要发送的数据包
     * @param buf 字节缓冲区
     */
    public static void encode(FireRateSyncPacket msg, FriendlyByteBuf buf) {
        buf.writeUUID(msg.playerId());
        buf.writeLong(msg.additionalInterval());
        buf.writeLong(msg.endTime());
    }

    /**
     * 解码方法 - 从字节缓冲区读取包数据
     * 用于网络接收后的反序列化
     *
     * @param buf 字节缓冲区
     * @return 解析后的数据包
     */
    public static FireRateSyncPacket decode(FriendlyByteBuf buf) {
        return new FireRateSyncPacket(
                buf.readUUID(),
                buf.readLong(),
                buf.readLong()
        );
    }

    /**
     * 包处理方法 - 在客户端处理同步数据
     * 将接收到的射速调整数据应用到本地玩家
     *
     * @param msg 接收到的数据包
     * @param ctx 网络上下文
     */
    public static void handle(FireRateSyncPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // 仅在客户端执行同步处理
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                ClientAdagioHandler.handleSync(msg);
            });
        });
        ctx.get().setPacketHandled(true);
    }
}