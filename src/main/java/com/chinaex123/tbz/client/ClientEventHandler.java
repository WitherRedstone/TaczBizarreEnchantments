package com.chinaex123.tbz.client;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.client.screen.MarsSmithingTableScreen;
import com.chinaex123.tbz.init.TBZMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(TBZMenuTypes.MARS_SMITHING_TABLE.get(), MarsSmithingTableScreen::new);
        });
    }
}