package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.AimingState;
import com.chinaex123.tbz.utils.SoundUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 枯萎凝视附魔的事件处理类
 * <p>
 * 功能：瞄准此武器一小段时间而不射击，你将能够削弱下一个目标
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家开镜瞄准时开始计时，记录瞄准开始时间</li>
 *   <li>持续瞄准达到50刻（2.5秒）后标记为"就绪"状态</li>
 *   <li>松开瞄准（关闭镜）时清除计时和就绪标记（需要重新充能）</li>
 *   <li>就绪状态下命中任意目标时，对目标施加虚弱效果</li>
 *   <li>虚弱效果的持续时间和等级从配置读取</li>
 *   <li>触发后立即重置就绪状态，需要重新瞄准充能才能再次触发</li>
 *   <li>每次瞄准周期仅能触发一次效果</li>
 * </ol>
 */
public class WitheringGazeEvent {

    /** NBT存储键：开始瞄准的时间 */
    private static final String AIMING_START_TIME_TAG = "WitheringGazeAimingStartTime";
    /** NBT存储键：是否已准备就绪 */
    private static final String READY_TAG = "WitheringGazeReady";
    /** NBT存储键：是否已触发过效果 */
    private static final String TRIGGERED_TAG = "WitheringGazeTriggered";
    /** NBT存储键：是否已播放过就绪音效 */
    private static final String SOUND_PLAYED_TAG = "WitheringGazeSoundPlayed";
    /** 需要持续瞄准的刻数 */
    private static final int AIMING_REQUIRED_TICKS = 50;

    /**
     * 枪械伤害事件：枯萎凝视
     * 如果附魔已准备就绪且未触发过，对目标施加易伤效果，然后重置状态
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.WITHERING_GAZE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isReady = tag.getBoolean(READY_TAG);
        boolean isTriggered = tag.getBoolean(TRIGGERED_TAG);

        // 如果已准备就绪且未触发过，触发易伤效果
        if (isReady && !isTriggered) {
            // 获取效果持续时间和等级
            int duration = TBZServerConfig.WITHERING_GAZE_EFFECT_DURATION.get();
            int amplifier = TBZServerConfig.WITHERING_GAZE_EFFECT_LEVEL.get() - 1;

            // 对目标施加易伤效果
            target.addEffect(new MobEffectInstance(FELEffects.VULNERABLE.get(), duration * 20, amplifier, false, false));

            // 标记已触发
            tag.putBoolean(TRIGGERED_TAG, true);
            tag.putBoolean(READY_TAG, false);
        }
    }

    /**
     * 玩家Tick事件：枯萎凝视
     * 追踪玩家的瞄准持续时间，达到阈值后标记为"就绪"状态并播放音效
     *
     * @param player 玩家实体
     */
    public static void onPlayerTick(Player player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.WITHERING_GAZE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isAiming = AimingState.isAiming(player);  // 从服务端获取瞄准状态

        if (isAiming) {
            // 正在瞄准：记录开始时间或检查是否达到充能阈值
            if (!tag.contains(AIMING_START_TIME_TAG)) {
                // 首次进入瞄准状态：记录开始时间
                tag.putLong(AIMING_START_TIME_TAG, player.level().getGameTime());
            } else {
                // 已经记录开始时间：检查是否达到充能要求
                long startTime = tag.getLong(AIMING_START_TIME_TAG);
                long currentTime = player.level().getGameTime();

                // 如果持续瞄准时间 >= 50刻（2.5秒），标记为就绪
                if (currentTime - startTime >= AIMING_REQUIRED_TICKS) {
                    // 检查是否已经就绪
                    if (!tag.getBoolean(READY_TAG)) {
                        tag.putBoolean(READY_TAG, true);
                    }
                    
                    // 检查是否已播放过音效
                    if (!tag.getBoolean(SOUND_PLAYED_TAG)) {
                        tag.putBoolean(SOUND_PLAYED_TAG, true);
                        // 播放就绪音效
                        SoundUtils.playSoundForPlayer(player, SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0f, 1.5f);
                    }
                }
            }
        } else {
            // 停止瞄准：清除所有状态
            tag.remove(AIMING_START_TIME_TAG);
            tag.putBoolean(READY_TAG, false);
            tag.putBoolean(TRIGGERED_TAG, false);
            tag.putBoolean(SOUND_PLAYED_TAG, false);
        }
    }
}