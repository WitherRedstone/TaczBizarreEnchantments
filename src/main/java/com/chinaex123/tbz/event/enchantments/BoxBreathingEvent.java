package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.AimingState;
import com.chinaex123.tbz.utils.SoundUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 盒式呼吸法附魔的事件处理类
 * <p>
 * 功能：瞄准一段时间后，持续造成额外伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家瞄准时开始计时</li>
 *   <li>持续瞄准50刻（2.5秒）后进入就绪状态</li>
 *   <li>就绪后播放提示音效</li>
 *   <li>就绪状态下所有射击都造成额外伤害</li>
 *   <li>主动换弹或停止瞄准时重置状态</li>
 * </ol>
 */
public class BoxBreathingEvent {

    /** NBT存储键：瞄准开始时间 **/
    private static final String AIMING_START_TIME_TAG = "BoxBreathingAimingStartTime";
    /** NBT存储键：是否就绪 **/
    private static final String READY_TAG = "BoxBreathingReady";

    /** NBT存储键：是否已播放音效 **/
    private static final String SOUND_PLAYED_TAG = "BoxBreathingSoundPlayed";
    /** 瞄准所需时间（50刻 = 2.5秒） **/
    private static final int AIMING_REQUIRED_TICKS = 50;

    /**
     * 枪械伤害事件：盒式呼吸法
     * 如果处于就绪状态且未触发，则增加伤害并消耗状态
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

        // 检查是否有盒式呼吸法附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BOX_BREATHING.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isReady = tag.getBoolean(READY_TAG);

        // 如果处于就绪状态，应用伤害加成
        if (isReady) {
            // 从配置获取伤害加成比例
            float damageBonus = TBZServerConfig.BOX_BREATHING_DAMAGE_BONUS.get().floatValue();
            float newDamage = event.getBaseAmount() * (1.0f + damageBonus);
            event.setBaseAmount(newDamage);
        }
    }

    /**
     * 玩家Tick事件：盒式呼吸法
     * 管理瞄准计时和就绪状态
     *
     * @param player 玩家对象
     */
    public static void onPlayerTick(Player player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有盒式呼吸法附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BOX_BREATHING.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isAiming = AimingState.isAiming(player);
        boolean isReady = tag.getBoolean(READY_TAG);

        if (isReady) {
            // 如果已经就绪，保持就绪状态，不做任何操作
            // 只有换弹或停止瞄准时才会重置
            return;
        }

        if (isAiming) {
            // 玩家正在瞄准，进行计时
            if (!tag.contains(AIMING_START_TIME_TAG)) {
                // 首次进入瞄准状态，记录开始时间
                tag.putLong(AIMING_START_TIME_TAG, player.level().getGameTime());
            } else {
                long startTime = tag.getLong(AIMING_START_TIME_TAG);
                long currentTime = player.level().getGameTime();

                // 检查是否达到瞄准所需时间
                if (currentTime - startTime >= AIMING_REQUIRED_TICKS) {
                    // 设置就绪状态
                    tag.putBoolean(READY_TAG, true);

                    // 播放就绪音效（仅一次）
                    if (!tag.getBoolean(SOUND_PLAYED_TAG)) {
                        tag.putBoolean(SOUND_PLAYED_TAG, true);
                        SoundUtils.playSoundForPlayer(player, SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0f, 1.5f);
                    }
                }
            }
        } else {
            // 玩家取消瞄准，重置所有状态
            tag.remove(AIMING_START_TIME_TAG);
            tag.putBoolean(READY_TAG, false);
            tag.putBoolean(SOUND_PLAYED_TAG, false);
        }
    }

    /**
     * 换弹事件处理 - 盒式呼吸法
     * 主动换弹时重置附魔状态
     *
     * @param event 换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有盒式呼吸法附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BOX_BREATHING.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        // 重置所有状态
        tag.remove(AIMING_START_TIME_TAG);
        tag.putBoolean(READY_TAG, false);
        tag.putBoolean(SOUND_PLAYED_TAG, false);
    }
}