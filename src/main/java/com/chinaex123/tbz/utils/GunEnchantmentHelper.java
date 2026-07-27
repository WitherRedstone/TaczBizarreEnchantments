package com.chinaex123.tbz.utils;

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
            // ========== [异域]类型附魔 ==========
            /* 防护编织 */
            case "protective_weave" -> {
                allowedTypes = TBZServerConfig.PROTECTIVE_WEAVE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PROTECTIVE_WEAVE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 统治浩劫 */
            case "reign_havoc" -> {
                allowedTypes = TBZServerConfig.REIGN_HAVOC_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REIGN_HAVOC_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [增伤]类型附魔 ==========
            /* 斩首武器 */
            case "borpal_weapon" -> {
                allowedTypes = TBZServerConfig.BORPAL_WEAPON_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BORPAL_WEAPON_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 精准工具 */
            case "precision_instrument" -> {
                allowedTypes = TBZServerConfig.PRECISION_INSTRUMENT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.PRECISION_INSTRUMENT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 目标锁定 */
            case "target_lock" -> {
                allowedTypes = TBZServerConfig.TARGET_LOCK_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TARGET_LOCK_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 直击要害 */
            case "gutshot_straight" -> {
                allowedTypes = TBZServerConfig.GUTSHOT_STRAIGHT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.GUTSHOT_STRAIGHT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 热能雾化 */
            case "thermal_atomization" -> {
                allowedTypes = TBZServerConfig.THERMAL_ATOMIZATION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.THERMAL_ATOMIZATION_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [回子弹]类型附魔 ==========
            /* 维持生计 */
            case "subsistence" -> {
                allowedTypes = TBZServerConfig.SUBSISTENCE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SUBSISTENCE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 野心刺客 */
            case "ambitious_assassin" -> {
                allowedTypes = TBZServerConfig.AMBITIOUS_ASSASSIN_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.AMBITIOUS_ASSASSIN_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 重建 */
            case "reconstruction" -> {
                allowedTypes = TBZServerConfig.RECONSTRUCTION_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.RECONSTRUCTION_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 精准连击 */
            case "triple_tap" -> {
                allowedTypes = TBZServerConfig.TRIPLE_TAP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TRIPLE_TAP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 事不过四 */
            case "fourth_time_the_charm" -> {
                allowedTypes = TBZServerConfig.FOURTH_TIME_THE_CHARM_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FOURTH_TIME_THE_CHARM_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 回转弹药 */
            case "rewind_rounds" -> {
                allowedTypes = TBZServerConfig.REWIND_ROUNDS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REWIND_ROUNDS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 重新调度 */
            case "mulligan" -> {
                allowedTypes = TBZServerConfig.MULLIGAN_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.MULLIGAN_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 涓流充能 */
            case "trickle_charge" -> {
                allowedTypes = TBZServerConfig.TRICKLE_CHARGE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.TRICKLE_CHARGE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 超充弹匣 */
            case "supercharged_magazine" -> {
                allowedTypes = TBZServerConfig.SUPERCHARGED_MAGAZINE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SUPERCHARGED_MAGAZINE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 命运的逆转 */
            case "reversal_of_fortune" -> {
                allowedTypes = TBZServerConfig.REVERSAL_OF_FORTUNE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.REVERSAL_OF_FORTUNE_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [应用效果]类型附魔 ==========
            /* 治疗弹匣 */
            case "heal_clip" -> {
                allowedTypes = TBZServerConfig.HEAL_CLIP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.HEAL_CLIP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 风暴涌动 */
            case "rolling_storm" -> {
                allowedTypes = TBZServerConfig.ROLLING_STORM_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ROLLING_STORM_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 失衡弹药 */
            case "destabilizing_rounds" -> {
                allowedTypes = TBZServerConfig.DESTABILIZING_ROUNDS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.DESTABILIZING_ROUNDS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 辉耀炽热 */
            case "incandescent" -> {
                allowedTypes = TBZServerConfig.INCANDESCENT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.INCANDESCENT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 冰冷弹匣 */
            case "chill_clip" -> {
                allowedTypes = TBZServerConfig.CHILL_CLIP_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.CHILL_CLIP_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 霜华窃取者 */
            case "rimestealer" -> {
                allowedTypes = TBZServerConfig.RIMESTEALER_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.RIMESTEALER_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 切割 */
            case "slice" -> {
                allowedTypes = TBZServerConfig.SLICE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SLICE_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 枯萎凝视 */
            case "withering_gaze" -> {
                allowedTypes = TBZServerConfig.WITHERING_GAZE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.WITHERING_GAZE_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [爆炸]类型附魔 ==========
            /* 蝴蝶 */
            case "butterfly" -> {
                allowedTypes = TBZServerConfig.BUTTERFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.BUTTERFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 高爆载荷 */
            case "explosive_payload" -> {
                allowedTypes = TBZServerConfig.EXPLOSIVE_PAYLOAD_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.EXPLOSIVE_PAYLOAD_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 萤火虫 */
            case "firefly" -> {
                allowedTypes = TBZServerConfig.FIREFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FIREFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 蜻蜓 */
            case "dragonfly" -> {
                allowedTypes = TBZServerConfig.DRAGONFLY_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.DRAGONFLY_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 巨脉蜻蜓 */
            case "meganeura" -> {
                allowedTypes = TBZServerConfig.MEGANEURA_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.MEGANEURA_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [配件数值]类型附魔 ==========
            /* 速射瞄准 */
            case "snapshot_sights" -> {
                allowedTypes = TBZServerConfig.SNAPSHOT_SIGHTS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.SNAPSHOT_SIGHTS_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 稳若磐石 */
            case "firmly_planted" -> {
                allowedTypes = TBZServerConfig.FIRMLY_PLANTED_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.FIRMLY_PLANTED_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 柔缓 */
            case "adagio" -> {
                allowedTypes = TBZServerConfig.ADAGIO_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ADAGIO_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 猛攻 */
            case "onslaught" -> {
                allowedTypes = TBZServerConfig.ONSLAUGHT_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ONSLAUGHT_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 风暴之眼 */
            case "eye_of_storm_eye" -> {
                allowedTypes = TBZServerConfig.EYE_OF_STORM_EYE_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.EYE_OF_STORM_EYE_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [持续伤害]类型附魔 ==========
            /* 羸弱能量球 */
            case "attrition_orbs" -> {
                allowedTypes = TBZServerConfig.ATTRITION_ORBS_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.ATTRITION_ORBS_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [填装]类型附魔 ==========
            /* 不法之徒 */
            case "outlaw" -> {
                allowedTypes = TBZServerConfig.OUTLAW_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.OUTLAW_WEAPON_TYPE_WHITELIST_MODE.get();
            }

            // ========== [其他]类型附魔 ==========
            /* 泉源 */
            case "wellspring" -> {
                allowedTypes = TBZServerConfig.WELLSPRING_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.WELLSPRING_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 冷却饰物 */
            case "cooling_baubles" -> {
                allowedTypes = TBZServerConfig.COOLING_BAUBLES_APPLICABLE_WEAPON_TYPES.get();
                yield TBZServerConfig.COOLING_BAUBLES_WEAPON_TYPE_WHITELIST_MODE.get();
            }
            /* 边打边劫 */
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
}