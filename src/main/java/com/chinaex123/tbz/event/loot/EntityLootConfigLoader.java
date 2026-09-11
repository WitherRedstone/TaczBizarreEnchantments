package com.chinaex123.tbz.event.loot;

import com.chinaex123.tbz.TBZMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * 实体战利品配置加载器
 * <p>
 * 负责在模组加载时初始化Boss实体配置
 */
@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityLootConfigLoader {

    /**
     * 通用设置事件处理
     * 在模组加载时加载Boss ID列表
     *
     * @param event 通用设置事件
     */
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(EntityLootInjector::loadBossIds);
    }
}