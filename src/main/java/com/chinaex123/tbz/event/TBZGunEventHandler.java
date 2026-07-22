package com.chinaex123.tbz.event;

import com.chinaex123.tbz.event.enchantments.*;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunFinishReloadEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.event.server.AmmoHitBlockEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

/**
 * 枪械事件处理器
 * <p>
 * 集中监听和分发各类枪械相关附魔效果的事件
 * 通过统一的入口调用各个附魔事件处理类，避免重复代码
 */
@Mod.EventBusSubscriber
public class TBZGunEventHandler {

    /**
     * 监听枪械伤害事件
     * 在子弹命中实体但伤害尚未应用时触发
     *
     * @param event 枪械伤害事件
     */
    @SubscribeEvent
    public static void onEntityHurtByGunEvent(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (attacker == null) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = attacker.getMainHandItem();
        if (gun.isEmpty()) return;

        // ==================== [异域]类型附魔 ====================
        ProtectiveWeaveEvent.onEntityHurtByGun(event, gun);
        // ==================== [增伤]类型附魔 ====================
        BorpalWeaponEvent.onEntityHurtByGun(event, gun, target);
        PrecisionInstrumentEvent.onEntityHurtByGun(event);
        TargetLockEvent.onEntityHurtByGun(event);
        GutshotStraightEvent.onEntityHurtByGun(event);
        ThermalAtomizationEvent.onEntityHurtByGun(event);
        // ==================== [回子弹]类型附魔 ====================
        ReconstructionEvent.onEntityHurtByGun(event);
        TripleTapEvent.onEntityHurtByGun(event);
        FourthTimeTheCharmEvent.onEntityHurtByGun(event);
        RewindRoundsEvent.onEntityHurtByGun(event);
        MulliganEvent.onEntityHurtByGun(event);
        // ==================== [应用效果]类型附魔 ====================
        ChillClipEvent.onEntityHurtByGun(event);
        SliceEvent.onEntityHurtByGun(event);
        WitheringGazeEvent.onEntityHurtByGun(event);
        ReversalOfFortuneEvent.onEntityHurtByGun(event);
        // ==================== [爆炸]类型附魔 ====================
        ExplosivePayloadEvent.onEntityHurtByGun(event);
        FireflyEvent.onEntityHurtByGun(event);
        DragonflyEvent.onEntityHurtByGun(event);
        MeganeuraEvent.onEntityHurtByGun(event);
        // ==================== [配件数值]类型附魔 ====================
        AdagioEvent.onEntityHurtByGun(event);
        // ==================== [持续伤害]类型附魔 ====================
        AttritionOrbsEvent.onEntityHurtByGun(event);
        // ==================== [填装]类型附魔 ====================
        OutlawEvent.onEntityHurtByGun(event);
        // ==================== [其他]类型附魔 ====================
    }

    /**
     * 监听子弹击中方块事件
     *
     * @param event 子弹击中方块事件
     */
    @SubscribeEvent
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {

        // ==================== [异域]类型附魔 ====================
        // ==================== [增伤]类型附魔 ====================
        // ==================== [回子弹]类型附魔 ====================
        // ==================== [应用效果]类型附魔 ====================
        // ==================== [爆炸]类型附魔 ====================
        ExplosivePayloadEvent.onAmmoHitBlock(event);
        // ==================== [配件数值]类型附魔 ====================
        // ==================== [持续伤害]类型附魔 ====================
        // ==================== [填装]类型附魔 ====================
        // ==================== [其他]类型附魔 ====================
        ShootTpLootEvent.onAmmoHitBlock(event);
    }

    /**
     * 监听实体死亡事件
     * 在实体被击杀时触发，用于处理击杀相关的附魔效果
     *
     * @param event 实体死亡事件
     */
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        // 获取击杀者
        Entity source = event.getSource().getEntity();
        if (!(source instanceof Player player)) return;

        // 获取玩家主手物品
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        // 检查是否是枪械
        if (IGun.getIGunOrNull(mainHand) == null) return;

