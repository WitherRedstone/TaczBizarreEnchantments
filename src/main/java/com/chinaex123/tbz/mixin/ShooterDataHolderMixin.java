package com.chinaex123.tbz.mixin;

import com.chinaex123.tbz.api.IShootIntervalAdjuster;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.item.gun.AbstractGunItem;
import com.tacz.guns.entity.shooter.ShooterDataHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 射击者数据持有者混入类
 * <p>
 * 功能：实现 IAdagioShootAdjuster 接口，管理武器的射速调整
 */
@Mixin(value = ShooterDataHolder.class, remap = false)
public class ShooterDataHolderMixin implements IShootIntervalAdjuster {

    @Shadow
    public long shootTimestamp;

    // 额外的射击间隔（毫秒），用于实现射速调整
    @Unique
    private long tbz_firerate_additionalInterval = 0;

    // 射速调整效果的结束时间戳
    @Unique
    private long tbz_firerate_endTime = 0;

    // 射速调整状态是否激活
    @Unique
    private boolean tbz_firerate_active = false;

    /**
     * 调整射击间隔
     * 通过修改射击时间戳来实现射速调整
     *
     * @param alpha 调整值（毫秒），正数增加间隔（减速）
     */
    @Override
    @Unique
    public void tbz$AdjustShootInterval(long alpha) {
        this.shootTimestamp += alpha;
    }

    /**
     * 应用射速修改效果
     * 根据附魔类型和等级计算射速调整量并保存到状态中
     *
     * @param player 玩家对象
     * @param level 附魔等级
     * @param gun 枪械物品
     * @param modifier 射速修改倍率（正数=减速，负数=加速）
     * @param duration 持续时间（秒）
     */
    @Override
    @Unique
    public void tbz$ApplyFireRateModifier(Player player, int level, ItemStack gun, float modifier, double duration) {
        if (player == null) return;

        // 获取当前射击间隔
        long currentInterval = tbz$getCurrentShootInterval(player, gun);

        // 计算额外的间隔时间并保存状态
        this.tbz_firerate_additionalInterval = (long)(currentInterval * modifier * level);
        this.tbz_firerate_endTime = System.currentTimeMillis() + (long)(duration * 1000L);
        this.tbz_firerate_active = true;
    }

    /**
     * 恢复射速
     * 清除射速修改状态，重置额外间隔
     */
    @Override
    @Unique
    public void tbz$RestoreFireRate() {
        if (this.tbz_firerate_active && this.tbz_firerate_additionalInterval != 0) {
            this.tbz_firerate_active = false;
            this.tbz_firerate_additionalInterval = 0;
        }
    }

    /**
     * 更新射速状态
     * 检查是否超时，若超时则自动恢复射速
     */
    @Override
    @Unique
    public void tbz$UpdateFireRateState() {
        if (this.tbz_firerate_active) {
            long currentTime = System.currentTimeMillis();
            // 如果当前时间超过结束时间，恢复射速
            if (currentTime >= this.tbz_firerate_endTime) {
                tbz$RestoreFireRate();
            }
        }
    }

    /**
     * 获取额外的射击间隔
     *
     * @return 额外的延迟时间（毫秒）
     */
    @Override
    @Unique
    public long tbz$GetAdditionalInterval() {
        return this.tbz_firerate_additionalInterval;
    }

    /**
     * 设置额外的射击间隔
     *
     * @param value 额外的延迟时间（毫秒）
     */
    @Override
    @Unique
    public void tbz$SetAdditionalInterval(long value) {
        this.tbz_firerate_additionalInterval = value;
    }

    /**
     * 设置射速修改状态是否激活
     *
     * @param active true表示激活，false表示停用
     */
    @Override
    @Unique
    public void tbz$SetActive(boolean active) {
        this.tbz_firerate_active = active;
    }

    /**
     * 设置射速修改效果的结束时间
     *
     * @param endTime 结束时间戳（毫秒）
     */
    @Override
    @Unique
    public void tbz$SetEndTime(long endTime) {
        this.tbz_firerate_endTime = endTime;
    }

    /**
     * 获取当前枪械的射击间隔
     * 从枪械数据中读取基础射击间隔
     *
     * @param player 玩家对象
     * @param gun 枪械物品
     * @return 射击间隔（毫秒），获取失败时返回默认值100
     */
    @Unique
    private long tbz$getCurrentShootInterval(Player player, ItemStack gun) {
        if (!(gun.getItem() instanceof AbstractGunItem gunItem)) {
            return 100;
        }

        try {
            var gunId = gunItem.getGunId(gun);
            var optional = TimelessAPI.getCommonGunIndex(gunId);
            if (optional.isPresent()) {
                var gunData = optional.get().getGunData();
                var fireMode = gunItem.getFireMode(gun);
                return gunData.getShootInterval(player, fireMode, gun);
            }
        } catch (Exception ignored) {
            // 忽略异常，返回默认值
        }

        return 100;
    }

    /**
     * 构造函数注入 - 初始化射速调整状态
     *
     * @param ci 回调信息
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        this.tbz_firerate_additionalInterval = 0;
        this.tbz_firerate_endTime = 0;
        this.tbz_firerate_active = false;
    }
}