package com.chinaex123.tbz.data;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.init.TBZItemTags;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TBZItemTagsProvider extends ItemTagsProvider {
    public TBZItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, TBZMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // D2 材料
        tag(TBZItemTags.D2_MATERIALS)
                .add(TBZItems.ENHANCEMENT_PRISM.get())
                .add(TBZItems.ASCENDANT_SHARD.get())
                .add(TBZItems.ASCENDANT_ALLOY.get());
        // 随机附魔材料
        tag(TBZItemTags.RANDOM_PERK_MATERIAL)
                .add(TBZItems.ASCENDANT_ALLOY.get());
        // 删除随机附魔材料
        tag(TBZItemTags.REFRESH_PERK_MATERIAL)
                .add(TBZItems.ASCENDANT_SHARD.get());
    }
}
