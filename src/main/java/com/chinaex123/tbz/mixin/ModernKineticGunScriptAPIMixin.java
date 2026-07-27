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

        // 稳若磐石（Firmly Planted）：潜行时提升精度
        int firmlyPlantedLevel = itemStack.getEnchantmentLevel(TBZEnchantments.FIRMLY_PLANTED.get());
        if (firmlyPlantedLevel > 0 && player.isShiftKeyDown() && inaccuracyType == InaccuracyType.AIM) {
            // 仅在瞄准状态下潜行时生效
            totalAccuracyBonus += TBZServerConfig.FIRMLY_PLANTED_SPREAD_REDUCTION.get().floatValue();
        }

        // 风暴之眼（Eye of Storm）：生命值越低，精度越高
        int eyeOfStormEyeLevel = itemStack.getEnchantmentLevel(TBZEnchantments.EYE_OF_STORM_EYE.get());
        if (eyeOfStormEyeLevel > 0) {
            // 计算生命值比例：生命值越低，加成越高
            float healthRatio = player.getHealth() / player.getMaxHealth();
            float healthBonus = (1.0f - healthRatio) * TBZServerConfig.EYE_OF_STORM_EYE_ACCURACY_BONUS.get().floatValue();
            totalAccuracyBonus += healthBonus;
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