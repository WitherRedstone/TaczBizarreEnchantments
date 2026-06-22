package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.List;

public class TBZConfig {

    // ========== 通用设置 ==========
    public static ForgeConfigSpec.IntValue MAX_ENCHANTMENTS_PER_GUN;

    // ========== 斩首武器 ==========
    public static ForgeConfigSpec.DoubleValue BORPAL_WEAPON_BOSS_DAMAGE_BONUS;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BORPAL_WEAPON_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.BooleanValue BORPAL_WEAPON_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BORPAL_WEAPON_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES;

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

    // ========== 野心刺客 ==========
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

    // ========== 重构 ==========
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
    public static ForgeConfigSpec.BooleanValue REWIND_ROUNDS_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REWIND_ROUNDS_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES;

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

    // ========== 枯萎凝视 ==========
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_EFFECT_DURATION;
    public static ForgeConfigSpec.IntValue WITHERING_GAZE_EFFECT_LEVEL;
    public static ForgeConfigSpec.BooleanValue WITHERING_GAZE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_GAZE_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WITHERING_GAZE_APPLICABLE_WEAPON_TYPES;

    // ========== 蝴蝶 ==========
    public static ForgeConfigSpec.IntValue BUTTERFLY_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue BUTTERFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BUTTERFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue BUTTERFLY_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_PAYLOAD_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue FIREFLY_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue FIREFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIREFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue FIREFLY_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue DRAGONFLY_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue DRAGONFLY_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DRAGONFLY_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DRAGONFLY_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue MEGANEURA_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue MEGANEURA_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue MEGANEURA_ENCHANTABILITY_SPAN;
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

    // ========== 风暴涌动 ==========
    public static ForgeConfigSpec.IntValue ROLLING_STORM_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ROLLING_STORM_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue DESTABILIZING_ROUNDS_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue INCANDESCENT_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue INCANDESCENT_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue INCANDESCENT_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue INCANDESCENT_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue CHILL_CLIP_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue CHILL_CLIP_ENCHANTABILITY_SPAN;
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
    public static ForgeConfigSpec.IntValue RIMESTEALER_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue RIMESTEALER_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RIMESTEALER_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue RIMESTEALER_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.IntValue RIMESTEALER_FROST_ARMOR_DURATION;
    public static ForgeConfigSpec.IntValue RIMESTEALER_FROST_ARMOR_AMPLIFIER;
    public static ForgeConfigSpec.IntValue RIMESTEALER_COOLDOWN_TICKS;
    public static ForgeConfigSpec.IntValue RIMESTEALER_EXTEND_DURATION;
    public static ForgeConfigSpec.IntValue RIMESTEALER_MAX_DURATION;
    public static ForgeConfigSpec.BooleanValue RIMESTEALER_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RIMESTEALER_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> RIMESTEALER_APPLICABLE_WEAPON_TYPES;

    // ========== 目标锁定 ==========
    public static ForgeConfigSpec.IntValue TARGET_LOCK_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_ENCHANTABILITY_SPAN;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_DAMAGE_BONUS_PER_STACK;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT;
    public static ForgeConfigSpec.BooleanValue TARGET_LOCK_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TARGET_LOCK_APPLICABLE_GUNS;
    public static ForgeConfigSpec.BooleanValue TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> TARGET_LOCK_APPLICABLE_WEAPON_TYPES;

    // ========== 切割 ==========
    public static ForgeConfigSpec.IntValue SLICE_MAX_LEVEL;
    public static ForgeConfigSpec.IntValue SLICE_BASE_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SLICE_LEVEL_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue SLICE_ENCHANTABILITY_SPAN;
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


    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("General");
        builder.comment("通用设置");
        MAX_ENCHANTMENTS_PER_GUN = builder
                .comment("每把枪械最多可以附魔的TBZ附魔数量")
                .defineInRange("maxEnchantmentsPerGun", 3, 1, 8);
        builder.pop();


        builder.push("BonusDamage");
        builder.comment("[增伤]类型附魔");

