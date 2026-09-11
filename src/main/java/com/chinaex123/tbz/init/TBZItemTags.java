package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public interface TBZItemTags {

    TagKey<Item> D2_MATERIALS = bind("d2_materials");
    TagKey<Item> RANDOM_PERK_MATERIAL = bind("random_perk_material");
    TagKey<Item> REFRESH_PERK_MATERIAL = bind("refresh_perk_material");

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TBZMod.MOD_ID, name));
    }
}
