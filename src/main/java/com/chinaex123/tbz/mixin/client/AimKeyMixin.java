package com.chinaex123.tbz.mixin.client;

import com.chinaex123.tbz.network.GunAimingPacket;
import com.chinaex123.tbz.network.PacketHandler;
import com.tacz.guns.client.input.AimKey;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 瞄准按键混入类
 * <p>
 * 功能：拦截枪械模组的瞄准按键事件，将瞄准状态同步到服务端
 */
@OnlyIn(Dist.CLIENT)
@Mixin(value = AimKey.class, remap = false)
public class AimKeyMixin {

    /**
     * 拦截瞄准按键按下事件（鼠标按键按下/释放）
     *
     * @param event 鼠标事件对象
     * @param ci 回调信息
     */
    @Inject(method = "onAimPress",
            at = @At(value = "INVOKE",
                    target = "Lcom/tacz/guns/api/client/gameplay/IClientPlayerGunOperator;aim(Z)V"),
            remap = false)
    private static void onAimPress(InputEvent.MouseButton.Post event, CallbackInfo ci) {
        // 判断按键动作：1 = 按下（PRESS），0 = 释放（RELEASE）
        boolean isPress = event.getAction() == 1;
        // 发送瞄准状态数据包到服务端
        tbz$sendAimPacket(isPress);
    }

    /**
     * 拦截长按瞄准按键持续检测事件
     *
     * @param event 客户端Tick事件
     * @param ci 回调信息
     */
    @Inject(method = "onAimHoldingPreInput",
            at = @At(value = "INVOKE",
                    target = "Lcom/tacz/guns/api/client/gameplay/IClientPlayerGunOperator;aim(Z)V"),
            remap = false)
    private static void onAimHoldingPreInput(TickEvent.ClientTickEvent event, CallbackInfo ci) {
        // 获取当前瞄准按键的按下状态（持续按住时为 true）
        boolean isAiming = AimKey.AIM_KEY.isDown();
        // 发送瞄准状态数据包到服务端
        tbz$sendAimPacket(isAiming);
    }

    /**
     * 辅助方法：发送瞄准状态网络包到服务端
     * 使用 @Unique 标记防止与目标类的方法冲突
     *
     * @param aiming 瞄准状态（true=正在瞄准，false=未瞄准）
     */
    @Unique
    private static void tbz$sendAimPacket(boolean aiming) {
        PacketHandler.INSTANCE.sendToServer(new GunAimingPacket(aiming));
    }
}