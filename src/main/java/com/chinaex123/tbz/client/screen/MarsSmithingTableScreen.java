package com.chinaex123.tbz.client.screen;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.menu.MarsSmithingTableMenu;
import com.chinaex123.tbz.network.MarsSmithingTablePacket;
import com.chinaex123.tbz.network.PacketHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * 火星锻造台屏幕渲染
 * <p>
 * 功能：渲染锻造台GUI界面，包括背景纹理、槽位和操作按钮
 * <p>
 * 界面布局：
 * <ol>
 *   <li>背景纹理：mars_smithing_table.png</li>
 *   <li>闪电按钮：位于界面中央（⚡），点击后触发锻造操作</li>
 *   <li>物品槽位：由父类 AbstractContainerScreen 管理</li>
 * </ol>
 */
public class MarsSmithingTableScreen extends AbstractContainerScreen<MarsSmithingTableMenu> {

    /** 界面背景纹理路径 */
    private static final ResourceLocation TEXTURE = TBZMod.id("textures/gui/mars_smithing_table.png");

    /**
     * 构造锻造台屏幕
     * 设置界面宽高
     *
     * @param menu             菜单容器
     * @param playerInventory  玩家背包
     * @param title            界面标题
     */
    public MarsSmithingTableScreen(MarsSmithingTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    /**
     * 初始化屏幕
     * 添加自定义闪电按钮，点击后向服务端发送锻造请求数据包
     */
    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(new CustomButton(this.leftPos + 80, this.topPos + 35, 16, 16, Component.literal("⚡"), button -> {
            PacketHandler.INSTANCE.sendToServer(new MarsSmithingTablePacket(menu.getBlockEntity().getBlockPos()));
        }));
    }

    /**
     * 自定义按钮渲染
     * 用于触发锻造操作，包含悬停高亮和边框效果
     */
    private class CustomButton extends Button {
        /** 常态背景色 */
        private static final int NORMAL_COLOR = new Color(90, 94, 120).getRGB();
        /** 悬停背景色 */
        private static final int HOVER_COLOR = new Color(122, 126, 152).getRGB();
        /** 文本颜色 */
        private static final int TEXT_COLOR = new Color(224, 228, 248).getRGB();
        /** 边框颜色 */
        private static final int BORDER_COLOR = new Color(58, 62, 88).getRGB();

        /**
         * 构造自定义按钮
         *
         * @param x       按钮X坐标
         * @param y       按钮Y坐标
         * @param width   按钮宽度
         * @param height  按钮高度
         * @param message 按钮显示的文本
         * @param onPress 点击回调
         */
        public CustomButton(int x, int y, int width, int height, Component message, OnPress onPress) {
            super(x, y, width, height, message, onPress, Button.DEFAULT_NARRATION);
        }

        /**
         * 渲染自定义按钮
         * 绘制背景色、边框和居中文本，悬停时显示高亮效果
         *
         * @param guiGraphics 图形渲染上下文
         * @param mouseX      鼠标X坐标
         * @param mouseY      鼠标Y坐标
         * @param partialTick 部分帧渲染时间
         */
        @Override
        public void renderWidget(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            int backgroundColor = isHovered ? HOVER_COLOR : NORMAL_COLOR;

            // 填充背景色
            guiGraphics.fill(getX(), getY(), getX() + width, getY() + height, backgroundColor);
            // 绘制边框（左、右、上、下）
            guiGraphics.fill(getX(), getY(), getX() + 1, getY() + height, BORDER_COLOR);
            guiGraphics.fill(getX() + width - 1, getY(), getX() + width, getY() + height, BORDER_COLOR);
            guiGraphics.fill(getX(), getY(), getX() + width, getY() + 1, BORDER_COLOR);
            guiGraphics.fill(getX(), getY() + height - 1, getX() + width, getY() + height, BORDER_COLOR);

            // 绘制文本（悬停时显示亮白色）
            int textColor = isHovered ? 0xFFFFFF : TEXT_COLOR;
            guiGraphics.drawCenteredString(font, getMessage(), getX() + width / 2, getY() + (height - 8) / 2, textColor);
        }
    }

    /**
     * 渲染背景
     * 绘制锻造台界面的背景纹理
     *
     * @param guiGraphics 图形渲染上下文
     * @param partialTick 部分帧渲染时间
     * @param mouseX      鼠标X坐标
     * @param mouseY      鼠标Y坐标
     */
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    /**
     * 渲染主屏幕
     * 依次渲染背景、父级内容（槽位等）和提示信息
     *
     * @param guiGraphics 图形渲染上下文
     * @param mouseX      鼠标X坐标
     * @param mouseY      鼠标Y坐标
     * @param partialTick 部分帧渲染时间
     */
    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    /**
     * 渲染文字标签
     * 在界面上绘制标题和玩家背包标题
     *
     * @param guiGraphics 图形渲染上下文
     * @param mouseX      鼠标X坐标
     * @param mouseY      鼠标Y坐标
     */
    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, 8, 6, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, 72, 4210752, false);
    }
}