package com.chinaex123.tbz.utils;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * 爆炸效果工具类
 * <p>
 * 功能：提供通用的爆炸伤害和视觉效果方法，供附魔系统复用
 */
public class ExplosionUtils {

    /**
     * 对目标造成爆炸伤害并播放视觉效果
     * 包含：伤害、声音、粒子效果、对周围生物的伤害
     *
     * @param entity    目标实体
     * @param damage    对目标的伤害值
     * @param splashMin 对周围生物的最小伤害
     * @param splashMax 对周围生物的最大伤害
     * @param range     对周围生物的伤害范围（格）
     */
    public static void dealExplosionDamage(LivingEntity entity, float damage, float splashMin, float splashMax, double range) {
        // 对目标造成通用伤害
        entity.hurt(entity.damageSources().generic(), damage);

        // 播放爆炸音效
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.5F, 1.0F
        );

        // 触发游戏事件
        entity.level().gameEvent(entity, GameEvent.EXPLODE, entity.position());

        // 在服务端生成粒子效果
        Level level = entity.level();
        if (level instanceof ServerLevel serverLevel) {
            // 计算目标中心位置
            Vec3 center = entity.position().add(0, entity.getBbHeight() / 2.0, 0);

            // 生成旋转的烟雾粒子
            for (int i = 0; i < 30; ++i) {
                double angle = Math.random() * Math.PI * 2.0;
                double radius = 0.8 + Math.random() * 0.5;
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;
                double offsetY = Math.random() - 0.5;

                serverLevel.sendParticles(
                        ParticleTypes.SMOKE, center.x + offsetX, center.y + offsetY, center.z + offsetZ,
                        1, 0.0, 0.0, 0.0, 0.0
                );
            }

            serverLevel.sendParticles(
                    ParticleTypes.EXPLOSION, center.x, center.y, center.z,
                    1, 0.0, 0.0, 0.0, 0.1
            );

            serverLevel.sendParticles(
                    ParticleTypes.FLAME, center.x, center.y, center.z,
                    15, 0.5, 0.5, 0.5, 0.05
            );

            // 对周围生物造成溅射伤害
            if (range > 0 && splashMin > 0 && splashMax > splashMin) {
                double rangeSqr = range * range;
                for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(range))) {
                    if (nearby != entity && entity.distanceToSqr(nearby) <= rangeSqr) {
                        float splashDamage = splashMin + (float)(Math.random() * (splashMax - splashMin));
                        nearby.hurt(nearby.damageSources().generic(), splashDamage);
                    }
                }
            }
        }
    }

    /**
     * 对目标造成爆炸伤害并播放视觉效果（简化版）
     * 使用默认的溅射伤害参数
     *
     * @param entity 目标实体
     * @param damage 对目标的伤害值
     */
    public static void dealExplosionDamage(LivingEntity entity, float damage) {
        dealExplosionDamage(entity, damage, 1.0F, 3.0F, 1.0);
    }

    /**
     * 对目标造成小爆炸伤害并播放视觉效果
     * 适用于高爆载荷等需要较小爆炸效果的附魔
     *
     * @param entity    目标实体
     * @param damage    对目标的伤害值
     * @param splashMin 对周围生物的最小伤害
     * @param splashMax 对周围生物的最大伤害
     * @param range     对周围生物的伤害范围（格）
     */
    public static void dealSmallExplosionDamage(LivingEntity entity, float damage, float splashMin, float splashMax, double range) {
        // 对目标造成通用伤害
        entity.hurt(entity.damageSources().generic(), damage);

        // 爆炸音效
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.2F
        );

        // 触发游戏事件
        entity.level().gameEvent(entity, GameEvent.EXPLODE, entity.position());

        // 在服务端生成粒子效果
        Level level = entity.level();
        if (level instanceof ServerLevel serverLevel) {
            // 计算目标中心位置
            Vec3 center = entity.position().add(0, entity.getBbHeight() / 2.0, 0);

            // 生成较少的烟雾粒子
            for (int i = 0; i < 15; ++i) {
                double angle = Math.random() * Math.PI * 2.0;
                double radius = 0.5 + Math.random() * 0.3;
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;
                double offsetY = Math.random() - 0.5;

                serverLevel.sendParticles(
                        ParticleTypes.SMOKE, center.x + offsetX, center.y + offsetY, center.z + offsetZ,
                        1, 0.0, 0.0, 0.0, 0.0
                );
            }

            serverLevel.sendParticles(
                    ParticleTypes.EXPLOSION, center.x, center.y, center.z,
                    1, 0.0, 0.0, 0.0, 0.02
            );

            serverLevel.sendParticles(
                    ParticleTypes.FLAME, center.x, center.y, center.z,
                    8, 0.3, 0.3, 0.3, 0.05
            );

            // 对周围生物造成溅射伤害
            if (range > 0 && splashMin > 0 && splashMax > splashMin) {
                double rangeSqr = range * range;
                for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(range))) {
                    if (nearby != entity && entity.distanceToSqr(nearby) <= rangeSqr) {
                        float splashDamage = splashMin + (float)(Math.random() * (splashMax - splashMin));
                        nearby.hurt(nearby.damageSources().generic(), splashDamage);
                    }
                }
            }
        }
    }

    /**
     * 对目标造成小爆炸伤害并播放视觉效果（简化版）
     * 使用默认的溅射伤害参数
     *
     * @param entity 目标实体
     * @param damage 对目标的伤害值
     */
    public static void dealSmallExplosionDamage(LivingEntity entity, float damage) {
        dealSmallExplosionDamage(entity, damage, 0.5F, 1.5F, 0.5);
    }

    /**
     * 在指定位置生成小爆炸视觉效果
     * 适用于方块爆炸等不需要对实体造成伤害的场景
     *
     * @param level  世界对象
     * @param pos    爆炸位置
     * @param splashMin 对周围生物的最小伤害
     * @param splashMax 对周围生物的最大伤害
     * @param range     对周围生物的伤害范围（格）
     */
    public static void createSmallExplosionEffect(Level level, Vec3 pos, float splashMin, float splashMax, double range) {
        level.playSound(null, pos.x, pos.y, pos.z,
                SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.2F
        );

        // 触发游戏事件
        level.gameEvent(null, GameEvent.EXPLODE, pos);

        // 在服务端生成粒子效果
        if (level instanceof ServerLevel serverLevel) {
            // 生成较少的烟雾粒子
            for (int i = 0; i < 15; ++i) {
                double angle = Math.random() * Math.PI * 2.0;
                double radius = 0.5 + Math.random() * 0.3;
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;
                double offsetY = Math.random() - 0.5;

                serverLevel.sendParticles(
                        ParticleTypes.SMOKE, pos.x + offsetX, pos.y + offsetY, pos.z + offsetZ,
                        1, 0.0, 0.0, 0.0, 0.0
                );
            }

            serverLevel.sendParticles(
                    ParticleTypes.EXPLOSION, pos.x, pos.y, pos.z,
                    1, 0.0, 0.0, 0.0, 0.02
            );

            serverLevel.sendParticles(
                    ParticleTypes.FLAME, pos.x, pos.y, pos.z,
                    8, 0.3, 0.3, 0.3, 0.05
            );

            // 对周围生物造成溅射伤害
            if (range > 0 && splashMin > 0 && splashMax > splashMin) {
                double rangeSqr = range * range;
                for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, 
                        new AABB(pos.x - range, pos.y - range, pos.z - range, 
                                pos.x + range, pos.y + range, pos.z + range))) {
                    if (nearby.distanceToSqr(pos.x, pos.y, pos.z) <= rangeSqr) {
                        float splashDamage = splashMin + (float)(Math.random() * (splashMax - splashMin));
                        nearby.hurt(nearby.damageSources().generic(), splashDamage);
                    }
                }
            }
        }
    }
}