package com.chinaex123.tbz.event.trade;

import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 材料交易生成器
 * <p>
 * 功能：为火星锻造师生成各种材料交易
 * <p>
 * 交易类型：
 * <ul>
 *   <li>基础材料交易 - 铁换金、钻石换绿宝石等</li>
 *   <li>高级材料交易 - 下界合金换钻石等</li>
 *   <li>随机材料交易 - 从多个可能输出中随机选择</li>
 *   <li>自定义材料交易 - ASCENDANT_SHARD和ASCENDANT_ALLOY相关交易</li>
 * </ul>
 */
public class TBZMaterialTrades {

    /**
     * 获取所有等级的材料交易
     *
     * @return 包含所有等级交易的Map，key为等级(1-5)，value为该等级的交易列表
     */
    public static Map<Integer, List<VillagerTrades.ItemListing>> getAllTrades() {
        Map<Integer, List<VillagerTrades.ItemListing>> trades = new java.util.HashMap<>();

        // 初始化每个等级的交易列表
        for (int level = 1; level <= 5; level++) {
            trades.put(level, new ArrayList<>());
        }

        // 添加各等级交易
        addLevel1Trades(trades);
        addLevel2Trades(trades);
        addLevel3Trades(trades);
        addLevel4Trades(trades);
        addLevel5Trades(trades);

        return trades;
    }

    /** 1级新手 **/
    private static void addLevel1Trades(Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        // 增强棱镜+紫水晶碎片 → 煤炭/铜锭/铁锭
        trades.get(1).add(createRandomMaterialTrade(
                new ItemStack(TBZItems.ENHANCEMENT_PRISM.get(), 1),
                new ItemStack[]{
                        new ItemStack(Items.COAL, 32),
                        new ItemStack(Items.COPPER_INGOT, 16),
                        new ItemStack(Items.IRON_INGOT, 4),
                },
                128, 5, 0.5f
        ));
        // 粗铁 → 铁锭
        trades.get(1).add(createMaterialTrade(
                new ItemStack(Items.RAW_IRON, 1),
                new ItemStack(Items.IRON_INGOT, 2),
                128, 5, 0.5f
        ));
        // 粗铜 → 铜锭
        trades.get(1).add(createMaterialTrade(
                new ItemStack(Items.RAW_COPPER, 1),
                new ItemStack(Items.COPPER_INGOT, 2),
                128, 5, 0.5f
        ));
    }

    /** 2级学徒 **/
    private static void addLevel2Trades(Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        // 增强棱镜+紫水晶碎片 → 金锭/钻石/绿宝石
        trades.get(2).add(createRandomMaterialTrade(
                new ItemStack(TBZItems.ENHANCEMENT_PRISM.get(), 1),
                new ItemStack[]{
                        new ItemStack(Items.GOLD_INGOT, 8),
                        new ItemStack(Items.DIAMOND, 2),
                        new ItemStack(Items.EMERALD, 4),
                },
                128, 10, 0.5f
        ));
    }

    /** 3级老手 **/
    private static void addLevel3Trades(Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        // 上维碎片 → 海洋之心
        trades.get(3).add(createMaterialTrade(
                new ItemStack(TBZItems.ASCENDANT_SHARD.get(), 8),
                new ItemStack(Items.HEART_OF_THE_SEA, 1),
                2, 20, 0.5f
        ));
        // 增强棱镜+紫水晶碎片 → 石英/烈焰棒
        trades.get(3).add(createDualItemRandomTrade(
                new ItemStack(TBZItems.ENHANCEMENT_PRISM.get(), 1),
                new ItemStack(Items.AMETHYST_SHARD, 2),
                new ItemStack[]{
                        new ItemStack(Items.QUARTZ, 16),
                        new ItemStack(Items.BLAZE_ROD, 2)
                },
                12, 20, 0.5f
        ));
    }

    /** 4级专家 **/
    private static void addLevel4Trades(Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        // 增强棱镜 → 鳞甲
        trades.get(4).add(createMaterialTrade(
                new ItemStack(TBZItems.ASCENDANT_SHARD.get(), 2),
                new ItemStack(Items.SCUTE, 1),
                8, 25, 0.5f
        ));
        // 增强棱镜+烈焰棒 → 远古残骸
        trades.get(4).add(createDualItemTrade(
                new ItemStack(TBZItems.ENHANCEMENT_PRISM.get(), 8),
                new ItemStack(Items.BLAZE_ROD, 4),
                new ItemStack(Items.ANCIENT_DEBRIS, 2),
                4, 25, 0.5f
        ));
        // 钻石 → 增强棱镜
        trades.get(4).add(createMaterialTrade(
                new ItemStack(Items.DIAMOND, 4),
                new ItemStack(TBZItems.ENHANCEMENT_PRISM.get(), 1),
                16, 25, 0.5f
        ));
    }

