package com.chinaex123.tbz.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 模组能力注册类
 */
@Mod.EventBusSubscriber(modid = "tbz", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCapabilities {

    /**
     * 枪械瞄准能力实例
     */
    public static final Capability<IGunAimingCapability> GUN_AIMING =
            CapabilityManager.get(new CapabilityToken<>() {});

    /**
     * 注册能力事件处理
     *
     * @param event 注册能力事件
     */
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        // 注册枪械瞄准能力接口
        event.register(IGunAimingCapability.class);
    }
}