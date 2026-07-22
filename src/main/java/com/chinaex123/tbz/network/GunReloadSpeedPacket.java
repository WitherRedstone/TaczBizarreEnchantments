package com.chinaex123.tbz.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * 枪械换弹速度同步包（双向）
 * <p>
 * 功能：在客户端和服务端之间同步换弹加速标记的状态
 * <p>
 * 使用场景：
 * <ul>
 *   <li>服务端 → 客户端：通知客户端设置换弹加速标记（触发音效加速等）</li>
 *   <li>客户端 → 服务端：请求服务端清除换弹加速标记（换弹完成时）</li>
 * </ul>
 */
public class GunReloadSpeedPacket {

    private final boolean hasEffect; // true=设置标记，false=清除标记
    private final ItemStack gunStack; // 枪械物品
    private final String speedTag; // NBT标签键名

    public GunReloadSpeedPacket(boolean hasEffect, ItemStack gunStack, String speedTag) {
        this.hasEffect = hasEffect;
        this.gunStack = gunStack;
        this.speedTag = speedTag;
    }

    /**
     * 解码方法 - 从字节缓冲区读取包数据
     * 用于网络接收后的反序列化
     *
     * @param buf 字节缓冲区
     * @return 解析后的数据包
     */
    public static GunReloadSpeedPacket decode(FriendlyByteBuf buf) {
        return new GunReloadSpeedPacket(buf.readBoolean(), buf.readItem(), buf.readUtf());
    }

    /**
     * 编码方法 - 将包数据写入字节缓冲区
     * 用于网络传输前的序列化
     *
     * @param buf 字节缓冲区
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeBoolean(hasEffect);
        buf.writeItem(gunStack);
        buf.writeUtf(speedTag);
    }

    /**
     * 包处理方法
     * <p>
     * 客户端处理：设置换弹加速标记（用于音效加速等客户端效果）
     * 服务端处理：清除换弹加速标记（保持服务端数据一致性）
     *
     * @param packet 接收到的数据包
     * @param contextSupplier 网络上下文提供者
     */
    public static void handle(GunReloadSpeedPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // 客户端处理：设置加速标记
            if (context.getDirection().getReceptionSide().isClient()) {
                if (packet.hasEffect && Minecraft.getInstance().player != null) {
                    var player = Minecraft.getInstance().player;
                    var weapon = player.getMainHandItem();
                    if (!weapon.isEmpty()) {
                        var tag = weapon.getOrCreateTag();
                        tag.putBoolean(packet.speedTag, true);
                    }
                }
            }
            // 服务端处理：清除加速标记
            else {
                if (!packet.hasEffect) {
                    var sender = context.getSender();
                    if (sender != null) {
                        ItemStack weapon = sender.getMainHandItem();
                        if (!weapon.isEmpty()) {
                            var tag = weapon.getOrCreateTag();
                            if (tag.getBoolean(packet.speedTag)) {
                                tag.putBoolean(packet.speedTag, false);
                            }
                        }
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}