package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.menu.MarsSmithingTableMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBZMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TBZMod.MOD_ID);

    public static final RegistryObject<MenuType<MarsSmithingTableMenu>> MARS_SMITHING_TABLE =
            MENUS.register("mars_smithing_table", () -> IForgeMenuType.create(MarsSmithingTableMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}