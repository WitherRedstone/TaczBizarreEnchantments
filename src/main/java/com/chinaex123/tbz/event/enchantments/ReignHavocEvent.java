package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.api.BoltChargeAPI;
import com.chinaex123.funky_effect_lib.api.LightningStrikeAPI;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ReignHavocEvent {

    private static final String HEADSHOT_COUNT_TAG = "reign_havoc_headshot_count";

    @SubscribeEvent
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity targetEntity = event.getHurtEntity();
        if (!(targetEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REIGN_HAVOC.get());
        if (enchantLevel <= 0) return;

        try {
            boolean isHeadshot = event.isHeadShot();
            if (isHeadshot) {
                var tag = gun.getOrCreateTag();
                int headshotCount = tag.getInt(HEADSHOT_COUNT_TAG);
                headshotCount++;
                tag.putInt(HEADSHOT_COUNT_TAG, headshotCount);

                int requiredHeadshots = TBZConfig.REIGN_HAVOC_REQUIRED_HEADSHOTS.get();
                if (headshotCount >= requiredHeadshots) {
                    triggerLightningStrike(player, gun, target);
                    tag.putInt(HEADSHOT_COUNT_TAG, 0);
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(net.minecraftforge.event.entity.living.LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        LivingEntity killedEntity = event.getEntity();
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REIGN_HAVOC.get());
        if (enchantLevel <= 0) return;

        try {
            triggerLightningStrike(player, gun, killedEntity);
        } catch (Exception e) {
            // 忽略异常
        }
    }

    private static void triggerLightningStrike(Player player, ItemStack gun, LivingEntity target) {
        try {
            float lightningDamage = TBZConfig.REIGN_HAVOC_LIGHTNING_DAMAGE.get().floatValue();
            LightningStrikeAPI.strike(target, player, lightningDamage);
            BoltChargeAPI.addCharge(player, 1);

            float refillPercentage = TBZConfig.REIGN_HAVOC_REFILL_PERCENTAGE.get().floatValue();
            IGun iGun = IGun.getIGunOrNull(gun);
            if (iGun != null) {
                var gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
                if (gunIndexOpt.isPresent()) {
                    CommonGunIndex gunIndex = gunIndexOpt.get();
                    int magazineSize = gunIndex.getGunData().getAmmoAmount();
                    int currentAmmo = iGun.getCurrentAmmoCount(gun);
                    int refillAmount = (int) (magazineSize * refillPercentage);
                    
                    int ammoNeeded = magazineSize - currentAmmo;
                    int actualReload = Math.min(refillAmount, ammoNeeded);
                    
                    if (actualReload > 0) {
                        ResourceLocation ammoId = gunIndex.getGunData().getAmmoId();
                        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);
                        if (availableAmmo > 0) {
                            int ammoToTransfer = Math.min(actualReload, availableAmmo);
                            AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToTransfer);
                            iGun.setCurrentAmmoCount(gun, currentAmmo + ammoToTransfer);
                        }
                    }
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }
    }
}