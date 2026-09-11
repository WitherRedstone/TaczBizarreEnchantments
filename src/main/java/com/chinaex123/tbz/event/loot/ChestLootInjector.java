package com.chinaex123.tbz.event.loot;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 箱子战利品注入器
 * <p>
 * 功能：为各种箱子添加自定义物品掉落
 * <p>
 * 机制：
 * <ol>
 *   <li>根据不同箱子类型配置不同的战利品</li>
 *   <li>支持强化棱镜、飞升碎片、飞升合金三种物品</li>
 *   <li>每个物品有独立的生成概率和数量范围</li>
 *   <li>使用配置文件的概率值</li>
 * </ol>
 */
@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID)
public class ChestLootInjector {

    private static final Supplier<Double> ENHANCEMENT_PRISM_CHANCE = TBZServerConfig.CHEST_LOOTS_ENHANCEMENT_PRISM_CHANCE;
    private static final Supplier<Double> ASCENDANT_SHARD_CHANCE = TBZServerConfig.CHEST_LOOTS_ASCENDANT_SHARD_CHANCE;
    private static final Supplier<Double> ASCENDANT_ALLOY_CHANCE = TBZServerConfig.CHEST_LOOTS_ASCENDANT_ALLOY_CHANCE;

    /**
     * 战利品表配置
     *
     * @param table 战利品表路径
     * @param entries 战利品条目
     */
    record LootTableSpec(String table, LootEntry... entries) {}

    /**
     * 战利品条目
     *
     * @param name 物品名称（用于生成池名称）
     * @param item 物品提供者
     * @param chance 概率提供者
     * @param min 最小数量
     * @param max 最大数量
     */
    record LootEntry(String name, Supplier<Item> item, Supplier<Double> chance, int min, int max) {}

    private static final List<LootTableSpec> LOOT_CONFIGS = Arrays.asList(
            // 简单地牢箱子
            spec("chests/simple_dungeon",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 0, 3)),
            // 废弃矿井箱子
            spec("chests/abandoned_mineshaft",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 1, 3)),
            // 林地府邸箱子
            spec("chests/woodland_mansion",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 1, 5)),
            // 沙漠神殿箱子
            spec("chests/desert_pyramid",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 1, 5)),
            // 废弃传送门箱子
            spec("chests/ruined_portal",
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 0, 1)),
            // 沉船宝藏箱子
            spec("chests/shipwreck_treasure",
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 0, 1)),
            // 埋葬的宝藏箱子
            spec("chests/buried_treasure",
                    entry("ascendant_alloy", TBZItems.ASCENDANT_ALLOY, ASCENDANT_ALLOY_CHANCE, 1, 1)),
            // 远古城市箱子
            spec("chests/ancient_city",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 1, 4),
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 0, 2),
                    entry("ascendant_alloy", TBZItems.ASCENDANT_ALLOY, ASCENDANT_ALLOY_CHANCE, 0, 1)),

            // 堡垒遗迹藏宝室箱子
            spec("chests/bastion_treasure",
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 1, 2)),
            // 堡垒遗迹疣猪兽棚子
            spec("chests/bastion_hoglin_stable",
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 1, 2)),
            // 堡垒遗迹其他箱子
            spec("chests/bastion_other",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 1, 3),
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 0, 1)),

            // 末地城宝藏
            spec("chests/end_city_treasure",
                    entry("enhancement_prism", TBZItems.ENHANCEMENT_PRISM, ENHANCEMENT_PRISM_CHANCE, 2, 5),
                    entry("ascendant_shard", TBZItems.ASCENDANT_SHARD, ASCENDANT_SHARD_CHANCE, 1, 2),
                    entry("ascendant_alloy", TBZItems.ASCENDANT_ALLOY, ASCENDANT_ALLOY_CHANCE, 0, 3))
    );

    /**
     * 创建战利品表配置
     */
    private static LootTableSpec spec(String table, LootEntry... entries) {
        return new LootTableSpec(table, entries);
    }

    /**
     * 创建战利品条目
     */
    private static LootEntry entry(String name, Supplier<Item> item, Supplier<Double> chance, int min, int max) {
        return new LootEntry(name, item, chance, min, max);
    }

    // ==================== 事件处理 ====================

    /**
     * 战利品表加载事件处理
     * 为匹配的箱子类型注入自定义战利品
     *
     * @param event 战利品表加载事件
     */
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        String tablePath = event.getName().toString();

        // 查找匹配的战利品配置
        for (LootTableSpec spec : LOOT_CONFIGS) {
            if (tablePath.contains(spec.table())) {
                // 注入所有战利品条目
                for (LootEntry entry : spec.entries()) {
                    injectLoot(event, entry);
                }
                break;
            }
        }
    }

    /**
     * 注入单个战利品条目
     *
     * @param event 战利品表加载事件
     * @param entry 战利品条目
     */
    private static void injectLoot(LootTableLoadEvent event, LootEntry entry) {
        double chance = entry.chance().get();
        if (chance <= 0 || entry.min() > entry.max()) return;

        // 提取箱子类型名称用于池命名
        String chestType = event.getName().getPath().replace("chests/", "");

        // 创建并添加战利品池
        event.getTable().addPool(LootPool.lootPool()
                .setRolls(UniformGenerator.between(1.0f, 1.0f))
                .when(LootItemRandomChanceCondition.randomChance((float) chance))
                .add(LootItem.lootTableItem(entry.item().get()))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(entry.min(), entry.max())))
                .name("tbz:" + entry.name() + "_" + chestType)
                .build());
    }
}