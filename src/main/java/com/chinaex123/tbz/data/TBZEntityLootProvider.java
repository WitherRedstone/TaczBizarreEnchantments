//package com.chinaex123.tbz.data;
//
//import com.chinaex123.tbz.init.TBZItems;
//import net.minecraft.data.loot.EntityLootSubProvider;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.flag.FeatureFlags;
//import net.minecraft.world.level.storage.loot.LootPool;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.entries.LootItem;
//import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
//import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
//import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
//import net.minecraftforge.common.Tags;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class TBZEntityLootProvider extends EntityLootSubProvider {
//
//    public TBZEntityLootProvider() {
//        super(FeatureFlags.VANILLA_SET, FeatureFlags.VANILLA_SET);
//    }
//
//    @Override
//    public void generate() {
//        // 为所有实体生成战利品表
//        ForgeRegistries.ENTITY_TYPES.getValues().stream()
//            .forEach(entityType -> {
//                if (entityType.is(Tags.EntityTypes.BOSSES)) {
//                    // Boss实体：生成包含额外掉落的战利品表
//                    this.addBossDrops(entityType);
//                } else {
//                    // 非Boss实体：生成空战利品表
//                    this.add(entityType, LootTable.lootTable());
//                }
//            });
//    }
//
//    private void addBossDrops(EntityType<?> entityType) {
//        // 创建战利品表
//        LootTable.Builder builder = LootTable.lootTable();
//
//        // 添加ASCENDANT_SHARD掉落池 (1-3个)
//        builder.withPool(
//                LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1))
//                        .add(LootItem.lootTableItem(TBZItems.ASCENDANT_SHARD.get())
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
//                        )
//        );
//
//        // 添加ASCENDANT_ALLOY掉落池 (5%概率)
//        builder.withPool(
//                LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1))
//                        .add(LootItem.lootTableItem(TBZItems.ASCENDANT_ALLOY.get())
//                                .setWeight(5)  // 5%权重
//                                .setQuality(0)
//                        )
//        );
//
//        // 添加到战利品表
//        this.add(entityType, builder);
//    }
//}