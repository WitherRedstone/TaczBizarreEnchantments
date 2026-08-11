package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.List;

public class TBZServerConfig {

    // ========== 通用设置 ==========
    public static ForgeConfigSpec.IntValue MAX_ENCHANTMENTS_PER_GUN;

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
    public static ForgeConfigSpec.DoubleValue SWASHBUCKLER_DECREASE_INTERVAL_SECONDS;
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
    public static ForgeConfigSpec.DoubleValue ONE_FOR_ALL_DURATION_SECONDS;
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
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_STACK_1_DURATION_SECONDS;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_STACK_2_DAMAGE_BONUS;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_STACK_2_DURATION_SECONDS;
    public static ForgeConfigSpec.BooleanValue MASTER_OF_ARMS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MASTER_OF_ARMS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue MASTER_OF_ARMS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> MASTER_OF_ARMS_APPLICABLE_WEAPON_TYPES;

    // ========== 聚合充能 ==========
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue AGGREGATE_CHARGE_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue AGGREGATE_CHARGE_DAMAGE_BONUS_PER_DEBUFF;
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
    public static ForgeConfigSpec.IntValue SUBSISTENCE_BASE_AMMO_PERCENTAGE;
    public static ForgeConfigSpec.IntValue SUBSISTENCE_AMMO_PERCENTAGE_PER_LEVEL;
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
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_BASE_OVERFILL;
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_OVERFILL_PER_KILL;
    public static ForgeConfigSpec.IntValue AMBITIOUS_ASSASSIN_MAX_OVERFILL;
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
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_AMMO_PER_RELOAD;
    public static ForgeConfigSpec.IntValue RECONSTRUCTION_SHOOT_COOLDOWN;
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
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_TIMEOUT_SECONDS;
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
    public static ForgeConfigSpec.DoubleValue SUPERCHARGED_MAGAZINE_RELOAD_INTERVAL;
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
    public static ForgeConfigSpec.DoubleValue REVERSAL_OF_FORTUNE_MISS_TIMEOUT;
    public static ForgeConfigSpec.DoubleValue REVERSAL_OF_FORTUNE_COOLDOWN;
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
    public static ForgeConfigSpec.IntValue CHILL_CLIP_FROSTBITE_DURATION;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_FROSTBITE_MIN_AMPLIFIER;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_FROSTBITE_MAX_AMPLIFIER;
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
    public static ForgeConfigSpec.BooleanValue DRAGONFLY_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DRAGONFLY_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> DRAGONFLY_APPLICABLE_WEAPON_TYPES;

    // ========== 巨脉蜻蜓 ==========
    public static ForgeConfigSpec.IntValue MEGANEURA_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MEGANEURA_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue MEGANEURA_MAX_LEVEL;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_BASE_DAMAGE;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_SPLASH_MIN;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_SPLASH_MAX;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_RANGE;
    public static ForgeConfigSpec.IntValue MEGANEURA_HEADSHOT_THRESHOLD;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_DAMAGE_BONUS_PER_THRESHOLD;
    public static ForgeConfigSpec.DoubleValue MEGANEURA_MAX_DAMAGE_BONUS;
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
    public static ForgeConfigSpec.DoubleValue ADAGIO_DURATION;
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
    public static ForgeConfigSpec.DoubleValue ONSLAUGHT_DURATION;
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

        builder.push("General");
        builder.comment("通用设置");
        MAX_ENCHANTMENTS_PER_GUN = builder
                .comment("每把枪械最多可以附魔的TBZ附魔数量")
                .defineInRange("maxEnchantmentsPerGun", 2, 1, 5);
        builder.pop();


        builder.push("Exotic");
        builder.comment("[异域]类型附魔");

