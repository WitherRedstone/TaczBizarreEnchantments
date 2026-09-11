package com.chinaex123.tbz.client.hud;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.BooleanSupplier;

/**
 * HUD元素工厂类
 * <p>
 * 提供静态工厂方法用于创建各种HUD元素实例
 * 通过封装通用的创建逻辑，避免在多个地方重复编写匿名内部类
 */
@OnlyIn(Dist.CLIENT)
public class HUDElementFactory {

    /**
     * 创建基础的HUD元素实例
     * <p>
     * 该方法封装了HUDElement所有接口方法的默认实现，
     * 调用方只需提供必要的显示参数和显示逻辑即可快速创建HUD元素
     *
     * @param text 要显示的文本内容，支持颜色代码（§）和格式化代码
     * @param colorText 文本颜色值（ARGB格式的int值），例如 0xFFFFFF 表示白色
     * @param colorBackground 背景颜色值（ARGB格式的int值），0x00000000 表示透明背景
     * @param padding 元素内边距（像素），控制文本与边框之间的间距
     * @param scale 缩放比例，控制元素在屏幕上的显示大小，1.0为原始大小
     * @param layoutSide 布局侧边位置，决定元素在HUD上显示的位置（如左上、右下等）
     * @param shouldDisplaySupplier 是否显示的判断函数式接口，通过Lambda表达式或方法引用传入动态判断逻辑
     * @return 配置好的HUDElement实例，可直接注册到HUDLayoutManager中使用
     */
    public static HUDLayoutManager.HUDElement createHUDElement(
            String text,
            int colorText,
            int colorBackground,
            int padding,
            double scale,
            HUDLayoutManager.LayoutSide layoutSide,
            BooleanSupplier shouldDisplaySupplier) {

        // 创建并返回一个匿名HUDElement实例
        // 所有方法都使用外部传入的参数或默认实现
        return new HUDLayoutManager.HUDElement() {

            /**
             * 获取显示文本
             * @return 返回工厂方法传入的文本内容
             */
            @Override
            public String getText() {
                return text;
            }

            /**
             * 计算文本宽度
             * 用于HUD布局系统确定元素水平方向占用的空间
             * @param font Minecraft字体对象，用于测量文本尺寸
             * @return 文本的像素宽度
             */
            @Override
            public int getTextWidth(Font font) {
                return font.width(text);
            }

            /**
             * 获取文本行高
             * 用于HUD布局系统确定元素垂直方向占用的空间
             * @param font Minecraft字体对象
             * @return 当前字体的行高（像素值）
             */
            @Override
            public int getLineHeight(Font font) {
                return font.lineHeight;
            }

            /**
             * 获取缩放比例
             * @return 工厂方法传入的缩放值
             */
            @Override
            public double getScale() {
                return scale;
            }

            /**
             * 获取内边距
             * @return 工厂方法传入的内边距值
             */
            @Override
            public int getPadding() {
                return padding;
            }

            /**
             * 获取文本颜色
             * @return 工厂方法传入的文本颜色值
             */
            @Override
            public int getTextColor() {
                return colorText;
            }

            /**
             * 获取背景颜色
             * @return 工厂方法传入的背景颜色值
             */
            @Override
            public int getBackgroundColor() {
                return colorBackground;
            }

            /**
             * 判断元素是否应该显示
             * 委托给外部传入的BooleanSupplier进行动态判断
             * 支持基于游戏状态、时间、玩家属性等动态条件控制显示
             * @return true表示显示，false表示隐藏
             */
            @Override
            public boolean shouldDisplay() {
                return shouldDisplaySupplier.getAsBoolean();
            }

            /**
             * 获取布局侧边位置
             * 决定该元素在HUD上的停靠位置
             * @return 工厂方法传入的布局侧边枚举值
             */
            @Override
            public HUDLayoutManager.LayoutSide getLayoutSide() {
                return layoutSide;
            }

            /**
             * 绘制HUD元素内容
             * 在指定位置渲染文本内容
             * <p>
             * 注意：x和y参数由HUD布局系统根据layoutSide和元素尺寸自动计算，
             * 但此处始终在(0,0)位置绘制，因为x和y已经代表了相对于布局位置的偏移
             *
             * @param guiGraphics GUI绘制上下文，提供绘图API
             * @param font 用于渲染文本的字体
             * @param x 绘制位置的X坐标（相对于布局锚点）
             * @param y 绘制位置的Y坐标（相对于布局锚点）
             */
            @Override
            public void drawContent(GuiGraphics guiGraphics, Font font, int x, int y) {
                // 在(0,0)位置绘制文本，偏移量由HUD布局系统通过x,y参数处理
                guiGraphics.drawString(font, text, 0, 0, colorText);
            }
        };
    }
}