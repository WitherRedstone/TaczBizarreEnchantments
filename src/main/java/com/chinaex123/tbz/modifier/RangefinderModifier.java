//package com.chinaex123.tbz.modifier;
//
//import com.chinaex123.tbz.TBZMod;
//import com.chinaex123.tbz.config.TBZServerConfig;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.chinaex123.tbz.network.AimingState;
//import com.google.gson.annotations.SerializedName;
//import com.tacz.guns.api.GunProperty;
//import com.tacz.guns.api.modifier.CacheValue;
//import com.tacz.guns.api.modifier.IAttachmentModifier;
//import com.tacz.guns.api.modifier.JsonProperty;
//import com.tacz.guns.resource.CommonAssetsManager;
//import com.tacz.guns.resource.pojo.data.attachment.Modifier;
//import com.tacz.guns.resource.pojo.data.gun.GunData;
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import javax.annotation.Nullable;
//import java.util.List;
//
///**
// * 测距仪 Modifier
// * 用于存储和获取测距仪附魔的射程扩展倍率
// */
//public class RangefinderModifier implements IAttachmentModifier<RangefinderModifier.RangefinderModifierData, Float> {
//
//    // GunProperty对象，用于TACZ缓存系统的key
//    public static final GunProperty<Float> PROPERTY = new GunProperty<>("RangefinderRangeMultiplier", Float.class);
//
//    // 缓存ID，用于标识
//    public static final String ID = "RangefinderRangeMultiplier";
//
//    // 默认射程扩展倍率
//    private static final float DEFAULT_MULTIPLIER = 1.0f;
//
//    @Override
//    public String getId() {
//        return ID;
//    }
//
//    /**
//     * 获取GunProperty对象
//     * 用于TACZ缓存系统的key
//     */
//    public static GunProperty<Float> getProperty() {
//        return PROPERTY;
//    }
//
//    @Override
//    public JsonProperty<RangefinderModifierData> readJson(String json) {
//        // 测距仪附魔不需要从JSON读取配置，返回空数据
//        RangefinderModifier.Data data = CommonAssetsManager.GSON.fromJson(json, RangefinderModifier.Data.class);
//        return new RangefinderModifier.RangefinderJsonProperty(data.getRangefinderModifier());
//    }
//
//    @Override
//    public CacheValue<Float> initCache(ItemStack gunItem, GunData gunData) {
//        // 初始化时存储默认倍率1.0f
//        TBZMod.LOGGER.info("[RangefinderModifier] initCache: 初始化缓存，默认倍率: {}", DEFAULT_MULTIPLIER);
//        return new CacheValue<>(DEFAULT_MULTIPLIER);
//    }
//
//    @Override
//    public void eval(List<RangefinderModifierData> modifiers, CacheValue<Float> cache) {
//        // 获取当前玩家（从Minecraft实例）
//        Player player = net.minecraft.client.Minecraft.getInstance().player;
//        if (player == null) {
//            TBZMod.LOGGER.info("[RangefinderModifier] eval: 玩家为null，使用默认倍率");
//            cache.setValue(DEFAULT_MULTIPLIER);
//            return;
//        }
//
//        // 获取当前射程扩展倍率
//        float currentMultiplier = (float) getRangeMultiplier(player);
//
//        // 更新缓存值
//        cache.setValue(currentMultiplier);
//        TBZMod.LOGGER.info("[RangefinderModifier] eval: 缓存更新成功，玩家: {}, 倍率: {}", player.getName().getString(), currentMultiplier);
//    }
//
//    @Override
//    @OnlyIn(Dist.CLIENT)
//    public int getDiagramsDataSize() {
//        return 0; // 测距仪显示由GunPropertyDiagramsMixin自行处理
//    }
//
//    /**
//     * 获取射程扩展倍率
//     * 如果玩家正在瞄准且持有测距仪附魔的武器，则返回扩展倍率
//     * 否则返回1.0
//     *
//     * @param player 玩家对象
//     * @return 射程扩展倍率
//     */
//    public static double getRangeMultiplier(Player player) {
//        if (player == null) {
//            TBZMod.LOGGER.info("[RangefinderModifier] getRangeMultiplier: 玩家为null，返回1.0");
//            return 1.0;
//        }
//
//        // 获取玩家主手武器
//        ItemStack gun = player.getMainHandItem();
//        if (gun.isEmpty()) {
//            TBZMod.LOGGER.info("[RangefinderModifier] getRangeMultiplier: 主手武器为空，返回1.0");
//            return 1.0;
//        }
//
//        // 检查是否有测距仪附魔
//        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
//        if (enchantLevel <= 0) {
//            TBZMod.LOGGER.info("[RangefinderModifier] getRangeMultiplier: 没有测距仪附魔，返回1.0");
//            return 1.0;
//        }
//
//        // 获取玩家的瞄准状态
//        boolean isAiming = AimingState.isAiming(player);
//        if (!isAiming) {
//            TBZMod.LOGGER.info("[RangefinderModifier] getRangeMultiplier: 玩家未瞄准，返回1.0");
//            return 1.0;
//        }
//
//        // 计算射程扩展倍率
//        double rangeExtension = TBZServerConfig.RANGEFINDER_ADS_RANGE_BONUS.get().doubleValue();
//        double multiplier = 1.0 + (rangeExtension * enchantLevel);
//        TBZMod.LOGGER.info("[RangefinderModifier] getRangeMultiplier: 测距仪附魔等级: {}, 射程扩展倍率: {}", enchantLevel, multiplier);
//        return multiplier;
//    }
//
//    /**
//     * 测距仪修改器数据
//     * 按照TACZ标准模式，简化为单个Modifier
//     */
//    public static class RangefinderModifierData {
//        @SerializedName("range_multiplier")
//        private Modifier rangeMultiplier = null;
//
//        public Modifier getRangeMultiplier() {
//            return rangeMultiplier;
//        }
//    }
//
//    public static class RangefinderJsonProperty extends JsonProperty<RangefinderModifierData> {
//        public RangefinderJsonProperty(RangefinderModifierData value) {
//            super(value);
//        }
//
//        @Override
//        public void initComponents() {
//            RangefinderModifierData value = getValue();
//            if (value != null && value.getRangeMultiplier() != null) {
//                components.add(Component.translatable("tooltip.tbz.enchantment.rangefinder.range_change").withStyle(ChatFormatting.GOLD));
//            }
//        }
//    }
//
//    public static class Data {
//        @SerializedName("range_multiplier")
//        @Nullable
//        private RangefinderModifierData rangefinderModifier = null;
//
//        @Nullable
//        public RangefinderModifierData getRangefinderModifier() {
//            return rangefinderModifier;
//        }
//    }
//}