    /** 5级大师 **/
    private static void addLevel5Trades(Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        // 下界之星 → 上维碎片
        trades.get(5).add(createMaterialTrade(
                new ItemStack(Items.NETHER_STAR, 1),
                new ItemStack(TBZItems.ASCENDANT_SHARD.get(), 4),
                4, 35, 0.5f
        ));
        // 上维合金 → 下界之星
        trades.get(5).add(createMaterialTrade(
                new ItemStack(TBZItems.ASCENDANT_ALLOY.get(), 1),
                new ItemStack(Items.NETHER_STAR, 1),
                4, 35, 0.5f
        ));
        // 下界合金锭 → 上维合金
        trades.get(5).add(createMaterialTrade(
                new ItemStack(Items.NETHERITE_INGOT, 8),
                new ItemStack(TBZItems.ASCENDANT_ALLOY.get(), 1),
                2, 35, 0.5f
        ));
    }

    /**
     * 创建材料交易（输入→输出）
     *
     * @param input 输入物品
     * @param output 输出物品
     * @param maxUses 最大交易次数
     * @param xpValue 经验值奖励
     * @param priceMultiplier 价格乘数
     * @return 交易对象
     */
    private static VillagerTrades.ItemListing createMaterialTrade(ItemStack input, ItemStack output, int maxUses, int xpValue, float priceMultiplier) {
        return (trader, rand) -> new MerchantOffer(input, output, maxUses, xpValue, priceMultiplier);
    }

    /**
     * 创建双物品交易（两个输入→输出）
     *
     * @param inputA 第一个输入物品
     * @param inputB 第二个输入物品
     * @param output 输出物品
     * @param maxUses 最大交易次数
     * @param xpValue 经验值奖励
     * @param priceMultiplier 价格乘数
     * @return 交易对象
     */
    private static VillagerTrades.ItemListing createDualItemTrade(ItemStack inputA, ItemStack inputB, ItemStack output, int maxUses, int xpValue, float priceMultiplier) {
        return (trader, rand) -> new MerchantOffer(inputA, inputB, output, maxUses, xpValue, priceMultiplier);
    }

    /**
     * 创建随机材料交易（从多个可能输出中随机选择一个）
     *
     * @param cost 花费物品
     * @param possibleOutputs 可能的输出物品数组
     * @param maxUses 最大交易次数
     * @param xpValue 经验值奖励
     * @param priceMultiplier 价格乘数
     * @return 交易对象
     */
    private static VillagerTrades.ItemListing createRandomMaterialTrade(ItemStack cost, ItemStack[] possibleOutputs, int maxUses, int xpValue, float priceMultiplier) {
        return (trader, rand) -> {
            // 随机选择一个输出
            ItemStack selectedOutput = possibleOutputs[rand.nextInt(possibleOutputs.length)];
            return new MerchantOffer(cost, selectedOutput, maxUses, xpValue, priceMultiplier);
        };
    }

    /**
     * 创建双物品随机交易（两个输入→多个可能输出中随机选择一个）
     *
     * @param inputA 第一个输入物品
     * @param inputB 第二个输入物品
     * @param possibleOutputs 可能的输出物品数组
     * @param maxUses 最大交易次数
     * @param xpValue 经验值奖励
     * @param priceMultiplier 价格乘数
     * @return 交易对象
     */
    private static VillagerTrades.ItemListing createDualItemRandomTrade(ItemStack inputA, ItemStack inputB, ItemStack[] possibleOutputs, int maxUses, int xpValue, float priceMultiplier) {
        return (trader, rand) -> {
            // 随机选择一个输出
            ItemStack selectedOutput = possibleOutputs[rand.nextInt(possibleOutputs.length)];
            return new MerchantOffer(inputA, inputB, selectedOutput, maxUses, xpValue, priceMultiplier);
        };
    }

    /**
     * 创建随机数量交易（输出数量在指定范围内随机）
     *
     * @param costItem 花费物品
     * @param outputItem 输出物品
     * @param minCount 最小数量
     * @param maxCount 最大数量
     * @param maxUses 最大交易次数
     * @param xpValue 经验值奖励
     * @param priceMultiplier 价格乘数
     * @return 交易对象
     */
    private static VillagerTrades.ItemListing createTradeWithRandomCount(ItemStack costItem, ItemStack outputItem, int minCount, int maxCount, int maxUses, int xpValue, float priceMultiplier) {
        return (trader, rand) -> {
            // 随机生成数量
            int count = minCount + rand.nextInt(maxCount - minCount + 1);
            ItemStack actualOutput = outputItem.copy();
            actualOutput.setCount(count);
            return new MerchantOffer(costItem, actualOutput, maxUses, xpValue, priceMultiplier);
        };
    }
}