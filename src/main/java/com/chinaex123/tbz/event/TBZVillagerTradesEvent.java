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
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Supplier;

/**
 * 村庄交易事件处理类
 * <p>
 * 功能：为图书管理员村民添加自定义附魔书的交易
 * <p>
 * 优化特性：
 * <ol>
 *   <li>交易缓存机制 - 只初始化一次，减少内存开销</li>
 *   <li>优化价格计算 - 更合理的价格曲线，稀有度影响更明显</li>
 *   <li>权重随机选择 - 每个等级随机出现部分附魔，增加多样性</li>
 *   <li>价格范围 5~55 绿宝石，分布更均匀</li>
 * </ol>
 */
@Mod.EventBusSubscriber(modid = "tbz")
public class TBZVillagerTradesEvent {

    /** 所有自定义附魔列表 **/
    private static final List<Supplier<? extends Enchantment>> ENCHANTMENTS = new ArrayList<>();

    /** 缓存所有交易 - 只初始化一次 **/
    private static final Map<Integer, List<VillagerTrades.ItemListing>> CACHED_TRADES = new HashMap<>();

    /** 价格配置缓存 - 避免重复计算 **/
    private static final Map<Enchantment.Rarity, PriceConfig> PRICE_CONFIGS = new EnumMap<>(Enchantment.Rarity.class);

    /** 是否已初始化交易 **/
    private static boolean initialized = false;

    static {
        // 初始化价格配置
        PRICE_CONFIGS.put(Enchantment.Rarity.COMMON, new PriceConfig(8, 1.0, 2));
        PRICE_CONFIGS.put(Enchantment.Rarity.UNCOMMON, new PriceConfig(14, 1.25, 4));
        PRICE_CONFIGS.put(Enchantment.Rarity.RARE, new PriceConfig(20, 1.5, 6));
        PRICE_CONFIGS.put(Enchantment.Rarity.VERY_RARE, new PriceConfig(28, 1.75, 8));

        // 自动扫描TBZEnchantments类中的所有附魔
        autoRegisterEnchantments();
    }

