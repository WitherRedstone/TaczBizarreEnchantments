package com.chinaex123.tbz.network;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.network.hud.TargetLockSyncPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

/** 网络包处理器 - 注册TBZ模组的网络通信通道 **/
public class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            TBZMod.id("main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int id = 0;

    public static void register() {
        INSTANCE.registerMessage(
                id++,
                GunAimingPacket.class,
                GunAimingPacket::encode,
                GunAimingPacket::decode,
                GunAimingPacket::handle
        );

        INSTANCE.registerMessage(
                id++,
                FireRateSyncPacket.class,
                FireRateSyncPacket::encode,
                FireRateSyncPacket::decode,
                FireRateSyncPacket::handle
        );

        INSTANCE.registerMessage(
                id++,
                GunReloadSpeedPacket.class,
                GunReloadSpeedPacket::encode,
                GunReloadSpeedPacket::decode,
                GunReloadSpeedPacket::handle
        );
    }
}