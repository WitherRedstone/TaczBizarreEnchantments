package com.chinaex123.tbz.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 模组能力注册类
 * <p>
 * 负责注册和管理模组中使用的所有 Capability
 * 在 MOD 总线事件中注册能力接口
 */
@Mod.EventBusSubscriber(modid = "tbz", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCapabilities {

    /**
     * 枪械瞄准能力实例
     * 使用 CapabilityToken 实现类型安全的能力引用
     */
    public static final Capability<IGunAimingCapability> GUN_AIMING = CapabilityManager.get(new CapabilityToken<>() {});

    /**
     * 注册能力事件处理
     * 在模组加载时注册所有能力接口
     *
     * @param event 注册能力事件
     */
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        // 注册枪械瞄准能力接口
        event.register(IGunAimingCapability.class);
    }
}