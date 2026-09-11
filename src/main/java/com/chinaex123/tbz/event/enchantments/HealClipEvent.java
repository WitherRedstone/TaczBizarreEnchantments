package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.EnchantmentParticleEffects;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 治疗弹匣附魔的事件处理类
 * <p>
 * 功能：最后一击后短时间内填装，可为自身或周围玩家或和平生物提供治愈
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀敌人时记录附魔等级和击杀时间</li>
 *   <li>击杀后等待换弹触发治疗效果（仅限一次）</li>
 *   <li>若击杀后40刻（2秒）内开始换弹，存储治愈数据到枪械NBT</li>
 *   <li>弹匣装填完成后应用治愈效果</li>
 *   <li>治疗强度随附魔等级提升：基础放大器 + (等级 - 1) × 每级增量</li>
 *   <li>施加CURE效果（瞬间恢复生命值），持续时间极短（1刻）</li>
 *   <li>触发后清除等待记录，防止重复治疗</li>
 *   <li>若超过时间窗口换弹，则不触发治疗并清除等待记录</li>
 *   <li>每次击杀独立记录，多个击杀不会叠加（后一次覆盖前一次）</li>
 * </ol>
 */
public class HealClipEvent {

    /** 治疗效果持续时间 */
    private static final int INSTANT_DURATION = 1;

    /** NBT存储键：待应用的治疗弹匣数据 */
    private static final String PENDING_HEAL_TAG = "HealClipPendingHeal";

    /** 记录每个玩家等待治疗的数据 */
    private static final Map<UUID, PendingHealData> pendingHealMap = new ConcurrentHashMap<>();

    /**
     * 实体死亡事件：治疗弹匣
     * 记录本次击杀的附魔等级和发生时间，等待换弹触发治疗
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.HEAL_CLIP.get());
        if (enchantLevel <= 0) return;

        long killTime = player.level().getGameTime();  // 记录击杀时的游戏时间（刻）
        pendingHealMap.put(player.getUUID(), new PendingHealData(enchantLevel, killTime));
    }

    /**
     * 换弹开始事件：治疗弹匣
     * 检查是否有待触发的治疗，若在有效时间窗口内则存储治愈数据到枪械NBT
     *
     * @param player 换弹的玩家
     * @param gun 正在换弹的枪械
     */
    public static void onGunReload(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.HEAL_CLIP.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        UUID playerId = player.getUUID();

        // 检查是否有等待治疗的击杀记录
        if (pendingHealMap.containsKey(playerId)) {
            PendingHealData data = pendingHealMap.get(playerId);
            long currentTime = player.level().getGameTime();

            // 判断是否在有效时间窗口内
            if (currentTime - data.killTime <= TBZServerConfig.HEAL_CLIP_RELOAD_TICKS.get()) {
                // 将治愈数据存储到枪械NBT中，待弹匣装填完成后触发
                CompoundTag tag = gun.getOrCreateTag();
                tag.putInt(PENDING_HEAL_TAG, data.enchantLevel);
            }
            // 无论是否存储治愈数据，都移除等待记录（一次性使用）
            pendingHealMap.remove(playerId);
        }
    }

    /**
     * 玩家Tick事件：治疗弹匣
     * 在弹药装填完成后调用，应用治愈效果
     * 注意：仅当弹匣已满（currentAmmo >= magazineSize）时才应用治愈
     *
     * @param gun 枪械物品
     * @param player 玩家对象
     */
    public static void onPlayerTick(ItemStack gun, Player player) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.HEAL_CLIP.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getTag();
        if (tag == null || !tag.contains(PENDING_HEAL_TAG)) return;

        int pendingEnchantLevel = tag.getInt(PENDING_HEAL_TAG);
        if (pendingEnchantLevel <= 0) {
            tag.remove(PENDING_HEAL_TAG);  // 清理无效标签
            return;
        }

        // 获取弹匣容量和当前弹药数量
        int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        if (magazineSize <= 0 || currentAmmo < 0) return;

