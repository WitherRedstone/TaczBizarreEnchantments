package com.chinaex123.tbz.event;

import com.chinaex123.tbz.network.ClientAdagioHandler;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** 客户端Tick事件处理器 **/
@Mod.EventBusSubscriber
public class ClientTickHandler {

    /**
     * 客户端Tick事件处理
     * 在客户端渲染帧的结束阶段调用缓射状态更新
     *
     * @param event 客户端Tick事件
     */
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // 仅在Tick的结束阶段执行，避免重复更新
        if (event.phase == TickEvent.Phase.END) {
            ClientAdagioHandler.tick();
        }
    }
}