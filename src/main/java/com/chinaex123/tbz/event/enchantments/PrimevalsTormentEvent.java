package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ParticleUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.server.AmmoHitBlockEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * 古昧的折磨附魔的事件处理类
 * <p>
 * 功能：射出的子弹有概率会对目标或命中点附近区域造成凋零效果
 * <p>
 * 机制：
 * <ol>
 *   <li>命中实体目标时有概率对目标施加凋零效果</li>
 *   <li>命中方块时有概率对命中点附近区域施加凋零效果</li>
 *   <li>凋零效果的持续时间和等级从配置读取</li>
 *   <li>范围影响：对命中点附近范围内的所有生物施加凋零效果</li>
 * </ol>
 */
public class PrimevalsTormentEvent {

    /**
     * 枪械伤害事件 - 古昧的折磨
     * 当附魔的枪械击中实体目标时，有概率对目标及周围生物施加凋零效果
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有古昧的折磨附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PRIMEVALS_TORMENT.get());
        if (enchantLevel <= 0) return;

        // 从配置获取触发概率
        float triggerChance = TBZServerConfig.PRIMEVALS_TORMENT_TRIGGER_CHANCE.get().floatValue();
        if (player.getRandom().nextFloat() >= triggerChance) return;

        // 从配置获取效果参数
        int duration = TBZServerConfig.PRIMEVALS_TORMENT_EFFECT_DURATION.get();
        int amplifier = TBZServerConfig.PRIMEVALS_TORMENT_EFFECT_LEVEL.get() - 1;
        double range = TBZServerConfig.PRIMEVALS_TORMENT_RANGE.get();

        // 对目标施加凋零效果
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, duration * 20, amplifier, false, false));

        // 对范围内的其他生物施加凋零效果
        if (range > 0) {
            double rangeSqr = range * range;
            boolean hasNearbyTargets = false;
            
            for (LivingEntity nearby : target.level().getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(range))) {
                if (nearby != target && target.distanceToSqr(nearby) <= rangeSqr) {
                    hasNearbyTargets = true;
                    nearby.addEffect(new MobEffectInstance(MobEffects.WITHER, duration * 20, amplifier, false, false));
                }
            }
            
            // 显示粒子效果
            if (hasNearbyTargets && TBZServerConfig.PRIMEVALS_TORMENT_SHOW_PARTICLES.get() && target.level() instanceof ServerLevel serverLevel) {
                ParticleUtils.spawnCircleRadiusParticle(serverLevel, target.getX(), target.getY(), target.getZ(), range, 0.3f, 0.0f, 0.3f, 0.5f);
            }
        }
    }

    /**
     * 子弹击中方块事件 - 古昧的折磨
     * 在击中位置附近区域有概率施加凋零效果
     *
     * @param event 子弹击中方块事件
     */
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {
        Entity owner = event.getAmmo().getOwner();
        if (!(owner instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有古昧的折磨附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PRIMEVALS_TORMENT.get());
        if (enchantLevel <= 0) return;

        // 从配置获取触发概率
        float triggerChance = TBZServerConfig.PRIMEVALS_TORMENT_TRIGGER_CHANCE.get().floatValue();
        if (player.getRandom().nextFloat() >= triggerChance) return;

        // 获取命中位置和范围
        Vec3 hitPos = event.getHitResult().getLocation();
        double range = TBZServerConfig.PRIMEVALS_TORMENT_RANGE.get();

        // 创建搜索区域
        AABB aabb = new AABB(
                hitPos.x - range, hitPos.y - range, hitPos.z - range,
                hitPos.x + range, hitPos.y + range, hitPos.z + range
        );

        // 从配置获取效果参数
        int duration = TBZServerConfig.PRIMEVALS_TORMENT_EFFECT_DURATION.get();
        int amplifier = TBZServerConfig.PRIMEVALS_TORMENT_EFFECT_LEVEL.get() - 1;

        // 对范围内所有生物施加凋零效果
        List<LivingEntity> entities = event.getLevel().getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entity : entities) {
            if (entity != player) {
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, duration * 20, amplifier, false, false));
            }
        }
    }
}