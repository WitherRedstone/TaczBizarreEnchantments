package com.chinaex123.tbz.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import com.chinaex123.tbz.capability.ModCapabilities;

import java.util.function.Supplier;

/**
 * 枪械瞄准状态网络数据包（客户端 → 服务端）
 * <p>
 * 功能：将客户端的枪械瞄准状态同步到服务端
 * <p>
 * 字段说明：
 * <ul>
 *   <li>isAiming - 玩家是否正在瞄准（true=瞄准中，false=未瞄准）</li>
 * </ul>
 */
public record GunAimingPacket(boolean isAiming) {

    /**
     * 编码方法 - 将数据包内容写入网络缓冲区
     * 用于客户端向服务端发送数据
     *
     * @param msg 数据包实例
     * @param buf 网络缓冲区
     */
    public static void encode(GunAimingPacket msg, FriendlyByteBuf buf) {
        buf.writeBoolean(msg.isAiming());  // 写入布尔值（1字节）
    }

    /**
     * 解码方法 - 从网络缓冲区读取数据并构建数据包对象
     * 用于服务端接收客户端数据
     *
     * @param buf 网络缓冲区
     * @return 解析后的数据包对象
     */
    public static GunAimingPacket decode(FriendlyByteBuf buf) {
        return new GunAimingPacket(buf.readBoolean());  // 按写入顺序读取布尔值
    }

    /**
     * 消息处理方法 - 在服务端执行数据同步逻辑
     * 将客户端传来的瞄准状态同步到服务端玩家的能力数据中
     *
     * @param msg 接收到的数据包
     * @param ctx 网络上下文（提供网络环境信息）
     */
    public static void handle(GunAimingPacket msg, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        // 在服务端主线程执行数据同步逻辑
        context.enqueueWork(() -> {
            // 获取发送数据包的玩家（服务端玩家对象）
            ServerPlayer player = context.getSender();
            if (player != null) {
                // 通过能力系统（Capability）更新瞄准状态
                player.getCapability(ModCapabilities.GUN_AIMING).ifPresent(cap -> {
                    cap.setAiming(msg.isAiming());  // 设置瞄准状态
                });
                // 同时更新静态的 AimingState 状态（用于非能力系统访问）
                AimingState.setAiming(player, msg.isAiming());
            }
        });
        // 标记数据包已处理完成
        context.setPacketHandled(true);
    }
}