package com.chinaex123.tbz;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZCreativeTabs;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.PacketHandler;
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

    public TBZMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TBZConfig.SPEC);
        TBZEnchantments.ENCHANTMENTS.register(modEventBus);
        PacketHandler.register();
        TBZCreativeTabs.CREATIVE_MODE_TAB.register(modEventBus);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}