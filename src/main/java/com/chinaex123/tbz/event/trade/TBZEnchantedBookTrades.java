package com.chinaex123.tbz.event.trade;

import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.init.TBZItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Supplier;

import static com.chinaex123.funky_effect_lib.FunkyEffectLib.LOGGER;

/**
 * 附魔书交易生成器
 * <p>
 * 功能：为火星锻造师生成自定义附魔书的交易
 * <p>
 * 交易方式：根据稀有度使用不同材料 + 书 -> 附魔书
 * <ul>
 *   <li>COMMON: 随机 2-4 个 ASCENDANT_SHARD + 书 -> 附魔书</li>
 *   <li>UNCOMMON: 随机 4-6 个 ASCENDANT_SHARD + 书 -> 附魔书</li>
 *   <li>RARE: 随机 2-3 个 ASCENDANT_ALLOY + 书 -> 附魔书</li>
 *   <li>VERY_RARE: 随机 3-4 个 ASCENDANT_ALLOY + 书 -> 附魔书</li>
 * </ul>
 * 以上为基础数量，实际交易还会额外固定 +1 个对应材料（等级加成）。
 * <p>
 * 附魔等级加成：根据附魔等级自动 +1 个对应的交易物品
 * <p>
 * 分级限制（哪些稀有度能在该等级刷出）：
 * <ul>
 *   <li>1 级（新手）：COMMON</li>
 *   <li>2 级（学徒）：COMMON、UNCOMMON</li>
 *   <li>3 级（老手）：COMMON、UNCOMMON、RARE</li>
 *   <li>4 级（专家）：COMMON、UNCOMMON、RARE</li>
 *   <li>5 级（大师）：COMMON、UNCOMMON、RARE、VERY_RARE</li>
 * </ul>
 * <p>
 * 特性：
 * <ol>
 *   <li>交易缓存机制 - 只初始化一次，减少内存开销</li>
 *   <li>权重随机选择 - 每个等级随机出现部分附魔，增加多样性</li>
 *   <li>分级限制 - 不同等级村民提供不同稀有度的附魔</li>
 *   <li>稀有度定价 - 不同稀有度使用不同材料和数量</li>
 *   <li>等级加成 - 高等级附魔需要更多材料</li>
 *   <li>去重选择 - selectEnchantmentsForLevel方法确保每个等级不选择重复附魔</li>
 * </ol>
 */
public class TBZEnchantedBookTrades {

    /** 所有自定义附魔列表 **/
    private static final List<Supplier<? extends Enchantment>> ENCHANTMENTS = new ArrayList<>();

    /** 缓存所有交易 - 只初始化一次 **/
    private static final Map<Integer, List<VillagerTrades.ItemListing>> CACHED_TRADES = new HashMap<>();

    /** 是否已初始化交易 **/
    private static boolean initialized = false;

    static {
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
                        LOGGER.error("[TBZEnchantedBookTrades.autoRegisterEnchantments] 无法访问字段: {} - {}", field.getName(), e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            // 反射失败时使用空列表
            LOGGER.error("[TBZEnchantedBookTrades.autoRegisterEnchantments] 自动注册附魔失败: {}", e.getMessage());
        }
    }

    /**
     * 获取所有等级的附魔书交易
     * @return 包含所有等级交易的Map，key为等级(1-5)，value为该等级的交易列表
     */
    public static Map<Integer, List<VillagerTrades.ItemListing>> getAllTrades() {
        // 首次初始化时生成所有交易（只执行一次）
        if (!initialized) {
            initializeTrades();
            initialized = true;
        }
        return CACHED_TRADES;
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
                int actualMaxLevel = Math.min(getMaxLevelForTradeLevel(level), enchantment.getMaxLevel());
                if (actualMaxLevel < 1) continue;

                // 创建并缓存交易
                int finalLevel = level;
                VillagerTrades.ItemListing trade = (trader, randSource) -> {
                    // 随机生成附魔等级（1~实际最大等级）
                    int enchantLevel = 1 + randSource.nextInt(actualMaxLevel);

                    // 根据稀有度决定交易物品和数量
                    MaterialDrop drop = switch (enchantment.getRarity()) {
                        case COMMON -> new MaterialDrop(
                                new ItemStack(TBZItems.ASCENDANT_SHARD.get()),
                                2 + randSource.nextInt(3));
                        case UNCOMMON -> new MaterialDrop(
                                new ItemStack(TBZItems.ASCENDANT_SHARD.get()),
                                4 + randSource.nextInt(3));
                        case RARE -> new MaterialDrop(
                                new ItemStack(TBZItems.ASCENDANT_ALLOY.get()),
                                2 + randSource.nextInt(2));
                        case VERY_RARE -> new MaterialDrop(
                                new ItemStack(TBZItems.ASCENDANT_ALLOY.get()),
                                3 + randSource.nextInt(2));
                        default -> new MaterialDrop(
                                new ItemStack(TBZItems.ASCENDANT_ALLOY.get()),
                                1 + randSource.nextInt(2));
                    };

                    // 根据附魔等级自动+1个对应的物品
//                    int levelBonus = 1; // 固定+1个
//                    int levelBonus = 1 + randSource.nextInt(2); // 1-2个
                    int levelBonus = 1 + (enchantLevel - 1) * 2; // 每升一级 +2
                    int finalCount = drop.count() + levelBonus;

                    ItemStack materialItem = drop.item();
                    materialItem.setCount(finalCount);

                    // 创建附魔书
                    ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(
                            new EnchantmentInstance(enchantment, enchantLevel)
                    );

                    // 返回交易对象：材料 + 书 -> 附魔书
                    return new MerchantOffer(
                            materialItem, new ItemStack(Items.BOOK, 1), enchantedBook,
                            8, finalLevel + 5, 0.05f
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
     *   <li>2级（学徒）：只刷 RARE 附魔</li>
     *   <li>3级（老手）：只刷 RARE 附魔</li>
     *   <li>4级（专家）：只刷 VERY_RARE 附魔</li>
     *   <li>5级（大师）：只刷 VERY_RARE 附魔</li>
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
                case 1 -> enchantment.getRarity() == Enchantment.Rarity.COMMON;
                case 2 -> enchantment.getRarity() == Enchantment.Rarity.COMMON
                        || enchantment.getRarity() == Enchantment.Rarity.UNCOMMON;
                case 3, 4 -> enchantment.getRarity() == Enchantment.Rarity.COMMON
                        || enchantment.getRarity() == Enchantment.Rarity.UNCOMMON
                        || enchantment.getRarity() == Enchantment.Rarity.RARE;
                case 5 -> enchantment.getRarity() == Enchantment.Rarity.COMMON
                        || enchantment.getRarity() == Enchantment.Rarity.UNCOMMON
                        || enchantment.getRarity() == Enchantment.Rarity.RARE
                        || enchantment.getRarity() == Enchantment.Rarity.VERY_RARE;
                default -> false;
            };

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
        return Integer.MAX_VALUE;
//        return switch (tradeLevel) {
//            case 1 -> 2;
//            case 2 -> 3;
//            case 3 -> 4;
//            case 4 -> 5;
//            case 5 -> 10;
//            default -> 3;
//        };
    }

    /**
     * 附魔权重记录类
     * @param enchantment 附魔
     * @param weight 出现权重
     */
    private record EnchantmentWithWeight(Enchantment enchantment, float weight) {}

    /**
     * 材料掉落记录类
     * @param item  掉落物品
     * @param count 基础数量（未含等级加成）
     */
    private record MaterialDrop(ItemStack item, int count) {}
}