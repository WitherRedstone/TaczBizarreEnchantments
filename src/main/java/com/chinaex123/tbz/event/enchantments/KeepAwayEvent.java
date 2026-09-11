package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.EnchantmentParticleEffects;
import com.chinaex123.tbz.utils.GunPropertyHelper;
import com.chinaex123.tbz.utils.ParticleUtils;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.pojo.data.gun.InaccuracyType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;

/**
 * 切勿靠近附魔的事件处理类
 * <p>
 * 功能：若附近无目标，提升优势射程和瞄准精度
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家半径7格内无任何敌对生物时，+10%优势射程和+5%瞄准精度</li>
 *   <li>半径的范围提示要有粒子效果，和火线一样</li>
 * </ol>
 */
public class KeepAwayEvent {

    /**
     * 玩家Tick事件：切勿靠近
     * 检测玩家周围是否有敌对生物，如果没有则提升优势射程和瞄准精度
     *
     * @param event 玩家Tick事件
     */
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player == null) return;
        if (player.level().isClientSide) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.KEEP_AWAY.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 从配置获取参数
        double detectionRadius = TBZServerConfig.KEEP_AWAY_DETECTION_RADIUS.get();
        double effectiveRangeBonus = TBZServerConfig.KEEP_AWAY_EFFECTIVE_RANGE_BONUS.get();
        double aimAccuracyBonus = TBZServerConfig.KEEP_AWAY_AIM_ACCURACY_BONUS.get();
        double extraRangeBonusPerLevel = TBZServerConfig.KEEP_AWAY_EXTRA_RANGE_BONUS_PER_LEVEL.get();
        double extraAccuracyBonusPerLevel = TBZServerConfig.KEEP_AWAY_EXTRA_ACCURACY_BONUS_PER_LEVEL.get();

        // 根据附魔等级额外增加优势射程
        double extraRangeBonus = enchantLevel * extraRangeBonusPerLevel;
        double extraAccuracyBonus = enchantLevel * extraAccuracyBonusPerLevel;

        // 总加成倍率 = 基础加成 + 额外加成
        double totalRangeBonus = 1.0 + effectiveRangeBonus + extraRangeBonus;
        double totalAccuracyBonus = 1.0 - aimAccuracyBonus - extraAccuracyBonus;

        // 检测玩家周围是否有敌对生物
        boolean hasHostileNearby = hasHostileEntityNearby(player, detectionRadius);

        // 如果没有敌对生物，提升优势射程和瞄准精度
        if (!hasHostileNearby) {
            // 提升优势射程
            GunPropertyHelper.EffectiveRange.update(player, gun, true, enchantLevel, totalRangeBonus);

            // 提升瞄准精度
            GunPropertyHelper.Inaccuracy.update(player, gun, InaccuracyType.AIM, true, enchantLevel, totalAccuracyBonus);

            // 生成粒子效果
            if (player.level() instanceof ServerLevel serverLevel) {
                EnchantmentParticleEffects.showKeepAwayRadiusParticle(serverLevel, player.getX(), player.getY(), player.getZ(), detectionRadius);
            }
        } else {
            // 有敌对生物时，恢复正常数值
            GunPropertyHelper.EffectiveRange.update(player, gun, false, enchantLevel, totalRangeBonus);
            GunPropertyHelper.Inaccuracy.update(player, gun, InaccuracyType.AIM, false, enchantLevel, totalAccuracyBonus);
        }
    }

    /**
     * 检测玩家周围是否有敌对生物
     *
     * @param player 玩家对象
     * @param radius 检测半径
     * @return 如果有敌对生物返回true，否则返回false
     */
    private static boolean hasHostileEntityNearby(Player player, double radius) {
        double radiusSqr = radius * radius;

        // 检测玩家周围指定半径内的敌对生物
        for (var entity : player.level().getEntitiesOfClass(LivingEntity.class,
                player.getBoundingBox().inflate(radius))) {

            // 排除玩家自己
            if (entity == player) continue;

            // 检查是否为敌对生物
            if (entity.getType().getCategory() == MobCategory.MONSTER) {
                // 检查距离
                if (player.distanceToSqr(entity) <= radiusSqr) {
                    return true;
                }
            }
        }

        return false;
    }
}