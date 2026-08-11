package com.chinaex123.tbz.client.hud;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 触发型附魔客户端处理类
 * <p>
 * 功能：在客户端显示触发型附魔的触发状态
 * <p>
 * 支持的附魔类型：
 * <ul>
 *   <li>rewind_rounds - 回转弹药</li>
 *   <li>triple_tap - 精准连击</li>
 *   <li>fourth_time_the_charm - 事不过四</li>
 * </ul>
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
public class TriggeredEnchantmentHUD {

    /** 缓存每个玩家的触发时间 **/
    private static final Map<UUID, Long> TRIGGER_TIME_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的附魔类型 **/
    private static final Map<UUID, String> ENCHANTMENT_TYPE_CACHE = new ConcurrentHashMap<>();
    /** 显示持续时间（刻） **/
    private static final int DISPLAY_DURATION_TICKS = 10;

    /**
     * 设置指定玩家的触发状态
     * 仅在客户端玩家自身匹配时更新缓存
     *
     * @param playerUuid 玩家UUID
     * @param enchantmentType 附魔类型
     * @param triggerTime 触发时间
     */
    public static void setTriggered(UUID playerUuid, String enchantmentType, long triggerTime) {
        Minecraft minecraft = Minecraft.getInstance();
        // 只缓存本地玩家的数据
        if (minecraft.player != null && minecraft.player.getUUID().equals(playerUuid)) {
            TRIGGER_TIME_CACHE.put(playerUuid, triggerTime);
            ENCHANTMENT_TYPE_CACHE.put(playerUuid, enchantmentType);
        }
    }

    /**
     * 清除指定玩家的触发数据
     *
     * @param playerUuid 玩家UUID
     */
    public static void clearTriggered(UUID playerUuid) {
        TRIGGER_TIME_CACHE.remove(playerUuid);
        ENCHANTMENT_TYPE_CACHE.remove(playerUuid);
    }

    /**
     * 在游戏界面上渲染触发型附魔显示
     * 在游戏画面渲染结束后绘制HUD
     *
     * @param event 渲染GUI事件
     */
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return;

        UUID playerUuid = minecraft.player.getUUID();
        Long triggerTime = TRIGGER_TIME_CACHE.get(playerUuid);
        String enchantmentType = ENCHANTMENT_TYPE_CACHE.get(playerUuid);

        // 如果没有触发或时间已过，不显示
        if (triggerTime == null || enchantmentType == null) return;

        // 检查是否还在显示时间内
        long currentTime = minecraft.player.level().getGameTime();
        if (currentTime - triggerTime >= DISPLAY_DURATION_TICKS) {
            clearTriggered(playerUuid);
            return;
        }

        GuiGraphics guiGraphics = event.getGuiGraphics();
        Font font = minecraft.font;

        // 根据附魔类型获取配置和文本
        int colorText;
        int colorBackground;
        double relativeX;
        double relativeY;
        int padding;
        double scale;
        String translationKey;

        switch (enchantmentType) {
            // 回转弹药
            case "rewind_rounds" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.REWIND_ROUNDS_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.REWIND_ROUNDS_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.REWIND_ROUNDS_RELATIVE_X.get();
                relativeY = TBZClientConfig.REWIND_ROUNDS_RELATIVE_Y.get();
                padding = TBZClientConfig.REWIND_ROUNDS_PADDING.get();
                scale = TBZClientConfig.REWIND_ROUNDS_SCALE.get();
                translationKey = "gui.tbz.rewind_rounds";
            }
            // 精准连击
            case "triple_tap" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.TRIPLE_TAP_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.TRIPLE_TAP_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.TRIPLE_TAP_RELATIVE_X.get();
                relativeY = TBZClientConfig.TRIPLE_TAP_RELATIVE_Y.get();
                padding = TBZClientConfig.TRIPLE_TAP_PADDING.get();
                scale = TBZClientConfig.TRIPLE_TAP_SCALE.get();
                translationKey = "gui.tbz.triple_tap";
            }
            // 事不过四
            case "fourth_time_the_charm" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.FOURTH_TIME_THE_CHARM_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.FOURTH_TIME_THE_CHARM_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.FOURTH_TIME_THE_CHARM_RELATIVE_X.get();
                relativeY = TBZClientConfig.FOURTH_TIME_THE_CHARM_RELATIVE_Y.get();
                padding = TBZClientConfig.FOURTH_TIME_THE_CHARM_PADDING.get();
                scale = TBZClientConfig.FOURTH_TIME_THE_CHARM_SCALE.get();
                translationKey = "gui.tbz.fourth_time_the_charm";
            }
            // 恶意触碰
            case "touch_of_malice" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.TOUCH_OF_MALICE_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.TOUCH_OF_MALICE_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.TOUCH_OF_MALICE_RELATIVE_X.get();
                relativeY = TBZClientConfig.TOUCH_OF_MALICE_RELATIVE_Y.get();
                padding = TBZClientConfig.TOUCH_OF_MALICE_PADDING.get();
                scale = TBZClientConfig.TOUCH_OF_MALICE_SCALE.get();
                translationKey = "gui.tbz.touch_of_malice";
            }
            // 正确抉择
            case "the_right_choice" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.THE_RIGHT_CHOICE_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.THE_RIGHT_CHOICE_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.THE_RIGHT_CHOICE_RELATIVE_X.get();
                relativeY = TBZClientConfig.THE_RIGHT_CHOICE_RELATIVE_Y.get();
                padding = TBZClientConfig.THE_RIGHT_CHOICE_PADDING.get();
                scale = TBZClientConfig.THE_RIGHT_CHOICE_SCALE.get();
                translationKey = "gui.tbz.the_right_choice";
            }
            default -> {
                return;
            }
        }

        // 获取屏幕尺寸
        int screenWidth = minecraft.getWindow().getGuiScaledWidth();
        int screenHeight = minecraft.getWindow().getGuiScaledHeight();

        // 使用相对位置（百分比）
        int displayX = (int) (screenWidth * relativeX);
        int displayY = (int) (screenHeight * relativeY);

        // 准备显示文本
        String text = Component.translatable(translationKey).getString();
        int textWidth = font.width(text);
        int lineHeight = font.lineHeight;

        // 应用缩放后的尺寸
        int scaledTextWidth = (int) (textWidth * scale);
        int scaledLineHeight = (int) (lineHeight * scale);
        int scaledPadding = (int) (padding * scale);

        // 计算背景位置和大小（在原始坐标系中）
        int bgX = displayX - scaledPadding;
        int bgY = displayY - scaledPadding / 2;
        int bgWidth = scaledTextWidth + scaledPadding * 2;
        int bgHeight = scaledLineHeight + scaledPadding;

        // 绘制半透明背景
        guiGraphics.fill(bgX, bgY, bgX + bgWidth, bgY + bgHeight, colorBackground);

        // 绘制文字（使用缩放变换）
        guiGraphics.pose().pushPose();
        // 平移至目标位置
        guiGraphics.pose().translate(displayX, displayY, 0);
        // 应用缩放
        guiGraphics.pose().scale((float) scale, (float) scale, 1.0f);
        // 在缩放后的坐标系中从 (0,0) 开始绘制文字
        guiGraphics.drawString(font, text, 0, 0, colorText);
        guiGraphics.pose().popPose();
    }
}