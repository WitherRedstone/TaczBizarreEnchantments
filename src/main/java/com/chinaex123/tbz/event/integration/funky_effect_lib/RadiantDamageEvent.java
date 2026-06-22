package com.chinaex123.tbz.event.integration.funky_effect_lib;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 焕光伤害事件处理类
 */
@Mod.EventBusSubscriber
public class RadiantDamageEvent {

    private static final float RADIANT_DAMAGE_BONUS = 0.35f; // 35% 伤害加成

    @SubscribeEvent
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        if (!player.hasEffect(FELEffects.RADIANT.get())) {
            return;
        }

        float newDamage = event.getBaseAmount() * (1.0f + RADIANT_DAMAGE_BONUS);
        event.setBaseAmount(newDamage);
    }
}