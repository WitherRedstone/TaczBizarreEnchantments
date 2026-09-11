package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.List;

public class TBZServerConfig {

    // ========== 通用设置 ==========
    public static ForgeConfigSpec.IntValue MAX_ENCHANTMENTS_PER_GUN;
    public static ForgeConfigSpec.IntValue MAX_EXOTIC_ENCHANTMENTS;

    // ========== 敌对生物掉落配置 ==========
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BOSS_DROP_ENTITIES;
    public static ForgeConfigSpec.IntValue ASCENDANT_SHARD_MIN_COUNT;
    public static ForgeConfigSpec.IntValue ASCENDANT_SHARD_MAX_COUNT;
    public static ForgeConfigSpec.IntValue ASCENDANT_ALLOY_COUNT;
    public static ForgeConfigSpec.DoubleValue ASCENDANT_ALLOY_CHANCE;
    public static ForgeConfigSpec.BooleanValue HOSTILE_DROP_ENABLED;
    public static ForgeConfigSpec.IntValue ENHANCEMENT_PRISM_MIN_COUNT;
    public static ForgeConfigSpec.IntValue ENHANCEMENT_PRISM_MAX_COUNT;
    public static ForgeConfigSpec.DoubleValue ENHANCEMENT_PRISM_CHANCE;

    // ========== 火星锻造台配置 ==========
    public static ForgeConfigSpec.IntValue MARS_SMITHING_MAX_RANDOM_PERKS;
    public static ForgeConfigSpec.IntValue MARS_SMITHING_RANDOM_PERK_MATERIAL_COST;
    public static ForgeConfigSpec.IntValue MARS_SMITHING_REFRESH_PERK_MATERIAL_COST;
    public static ForgeConfigSpec.DoubleValue MARS_SMITHING_COMMON_RARITY_CHANCE;
    public static ForgeConfigSpec.DoubleValue MARS_SMITHING_UNCOMMON_RARITY_CHANCE;
    public static ForgeConfigSpec.DoubleValue MARS_SMITHING_RARE_RARITY_CHANCE;
    public static ForgeConfigSpec.DoubleValue MARS_SMITHING_VERY_RARE_RARITY_CHANCE;

    // ========== 箱子战利品配置 ==========
    public static ForgeConfigSpec.DoubleValue CHEST_LOOTS_ENHANCEMENT_PRISM_CHANCE;
    public static ForgeConfigSpec.DoubleValue CHEST_LOOTS_ASCENDANT_SHARD_CHANCE;
    public static ForgeConfigSpec.DoubleValue CHEST_LOOTS_ASCENDANT_ALLOY_CHANCE;

    // ========== 防护编织 ==========
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue PROTECTIVE_WEAVE_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_WOVEN_MAIL_DURATION;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue PROTECTIVE_WEAVE_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue PROTECTIVE_WEAVE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PROTECTIVE_WEAVE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue PROTECTIVE_WEAVE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PROTECTIVE_WEAVE_APPLICABLE_WEAPON_TYPES;

    // ========== 统治浩劫 ==========
    public static ForgeConfigSpec.IntValue REIGN_HAVOC_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REIGN_HAVOC_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REIGN_HAVOC_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue REIGN_HAVOC_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue REIGN_HAVOC_REQUIRED_HEADSHOTS;
    public static ForgeConfigSpec.DoubleValue REIGN_HAVOC_LIGHTNING_DAMAGE;
    public static ForgeConfigSpec.DoubleValue REIGN_HAVOC_REFILL_PERCENTAGE;
    public static ForgeConfigSpec.BooleanValue REIGN_HAVOC_FIRE_DAMAGE;
    public static ForgeConfigSpec.BooleanValue REIGN_HAVOC_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REIGN_HAVOC_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue REIGN_HAVOC_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REIGN_HAVOC_APPLICABLE_WEAPON_TYPES;

    // ========== SUROS遗产 ==========
    public static ForgeConfigSpec.IntValue SUROS_LEGACY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUROS_LEGACY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUROS_LEGACY_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SUROS_LEGACY_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SUROS_LEGACY_DAMAGE_BONUS;
    public static ForgeConfigSpec.DoubleValue SUROS_LEGACY_CURE_CHANCE;
    public static ForgeConfigSpec.IntValue SUROS_LEGACY_CURE_AMPLIFIER;
    public static ForgeConfigSpec.BooleanValue SUROS_LEGACY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUROS_LEGACY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SUROS_LEGACY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUROS_LEGACY_APPLICABLE_WEAPON_TYPES;

    // ========== 古昧的折磨 ==========
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue PRIMEVALS_TORMENT_TRIGGER_CHANCE;
    public static ForgeConfigSpec.DoubleValue PRIMEVALS_TORMENT_RANGE;
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_EFFECT_DURATION;
    public static ForgeConfigSpec.IntValue PRIMEVALS_TORMENT_EFFECT_LEVEL;
    public static ForgeConfigSpec.BooleanValue PRIMEVALS_TORMENT_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue PRIMEVALS_TORMENT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PRIMEVALS_TORMENT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue PRIMEVALS_TORMENT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PRIMEVALS_TORMENT_APPLICABLE_WEAPON_TYPES;

    // ========== 到此为止 ==========
    public static ForgeConfigSpec.IntValue FULL_STOP_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FULL_STOP_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FULL_STOP_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue FULL_STOP_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue FULL_STOP_HEADSHOT_MULTIPLIER;
    public static ForgeConfigSpec.BooleanValue FULL_STOP_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FULL_STOP_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue FULL_STOP_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FULL_STOP_APPLICABLE_WEAPON_TYPES;

    // ========== 蔓延羸弱 ==========
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_REQUIRED_HEADSHOTS;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_TIME_WINDOW;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_SLOW_DURATION;
    public static ForgeConfigSpec.IntValue CREEPING_ATTRITION_SLOW_LEVEL;
    public static ForgeConfigSpec.BooleanValue CREEPING_ATTRITION_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CREEPING_ATTRITION_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue CREEPING_ATTRITION_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CREEPING_ATTRITION_APPLICABLE_WEAPON_TYPES;

    // ========== 恶意触碰 ==========
    public static ForgeConfigSpec.IntValue TOUCH_OF_MALICE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TOUCH_OF_MALICE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TOUCH_OF_MALICE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue TOUCH_OF_MALICE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue TOUCH_OF_MALICE_DAMAGE_BONUS_PER_HEART;
    public static ForgeConfigSpec.BooleanValue TOUCH_OF_MALICE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TOUCH_OF_MALICE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue TOUCH_OF_MALICE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TOUCH_OF_MALICE_APPLICABLE_WEAPON_TYPES;

    // ========== 正确抉择 ==========
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_TRIGGER_INTERVAL;
    public static ForgeConfigSpec.DoubleValue THE_RIGHT_CHOICE_RANGE;
    public static ForgeConfigSpec.BooleanValue THE_RIGHT_CHOICE_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue THE_RIGHT_CHOICE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> THE_RIGHT_CHOICE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue THE_RIGHT_CHOICE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> THE_RIGHT_CHOICE_APPLICABLE_WEAPON_TYPES;

    // ========== 十六进制 ==========
    public static ForgeConfigSpec.IntValue VEXADECIMAL_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue VEXADECIMAL_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue VEXADECIMAL_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue VEXADECIMAL_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue VEXADECIMAL_WEAKNESS_DURATION;
    public static ForgeConfigSpec.IntValue VEXADECIMAL_WEAKNESS_LEVEL;
    public static ForgeConfigSpec.DoubleValue VEXADECIMAL_EXTRA_DAMAGE_PERCENT;
    public static ForgeConfigSpec.BooleanValue VEXADECIMAL_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> VEXADECIMAL_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue VEXADECIMAL_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> VEXADECIMAL_APPLICABLE_WEAPON_TYPES;

    // ========== 私人助手 ==========
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_JOLT_DURATION;
    public static ForgeConfigSpec.IntValue PERSONAL_ASSISTANT_JOLT_LEVEL;
    public static ForgeConfigSpec.BooleanValue PERSONAL_ASSISTANT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PERSONAL_ASSISTANT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue PERSONAL_ASSISTANT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PERSONAL_ASSISTANT_APPLICABLE_WEAPON_TYPES;

    // ========== 斩首武器 ==========
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue BORPAL_WEAPON_BOSS_DAMAGE_BONUS;
    public static ForgeConfigSpec.BooleanValue BORPAL_WEAPON_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BORPAL_WEAPON_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES;

    // ========== 精准工具 ==========
    public static ForgeConfigSpec.IntValue PRECISION_INSTRUMENT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PRECISION_INSTRUMENT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue PRECISION_INSTRUMENT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue PRECISION_INSTRUMENT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue PRECISION_INSTRUMENT_FIRE_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue PRECISION_INSTRUMENT_MULTIPLIER_BONUS;
    public static ForgeConfigSpec.BooleanValue PRECISION_INSTRUMENT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PRECISION_INSTRUMENT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES;

    // ========== 目标锁定 ==========
    public static ForgeConfigSpec.IntValue TARGET_LOCK_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_DAMAGE_BONUS_PER_STACK;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_MAX_STACKS;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT;
    public static ForgeConfigSpec.BooleanValue TARGET_LOCK_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TARGET_LOCK_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TARGET_LOCK_APPLICABLE_WEAPON_TYPES;

    // ========== 直击要害 ==========
    public static ForgeConfigSpec.IntValue GUTSHOT_STRAIGHT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue GUTSHOT_STRAIGHT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue GUTSHOT_STRAIGHT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue GUTSHOT_STRAIGHT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue GUTSHOT_STRAIGHT_DAMAGE_BONUS;
    public static ForgeConfigSpec.BooleanValue GUTSHOT_STRAIGHT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> GUTSHOT_STRAIGHT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue GUTSHOT_STRAIGHT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> GUTSHOT_STRAIGHT_APPLICABLE_WEAPON_TYPES;

    // ========== 热能雾化 ==========
    public static ForgeConfigSpec.IntValue THERMAL_ATOMIZATION_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue THERMAL_ATOMIZATION_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue THERMAL_ATOMIZATION_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue THERMAL_ATOMIZATION_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue THERMAL_ATOMIZATION_DAMAGE_BONUS;
    public static ForgeConfigSpec.DoubleValue THERMAL_ATOMIZATION_EXPLOSION_MIN_DAMAGE;
    public static ForgeConfigSpec.DoubleValue THERMAL_ATOMIZATION_EXPLOSION_MAX_DAMAGE;
    public static ForgeConfigSpec.DoubleValue THERMAL_ATOMIZATION_EXPLOSION_RANGE;
    public static ForgeConfigSpec.DoubleValue THERMAL_ATOMIZATION_HEAT_THRESHOLD;
    public static ForgeConfigSpec.BooleanValue THERMAL_ATOMIZATION_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue THERMAL_ATOMIZATION_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> THERMAL_ATOMIZATION_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue THERMAL_ATOMIZATION_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> THERMAL_ATOMIZATION_APPLICABLE_WEAPON_TYPES;

    // ========== 斗剑士 ==========
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_MAX_STACKS;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_DECREASE_INTERVAL_TICKS;
    public static ForgeConfigSpec.BooleanValue SWASHBUCKLER_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SWASHBUCKLER_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SWASHBUCKLER_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SWASHBUCKLER_APPLICABLE_WEAPON_TYPES;

    // ========== 我为人人 ==========
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue ONE_FOR_ALL_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_DURATION_SECONDS;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_REQUIRED_HITS;
    public static ForgeConfigSpec.BooleanValue ONE_FOR_ALL_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ONE_FOR_ALL_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue ONE_FOR_ALL_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ONE_FOR_ALL_APPLICABLE_WEAPON_TYPES;

    // ========== 武器大师 ==========
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_STACK_1_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_STACK_1_DURATION_SECONDS;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_STACK_2_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_STACK_2_DURATION_SECONDS;
    public static ForgeConfigSpec.BooleanValue MASTER_OF_ARMS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MASTER_OF_ARMS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue MASTER_OF_ARMS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MASTER_OF_ARMS_APPLICABLE_WEAPON_TYPES;

    // ========== 聚合充能 ==========
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue AGGREGATE_CHARGE_DAMAGE_BONUS_PERCENT;
    public static ForgeConfigSpec.BooleanValue AGGREGATE_CHARGE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AGGREGATE_CHARGE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue AGGREGATE_CHARGE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AGGREGATE_CHARGE_APPLICABLE_WEAPON_TYPES;

    // ========== 火线 ==========
    public static ForgeConfigSpec.IntValue FIRING_LINE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIRING_LINE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIRING_LINE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue FIRING_LINE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue FIRING_LINE_RADIUS;
    public static ForgeConfigSpec.IntValue FIRING_LINE_REQUIRED_PLAYERS;
    public static ForgeConfigSpec.DoubleValue FIRING_LINE_DAMAGE_BONUS;
    public static ForgeConfigSpec.BooleanValue FIRING_LINE_EXCLUDE_SELF;
    public static ForgeConfigSpec.BooleanValue FIRING_LINE_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue FIRING_LINE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIRING_LINE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue FIRING_LINE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIRING_LINE_APPLICABLE_WEAPON_TYPES;

