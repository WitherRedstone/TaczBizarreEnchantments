//package com.chinaex123.tbz.mixin;
//
//import com.chinaex123.tbz.config.TBZConfig;
//import com.chinaex123.tbz.event.enchantments.OutlawEvent;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.chinaex123.tbz.utils.ReloadContextHolder;
//import com.tacz.guns.api.entity.ReloadState;
//import net.minecraft.client.Minecraft;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.fml.LogicalSide;
//import net.minecraftforge.fml.util.thread.EffectiveSide;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.ModifyVariable;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(value = ReloadState.class, remap = false)
//public class ReloadStateMixin {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger("TBZ-ReloadState");
//
//    @Shadow
//    private ReloadState.StateType stateType;
//
//    @Shadow
//    private long countDown;
//
//    private Player getCurrentPlayer() {
//        if (EffectiveSide.get() == LogicalSide.CLIENT) {
//            return Minecraft.getInstance().player;
//        } else {
//            return ReloadContextHolder.getPlayer();
//        }
//    }
//
//    @ModifyVariable(
//            method = "setCountDown",
//            at = @At("HEAD"),
//            remap = false
//    )
//    private long modifyReloadCountDown(long countDown) {
//        if (countDown > 0) {
//            LOGGER.info("【调用栈】setCountDown 被调用，值: {}", countDown);
//            // 打印调用栈，最多打印20层
//            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//            int maxDepth = Math.min(stackTrace.length, 20);
//            for (int i = 0; i < maxDepth; i++) {
//                LOGGER.info("  [{}] -> {}", i, stackTrace[i].toString());
//            }
//        }
//
//        LogicalSide side = EffectiveSide.get();
//
//        try {
//            if (!stateType.isReloading()) {
//                return countDown;
//            }
//
//            Player player = getCurrentPlayer();
//            if (player == null) {
//                LOGGER.info("【换弹加速】❌ 获取玩家失败，当前端: {}", side);
//                return countDown;
//            }
//
//            ItemStack weapon = player.getMainHandItem();
//            if (weapon.isEmpty()) return countDown;
//
//            int level = weapon.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
//            if (level <= 0) return countDown;
//
//            var tag = weapon.getOrCreateTag();
//            boolean hasSpeedTag = tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG);
//
//            LOGGER.info("【换弹加速】当前端: {}, RELOAD_SPEED_TAG: {}", side, hasSpeedTag);
//
//            if (!hasSpeedTag) return countDown;
//
//            float speedMultiplier = TBZConfig.OUTLAW_RELOAD_SPEED_MULTIPLIER.get().floatValue();
//            long acceleratedTime = (long) (countDown * speedMultiplier);
//            long result = Math.max(acceleratedTime, 1);
//
//            LOGGER.info("【换弹加速】✅ 加速成功！{} -> {}, 倍率: {}", countDown, result, speedMultiplier);
//
//            return result;
//
//        } catch (Exception e) {
//            LOGGER.error("【换弹加速】❌ 异常", e);
//            return countDown;
//        }
//    }
//
//    @Inject(method = "setStateType", at = @At("TAIL"), remap = false)
//    private void onStateTypeChange(ReloadState.StateType newState, CallbackInfo ci) {
//        if (newState == ReloadState.StateType.NOT_RELOADING) {
//            LOGGER.info("【换弹清理】换弹完成，清理标记");
//            ReloadContextHolder.clear();
//
//            try {
//                Player player = getCurrentPlayer();
//                if (player != null) {
//                    ItemStack gun = player.getMainHandItem();
//                    if (!gun.isEmpty()) {
//                        var tag = gun.getOrCreateTag();
//                        boolean hadTag = tag.getBoolean(OutlawEvent.RELOAD_SPEED_TAG);
//                        tag.putBoolean(OutlawEvent.RELOAD_SPEED_TAG, false);
//                        LOGGER.info("【换弹清理】RELOAD_SPEED_TAG 清理: {}", hadTag ? "已清除" : "本来就不存在");
//                    }
//                }
//            } catch (Exception e) {
//                LOGGER.error("【换弹清理】异常", e);
//            }
//        }
//    }
//}