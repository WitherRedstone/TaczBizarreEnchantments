package com.chinaex123.tbz.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TBZClientConfig {
    public static final ForgeConfigSpec SPEC;

    // ========== HUD显示设置 ==========
    public static ForgeConfigSpec.IntValue TARGET_LOCK_HUD_DISPLAY_X;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_HUD_DISPLAY_Y;
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_TEXT;
    public static ForgeConfigSpec.ConfigValue<String> TARGET_LOCK_HUD_COLOR_BACKGROUND;
    public static ForgeConfigSpec.IntValue TARGET_LOCK_HUD_PADDING;
    public static ForgeConfigSpec.DoubleValue TARGET_LOCK_HUD_SCALE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Target Lock Display");
        builder.comment("目标锁定显示配置");
        TARGET_LOCK_HUD_COLOR_TEXT = builder
                .comment("文本颜色 (十六进制格式，如 #FFFFFF 或 0xFFFFFF)")
                .define("colorText", "#FFFFFF");
        TARGET_LOCK_HUD_COLOR_BACKGROUND = builder
                .comment("背景颜色 (十六进制格式，如 #88000000 或 0x88000000)")
                .define("colorBackground", "#88000000");
        TARGET_LOCK_HUD_DISPLAY_X = builder
                .comment("显示位置 X 坐标")
                .defineInRange("displayX", 100, 0, Integer.MAX_VALUE);
        TARGET_LOCK_HUD_DISPLAY_Y = builder
                .comment("显示位置 Y 坐标")
                .defineInRange("displayY", 10, 0, Integer.MAX_VALUE);
        TARGET_LOCK_HUD_PADDING = builder
                .comment("背景内边距")
                .defineInRange("padding", 4, 0, 50);
        TARGET_LOCK_HUD_SCALE = builder
                .comment("缩放比例")
                .defineInRange("scale", 1.0, 0.5, 3.0);
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