        // ==================== [异域]类型附魔 ====================
        ProtectiveWeaveEvent.onKill(player, mainHand);
        // ==================== [增伤]类型附魔 ====================
        ThermalAtomizationEvent.onKill(player, event.getEntity(), mainHand);
        // ==================== [回子弹]类型附魔 ====================
        SubsistenceEvent.onKill(player, mainHand);
        AmbitiousAssassinEvent.onKill(player, mainHand);
        // ==================== [应用效果]类型附魔 ====================
        HealClipEvent.onKill(player, mainHand);
        RollingStormEvent.onKill(player, mainHand);
        DestabilizingRoundsEvent.onKill(player, mainHand, event.getEntity());
        IncandescentEvent.onKill(player, mainHand, event.getEntity());
        RimestealerEvent.onKill(player, mainHand, event.getEntity());
        // ==================== [爆炸]类型附魔 ====================
        ButterflyEvent.onLivingDeath(event);
        FireflyEvent.onKill(player, mainHand, event.getEntity());
        DragonflyEvent.onKill(player, mainHand, event.getEntity());
        MeganeuraEvent.onKill(player, mainHand, event.getEntity());
        // ==================== [配件数值]类型附魔 ====================
        OnslaughtEvent.onKill(player, mainHand, event.getEntity());
        AdagioEvent.onKill(player, mainHand, event.getEntity());
        // ==================== [持续伤害]类型附魔 ====================
        // ==================== [填装]类型附魔 ====================
        OutlawEvent.onKill(player, event.getEntity(), mainHand);
        // ==================== [其他]类型附魔 ====================
        WellspringEvent.onKill(player, mainHand, event.getEntity());
    }

    /**
     * 监听换弹开始事件
     * 在玩家开始换弹时触发
     *
     * @param event 换弹开始事件
     */
    @SubscribeEvent
    public static void onGunReload(GunReloadEvent event) {
        // 只在服务端执行
        if (event.getLogicalSide() != LogicalSide.SERVER) return;

        // 获取换弹的玩家
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        // 获取玩家主手物品
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        // ==================== [异域]类型附魔 ====================
        // ==================== [增伤]类型附魔 ====================
        PrecisionInstrumentEvent.onGunReload(event);
        TargetLockEvent.onGunReload(event);
        // ==================== [回子弹]类型附魔 ====================
        AmbitiousAssassinEvent.onGunReload(player, mainHand);
        RewindRoundsEvent.onGunReload(event);
        // ==================== [应用效果]类型附魔 ====================
        HealClipEvent.onGunReload(player);
        // ==================== [爆炸]类型附魔 ====================
        ButterflyEvent.onGunReload(event);
        FireflyEvent.onGunReload(event);
        // ==================== [配件数值]类型附魔 ====================
        // ==================== [持续伤害]类型附魔 ====================
        AttritionOrbsEvent.onGunReload(event);
        // ==================== [填装]类型附魔 ====================
        OutlawEvent.onGunReload(event);
        // ==================== [其他]类型附魔 ====================
    }

    /**
     * 监听换弹完成事件
     * 在换弹完成时触发，用于清理附魔状态
     *
     * @param event 换弹完成事件
     */
    @SubscribeEvent
    public static void onGunFinishReload(GunFinishReloadEvent event) {
        if (event.getLogicalSide() != LogicalSide.SERVER) return;

        ItemStack gun = event.getGunItemStack();
        if (gun.isEmpty()) return;

        OutlawEvent.onGunFinishReload(gun);
    }

    /**
     * 监听玩家每帧更新事件
     * 用于处理需要持续更新状态的附魔效果
     *
     * @param event 玩家Tick事件
     */
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.side != LogicalSide.SERVER) return;

        Player player = event.player;
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        if (IGun.getIGunOrNull(mainHand) != null) {
            // ==================== [异域]类型附魔 ====================
            // ==================== [增伤]类型附魔 ====================
            // ==================== [回子弹]类型附魔 ====================
            AmbitiousAssassinEvent.onPlayerTick(mainHand);
            ReconstructionEvent.onPlayerTick(player);
            RewindRoundsEvent.onPlayerTick(player);
            MulliganEvent.onPlayerTick(player);
            SuperchargedMagazineEvent.onPlayerTick(player);
            ReversalOfFortuneEvent.onPlayerTick(player);
            // ==================== [应用效果]类型附魔 ====================
            WitheringGazeEvent.onPlayerTick(player);
            // ==================== [爆炸]类型附魔 ====================
            ButterflyEvent.onPlayerTick(player);
            MeganeuraEvent.onPlayerTick(player, mainHand);
            // ==================== [配件数值]类型附魔 ====================
            AdagioEvent.onPlayerTick(player);
            OnslaughtEvent.onPlayerTick(player);
            // ==================== [持续伤害]类型附魔 ====================
            // ==================== [填装]类型附魔 ====================
            // ==================== [其他]类型附魔 ====================
        }
    }
}