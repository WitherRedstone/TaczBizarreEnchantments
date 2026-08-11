package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 私人助手附魔的事件处理类
 * <p>
 * 功能：显示目标生命值和距离，震颤目标
 * <p>
 * 机制：
 * <ol>
 *   <li>击中目标时，显示其生命值和距离信息</li>
 *   <li>造成伤害时，给目标添加震颤效果</li>
 * </ol>
 */
public class PersonalAssistantEvent {

    /**
     * 枪械伤害事件：私人助手
     * 显示目标生命值和距离，震颤目标
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PERSONAL_ASSISTANT.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 计算距离
        double distance = player.distanceTo(target);

        // 获取目标生命值
        float targetHealth = target.getHealth();
        float targetMaxHealth = target.getMaxHealth();

        // 显示在物品栏上方
        String healthText = Component.translatable("gui.tbz.personal_assistant.health", String.format("%.1f", targetHealth), String.format("%.1f", targetMaxHealth)).getString();
        String distanceText = Component.translatable("gui.tbz.personal_assistant.distance", String.format("%.1f", distance)).getString();
        player.displayClientMessage(Component.literal(healthText + " " + distanceText), true);

        // 震颤效果
        int joltDuration = TBZServerConfig.PERSONAL_ASSISTANT_JOLT_DURATION.get();
        int joltAmplifier = TBZServerConfig.PERSONAL_ASSISTANT_JOLT_LEVEL.get() - 1;
        target.addEffect(new MobEffectInstance(FELEffects.JOLT.get(), joltDuration * 20, joltAmplifier, false, false));
    }
}