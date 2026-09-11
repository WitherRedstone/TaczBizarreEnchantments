package com.chinaex123.tbz.network;

import com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record MarsSmithingTablePacket(BlockPos pos) {

    public static void encode(MarsSmithingTablePacket msg, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(msg.pos);
    }

    public static MarsSmithingTablePacket decode(FriendlyByteBuf buffer) {
        return new MarsSmithingTablePacket(buffer.readBlockPos());
    }

    public static void handle(MarsSmithingTablePacket msg, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                Level level = player.level();
                BlockEntity blockEntity = level.getBlockEntity(msg.pos);
                if (blockEntity instanceof MarsSmithingTableBlockEntity) {
                    ((MarsSmithingTableBlockEntity) blockEntity).onButtonPress(player);
                }
            }
        });
        context.setPacketHandled(true);
    }
}