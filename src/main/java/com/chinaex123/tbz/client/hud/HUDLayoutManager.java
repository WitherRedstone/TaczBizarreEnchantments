package com.chinaex123.tbz.client.hud;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HUD布局管理器
 * <p>
 * 功能：管理多个HUD元素的垂直堆叠布局，避免重叠
 * <p>
 * 特性：
 * <ul>
 *   <li>自动计算HUD元素位置，避免重叠</li>
 *   <li>支持配置起始位置、间距、最大高度等</li>
 *   <li>动态管理HUD元素的显示和隐藏</li>
 * </ul>
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
public class HUDLayoutManager {

    /** HUD元素接口 **/
    public interface HUDElement {
        /** 获取显示文本 **/
        String getText();

        /** 获取文本宽度 **/
        int getTextWidth(Font font);

        /** 获取行高 **/
        int getLineHeight(Font font);

        /** 获取缩放比例 **/
        double getScale();

        /** 获取内边距 **/
        int getPadding();

        /** 获取文本颜色 **/
        int getTextColor();

        /** 获取背景颜色 **/
        int getBackgroundColor();

        /** 是否应该显示 **/
        boolean shouldDisplay();

        /** 获取布局侧边（左侧或右侧）**/
        default LayoutSide getLayoutSide() {
            return LayoutSide.LEFT;
        }

        /** 绘制内容 **/
        void drawContent(GuiGraphics guiGraphics, Font font, int x, int y);
    }

    /** 布局侧边枚举 **/
    public enum LayoutSide {
        LEFT, RIGHT
    }

    /** HUD元素数据记录类 **/
    private record HUDElementData(HUDElement element, String id, UUID playerUuid, long timestamp) { }

    /** 注册的HUD元素列表 **/
    private static final List<HUDElementData> REGISTERED_ELEMENTS = new ArrayList<>();

    /** 元素缓存（左侧）**/
    private static final Map<String, HUDElementData> LEFT_ELEMENT_CACHE = new ConcurrentHashMap<>();

    /** 元素缓存（右侧）**/
    private static final Map<String, HUDElementData> RIGHT_ELEMENT_CACHE = new ConcurrentHashMap<>();

