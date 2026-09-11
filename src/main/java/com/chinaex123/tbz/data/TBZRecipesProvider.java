package com.chinaex123.tbz.data;

import com.chinaex123.tbz.init.TBZBlocks;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TBZRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public TBZRecipesProvider(PackOutput p0utput) {
        super(p0utput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeOutput) {

        // ==================== 有序合成 ====================
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TBZBlocks.MARS_SMITHING_TABLE.get())
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .define('A', Items.CHISELED_POLISHED_BLACKSTONE)
                .define('B', TBZItems.ENHANCEMENT_PRISM.get())
                .define('C', Items.ECHO_SHARD)
                .unlockedBy("has_mars_smithing_table_blackstone", has(Items.CHISELED_POLISHED_BLACKSTONE))
                .unlockedBy("has_mars_smithing_table_enhancement_prism", has(TBZItems.ENHANCEMENT_PRISM.get()))
                .unlockedBy("has_mars_smithing_table_echo_shard", has(Items.ECHO_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TBZItems.ASCENDANT_ALLOY.get())
                .pattern("BBB")
                .pattern("CAC")
                .pattern("BBB")
                .define('A', TBZItems.ENHANCEMENT_PRISM.get())
                .define('B', TBZItems.ASCENDANT_SHARD.get())
                .define('C', Items.DIAMOND)
                .unlockedBy("has_ascendant_alloy_enhancement_prism", has(TBZItems.ENHANCEMENT_PRISM.get()))
                .unlockedBy("has_ascendant_alloy_ascendant_shard", has(TBZItems.ASCENDANT_SHARD.get()))
                .unlockedBy("has_ascendant_alloy_diamond", has(Items.DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TBZItems.ASCENDANT_SHARD.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.NETHER_STAR)
                .define('B', TBZItems.ENHANCEMENT_PRISM.get())
                .unlockedBy("has_ascendant_shard_nether_star", has(Items.NETHER_STAR))
                .unlockedBy("has_ascendant_shard_enhancement_prism", has(TBZItems.ENHANCEMENT_PRISM.get()))
                .save(recipeOutput);


        // ==================== 无形状合成 ====================
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TBZItems.ENHANCEMENT_PRISM.get(),4)
                .requires(TBZItems.ASCENDANT_SHARD.get())
                .unlockedBy("has_enhancement_prism_ascendant_shard", has(TBZItems.ASCENDANT_SHARD.get()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TBZItems.ASCENDANT_SHARD.get(),2)
                .requires(TBZItems.ASCENDANT_ALLOY.get())
                .unlockedBy("has_ascendant_shard_ascendant_alloy", has(TBZItems.ASCENDANT_ALLOY.get()))
                .save(recipeOutput, "tbz:ascendant_shard2");
    }
}