    // ========== 盒式呼吸法 ==========
    public static ForgeConfigSpec.IntValue BOX_BREATHING_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BOX_BREATHING_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BOX_BREATHING_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue BOX_BREATHING_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue BOX_BREATHING_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue BOX_BREATHING_AIMING_REQUIRED_TICKS;
    public static ForgeConfigSpec.BooleanValue BOX_BREATHING_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BOX_BREATHING_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue BOX_BREATHING_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BOX_BREATHING_APPLICABLE_WEAPON_TYPES;

    // ========== 爆炸光能 ==========
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_LIGHT_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_XP_PER_STACK;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_MAX_STACKS;
    public static ForgeConfigSpec.BooleanValue EXPLOSIVE_LIGHT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLOSIVE_LIGHT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue EXPLOSIVE_LIGHT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLOSIVE_LIGHT_APPLICABLE_WEAPON_TYPES;

    // ========== 维持生计 ==========
    public static ForgeConfigSpec.IntValue SUBSISTENCE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUBSISTENCE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUBSISTENCE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SUBSISTENCE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SUBSISTENCE_BASE_AMMO_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue SUBSISTENCE_AMMO_PERCENTAGE_PER_LEVEL;
    public static ForgeConfigSpec.IntValue SUBSISTENCE_KILL_THRESHOLD;
    public static ForgeConfigSpec.BooleanValue SUBSISTENCE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUBSISTENCE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUBSISTENCE_APPLICABLE_WEAPON_TYPES;

    // ========== 刺客野心 ==========
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue AMBITIOUS_ASSASSIN_CAPACITY_BONUS_PERCENT;
    public static ForgeConfigSpec.DoubleValue AMBITIOUS_ASSASSIN_MAX_CAPACITY_BONUS_PERCENT;
    public static ForgeConfigSpec.BooleanValue AMBITIOUS_ASSASSIN_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AMBITIOUS_ASSASSIN_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES;

    // ========== 重建 ==========
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_RELOAD_INTERVAL;
    public static ForgeConfigSpec.DoubleValue RECONSTRUCTION_RELOAD_PERCENT;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_SHOOT_COOLDOWN;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_MAX_AMMO;
    public static ForgeConfigSpec.BooleanValue RECONSTRUCTION_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RECONSTRUCTION_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RECONSTRUCTION_APPLICABLE_WEAPON_TYPES;

    // ========== 精准连击 ==========
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_HIT_COUNT;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_TIME_WINDOW;
    public static ForgeConfigSpec.BooleanValue TRIPLE_TAP_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TRIPLE_TAP_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TRIPLE_TAP_APPLICABLE_WEAPON_TYPES;

    // ========== 事不过四 ==========
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_HIT_COUNT;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_TIME_WINDOW;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_AMMO_RETURN;
    public static ForgeConfigSpec.BooleanValue FOURTH_TIME_THE_CHARM_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FOURTH_TIME_THE_CHARM_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES;

    // ========== 回转弹药 ==========
    public static ForgeConfigSpec.IntValue REWIND_ROUNDS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REWIND_ROUNDS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REWIND_ROUNDS_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue REWIND_ROUNDS_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue REWIND_ROUNDS_RESTORE_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue REWIND_ROUNDS_MIN_FIRE_PERCENTAGE;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_TIMEOUT_SECONDS;
    public static ForgeConfigSpec.BooleanValue REWIND_ROUNDS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REWIND_ROUNDS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES;

    // ========== 重新调度 ==========
    public static ForgeConfigSpec.IntValue MULLIGAN_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MULLIGAN_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MULLIGAN_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue MULLIGAN_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue MULLIGAN_BASE_CHANCE;
    public static ForgeConfigSpec.DoubleValue MULLIGAN_CHANCE_PER_LEVEL;
    public static ForgeConfigSpec.BooleanValue MULLIGAN_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MULLIGAN_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue MULLIGAN_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MULLIGAN_APPLICABLE_WEAPON_TYPES;

    // ========== 涓流充能 ==========
    public static ForgeConfigSpec.IntValue TRICKLE_CHARGE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TRICKLE_CHARGE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TRICKLE_CHARGE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue TRICKLE_CHARGE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue TRICKLE_CHARGE_RECEIVE_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue TRICKLE_CHARGE_RELEASE_PERCENTAGE;
    public static ForgeConfigSpec.BooleanValue TRICKLE_CHARGE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TRICKLE_CHARGE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue TRICKLE_CHARGE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TRICKLE_CHARGE_APPLICABLE_WEAPON_TYPES;

    // ========== 超充弹匣 ==========
    public static ForgeConfigSpec.IntValue SUPERCHARGED_MAGAZINE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUPERCHARGED_MAGAZINE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SUPERCHARGED_MAGAZINE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SUPERCHARGED_MAGAZINE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SUPERCHARGED_MAGAZINE_RELOAD_PERCENTAGE;
    public static ForgeConfigSpec.IntValue SUPERCHARGED_MAGAZINE_RELOAD_INTERVAL;
    public static ForgeConfigSpec.BooleanValue SUPERCHARGED_MAGAZINE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUPERCHARGED_MAGAZINE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SUPERCHARGED_MAGAZINE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SUPERCHARGED_MAGAZINE_APPLICABLE_WEAPON_TYPES;

    // ========== 命运的逆转 ==========
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_REQUIRED_MISSES;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_REFUND_AMOUNT;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_MISS_TIMEOUT;
    public static ForgeConfigSpec.IntValue REVERSAL_OF_FORTUNE_COOLDOWN;
    public static ForgeConfigSpec.BooleanValue REVERSAL_OF_FORTUNE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REVERSAL_OF_FORTUNE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue REVERSAL_OF_FORTUNE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REVERSAL_OF_FORTUNE_APPLICABLE_WEAPON_TYPES;

    // ========== 小丑皇弹药筒 ==========
    public static ForgeConfigSpec.IntValue CLOWN_CARTRIDGE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CLOWN_CARTRIDGE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CLOWN_CARTRIDGE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue CLOWN_CARTRIDGE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue CLOWN_CARTRIDGE_MIN_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue CLOWN_CARTRIDGE_MAX_PERCENTAGE;
    public static ForgeConfigSpec.BooleanValue CLOWN_CARTRIDGE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CLOWN_CARTRIDGE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue CLOWN_CARTRIDGE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CLOWN_CARTRIDGE_APPLICABLE_WEAPON_TYPES;

    // ========== 治疗弹匣 ==========
    public static ForgeConfigSpec.IntValue HEAL_CLIP_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_BASE_AMPLIFIER;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_AMPLIFIER_PER_LEVEL;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_RELOAD_TICKS;
    public static ForgeConfigSpec.DoubleValue HEAL_CLIP_AREA_RADIUS;
    public static ForgeConfigSpec.BooleanValue HEAL_CLIP_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue HEAL_CLIP_HEAL_PEACEFUL;
    public static ForgeConfigSpec.IntValue HEAL_CLIP_OTHER_PLAYER_AMPLIFIER;
    public static ForgeConfigSpec.BooleanValue HEAL_CLIP_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> HEAL_CLIP_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> HEAL_CLIP_APPLICABLE_WEAPON_TYPES;

    // ========== 风暴涌动 ==========
    public static ForgeConfigSpec.IntValue ROLLING_STORM_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_AMPLIFIED_DURATION;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_AMPLIFIED_AMPLIFIER;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue ROLLING_STORM_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ROLLING_STORM_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ROLLING_STORM_APPLICABLE_WEAPON_TYPES;

    // ========== 失衡弹药 ==========
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue DESTABILIZING_ROUNDS_RANGE;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_VOLATILE_DURATION;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue DESTABILIZING_ROUNDS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DESTABILIZING_ROUNDS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES;

    // ========== 辉耀炽热 ==========
    public static ForgeConfigSpec.IntValue INCANDESCENT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue INCANDESCENT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue INCANDESCENT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue INCANDESCENT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue INCANDESCENT_RANGE;
    public static ForgeConfigSpec.IntValue INCANDESCENT_SCORCH_DURATION;
    public static ForgeConfigSpec.IntValue INCANDESCENT_SCORCH_AMPLIFIER;
    public static ForgeConfigSpec.IntValue INCANDESCENT_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue INCANDESCENT_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue INCANDESCENT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> INCANDESCENT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> INCANDESCENT_APPLICABLE_WEAPON_TYPES;

    // ========== 冰冷弹匣 ==========
    public static ForgeConfigSpec.IntValue CHILL_CLIP_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue CHILL_CLIP_TRIGGER_CHANCE;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_SLOW_DURATION;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_SLOW_MIN_AMPLIFIER;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_SLOW_MAX_AMPLIFIER;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue CHILL_CLIP_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CHILL_CLIP_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CHILL_CLIP_APPLICABLE_WEAPON_TYPES;

    // ========== 霜华窃取者 ==========
    public static ForgeConfigSpec.IntValue RIMESTEALER_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RIMESTEALER_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RIMESTEALER_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue RIMESTEALER_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue RIMESTEALER_FROST_ARMOR_DURATION;
    public static ForgeConfigSpec.IntValue RIMESTEALER_FROST_ARMOR_AMPLIFIER;
    public static ForgeConfigSpec.IntValue RIMESTEALER_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue RIMESTEALER_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue RIMESTEALER_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue RIMESTEALER_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RIMESTEALER_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RIMESTEALER_APPLICABLE_WEAPON_TYPES;

    // ========== 切割 ==========
    public static ForgeConfigSpec.IntValue SLICE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SLICE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SLICE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SLICE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SLICE_TRIGGER_CHANCE;
    public static ForgeConfigSpec.IntValue SLICE_SEVER_DURATION;
    public static ForgeConfigSpec.IntValue SLICE_SEVER_MIN_AMPLIFIER;
    public static ForgeConfigSpec.IntValue SLICE_SEVER_MAX_AMPLIFIER;
    public static ForgeConfigSpec.IntValue SLICE_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue SLICE_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue SLICE_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue SLICE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SLICE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SLICE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SLICE_APPLICABLE_WEAPON_TYPES;

    // ========== 枯萎凝视 ==========
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_EFFECT_DURATION;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_EFFECT_LEVEL;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_AIMING_REQUIRED_TICKS;
    public static ForgeConfigSpec.BooleanValue WITHERING_GAZE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_GAZE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_GAZE_APPLICABLE_WEAPON_TYPES;

    // ========== 燃烧野心 ==========
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_SHOTS_PER_STACK;
    public static ForgeConfigSpec.IntValue BURNING_AMBITION_STACKS_PER_HIT;
    public static ForgeConfigSpec.BooleanValue BURNING_AMBITION_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BURNING_AMBITION_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue BURNING_AMBITION_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BURNING_AMBITION_APPLICABLE_WEAPON_TYPES;

    // ========== 瓦解 ==========
    public static ForgeConfigSpec.IntValue DEMORALIZE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DEMORALIZE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DEMORALIZE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue DEMORALIZE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue DEMORALIZE_RADIUS;
    public static ForgeConfigSpec.IntValue DEMORALIZE_EFFECT_DURATION;
    public static ForgeConfigSpec.IntValue DEMORALIZE_EFFECT_LEVEL;
    public static ForgeConfigSpec.BooleanValue DEMORALIZE_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue DEMORALIZE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DEMORALIZE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue DEMORALIZE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DEMORALIZE_APPLICABLE_WEAPON_TYPES;

    // ========== 冲击支撑 ==========
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_OVERSHIELD_DURATION;
    public static ForgeConfigSpec.IntValue REPULSOR_BRACE_OVERSHIELD_LEVEL;
    public static ForgeConfigSpec.BooleanValue REPULSOR_BRACE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REPULSOR_BRACE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue REPULSOR_BRACE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REPULSOR_BRACE_APPLICABLE_WEAPON_TYPES;

    // ========== 蝴蝶 ==========
    public static ForgeConfigSpec.IntValue BUTTERFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BUTTERFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BUTTERFLY_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue BUTTERFLY_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue BUTTERFLY_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue BUTTERFLY_DAMAGE_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue BUTTERFLY_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue BUTTERFLY_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue BUTTERFLY_RANGE;
    public static ForgeConfigSpec.IntValue BUTTERFLY_AIMING_REQUIRED_TICKS;
    public static ForgeConfigSpec.BooleanValue BUTTERFLY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BUTTERFLY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue BUTTERFLY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BUTTERFLY_APPLICABLE_WEAPON_TYPES;

    // ========== 高爆载荷 ==========
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_PAYLOAD_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_PAYLOAD_DAMAGE_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_PAYLOAD_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_PAYLOAD_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_PAYLOAD_RANGE;
    public static ForgeConfigSpec.BooleanValue EXPLOSIVE_PAYLOAD_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLOSIVE_PAYLOAD_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue EXPLOSIVE_PAYLOAD_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXPLOSIVE_PAYLOAD_APPLICABLE_WEAPON_TYPES;

    // ========== 萤火虫 ==========
    public static ForgeConfigSpec.IntValue FIREFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIREFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIREFLY_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue FIREFLY_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue FIREFLY_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue FIREFLY_DAMAGE_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue FIREFLY_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue FIREFLY_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue FIREFLY_RANGE;
    public static ForgeConfigSpec.DoubleValue FIREFLY_BASE_RELOAD_SPEED;
    public static ForgeConfigSpec.DoubleValue FIREFLY_RELOAD_SPEED_PER_LEVEL;
    public static ForgeConfigSpec.IntValue FIREFLY_KILL_WINDOW_TICKS;
    public static ForgeConfigSpec.BooleanValue FIREFLY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIREFLY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue FIREFLY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIREFLY_APPLICABLE_WEAPON_TYPES;

