package com.chinaex123.tbz.event.loot;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体战利品注入器
 * <p>
 * 功能：为Boss和敌对生物添加自定义战利品掉落
 * <p>
 * 机制：
 * <ol>
 *   <li>Boss掉落：飞升碎片（固定数量）和飞升合金（概率掉落）</li>
 *   <li>敌对生物掉落：强化棱镜（概率掉落，数量随机）</li>
 *   <li>支持配置Boss列表、掉落数量和概率</li>
 *   <li>防止重复添加战利品到同一实体</li>
 * </ol>
 */
@Mod.EventBusSubscriber(modid = TBZMod.MOD_ID)
public class EntityLootInjector {

    /** 配置的Boss实体ID集合 **/
    private static final Set<ResourceLocation> BOSS_IDS = new HashSet<>();
    /** 已添加战利品的Boss集合（防止重复添加） **/
    private static final Set<ResourceLocation> ADDED_BOSSES = new HashSet<>();
    /** 已添加战利品的敌对生物集合（防止重复添加） **/
    private static final Set<ResourceLocation> ADDED_HOSTILES = new HashSet<>();

    /**
     * 配置重载事件处理
     * 当配置文件重载时，重置已添加集合并重新加载Boss ID
     *
     * @param event 配置重载事件
     */
    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals(TBZMod.MOD_ID)) {
            ADDED_BOSSES.clear();
            ADDED_HOSTILES.clear();
            loadBossIds();
        }
    }

    /**
     * 加载Boss ID列表
     * 从配置文件读取Boss实体ID并存入集合
     */
    @SuppressWarnings("removal")
    static void loadBossIds() {
        BOSS_IDS.clear();
        try {
            var bossList = TBZServerConfig.BOSS_DROP_ENTITIES.get();
            if (bossList != null) {
                for (String bossId : bossList) {
                    try {
                        ResourceLocation id = new ResourceLocation(bossId);
                        BOSS_IDS.add(id);
                    } catch (Exception e) {
                        TBZMod.LOGGER.error("[EntityLootInjector] 解析BossID失败: {}", bossId);
                    }
                }
            }
        } catch (Exception e) {
            TBZMod.LOGGER.error("[EntityLootInjector] 读取Boss配置失败", e);
        }
    }

    /**
     * 战利品表加载事件处理
     * 为匹配的实体注入自定义战利品
     *
     * @param event 战利品表加载事件
     */
    @SubscribeEvent
    @SuppressWarnings("removal")
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableId = event.getName();

        // 仅处理实体战利品表
        String path = tableId.getPath();
        if (path.startsWith("entities/")) {
            String entityName = path.substring("entities/".length());
            ResourceLocation entityId = new ResourceLocation(tableId.getNamespace(), entityName);

            // 获取实体类型
            EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);
            if (entityType != null) {
                // 检查是否为Boss
                if (BOSS_IDS.contains(entityId)) {
                    if (ADDED_BOSSES.contains(entityId)) {
                        return;
                    }
                    addBossLoot(event, entityType);
                    ADDED_BOSSES.add(entityId);
                }

                // 检查是否为敌对生物且启用掉落
                if (TBZServerConfig.HOSTILE_DROP_ENABLED.get() && isHostileEntity(entityType)) {
                    if (ADDED_HOSTILES.contains(entityId)) {
                        return;
                    }
                    addHostileLoot(event, entityType);
                    ADDED_HOSTILES.add(entityId);
                }
            }
        }
    }

    /**
     * 为Boss添加战利品
     * <p>
     * 掉落物品：
     * <ul>
     *   <li>飞升碎片：固定掉落，数量在配置范围内随机</li>
     *   <li>飞升合金：概率掉落，数量固定</li>
     * </ul>
     *
     * @param event 战利品表加载事件
     * @param bossType Boss实体类型
     */
    private static void addBossLoot(LootTableLoadEvent event, EntityType<?> bossType) {
        ResourceLocation registryName = ForgeRegistries.ENTITY_TYPES.getKey(bossType);
        String bossPath = registryName != null ? registryName.getPath() : "boss";

        // 读取配置
        int shardMin = TBZServerConfig.ASCENDANT_SHARD_MIN_COUNT.get();
        int shardMax = TBZServerConfig.ASCENDANT_SHARD_MAX_COUNT.get();
        int alloyCount = TBZServerConfig.ASCENDANT_ALLOY_COUNT.get();
        double alloyChance = TBZServerConfig.ASCENDANT_ALLOY_CHANCE.get();

        // 飞升碎片战利品池（固定掉落）
        LootPool shardPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(TBZItems.ASCENDANT_SHARD.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between((float) shardMin, (float) shardMax))))
                .name("tbz:ascendant_shard_" + bossPath + "_drop")
                .build();
        event.getTable().addPool(shardPool);

        // 飞升合金战利品池（概率掉落）
        if (alloyCount > 0 && alloyChance > 0) {
            LootPool alloyPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(TBZItems.ASCENDANT_ALLOY.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(alloyCount)))
                            .when(LootItemRandomChanceCondition.randomChance((float) alloyChance)))
                    .name("tbz:ascendant_alloy_" + bossPath + "_drop")
                    .build();
            event.getTable().addPool(alloyPool);
        }
    }

    /**
     * 检查实体是否为敌对生物
     *
     * @param entityType 实体类型
     * @return true表示是敌对生物
     */
    private static boolean isHostileEntity(EntityType<?> entityType) {
        return entityType.getCategory() == MobCategory.MONSTER;
    }

    /**
     * 为敌对生物添加战利品
     * <p>
     * 掉落物品：
     * <ul>
     *   <li>强化棱镜：概率掉落，数量在配置范围内随机</li>
     * </ul>
     *
     * @param event 战利品表加载事件
     * @param hostileType 敌对生物实体类型
     */
    private static void addHostileLoot(LootTableLoadEvent event, EntityType<?> hostileType) {
        ResourceLocation registryName = ForgeRegistries.ENTITY_TYPES.getKey(hostileType);
        String hostilePath = registryName != null ? registryName.getPath() : "hostile";

        // 读取配置
        int prismMin = TBZServerConfig.ENHANCEMENT_PRISM_MIN_COUNT.get();
        int prismMax = TBZServerConfig.ENHANCEMENT_PRISM_MAX_COUNT.get();
        double prismChance = TBZServerConfig.ENHANCEMENT_PRISM_CHANCE.get();

        // 如果配置无效，跳过
        if (prismChance <= 0 || prismMin <= 0 || prismMax <= 0) {
            return;
        }

        // 强化棱镜战利品池（概率掉落，数量随机）
        LootPool prismPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(TBZItems.ENHANCEMENT_PRISM.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between((float) prismMin, (float) prismMax)))
                        .when(LootItemRandomChanceCondition.randomChance((float) prismChance)))
                .name("tbz:enhancement_prism_" + hostilePath + "_drop")
                .build();
        event.getTable().addPool(prismPool);
    }
}