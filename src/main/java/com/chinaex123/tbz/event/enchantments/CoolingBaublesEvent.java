package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.item.ModernKineticGunScriptAPI;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 冷却饰物附魔的事件处理类
 * <p>
 * 功能：拾取经验球时降低枪械的热量
 * <p>
 * 机制：
 * <ol>
 *   <li>玩家拾取经验球时触发检测</li>
 *   <li>检查主手武器是否拥有冷却饰物附魔</li>
 *   <li>检查冷却时间是否已过</li>
 *   <li>根据配置的几率判定是否触发冷却效果</li>
 *   <li>触发时按弹匣最大热量的一定比例降低当前热量</li>
 *   <li>降低后的热量不会低于0</li>
 *   <li>触发后记录冷却时间</li>
 * </ol>
 */
public class CoolingBaublesEvent {

    /** 记录每个玩家上次触发冷却的时间 */
    private static final Map<UUID, Long> lastCoolTimeMap = new ConcurrentHashMap<>();

    /**
     * 经验值变化事件：冷却饰物
     * 当玩家经验值变化时，有几率降低主手枪械的热量
     *
     * @param event 经验值变化事件
     */
    public static void onPlayerXp(PlayerXpEvent event) {
        Player player = event.getEntity();
        if (player == null) return;

        // 获取玩家主手武器
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有冷却饰物附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.COOLING_BAUBLES.get());
        if (enchantLevel <= 0) return;

        try {
            UUID playerId = player.getUUID();
            long currentTime = player.level().getGameTime();
            int cooldownTicks = TBZServerConfig.COOLING_BAUBLES_COOLDOWN_TICKS.get();

            // 检查冷却时间是否已过
            if (lastCoolTimeMap.containsKey(playerId)) {
                long lastCoolTime = lastCoolTimeMap.get(playerId);
                if (currentTime - lastCoolTime < cooldownTicks) {
                    return;  // 冷却中，不触发
                }
            }

            // 从配置读取触发几率和热量减少比例
            float chance = TBZServerConfig.COOLING_BAUBLES_COOL_CHANCE.get().floatValue();
            float heatReduction = TBZServerConfig.COOLING_BAUBLES_HEAT_REDUCTION.get().floatValue();

            // 根据几率判定是否触发冷却效果
            if (player.level().random.nextFloat() < chance) {
                reduceGunHeat(player, gun, heatReduction);
                // 记录本次触发时间
                lastCoolTimeMap.put(playerId, currentTime);
            }
        } catch (Exception e) {
            // 忽略异常
        }
    }

    /**
     * 降低枪械热量的核心逻辑
     * 根据弹匣最大热量的一定比例减少当前热量
     *
     * @param player 玩家对象
     * @param gun 枪械物品
     * @param reductionPercent 热量减少比例（0.0~1.0），表示减少最大热量的百分比
     */
    private static void reduceGunHeat(Player player, ItemStack gun, float reductionPercent) {
        try {
            // 获取枪械API实例，用于操作热度数据
            ModernKineticGunScriptAPI gunAPI = new ModernKineticGunScriptAPI();
            gunAPI.setShooter(player);
            gunAPI.setItemStack(gun);
            IGunOperator operator = IGunOperator.fromLivingEntity(player);
            gunAPI.setDataHolder(operator.getDataHolder());

            // 获取当前热度和最大热度
            float heatAmount = gunAPI.getHeatAmount();
            float heatMax = gunAPI.getHeatMax();

            // 如果最大热度无效或当前热度已为0，无需处理
            if (heatMax <= 0 || heatAmount <= 0) {
                return;
            }

            // 计算减少量：最大热度 × 减少比例
            float reductionAmount = heatMax * reductionPercent;
            // 新热度 = 当前热度 - 减少量，且不低于0
            float newHeat = Math.max(0, heatAmount - reductionAmount);

            // 更新枪械的热度值
            gunAPI.setHeatAmount(newHeat);

        } catch (Exception e) {
            // 忽略异常
        }
    }

    /**
     * 清除玩家的冷却时间记录
     *
     * @param playerId 玩家UUID
     */
    public static void clearCooldown(UUID playerId) {
        lastCoolTimeMap.remove(playerId);
    }
}