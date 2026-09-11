package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TBZClientConfig {
    public static final ForgeConfigSpec SPEC;

    // ========== HUD布局管理器配置 ==========
    public static ForgeConfigSpec.DoubleValue HUD_LAYOUT_LEFT_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue HUD_LAYOUT_LEFT_RELATIVE_Y;
    public static ForgeConfigSpec.DoubleValue HUD_LAYOUT_RIGHT_RELATIVE_X;
    public static ForgeConfigSpec.DoubleValue HUD_LAYOUT_RIGHT_RELATIVE_Y;
    public static ForgeConfigSpec.IntValue HUD_LAYOUT_SPACING;
    public static ForgeConfigSpec.DoubleValue HUD_LAYOUT_MAX_SCREEN_HEIGHT_RATIO;
    public static ForgeConfigSpec.IntValue HUD_LAYOUT_TIMEOUT_SECONDS;

    // ========== 通用HUD配置 ==========
    public static ForgeConfigSpec.DoubleValue HUD_COMMON_SCALE;
    public static ForgeConfigSpec.IntValue HUD_COMMON_PADDING;

    // ========== 目标锁定 ==========
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_BACKGROUND;

    // ========== 斗剑士 ==========
    public static ForgeConfigSpec.ConfigValue<String> SWASHBUCKLER_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> SWASHBUCKLER_COLOR_BACKGROUND;

    // ========== 我为人人 ==========
    public static ForgeConfigSpec.ConfigValue<String> ONE_FOR_ALL_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> ONE_FOR_ALL_COLOR_BACKGROUND;

    // ========== 武器大师 ==========
    public static ForgeConfigSpec.ConfigValue<String> MASTER_OF_ARMS_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> MASTER_OF_ARMS_COLOR_BACKGROUND;

    // ========== 爆炸光能 ==========
    public static ForgeConfigSpec.ConfigValue<String> EXPLOSIVE_LIGHT_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> EXPLOSIVE_LIGHT_COLOR_BACKGROUND;

    // ========== 回转弹药 ==========
    public static ForgeConfigSpec.ConfigValue<String> REWIND_ROUNDS_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> REWIND_ROUNDS_COLOR_BACKGROUND;

    // ========== 精准连击 ==========
    public static ForgeConfigSpec.ConfigValue<String> TRIPLE_TAP_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TRIPLE_TAP_COLOR_BACKGROUND;
    
    // ========== 事不过四 ==========
    public static ForgeConfigSpec.ConfigValue<String> FOURTH_TIME_THE_CHARM_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> FOURTH_TIME_THE_CHARM_COLOR_BACKGROUND;

    // ========== 恶意触碰 ==========
    public static ForgeConfigSpec.ConfigValue<String> TOUCH_OF_MALICE_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TOUCH_OF_MALICE_COLOR_BACKGROUND;

    // ========== 正确抉择 ==========
    public static ForgeConfigSpec.ConfigValue<String> THE_RIGHT_CHOICE_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> THE_RIGHT_CHOICE_COLOR_BACKGROUND;


    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("通用HUD配置").push("Common HUD Config");
        HUD_COMMON_SCALE = builder
                .comment("通用HUD缩放比例")
                .comment("Common HUD scaling")
                .defineInRange("commonScale", 1.0, 0.1, 10.0);
        HUD_COMMON_PADDING = builder
                .comment("通用HUD背景内边距")
                .comment("Common HUD background padding")
                .defineInRange("commonPadding", 4, 0, 20);
        HUD_LAYOUT_LEFT_RELATIVE_X = builder
                .comment("左侧HUD起始位置 X 坐标（屏幕宽度的百分比）")
                .comment("Left HUD start position X coordinate (percentage of screen width)")
                .defineInRange("leftRelativeX", 0.05, 0.0, 1.0);
        HUD_LAYOUT_LEFT_RELATIVE_Y = builder
                .comment("左侧HUD起始位置 Y 坐标（屏幕高度的百分比）")
                .comment("Left HUD start position Y coordinate (percentage of screen height)")
                .defineInRange("leftRelativeY", 0.85, 0.0, 1.0);
        HUD_LAYOUT_RIGHT_RELATIVE_X = builder
                .comment("右侧HUD起始位置 X 坐标（屏幕宽度的百分比）")
                .comment("Right HUD start position X coordinate (percentage of screen width)")
                .defineInRange("rightRelativeX", 0.90, 0.0, 1.0);
        HUD_LAYOUT_RIGHT_RELATIVE_Y = builder
                .comment("右侧HUD起始位置 Y 坐标（屏幕高度的百分比）")
                .comment("Right HUD start position Y coordinate (percentage of screen height)")
                .defineInRange("rightRelativeY", 0.85, 0.0, 1.0);
        HUD_LAYOUT_SPACING = builder
                .comment("HUD元素之间的间距（像素）")
                .comment("Spacing between HUD elements (pixels)")
                .defineInRange("spacing", 1, 0, 20);
        HUD_LAYOUT_MAX_SCREEN_HEIGHT_RATIO = builder
                .comment("HUD最大占用屏幕高度比例（0.5表示最多占屏幕高度的一半）")
                .comment("Maximum HUD height ratio of screen (0.5 = half of screen height)")
                .defineInRange("maxScreenHeightRatio", 0.5, 0.1, 0.9);
        HUD_LAYOUT_TIMEOUT_SECONDS = builder
                .comment("HUD元素超时时间（tick）")
                .comment("HUD element timeout (ticks)")
                .defineInRange("timeoutSeconds", 100, 1, Integer.MAX_VALUE);
        builder.pop();


        builder.comment("左侧显示").push("Show on left side");

        builder.comment("目标锁定").push("Target Lock");
        TARGET_LOCK_HUD_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        TARGET_LOCK_HUD_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("斗剑士").push("Swashbuckler");
        SWASHBUCKLER_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        SWASHBUCKLER_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("我为人人").push("One For All");
        ONE_FOR_ALL_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        ONE_FOR_ALL_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("武器大师").push("Master Of Arms");
        MASTER_OF_ARMS_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        MASTER_OF_ARMS_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("爆炸光能").push("Explosive Light");
        EXPLOSIVE_LIGHT_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFD700");
        EXPLOSIVE_LIGHT_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.pop();


        builder.comment("右侧显示").push("Show on right side");

        builder.comment("回转弹药").push("Rewind Rounds");
        REWIND_ROUNDS_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        REWIND_ROUNDS_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("精准连击").push("Triple Tap");
        TRIPLE_TAP_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        TRIPLE_TAP_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("事不过四").push("Fourth Time's The Charm");
        FOURTH_TIME_THE_CHARM_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FFFFFF");
        FOURTH_TIME_THE_CHARM_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("恶意触碰").push("Touch of Malice");
        TOUCH_OF_MALICE_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#FF4444");
        TOUCH_OF_MALICE_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
        builder.pop();

        builder.comment("正确抉择").push("The Right Choice");
        THE_RIGHT_CHOICE_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式)")
                .comment("Text Color (Hexadecimal format)")
                .define("colorText", "#44FF44");
        THE_RIGHT_CHOICE_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式带透明度)")
                .comment("Background Color (Hexadecimal format with alpha)")
                .define("colorBackground", "#88000000");
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