        builder.push("BorpalWeapon");
        builder.comment("斩首武器附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.pop();


        builder.push("BonusBullet");
        builder.comment("[回子弹]类型附魔");

        builder.push("Subsistence");
        builder.comment("维持生计附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SUBSISTENCE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("AmbitiousAssassin");
        builder.comment("刺客野心附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(
                        "sniper", "rpg", "mg"
                ), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("Reconstruction");
        builder.comment("重建附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        RECONSTRUCTION_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("TripleTap");
        builder.comment("精准连击附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TRIPLE_TAP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("FourthTimeTheCharm");
        builder.comment("事不过四附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("RewindRounds");
        builder.comment("回转弹药附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("Mulligan");
        builder.comment("重新调度附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        MULLIGAN_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        MULLIGAN_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.pop();


        builder.push("ContinuousDamage");
        builder.comment("[持续伤害]类型附魔");

        builder.push("AttritionOrbs");
        builder.comment("羸弱能量球附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("TargetLock");
        builder.comment("目标锁定附魔配置");
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
        TARGET_LOCK_REQUIRED_MAGAZINE_PERCENT = builder
                .comment("需要射击弹夹的百分比来触发加成（0.15表示15%）")
                .defineInRange("requiredMagazinePercent", 0.15, 0.01, 0.5);
        builder.push("ApplicableGuns");
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
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        TARGET_LOCK_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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


        builder.push("ApplicationEffect");
        builder.comment("[应用效果]类型附魔");

        builder.push("HealClip");
        builder.comment("治疗弹匣附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        HEAL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("ProtectiveWeave");
        builder.comment("防护编织附魔配置");
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
                .comment("没有织造铠甲时给予的持续时间（刻）")
                .defineInRange("wovenMailDuration", 200, 50, 600);
        PROTECTIVE_WEAVE_WOVEN_MAIL_AMPLIFIER = builder
                .comment("没有织造铠甲时给予的等级")
                .defineInRange("wovenMailAmplifier", 0, 0, 2);
        PROTECTIVE_WEAVE_COOLDOWN_TICKS = builder
                .comment("没有织造铠甲时给予效果的冷却时间（刻）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        PROTECTIVE_WEAVE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        PROTECTIVE_WEAVE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("RollingStorm");
        builder.comment("风暴涌动附魔配置");
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
                .comment("没有增幅效果时给予的持续时间（刻）")
                .defineInRange("amplifiedDuration", 200, 50, 600);
        ROLLING_STORM_AMPLIFIED_AMPLIFIER = builder
                .comment("没有增幅效果时给予的等级")
                .defineInRange("amplifiedAmplifier", 0, 0, 2);
        ROLLING_STORM_COOLDOWN_TICKS = builder
                .comment("没有增幅效果时给予效果的冷却时间（刻）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        ROLLING_STORM_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        ROLLING_STORM_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        ROLLING_STORM_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("DestabilizingRounds");
        builder.comment("失衡弹药附魔配置");
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
                .comment("没有不稳定效果时给予的持续时间（刻）")
                .defineInRange("volatileDuration", 200, 50, 600);
        DESTABILIZING_ROUNDS_VOLATILE_AMPLIFIER = builder
                .comment("没有不稳定效果时给予的等级")
                .defineInRange("volatileAmplifier", 0, 0, 2);
        DESTABILIZING_ROUNDS_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        DESTABILIZING_ROUNDS_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("辉耀炽热附魔配置");
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
                .comment("没有灼烧效果时给予的持续时间（刻）")
                .defineInRange("scorchDuration", 200, 50, 600);
        INCANDESCENT_SCORCH_AMPLIFIER = builder
                .comment("没有灼烧效果时给予的等级")
                .defineInRange("scorchAmplifier", 0, 0, 2);
        INCANDESCENT_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        INCANDESCENT_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        INCANDESCENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("ChillClip");
        builder.comment("冰冷弹匣附魔配置");
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
                .comment("没有霜寒效果时给予的持续时间（刻）")
                .defineInRange("frostbiteDuration", 200, 50, 600);
        CHILL_CLIP_FROSTBITE_MIN_AMPLIFIER = builder
                .comment("没有霜寒效果时给予的最小等级")
                .defineInRange("frostbiteMinAmplifier", 0, 0, 2);
        CHILL_CLIP_FROSTBITE_MAX_AMPLIFIER = builder
                .comment("没有霜寒效果时给予的最大等级")
                .defineInRange("frostbiteMaxAmplifier", 2, 0, 2);
        CHILL_CLIP_COOLDOWN_TICKS = builder
                .comment("没有霜寒效果时给予效果的冷却时间（刻）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        CHILL_CLIP_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        CHILL_CLIP_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        CHILL_CLIP_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("霜华窃取者附魔配置");
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
                .comment("没有冰霜护甲时给予的持续时间（刻）")
                .defineInRange("frostArmorDuration", 200, 50, 600);
        RIMESTEALER_FROST_ARMOR_AMPLIFIER = builder
                .comment("没有冰霜护甲时给予的等级")
                .defineInRange("frostArmorAmplifier", 0, 0, 2);
        RIMESTEALER_COOLDOWN_TICKS = builder
                .comment("没有冰霜护甲时给予效果的冷却时间（刻）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        RIMESTEALER_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        RIMESTEALER_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        RIMESTEALER_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("切割附魔配置");
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
                .comment("没有瓦解效果时给予的持续时间（刻）")
                .defineInRange("severDuration", 200, 50, 600);
        SLICE_SEVER_MIN_AMPLIFIER = builder
                .comment("没有瓦解效果时给予的最小等级")
                .defineInRange("severMinAmplifier", 0, 0, 2);
        SLICE_SEVER_MAX_AMPLIFIER = builder
                .comment("没有瓦解效果时给予的最大等级")
                .defineInRange("severMaxAmplifier", 2, 0, 2);
        SLICE_COOLDOWN_TICKS = builder
                .comment("没有瓦解效果时给予效果的冷却时间（刻）")
                .defineInRange("cooldownTicks", 300, 100, 600);
        SLICE_EXTEND_DURATION = builder
                .comment("有效果时延长的持续时间（刻）")
                .defineInRange("extendDuration", 100, 20, 300);
        SLICE_MAX_DURATION = builder
                .comment("有效果时延长的最大持续时间（刻）")
                .defineInRange("maxDuration", 1200, 600, 2400);
        builder.push("ApplicableGuns");
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
                .defineList("gunList", List.of(),
                        obj -> obj instanceof String);
        builder.pop();
        builder.push("ApplicableWeaponTypes");
        SLICE_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        SLICE_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.pop();


        builder.push("Headshot");
        builder.comment("[爆头]类型附魔");

        builder.push("PrecisionInstrument");
        builder.comment("精准工具附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("Outlaw");
        builder.comment("不法之徒附魔配置");
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
                .defineList("gunList", List.of(), obj -> obj instanceof String);
        OUTLAW_WEAPON_TYPE_WHITELIST_MODE = builder
                .comment("武器类型是否使用白名单模式（true=白名单，false=黑名单）")
                .define("weaponTypeWhitelistMode", false);
        OUTLAW_APPLICABLE_WEAPON_TYPES = builder
                .comment(
                        "武器类型列表",
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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


        builder.push("Aim");
        builder.comment("[瞄准]类型附魔");

        builder.push("GutshotStraight");
        builder.comment("直击要害附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
                        "白名单模式：只有列表中的武器类型可以附魔",
                        "黑名单模式：列表中的武器类型不可以附魔",
                        "示例: [\"rifle\", \"smg\"]",
                        "留空表示：白名单模式=禁止所有类型，黑名单模式=允许所有类型"
                )
                .defineList("weaponTypeList", List.of(), obj -> obj instanceof String);
        builder.pop();
        builder.pop();

        builder.push("WitheringGaze");
        builder.comment("枯萎凝视附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.pop();


        builder.push("ExplosivePayload");
        builder.comment("[爆炸]类型附魔");

        builder.push("Butterfly");
        builder.comment("蝴蝶附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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

        builder.push("ExplosivePayload");
        builder.comment("高爆载荷附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("萤火虫附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("蜻蜓附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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
        builder.comment("巨脉蜻蜓附魔配置");
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
                        "可选类型: pistol, sniper, rifle, shotgun, smg, rpg, mg",
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









        SPEC = builder.build();
    }
}