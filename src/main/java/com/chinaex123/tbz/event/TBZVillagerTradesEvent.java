package com.chinaex123.tbz.event;

import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 村民交易事件处理类
 * 功能：为图书管理员村民添加模组附魔书的交易选项
 * 机制：每个附魔有独立的出现概率，价格根据附魔稀有度、交易等级和附魔等级动态计算
 */
@Mod.EventBusSubscriber(modid = "tbz")
public class TBZVillagerTradesEvent {

    // 存储所有附魔及其出现概率
    private static final Map<Supplier<? extends Enchantment>, Float> ENCHANTMENTS = new HashMap<>();

    // 初始化附魔列表和出现概率
    static {
        ENCHANTMENTS.put(TBZEnchantments.AMBITIOUS_ASSASSIN, 0.20f);
        ENCHANTMENTS.put(TBZEnchantments.BORPAL_WEAPON, 0.15f);
        ENCHANTMENTS.put(TBZEnchantments.HEAL_CLIP, 0.20f);
        ENCHANTMENTS.put(TBZEnchantments.SUBSISTENCE, 0.10f);
        ENCHANTMENTS.put(TBZEnchantments.RECONSTRUCTION, 0.15f);
        ENCHANTMENTS.put(TBZEnchantments.TRIPLE_TAP, 0.08f);
        ENCHANTMENTS.put(TBZEnchantments.FOURTH_TIME_THE_CHARM, 0.08f);
        ENCHANTMENTS.put(TBZEnchantments.REWIND_ROUNDS, 0.08f);
        ENCHANTMENTS.put(TBZEnchantments.ATTRITION_ORBS, 0.18f);
    }

    /**
     * 村民交易事件处理
     * 仅为图书管理员职业添加附魔书交易
     *
     * @param event 村民交易事件
     */
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        // 仅处理图书管理员村民
        if (event.getType() != VillagerProfession.LIBRARIAN) {
            return;
        }

        // 遍历1-5级交易
        for (int level = 1; level <= 5; level++) {
            List<VillagerTrades.ItemListing> trades = event.getTrades().get(level);
            if (trades == null) continue;

            // 为所有注册的附魔添加交易
            for (Map.Entry<Supplier<? extends Enchantment>, Float> entry : ENCHANTMENTS.entrySet()) {
                addEnchantmentTrade(trades, entry.getKey().get(), level, entry.getValue());
            }
        }
    }

    /**
     * 为指定交易等级添加单个附魔的交易
     *
     * @param trades      交易列表
     * @param enchantment 附魔实例
     * @param tradeLevel  交易等级（1-5）
     * @param spawnChance 出现概率（0-1）
     */
    private static void addEnchantmentTrade(List<VillagerTrades.ItemListing> trades,
                                            Enchantment enchantment, int tradeLevel, float spawnChance) {
        trades.add((trader, rand) -> {
            // 根据概率决定是否生成此交易
            if (rand.nextFloat() > spawnChance) {
                return null;
            }

            // 获取当前交易等级允许的最大附魔等级
            int maxLevelForTrade = getMaxLevelForTradeLevel(tradeLevel);
            int actualMaxLevel = Math.min(maxLevelForTrade, enchantment.getMaxLevel());

            // 如果最大等级小于1，无法生成有效交易
            if (actualMaxLevel < 1) return null;

            // 随机生成附魔等级
            int enchantLevel = 1 + rand.nextInt(actualMaxLevel);

            // 计算价格（绿宝石数量）
            int cost = calculatePrice(enchantment, tradeLevel, enchantLevel, rand);

            // 创建附魔书
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(enchantment, enchantLevel)
            );

            // 创建交易选项
            // 参数：成本物品（绿宝石x数量）、卖出物品（书x1）、交易物品（附魔书）、最大使用次数、经验值、价格乘数
            return new MerchantOffer(
                    new ItemStack(Items.EMERALD, cost), // 玩家支付：cost个绿宝石
                    new ItemStack(Items.BOOK, 1), // 玩家提供：1本书
                    enchantedBook, // 村民提供：附魔书
                    12, // 最大交易次数
                    tradeLevel + 4, // 给予的经验值
                    0.05f // 价格乘数（影响涨价幅度）
            );
        });
    }

    /**
     * 根据交易等级获取允许的附魔最大等级
     * 等级越高，可获得的附魔等级上限越高
     *
     * @param tradeLevel 村民交易等级（1-5）
     * @return 允许的最大附魔等级
     */
    private static int getMaxLevelForTradeLevel(int tradeLevel) {
        return switch (tradeLevel) {
            case 1 -> 2;   // 新手：最高附魔等级2
            case 2 -> 3;   // 学徒：最高附魔等级3
            case 3 -> 4;   // 老手：最高附魔等级4
            case 4 -> 5;   // 专家：最高附魔等级5
            case 5 -> 10;  // 大师：最高附魔等级10（支持自定义高等级）
            default -> 3;  // 默认值
        };
    }

    /**
     * 计算附魔书的价格（绿宝石数量）
     * 价格受以下因素影响：
     * - 附魔稀有度（基础价格）
     * - 交易等级（等级越高，价格越优惠）
     * - 附魔等级（等级越高，价格越贵）
     * - 随机浮动（85%-115%）
     *
     * @param enchantment  附魔实例
     * @param tradeLevel   交易等级
     * @param enchantLevel 附魔等级
     * @param rand         随机数生成器
     * @return 最终价格（限制在5-64之间）
     */
    private static int calculatePrice(Enchantment enchantment, int tradeLevel, int enchantLevel, RandomSource rand) {
        // 根据附魔稀有度确定基础价格
        int basePrice = switch (enchantment.getRarity()) {
            case COMMON -> 5;        // 普通：5绿宝石
            case UNCOMMON -> 8;      // 罕见：8绿宝石
            case RARE -> 10;         // 稀有：10绿宝石
            case VERY_RARE -> 15;    // 极其稀有：15绿宝石
        };

        // 交易等级修正：高等级村民提供更优惠的价格（减价）
        int levelModifier = (5 - tradeLevel) * 2;  // 交易等级5时0，等级1时+8

        // 附魔等级附加成本：每级增加3绿宝石
        int levelCost = enchantLevel * 3;

        // 基础价格计算
        int cost = basePrice + levelCost + levelModifier;

        // 随机价格浮动：85% - 115%
        float variation = 0.85f + rand.nextFloat() * 0.3f;
        cost = Math.round(cost * variation);

        // 限制价格范围：最小5绿宝石，最大64绿宝石
        return Math.min(Math.max(cost, 5), 64);
    }
}