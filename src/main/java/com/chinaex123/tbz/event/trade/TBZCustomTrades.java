package com.chinaex123.tbz.event.trade;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.init.TBZVillagerProfessions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;

/**
 * 自定义交易主类
 * <p>
 * 功能：为火星锻造师村民添加所有自定义交易
 * <p>
 * 交易类型：
 * <ul>
 *   <li>附魔书交易 - 由TBZEnchantedBookTrades提供</li>
 *   <li>材料交易 - 由TBZMaterialTrades提供</li>
 * </ul>
 * <p>
 * 交易方式：
 * <ul>
 *   <li>附魔书：ASCENDANT_SHARD 或 ASCENDANT_ALLOY (1-24个) + 书 -> 附魔书</li>
 *   <li>材料：各种基础和高级材料的交换交易</li>
 * </ul>
 */
@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID)
public class TBZCustomTrades {
    
    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType() != TBZVillagerProfessions.MARS_SMITH.get()) {
            return;
        }

        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        
        // 添加附魔书交易
        addEnchantedBookTrades(trades);
        
        // 添加材料交易
        addMaterialTrades(trades);
    }

    /**
     * 添加附魔书交易
     * 调用TBZEnchantedBookTrades获取所有等级的附魔书交易
     */
    private static void addEnchantedBookTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades) {
        Map<Integer, List<VillagerTrades.ItemListing>> enchantedBookTrades = TBZEnchantedBookTrades.getAllTrades();

        for (int level = 1; level <= 5; level++) {
            List<VillagerTrades.ItemListing> levelTrades = trades.get(level);
            if (levelTrades != null && enchantedBookTrades.containsKey(level)) {
                levelTrades.addAll(enchantedBookTrades.get(level));
            }
        }
    }
    
    /**
     * 添加材料交易
     * 调用TBZMaterialTrades获取所有等级的材料交易
     */
    private static void addMaterialTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades) {
        Map<Integer, List<VillagerTrades.ItemListing>> materialTrades = TBZMaterialTrades.getAllTrades();

        for (int level = 1; level <= 5; level++) {
            List<VillagerTrades.ItemListing> levelTrades = trades.get(level);
            if (levelTrades != null && materialTrades.containsKey(level)) {
                levelTrades.addAll(materialTrades.get(level));
            }
        }
    }
}