package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBZVillagerProfessions {

    /** POI类型注册器 **/
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TBZMod.MOD_ID);
    /** 村民职业注册器 **/
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TBZMod.MOD_ID);

    /** 火星锻造台POI **/
    public static final RegistryObject<PoiType> MARS_SMITHING_POI = POI_TYPES.register("mars_smith_poi",
            () -> new PoiType(ImmutableSet.copyOf(TBZBlocks.MARS_SMITHING_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));

    /** 火星锻造师职业 **/
    public static final RegistryObject<VillagerProfession> MARS_SMITH = VILLAGER_PROFESSIONS.register("mars_smith",
            () -> new VillagerProfession("mars_smith",
                    p -> p.get() == MARS_SMITHING_POI.get(),
                    p -> p.get() == MARS_SMITHING_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}