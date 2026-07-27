package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ShotTriggerHelper;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 精准工具附魔的事件处理类
 * <p>
 * 功能：造成精准伤害会提升爆头倍率
 * <p>
 * 机制：
 * <ol>
 *   <li>每发射一颗子弹增加1层射击计数（通过检测弹药减少量实现）</li>
 *   <li>首次射击时缓存当前枪械的弹匣容量</li>
 *   <li>射击计数达到"弹匣容量 × 配置比例"时触发加成叠加</li>
 *   <li>每次触发增加固定值的伤害加成（从配置读取），可多次叠加</li>
 *   <li>伤害加成对所有命中生效（不仅限于爆头）</li>
 *   <li>最终伤害 = 原伤害 × (1 + 累计加成值)</li>
 *   <li>触发后重置射击计数，准备下一次叠加</li>
 *   <li>换弹时重置所有计数和伤害加成（失去所有积累）</li>
 *   <li>每次射击只应用一次伤害加成，防止霰弹枪多次触发</li>
 * </ol>
 */
public class PrecisionInstrumentEvent {

    /** 射击触发标签前缀 */
    private static final String TRIGGER_TAG_PREFIX = "PrecisionInstrument";
    /** 当前弹匣累计射击次数 */
    private static final String SHOT_COUNT_TAG = "PrecisionInstrumentShotCount";
    /** 当前弹匣容量 */
    private static final String MAGAZINE_SIZE_TAG = "PrecisionInstrumentMagazineSize";
    /** 上一tick的弹药数 */
    private static final String PREV_AMMO_TAG = "PrecisionInstrumentPrevAmmo";
    /** 爆头伤害加成 */
    private static final String HEADSHOT_MULTIPLIER_TAG = "PrecisionInstrumentHeadshotMultiplier";

    /**
     * 枪械伤害事件：精准工具
     * 累计射击次数，达到阈值后增加爆头伤害加成
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PRECISION_INSTRUMENT.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt(PREV_AMMO_TAG);
        tag.putInt(PREV_AMMO_TAG, currentAmmo);

        // 检测射击：弹药减少时累计射击次数
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            int shotsFired = tag.getInt(SHOT_COUNT_TAG) + (prevAmmo - currentAmmo);
            tag.putInt(SHOT_COUNT_TAG, shotsFired);

            // 首次射击时获取并缓存弹匣容量
            if (tag.getInt(MAGAZINE_SIZE_TAG) == 0) {
                Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
                if (gunIndexOpt.isPresent()) {
                    int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
                    tag.putInt(MAGAZINE_SIZE_TAG, magazineSize);
                }
            }

            int magazineSize = tag.getInt(MAGAZINE_SIZE_TAG);
            if (magazineSize > 0) {
                // 计算触发所需射击次数（弹匣容量 × 配置比例）
                int requiredShots = (int) Math.ceil(magazineSize * TBZServerConfig.PRECISION_INSTRUMENT_FIRE_PERCENTAGE.get());

                // 检查是否达到触发条件
                if (shotsFired >= requiredShots) {
                    // 获取每次触发增加的爆头伤害加成
                    float multiplierBonus = TBZServerConfig.PRECISION_INSTRUMENT_MULTIPLIER_BONUS.get().floatValue();
                    float currentMultiplier = tag.getFloat(HEADSHOT_MULTIPLIER_TAG);
                    float newMultiplier = currentMultiplier + multiplierBonus;  // 累加加成
                    tag.putFloat(HEADSHOT_MULTIPLIER_TAG, newMultiplier);

                    // 重置射击计数，准备下一次触发
                    tag.putInt(SHOT_COUNT_TAG, 0);
                }
            }
        }

        // 检查当前射击是否已应用伤害加成
        if (ShotTriggerHelper.checkAndMarkTriggered(gun, TRIGGER_TAG_PREFIX)) {
            return;
        }

        // 应用爆头伤害加成到本次伤害中
        float headshotMultiplier = tag.getFloat(HEADSHOT_MULTIPLIER_TAG);
        if (headshotMultiplier > 0) {
            // 伤害公式：原伤害 × (1 + 累计加成)
            float newDamage = event.getBaseAmount() * (1.0f + headshotMultiplier);
            event.setBaseAmount(newDamage);
        }
    }

    /**
     * 换弹开始事件：精准工具
     * 重置所有计数，清除爆头伤害加成
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        net.minecraft.world.entity.LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.PRECISION_INSTRUMENT.get());
        if (enchantLevel <= 0) return;

        // 重置所有计数器
        CompoundTag tag = gun.getOrCreateTag();
        tag.putInt(SHOT_COUNT_TAG, 0);
        tag.putInt(MAGAZINE_SIZE_TAG, 0);
        tag.putInt(PREV_AMMO_TAG, 0);
        tag.putFloat(HEADSHOT_MULTIPLIER_TAG, 0);
    }
}