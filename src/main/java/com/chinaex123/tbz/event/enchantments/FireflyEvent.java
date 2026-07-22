package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.ExplosionUtils;
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
 * 萤火虫附魔的事件处理类
 * <p>
 * 功能：完成精准击杀可以提高填装速度并使目标爆炸
 * <p>
 * 机制：
 * <ol>
 *   <li>枪械命中目标时检测是否为爆头，记录爆头标记和命中时间</li>
 *   <li>击杀目标时检查是否存在有效的爆头命中标记</li>
 *   <li>若爆头时间到击杀时间的间隔在有效窗口内（60刻/3秒），判定为有效爆头击杀</li>
 *   <li>有效爆头击杀触发爆炸效果，对目标造成范围溅射伤害</li>
 *   <li>爆炸伤害随附魔等级提升：基础伤害 + 每级额外伤害</li>
 *   <li>换弹时触发弹药补给效果（无论是否有爆头标记）：
 *     <ol type="a">
 *       <li>根据附魔等级计算装填速度倍率（装填倍率 = 基础值 + 每级额外值）</li>
 *       <li>计算可补充弹药量 = 弹匣容量 × 装填倍率（向上取整）</li>
 *       <li>从玩家背包消耗对应弹药，补充到枪械弹匣中（不超过弹匣剩余空间）</li>
 *     </ol>
 *   </li>
 *   <li>仅当弹匣未满且背包有足够弹药时才会补充</li>
 *   <li>爆头标记触发后或超时后自动清除，防止重复触发</li>
 * </ol>
 */
public class FireflyEvent {

    /** 是否获得爆头击杀标记 */
    public static final String HEADSHOT_KILL_TAG = "FireflyHeadshotKill";
    /** 爆头击杀发生时间 */
    public static final String KILL_TIME_TAG = "FireflyKillTime";
    /** 有效时间窗口 */
    public static final int VALID_KILL_TICKS = 60;

    /**
     * 枪械伤害事件：萤火虫
     * 记录爆头命中次数，等待后续击杀确认
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

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FIREFLY.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 标记爆头命中，记录时间
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(HEADSHOT_KILL_TAG, true);
        tag.putLong(KILL_TIME_TAG, player.level().getGameTime());
    }

    /**
     * 实体死亡事件：萤火虫
     * 验证爆头命中是否导致了击杀，如果有效则触发爆炸效果
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FIREFLY.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        // 没有爆头命中标记，忽略
        if (!tag.getBoolean(HEADSHOT_KILL_TAG)) return;

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(KILL_TIME_TAG);

        // 如果爆头时间到击杀时间超过有效窗口，清除标记（爆头未导致击杀或超时）
        if (currentTime - killTime > VALID_KILL_TICKS) {
            tag.putBoolean(HEADSHOT_KILL_TAG, false);
            return;
        }

        // 触发爆炸效果
        float damage = TBZConfig.FIREFLY_BASE_DAMAGE.get().floatValue()
                + TBZConfig.FIREFLY_DAMAGE_PER_LEVEL.get().floatValue() * enchantLevel;
        float splashMin = TBZConfig.FIREFLY_SPLASH_MIN.get().floatValue();
        float splashMax = TBZConfig.FIREFLY_SPLASH_MAX.get().floatValue();
        double range = TBZConfig.FIREFLY_RANGE.get();
        ExplosionUtils.dealSmallExplosionDamage(target, damage, splashMin, splashMax, range);

        // 清除爆头击杀标记
        tag.putBoolean(HEADSHOT_KILL_TAG, false);
    }

    /**
     * 换弹开始事件：萤火虫
     * 如果有爆头击杀标记，则直接向弹匣补充弹药
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.FIREFLY.get());
        if (enchantLevel <= 0) return;

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
            float reloadSpeedMultiplier = TBZConfig.FIREFLY_BASE_RELOAD_SPEED.get().floatValue()
                    + TBZConfig.FIREFLY_RELOAD_SPEED_PER_LEVEL.get().floatValue() * enchantLevel;
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
    }
}