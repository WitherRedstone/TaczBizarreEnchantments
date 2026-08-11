package com.chinaex123.tbz.client.hud;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZClientConfig;
import com.chinaex123.tbz.config.TBZServerConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 附魔状态客户端处理类
 * <p>
 * 功能：在客户端显示附魔的状态信息
 * <p>
 * 支持的附魔类型：
 * <ul>
 *   <li>target_lock - 目标锁定</li>
 *   <li>swashbuckler - 斗剑士</li>
 *   <li>one_for_all - 我为人人</li>
 *   <li>master_of_arms - 武器大师</li>
 *   <li>explosive_light - 爆炸光能</li>
 * </ul>
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
public class EnchantmentStatusHUD {

    /** 缓存每个玩家的状态值 **/
    private static final Map<UUID, Integer> VALUE_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的时间戳 **/
    private static final Map<UUID, Long> TIMESTAMP_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的附魔类型 **/
    private static final Map<UUID, String> ENCHANTMENT_TYPE_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的枪械物品（武器大师需要） **/
    private static final Map<UUID, ItemStack> GUN_ITEM_CACHE = new ConcurrentHashMap<>();

    /**
     * 设置指定玩家的附魔状态
     * 仅在客户端玩家自身匹配时更新缓存
     *
     * @param playerUuid 玩家UUID
     * @param enchantmentType 附魔类型
     * @param value 状态值
     * @param timestamp 时间戳
     * @param gunItem 枪械物品
     */
    public static void setEnchantmentStatus(UUID playerUuid, String enchantmentType, int value, long timestamp, ItemStack gunItem) {
        Minecraft minecraft = Minecraft.getInstance();
        // 只缓存本地玩家的数据
        if (minecraft.player != null && minecraft.player.getUUID().equals(playerUuid)) {
            VALUE_CACHE.put(playerUuid, value);
            TIMESTAMP_CACHE.put(playerUuid, timestamp);
            ENCHANTMENT_TYPE_CACHE.put(playerUuid, enchantmentType);
            if (!gunItem.isEmpty()) {
                GUN_ITEM_CACHE.put(playerUuid, gunItem);
            }
        }
    }

    /**
     * 清除指定玩家的附魔状态
     *
     * @param playerUuid 玩家UUID
     */
    public static void clearEnchantmentStatus(UUID playerUuid) {
        VALUE_CACHE.remove(playerUuid);
        TIMESTAMP_CACHE.remove(playerUuid);
        ENCHANTMENT_TYPE_CACHE.remove(playerUuid);
        GUN_ITEM_CACHE.remove(playerUuid);
    }

    /**
     * 在游戏界面上渲染附魔状态显示
     * 在游戏画面渲染结束后绘制HUD
     *
     * @param event 渲染GUI事件
     */
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return;

        UUID playerUuid = minecraft.player.getUUID();
        Integer value = VALUE_CACHE.get(playerUuid);
        Long timestamp = TIMESTAMP_CACHE.get(playerUuid);
        String enchantmentType = ENCHANTMENT_TYPE_CACHE.get(playerUuid);
        ItemStack gunItem = GUN_ITEM_CACHE.get(playerUuid);

        // 如果没有数据，不显示
        if (value == null || timestamp == null || enchantmentType == null) return;

