package com.chinaex123.tbz.data;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.init.TBZBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TBZBlockTagsProvider extends BlockTagsProvider {

    public TBZBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TBZMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TBZBlocks.MARS_SMITHING_TABLE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(TBZBlocks.MARS_SMITHING_TABLE.get());
    }
}