        // 仅在弹匣已满时应用治愈（避免在装填过程中触发）
        if (currentAmmo >= magazineSize) {
            applyHeal(player, pendingEnchantLevel);
            tag.remove(PENDING_HEAL_TAG);  // 应用后清除标签
        }
        // 如果弹匣未满，则保留PENDING_HEAL_TAG，等待下次满弹时应用
    }

    /**
     * 应用治疗效果
     * 根据附魔等级计算药水效果强度并施加CURE效果
     *
     * @param player 目标玩家
     * @param enchantLevel 附魔等级
     */
    private static void applyHeal(Player player, int enchantLevel) {
        int amplifier = getCureAmplifier(enchantLevel);
        applyAreaHeal(player, amplifier);
    }

    /**
     * 应用区域治疗效果
     * 对玩家和半径内的其他玩家及和平生物施加治愈效果
     *
     * @param player 触发治疗的玩家
     * @param amplifier 治愈效果等级
     */
    private static void applyAreaHeal(Player player, int amplifier) {
        double radius = TBZServerConfig.HEAL_CLIP_AREA_RADIUS.get();
        boolean healPeaceful = TBZServerConfig.HEAL_CLIP_HEAL_PEACEFUL.get();
        int otherPlayerAmplifier = TBZServerConfig.HEAL_CLIP_OTHER_PLAYER_AMPLIFIER.get();

        player.addEffect(new MobEffectInstance(FELEffects.CURE.get(), INSTANT_DURATION, amplifier));

        player.level().getEntitiesOfClass(LivingEntity.class, new AABB(
            player.getX() - radius, player.getY() - radius, player.getZ() - radius,
            player.getX() + radius, player.getY() + radius, player.getZ() + radius
        )).forEach(entity -> {
            if (entity == player) return;
            if (entity instanceof Player) {
                entity.addEffect(new MobEffectInstance(FELEffects.CURE.get(), INSTANT_DURATION, otherPlayerAmplifier));
            } else if (healPeaceful && isPeacefulMob(entity)) {
                entity.addEffect(new MobEffectInstance(FELEffects.CURE.get(), INSTANT_DURATION, amplifier));
            }
        });

        if (TBZServerConfig.HEAL_CLIP_SHOW_PARTICLES.get() && player.level() instanceof ServerLevel serverLevel) {
            EnchantmentParticleEffects.showHealClipRadiusParticle(serverLevel, player.getX(), player.getY(), player.getZ(), radius);
        }
    }

    /**
     * 判断实体是否为和平生物
     *
     * @param entity 目标实体
     * @return 是否为和平生物
     */
    private static boolean isPeacefulMob(LivingEntity entity) {
        return entity.getType().getCategory() == MobCategory.AMBIENT || 
               entity.getType().getCategory() == MobCategory.CREATURE || 
               entity.getType().getCategory() == MobCategory.WATER_AMBIENT ||
               entity.getType().getCategory() == MobCategory.WATER_CREATURE;
    }

    /**
     * 计算治愈的放大器
     * 公式：基础放大器 + (附魔等级 - 1) × 每级增量
     *
     * @param level 附魔等级
     * @return 效果放大器值
     */
    private static int getCureAmplifier(int level) {
        return TBZServerConfig.HEAL_CLIP_BASE_AMPLIFIER.get()
                + (level - 1) * TBZServerConfig.HEAL_CLIP_AMPLIFIER_PER_LEVEL.get();
    }

    /**
     * 清除玩家的等待治疗数据
     *
     * @param playerId 玩家UUID
     */
    public static void clearPending(UUID playerId) {
        pendingHealMap.remove(playerId);
    }

    /**
     * 等待治疗数据记录
     * 使用record类型存储不可变数据
     *
     * @param enchantLevel 附魔等级
     * @param killTime 击杀时间（游戏刻）
     */
    private record PendingHealData(int enchantLevel, long killTime) {}
}