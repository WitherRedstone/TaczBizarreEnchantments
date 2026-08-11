//package com.chinaex123.tbz.client.hud;
//
//import com.chinaex123.tbz.TBZMod;
//import com.chinaex123.tbz.config.TBZClientConfig;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.Font;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.client.event.RenderGuiEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 目标信息客户端处理类
// * <p>
// * 功能：在客户端显示目标的健康值和距离信息
// */
//@OnlyIn(Dist.CLIENT)
//@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
//public class TargetInfoHUD {
//
//    private static final Map<UUID, Float> HEALTH_CACHE = new ConcurrentHashMap<>();
//    private static final Map<UUID, Float> MAX_HEALTH_CACHE = new ConcurrentHashMap<>();
//    private static final Map<UUID, Double> DISTANCE_CACHE = new ConcurrentHashMap<>();
//    private static final Map<UUID, Long> TIMESTAMP_CACHE = new ConcurrentHashMap<>();
//    private static final int DISPLAY_DURATION_TICKS = 60;
//
//    public static void setTargetInfo(UUID playerUuid, float health, float maxHealth, double distance, long timestamp) {
//        Minecraft minecraft = Minecraft.getInstance();
//        if (minecraft.player != null && minecraft.player.getUUID().equals(playerUuid)) {
//            HEALTH_CACHE.put(playerUuid, health);
//            MAX_HEALTH_CACHE.put(playerUuid, maxHealth);
//            DISTANCE_CACHE.put(playerUuid, distance);
//            TIMESTAMP_CACHE.put(playerUuid, timestamp);
//        }
//    }
//
//    @SubscribeEvent
//    public static void onRenderGui(RenderGuiEvent.Post event) {
//        Minecraft minecraft = Minecraft.getInstance();
//        if (minecraft.player == null || minecraft.screen != null) return;
//
//        UUID playerUuid = minecraft.player.getUUID();
//        Long timestamp = TIMESTAMP_CACHE.get(playerUuid);
//        if (timestamp == null) return;
//
//        long currentTime = 0;
//        if (minecraft.level != null) {
//            currentTime = minecraft.level.getGameTime();
//        }
//        if (currentTime - timestamp > DISPLAY_DURATION_TICKS) {
//            clearTargetInfo(playerUuid);
//            return;
//        }
//
//        Float health = HEALTH_CACHE.get(playerUuid);
//        Float maxHealth = MAX_HEALTH_CACHE.get(playerUuid);
//        Double distance = DISTANCE_CACHE.get(playerUuid);
//        if (health == null || maxHealth == null || distance == null) return;
//
//        Font font = minecraft.font;
//        GuiGraphics guiGraphics = event.getGuiGraphics();
//
//        int colorText = TBZClientConfig.parseColor(TBZClientConfig.PERSONAL_ASSISTANT_COLOR_TEXT.get());
//        int colorBackground = TBZClientConfig.parseColor(TBZClientConfig.PERSONAL_ASSISTANT_COLOR_BACKGROUND.get());
//        double relativeX = TBZClientConfig.PERSONAL_ASSISTANT_RELATIVE_X.get();
//        double relativeY = TBZClientConfig.PERSONAL_ASSISTANT_RELATIVE_Y.get();
//        int padding = TBZClientConfig.PERSONAL_ASSISTANT_PADDING.get();
//        double scale = TBZClientConfig.PERSONAL_ASSISTANT_SCALE.get();
//
//        int screenWidth = minecraft.getWindow().getGuiScaledWidth();
//        int screenHeight = minecraft.getWindow().getGuiScaledHeight();
//
//        int displayX = (int) (screenWidth * relativeX);
//        int displayY = (int) (screenHeight * relativeY);
//
//        String healthText = Component.translatable("gui.tbz.personal_assistant.health", String.format("%.1f", health), String.format("%.1f", maxHealth)).getString();
//        String distanceText = Component.translatable("gui.tbz.personal_assistant.distance", String.format("%.1f", distance)).getString();
//
//        int lineHeight = font.lineHeight;
//        int textWidth = Math.max(font.width(healthText), font.width(distanceText));
//        int boxWidth = (int) (textWidth * scale) + padding * 2;
//        int boxHeight = (int) (lineHeight * 2 * scale) + padding * 2;
//
//        guiGraphics.fill(displayX, displayY, displayX + boxWidth, displayY + boxHeight, colorBackground);
//
//        guiGraphics.pose().pushPose();
//        guiGraphics.pose().translate(displayX + padding, displayY + padding, 0);
//        guiGraphics.pose().scale((float) scale, (float) scale, 1.0F);
//
//        guiGraphics.drawString(font, healthText, 0, 0, colorText);
//        guiGraphics.drawString(font, distanceText, 0, lineHeight, colorText);
//
//        guiGraphics.pose().popPose();
//    }
//
//    public static void clearTargetInfo(UUID playerUuid) {
//        HEALTH_CACHE.remove(playerUuid);
//        MAX_HEALTH_CACHE.remove(playerUuid);
//        DISTANCE_CACHE.remove(playerUuid);
//        TIMESTAMP_CACHE.remove(playerUuid);
//    }
//}