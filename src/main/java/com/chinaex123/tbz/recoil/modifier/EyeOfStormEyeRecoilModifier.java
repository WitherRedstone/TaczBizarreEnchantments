package com.chinaex123.tbz.recoil.modifier;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.recoil.RecoilModifierRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import static com.chinaex123.tbz.recoil.RecoilModifierRegistry.RecoilType;

/** 风暴之眼附魔的后坐力修改器 **/
public class EyeOfStormEyeRecoilModifier implements RecoilModifierRegistry.RecoilModifier {

    public static void register() {
        RecoilModifierRegistry.register(new EyeOfStormEyeRecoilModifier());
    }

    /**
     * 判断是否应应用该修改器
     *
     * @param type 后坐力类型（俯仰/偏航）
     * @param player 射击者实体
     * @param itemStack 枪械物品
     * @return true表示应用修改，false表示不应用
     */
    @Override
    public boolean shouldApply(RecoilType type, LivingEntity player, ItemStack itemStack) {
        // 检查物品是否拥有风暴之眼附魔
        int level = itemStack.getEnchantmentLevel(TBZEnchantments.EYE_OF_STORM_EYE.get());
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
        // 只修改偏航方向的后坐力
        if (type != RecoilType.YAW) {
            return value;
        }

        // 计算生命值比例 (0~1)
        float healthRatio = player.getHealth() / player.getMaxHealth();

        // 从配置获取最大减少比例
        float maxReduction = TBZConfig.EYE_OF_STORM_EYE_RECOIL_REDUCTION.get().floatValue();

        // 生命值越低，减少效果越强：reduction = (1 - healthRatio) * maxReduction
        // 满血时 reduction = 0，无效果；濒死时 reduction = maxReduction，效果最大
        float reduction = (1.0f - healthRatio) * maxReduction;

        // 水平后坐力：乘以 (1 + reduction) 实现数值放大 = 更稳定
        // 例如：原始值 1.0，reduction = 0.5，则结果 = 1.5
        return value * (1.0f + reduction);
    }
}