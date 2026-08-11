package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ParticleUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * 火线附魔的事件处理类
 * <p>
 * 功能：在两个或更多玩家身边时，武器造成的精准伤害增加
 * <p>
 * 机制：
 * <ol>
 *   <li>仅对爆头命中生效</li>
 *   <li>检测玩家周围指定半径内的其他玩家数量</li>
 *   <li>如果有2个或以上玩家，增加精准伤害</li>
 *   <li>持有火线附魔武器时，在脚下生成圆形粒子（颜色可在配置文件中设置）</li>
 * </ol>
 */
public class FiringLineEvent {

    /**
     * 枪械伤害事件：火线
     * 在两个或更多玩家身边时，武器造成的精准伤害增加
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FIRING_LINE_CHARGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 获取配置的半径和所需玩家数量
        double radius = TBZServerConfig.FIRING_LINE_RADIUS.get();
        int requiredPlayers = TBZServerConfig.FIRING_LINE_REQUIRED_PLAYERS.get();
        double damageBonus = TBZServerConfig.FIRING_LINE_DAMAGE_BONUS.get();
        boolean excludeSelf = TBZServerConfig.FIRING_LINE_EXCLUDE_SELF.get();

        // 检测玩家周围指定半径内的玩家数量
        int nearbyPlayerCount = 0;
        double radiusSqr = radius * radius;
        for (ServerPlayer nearbyPlayer : player.level().getEntitiesOfClass(ServerPlayer.class, player.getBoundingBox().inflate(radius))) {
            if (player.distanceToSqr(nearbyPlayer) <= radiusSqr) {
                // 根据配置决定是否排除自己
                if (!excludeSelf || nearbyPlayer != player) {
                    nearbyPlayerCount++;
                }
            }
        }

        // 如果周围有足够数量的玩家，增加伤害
        if (nearbyPlayerCount >= requiredPlayers) {
            float baseDamage = event.getBaseAmount();
            float bonusDamage = (float) (baseDamage * damageBonus);
            event.setBaseAmount(baseDamage + bonusDamage);
        }
    }

    /**
     * 玩家Tick事件：生成圆形粒子领域
     * 当玩家持有火线附魔武器时，在脚下生成圆形粒子
     * 圈的大小根据火线生效的距离决定，颜色可在配置文件中设置
     *
     * @param player 玩家对象
     */
    public static void onPlayerTick(Player player) {
        if (player == null) return;
        if (player.level().isClientSide) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FIRING_LINE_CHARGE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        Level level = player.level();
        if (!(level instanceof ServerLevel serverLevel)) return;

        // 检查是否显示粒子
        if (!TBZServerConfig.FIRING_LINE_SHOW_PARTICLES.get()) return;

        // 获取配置的半径
        double radius = TBZServerConfig.FIRING_LINE_RADIUS.get();

        // 生成圆形粒子
        ParticleUtils.spawnCircleRadiusParticle(serverLevel, player.getX(), player.getY(), player.getZ(), radius, 255, 255, 255, 0.5f);
    }
}