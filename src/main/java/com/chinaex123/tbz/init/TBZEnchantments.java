package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.enchantment.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface TBZEnchantments {
    DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TBZMod.MOD_ID);
    EnchantmentCategory DESTINY_GUN = EnchantmentCategory.create("destiny_gun", item -> false);

    // ==================== [异域]类型附魔 ====================
    /** 防护编织 **/
    RegistryObject<ProtectiveWeaveEnchantment> PROTECTIVE_WEAVE = ENCHANTMENTS.register("protective_weave",
            () -> new ProtectiveWeaveEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 统治浩劫 **/
    RegistryObject<ReignHavocEnchantment> REIGN_HAVOC = ENCHANTMENTS.register("reign_havoc",
            () -> new ReignHavocEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [增伤]类型附魔 ====================
    /** 斩首武器 **/
    RegistryObject<BorpalWeaponEnchantment> BORPAL_WEAPON = ENCHANTMENTS.register("borpal_weapon",
            () -> new BorpalWeaponEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 精准工具 **/
    RegistryObject<PrecisionInstrumentEnchantment> PRECISION_INSTRUMENT = ENCHANTMENTS.register("precision_instrument",
            () -> new PrecisionInstrumentEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 目标锁定 **/
    RegistryObject<TargetLockEnchantment> TARGET_LOCK = ENCHANTMENTS.register("target_lock",
            () -> new TargetLockEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 直击要害 **/
    RegistryObject<GutshotStraightEnchantment> GUTSHOT_STRAIGHT = ENCHANTMENTS.register("gutshot_straight",
            () -> new GutshotStraightEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 热能雾化 **/
    RegistryObject<ThermalAtomizationEnchantment> THERMAL_ATOMIZATION = ENCHANTMENTS.register("thermal_atomization",
            () -> new ThermalAtomizationEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [回子弹]类型附魔 ====================
    /** 维持生计 **/
    RegistryObject<SubsistenceEnchantment> SUBSISTENCE = ENCHANTMENTS.register("subsistence",
            () -> new SubsistenceEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 刺客野心 **/
    RegistryObject<AmbitiousAssassinEnchantment> AMBITIOUS_ASSASSIN = ENCHANTMENTS.register("ambitious_assassin",
            () -> new AmbitiousAssassinEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 重建 **/
    RegistryObject<ReconstructionEnchantment> RECONSTRUCTION = ENCHANTMENTS.register("reconstruction",
            () -> new ReconstructionEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 精准连击 **/
    RegistryObject<TripleTapEnchantment> TRIPLE_TAP = ENCHANTMENTS.register("triple_tap",
            () -> new TripleTapEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 事不过四 **/
    RegistryObject<FourthTimeTheCharmEnchantment> FOURTH_TIME_THE_CHARM = ENCHANTMENTS.register("fourth_time_the_charm",
            () -> new FourthTimeTheCharmEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 回转弹药 **/
    RegistryObject<RewindRoundsEnchantment> REWIND_ROUNDS = ENCHANTMENTS.register("rewind_rounds",
            () -> new RewindRoundsEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 重新调度 **/
    RegistryObject<MulliganEnchantment> MULLIGAN = ENCHANTMENTS.register("mulligan",
            () -> new MulliganEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 涓流充能 **/
    RegistryObject<TrickleChargeEnchantment> TRICKLE_CHARGE = ENCHANTMENTS.register("trickle_charge",
            () -> new TrickleChargeEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 超充弹匣 **/
    RegistryObject<SuperchargedMagazineEnchantment> SUPERCHARGED_MAGAZINE = ENCHANTMENTS.register("supercharged_magazine",
            () -> new SuperchargedMagazineEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 命运的逆转 **/
    RegistryObject<ReversalOfFortuneEnchantment> REVERSAL_OF_FORTUNE = ENCHANTMENTS.register("reversal_of_fortune",
            () -> new ReversalOfFortuneEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [应用效果]类型附魔 ====================
    /** 治疗弹匣 **/
    RegistryObject<HealClipEnchantment> HEAL_CLIP = ENCHANTMENTS.register("heal_clip",
            () -> new HealClipEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 风暴涌动 **/
    RegistryObject<RollingStormEnchantment> ROLLING_STORM = ENCHANTMENTS.register("rolling_storm",
            () -> new RollingStormEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 失衡弹药 **/
    RegistryObject<DestabilizingRoundsEnchantment> DESTABILIZING_ROUNDS = ENCHANTMENTS.register("destabilizing_rounds",
            () -> new DestabilizingRoundsEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 辉耀炽热 **/
    RegistryObject<IncandescentEnchantment> INCANDESCENT = ENCHANTMENTS.register("incandescent",
            () -> new IncandescentEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 冰冷弹匣 **/
    RegistryObject<ChillClipEnchantment> CHILL_CLIP = ENCHANTMENTS.register("chill_clip",
            () -> new ChillClipEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 霜华窃取者 **/
    RegistryObject<RimestealerEnchantment> RIMESTEALER = ENCHANTMENTS.register("rimestealer",
            () -> new RimestealerEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 切割 **/
    RegistryObject<SliceEnchantment> SLICE = ENCHANTMENTS.register("slice",
            () -> new SliceEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 枯萎凝视 **/
    RegistryObject<WitheringGazeEnchantment> WITHERING_GAZE = ENCHANTMENTS.register("withering_gaze",
            () -> new WitheringGazeEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [爆炸]类型附魔 ====================
    /** 蝴蝶 **/
    RegistryObject<ButterflyEnchantment> BUTTERFLY = ENCHANTMENTS.register("butterfly",
            () -> new ButterflyEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 高爆载荷 **/
    RegistryObject<ExplosivePayloadEnchantment> EXPLOSIVE_PAYLOAD = ENCHANTMENTS.register("explosive_payload",
            () -> new ExplosivePayloadEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 萤火虫 **/
    RegistryObject<FireflyEnchantment> FIREFLY = ENCHANTMENTS.register("firefly",
            () -> new FireflyEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 蜻蜓 **/
    RegistryObject<DragonflyEnchantment> DRAGONFLY = ENCHANTMENTS.register("dragonfly",
            () -> new DragonflyEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 巨脉蜻蜓 **/
    RegistryObject<MeganeuraEnchantment> MEGANEURA = ENCHANTMENTS.register("meganeura",
            () -> new MeganeuraEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [配件数值]类型附魔 ====================
    /** 速射瞄准 **/
    RegistryObject<SnapshotSightsEnchantment> SNAPSHOT_SIGHTS = ENCHANTMENTS.register("snapshot_sights",
            () -> new SnapshotSightsEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 稳若磐石 **/
    RegistryObject<FirmlyPlantedEnchantment> FIRMLY_PLANTED = ENCHANTMENTS.register("firmly_planted",
            () -> new FirmlyPlantedEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 柔缓 **/
    RegistryObject<AdagioEnchantment> ADAGIO = ENCHANTMENTS.register("adagio",
            () -> new AdagioEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 猛攻 **/
    RegistryObject<OnslaughtEnchantment> ONSLAUGHT = ENCHANTMENTS.register("onslaught",
            () -> new OnslaughtEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 风暴之眼 **/
    RegistryObject<EyeOfStormEyeEnchantment> EYE_OF_STORM_EYE = ENCHANTMENTS.register("eye_of_storm_eye",
            () -> new EyeOfStormEyeEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [持续伤害]类型附魔 ====================
    /** 羸弱能量球 **/
    RegistryObject<AttritionOrbsEnchantment> ATTRITION_ORBS = ENCHANTMENTS.register("attrition_orbs",
            () -> new AttritionOrbsEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [填装]类型附魔 ====================
    /** 不法之徒 **/
    RegistryObject<OutlawEnchantment> OUTLAW = ENCHANTMENTS.register("outlaw",
            () -> new OutlawEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== [其他]类型附魔 ====================
    /** 泉源 **/
    RegistryObject<WellspringEnchantment> WELLSPRING = ENCHANTMENTS.register("wellspring",
            () -> new WellspringEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 冷却饰物 **/
    RegistryObject<CoolingBaublesEnchantment> COOLING_BAUBLES = ENCHANTMENTS.register("cooling_baubles",
            () -> new CoolingBaublesEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 边打边劫 **/
    RegistryObject<ShootTpLootEnchantment> SHOOT_TP_LOOT = ENCHANTMENTS.register("shoot_tp_loot",
            () -> new ShootTpLootEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    static void init() {}
}