package com.chinaex123.tbz.network.hud;

import com.chinaex123.tbz.TBZMod;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

/**
 * HUD网络包处理器
 * <p>
 * 注册HUD相关的网络通信通道
 * */
public class HUDPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            TBZMod.id("hud"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int id = 0;

    public static void register() {

        /* 通用附魔状态同步包 */
        INSTANCE.registerMessage(
                id++,
                EnchantmentStatusSyncPacket.class,
                EnchantmentStatusSyncPacket::encode,
                EnchantmentStatusSyncPacket::decode,
                EnchantmentStatusSyncPacket::handle
        );

        /* 通用触发型附魔HUD同步包 */
        INSTANCE.registerMessage(
                id++,
                TriggeredEnchantmentSyncPacket.class,
                TriggeredEnchantmentSyncPacket::encode,
                TriggeredEnchantmentSyncPacket::decode,
                TriggeredEnchantmentSyncPacket::handle
        );
    }
}