package com.chinaex123.tbz.network.hud;

import com.chinaex123.tbz.client.hud.TriggerBasedHUD;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 触发型附魔同步包
 * <p>
 * 功能：服务端 -> 客户端，同步触发型附魔的触发状态
 * <p>
 * 字段说明：
 * <ul>
 *   <li>playerId - 玩家UUID</li>
 *   <li>enchantmentType - 附魔类型（"triple_tap"或"fourth_time_the_charm"）</li>
 *   <li>triggerTime - 触发时间（游戏刻）</li>
 * </ul>
 */
public record TriggeredEnchantmentSyncPacket(UUID playerId, String enchantmentType, long triggerTime) {

    /**
     * 将数据编码到网络缓冲区
     *
     * @param buf 网络缓冲区
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeUtf(enchantmentType);
        buf.writeLong(triggerTime);
    }

    /**
     * 从网络缓冲区解码数据
     *
     * @param buf 网络缓冲区
     * @return 解码后的数据包
     */
    public static TriggeredEnchantmentSyncPacket decode(FriendlyByteBuf buf) {
        return new TriggeredEnchantmentSyncPacket(buf.readUUID(), buf.readUtf(), buf.readLong());
    }

    /**
     * 处理接收到的同步包
     * 在客户端更新触发型附魔显示
     *
     * @param packet 接收到的数据包
     * @param contextSupplier 网络上下文提供者
     */
    public static void handle(TriggeredEnchantmentSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // 更新客户端缓存
            TriggerBasedHUD.setTriggered(packet.playerId(), packet.enchantmentType(), packet.triggerTime());
        });
        context.setPacketHandled(true);
    }
}