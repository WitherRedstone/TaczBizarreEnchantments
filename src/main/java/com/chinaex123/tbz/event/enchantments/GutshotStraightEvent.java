package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.capability.IGunAimingCapability;
import com.chinaex123.tbz.capability.ModCapabilities;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 直击要害附魔的事件处理类
 * <p>
 * 功能：瞄准可提升身体射击伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>检测枪械命中目标时是否为爆头命中</li>
 *   <li>爆头命中不触发任何效果（仅作用于身体命中）</li>
 *   <li>检测玩家当前是否处于开镜瞄准状态（通过能力系统获取）</li>
 *   <li>仅在开镜瞄准且非爆头时触发伤害加成</li>
 *   <li>伤害加成比例从配置读取：最终伤害 = 原伤害 × (1 + 伤害加成比例)</li>
 *   <li>伤害加成比例固定，不随附魔等级变化</li>
 *   <li>每次命中独立计算，无冷却时间限制</li>
 *   <li>同时满足"非爆头"和"瞄准中"两个条件才生效</li>
 * </ol>
 */
public class GutshotStraightEvent {

    /**
     * 枪械伤害事件：直击要害
     * 瞄准时打中身体增加对身体的伤害
     * <p>
     * 触发条件：非爆头命中 + 玩家正在开镜瞄准
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.GUTSHOT_STRAIGHT.get());
        if (enchantLevel <= 0) return;

        // 条件1：爆头不触发
        if (event.isHeadShot()) return;

        // 条件2：获取玩家的瞄准状态
        boolean isAiming = player.getCapability(ModCapabilities.GUN_AIMING)
                .map(IGunAimingCapability::isAiming)
                .orElse(false);

        // 条件3：必须正在开镜瞄准
        if (!isAiming) return;

        // 从配置获取伤害加成比例
        float damageBonus = TBZConfig.GUTSHOT_STRAIGHT_DAMAGE_BONUS.get().floatValue();

        // 应用伤害加成：原伤害 × (1 + 伤害加成)
        event.setBaseAmount(event.getBaseAmount() * (1 + damageBonus));
    }
}