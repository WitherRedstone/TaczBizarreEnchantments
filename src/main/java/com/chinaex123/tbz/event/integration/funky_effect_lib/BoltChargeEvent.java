//package com.chinaex123.tbz.event.integration.funky_effect_lib;
//
//import com.chinaex123.funky_effect_lib.api.event.BoltCharge.BoltChargeReceivedEvent;
//import com.chinaex123.funky_effect_lib.api.event.BoltCharge.BoltChargeDischargedEvent;
//import com.chinaex123.tbz.event.enchantments.TrickleChargeEvent;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
///**
// * 电光充能事件处理类
// * <p>
// * 监听电光充能的接收和释放，触发涓流充能附魔效果
// */
//@Mod.EventBusSubscriber
//public class BoltChargeEvent {
//
//    @SubscribeEvent
//    public static void onBoltChargeReceived(BoltChargeReceivedEvent event) {
//        // 只处理玩家
//        if (!(event.getEntity() instanceof Player player)) return;
//
//        // 获取主手物品
//        ItemStack mainHand = player.getMainHandItem();
//
//        // 获取接收的电光充能数量
//        int chargeReceived = event.getAmountAdded();
//
//        // 触发涓流充能效果
//        TrickleChargeEvent.onChargeReceived(player, mainHand, chargeReceived);
//    }
//
//    @SubscribeEvent
//    public static void onBoltChargeDischarged(BoltChargeDischargedEvent event) {
//        // 只处理玩家
//        if (!(event.getEntity() instanceof Player player)) return;
//
//        // 获取主手物品
//        ItemStack mainHand = player.getMainHandItem();
//
//        // 获取释放的电光充能数量
//        int chargeReleased = event.getPreviousCount() - event.getChargeCount();
//
//        // 触发涓流充能效果
//        TrickleChargeEvent.onChargeReleased(player, mainHand, chargeReleased);
//    }
//}