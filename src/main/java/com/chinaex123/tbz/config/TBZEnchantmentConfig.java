package com.chinaex123.tbz.config;

import com.chinaex123.tbz.TBZMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("removal")
public class TBZEnchantmentConfig {

    // 缓存附魔ID到枪械过滤配置的映射
    private static Map<ResourceLocation, GunFilterConfig> enchantmentsMap = null;

    // 存储附魔ID与其对应的配置项的映射
    private static final Map<String, EnchantmentConfigEntry> ENCHANTMENT_CONFIGS = new HashMap<>();

    // 附魔配置条目记录类
    private record EnchantmentConfigEntry(
        ForgeConfigSpec.BooleanValue whitelistMode,
        ForgeConfigSpec.ConfigValue<List<? extends String>> gunList
    ) {}

    // 枪械过滤配置记录类
    private record GunFilterConfig(
        boolean whitelistMode,
        List<ResourceLocation> gunList
    ) {}

    // 静态初始化块：注册附魔及其对应的配置项
    static {
        // 注册斩首武器附魔配置
        ENCHANTMENT_CONFIGS.put("borpal_weapon", new EnchantmentConfigEntry(
            TBZConfig.BORPAL_WEAPON_WHITELIST_MODE,
            TBZConfig.BORPAL_WEAPON_APPLICABLE_GUNS
        ));
        // 注册治疗弹匣附魔配置
        ENCHANTMENT_CONFIGS.put("heal_clip", new EnchantmentConfigEntry(
            TBZConfig.HEAL_CLIP_WHITELIST_MODE,
            TBZConfig.HEAL_CLIP_APPLICABLE_GUNS
        ));
        // 注册维持生计附魔配置
        ENCHANTMENT_CONFIGS.put("subsistence", new EnchantmentConfigEntry(
            TBZConfig.SUBSISTENCE_WHITELIST_MODE,
            TBZConfig.SUBSISTENCE_APPLICABLE_GUNS
        ));
        // 注册刺客野心附魔配置
        ENCHANTMENT_CONFIGS.put("ambitious_assassin", new EnchantmentConfigEntry(
            TBZConfig.AMBITIOUS_ASSASSIN_WHITELIST_MODE,
            TBZConfig.AMBITIOUS_ASSASSIN_APPLICABLE_GUNS
        ));
        // 注册重建附魔配置
        ENCHANTMENT_CONFIGS.put("reconstruction", new EnchantmentConfigEntry(
            TBZConfig.RECONSTRUCTION_WHITELIST_MODE,
            TBZConfig.RECONSTRUCTION_APPLICABLE_GUNS
        ));
        // 注册精准连击附魔配置
        ENCHANTMENT_CONFIGS.put("triple_tap", new EnchantmentConfigEntry(
            TBZConfig.TRIPLE_TAP_WHITELIST_MODE,
            TBZConfig.TRIPLE_TAP_APPLICABLE_GUNS
        ));
        // 注册事不过四附魔配置
        ENCHANTMENT_CONFIGS.put("fourth_time_the_charm", new EnchantmentConfigEntry(
            TBZConfig.FOURTH_TIME_THE_CHARM_WHITELIST_MODE,
            TBZConfig.FOURTH_TIME_THE_CHARM_APPLICABLE_GUNS
        ));
        // 注册回转弹药附魔配置
        ENCHANTMENT_CONFIGS.put("rewind_rounds", new EnchantmentConfigEntry(
            TBZConfig.REWIND_ROUNDS_WHITELIST_MODE,
            TBZConfig.REWIND_ROUNDS_APPLICABLE_GUNS
        ));
        // 注册羸弱能量球附魔配置
        ENCHANTMENT_CONFIGS.put("attrition_orbs", new EnchantmentConfigEntry(
                TBZConfig.ATTRITION_ORBS_WHITELIST_MODE,
                TBZConfig.ATTRITION_ORBS_APPLICABLE_GUNS
        ));
        // 注册防护编织附魔配置
        ENCHANTMENT_CONFIGS.put("protective_weave", new EnchantmentConfigEntry(
                TBZConfig.PROTECTIVE_WEAVE_WHITELIST_MODE,
                TBZConfig.PROTECTIVE_WEAVE_APPLICABLE_GUNS
        ));
        // 注册精准工具附魔配置
        ENCHANTMENT_CONFIGS.put("precision_instrument", new EnchantmentConfigEntry(
                TBZConfig.PRECISION_INSTRUMENT_WHITELIST_MODE,
                TBZConfig.PRECISION_INSTRUMENT_APPLICABLE_GUNS
        ));
        // 注册重新调度附魔配置
        ENCHANTMENT_CONFIGS.put("mulligan", new EnchantmentConfigEntry(
                TBZConfig.MULLIGAN_WHITELIST_MODE,
                TBZConfig.MULLIGAN_APPLICABLE_GUNS
        ));
        // 注册不法之徒附魔配置
        ENCHANTMENT_CONFIGS.put("outlaw", new EnchantmentConfigEntry(
                TBZConfig.OUTLAW_WHITELIST_MODE,
                TBZConfig.OUTLAW_APPLICABLE_GUNS
        ));
        // 注册直击要害附魔配置
        ENCHANTMENT_CONFIGS.put("gutshot_straight", new EnchantmentConfigEntry(
                TBZConfig.GUTSHOT_STRAIGHT_WHITELIST_MODE,
                TBZConfig.GUTSHOT_STRAIGHT_APPLICABLE_GUNS
        ));
        // 注册枯萎凝视附魔配置
        ENCHANTMENT_CONFIGS.put("withering_gaze", new EnchantmentConfigEntry(
                TBZConfig.WITHERING_GAZE_WHITELIST_MODE,
                TBZConfig.WITHERING_GAZE_APPLICABLE_GUNS
        ));
        // 注册蝴蝶附魔配置
        ENCHANTMENT_CONFIGS.put("butterfly", new EnchantmentConfigEntry(
                TBZConfig.BUTTERFLY_WHITELIST_MODE,
                TBZConfig.BUTTERFLY_APPLICABLE_GUNS
        ));
        // 注册高爆载荷附魔配置
        ENCHANTMENT_CONFIGS.put("explosive_payload", new EnchantmentConfigEntry(
                TBZConfig.EXPLOSIVE_PAYLOAD_WHITELIST_MODE,
                TBZConfig.EXPLOSIVE_PAYLOAD_APPLICABLE_GUNS
        ));
        // 注册萤火虫附魔配置
        ENCHANTMENT_CONFIGS.put("firefly", new EnchantmentConfigEntry(
                TBZConfig.FIREFLY_WHITELIST_MODE,
                TBZConfig.FIREFLY_APPLICABLE_GUNS
        ));
        // 注册蜻蜓附魔配置
        ENCHANTMENT_CONFIGS.put("dragonfly", new EnchantmentConfigEntry(
                TBZConfig.DRAGONFLY_WHITELIST_MODE,
                TBZConfig.DRAGONFLY_APPLICABLE_GUNS
        ));
        // 注册巨脉蜻蜓附魔配置
        ENCHANTMENT_CONFIGS.put("meganeura", new EnchantmentConfigEntry(
                TBZConfig.MEGANEURA_WHITELIST_MODE,
                TBZConfig.MEGANEURA_APPLICABLE_GUNS
        ));
        // 注册风暴涌动附魔配置
        ENCHANTMENT_CONFIGS.put("rolling_storm", new EnchantmentConfigEntry(
                TBZConfig.ROLLING_STORM_WHITELIST_MODE,
                TBZConfig.ROLLING_STORM_APPLICABLE_GUNS
        ));
        // 注册失衡弹药附魔配置
        ENCHANTMENT_CONFIGS.put("destabilizing_rounds", new EnchantmentConfigEntry(
                TBZConfig.DESTABILIZING_ROUNDS_WHITELIST_MODE,
                TBZConfig.DESTABILIZING_ROUNDS_APPLICABLE_GUNS
        ));
        // 注册辉耀炽热附魔配置
        ENCHANTMENT_CONFIGS.put("incandescent", new EnchantmentConfigEntry(
                TBZConfig.INCANDESCENT_WHITELIST_MODE,
                TBZConfig.INCANDESCENT_APPLICABLE_GUNS
        ));
        // 注册冰冷弹匣附魔配置
        ENCHANTMENT_CONFIGS.put("chill_clip", new EnchantmentConfigEntry(
                TBZConfig.CHILL_CLIP_WHITELIST_MODE,
                TBZConfig.CHILL_CLIP_APPLICABLE_GUNS
        ));
        // 注册霜华窃取者附魔配置
        ENCHANTMENT_CONFIGS.put("rimestealer", new EnchantmentConfigEntry(
                TBZConfig.RIMESTEALER_WHITELIST_MODE,
                TBZConfig.RIMESTEALER_APPLICABLE_GUNS
        ));
        // 注册目标锁定附魔配置
        ENCHANTMENT_CONFIGS.put("target_lock", new EnchantmentConfigEntry(
                TBZConfig.TARGET_LOCK_WHITELIST_MODE,
                TBZConfig.TARGET_LOCK_APPLICABLE_GUNS
        ));
        // 注册切割附魔配置
        ENCHANTMENT_CONFIGS.put("slice", new EnchantmentConfigEntry(
                TBZConfig.SLICE_WHITELIST_MODE,
                TBZConfig.SLICE_APPLICABLE_GUNS
        ));








    }

