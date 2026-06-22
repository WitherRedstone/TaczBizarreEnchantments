package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 治疗弹匣附魔的事件处理类
 * <p>
 * 功能：最后一击后短时间内填装，可为自身提供治愈
 * 机制：
 * 1. 玩家击杀敌人时记录附魔等级和击杀时间
 * 2. 击杀后等待换弹触发治疗效果（仅限一次）
 * 3. 若击杀后40刻（2秒）内完成换弹，触发治疗
 * 4. 治疗强度随附魔等级提升：基础放大器 + (等级 - 1) × 每级增量
 * 5. 施加CURE效果（瞬间恢复生命值），持续时间极短（1刻）
 * 6. 触发后清除等待记录，防止重复治疗
 * 7. 若超过时间窗口换弹，则不触发治疗并清除等待记录
 * 8. 每次击杀独立记录，多个击杀不会叠加（后一次覆盖前一次）
 */
public class HealClipEvent {

    private static final int INSTANT_DURATION = 1; // 治疗效果持续时间
    private static final int VALID_RELOAD_TICKS = 40;  // 有效换弹时间窗口

    // 记录每个玩家等待治疗的数据
    private static final Map<UUID, PendingHealData> pendingHealMap = new ConcurrentHashMap<>();

    /**
     * 击杀事件处理
     * 记录本次击杀的附魔等级和发生时间，等待换弹触发治疗
     *
     * @param player 击杀者
     * @param gun    使用的枪械
     */
    public static void onKill(Player player, ItemStack gun) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.HEAL_CLIP.get());
        if (enchantLevel <= 0) return;

        long killTime = player.level().getGameTime();  // 记录击杀时的游戏时间（刻）
        pendingHealMap.put(player.getUUID(), new PendingHealData(enchantLevel, killTime));
    }

    /**
     * 换弹事件处理
     * 检查是否有待触发的治疗，若在有效时间窗口内则施加治疗效果
     *
     * @param player 换弹的玩家
     */
    public static void onReload(Player player) {
        UUID playerId = player.getUUID();

        // 检查是否有等待治疗的击杀记录
        if (pendingHealMap.containsKey(playerId)) {
            PendingHealData data = pendingHealMap.get(playerId);
            long currentTime = player.level().getGameTime();

            // 判断是否在有效时间窗口内
            if (currentTime - data.killTime <= VALID_RELOAD_TICKS) {
                applyHeal(player, data.enchantLevel);  // 触发治疗
            }
            // 无论是否触发治疗，都移除等待记录（一次性使用）
            pendingHealMap.remove(playerId);
        }
    }

    /**
     * 应用治疗效果
     * 根据附魔等级计算药水效果强度并施加CURE效果
     *
     * @param player 目标玩家
     * @param enchantLevel 附魔等级
     */
    private static void applyHeal(Player player, int enchantLevel) {
        // 根据附魔等级计算效果放大器（强度）
        int amplifier = getCureAmplifier(enchantLevel);

        player.addEffect(new MobEffectInstance(FELEffects.CURE.get(), INSTANT_DURATION, amplifier));
    }

    /**
     * 计算CURE药水效果的放大器（强度）
     * 公式：基础放大器 + (附魔等级 - 1) × 每级增量
     *
     * @param level 附魔等级
     * @return 效果放大器值
     */
    private static int getCureAmplifier(int level) {
        return TBZConfig.HEAL_CLIP_BASE_AMPLIFIER.get()
                + (level - 1) * TBZConfig.HEAL_CLIP_AMPLIFIER_PER_LEVEL.get();
    }

    /**
     * 清除玩家的等待治疗数据（用于玩家退出等场景）
     *
     * @param playerId 玩家UUID
     */
    public static void clearPending(UUID playerId) {
        pendingHealMap.remove(playerId);
    }

    /**
     * 等待治疗数据记录
     * 使用record类型存储不可变数据
     *
     * @param enchantLevel 附魔等级
     * @param killTime     击杀时间（游戏刻）
     */
    private record PendingHealData(int enchantLevel, long killTime) {}
}