package com.chinaex123.tbz.recoil.modifier;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.AimingState;
import com.chinaex123.tbz.recoil.RecoilModifierRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import static com.chinaex123.tbz.recoil.RecoilModifierRegistry.RecoilType;

/** 测距仪附魔的后坐力修改器 **/
public class RangefinderRecoilModifier implements RecoilModifierRegistry.RecoilModifier {

    public static void register() {
        RecoilModifierRegistry.register(new RangefinderRecoilModifier());
    }

    /**
     * 判断是否应应用该修改器
     *
     * @param type 后坐力类型
     * @param player 射击者实体
     * @param itemStack 枪械物品
     * @return true表示应用修改，false表示不应用
     */
    @Override
    public boolean shouldApply(RecoilType type, LivingEntity player, ItemStack itemStack) {
        // 只在玩家使用时生效
        if (!(player instanceof Player mcPlayer)) {
            return false;
        }

        // 只在瞄准时生效
        if (!AimingState.isAiming(mcPlayer)) {
            return false;
        }

        // 检查物品是否拥有测距仪附魔
        int level = itemStack.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
        return level > 0;
    }

    /**
     * 应用后坐力修改
     *
     * @param value 原始后坐力值
     * @param type 后坐力类型
     * @param player 射击者实体
     * @param itemStack 枪械物品
     * @return 修改后的后坐力值
     */
    @Override
    public double apply(double value, RecoilType type, LivingEntity player, ItemStack itemStack) {
        // 只修改垂直方向的后坐力
        if (type != RecoilType.PITCH) {
            return value;
        }

        // 获取附魔等级
        int level = itemStack.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
        
        // 从配置获取每级垂直后坐力减少因子
        float reductionFactorPerLevel = TBZServerConfig.RANGEFINDER_RECOIL_REDUCTION_PER_LEVEL.get().floatValue();
        
        // 计算总减少因子：1 - (1 - 因子) × 等级（如1级：0.90，2级：0.80，3级：0.70）
        float totalReductionFactor = 1.0f - (1.0f - reductionFactorPerLevel) * level;
        
        // 应用减少效果：原始值 × 总减少因子
        return value * totalReductionFactor;
    }
}