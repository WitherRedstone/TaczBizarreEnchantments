package com.chinaex123.tbz.network.hud;

import com.chinaex123.tbz.client.hud.TargetLockHUD;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 目标锁定同步包
 * <p>
 * 功能：服务端 -> 客户端，同步目标锁定状态
 * <p>
 * 字段说明：
 * <ul>
 *   <li>playerId - 玩家UUID</li>
 *   <li>damageStack - 伤害加成层数</li>
 *   <li>lastHitTime - 最后命中时间（游戏刻）</li>
 * </ul>
 */
public record TargetLockSyncPacket(UUID playerId, int damageStack, long lastHitTime) {

    /**
     * 将数据编码到网络缓冲区
     *
     * @param buf 网络缓冲区
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeInt(damageStack);
        buf.writeLong(lastHitTime);
    }

    /**
     * 从网络缓冲区解码数据
     *
     * @param buf 网络缓冲区
     * @return 解码后的数据包
     */
    public static TargetLockSyncPacket decode(FriendlyByteBuf buf) {
        return new TargetLockSyncPacket(buf.readUUID(), buf.readInt(), buf.readLong());
    }

    /**
     * 处理接收到的同步包
     * 在客户端更新目标锁定状态显示
     *
     * @param packet 接收到的数据包
     * @param contextSupplier 网络上下文提供者
     */
    public static void handle(TargetLockSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // 更新客户端缓存
            TargetLockHUD.setTargetLockDamageStack(packet.playerId(), packet.damageStack(), packet.lastHitTime());
        });
        context.setPacketHandled(true);
    }
}