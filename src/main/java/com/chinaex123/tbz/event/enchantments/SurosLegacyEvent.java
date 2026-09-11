package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * SUROS遗产附魔的事件处理类
 * <p>
 * 功能：弹匣后半子弹造成额外伤害，击杀时有几率恢复血量
 * <p>
 * 机制：
 * <ol>
 *   <li>当使用弹匣后半部分子弹时，造成额外5%伤害</li>
 *   <li>击杀敌人时，33%几率给予治愈效果</li>
 *   <li>治愈效果使用前置模组的Cure效果</li>
 *   <li>没有HUD显示</li>
 *   <li>只有1级附魔</li>
 * </ol>
 */
public class SurosLegacyEvent {

    /** 治疗效果持续时间（1刻，瞬间生效） **/
    private static final int CURE_DURATION = 1;

    /**
     * 枪械伤害事件处理 - SUROS遗产增伤
     * 检查是否使用弹匣后半部分子弹，如果是则增加伤害
     *
     * @param event 枪械伤害事件（前置阶段）
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有SUROS遗产附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SUROS_LEGACY.get());
        if (enchantLevel <= 0) return;

        // 获取弹匣容量和当前弹药数量
        int maxAmmo = GunEnchantmentHelper.getMagazineSize(gun);
        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
        if (maxAmmo <= 0 || currentAmmo < 0) return;

        // 检查是否在弹匣后半部分（剩余子弹 <= 弹匣容量的一半）
        if (currentAmmo <= maxAmmo / 2) {
            // 从配置获取伤害加成比例
            float bonusDamagePercent = TBZServerConfig.SUROS_LEGACY_DAMAGE_BONUS.get().floatValue();
            float currentDamage = event.getBaseAmount();
            float bonusDamage = currentDamage * bonusDamagePercent;
            // 设置加成后的伤害
            event.setBaseAmount(currentDamage + bonusDamage);
        }
    }

    /**
     * 击杀事件处理 - SUROS遗产治疗效果
     * 击杀敌人时，有几率给予治愈效果
     *
     * @param player 击杀者玩家
     * @param gun 使用的枪械物品
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查是否有SUROS遗产附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.SUROS_LEGACY.get());
        if (enchantLevel <= 0) return;

        // 从配置获取触发几率
        float cureChance = TBZServerConfig.SUROS_LEGACY_CURE_CHANCE.get().floatValue();
        // 判定是否触发治愈效果
        if (player.getRandom().nextFloat() < cureChance) {
            player.addEffect(new MobEffectInstance(FELEffects.CURE.get(), CURE_DURATION, TBZServerConfig.SUROS_LEGACY_CURE_AMPLIFIER.get()));
        }
    }
}