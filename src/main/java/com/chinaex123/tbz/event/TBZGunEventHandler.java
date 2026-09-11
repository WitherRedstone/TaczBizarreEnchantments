package com.chinaex123.tbz.event;

import com.chinaex123.tbz.event.enchantments.*;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunFinishReloadEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.event.server.AmmoHitBlockEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
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

        // ==================== 异域类 ====================
        ProtectiveWeaveEvent.onEntityHurtByGun(event, gun);
        ReignHavocEvent.onEntityHurtByGun(event);
        SurosLegacyEvent.onEntityHurtByGun(event);
        PrimevalsTormentEvent.onEntityHurtByGun(event);
        FullStopEvent.onEntityHurtByGun(event);
        CreepingAttritionEvent.onEntityHurtByGun(event);
        TouchOfMaliceEvent.onEntityHurtByGun(event);
        TheRightChoiceEvent.onEntityHurtByGun(event);
        VexadecimalEvent.onEntityHurtByGun(event);
        PersonalAssistantEvent.onEntityHurtByGun(event);
        // ==================== 增伤类 ====================
        BorpalWeaponEvent.onEntityHurtByGun(event, gun, target);
        PrecisionInstrumentEvent.onEntityHurtByGun(event);
        TargetLockEvent.onEntityHurtByGun(event);
        GutshotStraightEvent.onEntityHurtByGun(event);
        ThermalAtomizationEvent.onEntityHurtByGun(event);
        SwashbucklerEvent.onEntityHurtByGun(event);
        OneForAllEvent.onEntityHurtByGun(event);
        MasterOfArmsEvent.onEntityHurtByGun(event, gun);
        AggregateChargeEvent.onEntityHurtByGun(event);
        FiringLineEvent.onEntityHurtByGun(event);
        BoxBreathingEvent.onEntityHurtByGun(event);
        ExplosiveLightEvent.onEntityHurtByGun(event);
        // ==================== 子弹类 ====================
        ReconstructionEvent.onEntityHurtByGun(event);
        TripleTapEvent.onEntityHurtByGun(event);
        FourthTimeTheCharmEvent.onEntityHurtByGun(event);
        RewindRoundsEvent.onEntityHurtByGun(event);
        MulliganEvent.onEntityHurtByGun(event);
        // ==================== 效果类 ====================
        ChillClipEvent.onEntityHurtByGun(event);
        SliceEvent.onEntityHurtByGun(event);
        WitheringGazeEvent.onEntityHurtByGun(event);
        ReversalOfFortuneEvent.onEntityHurtByGun(event);
        BurningAmbitionEvent.onEntityHurtByGun(event);
        DemoralizeEvent.onEntityHurtByGun(event);
        // ==================== 爆炸类 ====================
        ExplosivePayloadEvent.onEntityHurtByGun(event);
        FireflyEvent.onEntityHurtByGun(event);
        DragonflyEvent.onEntityHurtByGun(event);
        MeganeuraEvent.onEntityHurtByGun(event);
        // ==================== 配件类 ====================
        OutlawEvent.onEntityHurtByGun(event);
        AdagioEvent.onEntityHurtByGun(event);
        RangefinderEvent.onEntityHurtByGun(event);
        // ==================== 其他类 ====================
        AttritionOrbsEvent.onEntityHurtByGun(event);
    }

    /**
     * 监听子弹击中方块事件
     *
     * @param event 子弹击中方块事件
     */
    @SubscribeEvent
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {

        // ==================== 异域类 ====================
        PrimevalsTormentEvent.onAmmoHitBlock(event);
        // ==================== 增伤类 ====================
        // ==================== 子弹类 ====================
        // ==================== 效果类 ====================
        // ==================== 爆炸类 ====================
        ExplosivePayloadEvent.onAmmoHitBlock(event);
        // ==================== 配件类 ====================
        // ==================== 其他类 ====================
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

        // 获取被击杀的实体
        LivingEntity entity = event.getEntity();

        // 获取玩家主手物品
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        // 检查是否是枪械
        if (IGun.getIGunOrNull(mainHand) == null) return;

        // ==================== 异域类 ====================
        ProtectiveWeaveEvent.onKill(player, mainHand);
        ReignHavocEvent.onLivingDeath(event);
        SurosLegacyEvent.onKill(player, mainHand);
        // ==================== 增伤类 ====================
        ThermalAtomizationEvent.onKill(player, entity, mainHand);
        SwashbucklerEvent.onLivingDeath(event);
        MasterOfArmsEvent.onKill(player, mainHand);
        // ==================== 子弹类 ====================
        SubsistenceEvent.onKill(player, mainHand);
        AmbitiousAssassinEvent.onKill(player, mainHand);
        // ==================== 效果类 ====================
        HealClipEvent.onKill(player, mainHand);
        RollingStormEvent.onKill(player, mainHand);
        DestabilizingRoundsEvent.onKill(player, mainHand, entity);
        IncandescentEvent.onKill(player, mainHand, entity);
        RimestealerEvent.onKill(player, mainHand, entity);
        DemoralizeEvent.onKill(player, mainHand, entity);
        RepulsorBraceEvent.onKill(player, entity, mainHand);
        // ==================== 爆炸类 ====================
        ButterflyEvent.onLivingDeath(event);
        FireflyEvent.onKill(player, mainHand, entity);
        DragonflyEvent.onKill(player, mainHand, entity);
        MeganeuraEvent.onKill(player, mainHand, entity);
        // ==================== 配件类 ====================
        OutlawEvent.onKill(player, entity, mainHand);
        OnslaughtEvent.onKill(player, mainHand, entity);
        AdagioEvent.onKill(player, mainHand, entity);
        // ==================== 其他类 ====================
        WellspringEvent.onKill(player, mainHand, entity);
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

        // ==================== 异域类 ====================
        // ==================== 增伤类 ====================
        PrecisionInstrumentEvent.onGunReload(event);
        TargetLockEvent.onGunReload(event);
        BoxBreathingEvent.onGunReload(event);
        // ==================== 子弹类 ====================
        AmbitiousAssassinEvent.onGunReload(player, mainHand);
        RewindRoundsEvent.onGunReload(event);
        ClownCartridgeEvent.onGunReload(event);
        // ==================== 效果类 ====================
        HealClipEvent.onGunReload(player, mainHand);
        // ==================== 爆炸类 ====================
        ButterflyEvent.onGunReload(event);
        FireflyEvent.onGunReload(event);
        // ==================== 配件类 ====================
        OutlawEvent.onGunReload(event);
        // ==================== 其他类 ====================
        AttritionOrbsEvent.onGunReload(event);
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

        // ==================== 异域类 ====================
        // ==================== 增伤类 ====================
        // ==================== 子弹类 ====================
        // ==================== 效果类 ====================
        // ==================== 爆炸类 ====================
        // ==================== 配件类 ====================
        OutlawEvent.onGunFinishReload(gun);
        // ==================== 其他类 ====================
    }

    /**
     * 监听玩家Tick事件
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
            // ==================== 异域类 ====================
            // ==================== 增伤类 ====================
            SwashbucklerEvent.onPlayerTick(event);
            OneForAllEvent.onPlayerTick(event);
            MasterOfArmsEvent.onPlayerTick(player, mainHand);
            FiringLineEvent.onPlayerTick(player);
            BoxBreathingEvent.onPlayerTick(player);
            // ==================== 子弹类 ====================
            AmbitiousAssassinEvent.onPlayerTick(mainHand);
            ReconstructionEvent.onPlayerTick(player);
            RewindRoundsEvent.onPlayerTick(player);
            MulliganEvent.onPlayerTick(player);
            SuperchargedMagazineEvent.onPlayerTick(player);
            ReversalOfFortuneEvent.onPlayerTick(player);
            ClownCartridgeEvent.onPlayerTick(mainHand);
            // ==================== 效果类 ====================
            WitheringGazeEvent.onPlayerTick(player);
            HealClipEvent.onPlayerTick(mainHand, player);
            // ==================== 爆炸类 ====================
            ButterflyEvent.onPlayerTick(player);
            MeganeuraEvent.onPlayerTick(player, mainHand);
            // ==================== 配件类 ====================
            AdagioEvent.onPlayerTick(player);
            OnslaughtEvent.onPlayerTick(player);
            KeepAwayEvent.onPlayerTick(event);
            // ==================== 其他类 ====================
        }
    }

    /**
     * 监听装备变更事件
     * 在玩家切换装备时触发，用于清理附魔状态
     *
     * @param event 装备变更事件
     */
    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        // 只在服务端执行
        if (player.level().isClientSide) return;

        // 只处理主手装备变更
        if (event.getSlot() != EquipmentSlot.MAINHAND) return;

        // ==================== 异域类 ====================
        // ==================== 增伤类 ====================
        SwashbucklerEvent.onLivingEquipmentChange(event);
        OneForAllEvent.onLivingEquipmentChange(event);
        MasterOfArmsEvent.onLivingEquipmentChange(event);
        ExplosiveLightEvent.onLivingEquipmentChange(event);
        // ==================== 子弹类 ====================
        // ==================== 效果类 ====================
        // ==================== 爆炸类 ====================
        // ==================== 配件类 ====================
        // ==================== 其他类 ====================
    }

    /**
     * 通用伤害事件
     * 在实体受到伤害时触发，用于处理爆炸伤害加成等
     *
     * @param event 伤害事件
     */
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // ==================== 异域类 ====================
        // ==================== 增伤类 ====================
        // ==================== 子弹类 ====================
        // ==================== 效果类 ====================
        // ==================== 爆炸类 ====================
        ExplosiveLightEvent.onLivingHurt(event);
        // ==================== 配件类 ====================
        // ==================== 其他类 ====================
    }

    /**
     * 监听经验值变化事件
     * 在玩家获得经验值时触发，用于触发冷却饰品相关效果
     *
     * @param event 经验变化事件
     */
    @SubscribeEvent
    public static void onPlayerXp(PlayerXpEvent event) {
        Player player = event.getEntity();
        if (player == null) return;

        // 获取主手物品
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // ==================== 异域类 ====================
        // ==================== 增伤类 ====================
        // ==================== 子弹类 ====================
        // ==================== 效果类 ====================
        // ==================== 爆炸类 ====================
        // ==================== 配件类 ====================
        // ==================== 其他类 ====================
        CoolingBaublesEvent.onPlayerXp(event);
    }

    /**
     * 监听拾取经验球事件
     * 在玩家获得经验值时触发，用于触发冷却饰品相关效果
     *
     * @param event 拾取经验球事件
     */
    @SubscribeEvent
    public static void onPlayerXp(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();
        if (player == null) return;

        // 获取主手物品
        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // ==================== [异域]类型附魔 ====================
        // ==================== [增伤]类型附魔 ====================
        // ==================== [回子弹]类型附魔 ====================
        // ==================== [应用效果]类型附魔 ====================
        // ==================== [爆炸]类型附魔 ====================
        // ==================== [配件数值]类型附魔 ====================
        // ==================== [持续伤害]类型附魔 ====================
        // ==================== [填装]类型附魔 ====================
        // ==================== [其他]类型附魔 ====================
        ExplosiveLightEvent.onPlayerPickupXp(event);
    }
}