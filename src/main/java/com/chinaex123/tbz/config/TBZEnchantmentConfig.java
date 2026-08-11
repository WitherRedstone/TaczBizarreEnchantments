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
        // ========== [异域]类型附魔 ==========
        // 防护编织
        ENCHANTMENT_CONFIGS.put("protective_weave", new EnchantmentConfigEntry(
                TBZServerConfig.PROTECTIVE_WEAVE_WHITELIST_MODE,
                TBZServerConfig.PROTECTIVE_WEAVE_APPLICABLE_GUNS
        ));
        // 统治浩劫
        ENCHANTMENT_CONFIGS.put("reign_havoc", new EnchantmentConfigEntry(
                TBZServerConfig.REIGN_HAVOC_WHITELIST_MODE,
                TBZServerConfig.REIGN_HAVOC_APPLICABLE_GUNS
        ));
        // SUROS遗产
        ENCHANTMENT_CONFIGS.put("suros_legacy", new EnchantmentConfigEntry(
                TBZServerConfig.SUROS_LEGACY_WHITELIST_MODE,
                TBZServerConfig.SUROS_LEGACY_APPLICABLE_GUNS
        ));
        // 古昧的折磨
        ENCHANTMENT_CONFIGS.put("primevals_torment", new EnchantmentConfigEntry(
                TBZServerConfig.PRIMEVALS_TORMENT_WHITELIST_MODE,
                TBZServerConfig.PRIMEVALS_TORMENT_APPLICABLE_GUNS
        ));
        // 到此为止
        ENCHANTMENT_CONFIGS.put("full_stop", new EnchantmentConfigEntry(
                TBZServerConfig.FULL_STOP_WHITELIST_MODE,
                TBZServerConfig.FULL_STOP_APPLICABLE_GUNS
        ));
        // 蔓延羸弱
        ENCHANTMENT_CONFIGS.put("creeping_attrition", new EnchantmentConfigEntry(
                TBZServerConfig.CREEPING_ATTRITION_WEAPON_TYPE_WHITELIST_MODE,
                TBZServerConfig.CREEPING_ATTRITION_APPLICABLE_GUNS
        ));
        // 恶意触碰
        ENCHANTMENT_CONFIGS.put("touch_of_malice", new EnchantmentConfigEntry(
                TBZServerConfig.TOUCH_OF_MALICE_WEAPON_TYPE_WHITELIST_MODE,
                TBZServerConfig.TOUCH_OF_MALICE_APPLICABLE_GUNS
        ));
        // 正确抉择
        ENCHANTMENT_CONFIGS.put("the_right_choice", new EnchantmentConfigEntry(
                TBZServerConfig.THE_RIGHT_CHOICE_WEAPON_TYPE_WHITELIST_MODE,
                TBZServerConfig.THE_RIGHT_CHOICE_APPLICABLE_GUNS
        ));
        // 十六进制
        ENCHANTMENT_CONFIGS.put("vexadecimal", new EnchantmentConfigEntry(
                TBZServerConfig.VEXADECIMAL_WHITELIST_MODE,
                TBZServerConfig.VEXADECIMAL_APPLICABLE_GUNS
        ));
        // 私人助手
        ENCHANTMENT_CONFIGS.put("personal_assistant", new EnchantmentConfigEntry(
                TBZServerConfig.PERSONAL_ASSISTANT_WHITELIST_MODE,
                TBZServerConfig.PERSONAL_ASSISTANT_APPLICABLE_GUNS
        ));


        // ========== [增伤]类型附魔 ==========
        // 斩首武器
        ENCHANTMENT_CONFIGS.put("borpal_weapon", new EnchantmentConfigEntry(
                TBZServerConfig.BORPAL_WEAPON_WHITELIST_MODE,
                TBZServerConfig.BORPAL_WEAPON_APPLICABLE_GUNS
        ));
        // 精准工具
        ENCHANTMENT_CONFIGS.put("precision_instrument", new EnchantmentConfigEntry(
                TBZServerConfig.PRECISION_INSTRUMENT_WHITELIST_MODE,
                TBZServerConfig.PRECISION_INSTRUMENT_APPLICABLE_GUNS
        ));
        // 目标锁定
        ENCHANTMENT_CONFIGS.put("target_lock", new EnchantmentConfigEntry(
                TBZServerConfig.TARGET_LOCK_WHITELIST_MODE,
                TBZServerConfig.TARGET_LOCK_APPLICABLE_GUNS
        ));
        // 直击要害
        ENCHANTMENT_CONFIGS.put("gutshot_straight", new EnchantmentConfigEntry(
                TBZServerConfig.GUTSHOT_STRAIGHT_WHITELIST_MODE,
                TBZServerConfig.GUTSHOT_STRAIGHT_APPLICABLE_GUNS
        ));
        // 热能雾化
        ENCHANTMENT_CONFIGS.put("thermal_atomization", new EnchantmentConfigEntry(
                TBZServerConfig.THERMAL_ATOMIZATION_WHITELIST_MODE,
                TBZServerConfig.THERMAL_ATOMIZATION_APPLICABLE_GUNS
        ));
        // 斗剑士
        ENCHANTMENT_CONFIGS.put("swashbuckler", new EnchantmentConfigEntry(
                TBZServerConfig.SWASHBUCKLER_WHITELIST_MODE,
                TBZServerConfig.SWASHBUCKLER_APPLICABLE_GUNS
        ));
        // 我为人人
        ENCHANTMENT_CONFIGS.put("one_for_all", new EnchantmentConfigEntry(
                TBZServerConfig.ONE_FOR_ALL_WHITELIST_MODE,
                TBZServerConfig.ONE_FOR_ALL_APPLICABLE_GUNS
        ));
        // 武器大师
        ENCHANTMENT_CONFIGS.put("master_of_arms", new EnchantmentConfigEntry(
                TBZServerConfig.MASTER_OF_ARMS_WHITELIST_MODE,
                TBZServerConfig.MASTER_OF_ARMS_APPLICABLE_GUNS
        ));
        // 聚合充能
        ENCHANTMENT_CONFIGS.put("aggregate_charge", new EnchantmentConfigEntry(
                TBZServerConfig.AGGREGATE_CHARGE_WHITELIST_MODE,
                TBZServerConfig.AGGREGATE_CHARGE_APPLICABLE_GUNS
        ));
        // 火线
        ENCHANTMENT_CONFIGS.put("firing_line", new EnchantmentConfigEntry(
                TBZServerConfig.FIRING_LINE_WHITELIST_MODE,
                TBZServerConfig.FIRING_LINE_APPLICABLE_GUNS
        ));
        // 盒式呼吸法
        ENCHANTMENT_CONFIGS.put("box_breathing", new EnchantmentConfigEntry(
                TBZServerConfig.BOX_BREATHING_WHITELIST_MODE,
                TBZServerConfig.BOX_BREATHING_APPLICABLE_GUNS
        ));
        // 爆炸光能
        ENCHANTMENT_CONFIGS.put("explosive_light", new EnchantmentConfigEntry(
                TBZServerConfig.EXPLOSIVE_LIGHT_WHITELIST_MODE,
                TBZServerConfig.EXPLOSIVE_LIGHT_APPLICABLE_GUNS
        ));

        // ========== [回子弹]类型附魔 ==========
        // 维持生计
        ENCHANTMENT_CONFIGS.put("subsistence", new EnchantmentConfigEntry(
                TBZServerConfig.SUBSISTENCE_WHITELIST_MODE,
                TBZServerConfig.SUBSISTENCE_APPLICABLE_GUNS
        ));
        // 刺客野心
        ENCHANTMENT_CONFIGS.put("ambitious_assassin", new EnchantmentConfigEntry(
                TBZServerConfig.AMBITIOUS_ASSASSIN_WHITELIST_MODE,
                TBZServerConfig.AMBITIOUS_ASSASSIN_APPLICABLE_GUNS
        ));
        // 重建
        ENCHANTMENT_CONFIGS.put("reconstruction", new EnchantmentConfigEntry(
                TBZServerConfig.RECONSTRUCTION_WHITELIST_MODE,
                TBZServerConfig.RECONSTRUCTION_APPLICABLE_GUNS
        ));
        // 精准连击
        ENCHANTMENT_CONFIGS.put("triple_tap", new EnchantmentConfigEntry(
                TBZServerConfig.TRIPLE_TAP_WHITELIST_MODE,
                TBZServerConfig.TRIPLE_TAP_APPLICABLE_GUNS
        ));
        // 事不过四
        ENCHANTMENT_CONFIGS.put("fourth_time_the_charm", new EnchantmentConfigEntry(
                TBZServerConfig.FOURTH_TIME_THE_CHARM_WHITELIST_MODE,
                TBZServerConfig.FOURTH_TIME_THE_CHARM_APPLICABLE_GUNS
        ));
        // 回转弹药
        ENCHANTMENT_CONFIGS.put("rewind_rounds", new EnchantmentConfigEntry(
                TBZServerConfig.REWIND_ROUNDS_WHITELIST_MODE,
                TBZServerConfig.REWIND_ROUNDS_APPLICABLE_GUNS
        ));
        // 重新调度
        ENCHANTMENT_CONFIGS.put("mulligan", new EnchantmentConfigEntry(
                TBZServerConfig.MULLIGAN_WHITELIST_MODE,
                TBZServerConfig.MULLIGAN_APPLICABLE_GUNS
        ));
        // 涓流充能
        ENCHANTMENT_CONFIGS.put("trickle_charge", new EnchantmentConfigEntry(
                TBZServerConfig.TRICKLE_CHARGE_WHITELIST_MODE,
                TBZServerConfig.TRICKLE_CHARGE_APPLICABLE_GUNS
        ));
        // 超充弹匣
        ENCHANTMENT_CONFIGS.put("supercharged_magazine", new EnchantmentConfigEntry(
                TBZServerConfig.SUPERCHARGED_MAGAZINE_WHITELIST_MODE,
                TBZServerConfig.SUPERCHARGED_MAGAZINE_APPLICABLE_GUNS
        ));
        // 命运的逆转
        ENCHANTMENT_CONFIGS.put("reversal_of_fortune", new EnchantmentConfigEntry(
                TBZServerConfig.REVERSAL_OF_FORTUNE_WHITELIST_MODE,
                TBZServerConfig.REVERSAL_OF_FORTUNE_APPLICABLE_GUNS
        ));
        // 小丑皇弹药筒
        ENCHANTMENT_CONFIGS.put("clown_cartridge", new EnchantmentConfigEntry(
                TBZServerConfig.CLOWN_CARTRIDGE_WHITELIST_MODE,
                TBZServerConfig.CLOWN_CARTRIDGE_APPLICABLE_GUNS
        ));

        // ========== [应用效果]类型附魔 ==========
        // 治疗弹匣
        ENCHANTMENT_CONFIGS.put("heal_clip", new EnchantmentConfigEntry(
                TBZServerConfig.HEAL_CLIP_WHITELIST_MODE,
                TBZServerConfig.HEAL_CLIP_APPLICABLE_GUNS
        ));
        // 风暴涌动
        ENCHANTMENT_CONFIGS.put("rolling_storm", new EnchantmentConfigEntry(
                TBZServerConfig.ROLLING_STORM_WHITELIST_MODE,
                TBZServerConfig.ROLLING_STORM_APPLICABLE_GUNS
        ));
        // 失衡弹药
        ENCHANTMENT_CONFIGS.put("destabilizing_rounds", new EnchantmentConfigEntry(
                TBZServerConfig.DESTABILIZING_ROUNDS_WHITELIST_MODE,
                TBZServerConfig.DESTABILIZING_ROUNDS_APPLICABLE_GUNS
        ));
        // 辉耀炽热
        ENCHANTMENT_CONFIGS.put("incandescent", new EnchantmentConfigEntry(
                TBZServerConfig.INCANDESCENT_WHITELIST_MODE,
                TBZServerConfig.INCANDESCENT_APPLICABLE_GUNS
        ));
        // 冰冷弹匣
        ENCHANTMENT_CONFIGS.put("chill_clip", new EnchantmentConfigEntry(
                TBZServerConfig.CHILL_CLIP_WHITELIST_MODE,
                TBZServerConfig.CHILL_CLIP_APPLICABLE_GUNS
        ));
        // 霜华窃取者
        ENCHANTMENT_CONFIGS.put("rimestealer", new EnchantmentConfigEntry(
                TBZServerConfig.RIMESTEALER_WHITELIST_MODE,
                TBZServerConfig.RIMESTEALER_APPLICABLE_GUNS
        ));
        // 切割
        ENCHANTMENT_CONFIGS.put("slice", new EnchantmentConfigEntry(
                TBZServerConfig.SLICE_WHITELIST_MODE,
                TBZServerConfig.SLICE_APPLICABLE_GUNS
        ));
        // 枯萎凝视
        ENCHANTMENT_CONFIGS.put("withering_gaze", new EnchantmentConfigEntry(
                TBZServerConfig.WITHERING_GAZE_WHITELIST_MODE,
                TBZServerConfig.WITHERING_GAZE_APPLICABLE_GUNS
        ));
        // 燃烧野心
        ENCHANTMENT_CONFIGS.put("burning_ambition", new EnchantmentConfigEntry(
                TBZServerConfig.BURNING_AMBITION_WHITELIST_MODE,
                TBZServerConfig.BURNING_AMBITION_APPLICABLE_GUNS
        ));

        // ========== [爆炸]类型附魔 ==========
        // 蝴蝶
        ENCHANTMENT_CONFIGS.put("butterfly", new EnchantmentConfigEntry(
                TBZServerConfig.BUTTERFLY_WHITELIST_MODE,
                TBZServerConfig.BUTTERFLY_APPLICABLE_GUNS
        ));
        // 高爆载荷
        ENCHANTMENT_CONFIGS.put("explosive_payload", new EnchantmentConfigEntry(
                TBZServerConfig.EXPLOSIVE_PAYLOAD_WHITELIST_MODE,
                TBZServerConfig.EXPLOSIVE_PAYLOAD_APPLICABLE_GUNS
        ));
        // 萤火虫
        ENCHANTMENT_CONFIGS.put("firefly", new EnchantmentConfigEntry(
                TBZServerConfig.FIREFLY_WHITELIST_MODE,
                TBZServerConfig.FIREFLY_APPLICABLE_GUNS
        ));
        // 蜻蜓
        ENCHANTMENT_CONFIGS.put("dragonfly", new EnchantmentConfigEntry(
                TBZServerConfig.DRAGONFLY_WHITELIST_MODE,
                TBZServerConfig.DRAGONFLY_APPLICABLE_GUNS
        ));
        // 巨脉蜻蜓
        ENCHANTMENT_CONFIGS.put("meganeura", new EnchantmentConfigEntry(
                TBZServerConfig.MEGANEURA_WHITELIST_MODE,
                TBZServerConfig.MEGANEURA_APPLICABLE_GUNS
        ));

        // ========== [配件数值]类型附魔 ==========
        // 不法之徒
        ENCHANTMENT_CONFIGS.put("outlaw", new EnchantmentConfigEntry(
                TBZServerConfig.OUTLAW_WHITELIST_MODE,
                TBZServerConfig.OUTLAW_APPLICABLE_GUNS
        ));
        // 速射瞄准
        ENCHANTMENT_CONFIGS.put("snapshot_sights", new EnchantmentConfigEntry(
                TBZServerConfig.SNAPSHOT_SIGHTS_WHITELIST_MODE,
                TBZServerConfig.SNAPSHOT_SIGHTS_APPLICABLE_GUNS
        ));
        // 稳若磐石
        ENCHANTMENT_CONFIGS.put("firmly_planted", new EnchantmentConfigEntry(
                TBZServerConfig.FIRMLY_PLANTED_WHITELIST_MODE,
                TBZServerConfig.FIRMLY_PLANTED_APPLICABLE_GUNS
        ));
        // 柔缓
        ENCHANTMENT_CONFIGS.put("adagio", new EnchantmentConfigEntry(
                TBZServerConfig.ADAGIO_WHITELIST_MODE,
                TBZServerConfig.ADAGIO_APPLICABLE_GUNS
        ));
        // 猛攻
        ENCHANTMENT_CONFIGS.put("onslaught", new EnchantmentConfigEntry(
                TBZServerConfig.ONSLAUGHT_WHITELIST_MODE,
                TBZServerConfig.ONSLAUGHT_APPLICABLE_GUNS
        ));
        // 风暴之眼
        ENCHANTMENT_CONFIGS.put("eye_of_storm_eye", new EnchantmentConfigEntry(
                TBZServerConfig.EYE_OF_STORM_EYE_WHITELIST_MODE,
                TBZServerConfig.EYE_OF_STORM_EYE_APPLICABLE_GUNS
        ));

        // ========== [持续伤害]类型附魔 ==========
        // 羸弱能量球
        ENCHANTMENT_CONFIGS.put("attrition_orbs", new EnchantmentConfigEntry(
                TBZServerConfig.ATTRITION_ORBS_WHITELIST_MODE,
                TBZServerConfig.ATTRITION_ORBS_APPLICABLE_GUNS
        ));

        // ========== [其他]类型附魔 ==========
        // 泉源
        ENCHANTMENT_CONFIGS.put("wellspring", new EnchantmentConfigEntry(
                TBZServerConfig.WELLSPRING_WHITELIST_MODE,
                TBZServerConfig.WELLSPRING_APPLICABLE_GUNS
        ));
        // 冷却饰物
        ENCHANTMENT_CONFIGS.put("cooling_baubles", new EnchantmentConfigEntry(
                TBZServerConfig.COOLING_BAUBLES_WHITELIST_MODE,
                TBZServerConfig.COOLING_BAUBLES_APPLICABLE_GUNS
        ));
        // 边打边劫
        ENCHANTMENT_CONFIGS.put("shoot_tp_loot", new EnchantmentConfigEntry(
                TBZServerConfig.SHOOT_TP_LOOT_WHITELIST_MODE,
                TBZServerConfig.SHOOT_TP_LOOT_APPLICABLE_GUNS
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