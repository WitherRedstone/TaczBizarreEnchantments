package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 重新调度附魔的事件处理类
 * <p>
 * 功能：子弹未命中时有几率直接向弹匣返还弹药
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家射击时（弹药减少）记录射击时间并标记为待判定状态</li>
 *   <li>射击后5刻（0.25秒）内若有命中事件发生，取消弹药返还（说明命中了）</li>
 *   <li>若5刻内无命中记录，触发弹药返还判定：
 *     <ol type="a">
 *       <li>计算返还概率：基础概率 + (等级 - 1) × 每级增加概率</li>
 *       <li>概率判定成功则返还1发弹药到弹匣</li>
 *       <li>仅当弹匣未满时才返还弹药（防止溢出）</li>
 *     </ol>
 *   </li>
 *   <li>每次射击独立判定，命中优先取消返还</li>
 *   <li>判定完成后清除待判定状态，等待下次射击</li>
 *   <li>返还概率随附魔等级提升而增加</li>
 * </ol>
 */
public class MulliganEvent {

    /** 射击时间记录 */
    private static final String SHOT_TIME_TAG = "MulliganShotTime";
    /** 是否等待弹药返还判定 */
    private static final String PENDING_RETURN_TAG = "MulliganPendingReturn";
    /** 射击后等待5刻（0.25秒）再检查是否命中 */
    private static final int CHECK_DELAY_TICKS = 5;

    // 记录每个玩家最后一次射击的时间（线程安全）
    private static final Map<UUID, Long> lastShotTimeMap = new ConcurrentHashMap<>();

    /**
     * 枪械伤害事件：重新调度
     * 如果射击后短时间内有命中记录，则取消弹药返还
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MULLIGAN.get());
        if (enchantLevel <= 0) return;

        UUID playerId = player.getUUID();
        Long shotTime = lastShotTimeMap.get(playerId);

        // 如果这次命中发生在射击后的检查窗口内，则取消弹药返还（标记为已命中）
        if (shotTime != null && player.level().getGameTime() - shotTime < CHECK_DELAY_TICKS) {
            CompoundTag tag = gun.getOrCreateTag();
            tag.putBoolean(PENDING_RETURN_TAG, false);
            lastShotTimeMap.remove(playerId);
        }
    }

    /**
     * 玩家每帧更新事件：重新调度
     * 检测射击行为，标记待返还状态，等待延迟后，如果没有被命中事件取消，则根据概率返还弹药
     *
     * @param player 玩家实体
     */
    public static void onPlayerTick(Player player) {
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.MULLIGAN.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt("MulliganPrevAmmo");
        tag.putInt("MulliganPrevAmmo", currentAmmo);

        UUID playerId = player.getUUID();

        // 检测射击行为：弹药减少时记录射击时间，并标记等待返还判定
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            lastShotTimeMap.put(playerId, player.level().getGameTime());
            tag.putBoolean(PENDING_RETURN_TAG, true);
        }

        // 处理等待弹药返还判定的射击
        if (tag.getBoolean(PENDING_RETURN_TAG)) {
            Long shotTime = lastShotTimeMap.get(playerId);
            // 检查是否已超过等待时间窗口（5刻）
            if (shotTime != null && player.level().getGameTime() - shotTime >= CHECK_DELAY_TICKS) {
                // 计算弹药返还概率
                // 公式：基础概率 + (等级 - 1) × 每级增加概率
                float baseChance = TBZConfig.MULLIGAN_BASE_CHANCE.get().floatValue();
                float chancePerLevel = TBZConfig.MULLIGAN_CHANCE_PER_LEVEL.get().floatValue();
                float totalChance = baseChance + (enchantLevel - 1) * chancePerLevel;

                // 概率判定：成功则返还1发弹药
                if (player.getRandom().nextFloat() < totalChance) {
                    Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
                    if (gunIndexOpt.isPresent()) {
                        int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
                        // 仅在未达到弹匣容量时返还弹药
                        if (currentAmmo < magazineSize) {
                            iGun.setCurrentAmmoCount(gun, currentAmmo + 1);
                        }
                    }
                }

                // 清理状态，判定完成
                tag.putBoolean(PENDING_RETURN_TAG, false);
                lastShotTimeMap.remove(playerId);
            }
        }
    }
}