    // ========== 蜻蜓 ==========
    public static ForgeConfigSpec.IntValue DRAGONFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DRAGONFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DRAGONFLY_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue DRAGONFLY_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue DRAGONFLY_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue DRAGONFLY_DAMAGE_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue DRAGONFLY_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue DRAGONFLY_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue DRAGONFLY_RANGE;
    public static ForgeConfigSpec.IntValue DRAGONFLY_KILL_WINDOW_TICKS;
    public static ForgeConfigSpec.BooleanValue DRAGONFLY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DRAGONFLY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DRAGONFLY_APPLICABLE_WEAPON_TYPES;

    // ========== 巨脉蜻蜓 ==========
    public static ForgeConfigSpec.IntValue MEGANEURA_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MEGANEURA_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MEGANEURA_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue MEGANEURA_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_DAMAGE_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_RANGE;
    public static ForgeConfigSpec.IntValue MEGANEURA_HEADSHOT_THRESHOLD;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_DAMAGE_BONUS_PER_THRESHOLD;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_MAX_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue MEGANEURA_KILL_TICKS;
    public static ForgeConfigSpec.BooleanValue MEGANEURA_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MEGANEURA_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue MEGANEURA_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MEGANEURA_APPLICABLE_WEAPON_TYPES;

    // ========== 速射瞄准 ==========
    public static ForgeConfigSpec.IntValue SNAPSHOT_SIGHTS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SNAPSHOT_SIGHTS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SNAPSHOT_SIGHTS_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SNAPSHOT_SIGHTS_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SNAPSHOT_SIGHTS_AIM_SPEED_BONUS;
    public static ForgeConfigSpec.BooleanValue SNAPSHOT_SIGHTS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SNAPSHOT_SIGHTS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SNAPSHOT_SIGHTS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SNAPSHOT_SIGHTS_APPLICABLE_WEAPON_TYPES;

    // ========== 稳若磐石 ==========
    public static ForgeConfigSpec.IntValue FIRMLY_PLANTED_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIRMLY_PLANTED_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIRMLY_PLANTED_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue FIRMLY_PLANTED_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue FIRMLY_PLANTED_SPREAD_REDUCTION;
    public static ForgeConfigSpec.DoubleValue FIRMLY_PLANTED_RECOIL_REDUCTION;
    public static ForgeConfigSpec.BooleanValue FIRMLY_PLANTED_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIRMLY_PLANTED_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue FIRMLY_PLANTED_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> FIRMLY_PLANTED_APPLICABLE_WEAPON_TYPES;

    // ========== 柔缓 ==========
    public static ForgeConfigSpec.IntValue ADAGIO_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ADAGIO_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ADAGIO_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue ADAGIO_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue ADAGIO_DURATION;
    public static ForgeConfigSpec.DoubleValue ADAGIO_BONUS_DAMAGE;
    public static ForgeConfigSpec.DoubleValue ADAGIO_FIRE_RATE_SLOWDOWN;
    public static ForgeConfigSpec.BooleanValue ADAGIO_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ADAGIO_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue ADAGIO_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ADAGIO_APPLICABLE_WEAPON_TYPES;

    // ========== 猛攻 ==========
    public static ForgeConfigSpec.IntValue ONSLAUGHT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ONSLAUGHT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ONSLAUGHT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue ONSLAUGHT_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue ONSLAUGHT_DURATION;
    public static ForgeConfigSpec.DoubleValue ONSLAUGHT_FIRE_RATE_BOOST;
    public static ForgeConfigSpec.BooleanValue ONSLAUGHT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ONSLAUGHT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue ONSLAUGHT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ONSLAUGHT_APPLICABLE_WEAPON_TYPES;

    // ========== 风暴之眼 ==========
    public static ForgeConfigSpec.IntValue EYE_OF_STORM_EYE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EYE_OF_STORM_EYE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EYE_OF_STORM_EYE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue EYE_OF_STORM_EYE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue EYE_OF_STORM_EYE_ACCURACY_BONUS;
    public static ForgeConfigSpec.DoubleValue EYE_OF_STORM_EYE_RECOIL_REDUCTION;
    public static ForgeConfigSpec.BooleanValue EYE_OF_STORM_EYE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EYE_OF_STORM_EYE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue EYE_OF_STORM_EYE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EYE_OF_STORM_EYE_APPLICABLE_WEAPON_TYPES;

    // ========== 测距仪 ==========
    public static ForgeConfigSpec.IntValue RANGEFINDER_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RANGEFINDER_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RANGEFINDER_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue RANGEFINDER_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue RANGEFINDER_ADS_RANGE_BONUS;
    public static ForgeConfigSpec.DoubleValue RANGEFINDER_AIM_ACCURACY_IMPROVEMENT_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue RANGEFINDER_RECOIL_REDUCTION_PER_LEVEL;
    public static ForgeConfigSpec.BooleanValue RANGEFINDER_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RANGEFINDER_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue RANGEFINDER_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RANGEFINDER_APPLICABLE_WEAPON_TYPES;

    // ========== 切勿靠近 ==========
    public static ForgeConfigSpec.IntValue KEEP_AWAY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue KEEP_AWAY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue KEEP_AWAY_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue KEEP_AWAY_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue KEEP_AWAY_EFFECTIVE_RANGE_BONUS;
    public static ForgeConfigSpec.DoubleValue KEEP_AWAY_EXTRA_RANGE_BONUS_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue KEEP_AWAY_AIM_ACCURACY_BONUS;
    public static ForgeConfigSpec.DoubleValue KEEP_AWAY_EXTRA_ACCURACY_BONUS_PER_LEVEL;
    public static ForgeConfigSpec.DoubleValue KEEP_AWAY_DETECTION_RADIUS;
    public static ForgeConfigSpec.BooleanValue KEEP_AWAY_SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue KEEP_AWAY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> KEEP_AWAY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue KEEP_AWAY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> KEEP_AWAY_APPLICABLE_WEAPON_TYPES;

    // ========== 羸弱能量球 ==========
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue ATTRITION_ORBS_BASE_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue ATTRITION_ORBS_PERCENTAGE_REDUCTION_PER_LEVEL;
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_MIN_ORBS;
    public static ForgeConfigSpec.IntValue ATTRITION_ORBS_MAX_ORBS;
    public static ForgeConfigSpec.BooleanValue ATTRITION_ORBS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ATTRITION_ORBS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue ATTRITION_ORBS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> ATTRITION_ORBS_APPLICABLE_WEAPON_TYPES;

    // ========== 不法之徒 ==========
    public static ForgeConfigSpec.IntValue OUTLAW_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue OUTLAW_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue OUTLAW_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue OUTLAW_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue OUTLAW_RELOAD_SPEED_MULTIPLIER;
    public static ForgeConfigSpec.BooleanValue OUTLAW_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> OUTLAW_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue OUTLAW_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> OUTLAW_APPLICABLE_WEAPON_TYPES;

    // ========== 泉源 ==========
    public static ForgeConfigSpec.IntValue WELLSPRING_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WELLSPRING_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WELLSPRING_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue WELLSPRING_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue WELLSPRING_MIN_EXP;
    public static ForgeConfigSpec.IntValue WELLSPRING_MAX_EXP;
    public static ForgeConfigSpec.BooleanValue WELLSPRING_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WELLSPRING_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue WELLSPRING_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WELLSPRING_APPLICABLE_WEAPON_TYPES;

    // ========== 冷却饰物 ==========
    public static ForgeConfigSpec.IntValue COOLING_BAUBLES_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue COOLING_BAUBLES_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue COOLING_BAUBLES_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue COOLING_BAUBLES_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue COOLING_BAUBLES_COOL_CHANCE;
    public static ForgeConfigSpec.DoubleValue COOLING_BAUBLES_HEAT_REDUCTION;
    public static ForgeConfigSpec.IntValue COOLING_BAUBLES_COOLDOWN_TICKS;
    public static ForgeConfigSpec.BooleanValue COOLING_BAUBLES_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> COOLING_BAUBLES_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue COOLING_BAUBLES_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> COOLING_BAUBLES_APPLICABLE_WEAPON_TYPES;

    // ========== 边打边劫 ==========
    public static ForgeConfigSpec.IntValue SHOOT_TP_LOOT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SHOOT_TP_LOOT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SHOOT_TP_LOOT_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue SHOOT_TP_LOOT_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue SHOOT_TP_LOOT_PICKUP_CHANCE;
    public static ForgeConfigSpec.DoubleValue SHOOT_TP_LOOT_PICKUP_RANGE;
    public static ForgeConfigSpec.BooleanValue SHOOT_TP_LOOT_CAN_PICKUP_XP_ORB;
    public static ForgeConfigSpec.BooleanValue SHOOT_TP_LOOT_LIMIT_ONE_ITEM_TYPE;
    public static ForgeConfigSpec.BooleanValue SHOOT_TP_LOOT_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SHOOT_TP_LOOT_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue SHOOT_TP_LOOT_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SHOOT_TP_LOOT_APPLICABLE_WEAPON_TYPES;


    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("通用配置").push("Common Config");
        MAX_ENCHANTMENTS_PER_GUN = builder
                .comment("每把枪械最多可以附魔的TBZ附魔数量")
                .comment("Maximum number of TBZ enchantments that can be applied to each firearm.")
                .defineInRange("maxEnchantmentsPerGun", 2, 1, 5);
        MAX_EXOTIC_ENCHANTMENTS = builder
                .comment("每把枪械最多可以附魔的异域类附魔数量（0表示不限制）")
                .comment("Maximum number of exotic enchantments that can be applied to each firearm (0 means no limit).")
                .defineInRange("maxExoticEnchantments", 1, 0, 2);
        builder.pop();


        builder.comment("火星锻造台配置").push("Mars Smithing Table Config");
        MARS_SMITHING_MAX_RANDOM_PERKS = builder
                .comment("武器最多通过随机功能更换附魔的次数（-1表示无限制，0表示不能附魔，1表示只能随机一次）")
                .comment("Maximum number of times a weapon can have its perks randomized through the random perk function (-1 for unlimited, 0 for no enchanting, 1 for one-time random).")
                .defineInRange("marsSmithingMaxRandomPerks", -1, -1, Integer.MAX_VALUE);
        MARS_SMITHING_RANDOM_PERK_MATERIAL_COST = builder
                .comment("随机附魔消耗的材料数量")
                .comment("Material cost for random perk enchantment")
                .defineInRange("marsSmithingRandomPerkMaterialCost", 1, 1, 64);
        MARS_SMITHING_REFRESH_PERK_MATERIAL_COST = builder
                .comment("清除随机附魔消耗的材料数量")
                .comment("Material cost for clearing random perk enchantment")
                .defineInRange("marsSmithingRefreshPerkMaterialCost", 1, 1, 64);
        MARS_SMITHING_COMMON_RARITY_CHANCE = builder
                .comment("COMMON的概率（%）")
                .comment("Probability of COMMON rarity enchantments (%)")
                .defineInRange("marsSmithingCommonRarityChance", 0.75, 0.0, 1.0);
        MARS_SMITHING_UNCOMMON_RARITY_CHANCE = builder
                .comment("UNCOMMON的概率（%）")
                .comment("Probability of UNCOMMON rarity enchantments (%)")
                .defineInRange("marsSmithingUncommonRarityChance", 0.45, 0.0, 1.0);
        MARS_SMITHING_RARE_RARITY_CHANCE = builder
                .comment("RARE的概率（%）")
                .comment("Probability of RARE rarity enchantments (%)")
                .defineInRange("marsSmithingRareRarityChance", 0.25, 0.0, 1.0);
        MARS_SMITHING_VERY_RARE_RARITY_CHANCE = builder
                .comment("VERY_RARE的概率（%）")
                .comment("Probability of VERY_RARE rarity enchantments (%)")
                .defineInRange("marsSmithingVeryRareRarityChance", 0.1, 0.0, 1.0);
        builder.pop();


        builder.comment("箱子战利品配置").push("Chest Loot Config");
        CHEST_LOOTS_ENHANCEMENT_PRISM_CHANCE = builder
                .comment("箱子中生成增强棱镜的概率（%）")
                .comment("Chance for Enhancement Prism to generate in chests (%).")
                .defineInRange("chestLootsEnhancementPrismChance", 0.35, 0.0, 1.0);
        CHEST_LOOTS_ASCENDANT_SHARD_CHANCE = builder
                .comment("箱子中生成上维碎片的概率（%）")
                .comment("Chance for Ascendant Shard to generate in chests (%).")
                .defineInRange("chestLootsAscendantShardChance", 0.25, 0.0, 1.0);
        CHEST_LOOTS_ASCENDANT_ALLOY_CHANCE = builder
                .comment("箱子中生成上维合金的概率（%）")
                .comment("Chance for Ascendant Alloy to generate in chests (%).")
                .defineInRange("chestLootsAscendantAlloyChance", 0.15, 0.0, 1.0);
        builder.pop();


