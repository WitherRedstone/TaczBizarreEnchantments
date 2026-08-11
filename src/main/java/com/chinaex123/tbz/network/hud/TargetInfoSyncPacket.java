//package com.chinaex123.tbz.network.hud;
//
//import com.chinaex123.tbz.client.hud.TargetInfoHUD;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.UUID;
//import java.util.function.Supplier;
//
///**
// * 目标信息同步包
// * <p>
// * 功能：服务端 -> 客户端，同步目标的健康值和距离信息
// * <p>
// * 字段说明：
// * <ul>
// *   <li>playerId - 玩家UUID</li>
// *   <li>targetHealth - 目标当前生命值</li>
// *   <li>targetMaxHealth - 目标最大生命值</li>
// *   <li>distance - 距离（格）</li>
// *   <li>timestamp - 时间戳</li>
// * </ul>
// */
//public record TargetInfoSyncPacket(UUID playerId, float targetHealth, float targetMaxHealth, double distance, long timestamp) {
//
//    public void encode(FriendlyByteBuf buf) {
//        buf.writeUUID(playerId);
//        buf.writeFloat(targetHealth);
//        buf.writeFloat(targetMaxHealth);
//        buf.writeDouble(distance);
//        buf.writeLong(timestamp);
//    }
//
//    public static TargetInfoSyncPacket decode(FriendlyByteBuf buf) {
//        return new TargetInfoSyncPacket(
//                buf.readUUID(),
//                buf.readFloat(),
//                buf.readFloat(),
//                buf.readDouble(),
//                buf.readLong()
//        );
//    }
//
//    public static void handle(TargetInfoSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
//        NetworkEvent.Context context = contextSupplier.get();
//        context.enqueueWork(() -> {
//            TargetInfoHUD.setTargetInfo(
//                    packet.playerId(),
//                    packet.targetHealth(),
//                    packet.targetMaxHealth(),
//                    packet.distance(),
//                    packet.timestamp()
//            );
//        });
//        context.setPacketHandled(true);
//    }
//}