        // 检查是否应该清除状态
        if (shouldClearStatus(enchantmentType, value, timestamp, gunItem)) {
            clearEnchantmentStatus(playerUuid);
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
        Object[] translationArgs;

        switch (enchantmentType) {
            // 目标锁定
            case "target_lock" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.TARGET_LOCK_HUD_RELATIVE_X.get();
                relativeY = TBZClientConfig.TARGET_LOCK_HUD_RELATIVE_Y.get();
                padding = TBZClientConfig.TARGET_LOCK_HUD_PADDING.get();
                scale = TBZClientConfig.TARGET_LOCK_HUD_SCALE.get();
                translationKey = "gui.tbz.target_lock";
                translationArgs = new Object[]{value};
            }
            // 斗剑士
            case "swashbuckler" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.SWASHBUCKLER_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.SWASHBUCKLER_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.SWASHBUCKLER_RELATIVE_X.get();
                relativeY = TBZClientConfig.SWASHBUCKLER_RELATIVE_Y.get();
                padding = TBZClientConfig.SWASHBUCKLER_PADDING.get();
                scale = TBZClientConfig.SWASHBUCKLER_SCALE.get();
                translationKey = "gui.tbz.swashbuckler";
                translationArgs = new Object[]{value};
            }
            // 我为人人
            case "one_for_all" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.ONE_FOR_ALL_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.ONE_FOR_ALL_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.ONE_FOR_ALL_RELATIVE_X.get();
                relativeY = TBZClientConfig.ONE_FOR_ALL_RELATIVE_Y.get();
                padding = TBZClientConfig.ONE_FOR_ALL_PADDING.get();
                scale = TBZClientConfig.ONE_FOR_ALL_SCALE.get();
                translationKey = "gui.tbz.one_for_all";
                int remainingSeconds = calculateRemainingSeconds(timestamp, TBZServerConfig.ONE_FOR_ALL_DURATION_SECONDS.get());
                translationArgs = new Object[]{value, remainingSeconds};
            }
            // 武器大师
            case "master_of_arms" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.MASTER_OF_ARMS_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.MASTER_OF_ARMS_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.MASTER_OF_ARMS_RELATIVE_X.get();
                relativeY = TBZClientConfig.MASTER_OF_ARMS_RELATIVE_Y.get();
                padding = TBZClientConfig.MASTER_OF_ARMS_PADDING.get();
                scale = TBZClientConfig.MASTER_OF_ARMS_SCALE.get();
                translationKey = "gui.tbz.master_of_arms";
                double duration = value == 2 ? TBZServerConfig.MASTER_OF_ARMS_STACK_2_DURATION_SECONDS.get() : TBZServerConfig.MASTER_OF_ARMS_STACK_1_DURATION_SECONDS.get();
                int remainingSeconds = calculateRemainingSeconds(timestamp, duration);
                translationArgs = new Object[]{value, remainingSeconds};
            }
            // 爆炸光能
            case "explosive_light" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.EXPLOSIVE_LIGHT_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.EXPLOSIVE_LIGHT_COLOR_BACKGROUND.get());
                relativeX = TBZClientConfig.EXPLOSIVE_LIGHT_RELATIVE_X.get();
                relativeY = TBZClientConfig.EXPLOSIVE_LIGHT_RELATIVE_Y.get();
                padding = TBZClientConfig.EXPLOSIVE_LIGHT_PADDING.get();
                scale = TBZClientConfig.EXPLOSIVE_LIGHT_SCALE.get();
                translationKey = "gui.tbz.explosive_light";
                int stacks = (value >> 16) & 0xFFFF;
                int accumulatedXp = value & 0xFFFF;
                translationArgs = new Object[]{stacks, accumulatedXp};
            }
            default -> {
                return; // 未知类型，不显示
            }
        }

        // 获取屏幕尺寸
        int screenWidth = minecraft.getWindow().getGuiScaledWidth();
        int screenHeight = minecraft.getWindow().getGuiScaledHeight();

        // 使用相对位置（百分比）
        int displayX = (int) (screenWidth * relativeX);
        int displayY = (int) (screenHeight * relativeY);

        // 准备显示文本
        String text = Component.translatable(translationKey, translationArgs).getString();
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

    /**
     * 计算剩余秒数
     *
     * @param startTime 开始时间（游戏刻）
     * @param durationSeconds 持续时间（秒）
     * @return 剩余秒数
     */
    private static int calculateRemainingSeconds(long startTime, double durationSeconds) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return 0;

        long currentTime = minecraft.player.level().getGameTime();
        long durationTicks = (long) (durationSeconds * 20);
        long remainingTicks = durationTicks - (currentTime - startTime);
        return (int) Math.max(0, Math.ceil(remainingTicks / 20.0));
    }

    /**
     * 检查是否应该清除状态
     *
     * @param enchantmentType 附魔类型
     * @param value 状态值
     * @param timestamp 时间戳
     * @param gunItem 枪械物品
     * @return 是否应该清除
     */
    private static boolean shouldClearStatus(String enchantmentType, int value, long timestamp, ItemStack gunItem) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return true;

        long currentTime = minecraft.player.level().getGameTime();

        switch (enchantmentType) {
            // 目标锁定：层数为0或超时
            case "target_lock" -> {
                if (value == 0) return true;
                long timeoutTicks = (long) (TBZServerConfig.TARGET_LOCK_TIMEOUT_SECONDS.get() * 20);
                return currentTime - timestamp > timeoutTicks;
            }
            // 斗剑士：层数为0或超时
            case "swashbuckler" -> {
                if (value == 0) return true;
                long timeoutTicks = (long) (TBZServerConfig.SWASHBUCKLER_DECREASE_INTERVAL_SECONDS.get() * 20);
                return currentTime - timestamp > timeoutTicks;
            }
            // 我为人人：层数为0或超时
            case "one_for_all" -> {
                if (value == 0) return true;
                long timeoutTicks = (long) (TBZServerConfig.ONE_FOR_ALL_DURATION_SECONDS.get() * 20);
                return currentTime - timestamp > timeoutTicks;
            }
            // 武器大师：层数为0或超时或枪械不匹配
            case "master_of_arms" -> {
                if (value == 0) return true;
                if (gunItem == null || gunItem.isEmpty()) return true;
                ItemStack currentGun = minecraft.player.getMainHandItem();
                if (!ItemStack.isSameItem(currentGun, gunItem)) return true;
                double duration = value == 2 ? TBZServerConfig.MASTER_OF_ARMS_STACK_2_DURATION_SECONDS.get() : TBZServerConfig.MASTER_OF_ARMS_STACK_1_DURATION_SECONDS.get();
                long timeoutTicks = (long) (duration * 20);
                return currentTime - timestamp > timeoutTicks;
            }
            // 爆炸光能：层数为0时清除
            case "explosive_light" -> {
                return value == 0;
            }
            default -> {
                return true;
            }
        }
    }
}