package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 不法之徒附魔的事件处理类
 * <p>
 * 功能：精准击杀可大幅缩短填装时间
 * 机制：
 * 1. 枪械命中目标时检测是否为爆头，记录爆头标记和命中时间
 * 2. 击杀目标时验证爆头标记是否在有效时间窗口内（60刻/3秒）
 * 3. 有效爆头击杀保留标记，等待换弹时触发效果
 * 4. 换弹时检查是否存在有效的爆头击杀标记：
 *    a. 无标记或超时 → 不触发效果并清除标记
 *    b. 标记有效 → 触发快速装填奖励
 * 5. 快速装填奖励：从背包消耗弹药并补充到弹匣
 *    a. 补充弹药量 = 弹匣容量 × 装填倍率（向上取整）
 *    b. 不超过弹匣剩余空间和背包可用弹药量
 * 6. 触发后立即清除爆头击杀标记（一次性效果）
 * 7. 装填倍率固定从配置读取，不随附魔等级变化
 * 8. 每个爆头击杀标记仅能触发一次快速装填
 */
public class OutlawEvent {

    // NBT标签常量
    public static final String HEADSHOT_KILL_TAG = "OutlawHeadshotKill"; // 是否获得爆头击杀标记
    public static final String KILL_TIME_TAG = "OutlawKillTime"; // 爆头击杀发生时间
    public static final int VALID_KILL_TICKS = 60; // 有效时间窗口

    /**
     * 枪械命中实体事件处理
     * 记录爆头命中，等待后续击杀确认
     *
     * @param event 枪械伤害事件（Pre阶段）
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 标记爆头命中，记录时间（等待击杀确认）
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(HEADSHOT_KILL_TAG, true);
        tag.putLong(KILL_TIME_TAG, player.level().getGameTime());
    }

    /**
     * 击杀事件处理
     * 验证爆头命中是否导致了击杀，如果未在有效时间内击杀则清除标记
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        // 没有爆头命中标记，忽略
        if (!tag.getBoolean(HEADSHOT_KILL_TAG)) return;

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(KILL_TIME_TAG);

        // 如果爆头时间到击杀时间超过有效窗口，清除标记（爆头未导致击杀或超时）
        if (currentTime - killTime > VALID_KILL_TICKS) {
            tag.putBoolean(HEADSHOT_KILL_TAG, false);
            // 注意：这里不清除KILL_TIME_TAG，但标记已失效
        }
        // 如果时间有效，保留标记，等待换弹时使用
    }

    /**
     * 换弹事件处理（核心逻辑）
     * 如果在有效时间内有爆头击杀标记，则触发快速装填效果
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        net.minecraft.world.entity.LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        // 没有爆头击杀标记，不触发效果
        if (!tag.getBoolean(HEADSHOT_KILL_TAG)) return;

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(KILL_TIME_TAG);

        // 检查是否超过有效时间窗口
        if (currentTime - killTime > VALID_KILL_TICKS) {
            tag.putBoolean(HEADSHOT_KILL_TAG, false);  // 标记已失效，清除
            return;
        }

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 获取枪械数据
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        if (gunIndexOpt.isEmpty()) return;

        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);

        // 仅在弹匣未满时补充弹药
        if (currentAmmo < magazineSize) {
            // 获取装填速度倍率（从配置读取）
            float reloadSpeedMultiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
            // 计算应补充的弹药量 = 弹匣容量 × 倍率（向上取整）
            int ammoToAdd = (int) Math.ceil(magazineSize * reloadSpeedMultiplier);
            // 限制不超过弹匣剩余空间
            ammoToAdd = Math.min(ammoToAdd, magazineSize - currentAmmo);

            // 获取枪械使用的弹药类型
            ResourceLocation ammoId = gunIndexOpt.get().getGunData().getAmmoId();
            int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);

            // 背包有弹药才进行补充
            if (availableAmmo > 0) {
                // 实际补充量不超过背包可用弹药
                ammoToAdd = Math.min(ammoToAdd, availableAmmo);
                // 从背包扣除弹药
                AmmoUtils.consumeAmmoFromInventory(player, ammoId, ammoToAdd);
                // 装填到枪械
                iGun.setCurrentAmmoCount(gun, currentAmmo + ammoToAdd);
            }
        }

        // 清除爆头击杀标记
        tag.putBoolean(HEADSHOT_KILL_TAG, false);
    }
}