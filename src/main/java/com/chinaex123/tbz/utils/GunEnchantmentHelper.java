package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.config.TBZEnchantmentConfig;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 枪械附魔辅助类
 * <p>
 * 功能：校验附魔能否应用于指定枪械
 */
public class GunEnchantmentHelper {

    /**
     * 检查是否可以应用附魔到枪上
     * @param enchantmentId 附魔ID
     * @param gunId 枪ID
     * @return 是否可以应用
     */
    public static boolean canApplyEnchantmentToGun(ResourceLocation enchantmentId, ResourceLocation gunId) {
        return TBZEnchantmentConfig.canApplyEnchantmentToGun(enchantmentId, gunId);
    }

    /**
     * 检查枪械上已有的TBZ附魔数量是否达到上限
     * @param gun 枪械物品
     * @return 是否可以继续添加TBZ附魔
     */
    public static boolean canAddMoreTBZEnchantments(ItemStack gun) {
        int maxEnchantments = TBZServerConfig.MAX_ENCHANTMENTS_PER_GUN.get();
        int currentTBZEnchantments = countTBZEnchantments(gun);
        return currentTBZEnchantments < maxEnchantments;
    }

    /**
     * 统计枪械上已有的TBZ附魔数量
     * @param gun 枪械物品
     * @return TBZ附魔数量
     */
    public static int countTBZEnchantments(ItemStack gun) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(gun);
        int count = 0;
        for (Enchantment enchantment : enchantments.keySet()) {
            if (isTBZEnchantment(enchantment)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 检查附魔是否是TBZ模组的附魔，通过附魔对象获取附魔的ID。
     * </p>
     * @param enchantment 附魔对象
     * @return 是否是TBZ附魔
     */
    public static boolean isTBZEnchantment(Enchantment enchantment) {
        if (enchantment == null) return false;
        ResourceLocation enchantmentId = net.minecraftforge.registries.ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
        if (enchantmentId == null) return false;
        return "tbz".equals(enchantmentId.getNamespace());
    }

    /**
     * 检查是否可以应用附魔到枪上（包含武器类型检查）
     * @param enchantmentId 附魔ID
     * @param gun 枪械物品
     * @return 是否可以应用
     */
    public static boolean canApplyEnchantmentToGunWithWeaponType(ResourceLocation enchantmentId, ItemStack gun) {
        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return false;

        ResourceLocation gunId = iGun.getGunId(gun);

        // 检查枪械ID
        if (!canApplyEnchantmentToGun(enchantmentId, gunId)) {
            return false;
        }

        // 检查武器类型
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(gunId);
        if (gunIndexOpt.isEmpty()) return true;

        String weaponType = gunIndexOpt.get().getType();
        String enchantmentName = enchantmentId.getPath();

        // 获取武器类型配置
        List<? extends String> allowedTypes = null;
        boolean whitelistMode = switch (enchantmentName) {

            // ========== 异域类 ==========
            // 防护编织
            case "protective_weave" -> {
                allowedTypes = TBZServerConfig.PROTECTIVE_WEAVE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PROTECTIVE_WEAVE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 统治浩劫
            case "reign_havoc" -> {
                allowedTypes = TBZServerConfig.REIGN_HAVOC_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REIGN_HAVOC_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // SUROS遗产
            case "suros_legacy" -> {
                allowedTypes = TBZServerConfig.SUROS_LEGACY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SUROS_LEGACY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 古昧的折磨
            case "primevals_torment" -> {
                allowedTypes = TBZServerConfig.PRIMEVALS_TORMENT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PRIMEVALS_TORMENT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 到此为止
            case "full_stop" -> {
                allowedTypes = TBZServerConfig.FULL_STOP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FULL_STOP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 蔓延羸弱
            case "creeping_attrition" -> {
                allowedTypes = TBZServerConfig.CREEPING_ATTRITION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.CREEPING_ATTRITION_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 恶意触碰
            case "touch_of_malice" -> {
                allowedTypes = TBZServerConfig.TOUCH_OF_MALICE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TOUCH_OF_MALICE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 正确抉择
            case "the_right_choice" -> {
                allowedTypes = TBZServerConfig.THE_RIGHT_CHOICE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.THE_RIGHT_CHOICE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 十六进制
            case "vexadecimal" -> {
                allowedTypes = TBZServerConfig.VEXADECIMAL_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.VEXADECIMAL_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 私人助手
            case "personal_assistant" -> {
                allowedTypes = TBZServerConfig.PERSONAL_ASSISTANT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PERSONAL_ASSISTANT_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 增伤类 ==========
            // 斩首武器
            case "borpal_weapon" -> {
                allowedTypes = TBZServerConfig.BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 精准工具
            case "precision_instrument" -> {
                allowedTypes = TBZServerConfig.PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 目标锁定
            case "target_lock" -> {
                allowedTypes = TBZServerConfig.TARGET_LOCK_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 直击要害
            case "gutshot_straight" -> {
                allowedTypes = TBZServerConfig.GUTSHOT_STRAIGHT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.GUTSHOT_STRAIGHT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 热能雾化
            case "thermal_atomization" -> {
                allowedTypes = TBZServerConfig.THERMAL_ATOMIZATION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.THERMAL_ATOMIZATION_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 斗剑士
            case "swashbuckler" -> {
                allowedTypes = TBZServerConfig.SWASHBUCKLER_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SWASHBUCKLER_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 我为人人
            case "one_for_all" -> {
                allowedTypes = TBZServerConfig.ONE_FOR_ALL_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ONE_FOR_ALL_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 武器大师
            case "master_of_arms" -> {
                allowedTypes = TBZServerConfig.MASTER_OF_ARMS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.MASTER_OF_ARMS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 聚合充能
            case "aggregate_charge" -> {
                allowedTypes = TBZServerConfig.AGGREGATE_CHARGE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.AGGREGATE_CHARGE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 火线
            case "firing_line" -> {
                allowedTypes = TBZServerConfig.FIRING_LINE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FIRING_LINE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 盒式呼吸法
            case "box_breathing" -> {
                allowedTypes = TBZServerConfig.BOX_BREATHING_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BOX_BREATHING_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 爆炸光能
            case "explosive_light" -> {
                allowedTypes = TBZServerConfig.EXPLOSIVE_LIGHT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.EXPLOSIVE_LIGHT_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 子弹类 ==========
            // 维持生计
            case "subsistence" -> {
                allowedTypes = TBZServerConfig.SUBSISTENCE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 野心刺客
            case "ambitious_assassin" -> {
                allowedTypes = TBZServerConfig.AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 重建
            case "reconstruction" -> {
                allowedTypes = TBZServerConfig.RECONSTRUCTION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 精准连击
            case "triple_tap" -> {
                allowedTypes = TBZServerConfig.TRIPLE_TAP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 事不过四
            case "fourth_time_the_charm" -> {
                allowedTypes = TBZServerConfig.FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 回转弹药
            case "rewind_rounds" -> {
                allowedTypes = TBZServerConfig.REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 重新调度
            case "mulligan" -> {
                allowedTypes = TBZServerConfig.MULLIGAN_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.MULLIGAN_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 涓流充能
            case "trickle_charge" -> {
                allowedTypes = TBZServerConfig.TRICKLE_CHARGE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TRICKLE_CHARGE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 超充弹匣
            case "supercharged_magazine" -> {
                allowedTypes = TBZServerConfig.SUPERCHARGED_MAGAZINE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SUPERCHARGED_MAGAZINE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 命运的反转
            case "reversal_of_fortune" -> {
                allowedTypes = TBZServerConfig.REVERSAL_OF_FORTUNE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REVERSAL_OF_FORTUNE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 小丑皇弹药筒
            case "clown_cartridge" -> {
                allowedTypes = TBZServerConfig.CLOWN_CARTRIDGE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.CLOWN_CARTRIDGE_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 效果类 ==========
            // 治疗弹匣
            case "heal_clip" -> {
                allowedTypes = TBZServerConfig.HEAL_CLIP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 风暴涌动
            case "rolling_storm" -> {
                allowedTypes = TBZServerConfig.ROLLING_STORM_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 失衡弹药
            case "destabilizing_rounds" -> {
                allowedTypes = TBZServerConfig.DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 辉耀炽热
            case "incandescent" -> {
                allowedTypes = TBZServerConfig.INCANDESCENT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 冰冷弹匣
            case "chill_clip" -> {
                allowedTypes = TBZServerConfig.CHILL_CLIP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 霜华窃取者
            case "rimestealer" -> {
                allowedTypes = TBZServerConfig.RIMESTEALER_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 切割
            case "slice" -> {
                allowedTypes = TBZServerConfig.SLICE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SLICE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 枯萎凝视
            case "withering_gaze" -> {
                allowedTypes = TBZServerConfig.WITHERING_GAZE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 燃烧野心
            case "burning_ambition" -> {
                allowedTypes = TBZServerConfig.BURNING_AMBITION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BURNING_AMBITION_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 瓦解
            case "demoralize" -> {
                allowedTypes = TBZServerConfig.DEMORALIZE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.DEMORALIZE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 冲击支撑
            case "repulsor_brace" -> {
                allowedTypes = TBZServerConfig.REPULSOR_BRACE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REPULSOR_BRACE_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 爆炸类 ==========
            // 蝴蝶
            case "butterfly" -> {
                allowedTypes = TBZServerConfig.BUTTERFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BUTTERFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 高爆载荷
            case "explosive_payload" -> {
                allowedTypes = TBZServerConfig.EXPLOSIVE_PAYLOAD_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.EXPLOSIVE_PAYLOAD_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 萤火虫
            case "firefly" -> {
                allowedTypes = TBZServerConfig.FIREFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FIREFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 蜻蜓
            case "dragonfly" -> {
                allowedTypes = TBZServerConfig.DRAGONFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 巨脉蜻蜓
            case "meganeura" -> {
                allowedTypes = TBZServerConfig.MEGANEURA_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.MEGANEURA_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 配件类 ==========
            // 不法之徒
            case "outlaw" -> {
                allowedTypes = TBZServerConfig.OUTLAW_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.OUTLAW_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 速射瞄准
            case "snapshot_sights" -> {
                allowedTypes = TBZServerConfig.SNAPSHOT_SIGHTS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SNAPSHOT_SIGHTS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 稳若磐石
            case "firmly_planted" -> {
                allowedTypes = TBZServerConfig.FIRMLY_PLANTED_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FIRMLY_PLANTED_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 柔缓
            case "adagio" -> {
                allowedTypes = TBZServerConfig.ADAGIO_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ADAGIO_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 猛攻
            case "onslaught" -> {
                allowedTypes = TBZServerConfig.ONSLAUGHT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ONSLAUGHT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 风暴之眼
            case "eye_of_storm_eye" -> {
                allowedTypes = TBZServerConfig.EYE_OF_STORM_EYE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.EYE_OF_STORM_EYE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 测距仪
            case "rangefinder" -> {
                allowedTypes = TBZServerConfig.RANGEFINDER_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.RANGEFINDER_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 切勿靠近
            case "keep_away" -> {
                allowedTypes = TBZServerConfig.KEEP_AWAY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.KEEP_AWAY_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== 其他类 ==========
            // 羸弱能量球
            case "attrition_orbs" -> {
                allowedTypes = TBZServerConfig.ATTRITION_ORBS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ATTRITION_ORBS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 泉源
            case "wellspring" -> {
                allowedTypes = TBZServerConfig.WELLSPRING_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.WELLSPRING_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 冷却饰物
            case "cooling_baubles" -> {
                allowedTypes = TBZServerConfig.COOLING_BAUBLES_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.COOLING_BAUBLES_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            // 边打边劫
            case "shoot_tp_loot" -> {
                allowedTypes = TBZServerConfig.SHOOT_TP_LOOT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SHOOT_TP_LOOT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            default -> false;
        };

        // 如果没有配置武器类型，默认允许
        if (allowedTypes == null || allowedTypes.isEmpty()) {
            return true;
        }

        // 根据模式判断
        if (whitelistMode) {
            // 白名单模式：武器类型必须在列表中
            return allowedTypes.contains(weaponType);
        } else {
            // 黑名单模式：武器类型不能在列表中
            return !allowedTypes.contains(weaponType);
        }
    }

    /**
     * 获取枪械的IGun接口
     * @param gun 枪械物品
     * @return IGun接口，如果枪械无效则返回null
     */
    public static IGun getIGun(ItemStack gun) {
        try {
            return IGun.getIGunOrNull(gun);
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getIGun] 获取枪械接口失败: {}", e.getMessage(), e);
            return null;
        }
    }

    /**
     * 获取枪械数据
     * @param gun 枪械物品
     * @return 枪械数据的Optional，如果获取失败则返回空Optional
     */
    public static Optional<CommonGunIndex> getGunData(ItemStack gun) {
        try {
            IGun iGun = getIGun(gun);
            if (iGun == null) {
                return Optional.empty();
            }
            return TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getGunData] 获取枪械数据失败: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    /**
     * 获取枪械的弹匣容量
     * @param gun 枪械物品
     * @return 弹匣容量，如果获取失败则返回-1
     */
    public static int getMagazineSize(ItemStack gun) {
        try {
            Optional<CommonGunIndex> gunData = getGunData(gun);
            return gunData.map(commonGunIndex -> commonGunIndex.getGunData().getAmmoAmount()).orElse(-1);
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getMagazineSize] 获取弹匣容量失败: {}", e.getMessage(), e);
            return -1;
        }
    }

    /**
     * 获取枪械的当前弹药数量
     * @param gun 枪械物品
     * @return 当前弹药数量，如果获取失败则返回-1
     */
    public static int getCurrentAmmo(ItemStack gun) {
        try {
            IGun iGun = getIGun(gun);
            if (iGun == null) {
                return -1;
            }
            return iGun.getCurrentAmmoCount(gun);
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getCurrentAmmo] 获取当前弹药数量失败: {}", e.getMessage(), e);
            return -1;
        }
    }

    /**
     * 获取枪械使用的弹药ID
     * @param gun 枪械物品
     * @return 弹药ID的Optional，如果获取失败则返回空Optional
     */
    public static Optional<ResourceLocation> getAmmoId(ItemStack gun) {
        try {
            Optional<CommonGunIndex> gunData = getGunData(gun);
            return gunData.map(commonGunIndex -> commonGunIndex.getGunData().getAmmoId());
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getAmmoId] 获取弹药ID失败: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    /**
     * 获取枪械的武器类型
     * @param gun 枪械物品
     * @return 武器类型的Optional，如果获取失败则返回空Optional
     */
    public static Optional<String> getWeaponType(ItemStack gun) {
        try {
            Optional<CommonGunIndex> gunData = getGunData(gun);
            return gunData.map(CommonGunIndex::getType);
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getWeaponType] 获取武器类型失败: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    /**
     * 获取枪械的ID
     * @param gun 枪械物品
     * @return 枪械ID的Optional，如果获取失败则返回空Optional
     */
    public static Optional<ResourceLocation> getGunId(ItemStack gun) {
        try {
            IGun iGun = getIGun(gun);
            if (iGun == null) {
                return Optional.empty();
            }
            return Optional.of(iGun.getGunId(gun));
        } catch (Exception e) {
            TBZMod.LOGGER.error("[GunEnchantmentHelper.getGunId] 获取枪枪ID失败: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }
}