        builder.comment("实体战利品配置").push("Entity Loot Config");
        builder.comment("上维碎片掉落").push("Ascendant Shard drops");
        BOSS_DROP_ENTITIES = builder
                .comment("Boss实体ID列表，留空表示不启用Boss掉落")
                .comment("Boss entity ID list, Leave empty to disable Boss drops")
                .defineList("bossEntities", List.of(
                        "minecraft:wither",
                        "minecraft:ender_dragon"
                ), obj -> obj instanceof String);
        ASCENDANT_SHARD_MIN_COUNT = builder
                .comment("上维碎片最小掉落数量")
                .comment("Ascendant Shard Minimum Drop Count")
                .defineInRange("ascendantShardMinCount", 1, 1, Integer.MAX_VALUE);
        ASCENDANT_SHARD_MAX_COUNT = builder
                .comment("上维碎片最大掉落数量")
                .comment("Ascendant Shard Maximum Drop Count")
                .defineInRange("ascendantShardMaxCount", 3, 1, Integer.MAX_VALUE);
        ASCENDANT_ALLOY_COUNT = builder
                .comment("上维合金掉落数量")
                .comment("Ascendant Shard Drop Count")
                .defineInRange("ascendantAlloyCount", 1, 1, Integer.MAX_VALUE);
        ASCENDANT_ALLOY_CHANCE = builder
                .comment("上维合金掉落概率（%）")
                .comment("Ascendant Shard Drop Rate (%)")
                .defineInRange("ascendantAlloyChance", 0.05, 0.0, 1.0);
        builder.pop();

        builder.comment("增强棱镜掉落").push("Enhancement Prism drops");
        HOSTILE_DROP_ENABLED = builder
                .comment("是否启用敌对生物掉落增强棱镜")
                .comment("Enable Enhancement Prism drops from hostile mobs.")
                .define("enabled", true);
        ENHANCEMENT_PRISM_MIN_COUNT = builder
                .comment("增强棱镜最小掉落数量")
                .comment("Enhancement Prism Minimum Drop Count")
                .defineInRange("enhancementPrismMinCount", 1, 1, Integer.MAX_VALUE);
        ENHANCEMENT_PRISM_MAX_COUNT = builder
                .comment("增强棱镜最大掉落数量")
                .comment("Enhancement Prism Maximum Drop Count")
                .defineInRange("enhancementPrismMaxCount", 3, 1, Integer.MAX_VALUE);
        ENHANCEMENT_PRISM_CHANCE = builder
                .comment("增强棱镜掉落概率（%）")
                .comment("Enhancement Prism Drop Rate (%)")
                .defineInRange("enhancementPrismChance", 0.025, 0.0, 1.0);
        builder.pop();

        builder.pop();


