package com.chinaex123.tbz;

import com.chinaex123.tbz.config.TBZClientConfig;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZCreativeTabs;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.PacketHandler;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.recoil.modifier.EyeOfStormEyeRecoilModifier;
import com.chinaex123.tbz.recoil.modifier.FirmlyPlantedRecoilModifier;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TBZMod.MOD_ID)
@SuppressWarnings("removal")
public class TBZMod {
    public static final String MOD_ID = "tbz";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TBZMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TBZServerConfig.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TBZClientConfig.SPEC);
        TBZEnchantments.ENCHANTMENTS.register(modEventBus);
        PacketHandler.register();
        HUDPacketHandler.register();
        FirmlyPlantedRecoilModifier.register();
        EyeOfStormEyeRecoilModifier.register();
        TBZCreativeTabs.CREATIVE_MODE_TAB.register(modEventBus);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}