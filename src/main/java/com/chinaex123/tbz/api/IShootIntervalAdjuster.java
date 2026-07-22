package com.chinaex123.tbz.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 射速调整接口 - 由 ShooterDataHolderMixin 实现
 * <p>
 * 用于管理附魔的射速调整功能（柔缓减速、猛攻加速等）
 * 实现类需要存储和管理额外的射击间隔时间
 */
public interface IShootIntervalAdjuster {

    /**
     * 调整射击间隔
     *
     * @param alpha 调整值（毫秒），正数增加间隔（减速），负数减少间隔（加速）
     */
    void tbz$AdjustShootInterval(long alpha);

    /**
     * 应用射速修改效果
     * 根据附魔类型和等级计算射速调整量并应用到射击间隔中
     *
     * @param player   玩家对象
     * @param level    附魔等级
     * @param gun      枪械物品
     * @param modifier 射速修改倍率（正数=减速，负数=加速）
     * @param duration 持续时间（秒）
     */
    void tbz$ApplyFireRateModifier(Player player, int level, ItemStack gun, float modifier, double duration);

    /**
     * 恢复射速
     * <p>
     * 移除射速修改效果，将射击间隔恢复为正常值
     */
    void tbz$RestoreFireRate();

    /**
     * 更新射速状态
     * <p>
     * 检查是否超时，若超时则自动恢复射速
     */
    void tbz$UpdateFireRateState();

    /**
     * 获取额外的射击间隔
     *
     * @return 额外的延迟时间（毫秒），正数=减速，负数=加速
     */
    long tbz$GetAdditionalInterval();

    /**
     * 设置额外的射击间隔
     *
     * @param value 额外的延迟时间（毫秒）
     */
    void tbz$SetAdditionalInterval(long value);

    /**
     * 设置射速修改状态是否激活
     *
     * @param active true表示激活，false表示停用
     */
    void tbz$SetActive(boolean active);

    /**
     * 设置缓射效果的结束时间
     *
     * @param endTime 结束时间戳（毫秒）
     */
    void tbz$SetEndTime(long endTime);
}