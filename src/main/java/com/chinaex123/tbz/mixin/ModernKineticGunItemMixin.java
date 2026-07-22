//package com.chinaex123.tbz.mixin;
//
//import com.chinaex123.tbz.config.TBZConfig;
//import com.chinaex123.tbz.event.enchantments.OutlawEvent;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.tacz.guns.api.entity.ReloadState;
//import com.tacz.guns.item.ModernKineticGunItem;
//import com.tacz.guns.item.ModernKineticGunScriptAPI;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Mixin(value = ModernKineticGunItem.class, remap = false)
//public class ModernKineticGunItemMixin {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger("TBZ-ModernKineticGun");
//
//    /**
//     * 拦截 defaultTickReload 方法，修改返回的 countDown
//     * 使用 ModernKineticGunScriptAPI 的完全限定名
//     */
//    @Inject(
//            method = "defaultTickReload",
//            at = @At("RETURN"),
//            remap = false,
//            cancellable = true
//    )
//    private void onDefaultTickReload(ModernKineticGunScriptAPI api, CallbackInfoReturnable<ReloadState> cir) {
//        try {
//            ReloadState originalState = cir.getReturnValue();
//            if (originalState == null || !originalState.getStateType().isReloading()) {
//                return;
//            }
//
//            // 获取玩家和武器
//            LivingEntity shooter = api.getShooter();
//            if (shooter == null) return;
//
//            ItemStack gunItem = api.getItemStack();
//            if (gunItem.isEmpty()) return;
//
//            // 检查不法之徒附魔
//            int level = gunItem.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
//            if (level <= 0) return;
//
//            // 检查换弹加速标记
//            var tag = gunItem.getOrCreateTag();
//            if (!tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG)) return;
//
//            // 获取加速倍率
//            float speedMultiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
//            long originalCountDown = originalState.getCountDown();
//            long newCountDown = Math.max((long) (originalCountDown * speedMultiplier), 1);
//
//            LOGGER.info("【defaultTickReload】加速换弹: {} -> {}, 倍率: {}",
//                    originalCountDown, newCountDown, speedMultiplier);
//
//            // 创建新的 ReloadState 并返回
//            ReloadState newState = new ReloadState(originalState);
//            newState.setCountDown(newCountDown);
//            cir.setReturnValue(newState);
//
//        } catch (Exception e) {
//            LOGGER.error("【defaultTickReload】异常", e);
//        }
//    }
//}