package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 到此为止附魔的事件处理类
 * <p>
 * 功能：对没有护甲的目标造成更高的精准伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>检测目标是否拥有护甲（通过getArmorValue()方法）</li>
 *   <li>如果目标没有护甲（护甲值为0），并且是爆头命中</li>
 *   <li>则将爆头伤害提升至配置的倍率</li>
 *   <li>伤害公式：原伤害 × 额外倍率</li>
 *   <li>非爆头命中或目标有护甲时不触发任何效果</li>
 * </ol>
 */
public class FullStopEvent {

    /**
     * 枪械伤害事件处理 - 到此为止
     * 当附魔的枪械对没有护甲的目标造成爆头伤害时，提升伤害倍率
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

        // 检查是否有到此为止附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FULL_STOP.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 检查目标是否没有护甲（护甲值为0）
        if (target.getArmorValue() > 0) return;

        // 从配置获取额外伤害倍率
        float extraMultiplier = TBZServerConfig.FULL_STOP_HEADSHOT_MULTIPLIER.get().floatValue();

        // 计算最终伤害：原伤害 × 额外倍率
        float newDamage = event.getBaseAmount() * extraMultiplier;
        event.setBaseAmount(newDamage);
    }
}