        builder.push("Protective Weave");
        builder.comment("防护编织");
        PROTECTIVE_WEAVE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        PROTECTIVE_WEAVE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        PROTECTIVE_WEAVE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        PROTECTIVE_WEAVE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        PROTECTIVE_WEAVE_DAMAGE_BONUS = builder
                .comment("拥有织造铠甲时的伤害加成（0.0-1.0，0.15表示15%）")
                .defineInRange("damageBonus", 0.15, 0.0, 1.0);
        PROTECTIVE_WEAVE_WOVEN_MAIL_DURATION = builder
                .comment("没有织造铠甲时给予的持续时间（tick）")
                .defineInRange("wovenMailDuration", 200, 50, 600);
        PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER = builder
                .comment("没有织造铠甲时给予的等级")
                .defineInRange("wovenMailAmplifier", 0, 0, 2);
        PROTECTIVE_WEAVE_COOLDOWN_TICKS = builder
                .comment("没有织造铠甲时给予效果的冷却时间（tick）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        PROTECTIVE_WEAVE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        PROTECTIVE_WEAVE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        PROTECTIVE_WEAVE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        PROTECTIVE_WEAVE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PROTECTIVE_WEAVE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        PROTECTIVE_WEAVE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Reign Havoc");
        builder.comment("统治浩劫");
        REIGN_HAVOC_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        REIGN_HAVOC_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 10, 1, 100);
        REIGN_HAVOC_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        REIGN_HAVOC_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        REIGN_HAVOC_REQUIRED_HEADSHOTS = builder
                .comment("触发闪电打击所需的连续爆头次数")
                .defineInRange("requiredHeadshots", 10, 1, 30);
        REIGN_HAVOC_LIGHTNING_DAMAGE = builder
                .comment("闪电打击造成的伤害")
                .defineInRange("lightningDamage", 5.0, 0.0, 20.0);
        REIGN_HAVOC_REFILL_PERCENTAGE = builder
                .comment("闪电打击时弹匣填装百分比")
                .defineInRange("refillPercentage", 0.10, 0.0, 1.0);
        REIGN_HAVOC_FIRE_DAMAGE = builder
                .comment("闪电打击是否造成火焰伤害")
                .define("fireDamage", false);
        builder.push("Whitelist & Blacklist");
        REIGN_HAVOC_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        REIGN_HAVOC_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        REIGN_HAVOC_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", true);
        REIGN_HAVOC_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Suros Legacy");
        builder.comment("SUROS遗产");
        SUROS_LEGACY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        SUROS_LEGACY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        SUROS_LEGACY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        SUROS_LEGACY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        SUROS_LEGACY_DAMAGE_BONUS = builder
                .comment("弹匣后半子弹造成的额外伤害比例（0.05 = 5%）")
                .defineInRange("damageBonus", 0.05, 0.0, 1.0);
        SUROS_LEGACY_CURE_CHANCE = builder
                .comment("击杀时触发治愈效果的概率（0.33 = 33%）")
                .defineInRange("cureChance", 0.33, 0.0, 1.0);
        builder.push("Whitelist & Blacklist");
        SUROS_LEGACY_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SUROS_LEGACY_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SUROS_LEGACY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SUROS_LEGACY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Primevals Torment");
        builder.comment("古昧的折磨");
        PRIMEVALS_TORMENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        PRIMEVALS_TORMENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        PRIMEVALS_TORMENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        PRIMEVALS_TORMENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        PRIMEVALS_TORMENT_TRIGGER_CHANCE = builder
                .comment("触发概率（0.0-1.0，1.0表示100%）")
                .defineInRange("triggerChance", 1.0, 0.0, 1.0);
        PRIMEVALS_TORMENT_RANGE = builder
                .comment("范围影响半径（格）")
                .defineInRange("range", 3.0, 1.0, 10.0);
        PRIMEVALS_TORMENT_EFFECT_DURATION = builder
                .comment("凋零效果持续时间（秒）")
                .defineInRange("effectDuration", 10, 1, 60);
        PRIMEVALS_TORMENT_EFFECT_LEVEL = builder
                .comment("凋零效果等级（1-5）")
                .defineInRange("effectLevel", 2, 1, 5);
        PRIMEVALS_TORMENT_SHOW_PARTICLES = builder
                .comment("是否显示圆形粒子效果（true=显示，false=不显示）")
                .define("showParticles", true);
        builder.push("Whitelist & Blacklist");
        PRIMEVALS_TORMENT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        PRIMEVALS_TORMENT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PRIMEVALS_TORMENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", true);
        PRIMEVALS_TORMENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Full Stop");
        builder.comment("到此为止");
        FULL_STOP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        FULL_STOP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        FULL_STOP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        FULL_STOP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        FULL_STOP_HEADSHOT_MULTIPLIER = builder
                .comment("爆头伤害倍率（3.0表示3倍伤害）")
                .defineInRange("headshotMultiplier", 3.0, 1.0, 10.0);
        builder.push("Whitelist & Blacklist");
        FULL_STOP_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        FULL_STOP_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        FULL_STOP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        FULL_STOP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Creeping Attrition");
        builder.comment("蔓延羸弱");
        CREEPING_ATTRITION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        CREEPING_ATTRITION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        CREEPING_ATTRITION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        CREEPING_ATTRITION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        CREEPING_ATTRITION_REQUIRED_HEADSHOTS = builder
                .comment("触发所需的爆头命中次数")
                .defineInRange("requiredHeadshots", 5, 1, 10);
        CREEPING_ATTRITION_TIME_WINDOW = builder
                .comment("有效时间窗口（tick，20tick=1秒）")
                .defineInRange("timeWindow", 60, 20, 300);
        CREEPING_ATTRITION_SLOW_DURATION = builder
                .comment("减速效果持续时间（tick，20tick=1秒）")
                .defineInRange("slowDuration", 160, 20, 300);
        CREEPING_ATTRITION_SLOW_LEVEL = builder
                .comment("减速效果等级（1-5）")
                .defineInRange("slowLevel", 1, 1, 5);
        builder.push("Whitelist & Blacklist");
        CREEPING_ATTRITION_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        CREEPING_ATTRITION_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        CREEPING_ATTRITION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        CREEPING_ATTRITION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "smg", "rifle", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Touch of Malice");
        builder.comment("恶意触碰");
        TOUCH_OF_MALICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        TOUCH_OF_MALICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        TOUCH_OF_MALICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        TOUCH_OF_MALICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        TOUCH_OF_MALICE_DAMAGE_BONUS_PER_HEART = builder
                .comment("每颗心提供的额外伤害百分比（0.05表示5%）")
                .defineInRange("damageBonusPerHeart", 0.05, 0.01, 0.5);
        builder.push("Whitelist & Blacklist");
        TOUCH_OF_MALICE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        TOUCH_OF_MALICE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        TOUCH_OF_MALICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TOUCH_OF_MALICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("The Right Choice");
        builder.comment("正确抉择");
        THE_RIGHT_CHOICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        THE_RIGHT_CHOICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        THE_RIGHT_CHOICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        THE_RIGHT_CHOICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        THE_RIGHT_CHOICE_TRIGGER_INTERVAL = builder
                .comment("触发间隔（射击次数，默认7）")
                .defineInRange("triggerInterval", 7, 1, 20);
        THE_RIGHT_CHOICE_RANGE = builder
                .comment("弹射范围（格）")
                .defineInRange("range", 5.0, 1.0, 20.0);
        THE_RIGHT_CHOICE_SHOW_PARTICLES = builder
                .comment("是否显示圆形粒子效果（true=显示，false=不显示）")
                .define("showParticles", true);
        builder.push("Whitelist & Blacklist");
        THE_RIGHT_CHOICE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        THE_RIGHT_CHOICE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        THE_RIGHT_CHOICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        THE_RIGHT_CHOICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Vexadecimal");
        builder.comment("十六进制");
        VEXADECIMAL_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        VEXADECIMAL_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        VEXADECIMAL_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        VEXADECIMAL_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        VEXADECIMAL_WEAKNESS_DURATION = builder
                .comment("虚弱效果持续时间（秒）")
                .defineInRange("weaknessDuration", 5, 1, 60);
        VEXADECIMAL_WEAKNESS_LEVEL = builder
                .comment("虚弱效果等级（1-5）")
                .defineInRange("weaknessLevel", 1, 1, 5);
        VEXADECIMAL_EXTRA_DAMAGE_PERCENT = builder
                .comment("额外伤害百分比（0.33表示33%）")
                .defineInRange("extraDamagePercent", 0.33, 0.1, 2.0);
        builder.push("Whitelist & Blacklist");
        VEXADECIMAL_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        VEXADECIMAL_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        VEXADECIMAL_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        VEXADECIMAL_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Personal Assistant");
        builder.comment("私人助手");
        PERSONAL_ASSISTANT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        PERSONAL_ASSISTANT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        PERSONAL_ASSISTANT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        PERSONAL_ASSISTANT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        PERSONAL_ASSISTANT_JOLT_DURATION = builder
                .comment("震颤效果持续时间（秒）")
                .defineInRange("joltDuration", 1, 1, 10);
        PERSONAL_ASSISTANT_JOLT_LEVEL = builder
                .comment("震颤效果等级（1-5）")
                .defineInRange("joltLevel", 1, 1, 5);
        builder.push("Whitelist & Blacklist");
        PERSONAL_ASSISTANT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        PERSONAL_ASSISTANT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PERSONAL_ASSISTANT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        PERSONAL_ASSISTANT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Bonus Damage");
        builder.comment("[增伤]类型附魔");

        builder.push("Borpal Weapon");
        builder.comment("斩首武器");
        BORPAL_WEAPON_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        BORPAL_WEAPON_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 4, 1, 100);
        BORPAL_WEAPON_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        BORPAL_WEAPON_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 12, 1, 100);
        BORPAL_WEAPON_BOSS_DAMAGE_BONUS = builder
                .comment("每级对Boss的伤害加成百分比")
                .defineInRange("bossDamageBonus", 0.1, 0.0, 10.0);
        builder.push("Whitelist & Blacklist");
        BORPAL_WEAPON_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        BORPAL_WEAPON_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Precision Instrument");
        builder.comment("精准工具");
        PRECISION_INSTRUMENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        PRECISION_INSTRUMENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        PRECISION_INSTRUMENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        PRECISION_INSTRUMENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        PRECISION_INSTRUMENT_FIRE_PERCENTAGE = builder
                .comment("触发所需的射击百分比（0.0-1.0，0.15表示15%）")
                .defineInRange("firePercentage", 0.15, 0.05, 1.0);
        PRECISION_INSTRUMENT_MULTIPLIER_BONUS = builder
                .comment("每次触发的爆头倍率加成（0.0-1.0，0.1表示10%）")
                .defineInRange("multiplierBonus", 0.1, 0.01, 1.0);
        builder.push("Whitelist & Blacklist");
        PRECISION_INSTRUMENT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        PRECISION_INSTRUMENT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Target Lock");
        builder.comment("目标锁定");
        TARGET_LOCK_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        TARGET_LOCK_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        TARGET_LOCK_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        TARGET_LOCK_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        TARGET_LOCK_DAMAGE_BONUS_PER_STACK = builder
                .comment("每层伤害加成（0.12表示12%）")
                .defineInRange("damageBonusPerStack", 0.12, 0.01, 0.5);
        TARGET_LOCK_MAX_STACKS = builder
                .comment("最大伤害加成层数")
                .defineInRange("maxStacks", 5, 1, 20);
        TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT = builder
                .comment("需要射击弹夹的百分比来触发加成（0.15表示15%）")
                .defineInRange("requiredMagazinePercent", 0.15, 0.01, 0.5);
        builder.push("Whitelist & Blacklist");
        TARGET_LOCK_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        TARGET_LOCK_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TARGET_LOCK_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Gutshot Straight");
        builder.comment("直击要害");
        GUTSHOT_STRAIGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        GUTSHOT_STRAIGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        GUTSHOT_STRAIGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        GUTSHOT_STRAIGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        GUTSHOT_STRAIGHT_DAMAGE_BONUS = builder
                .comment("伤害加成（0.0-1.0，0.15表示15%）")
                .defineInRange("damageBonus", 0.15, 0.1, 1.0);
        builder.push("Whitelist & Blacklist");
        GUTSHOT_STRAIGHT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        GUTSHOT_STRAIGHT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        GUTSHOT_STRAIGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        GUTSHOT_STRAIGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Thermal Atomization");
        builder.comment("热能雾化");
        THERMAL_ATOMIZATION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        THERMAL_ATOMIZATION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        THERMAL_ATOMIZATION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        THERMAL_ATOMIZATION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        THERMAL_ATOMIZATION_DAMAGE_BONUS = builder
                .comment("热量高于50%时的增伤百分比")
                .defineInRange("damageBonus", 0.25, 0.0, 2.0);
        THERMAL_ATOMIZATION_EXPLOSION_MIN_DAMAGE = builder
                .comment("击杀爆炸最小伤害")
                .defineInRange("explosionMinDamage", 1.0, 0.0, 10.0);
        THERMAL_ATOMIZATION_EXPLOSION_MAX_DAMAGE = builder
                .comment("击杀爆炸最大伤害")
                .defineInRange("explosionMaxDamage", 3.0, 0.0, 10.0);
        THERMAL_ATOMIZATION_EXPLOSION_RANGE = builder
                .comment("击杀爆炸范围（格）")
                .defineInRange("explosionRange", 1.5, 0.0, 5.0);
        THERMAL_ATOMIZATION_SHOW_PARTICLES = builder
                .comment("是否显示圆形粒子效果（true=显示，false=不显示）")
                .define("showParticles", true);
        builder.push("Whitelist & Blacklist");
        THERMAL_ATOMIZATION_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", true);
        THERMAL_ATOMIZATION_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        THERMAL_ATOMIZATION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", true);
        THERMAL_ATOMIZATION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Swashbuckler");
        builder.comment("斗剑士");
        SWASHBUCKLER_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        SWASHBUCKLER_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        SWASHBUCKLER_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本")
                .defineInRange("levelEnchantability", 10, 1, 100);
        SWASHBUCKLER_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        SWASHBUCKLER_MAX_STACKS = builder
                .comment("最大层数")
                .defineInRange("maxStacks", 5, 1, 20);
        SWASHBUCKLER_DECREASE_INTERVAL_SECONDS = builder
                .comment("层数降低间隔（秒）")
                .defineInRange("decreaseIntervalSeconds", 4.5, 0.5, 10.0);
        builder.push("Whitelist & Blacklist");
        SWASHBUCKLER_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SWASHBUCKLER_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SWASHBUCKLER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SWASHBUCKLER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("One For All");
        builder.comment("我为人人");
        ONE_FOR_ALL_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        ONE_FOR_ALL_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        ONE_FOR_ALL_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本")
                .defineInRange("levelEnchantability", 10, 1, 100);
        ONE_FOR_ALL_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        ONE_FOR_ALL_DAMAGE_BONUS = builder
                .comment("伤害加成（百分比，如0.2表示20%）")
                .defineInRange("damageBonus", 0.2, 0.0, 1.0);
        ONE_FOR_ALL_DURATION_SECONDS = builder
                .comment("效果持续时间（秒）")
                .defineInRange("durationSeconds", 6.0, 1.0, 30.0);
        ONE_FOR_ALL_REQUIRED_HITS = builder
                .comment("需要命中的不同目标数量")
                .defineInRange("requiredHits", 3, 2, 10);
        builder.push("Whitelist & Blacklist");
        ONE_FOR_ALL_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        ONE_FOR_ALL_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        ONE_FOR_ALL_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ONE_FOR_ALL_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Master of Arms");
        builder.comment("武器大师");
        MASTER_OF_ARMS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        MASTER_OF_ARMS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        MASTER_OF_ARMS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        MASTER_OF_ARMS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 35, 1, 100);
        MASTER_OF_ARMS_STACK_1_DAMAGE_BONUS = builder
                .comment("武器大师x1的伤害加成（0.0-1.0，0.15表示15%）")
                .defineInRange("stack1DamageBonus", 0.15, 0.0, 1.0);
        MASTER_OF_ARMS_STACK_1_DURATION_SECONDS = builder
                .comment("武器大师x1的持续时间（秒）")
                .defineInRange("stack1DurationSeconds", 7.0, 1.0, 30.0);
        MASTER_OF_ARMS_STACK_2_DAMAGE_BONUS = builder
                .comment("武器大师x2的伤害加成（0.0-1.0，0.25表示25%）")
                .defineInRange("stack2DamageBonus", 0.25, 0.0, 1.0);
        MASTER_OF_ARMS_STACK_2_DURATION_SECONDS = builder
                .comment("武器大师x2的持续时间（秒）")
                .defineInRange("stack2DurationSeconds", 4.0, 1.0, 30.0);
        builder.push("Whitelist & Blacklist");
        MASTER_OF_ARMS_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        MASTER_OF_ARMS_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        MASTER_OF_ARMS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        MASTER_OF_ARMS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Aggregate Charge");
        builder.comment("聚合充能");
        AGGREGATE_CHARGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        AGGREGATE_CHARGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        AGGREGATE_CHARGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        AGGREGATE_CHARGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        AGGREGATE_CHARGE_DAMAGE_BONUS_PER_DEBUFF = builder
                .comment("每个负面效果增加的伤害百分比（0.1表示10%）")
                .defineInRange("damageBonusPerDebuff", 0.1, 0.01, 1.0);
        builder.push("Whitelist & Blacklist");
        AGGREGATE_CHARGE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        AGGREGATE_CHARGE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        AGGREGATE_CHARGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        AGGREGATE_CHARGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Firing Line");
        builder.comment("火线");
        FIRING_LINE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        FIRING_LINE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        FIRING_LINE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        FIRING_LINE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        FIRING_LINE_RADIUS = builder
                .comment("检测半径（格）")
                .defineInRange("radius", 4.0, 1.0, 16.0);
        FIRING_LINE_REQUIRED_PLAYERS = builder
                .comment("所需玩家数量")
                .defineInRange("requiredPlayers", 2, 2, 10);
        FIRING_LINE_DAMAGE_BONUS = builder
                .comment("伤害加成百分比（0.35表示35%）")
                .defineInRange("damageBonus", 0.35, 0.05, 1.0);
        FIRING_LINE_EXCLUDE_SELF = builder
                .comment("是否排除玩家自己（true=排除自己，false=包括自己）")
                .define("excludeSelf", true);
        FIRING_LINE_SHOW_PARTICLES = builder
                .comment("是否显示圆形粒子效果（true=显示，false=不显示）")
                .define("showParticles", true);
        builder.push("Whitelist & Blacklist");
        FIRING_LINE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        FIRING_LINE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        FIRING_LINE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        FIRING_LINE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Box Breathing");
        builder.comment("盒式呼吸法");
        BOX_BREATHING_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        BOX_BREATHING_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        BOX_BREATHING_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        BOX_BREATHING_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        BOX_BREATHING_DAMAGE_BONUS = builder
                .comment("伤害加成（0.4 = 40%伤害提升）")
                .defineInRange("damageBonus", 0.4, 0.1, 2.0);
        builder.push("Whitelist & Blacklist");
        BOX_BREATHING_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        BOX_BREATHING_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BOX_BREATHING_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        BOX_BREATHING_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Explosive Light");
        builder.comment("爆炸光能");
        EXPLOSIVE_LIGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        EXPLOSIVE_LIGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        EXPLOSIVE_LIGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        EXPLOSIVE_LIGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        EXPLOSIVE_LIGHT_DAMAGE_BONUS = builder
                .comment("每层伤害加成（0.35 = 35%伤害提升）")
                .defineInRange("damageBonus", 0.35, 0.1, 2.0);
        EXPLOSIVE_LIGHT_XP_PER_STACK = builder
                .comment("每层所需经验值")
                .defineInRange("xpPerStack", 25, 5, 100);
        EXPLOSIVE_LIGHT_MAX_STACKS = builder
                .comment("最大层数")
                .defineInRange("maxStacks", 6, 1, 10);
        builder.push("Whitelist & Blacklist");
        EXPLOSIVE_LIGHT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        EXPLOSIVE_LIGHT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        EXPLOSIVE_LIGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        EXPLOSIVE_LIGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rpg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Bonus Bullet");
        builder.comment("[回子弹]类型附魔");

        builder.push("Subsistence");
        builder.comment("维持生计");
        SUBSISTENCE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        SUBSISTENCE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 10, 1, 100);
        SUBSISTENCE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        SUBSISTENCE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        SUBSISTENCE_BASE_AMMO_PERCENTAGE = builder
                .comment("基础弹药恢复百分比")
                .defineInRange("baseAmmoPercentage", 10, 1, 100);
        SUBSISTENCE_AMMO_PERCENTAGE_PER_LEVEL = builder
                .comment("每级弹药恢复百分比增量")
                .defineInRange("ammoPercentagePerLevel", 5, 1, 100);
        SUBSISTENCE_KILL_THRESHOLD = builder
                .comment("触发弹药恢复所需的击杀次数")
                .defineInRange("killThreshold", 3, 1, 20);
        builder.push("Whitelist & Blacklist");
        SUBSISTENCE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SUBSISTENCE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SUBSISTENCE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Ambitious Assassin");
        builder.comment("刺客野心");
        AMBITIOUS_ASSASSIN_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        AMBITIOUS_ASSASSIN_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        AMBITIOUS_ASSASSIN_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        AMBITIOUS_ASSASSIN_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        AMBITIOUS_ASSASSIN_BASE_OVERFILL = builder
                .comment("基础过量填充弹药数")
                .defineInRange("baseOverfill", 3, 0, 30);
        AMBITIOUS_ASSASSIN_OVERFILL_PER_KILL = builder
                .comment("每次击杀增加的过量填充弹药数")
                .defineInRange("overfillPerKill", 3, 0, 12);
        AMBITIOUS_ASSASSIN_MAX_OVERFILL = builder
                .comment("最大过量填充弹药数")
                .defineInRange("maxOverfill", 60, 1, 240);
        builder.push("Whitelist & Blacklist");
        AMBITIOUS_ASSASSIN_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        AMBITIOUS_ASSASSIN_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Reconstruction");
        builder.comment("重建");
        RECONSTRUCTION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        RECONSTRUCTION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        RECONSTRUCTION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        RECONSTRUCTION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        RECONSTRUCTION_RELOAD_INTERVAL = builder
                .comment("自动填装间隔（tick）")
                .defineInRange("reloadInterval", 50, 10, 200);
        RECONSTRUCTION_AMMO_PER_RELOAD = builder
                .comment("每次填装的弹药数")
                .defineInRange("ammoPerReload", 3, 1, 10);
        RECONSTRUCTION_SHOOT_COOLDOWN = builder
                .comment("开枪后冷却时间（tick）")
                .defineInRange("shootCooldown", 120, 20, 300);
        builder.push("Whitelist & Blacklist");
        RECONSTRUCTION_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        RECONSTRUCTION_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        RECONSTRUCTION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Triple Tap");
        builder.comment("精准连击");
        TRIPLE_TAP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        TRIPLE_TAP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        TRIPLE_TAP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        TRIPLE_TAP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        TRIPLE_TAP_HIT_COUNT = builder
                .comment("触发所需的精准命中次数")
                .defineInRange("hitCount", 3, 2, 10);
        TRIPLE_TAP_TIME_WINDOW = builder
                .comment("时间窗口（tick）")
                .defineInRange("timeWindow", 40, 20, 200);
        builder.push("Whitelist & Blacklist");
        TRIPLE_TAP_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        TRIPLE_TAP_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TRIPLE_TAP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Fourth Time The Charm");
        builder.comment("事不过四");
        FOURTH_TIME_THE_CHARM_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        FOURTH_TIME_THE_CHARM_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        FOURTH_TIME_THE_CHARM_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        FOURTH_TIME_THE_CHARM_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        FOURTH_TIME_THE_CHARM_HIT_COUNT = builder
                .comment("触发所需的精准命中次数")
                .defineInRange("hitCount", 4, 2, 10);
        FOURTH_TIME_THE_CHARM_TIME_WINDOW = builder
                .comment("时间窗口（tick）")
                .defineInRange("timeWindow", 40, 20, 200);
        FOURTH_TIME_THE_CHARM_AMMO_RETURN = builder
                .comment("返还的弹药数")
                .defineInRange("ammoReturn", 2, 1, 10);
        builder.push("Whitelist & Blacklist");
        FOURTH_TIME_THE_CHARM_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        FOURTH_TIME_THE_CHARM_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Rewind Rounds");
        builder.comment("回转弹药");
        REWIND_ROUNDS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        REWIND_ROUNDS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        REWIND_ROUNDS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        REWIND_ROUNDS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        REWIND_ROUNDS_RESTORE_PERCENTAGE = builder
                .comment("恢复弹药的百分比（0.0-1.0），恢复命中次数的百分比")
                .defineInRange("restorePercentage", 0.6, 0.1, 1.0);
        REWIND_ROUNDS_MIN_FIRE_PERCENTAGE = builder
                .comment("触发恢复所需的最小射击百分比（0.0-1.0），需要射击弹匣容量的百分比")
                .defineInRange("minFirePercentage", 0.2875, 0.1, 1.0);
        TARGET_LOCK_TIMEOUT_SECONDS = builder
                .comment("超时时间（秒），超过此时间未命中目标会重置锁定状态")
                .defineInRange("timeoutSeconds", 1.0, 0.1, 10.0);
        builder.push("Whitelist & Blacklist");
        REWIND_ROUNDS_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        REWIND_ROUNDS_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Mulligan");
        builder.comment("重新调度");
        MULLIGAN_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        MULLIGAN_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        MULLIGAN_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        MULLIGAN_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        MULLIGAN_BASE_CHANCE = builder
                .comment("基础返还概率（0.0-1.0，0.15表示15%）")
                .defineInRange("baseChance", 0.15, 0.0, 1.0);
        MULLIGAN_CHANCE_PER_LEVEL = builder
                .comment("每级增加的返还概率（0.0-1.0，0.05表示5%）")
                .defineInRange("chancePerLevel", 0.05, 0.0, 0.2);
        builder.push("Whitelist & Blacklist");
        MULLIGAN_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        MULLIGAN_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        MULLIGAN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        MULLIGAN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Trickle Charge");
        builder.comment("涓流充能");
        TRICKLE_CHARGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        TRICKLE_CHARGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        TRICKLE_CHARGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 9, 1, 100);
        TRICKLE_CHARGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        TRICKLE_CHARGE_RECEIVE_PERCENTAGE = builder
                .comment("接收电光充能时补充弹药的百分比（弹匣容量的百分比）")
                .defineInRange("receivePercentage", 0.1, 0.01, 1.0);
        TRICKLE_CHARGE_RELEASE_PERCENTAGE = builder
                .comment("释放电光充能时补充弹药的百分比（弹匣容量的百分比）")
                .defineInRange("releasePercentage", 0.2, 0.01, 1.0);
        builder.push("Whitelist & Blacklist");
        TRICKLE_CHARGE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        TRICKLE_CHARGE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表",
                        "白名单模式：只有列表中的武器可以附魔",
                        "黑名单模式：列表中的武器不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有武器，黑名单模式=允许所有武器"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        TRICKLE_CHARGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TRICKLE_CHARGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Supercharged Magazine");
        builder.comment("超充弹匣");
        SUPERCHARGED_MAGAZINE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        SUPERCHARGED_MAGAZINE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        SUPERCHARGED_MAGAZINE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 9, 1, 100);
        SUPERCHARGED_MAGAZINE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        SUPERCHARGED_MAGAZINE_RELOAD_PERCENTAGE = builder
                .comment("每次补充弹药的百分比（弹匣容量的百分比）")
                .defineInRange("reloadPercentage", 0.10, 0.01, 1.0);
        SUPERCHARGED_MAGAZINE_RELOAD_INTERVAL = builder
                .comment("补充弹药的间隔时间（秒）")
                .defineInRange("reloadInterval", 1.5, 0.1, 10.0);
        builder.push("Whitelist & Blacklist");
        SUPERCHARGED_MAGAZINE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SUPERCHARGED_MAGAZINE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表",
                        "白名单模式：只有列表中的武器可以附魔",
                        "黑名单模式：列表中的武器不可以附魔",
                        "示例: [\"timeless_and_classics_zero:ak47\", \"timeless_and_classics_zero:m4a1\"]",
                        "留空表示：白名单模式=禁止所有武器，黑名单模式=允许所有武器"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.push("WeaponType Whitelist & Blacklist");
        SUPERCHARGED_MAGAZINE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SUPERCHARGED_MAGAZINE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Reversal of Fortune");
        builder.comment("命运的逆转");
        REVERSAL_OF_FORTUNE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        REVERSAL_OF_FORTUNE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        REVERSAL_OF_FORTUNE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 9, 1, 100);
        REVERSAL_OF_FORTUNE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        REVERSAL_OF_FORTUNE_REQUIRED_MISSES = builder
                .comment("需要射偏的子弹数量")
                .defineInRange("requiredMisses", 2, 1, 10);
        REVERSAL_OF_FORTUNE_REFUND_AMOUNT = builder
                .comment("返还的弹药数量")
                .defineInRange("refundAmount", 1, 1, 5);
        REVERSAL_OF_FORTUNE_MISS_TIMEOUT = builder
                .comment("射偏超时时间（秒）")
                .defineInRange("missTimeout", 3.0, 0.5, 10.0);
        REVERSAL_OF_FORTUNE_COOLDOWN = builder
                .comment("返还冷却时间（秒）")
                .defineInRange("cooldown", 1.5, 0.1, 10.0);
        builder.push("Whitelist & Blacklist");
        REVERSAL_OF_FORTUNE_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        REVERSAL_OF_FORTUNE_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表",
                        "白名单模式：只有列表中的武器可以附魔",
                        "黑名单模式：列表中的武器不可以附魔",
                        "示例: [\"timeless_and_classics_zero:ak47\", \"timeless_and_classics_zero:m4a1\"]",
                        "留空表示：白名单模式=禁止所有武器，黑名单模式=允许所有武器"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("WeaponType Whitelist & Blacklist");
        REVERSAL_OF_FORTUNE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", true);
        REVERSAL_OF_FORTUNE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Clown Cartridge");
        builder.comment("小丑皇弹药筒");
        CLOWN_CARTRIDGE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        CLOWN_CARTRIDGE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        CLOWN_CARTRIDGE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        CLOWN_CARTRIDGE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        CLOWN_CARTRIDGE_MIN_PERCENTAGE = builder
                .comment("最小额外装填百分比（0.1表示10%）")
                .defineInRange("minPercentage", 0.1, 0.01, 1.0);
        CLOWN_CARTRIDGE_MAX_PERCENTAGE = builder
                .comment("最大额外装填百分比（0.5表示50%）")
                .defineInRange("maxPercentage", 0.5, 0.01, 1.0);
        builder.push("Whitelist & Blacklist");
        CLOWN_CARTRIDGE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        CLOWN_CARTRIDGE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        CLOWN_CARTRIDGE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        CLOWN_CARTRIDGE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "smg", "rifle", "sniper", "shotgun", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Application Effect");
        builder.comment("[应用效果]类型附魔");

        builder.push("Heal Clip");
        builder.comment("治疗弹匣");
        HEAL_CLIP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        HEAL_CLIP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        HEAL_CLIP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        HEAL_CLIP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        HEAL_CLIP_BASE_AMPLIFIER = builder
                .comment("基础效果等级")
                .defineInRange("baseAmplifier", 0, 0, 5);
        HEAL_CLIP_AMPLIFIER_PER_LEVEL = builder
                .comment("每级效果等级增量")
                .defineInRange("amplifierPerLevel", 1, 0, 3);
        builder.push("Whitelist & Blacklist");
        HEAL_CLIP_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        HEAL_CLIP_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        HEAL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Rolling Storm");
        builder.comment("风暴涌动");
        ROLLING_STORM_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        ROLLING_STORM_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        ROLLING_STORM_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        ROLLING_STORM_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        ROLLING_STORM_AMPLIFIED_DURATION = builder
                .comment("没有增幅效果时给予的持续时间（tick）")
                .defineInRange("amplifiedDuration", 300, 50, 600);
        ROLLING_STORM_AMPLIFIED_AMPLIFIER = builder
                .comment("没有增幅效果时给予的等级")
                .defineInRange("amplifiedAmplifier", 0, 0, 2);
        ROLLING_STORM_COOLDOWN_TICKS = builder
                .comment("没有增幅效果时给予效果的冷却时间（tick）")
                .defineInRange("cooldownTicks", 400, 100, 600);
        ROLLING_STORM_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        ROLLING_STORM_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        ROLLING_STORM_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        ROLLING_STORM_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ROLLING_STORM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Destabilizing Rounds");
        builder.comment("失衡弹药");
        DESTABILIZING_ROUNDS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        DESTABILIZING_ROUNDS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        DESTABILIZING_ROUNDS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        DESTABILIZING_ROUNDS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        DESTABILIZING_ROUNDS_RANGE = builder
                .comment("影响范围（半径）")
                .defineInRange("range", 3.0, 1.0, 10.0);
        DESTABILIZING_ROUNDS_VOLATILE_DURATION = builder
                .comment("没有不稳定效果时给予的持续时间（tick）")
                .defineInRange("volatileDuration", 200, 50, 600);
        DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER = builder
                .comment("没有不稳定效果时给予的等级")
                .defineInRange("volatileAmplifier", 0, 0, 2);
        DESTABILIZING_ROUNDS_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        DESTABILIZING_ROUNDS_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        DESTABILIZING_ROUNDS_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        DESTABILIZING_ROUNDS_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Incandescent");
        builder.comment("辉耀炽热");
        INCANDESCENT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        INCANDESCENT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        INCANDESCENT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        INCANDESCENT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        INCANDESCENT_RANGE = builder
                .comment("影响范围（半径）")
                .defineInRange("range", 3.0, 1.0, 10.0);
        INCANDESCENT_SCORCH_DURATION = builder
                .comment("没有灼烧效果时给予的持续时间（tick）")
                .defineInRange("scorchDuration", 200, 50, 600);
        INCANDESCENT_SCORCH_AMPLIFIER = builder
                .comment("没有灼烧效果时给予的等级")
                .defineInRange("scorchAmplifier", 0, 0, 2);
        INCANDESCENT_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        INCANDESCENT_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        INCANDESCENT_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        INCANDESCENT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        INCANDESCENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Chill Clip");
        builder.comment("冰冷弹匣");
        CHILL_CLIP_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        CHILL_CLIP_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        CHILL_CLIP_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        CHILL_CLIP_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        CHILL_CLIP_TRIGGER_CHANCE = builder
                .comment("触发概率（0.0-1.0，0.15表示15%）")
                .defineInRange("triggerChance", 0.15, 0.01, 1.0);
        CHILL_CLIP_FROSTBITE_DURATION = builder
                .comment("没有霜寒效果时给予的持续时间（tick）")
                .defineInRange("frostbiteDuration", 200, 50, 600);
        CHILL_CLIP_FROSTBITE_MIN_AMPLIFIER = builder
                .comment("没有霜寒效果时给予的最小等级")
                .defineInRange("frostbiteMinAmplifier", 0, 0, 2);
        CHILL_CLIP_FROSTBITE_MAX_AMPLIFIER = builder
                .comment("没有霜寒效果时给予的最大等级")
                .defineInRange("frostbiteMaxAmplifier", 2, 0, 2);
        CHILL_CLIP_COOLDOWN_TICKS = builder
                .comment("没有霜寒效果时给予效果的冷却时间（tick）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        CHILL_CLIP_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        CHILL_CLIP_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        CHILL_CLIP_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        CHILL_CLIP_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        CHILL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Rimestealer");
        builder.comment("霜华窃取者");
        RIMESTEALER_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        RIMESTEALER_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        RIMESTEALER_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        RIMESTEALER_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        RIMESTEALER_FROST_ARMOR_DURATION = builder
                .comment("没有冰霜护甲时给予的持续时间（tick）")
                .defineInRange("frostArmorDuration", 200, 50, 600);
        RIMESTEALER_FROST_ARMOR_AMPLIFIER = builder
                .comment("没有冰霜护甲时给予的等级")
                .defineInRange("frostArmorAmplifier", 0, 0, 2);
        RIMESTEALER_COOLDOWN_TICKS = builder
                .comment("没有冰霜护甲时给予效果的冷却时间（tick）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        RIMESTEALER_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        RIMESTEALER_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        RIMESTEALER_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        RIMESTEALER_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        RIMESTEALER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Slice");
        builder.comment("切割");
        SLICE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        SLICE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 50);
        SLICE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 20);
        SLICE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        SLICE_TRIGGER_CHANCE = builder
                .comment("触发概率（0.0-1.0，0.15表示15%）")
                .defineInRange("triggerChance", 0.15, 0.01, 1.0);
        SLICE_SEVER_DURATION = builder
                .comment("没有瓦解效果时给予的持续时间（tick）")
                .defineInRange("severDuration", 200, 50, 600);
        SLICE_SEVER_MIN_AMPLIFIER = builder
                .comment("没有瓦解效果时给予的最小等级")
                .defineInRange("severMinAmplifier", 0, 0, 2);
        SLICE_SEVER_MAX_AMPLIFIER = builder
                .comment("没有瓦解效果时给予的最大等级")
                .defineInRange("severMaxAmplifier", 2, 0, 2);
        SLICE_COOLDOWN_TICKS = builder
                .comment("没有瓦解效果时给予效果的冷却时间（tick）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        SLICE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（tick）")
                .defineInRange("extendDuration", 100, 20, 300);
        SLICE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（tick）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("Whitelist & Blacklist");
        SLICE_WHITELIST_MODE = builder
                .comment("枪械是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SLICE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        SLICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SLICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Withering Gaze");
        builder.comment("枯萎凝视");
        WITHERING_GAZE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        WITHERING_GAZE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        WITHERING_GAZE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        WITHERING_GAZE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        WITHERING_GAZE_EFFECT_DURATION = builder
                .comment("VULNERABLE效果持续时间（秒）")
                .defineInRange("effectDuration", 5, 1, 60);
        WITHERING_GAZE_EFFECT_LEVEL = builder
                .comment("VULNERABLE效果等级（1-5）")
                .defineInRange("effectLevel", 1, 1, 5);
        builder.push("Whitelist & Blacklist");
        WITHERING_GAZE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        WITHERING_GAZE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        WITHERING_GAZE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Burning Ambition");
        builder.comment("燃烧野心");
        BURNING_AMBITION_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        BURNING_AMBITION_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        BURNING_AMBITION_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        BURNING_AMBITION_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        BURNING_AMBITION_SHOTS_PER_STACK = builder
                .comment("每几发子弹叠一次燃烧层数（默认1发）")
                .defineInRange("shotsPerStack", 1, 1, 10);
        BURNING_AMBITION_STACKS_PER_HIT = builder
                .comment("每次命中给予的燃烧层数（默认1层）")
                .defineInRange("stacksPerHit", 1, 1, 10);
        builder.push("Whitelist & Blacklist");
        BURNING_AMBITION_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        BURNING_AMBITION_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        BURNING_AMBITION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        BURNING_AMBITION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Explosive Payload");
        builder.comment("[爆炸]类型附魔");

        builder.push("Butterfly");
        builder.comment("蝴蝶");
        BUTTERFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        BUTTERFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        BUTTERFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        BUTTERFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        BUTTERFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .defineInRange("baseDamage", 0.5, 0.5, 100.0);
        BUTTERFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害增量")
                .defineInRange("damagePerLevel", 0.5, 0.5, 50.0);
        BUTTERFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .defineInRange("splashMin", 0.5, 0.1, 10.0);
        BUTTERFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .defineInRange("splashMax", 1.0, 0.5, 15.0);
        BUTTERFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .defineInRange("range", 1.0, 0.1, 3.0);
        builder.push("Whitelist & Blacklist");
        BUTTERFLY_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        BUTTERFLY_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        BUTTERFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        BUTTERFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Explosive Payload");
        builder.comment("高爆载荷");
        EXPLOSIVE_PAYLOAD_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        EXPLOSIVE_PAYLOAD_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        EXPLOSIVE_PAYLOAD_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        EXPLOSIVE_PAYLOAD_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        EXPLOSIVE_PAYLOAD_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .defineInRange("baseDamage", 1.5, 1.0, 50.0);
        EXPLOSIVE_PAYLOAD_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害增量")
                .defineInRange("damagePerLevel", 0.5, 0.5, 30.0);
        EXPLOSIVE_PAYLOAD_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .defineInRange("splashMin", 0.5, 0.1, 10.0);
        EXPLOSIVE_PAYLOAD_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .defineInRange("splashMax", 1.5, 0.5, 15.0);
        EXPLOSIVE_PAYLOAD_RANGE = builder
                .comment("溅射伤害范围（格）")
                .defineInRange("range", 0.5, 0.1, 3.0);
        builder.push("Whitelist & Blacklist");
        EXPLOSIVE_PAYLOAD_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        EXPLOSIVE_PAYLOAD_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        EXPLOSIVE_PAYLOAD_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        EXPLOSIVE_PAYLOAD_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Firefly");
        builder.comment("萤火虫");
        FIREFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        FIREFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        FIREFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        FIREFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        FIREFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .defineInRange("baseDamage", 1.0, 1.0, 50.0);
        FIREFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害增量")
                .defineInRange("damagePerLevel", 0.5, 0.1, 30.0);
        FIREFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .defineInRange("splashMin", 0.5, 0.1, 10.0);
        FIREFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .defineInRange("splashMax", 1.5, 0.5, 15.0);
        FIREFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .defineInRange("range", 0.5, 0.1, 3.0);
        FIREFLY_BASE_RELOAD_SPEED = builder
                .comment("基础弹药补充倍率（0.0-1.0，0.1表示10%）")
                .defineInRange("baseReloadSpeed", 0.1, 0.1, 1.0);
        FIREFLY_RELOAD_SPEED_PER_LEVEL = builder
                .comment("每级弹药补充倍率增量")
                .defineInRange("reloadSpeedPerLevel", 0.1, 0.0, 0.5);
        builder.push("Whitelist & Blacklist");
        FIREFLY_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        FIREFLY_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(),
                        obj -> obj instanceof String);
        FIREFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        FIREFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Dragonfly");
        builder.comment("蜻蜓");
        DRAGONFLY_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        DRAGONFLY_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        DRAGONFLY_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        DRAGONFLY_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        DRAGONFLY_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .defineInRange("baseDamage", 1.0, 1.0, 50.0);
        DRAGONFLY_DAMAGE_PER_LEVEL = builder
                .comment("每级爆炸伤害增量")
                .defineInRange("damagePerLevel", 0.5, 0.1, 30.0);
        DRAGONFLY_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .defineInRange("splashMin", 0.5, 0.1, 10.0);
        DRAGONFLY_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .defineInRange("splashMax", 1.5, 0.5, 15.0);
        DRAGONFLY_RANGE = builder
                .comment("溅射伤害范围（格）")
                .defineInRange("range", 0.5, 0.1, 3.0);
        builder.push("Whitelist & Blacklist");
        DRAGONFLY_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        DRAGONFLY_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        DRAGONFLY_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Meganeura");
        builder.comment("巨脉蜻蜓");
        MEGANEURA_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 1);
        MEGANEURA_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        MEGANEURA_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        MEGANEURA_BASE_DAMAGE = builder
                .comment("基础爆炸伤害")
                .defineInRange("baseDamage", 3.0, 1.0, 50.0);
        MEGANEURA_SPLASH_MIN = builder
                .comment("溅射最小伤害")
                .defineInRange("splashMin", 1.5, 0.1, 10.0);
        MEGANEURA_SPLASH_MAX = builder
                .comment("溅射最大伤害")
                .defineInRange("splashMax", 4.5, 0.5, 15.0);
        MEGANEURA_RANGE = builder
                .comment("溅射伤害范围（格）")
                .defineInRange("range", 1.5, 0.1, 3.0);
        MEGANEURA_HEADSHOT_THRESHOLD = builder
                .comment("每次增加伤害所需的精准命中次数")
                .defineInRange("headshotThreshold", 5, 1, 10);
        MEGANEURA_DAMAGE_BONUS_PER_THRESHOLD = builder
                .comment("每个阈值增加的伤害百分比（0.05表示5%）")
                .defineInRange("damageBonusPerThreshold", 0.05, 0.01, 0.5);
        MEGANEURA_MAX_DAMAGE_BONUS = builder
                .comment("最大伤害加成百分比（0.25表示25%）")
                .defineInRange("maxDamageBonus", 0.50, 0.05, 1.0);
        builder.push("Whitelist & Blacklist");
        MEGANEURA_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        MEGANEURA_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        MEGANEURA_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        MEGANEURA_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Part Specifications");
        builder.comment("[配件数值]类型附魔");

        builder.push("Outlaw");
        builder.comment("不法之徒");
        OUTLAW_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        OUTLAW_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        OUTLAW_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        OUTLAW_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        OUTLAW_RELOAD_SPEED_MULTIPLIER = builder
                .comment("换弹速度加成（0.0-1.0，0.5表示50%）")
                .defineInRange("reloadSpeedMultiplier", 0.5, 0.1, 1.0);
        builder.push("Whitelist & Blacklist");
        OUTLAW_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        OUTLAW_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        OUTLAW_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        OUTLAW_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Snapshot Sights");
        builder.comment("速射瞄准");
        SNAPSHOT_SIGHTS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        SNAPSHOT_SIGHTS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        SNAPSHOT_SIGHTS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        SNAPSHOT_SIGHTS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        SNAPSHOT_SIGHTS_AIM_SPEED_BONUS = builder
                .comment("瞄准速度加成（1.5表示150%）")
                .defineInRange("aimSpeedBonus", 1.5, 0.1, 5.0);
        builder.push("Whitelist & Blacklist");
        SNAPSHOT_SIGHTS_WHITELIST_MODE = builder
                .comment("是否使用白名单模式")
                .define("whitelistMode", false);
        SNAPSHOT_SIGHTS_APPLICABLE_GUNS = builder
                .comment("枪械ID列表")
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SNAPSHOT_SIGHTS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式")
                .define("weaponTypeWhitelistMode", false);
        SNAPSHOT_SIGHTS_APPLICABLE_WEAPON_TYPES = builder
                .comment("武器类型列表")
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Firmly Planted");
        builder.comment("稳若磐石");
        FIRMLY_PLANTED_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        FIRMLY_PLANTED_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        FIRMLY_PLANTED_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        FIRMLY_PLANTED_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        FIRMLY_PLANTED_SPREAD_REDUCTION = builder
                .comment("瞄准精度提升倍率（1.0表示减少100%，0.25表示减少25%）")
                .defineInRange("spreadReduction", 0.25, 0.01, 1.0);
        FIRMLY_PLANTED_RECOIL_REDUCTION = builder
                .comment(
                        "垂直后坐力减少倍率（0.15 表示减少 15%）",
                        "推荐值：≤ 0.3，太高会导致枪口下移"
                )
                .defineInRange("recoilReduction", 0.15, 0.01, 0.5);
        builder.push("Whitelist & Blacklist");
        FIRMLY_PLANTED_WHITELIST_MODE = builder
                .comment("是否使用白名单模式")
                .define("whitelistMode", false);
        FIRMLY_PLANTED_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        FIRMLY_PLANTED_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式")
                .define("weaponTypeWhitelistMode", false);
        FIRMLY_PLANTED_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Adagio");
        builder.comment("柔缓");
        ADAGIO_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        ADAGIO_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        ADAGIO_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        ADAGIO_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        ADAGIO_DURATION = builder
                .comment("附魔激活持续时间（秒）")
                .defineInRange("duration", 5.0, 1.0, 30.0);
        ADAGIO_BONUS_DAMAGE = builder
                .comment("每级额外伤害倍率（0.15表示增加15%伤害）")
                .defineInRange("bonusDamage", 0.15, 0.01, 2.0);
        ADAGIO_FIRE_RATE_SLOWDOWN = builder
                .comment("每级射速减慢倍率（0.50表示减慢50%射速）")
                .defineInRange("fireRateSlowdown", 0.50, 0.01, 3.0);
        builder.push("Whitelist & Blacklist");
        ADAGIO_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        ADAGIO_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ADAGIO_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ADAGIO_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Onslaught");
        builder.comment("猛攻");
        ONSLAUGHT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        ONSLAUGHT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        ONSLAUGHT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        ONSLAUGHT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        ONSLAUGHT_DURATION = builder
                .comment("附魔激活持续时间（秒）")
                .defineInRange("duration", 4.5, 1.0, 30.0);
        ONSLAUGHT_FIRE_RATE_BOOST = builder
                .comment("每级射速提升倍率（0.25表示提升25%射速）")
                .defineInRange("fireRateBoost", 0.25, 0.01, 0.8);
        builder.push("Whitelist & Blacklist");
        ONSLAUGHT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        ONSLAUGHT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ONSLAUGHT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ONSLAUGHT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "pistol", "sniper", "shotgun", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Eye of Storm Eye");
        builder.comment("风暴之眼");
        EYE_OF_STORM_EYE_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        EYE_OF_STORM_EYE_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 20, 1, 100);
        EYE_OF_STORM_EYE_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 10, 1, 50);
        EYE_OF_STORM_EYE_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 30, 1, 100);
        EYE_OF_STORM_EYE_ACCURACY_BONUS = builder
                .comment("瞄准精度提升倍率（0.40表示提升40%精度，生命值越低效果越强）")
                .defineInRange("accuracyBonus", 0.40, 0.01, 1.0);
        EYE_OF_STORM_EYE_RECOIL_REDUCTION = builder
                .comment("水平后坐力减少倍率（0.05表示减少5%水平后坐力，生命值越低效果越强）")
                .defineInRange("recoilReduction", 0.05, 0.01, 0.3);
        builder.push("Whitelist & Blacklist");
        EYE_OF_STORM_EYE_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        EYE_OF_STORM_EYE_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        EYE_OF_STORM_EYE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        EYE_OF_STORM_EYE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();



        builder.pop();


        builder.push("Continuous Damage");
        builder.comment("[持续伤害]类型附魔");

        builder.push("Attrition Orbs");
        builder.comment("羸弱能量球");
        ATTRITION_ORBS_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        ATTRITION_ORBS_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 10, 1, 100);
        ATTRITION_ORBS_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        ATTRITION_ORBS_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        ATTRITION_ORBS_BASE_PERCENTAGE = builder
                .comment("基础射击百分比（1级，0.0-1.0）")
                .defineInRange("basePercentage", 0.67, 0.1, 1.0);
        ATTRITION_ORBS_PERCENTAGE_REDUCTION_PER_LEVEL = builder
                .comment("每级减少的射击百分比（0.0-1.0）")
                .defineInRange("percentageReductionPerLevel", 0.05, 0.0, 0.2);
        ATTRITION_ORBS_MIN_ORBS = builder
                .comment("生成的最小经验球数量")
                .defineInRange("minOrbs", 1, 1, 10);
        ATTRITION_ORBS_MAX_ORBS = builder
                .comment("生成的最大经验球数量")
                .defineInRange("maxOrbs", 3, 1, 20);
        builder.push("Whitelist & Blacklist");
        ATTRITION_ORBS_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        ATTRITION_ORBS_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:scar_l\", \"tacz:hk416\", \"tacz:awp\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        ATTRITION_ORBS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ATTRITION_ORBS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("Other");
        builder.comment("[其他]类型附魔");

        builder.push("Wellspring");
        builder.comment("泉源");
        WELLSPRING_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 3);
        WELLSPRING_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 15, 1, 100);
        WELLSPRING_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 9, 1, 100);
        WELLSPRING_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 50, 1, 100);
        WELLSPRING_MIN_EXP = builder
                .comment("每次击杀产生的最小经验值")
                .defineInRange("minExp", 1, 1, 100);
        WELLSPRING_MAX_EXP = builder
                .comment("每次击杀产生的最大经验值")
                .defineInRange("maxExp", 5, 1, 1000);
        builder.push("Whitelist & Blacklist");
        WELLSPRING_WHITELIST_MODE = builder
                .comment("武器是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        WELLSPRING_APPLICABLE_GUNS = builder
                .comment(
                        "武器ID列表",
                        "白名单模式：只有列表中的武器可以附魔",
                        "黑名单模式：列表中的武器不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有武器，黑名单模式=允许所有武器"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        WELLSPRING_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        WELLSPRING_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "rpg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Cooling Baubles");
        builder.comment("冷却饰物");
        COOLING_BAUBLES_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 3, 1, 5);
        COOLING_BAUBLES_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 10, 1, 100);
        COOLING_BAUBLES_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        COOLING_BAUBLES_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        COOLING_BAUBLES_COOL_CHANCE = builder
                .comment("收集经验球时降低热量的概率")
                .defineInRange("coolChance", 0.25, 0.0, 1.0);
        COOLING_BAUBLES_HEAT_REDUCTION = builder
                .comment("降低热量的百分比")
                .defineInRange("heatReduction", 0.05, 0.0, 1.0);
        builder.push("Whitelist & Blacklist");
        COOLING_BAUBLES_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", true);
        COOLING_BAUBLES_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(
                        "tacz:minigun"
                ), obj -> obj instanceof String);
        COOLING_BAUBLES_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", true);
        COOLING_BAUBLES_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Shoot Tp Loot");
        builder.comment("边打边劫");
        SHOOT_TP_LOOT_MAX_LEVEL = builder
                .comment("最大附魔等级")
                .defineInRange("maxLevel", 1, 1, 5);
        SHOOT_TP_LOOT_BASE_ENCHANTABILITY = builder
                .comment("基础附魔成本")
                .defineInRange("baseEnchantability", 10, 1, 100);
        SHOOT_TP_LOOT_LEVEL_ENCHANTABILITY = builder
                .comment("每级附魔成本增量")
                .defineInRange("levelEnchantability", 8, 1, 50);
        SHOOT_TP_LOOT_ENCHANTABILITY_SPAN = builder
                .comment("附魔成本跨度")
                .defineInRange("enchantabilitySpan", 25, 1, 100);
        SHOOT_TP_LOOT_PICKUP_CHANCE = builder
                .comment("子弹击中物品时拾取的概率")
                .defineInRange("pickupChance", 1.0, 0.0, 1.0);
        SHOOT_TP_LOOT_PICKUP_RANGE = builder
                .comment("拾取范围（格）")
                .defineInRange("pickupRange", 0.5, 0.25, 2.0);
        SHOOT_TP_LOOT_CAN_PICKUP_XP_ORB = builder
                .comment("是否可以拾取经验球")
                .define("canPickupXpOrb", true);
        SHOOT_TP_LOOT_LIMIT_ONE_ITEM_TYPE = builder
                .comment("是否限制每次只拾取一种物品（数量不限）")
                .define("limitOneItemType", true);
        builder.push("Whitelist & Blacklist");
        SHOOT_TP_LOOT_WHITELIST_MODE = builder
                .comment("是否使用白名单模式（true=白名单，false=黑名单）")
                .define("whitelistMode", false);
        SHOOT_TP_LOOT_APPLICABLE_GUNS = builder
                .comment(
                        "枪械ID列表",
                        "白名单模式：只有列表中的枪械可以附魔",
                        "黑名单模式：列表中的枪械不可以附魔",
                        "示例: [\"tacz:ak47\", \"tacz:m4a1\"]",
                        "留空表示：白名单模式=禁止所有枪械，黑名单模式=允许所有枪械"
                )
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SHOOT_TP_LOOT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SHOOT_TP_LOOT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, smg, rifle, sniper, shotgun, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();









        SPEC = builder.build();
    }
}