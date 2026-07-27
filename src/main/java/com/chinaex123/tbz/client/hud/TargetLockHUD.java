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

import static com.chinaex123.tbz.event.enchantments.TargetLockEvent.TIMEOUT_TICKS;

/**
 * 目标锁定客户端处理类
 * <p>
 * 功能：在客户端显示目标锁定伤害加成层数的HUD
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
public class TargetLockHUD {

    /** 缓存每个玩家的目标锁定伤害加成层数 **/
    private static final Map<UUID, Integer> TARGET_LOCK_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的最后命中时间 **/
    private static final Map<UUID, Long> LAST_HIT_TIME_CACHE = new ConcurrentHashMap<>();

    /**
     * 设置指定玩家的目标锁定伤害加成层数
     * 仅在客户端玩家自身匹配时更新缓存
     *
     * @param playerUuid 玩家UUID
     * @param damageStack 伤害加成层数
     * @param lastHitTime 最后命中时间
     */
    public static void setTargetLockDamageStack(UUID playerUuid, int damageStack, long lastHitTime) {
        Minecraft minecraft = Minecraft.getInstance();
        // 只缓存本地玩家的数据
        if (minecraft.player != null && minecraft.player.getUUID().equals(playerUuid)) {
            TARGET_LOCK_CACHE.put(playerUuid, damageStack);
            LAST_HIT_TIME_CACHE.put(playerUuid, lastHitTime);
        }
    }

    /**
     * 清除指定玩家的目标锁定数据
     *
     * @param playerUuid 玩家UUID
     */
    public static void clearTargetLock(UUID playerUuid) {
        TARGET_LOCK_CACHE.remove(playerUuid);
        LAST_HIT_TIME_CACHE.remove(playerUuid);
    }

    /**
     * 在游戏界面上渲染目标锁定层数显示
     * 在游戏画面渲染结束后绘制HUD
     *
     * @param event 渲染GUI事件
     */
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return;

        UUID playerUuid = minecraft.player.getUUID();
        Integer damageStack = TARGET_LOCK_CACHE.get(playerUuid);
        Long lastHitTime = LAST_HIT_TIME_CACHE.get(playerUuid);

        // 如果没有伤害加成层数或层数为0，不显示
        if (damageStack == null || damageStack <= 0) return;

        // 检查是否超时（停止射击超过1秒）
        if (lastHitTime == null) return;
        long currentTime = minecraft.player.level().getGameTime();
        if (currentTime - lastHitTime > TIMEOUT_TICKS) {
            // 超时，清除缓存并返回
            clearTargetLock(playerUuid);
            return;
        }

        GuiGraphics guiGraphics = event.getGuiGraphics();
        Font font = minecraft.font;

        // 从配置读取显示参数
        int colorText = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_TEXT.get());
        int colorBackground = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_BACKGROUND.get());
        int displayX = TBZClientConfig.TARGET_LOCK_HUD_DISPLAY_X.get();
        int displayY = TBZClientConfig.TARGET_LOCK_HUD_DISPLAY_Y.get();
        int padding = TBZClientConfig.TARGET_LOCK_HUD_PADDING.get();
        double scale = TBZClientConfig.TARGET_LOCK_HUD_SCALE.get();

        // 准备显示文本
        String text = Component.translatable("gui.tbz.target_lock", damageStack).getString();
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