//package com.chinaex123.tbz.mixin;
//
//import com.chinaex123.tbz.config.TBZConfig;
//import com.chinaex123.tbz.event.enchantments.OutlawEvent;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.tacz.guns.api.client.animation.ObjectAnimation;
//import com.tacz.guns.api.client.animation.ObjectAnimationRunner;
//import net.minecraft.client.Minecraft;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyVariable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Mixin(value = ObjectAnimationRunner.class, remap = false)
//public class ObjectAnimationRunnerMixin {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger("TBZ-AnimationRunner");
//
//    @Shadow
//    private ObjectAnimation animation;
//
//    @Shadow
//    private long lastUpdateNs;
//
//    /**
//     * 修改 update 方法中的 alphaProgress（时间增量）
//     * 实现动画加速
//     */
//    @ModifyVariable(
//            method = "update",
//            at = @At("STORE"),
//            remap = false
//    )
//    private long modifyAlphaProgress(long alphaProgress) {
//        try {
//            // 检查是否是换弹动画
//            if (animation == null || animation.name == null) {
//                return alphaProgress;
//            }
//            if (!animation.name.toLowerCase().contains("reload")) {
//                return alphaProgress;
//            }
//
//            // 获取当前玩家
//            Player player = Minecraft.getInstance().player;
//            if (player == null) return alphaProgress;
//
//            ItemStack weapon = player.getMainHandItem();
//            if (weapon.isEmpty()) return alphaProgress;
//
//            // 检查不法之徒附魔
//            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
//            if (level <= 0) return alphaProgress;
//
//            // 检查换弹加速标记
//            var tag = weapon.getOrCreateTag();
//            if (!tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG)) return alphaProgress;
//
//            // 获取加速倍率（配置值 0.9 表示加速 90%）
//            float multiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
//            float clamped = Math.min(Math.max(multiplier, 0.0f), 0.99f);
//
//            // 计算速度倍数：加速 90% → 速度变为 10 倍
//            float speedFactor = 1.0f / (1.0f - clamped);
//            long newAlphaProgress = (long) (alphaProgress * speedFactor);
//
//            // 只打印一次，避免刷屏
//            if (alphaProgress > 0 && newAlphaProgress > alphaProgress * 2) {
//                LOGGER.info("【换弹动画】加速 {} 倍, 动画: {}", speedFactor, animation.name);
//            }
//
//            return newAlphaProgress;
//
//        } catch (Exception e) {
//            return alphaProgress;
//        }
//    }
//}