        builder.comment("异域类").push("Exotic Category");
        builder.comment("防护编织").push("Protective Weave");
        PROTECTIVE_WEAVE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        PROTECTIVE_WEAVE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_DAMAGE_BONUS = builder
                .comment("拥有'织造铠甲'效果时的伤害加成系数（%）")
                .comment("Damage bonus coefficient while having 'Weave Armor' effect (%)")
                .defineInRange("weaveArmorDamageBonus", 0.15, 0.0, 1.0);
        PROTECTIVE_WEAVE_WOVEN_MAIL_DURATION = builder
                .comment("'织造铠甲'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when no 'Weave Armor' effect is active (tick)")
                .defineInRange("weaveArmorDuration", 200, 50, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER = builder
                .comment("'织造铠甲'效果首次获取时给予的等级")
                .comment("Level granted when 'Weave Armor' effect is first acquired")
                .defineInRange("weaveArmorAmplifier", 0, 0, 255);
        PROTECTIVE_WEAVE_COOLDOWN_TICKS = builder
                .comment("'织造铠甲'效果首次获取后需要冷却的时间（tick）")
                .comment("Cooldown time after first acquiring 'Weave Armor' (tick)")
                .defineInRange("weaveArmorCooldownTicks", 300, 1, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended Duration when Effect is Active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        PROTECTIVE_WEAVE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended Duration when Effect is Active (tick)")
                .defineInRange("maxDuration", 1200, 600, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        PROTECTIVE_WEAVE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        PROTECTIVE_WEAVE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PROTECTIVE_WEAVE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        PROTECTIVE_WEAVE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("统治浩劫").push("Reign Havoc");
        REIGN_HAVOC_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        REIGN_HAVOC_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 10, 1, Integer.MAX_VALUE);
        REIGN_HAVOC_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        REIGN_HAVOC_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        REIGN_HAVOC_REQUIRED_HEADSHOTS = builder
                .comment("触发闪电打击所需的连续爆头次数")
                .comment("Number of consecutive headshots required to trigger Lightning Strike.")
                .defineInRange("requiredHeadshots", 10, 1, Integer.MAX_VALUE);
        REIGN_HAVOC_LIGHTNING_DAMAGE = builder
                .comment("闪电打击造成的伤害")
                .comment("Damage dealt by Lightning Strike.")
                .defineInRange("lightningDamage", 5.0, 0.0, Integer.MAX_VALUE);
        REIGN_HAVOC_REFILL_PERCENTAGE = builder
                .comment("触发闪电打击时弹匣填装系数（%）")
                .comment("Magazine Refill Multiplier When Lightning Strike is Triggered (%).")
                .defineInRange("refillPercentage", 0.10, 0.0, 1.0);
        REIGN_HAVOC_FIRE_DAMAGE = builder
                .comment("闪电打击是否造成火焰伤害")
                .comment("Does Lightning Strike deal Fire damage")
                .define("fireDamage", false);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        REIGN_HAVOC_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        REIGN_HAVOC_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        REIGN_HAVOC_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        REIGN_HAVOC_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("SUROS遗产").push("Suros Legacy");
        SUROS_LEGACY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SUROS_LEGACY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        SUROS_LEGACY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        SUROS_LEGACY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        SUROS_LEGACY_DAMAGE_BONUS = builder
                .comment("弹匣后半子弹造成的额外伤害系数（%）")
                .comment("Bonus damage percentage for bullets in the second half of the magazine (%).")
                .defineInRange("damageBonus", 0.05, 0.0, 1.0);
        SUROS_LEGACY_CURE_CHANCE = builder
                .comment("击杀时触发治愈效果的概率（%）")
                .comment("Probability of triggering cure effect when killing a player (%).")
                .defineInRange("cureChance", 0.33, 0.0, 1.0);
        SUROS_LEGACY_CURE_AMPLIFIER = builder
                .comment("击杀时触发治愈效果的等级")
                .comment("Level of triggering cure effect when killing a player")
                .defineInRange("cureAmplifier", 0, 0, 255);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SUROS_LEGACY_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SUROS_LEGACY_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SUROS_LEGACY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SUROS_LEGACY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("古昧的折磨").push("Primevals Torment");
        PRIMEVALS_TORMENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        PRIMEVALS_TORMENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        PRIMEVALS_TORMENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        PRIMEVALS_TORMENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        PRIMEVALS_TORMENT_TRIGGER_CHANCE = builder
                .comment("触发'凋零'效果的概率（%）")
                .comment("Probability of triggering 'Wither' effect (%)")
                .defineInRange("triggerChance", 1.0, 0.0, 1.0);
        PRIMEVALS_TORMENT_RANGE = builder
                .comment("'凋零'效果影响的半径范围（格）")
                .comment("Radius of 'Wither' effect area (block)")
                .defineInRange("range", 3.0, 1.0, 16.0);
        PRIMEVALS_TORMENT_EFFECT_DURATION = builder
                .comment("给予'凋零'效果的持续时间（tick）")
                .comment("Duration of the applied Wither effect (tick)")
                .defineInRange("effectDuration", 10, 1, Integer.MAX_VALUE);
        PRIMEVALS_TORMENT_EFFECT_LEVEL = builder
                .comment("给予'凋零'效果的等级")
                .comment("Applied Wither Effect Level")
                .defineInRange("effectLevel", 2, 1, 255);
        PRIMEVALS_TORMENT_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        PRIMEVALS_TORMENT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        PRIMEVALS_TORMENT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PRIMEVALS_TORMENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        PRIMEVALS_TORMENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("到此为止").push("Full Stop");
        FULL_STOP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        FULL_STOP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        FULL_STOP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        FULL_STOP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        FULL_STOP_HEADSHOT_MULTIPLIER = builder
                .comment("增加的爆头伤害倍数")
                .comment("Increased headshot damage multiplier")
                .defineInRange("headshotMultiplier", 3.0, 1.0, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        FULL_STOP_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        FULL_STOP_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        FULL_STOP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        FULL_STOP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("蔓延羸弱").push("Creeping Attrition");
        CREEPING_ATTRITION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        CREEPING_ATTRITION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        CREEPING_ATTRITION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        CREEPING_ATTRITION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        CREEPING_ATTRITION_REQUIRED_HEADSHOTS = builder
                .comment("触发所需的爆头命中次数")
                .comment("Headshots Required to Trigger")
                .defineInRange("requiredHeadshots", 5, 1, Integer.MAX_VALUE);
        CREEPING_ATTRITION_TIME_WINDOW = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("killWindowTicks", 60, 1, Integer.MAX_VALUE);
        CREEPING_ATTRITION_SLOW_DURATION = builder
                .comment("给予'减速'效果的持续时间（tick）")
                .comment("Duration of the applied Slow effect (tick)")
                .defineInRange("slowDuration", 160, 20, Integer.MAX_VALUE);
        CREEPING_ATTRITION_SLOW_LEVEL = builder
                .comment("给予'减速'效果的等级")
                .comment("Applied Slow Effect Level")
                .defineInRange("slowLevel", 1, 1, 255);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        CREEPING_ATTRITION_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        CREEPING_ATTRITION_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        CREEPING_ATTRITION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        CREEPING_ATTRITION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "smg", "rifle", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("恶意触碰").push("Touch of Malice");
        TOUCH_OF_MALICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        TOUCH_OF_MALICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        TOUCH_OF_MALICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        TOUCH_OF_MALICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        TOUCH_OF_MALICE_DAMAGE_BONUS_PER_HEART = builder
                .comment("每颗心提供的额外伤害系数（%）")
                .comment("Bonus damage multiplier per Heart (%)")
                .defineInRange("damageBonusPerHeart", 0.05, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        TOUCH_OF_MALICE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        TOUCH_OF_MALICE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        TOUCH_OF_MALICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        TOUCH_OF_MALICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("正确抉择").push("The Right Choice");
        THE_RIGHT_CHOICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        THE_RIGHT_CHOICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        THE_RIGHT_CHOICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        THE_RIGHT_CHOICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        THE_RIGHT_CHOICE_TRIGGER_INTERVAL = builder
                .comment("触发时需要射击的次数")
                .comment("Number of shots required to trigger.")
                .defineInRange("triggerInterval", 7, 1, Integer.MAX_VALUE);
        THE_RIGHT_CHOICE_RANGE = builder
                .comment("子弹伤害弹射范围（格）")
                .comment("Bullet damage ricochet range (block).")
                .defineInRange("range", 5.0, 1.0, 16.0);
        THE_RIGHT_CHOICE_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        THE_RIGHT_CHOICE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        THE_RIGHT_CHOICE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        THE_RIGHT_CHOICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        THE_RIGHT_CHOICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("十六进制").push("Vexadecimal");
        VEXADECIMAL_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        VEXADECIMAL_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        VEXADECIMAL_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        VEXADECIMAL_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        VEXADECIMAL_WEAKNESS_DURATION = builder
                .comment("给予'虚弱'效果的持续时间（tick）")
                .comment("Duration of the applied Vulnerable effect (tick)")
                .defineInRange("weaknessDuration", 5, 1, Integer.MAX_VALUE);
        VEXADECIMAL_WEAKNESS_LEVEL = builder
                .comment("给予'虚弱'效果的等级")
                .comment("Applied Vulnerable Effect Level")
                .defineInRange("weaknessLevel", 1, 1, 255);
        VEXADECIMAL_EXTRA_DAMAGE_PERCENT = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("extraDamagePercent", 0.33, 0.1, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        VEXADECIMAL_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        VEXADECIMAL_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        VEXADECIMAL_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        VEXADECIMAL_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("私人助手").push("Personal Assistant");
        PERSONAL_ASSISTANT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        PERSONAL_ASSISTANT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        PERSONAL_ASSISTANT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        PERSONAL_ASSISTANT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        PERSONAL_ASSISTANT_JOLT_DURATION = builder
                .comment("给予'震颤'效果的持续时间（tick）")
                .comment("Duration of the applied Jolt effect (tick)")
                .defineInRange("joltDuration", 1, 1, Integer.MAX_VALUE);
        PERSONAL_ASSISTANT_JOLT_LEVEL = builder
                .comment("给予'震颤'效果的等级")
                .comment("Applied Jolt Effect Level")
                .defineInRange("joltLevel", 1, 1, 255);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        PERSONAL_ASSISTANT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        PERSONAL_ASSISTANT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PERSONAL_ASSISTANT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        PERSONAL_ASSISTANT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("增伤类").push("Bonus Damage Category");
        builder.comment("斩首武器").push("Borpal Weapon");
        BORPAL_WEAPON_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 5, 1, 5);
        BORPAL_WEAPON_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 4, 1, Integer.MAX_VALUE);
        BORPAL_WEAPON_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        BORPAL_WEAPON_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 12, 1, Integer.MAX_VALUE);
        BORPAL_WEAPON_BOSS_DAMAGE_BONUS = builder
                .comment("每级对Boss的伤害加成系数（%）")
                .comment("Damage bonus multiplier against Boss per level (%)")
                .defineInRange("bossDamageBonus", 0.1, 0.0, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        BORPAL_WEAPON_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        BORPAL_WEAPON_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("精准工具").push("Precision Instrument");
        PRECISION_INSTRUMENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        PRECISION_INSTRUMENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        PRECISION_INSTRUMENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        PRECISION_INSTRUMENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        PRECISION_INSTRUMENT_FIRE_PERCENTAGE = builder
                .comment("触发所需的射击系数（%）")
                .comment("Shot coefficient required for trigger (%)")
                .defineInRange("firePercentage", 0.15, 0.05, 1.0);
        PRECISION_INSTRUMENT_MULTIPLIER_BONUS = builder
                .comment("爆头加成系数（%）")
                .comment("Headshot bonus coefficient (%)")
                .defineInRange("multiplierBonus", 0.35, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        PRECISION_INSTRUMENT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        PRECISION_INSTRUMENT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("目标锁定").push("Target Lock");
        TARGET_LOCK_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        TARGET_LOCK_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        TARGET_LOCK_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        TARGET_LOCK_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        TARGET_LOCK_DAMAGE_BONUS_PER_STACK = builder
                .comment("每层伤害加成系数（%）")
                .comment("Damage bonus coefficient per stack (%)")
                .defineInRange("damageBonusPerStack", 0.12, 0.01, 1.0);
        TARGET_LOCK_MAX_STACKS = builder
                .comment("伤害加成层数上限")
                .comment("Maximum damage bonus stacks")
                .defineInRange("maxStacks", 5, 1, Integer.MAX_VALUE);
        TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT = builder
                .comment("触发加成所需弹匣弹药消耗系数（%）")
                .comment("Multiplier of magazine shots required to trigger the bonus (%)")
                .defineInRange("requiredMagazinePercent", 0.15, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        TARGET_LOCK_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        TARGET_LOCK_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        TARGET_LOCK_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("直击要害").push("Gutshot Straight");
        GUTSHOT_STRAIGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        GUTSHOT_STRAIGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        GUTSHOT_STRAIGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        GUTSHOT_STRAIGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        GUTSHOT_STRAIGHT_DAMAGE_BONUS = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("damageBonus", 0.15, 0.1, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        GUTSHOT_STRAIGHT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        GUTSHOT_STRAIGHT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        GUTSHOT_STRAIGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        GUTSHOT_STRAIGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("热能雾化").push("Thermal Atomization");
        THERMAL_ATOMIZATION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        THERMAL_ATOMIZATION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        THERMAL_ATOMIZATION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        THERMAL_ATOMIZATION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        THERMAL_ATOMIZATION_DAMAGE_BONUS = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("damageBonus", 0.25, 0.0, 1.0);
        THERMAL_ATOMIZATION_EXPLOSION_MIN_DAMAGE = builder
                .comment("击杀时最低爆炸伤害")
                .comment("Minimum explosion damage on kill")
                .defineInRange("explosionMinDamage", 1.0, 0.0, Integer.MAX_VALUE);
        THERMAL_ATOMIZATION_EXPLOSION_MAX_DAMAGE = builder
                .comment("击杀时最高爆炸伤害")
                .comment("Maximum explosion damage on kill")
                .defineInRange("explosionMaxDamage", 3.0, 0.0, Integer.MAX_VALUE);
        THERMAL_ATOMIZATION_EXPLOSION_RANGE = builder
                .comment("击杀时爆炸半径（格）")
                .comment("Explosion radius on kill (block)")
                .defineInRange("explosionRange", 1.5, 0.0, 16.0);
        THERMAL_ATOMIZATION_HEAT_THRESHOLD = builder
                .comment("触发效果的热量阈值（%）")
                .comment("Heat threshold for triggering the effect (%)")
                .defineInRange("heatThreshold", 0.5, 0.0, 1.0);
        THERMAL_ATOMIZATION_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        THERMAL_ATOMIZATION_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", true);
        THERMAL_ATOMIZATION_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        THERMAL_ATOMIZATION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        THERMAL_ATOMIZATION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("斗剑士").push("Swashbuckler");
        SWASHBUCKLER_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SWASHBUCKLER_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        SWASHBUCKLER_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        SWASHBUCKLER_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        SWASHBUCKLER_MAX_STACKS = builder
                .comment("加成层数上限")
                .comment("Maximum bonus stacks")
                .defineInRange("maxStacks", 5, 1, Integer.MAX_VALUE);
        SWASHBUCKLER_DECREASE_INTERVAL_TICKS = builder
                .comment("层数降低间隔（tick）")
                .comment("Stack decrease interval (ticks).")
                .defineInRange("decreaseIntervalTicks", 90, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SWASHBUCKLER_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SWASHBUCKLER_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SWASHBUCKLER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SWASHBUCKLER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("我为人人").push("One For All");
        ONE_FOR_ALL_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        ONE_FOR_ALL_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        ONE_FOR_ALL_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        ONE_FOR_ALL_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        ONE_FOR_ALL_DAMAGE_BONUS = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("damageBonus", 0.2, 0.0, 1.0);
        ONE_FOR_ALL_DURATION_SECONDS = builder
                .comment("加成系数持续时间（Tick）")
                .comment("Bonus coefficient duration (ticks)")
                .defineInRange("durationSeconds", 120, 1, Integer.MAX_VALUE);
        ONE_FOR_ALL_REQUIRED_HITS = builder
                .comment("需要命中的不同目标数量")
                .comment("Number of Unique Targets that Need to be Hit")
                .defineInRange("requiredHits", 3, 2, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        ONE_FOR_ALL_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        ONE_FOR_ALL_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        ONE_FOR_ALL_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        ONE_FOR_ALL_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("武器大师").push("Master of Arms");
        MASTER_OF_ARMS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        MASTER_OF_ARMS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        MASTER_OF_ARMS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        MASTER_OF_ARMS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 35, 1, Integer.MAX_VALUE);
        MASTER_OF_ARMS_STACK_1_DAMAGE_BONUS = builder
                .comment("'武器大师x1'的伤害加成系数（%）")
                .comment("Damage Bonus Multiplier of 'Master of Arms x1' (%)")
                .defineInRange("stack1DamageBonus", 0.15, 0.0, 1.0);
        MASTER_OF_ARMS_STACK_1_DURATION_SECONDS = builder
                .comment("'武器大师x1'的加成系数持续时间（tick）")
                .comment("Bonus coefficient Duration of 'Master of Arms x1' (ticks)")
                .defineInRange("stack1DurationSeconds", 140, 20, Integer.MAX_VALUE);
        MASTER_OF_ARMS_STACK_2_DAMAGE_BONUS = builder
                .comment("'武器大师x2'的伤害加成系数（%）")
                .comment("Damage Bonus Multiplier of 'Master of Arms x2' (%)")
                .defineInRange("stack2DamageBonus", 0.25, 0.0, 1.0);
        MASTER_OF_ARMS_STACK_2_DURATION_SECONDS = builder
                .comment("'武器大师x2'的加成系数持续时间（tick）")
                .comment("Bonus coefficient Duration of 'Master of Arms x2' (ticks)")
                .defineInRange("stack2DurationSeconds", 80, 20, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        MASTER_OF_ARMS_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        MASTER_OF_ARMS_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        MASTER_OF_ARMS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        MASTER_OF_ARMS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("聚合充能").push("Aggregate Charge");
        AGGREGATE_CHARGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        AGGREGATE_CHARGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        AGGREGATE_CHARGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        AGGREGATE_CHARGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        AGGREGATE_CHARGE_DAMAGE_BONUS_PERCENT = builder
                .comment("每种减益增加的伤害系数（%）")
                .comment("Damage Bonus Multiplier per debuff (%)")
                .defineInRange("damageBonusPercent", 0.11, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        AGGREGATE_CHARGE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        AGGREGATE_CHARGE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        AGGREGATE_CHARGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        AGGREGATE_CHARGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("火线").push("Firing Line");
        FIRING_LINE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        FIRING_LINE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        FIRING_LINE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        FIRING_LINE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        FIRING_LINE_RADIUS = builder
                .comment("检测半径（格）")
                .comment("Detection Radius (block)")
                .defineInRange("radius", 4.0, 1.0, 16.0);
        FIRING_LINE_REQUIRED_PLAYERS = builder
                .comment("所需玩家数量")
                .comment("Required Number of Players")
                .defineInRange("requiredPlayers", 2, 2, Integer.MAX_VALUE);
        FIRING_LINE_DAMAGE_BONUS = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("damageBonus", 0.35, 0.05, 1.0);
        FIRING_LINE_EXCLUDE_SELF = builder
                .comment("是否排除玩家自己（true = 排除自己，false = 包括自己）")
                .comment("Exclude the Player Themself (true = exclude self, false = include self)")
                .define("excludeSelf", true);
        FIRING_LINE_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        FIRING_LINE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        FIRING_LINE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        FIRING_LINE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        FIRING_LINE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("盒式呼吸法").push("Box Breathing");
        BOX_BREATHING_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        BOX_BREATHING_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        BOX_BREATHING_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        BOX_BREATHING_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        BOX_BREATHING_DAMAGE_BONUS = builder
                .comment("伤害加成系数（%）")
                .comment("Damage bonus coefficient (%)")
                .defineInRange("damageBonus", 0.4, 0.1, 1.0);
        BOX_BREATHING_AIMING_REQUIRED_TICKS = builder
                .comment("需要持续瞄准的时间（ticks）")
                .comment("Required continuous aiming time (tick)")
                .defineInRange("requiredTicks", 28, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        BOX_BREATHING_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        BOX_BREATHING_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BOX_BREATHING_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        BOX_BREATHING_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("爆炸光能").push("Explosive Light");
        EXPLOSIVE_LIGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        EXPLOSIVE_LIGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        EXPLOSIVE_LIGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        EXPLOSIVE_LIGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        EXPLOSIVE_LIGHT_DAMAGE_BONUS = builder
                .comment("每层伤害加成系数（%）")
                .comment("Damage bonus coefficient per stack (%)")
                .defineInRange("damageBonus", 0.35, 0.1, 1.0);
        EXPLOSIVE_LIGHT_XP_PER_STACK = builder
                .comment("每层所需经验值")
                .comment("Experience Required per Level")
                .defineInRange("xpPerStack", 25, 5, Integer.MAX_VALUE);
        EXPLOSIVE_LIGHT_MAX_STACKS = builder
                .comment("可持有的最大层数")
                .comment("Maximum Stackable Levels")
                .defineInRange("maxStacks", 6, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        EXPLOSIVE_LIGHT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        EXPLOSIVE_LIGHT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        EXPLOSIVE_LIGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        EXPLOSIVE_LIGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("子弹类").push("Ammo Category");
        builder.comment("维持生计").push("Subsistence");
        SUBSISTENCE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        SUBSISTENCE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 10, 1, Integer.MAX_VALUE);
        SUBSISTENCE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        SUBSISTENCE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        SUBSISTENCE_BASE_AMMO_PERCENTAGE = builder
                .comment("基础弹药恢复系数（%）")
                .comment("Base ammo recovery coefficient (%)")
                .defineInRange("baseAmmoPercentage", 0.1, 0.0, 1.0);
        SUBSISTENCE_AMMO_PERCENTAGE_PER_LEVEL = builder
                .comment("每级弹药恢复系数（%）")
                .comment("Ammo Recovery Multiplier per Level (%)")
                .defineInRange("percentagePerLevel", 0.05, 0.0, 1.0);
        SUBSISTENCE_KILL_THRESHOLD = builder
                .comment("触发弹药恢复所需的击杀数量")
                .comment("Kills Required to Trigger Ammo Recovery")
                .defineInRange("killThreshold", 3, 1, 20);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SUBSISTENCE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SUBSISTENCE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SUBSISTENCE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("刺客野心").push("Ambitious Assassin");
        AMBITIOUS_ASSASSIN_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        AMBITIOUS_ASSASSIN_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        AMBITIOUS_ASSASSIN_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        AMBITIOUS_ASSASSIN_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        AMBITIOUS_ASSASSIN_CAPACITY_BONUS_PERCENT = builder
                .comment("每次击杀提升的弹匣容量百分比（%）")
                .comment("Capacity bonus percentage per kill (%)")
                .defineInRange("capacityBonusPercent", 0.2, 0.01, 1.0);
        AMBITIOUS_ASSASSIN_MAX_CAPACITY_BONUS_PERCENT = builder
                .comment("最大弹匣容量提升百分比（%）")
                .comment("Maximum capacity bonus percentage (%)")
                .defineInRange("maxCapacityBonusPercent", 1.5, 0.1, 3.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        AMBITIOUS_ASSASSIN_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        AMBITIOUS_ASSASSIN_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("重建").push("Reconstruction");
        RECONSTRUCTION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        RECONSTRUCTION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        RECONSTRUCTION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        RECONSTRUCTION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        RECONSTRUCTION_RELOAD_INTERVAL = builder
                .comment("自动填装间隔（tick）")
                .comment("Auto-Reload Interval (ticks)")
                .defineInRange("reloadInterval", 100, 10, Integer.MAX_VALUE);
        RECONSTRUCTION_RELOAD_PERCENT = builder
                .comment("每次填装的弹匣容量系数（%）")
                .comment("Reload multiplier per magazine capacity (%)")
                .defineInRange("reloadPercent", 0.25, 0.01, 1.0);
        RECONSTRUCTION_SHOOT_COOLDOWN = builder
                .comment("开枪后冷却时间（tick）")
                .comment("Cooldown After Firing (ticks)")
                .defineInRange("shootCooldown", 100, 20, Integer.MAX_VALUE);
        RECONSTRUCTION_MAX_AMMO = builder
                .comment("最大弹匣容量倍数")
                .comment("Maximum Magazine Capacity Multiplier")
                .defineInRange("maxAmmo", 2, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        RECONSTRUCTION_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        RECONSTRUCTION_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        RECONSTRUCTION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("精准连击").push("Triple Tap");
        TRIPLE_TAP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        TRIPLE_TAP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        TRIPLE_TAP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        TRIPLE_TAP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        TRIPLE_TAP_HIT_COUNT = builder
                .comment("触发所需的精准命中次数")
                .comment("Headshots Required to Trigger")
                .defineInRange("hitCount", 3, 2, Integer.MAX_VALUE);
        TRIPLE_TAP_TIME_WINDOW = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("timeWindow", 40, 10, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        TRIPLE_TAP_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        TRIPLE_TAP_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        TRIPLE_TAP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("事不过四").push("Fourth Time The Charm");
        FOURTH_TIME_THE_CHARM_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        FOURTH_TIME_THE_CHARM_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        FOURTH_TIME_THE_CHARM_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        FOURTH_TIME_THE_CHARM_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        FOURTH_TIME_THE_CHARM_HIT_COUNT = builder
                .comment("触发所需的精准命中次数")
                .comment("Headshots Required to Trigger")
                .defineInRange("hitCount", 4, 2, Integer.MAX_VALUE);
        FOURTH_TIME_THE_CHARM_TIME_WINDOW = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("timeWindow", 40, 20, Integer.MAX_VALUE);
        FOURTH_TIME_THE_CHARM_AMMO_RETURN = builder
                .comment("每次触发后返还的弹药数")
                .comment("Ammo Refunded per Trigger")
                .defineInRange("ammoReturn", 2, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        FOURTH_TIME_THE_CHARM_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        FOURTH_TIME_THE_CHARM_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("回转弹药").push("Rewind Rounds");
        REWIND_ROUNDS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        REWIND_ROUNDS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        REWIND_ROUNDS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        REWIND_ROUNDS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        REWIND_ROUNDS_RESTORE_PERCENTAGE = builder
                .comment("根据命中次数恢复的弹匣容量系数（%）")
                .comment("Magazine Capacity Restored per Hit (%)")
                .defineInRange("restorePercentage", 0.6, 0.1, 1.0);
        REWIND_ROUNDS_MIN_FIRE_PERCENTAGE = builder
                .comment("触发所需的最少射击系数（%）")
                .comment("Minimum Shots Required to Trigger (%)")
                .defineInRange("minFirePercentage", 0.2875, 0.1, 1.0);
        TARGET_LOCK_TIMEOUT_SECONDS = builder
                .comment("超时重置时间（tick）")
                .comment("Timeout reset time (ticks)")
                .defineInRange("timeoutSeconds", 20, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        REWIND_ROUNDS_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        REWIND_ROUNDS_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("重新调度").push("Mulligan");
        MULLIGAN_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        MULLIGAN_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        MULLIGAN_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        MULLIGAN_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        MULLIGAN_BASE_CHANCE = builder
                .comment("基础返还概率（%）")
                .comment("Base Refund Chance (%)")
                .defineInRange("baseChance", 0.35, 0.0, 1.0);
        MULLIGAN_CHANCE_PER_LEVEL = builder
                .comment("每级增加的返还概率（%）")
                .comment("Refund Chance Increase per Level (%)")
                .defineInRange("chancePerLevel", 0.05, 0.0, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        MULLIGAN_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        MULLIGAN_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        MULLIGAN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        MULLIGAN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("涓流充能").push("Trickle Charge");
        TRICKLE_CHARGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        TRICKLE_CHARGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        TRICKLE_CHARGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 9, 1, Integer.MAX_VALUE);
        TRICKLE_CHARGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        TRICKLE_CHARGE_RECEIVE_PERCENTAGE = builder
                .comment("接收电光充能时补充的弹匣容量（%）")
                .comment("Magazine Capacity Refilled When Receiving Electro-Charge (%)")
                .defineInRange("receivePercentage", 0.1, 0.01, 1.0);
        TRICKLE_CHARGE_RELEASE_PERCENTAGE = builder
                .comment("释放电光充能时补充的弹匣容量（%）")
                .comment("Magazine Capacity Refilled When Releasing Electro-Charge (%)")
                .defineInRange("releasePercentage", 0.2, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        TRICKLE_CHARGE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        TRICKLE_CHARGE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        TRICKLE_CHARGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        TRICKLE_CHARGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("超充弹匣").push("Supercharged Magazine");
        SUPERCHARGED_MAGAZINE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SUPERCHARGED_MAGAZINE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        SUPERCHARGED_MAGAZINE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 9, 1, Integer.MAX_VALUE);
        SUPERCHARGED_MAGAZINE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        SUPERCHARGED_MAGAZINE_RELOAD_PERCENTAGE = builder
                .comment("弹药恢复系数（%）")
                .comment("Ammo recovery coefficient (%)")
                .defineInRange("reloadPercentage", 0.10, 0.01, 1.0);
        SUPERCHARGED_MAGAZINE_RELOAD_INTERVAL = builder
                .comment("弹药恢复的间隔时间（tick）")
                .comment("Ammo recovery Interval (tick)")
                .defineInRange("reloadInterval", 30, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SUPERCHARGED_MAGAZINE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SUPERCHARGED_MAGAZINE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SUPERCHARGED_MAGAZINE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SUPERCHARGED_MAGAZINE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("命运的逆转").push("Reversal of Fortune");
        REVERSAL_OF_FORTUNE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        REVERSAL_OF_FORTUNE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 9, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_REQUIRED_MISSES = builder
                .comment("需要射偏的子弹数量")
                .comment("Number of Shots That Need to Miss")
                .defineInRange("requiredMisses", 2, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_REFUND_AMOUNT = builder
                .comment("返还的弹药数量")
                .comment("Ammo Refund Amount")
                .defineInRange("refundAmount", 1, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_MISS_TIMEOUT = builder
                .comment("射偏超时时间（tick）")
                .comment("Miss Timeout (tick)")
                .defineInRange("missTimeout", 60, 1, Integer.MAX_VALUE);
        REVERSAL_OF_FORTUNE_COOLDOWN = builder
                .comment("成功返还后的冷却时间（tick）")
                .comment("Cooldown After Successful Refund (tick)")
                .defineInRange("cooldown", 30, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        REVERSAL_OF_FORTUNE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        REVERSAL_OF_FORTUNE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        REVERSAL_OF_FORTUNE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        REVERSAL_OF_FORTUNE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("小丑皇弹药筒").push("Clown Cartridge");
        CLOWN_CARTRIDGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        CLOWN_CARTRIDGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        CLOWN_CARTRIDGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        CLOWN_CARTRIDGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        CLOWN_CARTRIDGE_MIN_PERCENTAGE = builder
                .comment("额外装填的最小值（%）")
                .comment("Minimum Extra Reload Amount (%)")
                .defineInRange("minPercentage", 0.1, 0.01, 1.0);
        CLOWN_CARTRIDGE_MAX_PERCENTAGE = builder
                .comment("额外装填的最大值（%）")
                .comment("Maximum Extra Reload Amount (%)")
                .defineInRange("maxPercentage", 0.5, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        CLOWN_CARTRIDGE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        CLOWN_CARTRIDGE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        CLOWN_CARTRIDGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        CLOWN_CARTRIDGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("效果类").push("Effect Category");
        builder.comment("治疗弹匣").push("Heal Clip");
        HEAL_CLIP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        HEAL_CLIP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        HEAL_CLIP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        HEAL_CLIP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        HEAL_CLIP_BASE_AMPLIFIER = builder
                .comment("基础效果等级")
                .comment("Base effect level")
                .defineInRange("baseAmplifier", 1, 0, 255);
        HEAL_CLIP_AMPLIFIER_PER_LEVEL = builder
                .comment("每级增加的效果等级")
                .comment("Effect level increase per level")
                .defineInRange("amplifierPerLevel", 1, 0, 255);
        HEAL_CLIP_RELOAD_TICKS = builder
                .comment("有效换弹时间窗口（tick）")
                .comment("Valid Reload Time Window (tick)")
                .defineInRange("reloadTicks", 120, 1, Integer.MAX_VALUE);
        HEAL_CLIP_AREA_RADIUS = builder
                .comment("治疗半径（格）")
                .comment("Healing radius (blocks)")
                .defineInRange("areaRadius", 5.0, 1.0, 10.0);
        HEAL_CLIP_HEAL_PEACEFUL = builder
                .comment("是否治疗和平生物")
                .comment("Whether to heal peaceful mobs")
                .define("healPeaceful", true);
        HEAL_CLIP_OTHER_PLAYER_AMPLIFIER = builder
                .comment("治疗范围内其他玩家的治愈等级")
                .comment("Cure amplifier for other players in healing range")
                .defineInRange("otherPlayerAmplifier", 0, 0, 255);
        HEAL_CLIP_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        HEAL_CLIP_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        HEAL_CLIP_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        HEAL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("风暴涌动").push("Rolling Storm");
        ROLLING_STORM_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        ROLLING_STORM_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        ROLLING_STORM_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        ROLLING_STORM_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        ROLLING_STORM_AMPLIFIED_DURATION = builder
                .comment("'增幅'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Amplified' effect is first acquired (tick)")
                .defineInRange("amplifiedDuration", 300, 50, Integer.MAX_VALUE);
        ROLLING_STORM_AMPLIFIED_AMPLIFIER = builder
                .comment("'增幅'效果首次获取时给予的等级")
                .comment("Level granted when 'Amplified' effect is first acquired")
                .defineInRange("amplifiedAmplifier", 0, 0, 255);
        ROLLING_STORM_COOLDOWN_TICKS = builder
                .comment("'增幅'效果首次获取后需要冷却的时间（tick）")
                .comment("Cooldown time after first acquiring 'Amplified' (tick)")
                .defineInRange("amplifiedCooldownTicks", 400, 100, Integer.MAX_VALUE);
        ROLLING_STORM_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        ROLLING_STORM_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 600, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        ROLLING_STORM_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        ROLLING_STORM_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        ROLLING_STORM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("失衡弹药").push("Destabilizing Rounds");
        DESTABILIZING_ROUNDS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        DESTABILIZING_ROUNDS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        DESTABILIZING_ROUNDS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        DESTABILIZING_ROUNDS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        DESTABILIZING_ROUNDS_RANGE = builder
                .comment("范围影响半径（格）")
                .comment("Area effect radius (block)")
                .defineInRange("range", 4.0, 1.0, 16.0);
        DESTABILIZING_ROUNDS_VOLATILE_DURATION = builder
                .comment("'不稳定'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Volatile' effect is first acquired (tick)")
                .defineInRange("volatileDuration", 200, 50, Integer.MAX_VALUE);
        DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER = builder
                .comment("'不稳定'效果首次获取时给予的等级")
                .comment("Level granted when 'Volatile' effect is first acquired")
                .defineInRange("volatileAmplifier", 0, 0, 255);
        DESTABILIZING_ROUNDS_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        DESTABILIZING_ROUNDS_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 600, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        DESTABILIZING_ROUNDS_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        DESTABILIZING_ROUNDS_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("辉耀炽热").push("Incandescent");
        INCANDESCENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        INCANDESCENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        INCANDESCENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        INCANDESCENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        INCANDESCENT_RANGE = builder
                .comment("范围影响半径（格）")
                .comment("Area effect radius (block)")
                .defineInRange("range", 4.0, 1.0, 16.0);
        INCANDESCENT_SCORCH_DURATION = builder
                .comment("'灼烧'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Scorch' effect is first acquired (tick)")
                .defineInRange("scorchDuration", 200, 50, Integer.MAX_VALUE);
        INCANDESCENT_SCORCH_AMPLIFIER = builder
                .comment("'灼烧'效果首次获取时给予的等级 ")
                .comment("Level granted when 'Scorch' effect is first acquired")
                .defineInRange("scorchAmplifier", 0, 0, 255);
        INCANDESCENT_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        INCANDESCENT_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 600, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        INCANDESCENT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        INCANDESCENT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        INCANDESCENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("冰冷弹匣").push("Chill Clip");
        CHILL_CLIP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        CHILL_CLIP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        CHILL_CLIP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        CHILL_CLIP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        CHILL_CLIP_TRIGGER_CHANCE = builder
                .comment("效果触发概率（%）")
                .comment("Effect trigger chance (%)")
                .defineInRange("triggerChance", 0.15, 0.01, 1.0);
        CHILL_CLIP_SLOW_DURATION = builder
                .comment("'减速'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Slow' effect is first acquired (tick)")
                .defineInRange("slowDuration", 200, 50, Integer.MAX_VALUE);
        CHILL_CLIP_SLOW_MIN_AMPLIFIER = builder
                .comment("'减速'效果首次获取时给予的最小等级")
                .comment("Minimum Level Granted on First Obtaining the 'Slow' Effect")
                .defineInRange("slowMinAmplifier", 0, 0, 255);
        CHILL_CLIP_SLOW_MAX_AMPLIFIER = builder
                .comment("'减速'效果首次获取时给予的最大等级")
                .comment("Maximum Level Granted on First Obtaining the 'Slow' Effect")
                .defineInRange("slowMaxAmplifier", 2, 0, 255);
        CHILL_CLIP_COOLDOWN_TICKS = builder
                .comment("'减速'效果首次获取后需要冷却的时间（tick）")
                .comment("Cooldown time after first acquiring 'Slow' (tick)")
                .defineInRange("cooldownTicks", 300, 20, Integer.MAX_VALUE);
        CHILL_CLIP_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        CHILL_CLIP_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 20, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        CHILL_CLIP_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        CHILL_CLIP_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        CHILL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("霜华窃取者").push("Rimestealer");
        RIMESTEALER_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        RIMESTEALER_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        RIMESTEALER_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        RIMESTEALER_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        RIMESTEALER_FROST_ARMOR_DURATION = builder
                .comment("'冰霜护甲'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Frost Armor' effect is first acquired (tick)")
                .defineInRange("frostArmorDuration", 200, 50, Integer.MAX_VALUE);
        RIMESTEALER_FROST_ARMOR_AMPLIFIER = builder
                .comment("'冰霜护甲'效果首次获取时给予的等级")
                .comment("Level granted when 'Frost Armor' effect is first acquired")
                .defineInRange("frostArmorAmplifier", 0, 0, 255);
        RIMESTEALER_COOLDOWN_TICKS = builder
                .comment("'冰霜护甲'效果首次获取后需要冷却的时间（tick）")
                .comment("Cooldown time after first acquiring 'Frost Armor' (tick)")
                .defineInRange("cooldownTicks", 300, 20, Integer.MAX_VALUE);
        RIMESTEALER_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        RIMESTEALER_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 20, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        RIMESTEALER_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        RIMESTEALER_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        RIMESTEALER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("切割").push("Slice");
        SLICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SLICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        SLICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        SLICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        SLICE_TRIGGER_CHANCE = builder
                .comment("效果触发概率（%）")
                .comment("Effect trigger chance (%)")
                .defineInRange("triggerChance", 0.15, 0.01, 1.0);
        SLICE_SEVER_DURATION = builder
                .comment("'瓦解'效果首次获取时给予的持续时间（tick）")
                .comment("Duration granted when 'Sever' effect is first acquired (tick)")
                .defineInRange("severDuration", 200, 50, Integer.MAX_VALUE);
        SLICE_SEVER_MIN_AMPLIFIER = builder
                .comment("'瓦解'效果首次获取时给予的最小等级")
                .comment("Minimum Level Granted on First Obtaining the 'Sever' Effect")
                .defineInRange("severMinAmplifier", 0, 0, 255);
        SLICE_SEVER_MAX_AMPLIFIER = builder
                .comment("'瓦解'效果首次获取时给予的最大等级")
                .comment("Maximum Level Granted on First Obtaining the 'Sever' Effect")
                .defineInRange("severMaxAmplifier", 2, 0, 255);
        SLICE_COOLDOWN_TICKS = builder
                .comment("'瓦解'效果首次获取后需要冷却的时间（tick）")
                .comment("Cooldown time after first acquiring 'Sever' (tick)")
                .defineInRange("cooldownTicks", 300, 20, Integer.MAX_VALUE);
        SLICE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .comment("Extended duration when effect is active (tick)")
                .defineInRange("extendDuration", 100, 20, Integer.MAX_VALUE);
        SLICE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .comment("Maximum extended duration when effect is active (tick)")
                .defineInRange("maxDuration", 1200, 20, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SLICE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SLICE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SLICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SLICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("枯萎凝视").push("Withering Gaze");
        WITHERING_GAZE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        WITHERING_GAZE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        WITHERING_GAZE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        WITHERING_GAZE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        WITHERING_GAZE_EFFECT_DURATION = builder
                .comment("给予'虚弱'效果的持续时间（tick）")
                .comment("Duration of the applied 'Vulnerable' effect (tick)")
                .defineInRange("effectDuration", 100, 20, Integer.MAX_VALUE);
        WITHERING_GAZE_EFFECT_LEVEL = builder
                .comment("给予'虚弱'效果的等级")
                .comment("Applied 'Vulnerable' Effect Level")
                .defineInRange("effectLevel", 1, 1, 255);
        WITHERING_GAZE_AIMING_REQUIRED_TICKS = builder
                .comment("需要持续瞄准的时间（tick）")
                .comment("Required continuous aiming time (tick)")
                .defineInRange("requiredTicks", 28, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        WITHERING_GAZE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        WITHERING_GAZE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        WITHERING_GAZE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("燃烧野心").push("Burning Ambition");
        BURNING_AMBITION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        BURNING_AMBITION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        BURNING_AMBITION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        BURNING_AMBITION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        BURNING_AMBITION_SHOTS_PER_STACK = builder
                .comment("叠一次燃烧层数所需要的射击次数")
                .comment("Shots Required to Gain One Burn Stack")
                .defineInRange("shotsPerStack", 1, 1, Integer.MAX_VALUE);
        BURNING_AMBITION_STACKS_PER_HIT = builder
                .comment("每次命中给予的燃烧层数")
                .comment("Burn Stacks Granted per Hit")
                .defineInRange("stacksPerHit", 1, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        BURNING_AMBITION_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        BURNING_AMBITION_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        BURNING_AMBITION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        BURNING_AMBITION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("瓦解").push("Demoralize");
        DEMORALIZE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        DEMORALIZE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        DEMORALIZE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        DEMORALIZE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        DEMORALIZE_RADIUS = builder
                .comment("范围影响半径（格）")
                .comment("Area effect radius (block)")
                .defineInRange("radius", 3.0, 1.0, 16.0);
        DEMORALIZE_EFFECT_DURATION = builder
                .comment("给予'瓦解'效果的持续时间")
                .comment("Duration of the applied 'Sever' effect (tick)")
                .defineInRange("effectDuration", 100, 20, Integer.MAX_VALUE);
        DEMORALIZE_EFFECT_LEVEL = builder
                .comment("给予'瓦解'效果的等级")
                .comment("Applied 'Sever' Effect Level")
                .defineInRange("effectLevel", 1, 1, 255);
        DEMORALIZE_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        DEMORALIZE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        DEMORALIZE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        DEMORALIZE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        DEMORALIZE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("冲击支撑").push("Repulsor Brace");
        REPULSOR_BRACE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        REPULSOR_BRACE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        REPULSOR_BRACE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        REPULSOR_BRACE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        REPULSOR_BRACE_OVERSHIELD_DURATION = builder
                .comment("覆盖护盾持续时间（tick）")
                .comment("Overshield Duration (tick)")
                .defineInRange("overshieldDuration", 240, 1, Integer.MAX_VALUE);
        REPULSOR_BRACE_OVERSHIELD_LEVEL = builder
                .comment("覆盖护盾等级")
                .comment("Overshield Level")
                .defineInRange("overshieldLevel", 1, 1, 255);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        REPULSOR_BRACE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        REPULSOR_BRACE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        REPULSOR_BRACE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        REPULSOR_BRACE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("爆炸类").push("Explosive Category");
        builder.comment("蝴蝶").push("Butterfly");
        BUTTERFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        BUTTERFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        BUTTERFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        BUTTERFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        BUTTERFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .comment("Base Explosion Damage")
                .defineInRange("baseDamage", 0.5, 0.5, Integer.MAX_VALUE);
        BUTTERFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害")
                .comment("Explosion Damage per Level")
                .defineInRange("damagePerLevel", 0.5, 0.5, Integer.MAX_VALUE);
        BUTTERFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .comment("Minimum Splash Damage")
                .defineInRange("splashMin", 0.5, 0.1, Integer.MAX_VALUE);
        BUTTERFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .comment("Maximum Splash Damage")
                .defineInRange("splashMax", 2.0, 0.5, Integer.MAX_VALUE);
        BUTTERFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .comment("Splash Damage Range (block)")
                .defineInRange("range", 1.0, 0.1, 16.0);
        BUTTERFLY_AIMING_REQUIRED_TICKS = builder
                .comment("需要持续瞄准的时间（tick）")
                .comment("Required continuous aiming time (tick)")
                .defineInRange("requiredTicks", 28, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        BUTTERFLY_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        BUTTERFLY_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BUTTERFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        BUTTERFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("高爆载荷").push("Explosive Payload");
        EXPLOSIVE_PAYLOAD_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        EXPLOSIVE_PAYLOAD_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .comment("Base Explosion Damage")
                .defineInRange("baseDamage", 1.5, 1.0, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害")
                .comment("Explosion Damage per Level")
                .defineInRange("damagePerLevel", 0.5, 0.5, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .comment("Minimum Splash Damage")
                .defineInRange("splashMin", 0.5, 0.1, 10.0);
        EXPLOSIVE_PAYLOAD_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .comment("Maximum Splash Damage")
                .defineInRange("splashMax", 1.5, 0.5, Integer.MAX_VALUE);
        EXPLOSIVE_PAYLOAD_RANGE = builder
                .comment("溅射伤害范围（格）")
                .comment("Splash Damage Range (block)")
                .defineInRange("range", 0.5, 0.1, 16.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        EXPLOSIVE_PAYLOAD_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        EXPLOSIVE_PAYLOAD_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        EXPLOSIVE_PAYLOAD_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        EXPLOSIVE_PAYLOAD_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("萤火虫").push("Firefly");
        FIREFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        FIREFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        FIREFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        FIREFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        FIREFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .comment("Base Explosion Damage")
                .defineInRange("baseDamage", 1.0, 1.0, Integer.MAX_VALUE);
        FIREFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害")
                .comment("Explosion Damage per Level")
                .defineInRange("damagePerLevel", 0.5, 0.1, Integer.MAX_VALUE);
        FIREFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .comment("Minimum Splash Damage")
                .defineInRange("splashMin", 0.5, 0.1, Integer.MAX_VALUE);
        FIREFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .comment("Maximum Splash Damage")
                .defineInRange("splashMax", 1.5, 0.5, Integer.MAX_VALUE);
        FIREFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .comment("Splash Damage Range (block)")
                .defineInRange("range", 0.5, 0.1, 16.0);
        FIREFLY_BASE_RELOAD_SPEED = builder
                .comment("基础弹药恢复系数（%）")
                .comment("Base ammo recovery coefficient (%)")
                .defineInRange("baseReloadSpeed", 0.1, 0.1, 1.0);
        FIREFLY_RELOAD_SPEED_PER_LEVEL = builder
                .comment("每级增加的弹药恢复系数（%）")
                .comment("Ammo recovery coefficient increase per level (%)")
                .defineInRange("reloadSpeedPerLevel", 0.1, 0.0, 1.0);
        FIREFLY_KILL_WINDOW_TICKS = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("killWindowTicks", 120, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        FIREFLY_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        FIREFLY_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(),
                        obj -> obj instanceof String);
        FIREFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        FIREFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("蜻蜓").push("Dragonfly");
        DRAGONFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        DRAGONFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        DRAGONFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        DRAGONFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        DRAGONFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .comment("Base Explosion Damage")
                .defineInRange("baseDamage", 1.0, 1.0, Integer.MAX_VALUE);
        DRAGONFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害")
                .comment("Explosion Damage per Level")
                .defineInRange("damagePerLevel", 0.5, 0.1, Integer.MAX_VALUE);
        DRAGONFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .comment("Minimum Splash Damage")
                .defineInRange("splashMin", 0.5, 0.1, Integer.MAX_VALUE);
        DRAGONFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .comment("Maximum Splash Damage")
                .defineInRange("splashMax", 1.5, 0.5, Integer.MAX_VALUE);
        DRAGONFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .comment("Splash Damage Range (block)")
                .defineInRange("range", 0.5, 0.1, 16.0);
        DRAGONFLY_KILL_WINDOW_TICKS = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("killWindowTicks", 120, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        DRAGONFLY_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        DRAGONFLY_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        DRAGONFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("巨脉蜻蜓").push("Meganeura");
        MEGANEURA_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        MEGANEURA_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        MEGANEURA_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        MEGANEURA_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        MEGANEURA_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .comment("Base Explosion Damage")
                .defineInRange("baseDamage", 3.0, 1.0, Integer.MAX_VALUE);
        MEGANEURA_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害")
                .comment("Explosion Damage per Level")
                .defineInRange("damagePerLevel", 0.5, 0.1, Integer.MAX_VALUE);
        MEGANEURA_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .comment("Minimum Splash Damage")
                .defineInRange("splashMin", 1.5, 0.1, Integer.MAX_VALUE);
        MEGANEURA_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .comment("Maximum Splash Damage")
                .defineInRange("splashMax", 4.5, 0.5, Integer.MAX_VALUE);
        MEGANEURA_RANGE = builder
                .comment("溅射伤害范围（格）")
                .comment("Splash Damage Range (block)")
                .defineInRange("range", 1.5, 0.1, 16.0);
        MEGANEURA_HEADSHOT_THRESHOLD = builder
                .comment("触发所需的精准命中次数")
                .comment("Headshots Required to Trigger")
                .defineInRange("headshotThreshold", 5, 1, Integer.MAX_VALUE);
        MEGANEURA_DAMAGE_BONUS_PER_THRESHOLD = builder
                .comment("每个阈值增加的伤害系数（%）")
                .comment("Damage coefficient bonus per threshold (%)")
                .defineInRange("damageBonusPerThreshold", 0.05, 0.01, 1.0);
        MEGANEURA_MAX_DAMAGE_BONUS = builder
                .comment("最大伤害系数（%）")
                .comment("Maximum Damage coefficient bonus (%)")
                .defineInRange("maxDamageBonus", 0.50, 0.01, 1.0);
        MEGANEURA_KILL_TICKS = builder
                .comment("有效时间窗口（tick）")
                .comment("Valid Time Window (tick)")
                .defineInRange("killWindowTicks", 120, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        MEGANEURA_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        MEGANEURA_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        MEGANEURA_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        MEGANEURA_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("配件类").push("Accessories Category");
        builder.comment("不法之徒").push("Outlaw");
        OUTLAW_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        OUTLAW_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        OUTLAW_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        OUTLAW_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        OUTLAW_RELOAD_SPEED_MULTIPLIER = builder
                .comment("换弹速度加成系数（%）")
                .comment("Reload speed bonus coefficient (%)")
                .defineInRange("reloadSpeedMultiplier", 0.5, 0.1, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        OUTLAW_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        OUTLAW_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        OUTLAW_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        OUTLAW_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("速射瞄准").push("Snapshot Sights");
        SNAPSHOT_SIGHTS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SNAPSHOT_SIGHTS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        SNAPSHOT_SIGHTS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        SNAPSHOT_SIGHTS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        SNAPSHOT_SIGHTS_AIM_SPEED_BONUS = builder
                .comment("瞄准速度加成系数（%）")
                .comment("Aim speed bonus coefficient (%)")
                .defineInRange("aimSpeedBonus", 1.5, 0.1, 2.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SNAPSHOT_SIGHTS_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SNAPSHOT_SIGHTS_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SNAPSHOT_SIGHTS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SNAPSHOT_SIGHTS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("稳若磐石").push("Firmly Planted");
        FIRMLY_PLANTED_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        FIRMLY_PLANTED_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        FIRMLY_PLANTED_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        FIRMLY_PLANTED_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        FIRMLY_PLANTED_SPREAD_REDUCTION = builder
                .comment("瞄准速度加成系数（%）")
                .comment("Aim speed bonus coefficient (%)")
                .defineInRange("spreadReduction", 0.25, 0.01, 1.0);
        FIRMLY_PLANTED_RECOIL_REDUCTION = builder
                .comment(
                        "垂直后坐力减少（%）",
                        "推荐值：≤ 0.3，太高会导致枪口下移"
                )
                .comment(
                        "Vertical Recoil Reduction (%)",
                        "Recommended value: ≤ 0.3. Too high a value will cause the muzzle to move downward."
                )
                .defineInRange("recoilReduction", 0.15, 0.01, 0.5);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        FIRMLY_PLANTED_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        FIRMLY_PLANTED_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        FIRMLY_PLANTED_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        FIRMLY_PLANTED_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("柔缓").push("Adagio");
        ADAGIO_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        ADAGIO_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        ADAGIO_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        ADAGIO_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        ADAGIO_DURATION = builder
                .comment("激活后的持续时间（tick）")
                .comment("Duration After Activation (tick)")
                .defineInRange("duration", 100, 20, Integer.MAX_VALUE);
        ADAGIO_BONUS_DAMAGE = builder
                .comment("每级额外伤害系数（%）")
                .comment("Extra damage coefficient per level (%)")
                .defineInRange("bonusDamage", 0.30, 0.01, 1.0);
        ADAGIO_FIRE_RATE_SLOWDOWN = builder
                .comment("每级射速减慢系数（%）")
                .comment("Fire rate slowdown coefficient per level (%)")
                .defineInRange("fireRateSlowdown", 0.50, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        ADAGIO_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        ADAGIO_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ADAGIO_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        ADAGIO_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("猛攻").push("Onslaught");
        ONSLAUGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        ONSLAUGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        ONSLAUGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        ONSLAUGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        ONSLAUGHT_DURATION = builder
                .comment("激活后的持续时间（tick）")
                .comment("Duration After Activation (tick)")
                .defineInRange("duration", 90, 20, Integer.MAX_VALUE);
        ONSLAUGHT_FIRE_RATE_BOOST = builder
                .comment("每级射速提升系数（%）")
                .comment("Fire rate increase coefficient per level (%)")
                .defineInRange("fireRateBoost", 0.25, 0.01, 1.0);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        ONSLAUGHT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        ONSLAUGHT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ONSLAUGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        ONSLAUGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("风暴之眼").push("Eye of Storm Eye");
        EYE_OF_STORM_EYE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        EYE_OF_STORM_EYE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 20, 1, Integer.MAX_VALUE);
        EYE_OF_STORM_EYE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        EYE_OF_STORM_EYE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        EYE_OF_STORM_EYE_ACCURACY_BONUS = builder
                .comment("瞄准精度提升系数（%）")
                .comment("Aim accuracy improvement coefficient (%)")
                .defineInRange("accuracyBonus", 0.40, 0.01, 1.0);
        EYE_OF_STORM_EYE_RECOIL_REDUCTION = builder
                .comment("水平后坐力减少系数（%）")
                .comment("Horizontal recoil reduction coefficient (%)")
                .defineInRange("recoilReduction", 0.05, 0.01, 0.5);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        EYE_OF_STORM_EYE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        EYE_OF_STORM_EYE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        EYE_OF_STORM_EYE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        EYE_OF_STORM_EYE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("测距仪").push("Rangefinder");
        RANGEFINDER_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        RANGEFINDER_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        RANGEFINDER_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 10, 1, Integer.MAX_VALUE);
        RANGEFINDER_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 30, 1, Integer.MAX_VALUE);
        RANGEFINDER_ADS_RANGE_BONUS = builder
                .comment("每级优势射程提升系数（%）")
                .comment("Effective range increase coefficient per level (%)")
                .defineInRange("adsRangeBonus", 0.45, 0.0, 1.0);
        RANGEFINDER_AIM_ACCURACY_IMPROVEMENT_PER_LEVEL = builder
                .comment("每级瞄准精度提升系数（%）")
                .comment("Aim accuracy improvement coefficient per level (%)")
                .defineInRange("aimAccuracyImprovementPerLevel", 0.15, 0.01, 1.0);
        RANGEFINDER_RECOIL_REDUCTION_PER_LEVEL = builder
                .comment("每级垂直后坐力减少因子（最终倍率）")
                .comment("Vertical recoil reduction factor per level (Final Multiplier)")
                .defineInRange("recoilReductionPerLevel", 0.9, 0.5, 0.9);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        RANGEFINDER_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        RANGEFINDER_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        RANGEFINDER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        RANGEFINDER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("切勿靠近").push("Keep Away");
        KEEP_AWAY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        KEEP_AWAY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        KEEP_AWAY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        KEEP_AWAY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        KEEP_AWAY_EFFECTIVE_RANGE_BONUS = builder
                .comment("基础优势射程提升系数（%）")
                .comment("Base effective range improvement coefficient (%)")
                .defineInRange("effectiveRangeBonus", 0.25, 0.0, 1.0);
        KEEP_AWAY_EXTRA_RANGE_BONUS_PER_LEVEL = builder
                .comment("每级优势射程提升系数（%）")
                .comment("Effective range improvement coefficient per level (%)")
                .defineInRange("extraRangeBonusPerLevel", 0.05, 0.0, 1.0);
        KEEP_AWAY_AIM_ACCURACY_BONUS = builder
                .comment("基础瞄准精度加成系数（%）")
                .comment("Base aim accuracy bonus coefficient (%)")
                .defineInRange("aimAccuracyBonus", 0.05, 0.0, 1.0);
        KEEP_AWAY_EXTRA_ACCURACY_BONUS_PER_LEVEL = builder
                .comment("每级瞄准精度加成系数（%）")
                .comment("Aim accuracy bonus coefficient per level (%)")
                .defineInRange("extraAccuracyBonusPerLevel", 0.05, 0.0, 1.0);
        KEEP_AWAY_DETECTION_RADIUS = builder
                .comment("敌对生物检测半径（格）")
                .comment("Hostile mob detection radius (blocks)")
                .defineInRange("detectionRadius", 7.0, 1.0, 16.0);
        KEEP_AWAY_SHOW_PARTICLES = builder
                .comment("是否显示生效时的圆形粒子")
                .comment("Show circular particles when effect is active.")
                .define("showParticles", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        KEEP_AWAY_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        KEEP_AWAY_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        KEEP_AWAY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        KEEP_AWAY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.comment("其他类").push("Other Category");
        builder.comment("羸弱能量球").push("Attrition Orbs");
        ATTRITION_ORBS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        ATTRITION_ORBS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 10, 1, Integer.MAX_VALUE);
        ATTRITION_ORBS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        ATTRITION_ORBS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        ATTRITION_ORBS_BASE_PERCENTAGE = builder
                .comment("基础射击系数（%）")
                .comment("Base shot coefficient (%)")
                .defineInRange("basePercentage", 0.67, 0.1, 1.0);
        ATTRITION_ORBS_PERCENTAGE_REDUCTION_PER_LEVEL = builder
                .comment("每级减少的射击系数（%）")
                .comment("Shot coefficient reduction per level (%)")
                .defineInRange("percentageReductionPerLevel", 0.05, 0.0, 1.0);
        ATTRITION_ORBS_MIN_ORBS = builder
                .comment("生成的最小经验球数量")
                .comment("Minimum number of experience orbs spawned")
                .defineInRange("minOrbs", 1, 1, Integer.MAX_VALUE);
        ATTRITION_ORBS_MAX_ORBS = builder
                .comment("生成的最大经验球数量")
                .comment("Maximum number of experience orbs spawned")
                .defineInRange("maxOrbs", 3, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        ATTRITION_ORBS_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        ATTRITION_ORBS_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ATTRITION_ORBS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        ATTRITION_ORBS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("泉源").push("Wellspring");
        WELLSPRING_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        WELLSPRING_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 15, 1, Integer.MAX_VALUE);
        WELLSPRING_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 9, 1, Integer.MAX_VALUE);
        WELLSPRING_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 50, 1, Integer.MAX_VALUE);
        WELLSPRING_MIN_EXP = builder
                .comment("每次击杀产生的最小经验值")
                .comment("Minimum experience per kill")
                .defineInRange("minExp", 1, 1, Integer.MAX_VALUE);
        WELLSPRING_MAX_EXP = builder
                .comment("每次击杀产生的最大经验值")
                .comment("Maximum experience per kill")
                .defineInRange("maxExp", 5, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        WELLSPRING_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        WELLSPRING_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        WELLSPRING_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        WELLSPRING_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("冷却饰物").push("Cooling Baubles");
        COOLING_BAUBLES_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 3, 1, 5);
        COOLING_BAUBLES_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 10, 1, Integer.MAX_VALUE);
        COOLING_BAUBLES_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        COOLING_BAUBLES_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        COOLING_BAUBLES_COOL_CHANCE = builder
                .comment("降低热量的概率（%）")
                .comment("Chance to reduce heat (%)")
                .defineInRange("coolChance", 1.0, 0.0, 1.0);
        COOLING_BAUBLES_HEAT_REDUCTION = builder
                .comment("降低热量的系数（%）")
                .comment("Heat reduction coefficient (%)")
                .defineInRange("heatReduction", 0.35, 0.0, 1.0);
        COOLING_BAUBLES_COOLDOWN_TICKS = builder
                .comment("冷却时间（tick）")
                .comment("Cooldown time (tick)")
                .defineInRange("cooldownTicks", 60, 1, Integer.MAX_VALUE);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        COOLING_BAUBLES_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        COOLING_BAUBLES_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        COOLING_BAUBLES_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        COOLING_BAUBLES_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.comment("边打边劫").push("Shoot Tp Loot");
        SHOOT_TP_LOOT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .comment("Maximum Enchantment Level")
                .defineInRange("maxLevel", 1, 1, 5);
        SHOOT_TP_LOOT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .comment("Base Enchantment Cost")
                .defineInRange("baseEnchantability", 10, 1, Integer.MAX_VALUE);
        SHOOT_TP_LOOT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .comment("Enchantment Cost Increment per Level")
                .defineInRange("levelEnchantability", 8, 1, Integer.MAX_VALUE);
        SHOOT_TP_LOOT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .comment("Enchantment Cost Range")
                .defineInRange("enchantabilitySpan", 25, 1, Integer.MAX_VALUE);
        SHOOT_TP_LOOT_PICKUP_CHANCE = builder
                .comment("子弹击中物品时拾取的概率（%）")
                .comment("Chance to pick up item when bullet hits (%)")
                .defineInRange("pickupChance", 1.0, 0.0, 1.0);
        SHOOT_TP_LOOT_PICKUP_RANGE = builder
                .comment("拾取范围（格）")
                .comment("Pickup range (block)")
                .defineInRange("pickupRange", 0.5, 0.25, 16.0);
        SHOOT_TP_LOOT_CAN_PICKUP_XP_ORB = builder
                .comment("是否可以拾取经验球")
                .comment("Whether experience orbs can be picked up")
                .define("canPickupXpOrb", true);
        SHOOT_TP_LOOT_LIMIT_ONE_ITEM_TYPE = builder
                .comment("是否限制每次只拾取一种物品（数量不限）")
                .comment("Whether to limit picking up only one type of item at a time (unlimited quantity)")
                .define("limitOneItemType", true);
        builder.comment("黑名单 & 白名单").push("Whitelist & Blacklist");
        SHOOT_TP_LOOT_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapons (true = whitelist, false = blacklist)")
                .define("weaponWhitelistMode", false);
        SHOOT_TP_LOOT_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表 (如: tacz:scar_l, tacz:hk416, tacz:awp)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Firearm ID list (e.g. tacz:scar_l, tacz:hk416, tacz:awp)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SHOOT_TP_LOOT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true = 白名单，false = 黑名单）")
                .comment("Whether to use whitelist mode for weapon types (true = whitelist, false = blacklist)")
                .define("weaponTypeWhitelistMode", false);
        SHOOT_TP_LOOT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表 (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "空列表时：白名单 = 全部禁用，黑名单 = 全部允许"
                )
                .comment(
                        "Weapon type list (pistol, smg, rifle, sniper, shotgun, rpg, mg)",
                        "Empty list: Whitelist = all disabled, Blacklist = all allowed"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();






//        builder.push("=").comment("=".repeat(40));
        SPEC = builder.build();
    }
}