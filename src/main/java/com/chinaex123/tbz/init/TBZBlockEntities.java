package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBZBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TBZMod.MOD_ID);

    /**
     * 火星锻造台方块实体类型
     * 绑定火星锻造台方块实体类和对应的方块
     */
    public static final RegistryObject<BlockEntityType<MarsSmithingTableBlockEntity>> MARS_SMITHING_TABLE =
            BLOCK_ENTITIES.register("mars_smithing_table", () -> BlockEntityType.Builder.of(
                    MarsSmithingTableBlockEntity::new,
                    TBZBlocks.MARS_SMITHING_TABLE.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}