    /**
     * 加载附魔映射
     * 延迟加载，只在第一次使用时初始化
     */
    public static void loadEnchantmentsMapIfNeeded() {
        // 如果已经加载过，直接返回
        if (enchantmentsMap != null) return;

        // 创建新的映射
        enchantmentsMap = new HashMap<>();

        try {
            // 遍历每个已注册的附魔配置
            for (Map.Entry<String, EnchantmentConfigEntry> entry : ENCHANTMENT_CONFIGS.entrySet()) {
                // 获取附魔ID
                String enchantmentId = entry.getKey();
                // 获取对应的配置条目
                EnchantmentConfigEntry configEntry = entry.getValue();

                // 从配置中读取模式
                boolean whitelistMode = configEntry.whitelistMode.get();
                // 从配置中读取枪械列表
                List<? extends String> configGuns = configEntry.gunList.get();

                // 将字符串列表转换为ResourceLocation列表
                List<ResourceLocation> gunList = configGuns == null || configGuns.isEmpty() ? 
                    Collections.emptyList() : 
                    configGuns.stream()
                        .map(ResourceLocation::new)
                        .collect(Collectors.toList());

                // 将附魔ID和枪械过滤配置存入映射
                enchantmentsMap.put(
                    new ResourceLocation(TBZMod.MOD_ID, enchantmentId),
                    new GunFilterConfig(whitelistMode, gunList)
                );
            }
        } catch (Exception e) {
            // 静默失败，不输出日志
        }
    }

