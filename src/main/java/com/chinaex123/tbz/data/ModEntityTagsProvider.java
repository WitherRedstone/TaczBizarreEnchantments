//package com.chinaex123.tbz.data;
//
//import com.chinaex123.tbz.TBZMod;
//import com.chinaex123.tbz.init.TBZEntityTags;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.PackOutput;
//import net.minecraft.data.tags.EntityTypeTagsProvider;
//import net.minecraft.world.entity.EntityType;
//import net.minecraftforge.common.data.ExistingFileHelper;
//
//import java.util.concurrent.CompletableFuture;
//
//public class ModEntityTagsProvider extends EntityTypeTagsProvider {
//
//    public ModEntityTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
//        super(output, lookupProvider, TBZMod.MOD_ID, existingFileHelper);
//    }
//
//    @Override
//    protected void addTags(HolderLookup.Provider provider) {
//        tag(TBZEntityTags.BOSS)
//                .add(EntityType.ENDER_DRAGON)
//                .add(EntityType.WITHER);
//    }
//}
