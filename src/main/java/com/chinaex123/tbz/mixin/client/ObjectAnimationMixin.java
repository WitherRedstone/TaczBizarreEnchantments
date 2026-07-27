package com.chinaex123.tbz.mixin.client;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.client.animation.ObjectAnimation;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * 对象动画混入类
 * <p>
 * 功能：用于加速换弹动画的播放速度
 * 通过修改动画更新时间来实现加速
 */
@Mixin(value = ObjectAnimation.class, remap = false)
public class ObjectAnimationMixin {

    @Final
    @Shadow
    public String name;  // 动画名称

    /**
     * 修改动画更新时间
     *
     * @param timeNs 原始时间增量（纳秒）
     * @return 修改后的时间增量
     */
    @ModifyVariable(
            method = "update",
            at = @At("HEAD"),
            remap = false,
            argsOnly = true
    )
    private float modifyUpdateTime(float timeNs) {
        try {
            // 仅处理换弹动画
            if (name == null || !name.toLowerCase().contains("reload")) {
                return timeNs;
            }

            // 获取当前玩家
            Player player = Minecraft.getInstance().player;
            if (player == null) return timeNs;

            // 获取玩家主手武器
            ItemStack weapon = player.getMainHandItem();
            if (weapon.isEmpty()) return timeNs;

            // 检查是否有指定附魔
            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
            if (level <= 0) return timeNs;

            // 检查是否有换弹加速标记
            var tag = weapon.getOrCreateTag();
            boolean hasSpeedTag = tag.getBoolean("OutlawReloadSpeed");
            if (!hasSpeedTag) return timeNs;

            // 从配置获取加速比例并计算速度因子
            float multiplier = TBZServerConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
            float clamped = Math.min(Math.max(multiplier, 0.0f), 0.99f);
            // 速度因子 = 1 / (1 - 加速比例)
            // 例如：加速30% => 因子 = 1 / 0.7 ≈ 1.428
            float speedFactor = 1.0f / (1.0f - clamped);

            // 应用加速：将时间增量乘以速度因子
            return timeNs * speedFactor;

        } catch (Exception e) {
            // 忽略异常，保持原有行为
            return timeNs;
        }
    }
}