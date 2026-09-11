package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.config.TBZServerConfig;
import net.minecraft.server.level.ServerLevel;

import java.util.function.BooleanSupplier;

/**
 * 附魔粒子效果工具类
 * <p>
 * 专门管理各种附魔相关的粒子效果显示
 */
public class EnchantmentParticleEffects {

    /**
     * 统一的粒子显示方法，包含配置检查
     */
    private static void showRadiusParticleIfEnabled(
            ServerLevel level,
            double x, double y, double z,
            double radius,
            BooleanSupplier configCheck,
            float r, float g, float b, float alpha) {
        if (!configCheck.getAsBoolean()) {
            return;
        }
        ParticleUtils.spawnCircleRadiusParticle(level, x, y, z, radius, r, g, b, alpha);
    }

    /**
     * 显示瓦解附魔的圆形范围粒子效果
     */
    public static void showDemoralizeRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.DEMORALIZE_SHOW_PARTICLES.get(), 1.0f, 0.0f, 0.0f, 0.5f);
    }

    /**
     * 显示切勿靠近附魔的圆形范围粒子效果
     */
    public static void showKeepAwayRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.KEEP_AWAY_SHOW_PARTICLES.get(), 0.0f, 1.0f, 0.0f, 0.5f);
    }

    /**
     * 显示火线附魔的圆形范围粒子效果
     */
    public static void showFiringLineRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.FIRING_LINE_SHOW_PARTICLES.get(), 1.0f, 1.0f, 1.0f, 0.5f);
    }

    /**
     * 显示热能雾化附魔的圆形范围粒子效果
     */
    public static void showThermalAtomizationRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.THERMAL_ATOMIZATION_SHOW_PARTICLES.get(), 1.0f, 0.5f, 0.0f, 0.5f);
    }

    /**
     * 显示正确选择附魔的圆形范围粒子效果
     */
    public static void showTheRightChoiceRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.THE_RIGHT_CHOICE_SHOW_PARTICLES.get(), 0.27f, 1.0f, 0.27f, 0.5f);
    }

    /**
     * 显示古昧的折磨附魔的圆形范围粒子效果
     */
    public static void showPrimevalsTormentRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.PRIMEVALS_TORMENT_SHOW_PARTICLES.get(), 0.3f, 0.0f, 0.3f, 0.5f);
    }

    /**
     * 显示治疗弹匣附魔的圆形范围粒子效果
     */
    public static void showHealClipRadiusParticle(ServerLevel level, double x, double y, double z, double radius) {
        showRadiusParticleIfEnabled(level, x, y, z, radius, () -> TBZServerConfig.HEAL_CLIP_SHOW_PARTICLES.get(), 0.0f, 1.0f, 0.0f, 0.5f);
    }
}