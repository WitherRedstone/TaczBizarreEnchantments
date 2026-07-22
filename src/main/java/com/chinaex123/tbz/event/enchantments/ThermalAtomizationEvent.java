package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ExplosionUtils;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.item.ModernKineticGunScriptAPI;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 热能雾化附魔的事件处理类
 * <p>
 * 功能：枪械热度较高时造成额外伤害，击杀时触发小范围爆炸
 * <p>
 * 机制：
 * <ol>
 *   <li>当枪械热度超过50%阈值时，子弹造成额外伤害</li>
 *   <li>额外伤害比例从配置读取</li>
 *   <li>在热度超过阈值时击杀目标，会触发小范围爆炸</li>
 *   <li>爆炸伤害在最小和最大伤害之间随机</li>
 *   <li>附魔等级不直接影响伤害倍率，仅作为触发条件</li>
 * </ol>
 */
public class ThermalAtomizationEvent {

    /** 标记当前伤害是否有加成 */
    private static final String HEAT_DAMAGE_TAG = "ThermalAtomizationHeatDamage";

    /** 热度阈值，超过此比例时触发效果 */
    private static final float HEAT_THRESHOLD = 0.5f;

    /**
     * 枪械伤害事件处理 - 热能雾化增伤
     * 当枪械热度超过阈值时，增加本次伤害
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

        // 检查是否有热能雾化附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.THERMAL_ATOMIZATION.get());
        if (enchantLevel <= 0) return;

        try {
            // 获取枪械API实例，用于读取热度数据
            ModernKineticGunScriptAPI gunAPI = new ModernKineticGunScriptAPI();
            gunAPI.setShooter(player);
            gunAPI.setItemStack(gun);
            IGunOperator operator = IGunOperator.fromLivingEntity(player);
            gunAPI.setDataHolder(operator.getDataHolder());

            // 获取当前热度和最大热度
            float heatAmount = gunAPI.getHeatAmount();
            float heatMax = gunAPI.getHeatMax();

            if (heatMax <= 0) {
                return;
            }

            // 计算热度比例
            float heatRatio = heatAmount / heatMax;

            // 如果热度超过阈值，增加伤害
            if (heatRatio > HEAT_THRESHOLD) {
                // 从配置获取伤害加成比例
                float damageBonus = TBZConfig.THERMAL_ATOMIZATION_DAMAGE_BONUS.get().floatValue();
                float originalDamage = event.getBaseAmount();
                // 计算新伤害：原始伤害 × (1 + 伤害加成)
                float newDamage = originalDamage * (1.0f + damageBonus);
                event.setBaseAmount(newDamage);

                // 标记本次伤害由热能雾化加成
                var tag = gun.getOrCreateTag();
                tag.putBoolean(HEAT_DAMAGE_TAG, true);
            } else {
                // 热度不足，清除标记
                var tag = gun.getOrCreateTag();
                tag.putBoolean(HEAT_DAMAGE_TAG, false);
            }

        } catch (Exception e) {
            // 忽略异常
        }
    }

    /**
     * 击杀事件处理 - 热能雾化爆炸
     * 当击杀时枪械热度超过阈值，触发小范围爆炸
     *
     * @param player 击杀者玩家
     * @param killedEntity 被击杀的实体
     * @param gun 使用的枪械物品
     */
    public static void onKill(Player player, Entity killedEntity, ItemStack gun) {
        if (!(killedEntity instanceof LivingEntity target)) return;
        if (gun.isEmpty()) return;

        // 检查是否有热能雾化附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.THERMAL_ATOMIZATION.get());
        if (enchantLevel <= 0) return;

        // 检查本次击杀是否由热能雾化加成伤害造成
        var tag = gun.getOrCreateTag();
        if (!tag.getBoolean(HEAT_DAMAGE_TAG)) return;

        try {
            ModernKineticGunScriptAPI gunAPI = new ModernKineticGunScriptAPI();
            gunAPI.setShooter(player);
            gunAPI.setItemStack(gun);
            IGunOperator operator = IGunOperator.fromLivingEntity(player);
            gunAPI.setDataHolder(operator.getDataHolder());

            // 获取当前热度和最大热度
            float heatAmount = gunAPI.getHeatAmount();
            float heatMax = gunAPI.getHeatMax();

            if (heatMax <= 0) {
                return;
            }

            // 计算热度比例
            float heatRatio = heatAmount / heatMax;

            // 如果热度低于阈值，不触发爆炸
            if (heatRatio <= HEAT_THRESHOLD) {
                return;
            }

            // 从配置读取爆炸参数
            float explosionMinDamage = TBZConfig.THERMAL_ATOMIZATION_EXPLOSION_MIN_DAMAGE.get().floatValue();
            float explosionMaxDamage = TBZConfig.THERMAL_ATOMIZATION_EXPLOSION_MAX_DAMAGE.get().floatValue();
            double explosionRange = TBZConfig.THERMAL_ATOMIZATION_EXPLOSION_RANGE.get();

            // 在目标位置触发小范围爆炸
            ExplosionUtils.dealSmallExplosionDamage(target, 0, explosionMinDamage, explosionMaxDamage, explosionRange);

        } catch (Exception e) {
            // 忽略异常
        }
    }
}