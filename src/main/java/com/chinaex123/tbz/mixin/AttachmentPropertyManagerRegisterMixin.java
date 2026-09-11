//package com.chinaex123.tbz.mixin;
//
//import com.chinaex123.tbz.modifier.RangefinderModifier;
//import com.tacz.guns.resource.modifier.AttachmentPropertyManager;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
///**
// * 注册我们的自定义 Modifier 到 TACZ 系统
// * <p>
// * 已废弃：不再需要注册自定义的 RangefinderModifier
// * 现在直接使用 TACZ 内置的 GunProperties.EFFECTIVE_RANGE 来实现射程扩展
// */
//@Mixin(value = AttachmentPropertyManager.class, remap = false)
//public class AttachmentPropertyManagerRegisterMixin {
//
//    /**
//     * 在 TACZ 注册完所有默认 Modifier 后，注册我们的 Modifier
//     * <p>
//     * 已废弃：不再需要注册自定义 Modifier
//     */
//    @Inject(method = "registerModifier", at = @At("TAIL"), require = 0)
//    private static void registerCustomModifiers(CallbackInfo ci) {
//        var modifiers = AttachmentPropertyManager.getModifiers();
//
//        modifiers.put(RangefinderModifier.ID, new RangefinderModifier());
//    }
//}