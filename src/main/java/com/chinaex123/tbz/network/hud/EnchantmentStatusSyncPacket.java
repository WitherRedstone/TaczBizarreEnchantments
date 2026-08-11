package com.chinaex123.tbz.network.hud;

import com.chinaex123.tbz.client.hud.EnchantmentStatusHUD;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 附魔状态同步包
 * <p>
 * 功能：服务端 -> 客户端，同步附魔的状态信息
 * <p>
 * 字段说明：
 * <ul>
 *   <li>playerId - 玩家UUID</li>
 *   <li>enchantmentType - 附魔类型（"target_lock", "swashbuckler", "one_for_all", "master_of_arms"）</li>
 *   <li>value - 状态值（层数、激活状态等）</li>
 *   <li>timestamp - 时间戳（开始时间、最后命中时间等）</li>
 *   <li>gunItem - 枪械物品（可选，仅武器大师需要）</li>
 * </ul>
 */
public record EnchantmentStatusSyncPacket(UUID playerId, String enchantmentType, int value, long timestamp, ItemStack gunItem) {

    /**
     * 将数据编码到网络缓冲区
     *
     * @param buf 网络缓冲区
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeUtf(enchantmentType);
        buf.writeInt(value);
        buf.writeLong(timestamp);
        buf.writeItem(gunItem);
    }

    /**
     * 从网络缓冲区解码数据
     *
     * @param buf 网络缓冲区
     * @return 解码后的数据包
     */
    public static EnchantmentStatusSyncPacket decode(FriendlyByteBuf buf) {
        return new EnchantmentStatusSyncPacket(
                buf.readUUID(),
                buf.readUtf(),
                buf.readInt(),
                buf.readLong(),
                buf.readItem()
        );
    }

    /**
     * 处理接收到的同步包
     * 在客户端更新附魔状态显示
     *
     * @param packet 接收到的数据包
     * @param contextSupplier 网络上下文提供者
     */
    public static void handle(EnchantmentStatusSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // 更新客户端缓存
            EnchantmentStatusHUD.setEnchantmentStatus(
                    packet.playerId(),
                    packet.enchantmentType(),
                    packet.value(),
                    packet.timestamp(),
                    packet.gunItem()
            );
        });
        context.setPacketHandled(true);
    }
}