package com.chinaex123.tbz.recoil.modifier;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.recoil.RecoilModifierRegistry;
import com.chinaex123.tbz.utils.GunTypeHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import static com.chinaex123.tbz.recoil.RecoilModifierRegistry.RecoilType;

/** 稳若磐石附魔的后坐力修改器 **/
public class FirmlyPlantedRecoilModifier implements RecoilModifierRegistry.RecoilModifier {

    public static void register() {
        RecoilModifierRegistry.register(new FirmlyPlantedRecoilModifier());
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
        // 只在潜行时生效
        if (!player.isShiftKeyDown()) {
            return false;
        }

        // 检查物品是否拥有稳若磐石附魔
        int level = itemStack.getEnchantmentLevel(TBZEnchantments.FIRMLY_PLANTED.get());
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
        // 只修改俯仰方向的后坐力
        if (type != RecoilType.PITCH) {
            return value;
        }

        // 从配置获取后坐力减少比例
        float reduction = TBZServerConfig.FIRMLY_PLANTED_RECOIL_REDUCTION.get().floatValue();

        // 霰弹枪特殊处理：效果减半
        if (GunTypeHelper.isShotgun(itemStack)) {
            // 仅对负值（向上后坐力）进行修改
            if (value < 0) {
                float shotgunReduction = reduction * 0.5f;
                // 使用除法实现减少效果：除以(1 - 减少比例)
                return value / (1.0f - shotgunReduction);
            }
            // 正值（向下后坐力）保持不变
            return value;
        }

        // 普通枪械：应用完整减少效果
        return value / (1.0f - reduction);
    }
}