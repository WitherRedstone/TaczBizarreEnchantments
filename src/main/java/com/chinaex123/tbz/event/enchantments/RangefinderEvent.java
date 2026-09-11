package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.AimingState;
import com.chinaex123.tbz.utils.GunPropertyHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 测距仪附魔的事件处理类
 * <p>
 * 功能：瞄准可提高优势射程
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家瞄准时，根据附魔等级增加优势射程</li>
 *   <li>优势射程增加：每级增加25%的优势射程</li>
 *   <li>停止瞄准时恢复正常数值</li>
 * </ol>
 */
public class RangefinderEvent {

    /** NBT存储键：原始优势射程 **/
    private static final String ORIGINAL_EFFECTIVE_RANGE_TAG = "RangefinderOriginalEffectiveRange";

    /**
     * 枪械伤害事件：测距仪
     * 瞄准时修改有效射程，提高优势射程
     * <p>
     * 触发条件：玩家正在开镜瞄准
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        // 获取攻击者，需要检查是否是玩家
        var attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
        if (enchantLevel <= 0) return;

        // 获取IGun接口
        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        boolean isAiming = AimingState.isAiming(player);

        // 从配置获取每级射程提升百分比（0.45 = 每级增加45%）
        double effectiveRangeBonus = TBZServerConfig.RANGEFINDER_ADS_RANGE_BONUS.get();

        if (isAiming) {
            // 瞄准时增加优势射程
            GunPropertyHelper.EffectiveRange.update(player, gun, true, enchantLevel, 1.0 + effectiveRangeBonus);
        } else {
            // 停止瞄准时恢复正常数值
            GunPropertyHelper.EffectiveRange.update(player, gun, false, enchantLevel, 1.0 + effectiveRangeBonus);
        }
    }
}