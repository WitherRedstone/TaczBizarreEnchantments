package com.chinaex123.tbz.data;

import com.chinaex123.tbz.TBZMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TBZDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(), new TBZBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TBZItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new TBZBlockStatesProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new TBZItemModelsProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new TBZRecipesProvider(packOutput));
        generator.addProvider(event.includeServer(), new TBZPoiTagProvider(packOutput, lookupProvider));
//

//        generator.addProvider(event.includeServer(), new ModEntityTagsProvider(packOutput, lookupProvider, existingFileHelper));

    }
}