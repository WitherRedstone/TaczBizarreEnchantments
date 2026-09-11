package com.chinaex123.tbz.data;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.block.MarsSmithingTableBlock;
import com.chinaex123.tbz.init.TBZBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TBZBlockStatesProvider extends BlockStateProvider {
    public TBZBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TBZMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        var model = models().withExistingParent("mars_smithing_table", "minecraft:block/cube")
                .texture("up", modLoc("block/mars_smithing_table_top"))
                .texture("down", modLoc("block/mars_smithing_table_bottom"))
                .texture("east", modLoc("block/mars_smithing_table_side"))
                .texture("north", modLoc("block/mars_smithing_table_front"))
                .texture("south", modLoc("block/mars_smithing_table_front"))
                .texture("west", modLoc("block/mars_smithing_table_side"))
                .texture("particle", modLoc("block/mars_smithing_table_front"));

        
        getVariantBuilder(TBZBlocks.MARS_SMITHING_TABLE.get())
            .forAllStates(state -> {
                var direction = state.getValue(MarsSmithingTableBlock.FACING);
                return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(direction.get2DDataValue() * 90)
                    .build();
            });
        
        simpleBlockItem(TBZBlocks.MARS_SMITHING_TABLE.get(), model);
    }
}