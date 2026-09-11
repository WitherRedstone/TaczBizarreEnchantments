package com.chinaex123.tbz.client.hud;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZClientConfig;
import com.chinaex123.tbz.config.TBZServerConfig;
import net.minecraft.client.Minecraft;
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
 * 持续型附魔状态客户端处理类
 * <p>
 * 功能：在客户端显示附魔的状态信息
 * <p>
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TBZMod.MOD_ID)
public class DurationBasedHUD {

    /** 缓存每个玩家的状态值 **/
    private static final Map<UUID, Integer> VALUE_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的时间戳 **/
    private static final Map<UUID, Long> TIMESTAMP_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的附魔类型 **/
    private static final Map<UUID, String> ENCHANTMENT_TYPE_CACHE = new ConcurrentHashMap<>();
    /** 缓存每个玩家的枪械物品 **/
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

        // 创建HUD元素并注册到布局管理器
        HUDLayoutManager.HUDElement hudElement = createHUDElement(enchantmentType, value, timestamp, gunItem);
        if (hudElement != null) {
            String elementId = "enchantment_" + enchantmentType;
            HUDLayoutManager.registerElement(elementId, hudElement, playerUuid, timestamp);
        }
    }

    /**
     * 创建HUD元素
     */
    private static HUDLayoutManager.HUDElement createHUDElement(String enchantmentType, int value, long timestamp, ItemStack gunItem) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return null;
        
        // 根据附魔类型获取配置和文本
        int colorText;
        int colorBackground;
        int padding;
        double scale;
        String translationKey;
        Object[] translationArgs;

        switch (enchantmentType) {
            // 目标锁定
            case "target_lock" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.TARGET_LOCK_HUD_COLOR_BACKGROUND.get());
                padding = TBZClientConfig.HUD_COMMON_PADDING.get();
                scale = TBZClientConfig.HUD_COMMON_SCALE.get();
                translationKey = "gui.tbz.target_lock";
                translationArgs = new Object[]{value};
            }
            // 斗剑士
            case "swashbuckler" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.SWASHBUCKLER_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.SWASHBUCKLER_COLOR_BACKGROUND.get());
                padding = TBZClientConfig.HUD_COMMON_PADDING.get();
                scale = TBZClientConfig.HUD_COMMON_SCALE.get();
                translationKey = "gui.tbz.swashbuckler";
                translationArgs = new Object[]{value};
            }
            // 我为人人
            case "one_for_all" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.ONE_FOR_ALL_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.ONE_FOR_ALL_COLOR_BACKGROUND.get());
                padding = TBZClientConfig.HUD_COMMON_PADDING.get();
                scale = TBZClientConfig.HUD_COMMON_SCALE.get();
                translationKey = "gui.tbz.one_for_all";
                int remainingSeconds = calculateRemainingSeconds(timestamp, TBZServerConfig.ONE_FOR_ALL_DURATION_SECONDS.get());
                translationArgs = new Object[]{value, remainingSeconds};
            }
            // 武器大师
            case "master_of_arms" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.MASTER_OF_ARMS_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.MASTER_OF_ARMS_COLOR_BACKGROUND.get());
                padding = TBZClientConfig.HUD_COMMON_PADDING.get();
                scale = TBZClientConfig.HUD_COMMON_SCALE.get();
                translationKey = "gui.tbz.master_of_arms";
                int duration = value == 2 ? TBZServerConfig.MASTER_OF_ARMS_STACK_2_DURATION_SECONDS.get() : TBZServerConfig.MASTER_OF_ARMS_STACK_1_DURATION_SECONDS.get();
                int remainingSeconds = calculateRemainingSeconds(timestamp, duration);
                translationArgs = new Object[]{value, remainingSeconds};
            }
            // 爆炸光能
            case "explosive_light" -> {
                colorText = TBZClientConfig.parseColor(TBZClientConfig.EXPLOSIVE_LIGHT_COLOR_TEXT.get());
                colorBackground = TBZClientConfig.parseColor(TBZClientConfig.EXPLOSIVE_LIGHT_COLOR_BACKGROUND.get());
                padding = TBZClientConfig.HUD_COMMON_PADDING.get();
                scale = TBZClientConfig.HUD_COMMON_SCALE.get();
                translationKey = "gui.tbz.explosive_light";
                int stacks = (value >> 16) & 0xFFFF;
                int accumulatedXp = value & 0xFFFF;
                translationArgs = new Object[]{stacks, accumulatedXp};
            }
            default -> {
                return null; // 未知类型，不显示
            }
        }

        // 准备显示文本
        String text = Component.translatable(translationKey, translationArgs).getString();

        // 使用工厂类创建HUD元素
        return HUDElementFactory.createHUDElement(
            text,
            colorText,
            colorBackground,
            padding,
            scale,
            HUDLayoutManager.LayoutSide.LEFT,
            () -> !shouldClearStatus(enchantmentType, value, timestamp, gunItem)
        );
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
                long timeoutTicks = (long) (TBZServerConfig.TARGET_LOCK_TIMEOUT_SECONDS.get());
                return currentTime - timestamp > timeoutTicks;
            }
            // 斗剑士：层数为0或超时
            case "swashbuckler" -> {
                if (value == 0) return true;
                long timeoutTicks = (long) (TBZServerConfig.SWASHBUCKLER_DECREASE_INTERVAL_TICKS.get());
                return currentTime - timestamp > timeoutTicks;
            }
            // 我为人人：层数为0或超时
            case "one_for_all" -> {
                if (value == 0) return true;
                long timeoutTicks = (long) (TBZServerConfig.ONE_FOR_ALL_DURATION_SECONDS.get());
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