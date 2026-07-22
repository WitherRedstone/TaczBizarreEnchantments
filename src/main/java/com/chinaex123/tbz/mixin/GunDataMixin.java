package com.chinaex123.tbz.mixin;

import com.chinaex123.tbz.api.IShootIntervalAdjuster;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.api.item.gun.FireMode;
import com.tacz.guns.entity.shooter.ShooterDataHolder;
import com.tacz.guns.resource.pojo.data.gun.GunData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * 枪械数据混入类
 * <p>
 * 功能：用于修改枪械的射击间隔，实现武器的射速变化效果
 */
@Mixin(value = GunData.class, remap = false)
public class GunDataMixin {

    /**
     * 修改射击间隔方法
     *
     * @param shooter 射击者实体
     * @param fireMode 射击模式
     * @param gunStack 枪械物品堆
     * @param cir 回调信息返回对象，包含原始射击间隔
     */
    @Inject(
            method = "getShootInterval",
            at = @At("RETURN"),
            cancellable = true
    )
    private void modifyShootInterval(LivingEntity shooter, FireMode fireMode, ItemStack gunStack, CallbackInfoReturnable<Long> cir) {
        long original = cir.getReturnValue();
        if (shooter == null) return;

        try {
            // 获取射击者的数据持有者
            IGunOperator gunOperator = IGunOperator.fromLivingEntity(shooter);
            ShooterDataHolder dataHolder = gunOperator.getDataHolder();

            // 检查是否实现了柔缓调整器接口
            if (dataHolder instanceof IShootIntervalAdjuster adjuster) {
                long additional = adjuster.tbz$GetAdditionalInterval();
                // 如果有额外的延迟时间（正数=减速，负数=加速），应用到原始射击间隔中
                if (additional != 0) {
                    long newInterval = original + additional;
                    // 确保射击间隔不会小于最小值（防止射速过快）
                    if (newInterval < 50) {
                        newInterval = 50;
                    }
                    cir.setReturnValue(newInterval);
                }
            }
        } catch (Exception e) {
            // 捕获异常并忽略，避免影响正常游戏流程
        }
    }
}