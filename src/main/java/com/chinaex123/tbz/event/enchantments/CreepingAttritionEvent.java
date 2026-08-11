package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * 蔓延羸弱附魔的事件处理类
 * <p>
 * 功能：快速精准命中会使目标进入减速状态
 * <p>
 * 机制：
 * <ol>
 *   <li>仅对爆头命中生效</li>
 *   <li>每次爆头命中时增加命中计数</li>
 *   <li>当命中计数达到配置要求时，对目标施加Slow减速效果</li>
 *   <li>命中计数有有效时间窗口，超过时间窗口未达到要求则重置</li>
 *   <li>Slow效果的持续时间和等级从配置读取</li>
 *   <li>触发后重置命中计数，准备下一次触发</li>
 * </ol>
 */
public class CreepingAttritionEvent {

    /** NBT存储键：精准命中计数 */
    private static final String HEADSHOT_COUNT_TAG = "CreepingAttritionHeadshotCount";
    /** NBT存储键：上次精准命中时间 */
    private static final String LAST_HEADSHOT_TIME_TAG = "CreepingAttritionLastHeadshotTime";

    /**
     * 枪械伤害事件：蔓延羸弱
     * 爆头命中时累计计数，达到阈值后对目标施加Slow减速效果
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

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.CREEPING_ATTRITION.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        Level level = player.level();
        long currentTime = level.getGameTime();
        CompoundTag tag = gun.getOrCreateTag();
        long lastHeadshotTime = tag.getLong(LAST_HEADSHOT_TIME_TAG);
        int headshotCount = tag.getInt(HEADSHOT_COUNT_TAG);

        // 检查是否在有效时间窗口内
        int timeWindow = TBZServerConfig.CREEPING_ATTRITION_TIME_WINDOW.get();
        if (currentTime - lastHeadshotTime > timeWindow) {
            // 超过时间窗口，重置计数
            headshotCount = 0;
        }

        // 增加命中计数
        headshotCount++;
        tag.putInt(HEADSHOT_COUNT_TAG, headshotCount);
        tag.putLong(LAST_HEADSHOT_TIME_TAG, currentTime);

        // 检查是否达到触发所需的命中次数
        int requiredHeadshots = TBZServerConfig.CREEPING_ATTRITION_REQUIRED_HEADSHOTS.get();
        if (headshotCount >= requiredHeadshots) {
            // 获取减速效果的持续时间和等级
            int slowDuration = TBZServerConfig.CREEPING_ATTRITION_SLOW_DURATION.get();
            int slowAmplifier = TBZServerConfig.CREEPING_ATTRITION_SLOW_LEVEL.get() - 1;

            // 对目标施加减速效果
            target.addEffect(new MobEffectInstance(
                    FELEffects.SLOW.get(), slowDuration, slowAmplifier, false, true
            ));

            // 重置命中计数
            tag.putInt(HEADSHOT_COUNT_TAG, 0);
        }
    }
}