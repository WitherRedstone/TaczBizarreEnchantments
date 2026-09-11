package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.item.enchantment.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface TBZEnchantments {
    DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TBZMod.MOD_ID);
    EnchantmentCategory DESTINY_GUN = EnchantmentCategory.create("destiny_gun", item -> false);

    // ==================== 异域类 ====================
    /** 防护编织 **/
    RegistryObject<ProtectiveWeaveEnchantment> PROTECTIVE_WEAVE = ENCHANTMENTS.register("protective_weave",
            () -> new ProtectiveWeaveEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 统治浩劫 **/
    RegistryObject<ReignHavocEnchantment> REIGN_HAVOC = ENCHANTMENTS.register("reign_havoc",
            () -> new ReignHavocEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** SUROS遗产 **/
    RegistryObject<SurosLegacyEnchantment> SUROS_LEGACY = ENCHANTMENTS.register("suros_legacy",
            () -> new SurosLegacyEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 古昧的折磨 **/
    RegistryObject<PrimevalsTormentEnchantment> PRIMEVALS_TORMENT = ENCHANTMENTS.register("primevals_torment",
            () -> new PrimevalsTormentEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 到此为止 **/
    RegistryObject<FullStopEnchantment> FULL_STOP = ENCHANTMENTS.register("full_stop",
            () -> new FullStopEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 蔓延羸弱 **/
    RegistryObject<CreepingAttritionEnchantment> CREEPING_ATTRITION = ENCHANTMENTS.register("creeping_attrition",
            () -> new CreepingAttritionEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 恶意触碰 **/
    RegistryObject<TouchOfMaliceEnchantment> TOUCH_OF_MALICE = ENCHANTMENTS.register("touch_of_malice",
            () -> new TouchOfMaliceEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 正确抉择 **/
    RegistryObject<TheRightChoiceEnchantment> THE_RIGHT_CHOICE = ENCHANTMENTS.register("the_right_choice",
            () -> new TheRightChoiceEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 十六进制 **/
    RegistryObject<VexadecimalEnchantment> VEXADECIMAL = ENCHANTMENTS.register("vexadecimal",
            () -> new VexadecimalEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 私人助手 **/
    RegistryObject<PersonalAssistantEnchantment> PERSONAL_ASSISTANT = ENCHANTMENTS.register("personal_assistant",
            () -> new PersonalAssistantEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 增伤类 ====================
    /** 斩首武器 **/
    RegistryObject<BorpalWeaponEnchantment> BORPAL_WEAPON = ENCHANTMENTS.register("borpal_weapon",
            () -> new BorpalWeaponEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 精准工具 **/
    RegistryObject<PrecisionInstrumentEnchantment> PRECISION_INSTRUMENT = ENCHANTMENTS.register("precision_instrument",
            () -> new PrecisionInstrumentEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 目标锁定 **/
    RegistryObject<TargetLockEnchantment> TARGET_LOCK = ENCHANTMENTS.register("target_lock",
            () -> new TargetLockEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 直击要害 **/
    RegistryObject<GutshotStraightEnchantment> GUTSHOT_STRAIGHT = ENCHANTMENTS.register("gutshot_straight",
            () -> new GutshotStraightEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 热能雾化 **/
    RegistryObject<ThermalAtomizationEnchantment> THERMAL_ATOMIZATION = ENCHANTMENTS.register("thermal_atomization",
            () -> new ThermalAtomizationEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 斗剑士 **/
    RegistryObject<SwashbucklerEnchantment> SWASHBUCKLER = ENCHANTMENTS.register("swashbuckler",
            () -> new SwashbucklerEnchantment(Enchantment.Rarity.COMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 我为人人 **/
    RegistryObject<OneForAllEnchantment> ONE_FOR_ALL = ENCHANTMENTS.register("one_for_all",
            () -> new OneForAllEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 武器大师 **/
    RegistryObject<MasterOfArmsEnchantment> MASTER_OF_ARMS = ENCHANTMENTS.register("master_of_arms",
            () -> new MasterOfArmsEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 聚合充能 **/
    RegistryObject<AggregateChargeEnchantment> AGGREGATE_CHARGE = ENCHANTMENTS.register("aggregate_charge",
            () -> new AggregateChargeEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 火线 **/
    RegistryObject<FiringLineEnchantment> FIRING_LINE_CHARGE = ENCHANTMENTS.register("firing_line",
            () -> new FiringLineEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 盒式呼吸法 **/
    RegistryObject<BoxBreathingEnchantment> BOX_BREATHING = ENCHANTMENTS.register("box_breathing",
            () -> new BoxBreathingEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 爆炸光能 **/
    RegistryObject<ExplosiveLightEnchantment> EXPLOSIVE_LIGHT = ENCHANTMENTS.register("explosive_light",
            () -> new ExplosiveLightEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 子弹类 ====================
    /** 维持生计 **/
    RegistryObject<SubsistenceEnchantment> SUBSISTENCE = ENCHANTMENTS.register("subsistence",
            () -> new SubsistenceEnchantment(Enchantment.Rarity.COMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 刺客野心 **/
    RegistryObject<AmbitiousAssassinEnchantment> AMBITIOUS_ASSASSIN = ENCHANTMENTS.register("ambitious_assassin",
            () -> new AmbitiousAssassinEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 重建 **/
    RegistryObject<ReconstructionEnchantment> RECONSTRUCTION = ENCHANTMENTS.register("reconstruction",
            () -> new ReconstructionEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 精准连击 **/
    RegistryObject<TripleTapEnchantment> TRIPLE_TAP = ENCHANTMENTS.register("triple_tap",
            () -> new TripleTapEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 事不过四 **/
    RegistryObject<FourthTimeTheCharmEnchantment> FOURTH_TIME_THE_CHARM = ENCHANTMENTS.register("fourth_time_the_charm",
            () -> new FourthTimeTheCharmEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 回转弹药 **/
    RegistryObject<RewindRoundsEnchantment> REWIND_ROUNDS = ENCHANTMENTS.register("rewind_rounds",
            () -> new RewindRoundsEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 重新调度 **/
    RegistryObject<MulliganEnchantment> MULLIGAN = ENCHANTMENTS.register("mulligan",
            () -> new MulliganEnchantment(Enchantment.Rarity.COMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 涓流充能 **/
    RegistryObject<TrickleChargeEnchantment> TRICKLE_CHARGE = ENCHANTMENTS.register("trickle_charge",
            () -> new TrickleChargeEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 超充弹匣 **/
    RegistryObject<SuperchargedMagazineEnchantment> SUPERCHARGED_MAGAZINE = ENCHANTMENTS.register("supercharged_magazine",
            () -> new SuperchargedMagazineEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 命运的逆转 **/
    RegistryObject<ReversalOfFortuneEnchantment> REVERSAL_OF_FORTUNE = ENCHANTMENTS.register("reversal_of_fortune",
            () -> new ReversalOfFortuneEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 小丑皇弹药筒 **/
    RegistryObject<ClownCartridgeEnchantment> CLOWN_CARTRIDGE = ENCHANTMENTS.register("clown_cartridge",
            () -> new ClownCartridgeEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 效果类 ====================
    /** 治疗弹匣 **/
    RegistryObject<HealClipEnchantment> HEAL_CLIP = ENCHANTMENTS.register("heal_clip",
            () -> new HealClipEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 风暴涌动 **/
    RegistryObject<RollingStormEnchantment> ROLLING_STORM = ENCHANTMENTS.register("rolling_storm",
            () -> new RollingStormEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 失衡弹药 **/
    RegistryObject<DestabilizingRoundsEnchantment> DESTABILIZING_ROUNDS = ENCHANTMENTS.register("destabilizing_rounds",
            () -> new DestabilizingRoundsEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 辉耀炽热 **/
    RegistryObject<IncandescentEnchantment> INCANDESCENT = ENCHANTMENTS.register("incandescent",
            () -> new IncandescentEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 冰冷弹匣 **/
    RegistryObject<ChillClipEnchantment> CHILL_CLIP = ENCHANTMENTS.register("chill_clip",
            () -> new ChillClipEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 霜华窃取者 **/
    RegistryObject<RimestealerEnchantment> RIMESTEALER = ENCHANTMENTS.register("rimestealer",
            () -> new RimestealerEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 切割 **/
    RegistryObject<SliceEnchantment> SLICE = ENCHANTMENTS.register("slice",
            () -> new SliceEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 枯萎凝视 **/
    RegistryObject<WitheringGazeEnchantment> WITHERING_GAZE = ENCHANTMENTS.register("withering_gaze",
            () -> new WitheringGazeEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 燃烧野心 **/
    RegistryObject<BurningAmbitionEnchantment> BURNING_AMBITION = ENCHANTMENTS.register("burning_ambition",
            () -> new BurningAmbitionEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 瓦解 **/
    RegistryObject<DemoralizeEnchantment> DEMORALIZE = ENCHANTMENTS.register("demoralize",
            () -> new DemoralizeEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 冲击支撑 **/
    RegistryObject<RepulsorBraceEnchantment> REPULSOR_BRACE = ENCHANTMENTS.register("repulsor_brace",
            () -> new RepulsorBraceEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 爆炸类 ====================
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
            () -> new DragonflyEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 巨脉蜻蜓 **/
    RegistryObject<MeganeuraEnchantment> MEGANEURA = ENCHANTMENTS.register("meganeura",
            () -> new MeganeuraEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 配件类 ====================
    /** 不法之徒 **/
    RegistryObject<OutlawEnchantment> OUTLAW = ENCHANTMENTS.register("outlaw",
            () -> new OutlawEnchantment(Enchantment.Rarity.UNCOMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 速射瞄准 **/
    RegistryObject<SnapshotSightsEnchantment> SNAPSHOT_SIGHTS = ENCHANTMENTS.register("snapshot_sights",
            () -> new SnapshotSightsEnchantment(Enchantment.Rarity.COMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
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
    /** 测距仪 **/
    RegistryObject<RangefinderEnchantment> RANGEFINDER = ENCHANTMENTS.register("rangefinder",
            () -> new RangefinderEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 切勿靠近 **/
    RegistryObject<KeepAwayEnchantment> KEEP_AWAY = ENCHANTMENTS.register("keep_away",
            () -> new KeepAwayEnchantment(Enchantment.Rarity.RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    // ==================== 其他类 ====================
    /** 羸弱能量球 **/
    RegistryObject<AttritionOrbsEnchantment> ATTRITION_ORBS = ENCHANTMENTS.register("attrition_orbs",
            () -> new AttritionOrbsEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 泉源 **/
    RegistryObject<WellspringEnchantment> WELLSPRING = ENCHANTMENTS.register("wellspring",
            () -> new WellspringEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 冷却饰物 **/
    RegistryObject<CoolingBaublesEnchantment> COOLING_BAUBLES = ENCHANTMENTS.register("cooling_baubles",
            () -> new CoolingBaublesEnchantment(Enchantment.Rarity.VERY_RARE, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    /** 边打边劫 **/
    RegistryObject<ShootTpLootEnchantment> SHOOT_TP_LOOT = ENCHANTMENTS.register("shoot_tp_loot",
            () -> new ShootTpLootEnchantment(Enchantment.Rarity.COMMON, DESTINY_GUN, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    static void init() {}
}