    /**
     * 自动扫描TBZEnchantments类中的所有附魔并注册
     * 使用反射自动获取所有RegistryObject<Enchantment>类型的字段
     */
    private static void autoRegisterEnchantments() {
        try {
            Field[] fields = TBZEnchantments.class.getDeclaredFields();
            for (Field field : fields) {
                // 检查字段类型是否为RegistryObject<Enchantment>
                if (field.getType() == RegistryObject.class) {
                    try {
                        @SuppressWarnings("unchecked")
                        RegistryObject<Enchantment> enchantmentObj = (RegistryObject<Enchantment>) field.get(null);
                        if (enchantmentObj != null) {
                            ENCHANTMENTS.add(enchantmentObj);
                        }
                    } catch (IllegalAccessException e) {
                        // 忽略无法访问的字段
                        System.err.println("[TBZVillagerTradesEvent.autoRegisterEnchantments] Failed to access field: " + field.getName() + " - " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            // 反射失败时使用空列表
            System.err.println("[TBZVillagerTradesEvent.autoRegisterEnchantments] Failed to auto-register enchantments: " + e.getMessage());
        }
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() != VillagerProfession.LIBRARIAN) {
            return;
        }

        // 首次初始化时生成所有交易（只执行一次）
        if (!initialized) {
            initializeTrades();
            initialized = true;
        }

        // 使用缓存的交易列表
        for (int level = 1; level <= 5; level++) {
            List<VillagerTrades.ItemListing> trades = event.getTrades().get(level);
            if (trades != null && CACHED_TRADES.containsKey(level)) {
                trades.addAll(CACHED_TRADES.get(level));
            }
        }
    }

    /**
     * 初始化所有交易（只执行一次）
     * 每个等级随机选择部分附魔，而不是全部
     */
    private static void initializeTrades() {
        RandomSource rand = RandomSource.create();

        for (int level = 1; level <= 5; level++) {
            List<VillagerTrades.ItemListing> levelTrades = new ArrayList<>();

            // 为每个等级选择 3~7 种附魔（新手少，大师多）
            List<Enchantment> selectedEnchantments = selectEnchantmentsForLevel(level, rand);

            for (Enchantment enchantment : selectedEnchantments) {
                int maxLevelForTrade = getMaxLevelForTradeLevel(level);
                int actualMaxLevel = Math.min(maxLevelForTrade, enchantment.getMaxLevel());
                if (actualMaxLevel < 1) continue;

                PriceConfig priceConfig = PRICE_CONFIGS.get(enchantment.getRarity());
                if (priceConfig == null) continue;

                int finalLevel = level;

                // 创建并缓存交易
                VillagerTrades.ItemListing trade = (trader, randSource) -> {
                    // 随机生成附魔等级（1~实际最大等级）
                    int enchantLevel = 1 + randSource.nextInt(actualMaxLevel);

                    // 使用优化后的价格计算
                    int cost = calculatePriceOptimized(enchantment, finalLevel, enchantLevel, randSource, priceConfig);

                    // 创建附魔书
                    ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(
                            new EnchantmentInstance(enchantment, enchantLevel)
                    );

                    // 返回交易对象
                    return new MerchantOffer(
                            new ItemStack(Items.EMERALD, cost),
                            new ItemStack(Items.BOOK, 1),
                            enchantedBook,
                            8,  // 最大交易次数
                            finalLevel + 4,  // 经验值奖励
                            0.05f  // 价格乘数
                    );
                };

                levelTrades.add(trade);
            }

            CACHED_TRADES.put(level, levelTrades);
        }
    }

    /**
     * 为指定等级选择附魔（基于权重随机）
     * <p>
     * 分级限制规则：
     * <ul>
     *   <li>1级（新手）：只刷 UNCOMMON 附魔</li>
     *   <li>2级（学徒）：刷 UNCOMMON + RARE 附魔</li>
     *   <li>3级（老手）：刷 UNCOMMON + RARE 附魔</li>
     *   <li>4级（专家）：刷 UNCOMMON + RARE + VERY_RARE 附魔</li>
     *   <li>5级（大师）：所有稀有度均可出现</li>
     * </ul>
     *
     * @param level 交易等级（1~5）
     * @param rand  随机源
     * @return 选中的附魔列表
     */
    private static List<Enchantment> selectEnchantmentsForLevel(int level, RandomSource rand) {
        List<EnchantmentWithWeight> candidates = new ArrayList<>();
        float totalWeight = 0;

        for (Supplier<? extends Enchantment> supplier : ENCHANTMENTS) {
            Enchantment enchantment = supplier.get();
            int maxLevel = Math.min(getMaxLevelForTradeLevel(level), enchantment.getMaxLevel());
            if (maxLevel < 1) continue;

            // 分级限制：根据交易等级决定哪些稀有度可以出现
            boolean canAppear = switch (level) {
                case 1 -> enchantment.getRarity() == Enchantment.Rarity.UNCOMMON;   // 1级：只刷 UNCOMMON
                case 2 -> enchantment.getRarity() == Enchantment.Rarity.RARE; // 2级：只刷 RARE
                case 3 -> enchantment.getRarity() == Enchantment.Rarity.RARE; // 3级：只刷 RARE
                case 4 -> enchantment.getRarity() == Enchantment.Rarity.RARE;  // 4级：只刷 VERY_RARE
                case 5 -> enchantment.getRarity() == Enchantment.Rarity.VERY_RARE;  // 5级：只刷 VERY_RARE
                default -> false;
            };
//            boolean canAppear = switch (level) {
//                // 1级：只刷 UNCOMMON
//                case 1 -> enchantment.getRarity() == Enchantment.Rarity.UNCOMMON;
//                // 2级：UNCOMMON + RARE
//                case 2 -> enchantment.getRarity() == Enchantment.Rarity.UNCOMMON ||
//                        enchantment.getRarity() == Enchantment.Rarity.RARE;
//                // 3级：UNCOMMON + RARE
//                case 3 -> enchantment.getRarity() == Enchantment.Rarity.UNCOMMON ||
//                        enchantment.getRarity() == Enchantment.Rarity.RARE;
//                // 4级：UNCOMMON + RARE + VERY_RARE
//                case 4 -> enchantment.getRarity() != Enchantment.Rarity.COMMON;
//                case 5 -> true; // 5级：全部可刷
//                default -> false;
//            };

            if (!canAppear) continue;

            // 获取基础权重（稀有度决定）
            float weight = switch (enchantment.getRarity()) {
                case COMMON -> 0.65f;
                case UNCOMMON -> 0.45f;
                case RARE -> 0.25f;
                case VERY_RARE -> 0.05f;
            };

            // 高级村民能遇到更多稀有附魔（权重提升）
            float levelBonus = 1.0f + (level - 1) * 0.1f;
            weight *= levelBonus;

            candidates.add(new EnchantmentWithWeight(enchantment, weight));
            totalWeight += weight;
        }

        // 每个等级选择数量（3 + level，即 4~8 个）
        int count = Math.min(3 + level, candidates.size());
        List<Enchantment> selected = new ArrayList<>();

        for (int i = 0; i < count && !candidates.isEmpty(); i++) {
            float random = rand.nextFloat() * totalWeight;
            float cumulative = 0;

            Iterator<EnchantmentWithWeight> iterator = candidates.iterator();
            while (iterator.hasNext()) {
                EnchantmentWithWeight ew = iterator.next();
                cumulative += ew.weight;
                if (random <= cumulative) {
                    selected.add(ew.enchantment);
                    totalWeight -= ew.weight;
                    iterator.remove();
                    break;
                }
            }
        }

        return selected;
    }

    /**
     * 获取交易等级对应的最大附魔等级
     *
     * @param tradeLevel 交易等级（1~5）
     * @return 最大附魔等级
     */
    private static int getMaxLevelForTradeLevel(int tradeLevel) {
        return switch (tradeLevel) {
            case 1 -> 2;
            case 2 -> 3;
            case 3 -> 4;
            case 4 -> 5;
            case 5 -> 10;
            default -> 3;
        };
    }

    /**
     * 优化后的价格计算
     * <p>
     * 价格因素：
     * <ol>
     *   <li>附魔稀有度（原版稀有度决定基础价格和倍率）</li>
     *   <li>交易等级（高等级村民更优惠，最多-20%）</li>
     *   <li>附魔等级（非线性增长，高等级更贵）</li>
     *   <li>随机浮动（95%~105%，更稳定）</li>
     * </ol>
     *
     * @param enchantment 附魔类型
     * @param tradeLevel 交易等级
     * @param enchantLevel 附魔等级
     * @param rand 随机源
     * @param priceConfig 价格配置
     * @return 价格（绿宝石数量，范围5~55）
     */
    private static int calculatePriceOptimized(Enchantment enchantment, int tradeLevel, int enchantLevel, RandomSource rand, PriceConfig priceConfig) {
        /* 基础价格 */
        int basePrice = priceConfig.basePrice();

        /* 稀有度价格系数 */
        double rarityFactor = priceConfig.rarityMultiplier();

        /* 每级固定增量 */
        int perLevelIncrease = priceConfig.perLevelIncrease();

        /* 计算交易等级折扣 */
        double discount = 1.0 - (tradeLevel - 1) * 0.03;

        /* 计算基础价格 */
        double cost = (basePrice + (enchantLevel - 1) * perLevelIncrease) * rarityFactor * discount;

        /* 计算随机浮动系数 */
        double variation = 0.95 + rand.nextDouble() * 0.10;
        cost *= variation;

        /* 四舍五入并裁剪*/
        return Math.min(Math.max((int) Math.round(cost), 8), 64);
    }

    /**
     * 价格配置记录类
     * @param basePrice 基础价格
     * @param rarityMultiplier 稀有度价格系数
     * @param perLevelIncrease 每级增加的价格
     */
    private record PriceConfig(int basePrice, double rarityMultiplier, int perLevelIncrease) {}

    /**
     * 附魔权重记录类
     * @param enchantment 附魔
     * @param weight 出现权重
     */
    private record EnchantmentWithWeight(Enchantment enchantment, float weight) {}
}