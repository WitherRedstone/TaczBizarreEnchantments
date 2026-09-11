//package com.chinaex123.tbz.mixin.client;
//
//import com.chinaex123.tbz.client.animation.AnimationSpeedScaler;
//import com.tacz.guns.api.client.animation.ObjectAnimationRunner;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyVariable;
//
///**
// * 对象动画运行器混入类
// * <p>
// * 功能：通过修改动画进度来实现换弹动画加速
// * 使用 AnimationSpeedScaler 获取加速倍率
// */
//@Mixin(value = ObjectAnimationRunner.class, remap = false)
//public class ObjectAnimationRunnerMixin {
//
//    /**
//     * 修改 updateProgress 方法中的 alphaProgress（时间增量）
//     * 实现动画加速
//     *
//     * @param alphaProgress 原始时间增量
//     * @return 修改后的时间增量
//     */
//    @ModifyVariable(
//            method = "updateProgress",
//            at = @At(value = "HEAD"),
//            ordinal = 0,
//            argsOnly = true
//    )
//    private long scaleProgress(long alphaProgress) {
//        double scale = AnimationSpeedScaler.getAnimationSpeedScale();
//        return (long) (alphaProgress * scale);
//    }
//}