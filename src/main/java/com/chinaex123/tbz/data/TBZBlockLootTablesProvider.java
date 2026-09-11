package com.chinaex123.tbz.data;

import com.chinaex123.tbz.init.TBZBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class TBZBlockLootTablesProvider extends BlockLootSubProvider {
    public TBZBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(TBZBlocks.MARS_SMITHING_TABLE.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return TBZBlocks.BLOCK_REGISTER.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
