package com.chinaex123.tbz.mixin.client;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.client.animation.AnimationSoundChannelContent;
import com.tacz.guns.api.client.animation.ObjectAnimationSoundChannel;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 对象动画音效通道混入类
 * <p>
 * 功能：用于换弹加速音效的播放同步
 * 当换弹加速激活时，取消原音效播放，实现音效与加速动画的同步
 */
@Mixin(value = ObjectAnimationSoundChannel.class, remap = false)
public class ObjectAnimationSoundChannelMixin {

    // 音效通道内容，包含所有关键帧音效数据
    @Shadow
    public AnimationSoundChannelContent content;

    /**
     * 获取换弹速度因子
     * 检查玩家是否持有带有亡命之徒附魔且拥有有效加速标记的武器
     *
     * @return 速度因子（0.01~1.0），1.0表示无加速，<1.0表示需要加速
     */
    @Unique
    private float tbz$getSpeedFactor() {
        try {
            // 检查音效内容是否存在
            if (content == null) return 1.0f;

            // 获取当前玩家
            Player player = Minecraft.getInstance().player;
            if (player == null) return 1.0f;

            // 获取玩家主手武器
            ItemStack weapon = player.getMainHandItem();
            if (weapon.isEmpty()) return 1.0f;

            // 检查是否有指定附魔
            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
            if (level <= 0) return 1.0f;

            // 检查是否有换弹加速标记
            var tag = weapon.getOrCreateTag();
            if (!tag.getBoolean("OutlawReloadSpeed")) return 1.0f;

            // 从配置获取加速比例并计算速度因子
            float multiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
            float clamped = Math.min(Math.max(multiplier, 0.0f), 0.99f);
            // 速度因子 = 1 - 加速比例，用于压缩音效播放时间
            return 1.0f - clamped;

        } catch (Exception e) {
            // 发生异常时返回无加速状态，保证游戏正常运行
            return 1.0f;
        }
    }

    /**
     * 音效播放注入
     * 当换弹加速激活时，取消原音效播放方法
     *
     * @param fromTimeS 起始时间（秒）
     * @param toTimeS 结束时间（秒）
     * @param entity 实体对象
     * @param distance 音效传播距离
     * @param volume 音量
     * @param pitch 音调
     * @param ci 回调信息，用于取消原方法
     */
    @Inject(
            method = "playSound",
            at = @At("HEAD"),
            remap = false,
            cancellable = true
    )
    private void onPlaySound(double fromTimeS, double toTimeS, Entity entity,
                             int distance, float volume, float pitch, CallbackInfo ci) {
        try {
            // 检查音效内容是否存在
            if (content == null) return;

            // 获取速度因子
            float timeFactor = tbz$getSpeedFactor();

            // 如果速度因子小于1.0，表示有加速效果，取消原音效播放
            if (timeFactor < 1.0f) {
                // 取消原方法执行
                ci.cancel();
            }
            // timeFactor >= 1.0 时走原方法，不做任何修改

        } catch (Exception e) {
            // 忽略异常，走原方法确保音效正常播放
        }
    }
}