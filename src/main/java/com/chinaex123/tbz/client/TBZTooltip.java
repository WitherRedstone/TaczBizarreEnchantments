package com.chinaex123.tbz.client;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity.RANDOM_PERK_TRUE_TAG;

@Mod.EventBusSubscriber
public class TBZTooltip {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

//        if (stack.getItem() == TBZItems.ASCENDANT_SHARD.get()) {
//            tooltip.add(Component.translatable("item.tbz.ascendant_shard.tooltip").withStyle(ChatFormatting.GREEN));
//        }
//        if (stack.getItem() == TBZItems.ASCENDANT_ALLOY.get()) {
//            tooltip.add(Component.translatable("item.tbz.ascendant_alloy.tooltip").withStyle(ChatFormatting.GREEN));
//        }

        if (hasRandomPerkTag(stack)) {
            tooltip.add(Component.translatable("tooltip.tbz.random_perk").withStyle(ChatFormatting.GREEN));
        }
    }

    private static boolean hasRandomPerkTag(ItemStack stack) {
        if (stack.isEmpty()) return false;
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(RANDOM_PERK_TRUE_TAG);
    }
}