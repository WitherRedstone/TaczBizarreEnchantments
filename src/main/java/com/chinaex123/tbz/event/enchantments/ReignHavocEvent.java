package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.api.event.BoltCharge.BoltChargeAPI;
import com.chinaex123.funky_effect_lib.api.LightningStrikeAPI;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Optional;

/**
 * 统治浩劫附魔的事件处理类
 * <p>
 * 功能：连续爆头触发闪电打击，击杀时必定触发，闪电打击后补充弹药
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家使用带有统治浩劫附魔的枪械时，记录连续爆头次数</li>
 *   <li>当连续爆头次数达到配置要求时，触发闪电打击</li>
 *   <li>击杀任意敌人时也会触发闪电打击（无论是否爆头）</li>
 *   <li>闪电打击对目标造成雷电伤害</li>
 *   <li>触发闪电打击后，为玩家增加1层雷电荷</li>
 *   <li>同时按弹匣容量百分比补充弹药（从备弹中消耗）</li>
 *   <li>触发后重置爆头计数</li>
 * </ol>
 */
public class ReignHavocEvent {

    /** NBT存储键：记录连续爆头次数 */
    private static final String HEADSHOT_COUNT_TAG = "reign_havoc_headshot_count";

    /**
     * 枪械伤害事件：统治浩劫
     * 当玩家爆头命中时增加计数，达到阈值时触发闪电打击
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity targetEntity = event.getHurtEntity();
        if (!(targetEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有统治浩劫附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REIGN_HAVOC.get());
        if (enchantLevel <= 0) return;

        try {
            // 仅处理爆头命中
            if (event.isHeadShot()) {
                var tag = gun.getOrCreateTag();
                int headshotCount = tag.getInt(HEADSHOT_COUNT_TAG);
                headshotCount++;
                tag.putInt(HEADSHOT_COUNT_TAG, headshotCount);

                // 从配置获取所需爆头次数
                int requiredHeadshots = TBZServerConfig.REIGN_HAVOC_REQUIRED_HEADSHOTS.get();
                // 达到阈值时触发闪电打击
                if (headshotCount >= requiredHeadshots) {
                    triggerLightningStrike(player, gun, target);
                    // 重置爆头计数
                    tag.putInt(HEADSHOT_COUNT_TAG, 0);
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }
    }

    /**
     * 实体死亡事件：统治浩劫
     * 无论是否爆头，击杀任意敌人都会触发闪电打击
     *
     * @param event 实体死亡事件
     */
    public static void onLivingDeath(LivingDeathEvent event) {
        // 获取击杀者
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        LivingEntity killedEntity = event.getEntity();
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有统治浩劫附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.REIGN_HAVOC.get());
        if (enchantLevel <= 0) return;

        // 击杀时触发闪电打击
        triggerLightningStrike(player, gun, killedEntity);
    }

    /**
     * 触发闪电打击的逻辑
     * 对目标造成雷电伤害，增加电光充能，并补充弹药
     *
     * @param player 玩家对象
     * @param gun 枪械物品
     * @param target 闪电打击的目标
     */
    private static void triggerLightningStrike(Player player, ItemStack gun, LivingEntity target) {
        try {
            // 从配置获取闪电伤害值
            float lightningDamage = TBZServerConfig.REIGN_HAVOC_LIGHTNING_DAMAGE.get().floatValue();
            // 从配置获取是否开启火焰伤害
            boolean fireDamage = TBZServerConfig.REIGN_HAVOC_FIRE_DAMAGE.get();
            // 对目标触发闪电打击
            LightningStrikeAPI.strike(target, player, lightningDamage, true, fireDamage);
            // 增加1层电光充能
            BoltChargeAPI.addCharge(player, 1);

            // 从配置获取弹药补充百分比
            float refillPercentage = TBZServerConfig.REIGN_HAVOC_REFILL_PERCENTAGE.get().floatValue();

            // 获取枪械数据
            int magazineSize = GunEnchantmentHelper.getMagazineSize(gun);
            int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);
            Optional<ResourceLocation> ammoId = GunEnchantmentHelper.getAmmoId(gun);
            if (magazineSize <= 0 || currentAmmo < 0 || ammoId.isEmpty()) return;

            // 计算需要补充的弹药数量
            int refillAmount = (int) (magazineSize * refillPercentage);
            int ammoNeeded = magazineSize - currentAmmo;
            int actualReload = Math.min(refillAmount, ammoNeeded);

            // 如果有弹药需要补充且备弹充足
            if (actualReload > 0) {
                ResourceLocation ammoIdValue = ammoId.get();
                int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoIdValue);
                if (availableAmmo > 0) {
                    // 从备弹转移到弹匣
                    int ammoToTransfer = Math.min(actualReload, availableAmmo);
                    AmmoUtils.consumeAmmoFromInventory(player, ammoIdValue, ammoToTransfer);
                    IGun iGun = GunEnchantmentHelper.getIGun(gun);
                    if (iGun != null) {
                        iGun.setCurrentAmmoCount(gun, currentAmmo + ammoToTransfer);
                    }
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }
    }
}