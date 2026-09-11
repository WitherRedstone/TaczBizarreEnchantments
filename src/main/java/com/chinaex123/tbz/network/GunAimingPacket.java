package com.chinaex123.tbz.network;

import com.chinaex123.tbz.capability.ModCapabilities;
import com.chinaex123.tbz.client.GunAimingClientHandler;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.GunPropertyHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
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
                AimingState.setAiming(player, msg.isAiming());
                updateRangefinderCache(player);
            }
        });
        // 标记数据包已处理完成
        context.setPacketHandled(true);
    }

    /**
     * 更新附魔的优势射程
     * 根据玩家的瞄准状态和附魔等级计算并更新缓存
     *
     * @param player 玩家对象
     */
    private static void updateRangefinderCache(ServerPlayer player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有测距仪附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
        if (enchantLevel <= 0) {
            return;
        }

        // 检查玩家是否在瞄准
        boolean isAiming = AimingState.isAiming(player);
        // 从配置获取每级射程扩展因子
        double rangeBonusFactorPerLevel = TBZServerConfig.RANGEFINDER_ADS_RANGE_BONUS.get();

        // 使用通用工具类更新优势射程
        GunPropertyHelper.EffectiveRange.update(player, gun, isAiming, enchantLevel, rangeBonusFactorPerLevel);

        // 瞄准时提升精度
//        double accuracyImprovementFactorPerLevel = TBZServerConfig.RANGEFINDER_AIM_ACCURACY_IMPROVEMENT_PER_LEVEL.get();
//        GunPropertyHelper.Inaccuracy.update(player, gun, InaccuracyType.AIM, isAiming, enchantLevel, accuracyImprovementFactorPerLevel);
    }
}

/**
 * 枪械瞄准状态同步数据包（服务端 → 客户端）
 * <p>
 * 功能：将服务端的瞄准状态同步到客户端
 * <p>
 * 字段说明：
 * <ul>
 *   <li>playerId - 玩家UUID</li>
 *   <li>isAiming - 玩家是否正在瞄准（true=瞄准中，false=未瞄准）</li>
 * </ul>
 */
record GunAimingSyncPacket(UUID playerId, boolean isAiming) {

    /**
     * 编码方法 - 将数据包内容写入网络缓冲区
     * 用于服务端向客户端发送数据
     *
     * @param msg    数据包实例
     * @param buffer 网络缓冲区
     */
    public static void encode(GunAimingSyncPacket msg, FriendlyByteBuf buffer) {
        buffer.writeUUID(msg.playerId);
        buffer.writeBoolean(msg.isAiming);
    }

    /**
     * 解码方法 - 从网络缓冲区读取数据包内容
     * 用于客户端接收服务端数据
     *
     * @param buffer 网络缓冲区
     * @return 解码后的数据包实例
     */
    public static GunAimingSyncPacket decode(FriendlyByteBuf buffer) {
        UUID playerId = buffer.readUUID();
        boolean isAiming = buffer.readBoolean();
        return new GunAimingSyncPacket(playerId, isAiming);
    }

    /**
     * 处理方法 - 客户端接收数据包后的处理逻辑
     * 更新客户端玩家的瞄准状态 Capability
     *
     * @param msg 数据包实例
     * @param ctx 网络事件上下文
     */
    public static void handle(GunAimingSyncPacket msg, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        // 在客户端主线程执行数据同步逻辑
        context.enqueueWork(() -> {
            // 使用 DistExecutor 分离客户端逻辑
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                GunAimingClientHandler.handleSync(msg.playerId, msg.isAiming);
            });
        });
        // 标记数据包已处理完成
        context.setPacketHandled(true);
    }
}