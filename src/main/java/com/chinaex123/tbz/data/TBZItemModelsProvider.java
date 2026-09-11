package com.chinaex123.tbz.data;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TBZItemModelsProvider extends ItemModelProvider {
    public TBZItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TBZMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        basicItem(TBZItems.ENHANCEMENT_PRISM.get());
        basicItem(TBZItems.ASCENDANT_SHARD.get());
        basicItem(TBZItems.ASCENDANT_ALLOY.get());
    }
}