    /**
     * 判断指定的附魔是否可以应用到指定的枪械上
     *
     * @param enchantmentId 附魔的ID
     * @param gunId 枪械的ID
     * @return 如果可以应用则返回true，否则返回false
     */
    public static boolean canApplyEnchantmentToGun(ResourceLocation enchantmentId, ResourceLocation gunId) {
        // 确保映射已加载
        loadEnchantmentsMapIfNeeded();

        // 获取该附魔的枪械过滤配置
        GunFilterConfig filterConfig = enchantmentsMap.get(enchantmentId);
        // 如果没有配置该附魔，返回false
        if (filterConfig == null) return false;

        // 根据模式判断
        if (filterConfig.whitelistMode) {
            // 白名单模式：枪械必须在列表中
            return filterConfig.gunList.contains(gunId);
        } else {
            // 黑名单模式：枪械不能在列表中
            return !filterConfig.gunList.contains(gunId);
        }
    }

    /**
     * 注册一个附魔的配置项
     *
     * @param enchantmentId 附魔ID
     * @param whitelistMode 是否使用白名单模式
     * @param gunList 枪械列表配置
     */
    public static void registerEnchantmentConfig(String enchantmentId, ForgeConfigSpec.BooleanValue whitelistMode, ForgeConfigSpec.ConfigValue<List<? extends String>> gunList) {
        ENCHANTMENT_CONFIGS.put(enchantmentId, new EnchantmentConfigEntry(whitelistMode, gunList));
    }
}