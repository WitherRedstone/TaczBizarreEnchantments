package com.chinaex123.tbz.capability;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 枪械瞄准能力附着器
 * <p>
 * 负责为所有生物实体附加枪械瞄准能力（GunAimingCapability）
 * 该能力用于管理实体瞄准相关的数据和行为
 */
@Mod.EventBusSubscriber
public class GunAimingAttacher {

    // 能力的唯一标识符
    private static final ResourceLocation CAPABILITY_ID = ResourceLocation.fromNamespaceAndPath("tbz", "gun_aiming");

    /**
     * 附加能力事件处理
     * 当实体被创建时，检查是否为生物实体，如果是则附加枪械瞄准能力
     *
     * @param event 附加能力事件
     */
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        // 仅为生物实体附加能力
        if (event.getObject() instanceof LivingEntity) {
            // 添加能力提供者到实体
            event.addCapability(CAPABILITY_ID, new Provider());
        }
    }

    /**
     * 能力提供者内部类
     * 实现 ICapabilityProvider 接口，负责提供枪械瞄准能力实例
     */
    private static class Provider implements ICapabilityProvider {

        // 能力实例
        private final GunAimingCapability capability = new GunAimingCapability();

        // 懒加载的能力实例包装器
        private final LazyOptional<IGunAimingCapability> instance = LazyOptional.of(() -> capability);

        /**
         * 获取能力实例
         *
         * @param cap 请求的能力类型
         * @param side 方向（可为null）
         * @param <T> 能力类型
         * @return 能力实例的懒加载包装器，如果类型不匹配则返回空
         */
        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            // 检查请求的能力类型是否匹配，匹配则返回能力实例，否则返回空
            return ModCapabilities.GUN_AIMING.orEmpty(cap, instance);
        }
    }
}