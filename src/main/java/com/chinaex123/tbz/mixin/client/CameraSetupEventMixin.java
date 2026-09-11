package com.chinaex123.tbz.mixin.client;

import com.chinaex123.tbz.recoil.RecoilModifierRegistry;
import com.tacz.guns.client.event.CameraSetupEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * 相机设置事件混入类（客户端）
 * <p>
 * 功能：修改 TA:CZ 模组的相机后坐力
 * 通过后坐力修改器注册表，对垂直（Pitch）和水平（Yaw）方向的后坐力进行修改
 */
@Mixin(value = CameraSetupEvent.class, remap = false)
public class CameraSetupEventMixin {

    /**
     * 修改垂直后坐力值（俯仰方向）
     * 在 applyCameraRecoil 方法中 pitch 样条函数计算后存储到变量时，修改后坐力值
     *
     * @param value 原始垂直后坐力值
     * @return 修改后的垂直后坐力值
     */
    @ModifyVariable(
            method = "applyCameraRecoil",
            at = @At(
                    value = "STORE",
                    ordinal = 0
            ),
            remap = false,
            name = "value"
    )
    private static double modifyPitchRecoilValue(double value) {
        return tbz$applyAllModifiers(value, RecoilModifierRegistry.RecoilType.PITCH);
    }

    /**
     * 修改水平后坐力值（偏航方向）
     * 在 applyCameraRecoil 方法中 yaw 样条函数计算后存储到变量时，修改后坐力值
     *
     * @param value 原始水平后坐力值
     * @return 修改后的水平后坐力值
     */
    @ModifyVariable(
            method = "applyCameraRecoil",
            at = @At(
                    value = "STORE",
                    ordinal = 1
            ),
            remap = false,
            name = "value"
    )
    private static double modifyYawRecoilValue(double value) {
        return tbz$applyAllModifiers(value, RecoilModifierRegistry.RecoilType.YAW);
    }

    /**
     * 应用所有后坐力修改器
     * 遍历注册表中所有匹配类型的修改器，依次对后坐力值进行修改
     *
     * @param value 原始后坐力值
     * @param type 后坐力类型（俯仰/偏航）
     * @return 修改后的后坐力值
     */
    @Unique
    private static double tbz$applyAllModifiers(double value, RecoilModifierRegistry.RecoilType type) {
        // 获取当前客户端玩家
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return value;
        }

        // 获取玩家主手物品
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) {
            return value;
        }

        // 通过后坐力修改器注册表应用所有符合条件的修改器
        return RecoilModifierRegistry.applyModifiers(value, type, player, mainHand);
    }
}