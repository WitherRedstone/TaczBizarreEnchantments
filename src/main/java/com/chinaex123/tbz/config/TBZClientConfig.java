package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TBZClientConfig {
    public static final ForgeConfigSpec SPEC;

    // ========== HUD显示设置 ==========
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_HUD_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_HUD_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_HUD_PADDING;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_HUD_SCALE;

    public static ForgeConfigSpec.DoubleValue SWASHBUCKLER_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue SWASHBUCKLER_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> SWASHBUCKLER_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> SWASHBUCKLER_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue SWASHBUCKLER_PADDING;
    public static ForgeConfigSpec.DoubleValue SWASHBUCKLER_SCALE;

    public static ForgeConfigSpec.DoubleValue ONE_FOR_ALL_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue ONE_FOR_ALL_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> ONE_FOR_ALL_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> ONE_FOR_ALL_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue ONE_FOR_ALL_PADDING;
    public static ForgeConfigSpec.DoubleValue ONE_FOR_ALL_SCALE;

    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> MASTER_OF_ARMS_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> MASTER_OF_ARMS_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue MASTER_OF_ARMS_PADDING;
    public static ForgeConfigSpec.DoubleValue MASTER_OF_ARMS_SCALE;

    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_LIGHT_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_LIGHT_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> EXPLOSIVE_LIGHT_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> EXPLOSIVE_LIGHT_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue EXPLOSIVE_LIGHT_PADDING;
    public static ForgeConfigSpec.DoubleValue EXPLOSIVE_LIGHT_SCALE;

    public static ForgeConfigSpec.DoubleValue REWIND_ROUNDS_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue REWIND_ROUNDS_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> REWIND_ROUNDS_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> REWIND_ROUNDS_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue REWIND_ROUNDS_PADDING;
    public static ForgeConfigSpec.DoubleValue REWIND_ROUNDS_SCALE;

    public static ForgeConfigSpec.DoubleValue TRIPLE_TAP_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue TRIPLE_TAP_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> TRIPLE_TAP_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TRIPLE_TAP_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue TRIPLE_TAP_PADDING;
    public static ForgeConfigSpec.DoubleValue TRIPLE_TAP_SCALE;
    public static ForgeConfigSpec.DoubleValue FOURTH_TIME_THE_CHARM_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue FOURTH_TIME_THE_CHARM_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> FOURTH_TIME_THE_CHARM_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> FOURTH_TIME_THE_CHARM_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue FOURTH_TIME_THE_CHARM_PADDING;
    public static ForgeConfigSpec.DoubleValue FOURTH_TIME_THE_CHARM_SCALE;

    public static ForgeConfigSpec.DoubleValue TOUCH_OF_MALICE_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue TOUCH_OF_MALICE_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> TOUCH_OF_MALICE_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TOUCH_OF_MALICE_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue TOUCH_OF_MALICE_PADDING;
    public static ForgeConfigSpec.DoubleValue TOUCH_OF_MALICE_SCALE;
    public static ForgeConfigSpec.DoubleValue THE_RIGHT_CHOICE_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue THE_RIGHT_CHOICE_RELATIVE_Y;
    public static ForgeConfigSpec.ConfigValue<String> THE_RIGHT_CHOICE_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> THE_RIGHT_CHOICE_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue THE_RIGHT_CHOICE_PADDING;
    public static ForgeConfigSpec.DoubleValue THE_RIGHT_CHOICE_SCALE;


    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Left Display");
        builder.comment("左显示");

        builder.push("Target Lock Display");
        builder.comment("目标锁定显示配置");
        TARGET_LOCK_HUD_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        TARGET_LOCK_HUD_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        TARGET_LOCK_HUD_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.01, 0.0, 1.0);
        TARGET_LOCK_HUD_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.97, 0.0, 1.0);
        TARGET_LOCK_HUD_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        TARGET_LOCK_HUD_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("Swashbuckler Display");
        builder.comment("斗剑士显示配置");
        SWASHBUCKLER_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        SWASHBUCKLER_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        SWASHBUCKLER_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.01, 0.0, 1.0);
        SWASHBUCKLER_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.93, 0.0, 1.0);
        SWASHBUCKLER_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        SWASHBUCKLER_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("OneForAll Display");
        builder.comment("我为人人显示配置");
        ONE_FOR_ALL_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        ONE_FOR_ALL_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        ONE_FOR_ALL_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.01, 0.0, 1.0);
        ONE_FOR_ALL_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.89, 0.0, 1.0);
        ONE_FOR_ALL_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        ONE_FOR_ALL_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("MasterOfArms Display");
        builder.comment("武器大师显示配置");
        MASTER_OF_ARMS_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        MASTER_OF_ARMS_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        MASTER_OF_ARMS_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.01, 0.0, 1.0);
        MASTER_OF_ARMS_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.85, 0.0, 1.0);
        MASTER_OF_ARMS_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        MASTER_OF_ARMS_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("ExplosiveLight Display");
        builder.comment("爆炸光能显示配置");
        EXPLOSIVE_LIGHT_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFD700");
        EXPLOSIVE_LIGHT_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        EXPLOSIVE_LIGHT_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        EXPLOSIVE_LIGHT_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.75, 0.0, 1.0);
        EXPLOSIVE_LIGHT_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        EXPLOSIVE_LIGHT_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.pop();


        builder.push("Right Display");
        builder.comment("右显示");

        builder.push("RewindRounds Display");
        builder.comment("回转弹药显示配置");
        REWIND_ROUNDS_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        REWIND_ROUNDS_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        REWIND_ROUNDS_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        REWIND_ROUNDS_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.97, 0.0, 1.0);
        REWIND_ROUNDS_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        REWIND_ROUNDS_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("TripleTap Display");
        builder.comment("精准连击显示配置");
        TRIPLE_TAP_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        TRIPLE_TAP_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        TRIPLE_TAP_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        TRIPLE_TAP_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.93, 0.0, 1.0);
        TRIPLE_TAP_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        TRIPLE_TAP_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("FourthTimeTheCharm Display");
        builder.comment("事不过四显示配置");
        FOURTH_TIME_THE_CHARM_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        FOURTH_TIME_THE_CHARM_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        FOURTH_TIME_THE_CHARM_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        FOURTH_TIME_THE_CHARM_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.89, 0.0, 1.0);
        FOURTH_TIME_THE_CHARM_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        FOURTH_TIME_THE_CHARM_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("TouchOfMalice Display");
        builder.comment("恶意触碰显示配置");
        TOUCH_OF_MALICE_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FF4444");
        TOUCH_OF_MALICE_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        TOUCH_OF_MALICE_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        TOUCH_OF_MALICE_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.85, 0.0, 1.0);
        TOUCH_OF_MALICE_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        TOUCH_OF_MALICE_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.push("TheRightChoice Display");
        builder.comment("正确抉择显示配置");
        THE_RIGHT_CHOICE_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#44FF44");
        THE_RIGHT_CHOICE_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        THE_RIGHT_CHOICE_RELATIVE_X = builder
                .comment("显示位置 X 坐标（屏幕宽度的百分比，0.0-1.0）")
                .defineInRange("relativeX", 0.08, 0.0, 1.0);
        THE_RIGHT_CHOICE_RELATIVE_Y = builder
                .comment("显示位置 Y 坐标（屏幕高度的百分比，0.0-1.0）")
                .defineInRange("relativeY", 0.81, 0.0, 1.0);
        THE_RIGHT_CHOICE_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        THE_RIGHT_CHOICE_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
        builder.pop();

        builder.pop();

        SPEC = builder.build();
    }

    /**
     * 解析颜色字符串为整数值
     *
     * @param colorStr 颜色字符串，支持 #FFFFFF 或 0xFFFFFF 格式
     * @return 颜色的整数值，解析失败时返回 0xFFFFFF
     */
    public static int parseColor(String colorStr) {
        if (colorStr == null || colorStr.isEmpty()) {
            return 0xFFFFFF;
        }

        try {
            String hex = colorStr.trim();
            if (hex.startsWith("#")) {
                hex = hex.substring(1);
            } else if (hex.startsWith("0x") || hex.startsWith("0X")) {
                hex = hex.substring(2);
            }

            if (hex.length() == 6) {
                return Integer.parseInt(hex, 16);
            } else if (hex.length() == 8) {
                return (int) Long.parseLong(hex, 16);
            } else {
                return 0xFFFFFF;
            }
        } catch (NumberFormatException e) {
            return 0xFFFFFF;
        }
    }
}