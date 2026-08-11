package com.chinaex123.tbz.utils;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import org.joml.Vector3f;

/**
 * 粒子效果工具类
 * <p>
 * 功能：提供通用的粒子效果方法，供附魔系统复用
 */
public class ParticleUtils {

    /**
     * 生成圆形粒子圈
     * 在指定位置生成一个圆形粒子圈，大小根据半径决定
     *
     * @param level  服务端世界
     * @param x      X坐标
     * @param y      Y坐标
     * @param z      Z坐标
     * @param radius 半径
     * @param r      红色分量（0.0-1.0）
     * @param g      绿色分量（0.0-1.0）
     * @param b      蓝色分量（0.0-1.0）
     * @param size   粒子大小
     */
    public static void spawnCircleRadiusParticle(ServerLevel level, double x, double y, double z, double radius, float r, float g, float b, float size) {
        Vector3f particleColor = new Vector3f(r, g, b);
        DustParticleOptions particle = new DustParticleOptions(particleColor, size);

        // 根据半径动态计算粒子数量，确保粒子连续无空隙
        double particleSpacing = 0.15;
        double circumference = 2 * Math.PI * radius;
        int particleCount = (int) Math.ceil(circumference / particleSpacing);
        // 最少72个，最多288个，确保粒子连贯
        particleCount = Math.max(72, Math.min(288, particleCount));
        
        for (int i = 0; i < particleCount; i++) {
            double angle = (2 * Math.PI * i) / particleCount;
            double particleX = x + radius * Math.cos(angle);
            double particleZ = z + radius * Math.sin(angle);

            // 在脚部高度生成粒子
            double particleY = y + 0.1;

            level.sendParticles(particle, particleX, particleY, particleZ, 1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    /**
     * 生成圆形粒子圈
     * 在指定位置生成一个圆形粒子圈，大小根据半径决定
     *
     * @param level  服务端世界
     * @param x      X坐标
     * @param y      Y坐标
     * @param z      Z坐标
     * @param radius 半径
     * @param r      红色分量（0-255）
     * @param g      绿色分量（0-255）
     * @param b      蓝色分量（0-255）
     * @param size   粒子大小
     */
    public static void spawnCircleRadiusParticle(ServerLevel level, double x, double y, double z, double radius, int r, int g, int b, float size) {
        spawnCircleRadiusParticle(level, x, y, z, radius, r / 255.0f, g / 255.0f, b / 255.0f, size);
    }

//    /**
//     * 生成wax_on圆形粒子圈
//     *
//     * @param level  服务端世界
//     * @param x      X坐标
//     * @param y      Y坐标
//     * @param z      Z坐标
//     * @param radius 半径
//     */
//    public static void spawnWaxOnCircle(ServerLevel level, double x, double y, double z, double radius) {
//        // 根据半径动态计算粒子数量，确保粒子连续无空隙
//        double particleSpacing = 0.15;
//        double circumference = 2 * Math.PI * radius;
//        int particleCount = (int) Math.ceil(circumference / particleSpacing);
//        // 最少72个，最多288个，确保粒子连贯
//        particleCount = Math.max(72, Math.min(288, particleCount));
//
//        for (int i = 0; i < particleCount; i++) {
//            double angle = (2 * Math.PI * i) / particleCount;
//            double particleX = x + radius * Math.cos(angle);
//            double particleZ = z + radius * Math.sin(angle);
//
//            // 在脚部高度生成粒子
//            double particleY = y + 0.1;
//
//            level.sendParticles(ParticleTypes.SMALL_FLAME, particleX, particleY, particleZ,
//                    1, 0.0, 0.0, 0.0, 0.0
//            );
//        }
//    }

}