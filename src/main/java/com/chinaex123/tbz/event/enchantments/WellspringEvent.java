package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

/**
 * 泉源附魔的事件处理类
 * <p>
 * 功能：使用此武器造成击杀会产生经验球
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家击杀敌人时触发效果</li>
 *   <li>随机产生1-3点经验值</li>
 *   <li>经验值以经验球的形式掉落在被击杀实体的位置</li>
 *   <li>每次击杀都会产生经验球，无冷却限制</li>
 *   <li>经验值范围从配置读取</li>
 *   <li>附魔经验球是额外奖励，不会影响生物原本的经验掉落</li>
 * </ol>
 */
public class WellspringEvent {

    /**
     * 实体死亡事件：泉源
     * 产生经验球
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     * @param entity 被击杀的实体
     */
    public static void onKill(Player player, ItemStack gun, Entity entity) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.WELLSPRING.get());
        if (enchantLevel <= 0) return;

        // 从配置获取经验值范围
        int minExp = TBZConfig.WELLSPRING_MIN_EXP.get();
        int maxExp = TBZConfig.WELLSPRING_MAX_EXP.get();

        // 随机产生经验值
        int expAmount = player.getRandom().nextInt(maxExp - minExp + 1) + minExp;

        // 产生经验球
        if (expAmount > 0) {
            // 在服务端生成经验球
            if (player.level() instanceof ServerLevel serverLevel) {
                ExperienceOrb orb = new ExperienceOrb(serverLevel, entity.getX(), entity.getY(), entity.getZ(), expAmount);
                serverLevel.addFreshEntity(orb);
            }
        }
    }
}