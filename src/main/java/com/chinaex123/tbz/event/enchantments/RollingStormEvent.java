package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.api.BoltChargeAPI;
import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 风暴涌动附魔的事件处理类
 * <p>
 * 功能：击杀生物会提供电光充能
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀敌人时触发效果检测</li>
 *   <li>判断玩家当前是否处于增幅状态：
 *     <ol type="a">
 *       <li>处于增幅状态 → 提供2层电光充能</li>
 *       <li>不处于增幅状态 → 提供1层电光充能</li>
 *     </ol>
 *   </li>
 *   <li>电光充能通过 BoltChargeAPI.addCharge 添加</li>
 *   <li>每次击杀都会提供电光充能，无冷却限制</li>
 *   <li>处于增幅状态时击杀可以获得更多电光充能</li>
 * </ol>
 */
public class RollingStormEvent {

    /**
     * 实体死亡事件：风暴涌动
     * 根据当前是否处于增幅状态，决定提供多少层电光充能
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ROLLING_STORM.get());
        if (enchantLevel <= 0) return;

        // 检查玩家当前是否处于增幅状态
        MobEffectInstance amplifiedEffect = player.getEffect(FELEffects.AMPLIFIED.get());
        boolean isAmplified = amplifiedEffect != null;

        // 根据增幅状态决定提供多少层电光充能
        int chargeAmount = isAmplified ? 2 : 1;

        // 添加电光充能
        BoltChargeAPI.addCharge(player, chargeAmount);
    }
}