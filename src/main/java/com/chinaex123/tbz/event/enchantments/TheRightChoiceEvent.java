package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.network.hud.TriggeredEnchantmentSyncPacket;
import com.chinaex123.tbz.utils.ParticleUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

/**
 * 正确抉择附魔的事件处理类
 * <p>
 * 功能：每第七发子弹会弹向附近目标
 * <p>
 * 机制：
 * <ol>
 *   <li>追踪射击次数</li>
 *   <li>每第7发子弹时，向周围每个生物发射额外的子弹</li>
 *   <li>额外子弹的伤害与当前子弹相同</li>
 *   <li>触发时显示HUD</li>
 * </ol>
 */
public class TheRightChoiceEvent {

    /** NBT存储键：射击次数 */
    private static final String SHOT_COUNT_TAG = "TheRightChoice_ShotCount";

    /**
     * 枪械伤害事件：正确抉择
     * 每第七发子弹向周围每个生物发射额外的子弹
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.THE_RIGHT_CHOICE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();

        // 增加射击计数
        int shotCount = tag.getInt(SHOT_COUNT_TAG) + 1;
        tag.putInt(SHOT_COUNT_TAG, shotCount);

        // 从配置获取触发间隔（默认7）
        int triggerInterval = TBZServerConfig.THE_RIGHT_CHOICE_TRIGGER_INTERVAL.get();

        // 检查是否达到触发间隔
        if (shotCount % triggerInterval != 0) return;

        // 获取当前伤害值
        float baseDamage = event.getBaseAmount();

        // 获取范围
        double range = TBZServerConfig.THE_RIGHT_CHOICE_RANGE.get();

        // 获取被击中的实体
        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 获取周围所有生物
        if (player.level() instanceof ServerLevel serverLevel) {
            double rangeSqr = range * range;
            boolean hasNearbyTargets = false;
            
            for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(range))) {
                // 排除玩家自己和已击中的目标，以及超出圆形范围的
                if (nearby == player || nearby == target || target.distanceToSqr(nearby) > rangeSqr) continue;

                hasNearbyTargets = true;
                // 对每个生物造成与当前子弹相同的伤害（使用玩家作为伤害源）
                nearby.hurt(player.damageSources().playerAttack(player), baseDamage);
            }
            
            // 显示粒子效果
            if (hasNearbyTargets && TBZServerConfig.THE_RIGHT_CHOICE_SHOW_PARTICLES.get()) {
                ParticleUtils.spawnCircleRadiusParticle(serverLevel, target.getX(), target.getY(), target.getZ(), range, 0.27f, 1.0f, 0.27f, 0.5f);
            }
        }

        // 显示HUD提示
        if (player instanceof ServerPlayer serverPlayer) {
            long currentTime = serverPlayer.level().getGameTime();
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new TriggeredEnchantmentSyncPacket(player.getUUID(), "the_right_choice", currentTime)
            );
        }
    }
}