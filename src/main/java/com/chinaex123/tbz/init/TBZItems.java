package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBZItems {
    public static final DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, TBZMod.MOD_ID);

    /** 增强棱镜 */
    public static final RegistryObject<Item> ENHANCEMENT_PRISM = ITEMS_REGISTER.register("enhancement_prism",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(50).rarity(Rarity.RARE)));
    /** 上维碎片 */
    public static final RegistryObject<Item> ASCENDANT_SHARD = ITEMS_REGISTER.register("ascendant_shard",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(50).rarity(Rarity.EPIC)));
    /** 上维合金 */
    public static final RegistryObject<Item> ASCENDANT_ALLOY = ITEMS_REGISTER.register("ascendant_alloy",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(50).rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
