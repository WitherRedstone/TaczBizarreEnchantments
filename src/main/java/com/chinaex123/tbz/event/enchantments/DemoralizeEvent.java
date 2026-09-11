package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.EnchantmentParticleEffects;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 瓦解附魔的事件处理类
 * <p>
 * 功能：精准最后一击会使附近目标变得虚弱
 * <p>
 * 机制：
 * <ol>
 *   <li>爆头命中时标记</li>
 *   <li>爆头击杀时对半径3格内的所有目标施加虚弱效果</li>
 *   <li>显示范围粒子效果（和火线一样）</li>
 * </ol>
 */
public class DemoralizeEvent {

    /** NBT存储键：是否获得爆头击杀标记 */
    private static final String HEADSHOT_KILL_TAG = "DemoralizeHeadshotKill";

    /**
     * 枪械伤害事件：瓦解
     * 记录爆头命中，等待后续击杀确认
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

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.DEMORALIZE.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 标记爆头命中
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(HEADSHOT_KILL_TAG, true);
    }

    /**
     * 实体死亡事件：瓦解
     * 验证爆头命中是否导致了击杀，如果有效则触发虚弱效果
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查是否有瓦解附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.DEMORALIZE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean hasHeadshotMark = tag.getBoolean(HEADSHOT_KILL_TAG);

        // 验证是否有爆头标记
        if (!hasHeadshotMark) {
            return;
        }

        // 清除标记
        tag.remove(HEADSHOT_KILL_TAG);

        // 从配置获取参数
        double radius = TBZServerConfig.DEMORALIZE_RADIUS.get();
        int duration = TBZServerConfig.DEMORALIZE_EFFECT_DURATION.get();
        int amplifier = TBZServerConfig.DEMORALIZE_EFFECT_LEVEL.get() - 1;

        // 对半径内的所有生物施加虚弱效果
        double radiusSqr = radius * radius;
        for (var nearbyEntity : target.level().getEntitiesOfClass(LivingEntity.class,
                target.getBoundingBox().inflate(radius))) {

            // 排除被击杀的目标自己
            if (nearbyEntity == target) continue;

            // 检查距离
            if (target.distanceToSqr(nearbyEntity) <= radiusSqr) {
                // 施加瓦解效果
                nearbyEntity.addEffect(new MobEffectInstance(FELEffects.SEVER.get(), duration, amplifier, false, true));
            }
        }

        // 生成粒子效果
        if (target.level() instanceof ServerLevel serverLevel) {
            EnchantmentParticleEffects.showDemoralizeRadiusParticle(serverLevel, target.getX(), target.getY(), target.getZ(), radius);
        }
    }
}