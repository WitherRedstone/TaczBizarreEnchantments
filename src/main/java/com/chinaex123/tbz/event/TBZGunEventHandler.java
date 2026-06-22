package com.chinaex123.tbz.event;

import com.chinaex123.tbz.event.enchantments.*;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
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

/** 枪械事件处理器 - 集中监听和分发各类枪械相关附魔效果 **/
@Mod.EventBusSubscriber
public class TBZGunEventHandler {

    /** 监听枪械伤害事件 **/
    @SubscribeEvent
    public static void onEntityHurtByGunEvent(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (attacker == null) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = attacker.getMainHandItem();
        if (gun.isEmpty()) return;

        // 应用斩首武器效果
        BorpalWeaponEvent.apply(event, gun, target);
        // 应用附魔效果（检测开枪）
        ReconstructionEvent.onEntityHurtByGun(event);
        // 应用精准连击效果
        TripleTapEvent.onEntityHurtByGun(event);
        // 应用事不过四效果
        FourthTimeTheCharmEvent.onEntityHurtByGun(event);
        // 应用回转弹药效果
        RewindRoundsEvent.onEntityHurtByGun(event);
        // 应用羸弱能量球效果
        AttritionOrbsEvent.onEntityHurtByGun(event);
        // 应用防护编织效果
        ProtectiveWeaveEvent.onEntityHurtByGun(event, gun);
        // 应用精准工具效果
        PrecisionInstrumentEvent.onEntityHurtByGun(event);
        // 应用重新调度效果
        MulliganEvent.onEntityHurtByGun(event);
        // 应用不法之徒效果
        OutlawEvent.onEntityHurtByGun(event);
        // 应用直击要害效果
        GutshotStraightEvent.onEntityHurtByGun(event);
        // 应用枯萎凝视效果
        WitheringGazeEvent.onEntityHurtByGun(event);
        // 应用高爆载荷效果
        ExplosivePayloadEvent.onEntityHurtByGun(event);
        // 应用萤火虫效果
        FireflyEvent.onEntityHurtByGun(event);
        // 应用蜻蜓效果
        DragonflyEvent.onEntityHurtByGun(event);
        // 应用巨脉蜻蜓效果
        MeganeuraEvent.onEntityHurtByGun(event);
        // 应用冰冷弹匣效果
        ChillClipEvent.onEntityHurtByGun(event);
        // 应用目标锁定效果
        TargetLockEvent.onEntityHurtByGun(event);
        // 应用切割效果
        SliceEvent.onEntityHurtByGun(event);
    }

    /** 监听子弹击中方块事件 **/
    @SubscribeEvent
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {
        // 应用高爆载荷效果
        ExplosivePayloadEvent.onAmmoHitBlock(event);
    }

    /** 监听实体死亡事件 **/
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

        // 应用治疗弹匣效果
        HealClipEvent.onKill(player, mainHand);
        // 应用维持生计效果
        SubsistenceEvent.onKill(player, mainHand);
        // 应用野心刺客效果
        AmbitiousAssassinEvent.onKill(player, mainHand);
        // 应用防护编织效果
        ProtectiveWeaveEvent.onKill(player, mainHand);
        // 应用不法之徒效果
        OutlawEvent.onKill(player, mainHand);
        // 应用蝴蝶效果
        ButterflyEvent.onLivingDeath(event);
        // 应用萤火虫效果
        FireflyEvent.onKill(player, mainHand, event.getEntity());
        // 应用蜻蜓效果
        DragonflyEvent.onKill(player, mainHand, event.getEntity());
        // 应用巨脉蜻蜓效果
        MeganeuraEvent.onKill(player, mainHand, event.getEntity());
        // 应用风暴涌动效果
        RollingStormEvent.onKill(player, mainHand);
        // 应用失衡弹药效果
        DestabilizingRoundsEvent.onKill(player, mainHand, event.getEntity());
        // 应用辉耀炽热效果
        IncandescentEvent.onKill(player, mainHand, event.getEntity());
        // 应用霜华窃取者效果
        RimestealerEvent.onKill(player, mainHand, event.getEntity());
    }

    /**
     * 目标锁定附魔：换弹时重置
     */
    @SubscribeEvent
    public static void onTargetLockReload(GunReloadEvent event) {
        TargetLockEvent.onReload(event);
    }

    /** 监听换弹完成事件 **/
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

        // 触发等待中的治愈效果
        HealClipEvent.onReload(player);
        // 触发野心刺客过量填充
        AmbitiousAssassinEvent.onReload(player, mainHand);
        // 触发回转弹药重置
        RewindRoundsEvent.onGunReload(event);
        // 触发羸弱能量球重置
        AttritionOrbsEvent.onGunReload(event);
        // 触发精准工具重置
        PrecisionInstrumentEvent.onGunReload(event);
        // 触发不法之徒重置
        OutlawEvent.onGunReload(event);
        // 触发蝴蝶重置
        ButterflyEvent.onGunReload(event);
        // 触发萤火虫重置
        FireflyEvent.onGunReload(event);
    }

    /** 监听玩家tick事件 **/
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.side != LogicalSide.SERVER) return;

        Player player = event.player;
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.isEmpty()) return;

        if (IGun.getIGunOrNull(mainHand) != null) {
            AmbitiousAssassinEvent.applyOverfill(mainHand);
            ReconstructionEvent.onPlayerTick(player);
            RewindRoundsEvent.onPlayerTick(player);
            MulliganEvent.onPlayerTick(player);
            WitheringGazeEvent.onPlayerTick(player);
            ButterflyEvent.onPlayerTick(player);
            MeganeuraEvent.onPlayerTick(player, mainHand);
        }
    }
}