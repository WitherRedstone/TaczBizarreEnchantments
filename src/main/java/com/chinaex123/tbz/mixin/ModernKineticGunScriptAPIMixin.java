package com.chinaex123.tbz.mixin;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ReloadContextHolder;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.tacz.guns.resource.pojo.data.gun.InaccuracyType;
import com.tacz.guns.item.ModernKineticGunScriptAPI;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/**
 * 现代动能枪械脚本API混入类
 * <p>
 * 功能：应用附魔对枪械精度的加成效果
 * 在射击时修改散布值，实现武器的精度提升
 */
@Mixin(value = ModernKineticGunScriptAPI.class, remap = false)
public class ModernKineticGunScriptAPIMixin {

    @Shadow
    private ItemStack itemStack;

    /**
     * 应用附魔精度加成
     * 在计算散布值时，根据附魔效果修改精度值
     *
     * @param original 原始散布值
     * @param inaccuracyType 散布类型（瞄准/腰射）
     * @return 修改后的散布值
     */
    @Definition(id = "inaccuracy", local = @Local(type = float.class, name = "inaccuracy"))
    @Expression("inaccuracy = @(?)")
    @ModifyExpressionValue(
            method = "shootOnce",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private float applyEnchantmentAccuracyBonus(float original, @Local(name = "inaccuracyType") InaccuracyType inaccuracyType) {
        Player player = ReloadContextHolder.getPlayer();
        if (player == null || itemStack == null || itemStack.isEmpty()) {
            return original;
        }

        float totalAccuracyBonus = 0;

        // 测距仪（Rangefinder）：瞄准时提升精度
        int rangefinderLevel = itemStack.getEnchantmentLevel(TBZEnchantments.RANGEFINDER.get());
        if (rangefinderLevel > 0 && inaccuracyType == InaccuracyType.AIM) {
            // 配置值是直观的提升比例（0.15表示提升15%），转换为因子：因子 = 1.0 - 配置值
            float accuracyImprovementPerLevel = TBZServerConfig.RANGEFINDER_AIM_ACCURACY_IMPROVEMENT_PER_LEVEL.get().floatValue();
            float factorPerLevel = 1.0f - accuracyImprovementPerLevel;
            // 计算总因子：总因子 = 1.0 - (1.0 - 每级因子) × 等级
            float totalImprovementFactor = 1.0f - (1.0f - factorPerLevel) * rangefinderLevel;
            totalAccuracyBonus += (1.0f - totalImprovementFactor);
        }

        // 稳若磐石（Firmly Planted）：潜行时提升精度
        int firmlyPlantedLevel = itemStack.getEnchantmentLevel(TBZEnchantments.FIRMLY_PLANTED.get());
        if (firmlyPlantedLevel > 0 && player.isShiftKeyDown() && inaccuracyType == InaccuracyType.AIM) {
            // 配置值是直观的减少比例（0.25表示减少25%），转换为因子：因子 = 1.0 - 配置值
            float spreadReduction = TBZServerConfig.FIRMLY_PLANTED_SPREAD_REDUCTION.get().floatValue();
            float factor = 1.0f - spreadReduction;
            totalAccuracyBonus += (1.0f - factor);
        }

        // 风暴之眼（Eye of Storm）：生命值越低，精度越高
        int eyeOfStormEyeLevel = itemStack.getEnchantmentLevel(TBZEnchantments.EYE_OF_STORM_EYE.get());
        if (eyeOfStormEyeLevel > 0) {
            // 计算生命值比例：生命值越低，加成越高
            float healthRatio = player.getHealth() / player.getMaxHealth();
            // 配置值是直观的提升比例（0.40表示提升40%），转换为因子：因子 = 1.0 - 配置值
            float accuracyBonus = TBZServerConfig.EYE_OF_STORM_EYE_ACCURACY_BONUS.get().floatValue();
            float baseFactor = 1.0f - accuracyBonus;
            // 生命值越低，因子越小（精度提升越大）：因子 = 基础因子 + (1 - 基础因子) * 生命值比例
            float dynamicFactor = baseFactor + (1.0f - baseFactor) * healthRatio;
            totalAccuracyBonus += (1.0f - dynamicFactor);
        }

        // 如果没有精度加成，返回原始值
        if (totalAccuracyBonus <= 0) {
            return original;
        }

        // 计算新散布值：新精度 = 原始精度 × (1 - 精度提升百分比)
        // 例如：原始散布 0.1，提升 30% => 新散布 = 0.1 × 0.7 = 0.07
        return original * (1.0f - totalAccuracyBonus);
    }
}