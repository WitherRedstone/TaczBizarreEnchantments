package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.AimingState;
import com.chinaex123.tbz.utils.ExplosionUtils;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * 蝴蝶附魔的事件处理类
 * <p>
 * 功能：瞄准此武器一小段时间而不射击会使你的目标在你剩余弹匣内造成最后一击时爆炸
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家开镜瞄准时开始计时，记录瞄准开始时间
 *   <li>持续瞄准达到50刻（2.5秒）后激活附魔状态（标记为已激活）
 *   <li>松开瞄准（关闭镜）时清除计时，但保留激活状态（若已激活）
 *   <li>激活状态下击杀任意敌人时，在目标位置触发范围爆炸伤害
 *   <li>爆炸伤害随附魔等级提升：基础伤害 + 每级额外伤害
 *   <li>爆炸有随机溅射伤害范围（最小值~最大值之间随机）
 *   <li>爆炸影响范围内的所有实体（造成伤害）
 *   <li>换弹时重置激活状态，需要重新瞄准充能才能再次激活
 * </ol>
 */
public class ButterflyEvent {

    /** NBT存储键：开始瞄准的时间 */
    private static final String AIMING_START_TIME_TAG = "ButterflyAimingStartTime";
    /** NBT存储键：附魔是否已激活 */
    private static final String ACTIVE_TAG = "ButterflyActive";
    /** 需要持续瞄准的刻数 */
    private static final int AIMING_REQUIRED_TICKS = 50;

    /**
     * 实体死亡事件：蝴蝶
     * 如果附魔已激活，对死亡的实体造成额外爆炸伤害并播放效果
     *
     * @param event 实体死亡事件
     */
    public static void onLivingDeath(LivingDeathEvent event) {
        // 获取击杀者
        Entity source = event.getSource().getEntity();
        if (!(source instanceof Player player)) return;

        LivingEntity target = event.getEntity();
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BUTTERFLY.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        boolean isActive = tag.getBoolean(ACTIVE_TAG);

        // 如果附魔已激活，触发爆炸伤害
        if (isActive) {
            float damage = TBZServerConfig.BUTTERFLY_BASE_DAMAGE.get().floatValue()
                    + TBZServerConfig.BUTTERFLY_DAMAGE_PER_LEVEL.get().floatValue() * enchantLevel;
            float splashMin = TBZServerConfig.BUTTERFLY_SPLASH_MIN.get().floatValue();
            float splashMax = TBZServerConfig.BUTTERFLY_SPLASH_MAX.get().floatValue();
            double range = TBZServerConfig.BUTTERFLY_RANGE.get();
            ExplosionUtils.dealExplosionDamage(target, damage, splashMin, splashMax, range);
        }
    }

    /**
     * 玩家Tick事件：蝴蝶
     * 追踪玩家的瞄准持续时间，达到阈值后激活附魔
     *
     * @param player 玩家实体
     */
    public static void onPlayerTick(Player player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BUTTERFLY.get());
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

                // 如果持续瞄准时间 >= 50刻（2.5秒），激活附魔
                if (currentTime - startTime >= AIMING_REQUIRED_TICKS) {
                    tag.putBoolean(ACTIVE_TAG, true);
                }
            }
        } else {
            // 停止瞄准：清除开始时间
            tag.remove(AIMING_START_TIME_TAG);
        }
    }

    /**
     * 换弹开始事件：蝴蝶
     * 换弹时重置附魔状态（失去所有充能）
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BUTTERFLY.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 换弹时重置激活状态（需要重新瞄准充能）
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(ACTIVE_TAG, false);
    }
}