    /**
     * 注册HUD元素
     *
     * @param id 元素ID
     * @param element HUD元素
     * @param playerUuid 玩家UUID
     * @param timestamp 时间戳
     */
    public static void registerElement(String id, HUDElement element, UUID playerUuid, long timestamp) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || !minecraft.player.getUUID().equals(playerUuid)) return;

        HUDElementData data = new HUDElementData(element, id, playerUuid, timestamp);

        // 根据元素的布局侧边选择缓存
        if (element.getLayoutSide() == LayoutSide.RIGHT) {
            RIGHT_ELEMENT_CACHE.put(id, data);
        } else {
            LEFT_ELEMENT_CACHE.put(id, data);
        }
    }

    /**
     * 注销HUD元素
     *
     * @param id 元素ID
     */
    public static void unregisterElement(String id) {
        LEFT_ELEMENT_CACHE.remove(id);
        RIGHT_ELEMENT_CACHE.remove(id);
    }

    /**
     * 清除所有HUD元素
     */
    public static void clearAllElements() {
        LEFT_ELEMENT_CACHE.clear();
        RIGHT_ELEMENT_CACHE.clear();
    }

    /**
     * 在游戏界面上渲染所有HUD元素
     *
     * @param event 渲染GUI事件
     */
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return;

        // 清理过期的元素
        cleanupExpiredElements(minecraft);

        // 渲染左侧HUD元素
        renderSideElements(event, LayoutSide.LEFT, LEFT_ELEMENT_CACHE,
            TBZClientConfig.HUD_LAYOUT_LEFT_RELATIVE_X.get(),
            TBZClientConfig.HUD_LAYOUT_LEFT_RELATIVE_Y.get());

        // 渲染右侧HUD元素
        renderSideElements(event, LayoutSide.RIGHT, RIGHT_ELEMENT_CACHE,
            TBZClientConfig.HUD_LAYOUT_RIGHT_RELATIVE_X.get(),
            TBZClientConfig.HUD_LAYOUT_RIGHT_RELATIVE_Y.get());
    }

    /**
     * 渲染指定侧边的HUD元素
     */
    private static void renderSideElements(RenderGuiEvent.Post event, LayoutSide side,
                                           Map<String, HUDElementData> elementCache,
                                           double relativeX, double relativeY) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return;

        // 获取应该显示的元素
        List<HUDElementData> displayElements = new ArrayList<>();
        for (HUDElementData data : elementCache.values()) {
            if (data.element.shouldDisplay()) {
                displayElements.add(data);
            }
        }

        if (displayElements.isEmpty()) return;

        GuiGraphics guiGraphics = event.getGuiGraphics();
        Font font = minecraft.font;

        // 获取配置参数
        int spacing = TBZClientConfig.HUD_LAYOUT_SPACING.get();
        double maxScreenHeightRatio = TBZClientConfig.HUD_LAYOUT_MAX_SCREEN_HEIGHT_RATIO.get();

        // 获取屏幕尺寸
        int screenWidth = minecraft.getWindow().getGuiScaledWidth();
        int screenHeight = minecraft.getWindow().getGuiScaledHeight();

        // 计算起始位置
        int startX = (int) (screenWidth * relativeX);
        int startY = (int) (screenHeight * relativeY);
        int currentY = startY;

        // 第一遍：计算所有元素的尺寸和总高度
        List<ElementSize> elementSizes = new ArrayList<>();
        int totalHeight = 0;

        for (HUDElementData data : displayElements) {
            HUDElement element = data.element;
            double scale = element.getScale();
            int padding = element.getPadding();

            int textWidth = element.getTextWidth(font);
            int lineHeight = element.getLineHeight(font);

            int scaledTextWidth = (int) (textWidth * scale);
            int scaledLineHeight = (int) (lineHeight * scale);
            int scaledPadding = (int) (padding * scale);

            int elementWidth = scaledTextWidth + scaledPadding * 2;
            int elementHeight = scaledLineHeight + scaledPadding;

            elementSizes.add(new ElementSize(elementWidth, elementHeight, scaledPadding, scale));

            totalHeight += elementHeight;

            if (elementSizes.size() < displayElements.size()) {
                totalHeight += spacing;
            }
        }

        // 检查是否超出最大高度限制
        int maxAllowedHeight = (int) (screenHeight * maxScreenHeightRatio);
        if (totalHeight > maxAllowedHeight) {
            // 超出限制，需要缩放或隐藏部分元素
            for (int i = 0; i < displayElements.size(); i++) {
                HUDElementData data = displayElements.get(i);
                ElementSize size = elementSizes.get(i);

                if (currentY + size.height > startY + maxAllowedHeight) {
                    break; // 超出限制，停止绘制
                }

                drawHUDElement(guiGraphics, font, data.element, startX, currentY, size);
                currentY += size.height + spacing;
            }
        } else {
            // 正常绘制所有元素
            for (int i = 0; i < displayElements.size(); i++) {
                HUDElementData data = displayElements.get(i);
                ElementSize size = elementSizes.get(i);

                drawHUDElement(guiGraphics, font, data.element, startX, currentY, size);
                currentY += size.height + spacing;
            }
        }
    }

    /**
     * 绘制单个HUD元素
     */
    private static void drawHUDElement(GuiGraphics guiGraphics, Font font, HUDElement element, int x, int y, ElementSize size) {
        int bgX = x - size.padding;
        int bgY = y - size.padding / 2;
        int bgWidth = size.width;
        int bgHeight = size.height;

        // 绘制背景
        guiGraphics.fill(bgX, bgY, bgX + bgWidth, bgY + bgHeight, element.getBackgroundColor());

        // 绘制内容
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x, y, 0);
        guiGraphics.pose().scale((float) size.scale, (float) size.scale, 1.0f);
        element.drawContent(guiGraphics, font, 0, 0);
        guiGraphics.pose().popPose();
    }

    /**
     * 清理过期的HUD元素
     */
    private static void cleanupExpiredElements(Minecraft minecraft) {
        long currentTime;
        if (minecraft.player != null) {
            currentTime = minecraft.player.level().getGameTime();
        } else {
            currentTime = 0;
        }
        long timeoutTicks = TBZClientConfig.HUD_LAYOUT_TIMEOUT_SECONDS.get();

        // 清理左侧元素
        LEFT_ELEMENT_CACHE.entrySet().removeIf(entry -> {
            HUDElementData data = entry.getValue();
            return currentTime - data.timestamp > timeoutTicks || !data.element.shouldDisplay();
        });

        // 清理右侧元素
        RIGHT_ELEMENT_CACHE.entrySet().removeIf(entry -> {
            HUDElementData data = entry.getValue();
            return currentTime - data.timestamp > timeoutTicks || !data.element.shouldDisplay();
        });
    }

    /** 元素尺寸数据记录类 **/
    private record ElementSize(int width, int height, int padding, double scale) { }
}