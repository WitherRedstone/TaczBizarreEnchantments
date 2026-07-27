package com.chinaex123.tbz.mixin.client;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.client.gameplay.LocalPlayerAim;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * 玩家瞄准混入类
 * <p>
 * 用于修改瞄准进度
 */
@OnlyIn(Dist.CLIENT)
@Mixin(value = LocalPlayerAim.class, remap = false)
public class LocalPlayerAimMixin {

    @Final
    @Shadow
    private LocalPlayer player;

    @Shadow
    public boolean isAim() {
        return false;
    }

    /**
     * 修改瞄准进度方法
     * 在原始方法返回后，如果玩家正在瞄准且主手持有附魔了速射瞄准的物品，
     * 则根据配置的加成值加速瞄准进度
     *
     * @param cir 回调信息返回对象，包含原始的瞄准进度值
     */
    @Inject(
            method = "getAlphaProgress",
            at = @At("RETURN"),
            remap = false,
            cancellable = true
    )
    private void modifyAimProgress(CallbackInfoReturnable<Float> cir) {
        // 如果玩家未在瞄准状态，直接返回
        if (!isAim()) {
            return;
        }

        // 检查玩家对象是否为空
        if (player == null) {
            return;
        }

        // 获取玩家主手物品
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }

        // 检查主手物品是否拥有速射瞄准附魔
        int enchantLevel = mainHandItem.getEnchantmentLevel(TBZEnchantments.SNAPSHOT_SIGHTS.get());
        if (enchantLevel <= 0) {
            return;
        }

        // 获取原始瞄准进度
        float originalProgress = cir.getReturnValue();

        // 从配置中获取瞄准速度加成值，并计算速度倍率
        float bonus = TBZServerConfig.SNAPSHOT_SIGHTS_AIM_SPEED_BONUS.get().floatValue();
        float speedMultiplier = 1.0f + bonus;

        // 计算新的瞄准进度
        float newProgress = originalProgress * speedMultiplier;

        // 将修改后的进度设置回返回值
        cir.setReturnValue(newProgress);
    }
}