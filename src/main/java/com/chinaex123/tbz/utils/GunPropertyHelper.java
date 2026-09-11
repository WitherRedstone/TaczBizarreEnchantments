package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.TBZMod;
import com.tacz.guns.api.GunProperties;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.resource.modifier.AttachmentCacheProperty;
import com.tacz.guns.resource.pojo.data.gun.InaccuracyType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * 枪械属性管理工具类
 * <p>
 * 功能：提供通用的枪械属性修改功能，支持多个附魔复用
 * <p>
 * 使用场景：
 * <ul>
 *   <li>测距仪附魔：瞄准时增加优势射程</li>
 *   <li>其他附魔：可根据条件动态调整优势射程、精度等属性</li>
 * </ul>
 */
public class GunPropertyHelper {

    /**
     * 优势射程管理内部类
     */
    public static class EffectiveRange {

        /** NBT存储键：原始优势射程 **/
        private static final String ORIGINAL_EFFECTIVE_RANGE_TAG = "TBZ_OriginalEffectiveRange";

        /**
         * 更新优势射程
         * <p>
         * 根据激活状态和参数计算新的优势射程，并更新到缓存
         * <p>
         * 计算公式：
         * <ul>
         *   <li>激活时：新射程 = 原始射程 × (1 + (因子-1) × 等级)</li>
         *   <li>未激活时：恢复原始射程</li>
         * </ul>
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param isActive 是否激活效果（如瞄准状态）
         * @param level 附魔等级或效果等级
         * @param rangeBonusFactorPerLevel 每级的射程提升因子（1.45 表示增加45%射程）
         */
        public static void update(Player player, ItemStack gun, boolean isActive, int level, double rangeBonusFactorPerLevel) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Float currentEffectiveRange = cacheProperty.getCache(GunProperties.EFFECTIVE_RANGE);
                if (currentEffectiveRange == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();

                if (isActive) {
                    if (!tag.contains(ORIGINAL_EFFECTIVE_RANGE_TAG)) {
                        tag.putFloat(ORIGINAL_EFFECTIVE_RANGE_TAG, currentEffectiveRange);
                    }

                    float originalRange = tag.getFloat(ORIGINAL_EFFECTIVE_RANGE_TAG);
                    float totalRangeBonusFactor = (float) (1.0f + (rangeBonusFactorPerLevel - 1.0f) * level);
                    float newEffectiveRange = originalRange * totalRangeBonusFactor;

                    cacheProperty.setCache(GunProperties.EFFECTIVE_RANGE, newEffectiveRange);
                } else {
                    if (tag.contains(ORIGINAL_EFFECTIVE_RANGE_TAG)) {
                        float originalRange = tag.getFloat(ORIGINAL_EFFECTIVE_RANGE_TAG);
                        cacheProperty.setCache(GunProperties.EFFECTIVE_RANGE, originalRange);
                    }
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.EffectiveRange.update] 更新优势射程失败: {}", e.getMessage());
            }
        }

        /**
         * 重置优势射程到原始值
         * <p>
         * 强制恢复枪械的原始优势射程，清除所有修改
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         */
        public static void reset(Player player, ItemStack gun) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                if (tag.contains(ORIGINAL_EFFECTIVE_RANGE_TAG)) {
                    float originalRange = tag.getFloat(ORIGINAL_EFFECTIVE_RANGE_TAG);
                    cacheProperty.setCache(GunProperties.EFFECTIVE_RANGE, originalRange);
                    tag.remove(ORIGINAL_EFFECTIVE_RANGE_TAG);
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.EffectiveRange.reset] 重置优势射程失败: {}", e.getMessage());
            }
        }

        /**
         * 获取当前优势射程
         *
         * @param player 玩家对象
         * @return 当前优势射程，如果获取失败返回 null
         */
        public static Float getCurrent(Player player) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return null;
                }

                return cacheProperty.getCache(GunProperties.EFFECTIVE_RANGE);
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.EffectiveRange.getCurrent] 获取当前优势射程失败: {}", e.getMessage());
                return null;
            }
        }

        /**
         * 获取原始优势射程
         *
         * @param gun 枪械物品
         * @return 原始优势射程，如果未保存返回 null
         */
        public static Float getOriginal(ItemStack gun) {
            CompoundTag tag = gun.getOrCreateTag();
            if (tag.contains(ORIGINAL_EFFECTIVE_RANGE_TAG)) {
                return tag.getFloat(ORIGINAL_EFFECTIVE_RANGE_TAG);
            }
            return null;
        }
    }

    /**
     * 精度管理内部类
     */
    public static class Inaccuracy {

        /** NBT存储键前缀 **/
        private static final String ORIGINAL_INACCURACY_TAG_PREFIX = "TBZ_OriginalInaccuracy_";

        /**
         * 更新精度
         * <p>
         * 根据激活状态和参数计算新的精度，并更新到缓存
         * <p>
         * 计算公式：
         * <ul>
         *   <li>激活时：新精度 = 原始精度 × (1 - (1-因子) × 等级)</li>
         *   <li>未激活时：恢复原始精度</li>
         * </ul>
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param inaccuracyType 精度类型（AIM 或 HIP）
         * @param isActive 是否激活效果（如瞄准状态）
         * @param level 附魔等级或效果等级
         * @param accuracyImprovementFactorPerLevel 每级的精度提升因子（0.85 表示提升15%精度）
         */
        public static void update(Player player, ItemStack gun, InaccuracyType inaccuracyType, boolean isActive, int level, double accuracyImprovementFactorPerLevel) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Map<InaccuracyType, Float> currentInaccuracy = cacheProperty.getCache(GunProperties.INACCURACY);
                if (currentInaccuracy == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                String originalTagKey = ORIGINAL_INACCURACY_TAG_PREFIX + inaccuracyType.name();

                if (isActive) {
                    Float originalInaccuracy = null;
                    if (tag.contains(originalTagKey)) {
                        originalInaccuracy = tag.getFloat(originalTagKey);
                    } else {
                        originalInaccuracy = currentInaccuracy.get(inaccuracyType);
                        if (originalInaccuracy != null) {
                            tag.putFloat(originalTagKey, originalInaccuracy);
                        }
                    }

                    if (originalInaccuracy != null) {
                        float totalImprovementFactor = (float) (1.0f - (1.0f - accuracyImprovementFactorPerLevel) * level);
                        float newInaccuracy = originalInaccuracy * totalImprovementFactor;

                        Map<InaccuracyType, Float> newInaccuracyMap = new HashMap<>(currentInaccuracy);
                        newInaccuracyMap.put(inaccuracyType, newInaccuracy);

                        cacheProperty.setCache(GunProperties.INACCURACY, newInaccuracyMap);
                    }
                } else {
                    if (tag.contains(originalTagKey)) {
                        float originalInaccuracy = tag.getFloat(originalTagKey);

                        Map<InaccuracyType, Float> newInaccuracyMap = new HashMap<>(currentInaccuracy);
                        newInaccuracyMap.put(inaccuracyType, originalInaccuracy);

                        cacheProperty.setCache(GunProperties.INACCURACY, newInaccuracyMap);
                    }
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Inaccuracy.update] 更新精度失败: {}", e.getMessage());
            }
        }

        /**
         * 重置精度到原始值
         * <p>
         * 强制恢复枪械的原始精度，清除所有修改
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param inaccuracyType 精度类型（AIM 或 HIP）
         */
        public static void reset(Player player, ItemStack gun, InaccuracyType inaccuracyType) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Map<InaccuracyType, Float> currentInaccuracy = cacheProperty.getCache(GunProperties.INACCURACY);
                if (currentInaccuracy == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                String originalTagKey = ORIGINAL_INACCURACY_TAG_PREFIX + inaccuracyType.name();
                if (tag.contains(originalTagKey)) {
                    float originalInaccuracy = tag.getFloat(originalTagKey);

                    Map<InaccuracyType, Float> newInaccuracyMap = new HashMap<>(currentInaccuracy);
                    newInaccuracyMap.put(inaccuracyType, originalInaccuracy);

                    cacheProperty.setCache(GunProperties.INACCURACY, newInaccuracyMap);
                    tag.remove(originalTagKey);
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Inaccuracy.reset] 重置精度失败: {}", e.getMessage());
            }
        }

        /**
         * 获取当前精度
         *
         * @param player 玩家对象
         * @param inaccuracyType 精度类型（AIM 或 HIP）
         * @return 当前精度，如果获取失败返回 null
         */
        public static Float getCurrent(Player player, InaccuracyType inaccuracyType) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return null;
                }

                Map<InaccuracyType, Float> inaccuracy = cacheProperty.getCache(GunProperties.INACCURACY);
                if (inaccuracy == null) {
                    return null;
                }

                return inaccuracy.get(inaccuracyType);
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Inaccuracy.getCurrent] 获取当前精度失败: {}", e.getMessage());
                return null;
            }
        }

        /**
         * 获取原始精度
         *
         * @param gun 枪械物品
         * @param inaccuracyType 精度类型（AIM 或 HIP）
         * @return 原始精度，如果未保存返回 null
         */
        public static Float getOriginal(ItemStack gun, InaccuracyType inaccuracyType) {
            CompoundTag tag = gun.getOrCreateTag();
            String originalTagKey = ORIGINAL_INACCURACY_TAG_PREFIX + inaccuracyType.name();
            if (tag.contains(originalTagKey)) {
                return tag.getFloat(originalTagKey);
            }
            return null;
        }
    }

//    /**
//     * 后坐力管理内部类
//     */
//    public static class Recoil {
//
//        /** NBT存储键：原始水平后坐力 **/
//        private static final String ORIGINAL_RECOIL_HORIZONTAL_TAG = "TBZ_OriginalRecoilHorizontal";
//
//        /** NBT存储键：原始垂直后坐力 **/
//        private static final String ORIGINAL_RECOIL_VERTICAL_TAG = "TBZ_OriginalRecoilVertical";
//
//        /**
//         * 更新后坐力
//         * <p>
//         * 根据激活状态和参数计算新的后坐力，并更新到缓存
//         * <p>
//         * 计算公式：
//         * <ul>
//         *   <li>激活时：新后坐力 = 原始后坐力 × (1 - 每级倍率 × 等级)</li>
//         *   <li>未激活时：恢复原始后坐力</li>
//         * </ul>
//         *
//         * @param player 玩家对象
//         * @param gun 枪械物品
//         * @param isActive 是否激活效果（如瞄准状态）
//         * @param level 附魔等级或效果等级
//         * @param recoilReductionPerLevel 每级的后坐力减少倍率（0.2 表示减少20%后坐力）
//         */
//        public static void update(Player player, ItemStack gun, boolean isActive, int level, double recoilReductionPerLevel) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return;
//                }
//
//                ParameterizedCachePair<Float, Float> currentRecoil = cacheProperty.getCache(GunProperties.RECOIL);
//                if (currentRecoil == null) {
//                    return;
//                }
//
//                CompoundTag tag = gun.getOrCreateTag();
//
//                if (isActive) {
//                    Float originalHorizontal = null;
//                    Float originalVertical = null;
//
//                    if (tag.contains(ORIGINAL_RECOIL_HORIZONTAL_TAG)) {
//                        originalHorizontal = tag.getFloat(ORIGINAL_RECOIL_HORIZONTAL_TAG);
//                    } else {
//                        originalHorizontal = currentRecoil.left().getDefaultValue();
//                        if (originalHorizontal != null) {
//                            tag.putFloat(ORIGINAL_RECOIL_HORIZONTAL_TAG, originalHorizontal);
//                        }
//                    }
//
//                    if (tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                        originalVertical = tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//                    } else {
//                        originalVertical = currentRecoil.right().getDefaultValue();
//                        if (originalVertical != null) {
//                            tag.putFloat(ORIGINAL_RECOIL_VERTICAL_TAG, originalVertical);
//                        }
//                    }
//
//                    if (originalHorizontal != null && originalVertical != null) {
//                        float newHorizontal = originalHorizontal * (1.0f - (float)(recoilReductionPerLevel * level));
//                        float newVertical = originalVertical * (1.0f - (float)(recoilReductionPerLevel * level));
//
//                        ParameterizedCachePair<Float, Float> newRecoil = ParameterizedCachePair.of(newHorizontal, newVertical);
//                        cacheProperty.setCache(GunProperties.RECOIL, newRecoil);
//                    }
//                } else {
//                    if (tag.contains(ORIGINAL_RECOIL_HORIZONTAL_TAG) && tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                        float originalHorizontal = tag.getFloat(ORIGINAL_RECOIL_HORIZONTAL_TAG);
//                        float originalVertical = tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//
//                        ParameterizedCachePair<Float, Float> newRecoil = ParameterizedCachePair.of(originalHorizontal, originalVertical);
//                        cacheProperty.setCache(GunProperties.RECOIL, newRecoil);
//                    }
//                }
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.Recoil.update] 更新后坐力失败: {}", e.getMessage());
//            }
//        }
//
//        /**
//         * 重置后坐力到原始值
//         * <p>
//         * 强制恢复枪械的原始后坐力，清除所有修改
//         *
//         * @param player 玩家对象
//         * @param gun 枪械物品
//         */
//        public static void reset(Player player, ItemStack gun) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return;
//                }
//
//                CompoundTag tag = gun.getOrCreateTag();
//                if (tag.contains(ORIGINAL_RECOIL_HORIZONTAL_TAG) && tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                    float originalHorizontal = tag.getFloat(ORIGINAL_RECOIL_HORIZONTAL_TAG);
//                    float originalVertical = tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//
//                    ParameterizedCachePair<Float, Float> newRecoil = ParameterizedCachePair.of(originalHorizontal, originalVertical);
//                    cacheProperty.setCache(GunProperties.RECOIL, newRecoil);
//
//                    tag.remove(ORIGINAL_RECOIL_HORIZONTAL_TAG);
//                    tag.remove(ORIGINAL_RECOIL_VERTICAL_TAG);
//                }
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.Recoil.reset] 重置后坐力失败: {}", e.getMessage());
//            }
//        }
//
//        /**
//         * 获取当前水平后坐力
//         *
//         * @param player 玩家对象
//         * @return 当前水平后坐力，如果获取失败返回 null
//         */
//        public static Float getHorizontalCurrent(Player player) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return null;
//                }
//
//                ParameterizedCachePair<Float, Float> recoil = cacheProperty.getCache(GunProperties.RECOIL);
//                if (recoil == null) {
//                    return null;
//                }
//
//                return recoil.left().getDefaultValue();
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.Recoil.getHorizontalCurrent] 获取当前水平后坐力失败: {}", e.getMessage());
//                return null;
//            }
//        }
//
//        /**
//         * 获取当前垂直后坐力
//         *
//         * @param player 玩家对象
//         * @return 当前垂直后坐力，如果获取失败返回 null
//         */
//        public static Float getVerticalCurrent(Player player) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return null;
//                }
//
//                ParameterizedCachePair<Float, Float> recoil = cacheProperty.getCache(GunProperties.RECOIL);
//                if (recoil == null) {
//                    return null;
//                }
//
//                return recoil.right().getDefaultValue();
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.Recoil.getVerticalCurrent] 获取当前垂直后坐力失败: {}", e.getMessage());
//                return null;
//            }
//        }
//
//        /**
//         * 获取原始水平后坐力
//         *
//         * @param gun 枪械物品
//         * @return 原始水平后坐力，如果未保存返回 null
//         */
//        public static Float getHorizontalOriginal(ItemStack gun) {
//            CompoundTag tag = gun.getOrCreateTag();
//            if (tag.contains(ORIGINAL_RECOIL_HORIZONTAL_TAG)) {
//                return tag.getFloat(ORIGINAL_RECOIL_HORIZONTAL_TAG);
//            }
//            return null;
//        }
//
//        /**
//         * 获取原始垂直后坐力
//         *
//         * @param gun 枪械物品
//         * @return 原始垂直后坐力，如果未保存返回 null
//         */
//        public static Float getVerticalOriginal(ItemStack gun) {
//            CompoundTag tag = gun.getOrCreateTag();
//            if (tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                return tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//            }
//            return null;
//        }
//
//        /**
//         * 更新垂直后坐力
//         * <p>
//         * 根据激活状态和参数计算新的垂直后坐力，并更新到缓存
//         * <p>
//         * 计算公式：
//         * <ul>
//         *   <li>激活时：新垂直后坐力 = 原始垂直后坐力 × (1 - 每级倍率 × 等级)</li>
//         *   <li>未激活时：恢复原始垂直后坐力</li>
//         * </ul>
//         *
//         * @param player 玩家对象
//         * @param gun 枪械物品
//         * @param isActive 是否激活效果（如瞄准状态）
//         * @param level 附魔等级或效果等级
//         * @param verticalRecoilReductionPerLevel 每级的垂直后坐力减少倍率（0.1 表示减少10%垂直后坐力）
//         */
//        public static void updateVertical(Player player, ItemStack gun, boolean isActive, int level, double verticalRecoilReductionPerLevel) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return;
//                }
//
//                ParameterizedCachePair<Float, Float> currentRecoil = cacheProperty.getCache(GunProperties.RECOIL);
//                if (currentRecoil == null) {
//                    return;
//                }
//
//                CompoundTag tag = gun.getOrCreateTag();
//
//                if (isActive) {
//                    Float originalVertical = null;
//                    Float currentHorizontal = currentRecoil.left().getDefaultValue();
//
//                    if (tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                        originalVertical = tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//                    } else {
//                        originalVertical = currentRecoil.right().getDefaultValue();
//                        if (originalVertical != null) {
//                            tag.putFloat(ORIGINAL_RECOIL_VERTICAL_TAG, originalVertical);
//                        }
//                    }
//
//                    if (originalVertical != null && currentHorizontal != null) {
//                        float newVertical = originalVertical * (1.0f - (float)(verticalRecoilReductionPerLevel * level));
//
//                        ParameterizedCachePair<Float, Float> newRecoil = ParameterizedCachePair.of(currentHorizontal, newVertical);
//                        cacheProperty.setCache(GunProperties.RECOIL, newRecoil);
//                    }
//                } else {
//                    if (tag.contains(ORIGINAL_RECOIL_VERTICAL_TAG)) {
//                        float originalVertical = tag.getFloat(ORIGINAL_RECOIL_VERTICAL_TAG);
//                        float currentHorizontal = currentRecoil.left().getDefaultValue();
//
//                        ParameterizedCachePair<Float, Float> newRecoil = ParameterizedCachePair.of(currentHorizontal, originalVertical);
//                        cacheProperty.setCache(GunProperties.RECOIL, newRecoil);
//                    }
//                }
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.Recoil.updateVertical] 更新垂直后坐力失败: {}", e.getMessage());
//            }
//        }
//    }

//    /**
//     * 射速管理内部类
//     */
//    public static class FireRate {
//
//        /** NBT存储键：原始射速 **/
//        private static final String ORIGINAL_FIRE_RATE_TAG = "TBZ_OriginalFireRate";
//
//        /**
//         * 更新射速
//         * <p>
//         * 根据激活状态和参数计算新的射速，并更新到缓存
//         * <p>
//         * 计算公式：
//         * <ul>
//         *   <li>激活时：新射速 = 原始射速 × (1 + (因子-1) × 等级)</li>
//         *   <li>未激活时：恢复原始射速</li>
//         * </ul>
//         *
//         * @param player 玩家对象
//         * @param gun 枪械物品
//         * @param isActive 是否激活效果（如瞄准状态）
//         * @param level 附魔等级或效果等级
//         * @param fireRateBonusFactorPerLevel 每级的射速提升因子（1.1 表示提升10%射速）
//         */
//        public static void update(Player player, ItemStack gun, boolean isActive, int level, double fireRateBonusFactorPerLevel) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return;
//                }
//
//                Integer currentFireRate = cacheProperty.getCache(GunProperties.ROUNDS_PER_MINUTE);
//                if (currentFireRate == null) {
//                    return;
//                }
//
//                CompoundTag tag = gun.getOrCreateTag();
//
//                if (isActive) {
//                    if (!tag.contains(ORIGINAL_FIRE_RATE_TAG)) {
//                        tag.putInt(ORIGINAL_FIRE_RATE_TAG, currentFireRate);
//                    }
//
//                    int originalFireRate = tag.getInt(ORIGINAL_FIRE_RATE_TAG);
//                    double totalFireRateBonusFactor = 1.0 + (fireRateBonusFactorPerLevel - 1.0) * level;
//                    int newFireRate = (int)(originalFireRate * totalFireRateBonusFactor);
//
//                    cacheProperty.setCache(GunProperties.ROUNDS_PER_MINUTE, newFireRate);
//                } else {
//                    if (tag.contains(ORIGINAL_FIRE_RATE_TAG)) {
//                        int originalFireRate = tag.getInt(ORIGINAL_FIRE_RATE_TAG);
//                        cacheProperty.setCache(GunProperties.ROUNDS_PER_MINUTE, originalFireRate);
//                    }
//                }
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.FireRate.update] 更新射速失败: {}", e.getMessage());
//            }
//        }
//
//        /**
//         * 重置射速到原始值
//         * <p>
//         * 强制恢复枪械的原始射速，清除所有修改
//         *
//         * @param player 玩家对象
//         * @param gun 枪械物品
//         */
//        public static void reset(Player player, ItemStack gun) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return;
//                }
//
//                CompoundTag tag = gun.getOrCreateTag();
//                if (tag.contains(ORIGINAL_FIRE_RATE_TAG)) {
//                    int originalFireRate = tag.getInt(ORIGINAL_FIRE_RATE_TAG);
//                    cacheProperty.setCache(GunProperties.ROUNDS_PER_MINUTE, originalFireRate);
//                    tag.remove(ORIGINAL_FIRE_RATE_TAG);
//                }
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.FireRate.reset] 重置射速失败: {}", e.getMessage());
//            }
//        }
//
//        /**
//         * 获取当前射速
//         *
//         * @param player 玩家对象
//         * @return 当前射速，如果获取失败返回 null
//         */
//        public static Integer getCurrent(Player player) {
//            try {
//                IGunOperator operator = IGunOperator.fromLivingEntity(player);
//                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
//                if (cacheProperty == null) {
//                    return null;
//                }
//
//                return cacheProperty.getCache(GunProperties.ROUNDS_PER_MINUTE);
//            } catch (Exception e) {
//                TBZMod.LOGGER.warn("[GunPropertyHelper.FireRate.getCurrent] 获取当前射速失败: {}", e.getMessage());
//                return null;
//            }
//        }
//
//        /**
//         * 获取原始射速
//         *
//         * @param gun 枪械物品
//         * @return 原始射速，如果未保存返回 null
//         */
//        public static Integer getOriginal(ItemStack gun) {
//            CompoundTag tag = gun.getOrCreateTag();
//            if (tag.contains(ORIGINAL_FIRE_RATE_TAG)) {
//                return tag.getInt(ORIGINAL_FIRE_RATE_TAG);
//            }
//            return null;
//        }
//    }

    /**
     * 暴击倍率管理内部类
     */
    public static class Headshot {

        /** NBT存储键：原始暴击倍率 **/
        private static final String ORIGINAL_HEADSHOT_MULTIPLIER_TAG = "TBZ_OriginalHeadshotMultiplier";

        /**
         * 更新暴击倍率
         * <p>
         * 根据激活状态和参数计算新的暴击倍率，并更新到缓存
         * <p>
         * 计算公式：
         * <ul>
         *   <li>激活时：新暴击倍率 = 原始暴击倍率 × (1 + 每级倍率 × 等级)</li>
         *   <li>未激活时：恢复原始暴击倍率</li>
         * </ul>
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param isActive 是否激活效果（如瞄准状态）
         * @param level 附魔等级或效果等级
         * @param headshotBonusPerLevel 每级的暴击倍率提升倍率（0.15 表示提升15%暴击倍率）
         */
        public static void update(Player player, ItemStack gun, boolean isActive, int level, double headshotBonusPerLevel) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Float currentHeadshotMultiplier = cacheProperty.getCache(GunProperties.HEADSHOT_MULTIPLIER);
                if (currentHeadshotMultiplier == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();

                if (isActive) {
                    if (!tag.contains(ORIGINAL_HEADSHOT_MULTIPLIER_TAG)) {
                        tag.putFloat(ORIGINAL_HEADSHOT_MULTIPLIER_TAG, currentHeadshotMultiplier);
                    }

                    float originalHeadshotMultiplier = tag.getFloat(ORIGINAL_HEADSHOT_MULTIPLIER_TAG);
                    float newHeadshotMultiplier = originalHeadshotMultiplier * (1.0f + (float)(headshotBonusPerLevel * level));

                    cacheProperty.setCache(GunProperties.HEADSHOT_MULTIPLIER, newHeadshotMultiplier);
                } else {
                    if (tag.contains(ORIGINAL_HEADSHOT_MULTIPLIER_TAG)) {
                        float originalHeadshotMultiplier = tag.getFloat(ORIGINAL_HEADSHOT_MULTIPLIER_TAG);
                        cacheProperty.setCache(GunProperties.HEADSHOT_MULTIPLIER, originalHeadshotMultiplier);
                    }
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Headshot.update] 更新暴击倍率失败: {}", e.getMessage());
            }
        }

        /**
         * 重置暴击倍率到原始值
         * <p>
         * 强制恢复枪械的原始暴击倍率，清除所有修改
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         */
        public static void reset(Player player, ItemStack gun) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                if (tag.contains(ORIGINAL_HEADSHOT_MULTIPLIER_TAG)) {
                    float originalHeadshotMultiplier = tag.getFloat(ORIGINAL_HEADSHOT_MULTIPLIER_TAG);
                    cacheProperty.setCache(GunProperties.HEADSHOT_MULTIPLIER, originalHeadshotMultiplier);
                    tag.remove(ORIGINAL_HEADSHOT_MULTIPLIER_TAG);
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Headshot.reset] 重置暴击倍率失败: {}", e.getMessage());
            }
        }

        /**
         * 获取当前暴击倍率
         *
         * @param player 玩家对象
         * @return 当前暴击倍率，如果获取失败返回 null
         */
        public static Float getCurrent(Player player) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return null;
                }

                return cacheProperty.getCache(GunProperties.HEADSHOT_MULTIPLIER);
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Headshot.getCurrent] 获取当前暴击倍率失败: {}", e.getMessage());
                return null;
            }
        }

        /**
         * 获取原始暴击倍率
         *
         * @param gun 枪械物品
         * @return 原始暴击倍率，如果未保存返回 null
         */
        public static Float getOriginal(ItemStack gun) {
            CompoundTag tag = gun.getOrCreateTag();
            if (tag.contains(ORIGINAL_HEADSHOT_MULTIPLIER_TAG)) {
                return tag.getFloat(ORIGINAL_HEADSHOT_MULTIPLIER_TAG);
            }
            return null;
        }
    }

    /**
     * 护甲穿透管理内部类
     */
    public static class ArmorIgnore {

        /** NBT存储键：原始护甲穿透 **/
        private static final String ORIGINAL_ARMOR_IGNORE_TAG = "TBZ_OriginalArmorIgnore";

        /**
         * 更新护甲穿透
         * <p>
         * 根据激活状态和参数计算新的护甲穿透，并更新到缓存
         * <p>
         * 计算公式：
         * <ul>
         *   <li>激活时：新护甲穿透 = 原始护甲穿透 × (1 + 每级倍率 × 等级)</li>
         *   <li>未激活时：恢复原始护甲穿透</li>
         * </ul>
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param isActive 是否激活效果（如瞄准状态）
         * @param level 附魔等级或效果等级
         * @param armorIgnoreBonusPerLevel 每级的护甲穿透提升倍率（0.1 表示提升10%护甲穿透）
         */
        public static void update(Player player, ItemStack gun, boolean isActive, int level, double armorIgnoreBonusPerLevel) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Float currentArmorIgnore = cacheProperty.getCache(GunProperties.ARMOR_IGNORE);
                if (currentArmorIgnore == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();

                if (isActive) {
                    if (!tag.contains(ORIGINAL_ARMOR_IGNORE_TAG)) {
                        tag.putFloat(ORIGINAL_ARMOR_IGNORE_TAG, currentArmorIgnore);
                    }

                    float originalArmorIgnore = tag.getFloat(ORIGINAL_ARMOR_IGNORE_TAG);
                    float newArmorIgnore = originalArmorIgnore * (1.0f + (float)(armorIgnoreBonusPerLevel * level));

                    cacheProperty.setCache(GunProperties.ARMOR_IGNORE, newArmorIgnore);
                } else {
                    if (tag.contains(ORIGINAL_ARMOR_IGNORE_TAG)) {
                        float originalArmorIgnore = tag.getFloat(ORIGINAL_ARMOR_IGNORE_TAG);
                        cacheProperty.setCache(GunProperties.ARMOR_IGNORE, originalArmorIgnore);
                    }
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.ArmorIgnore.update] 更新护甲穿透失败: {}", e.getMessage());
            }
        }

        /**
         * 重置护甲穿透到原始值
         * <p>
         * 强制恢复枪械的原始护甲穿透，清除所有修改
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         */
        public static void reset(Player player, ItemStack gun) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                if (tag.contains(ORIGINAL_ARMOR_IGNORE_TAG)) {
                    float originalArmorIgnore = tag.getFloat(ORIGINAL_ARMOR_IGNORE_TAG);
                    cacheProperty.setCache(GunProperties.ARMOR_IGNORE, originalArmorIgnore);
                    tag.remove(ORIGINAL_ARMOR_IGNORE_TAG);
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.ArmorIgnore.reset] 重置护甲穿透失败: {}", e.getMessage());
            }
        }

        /**
         * 获取当前护甲穿透
         *
         * @param player 玩家对象
         * @return 当前护甲穿透，如果获取失败返回 null
         */
        public static Float getCurrent(Player player) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return null;
                }

                return cacheProperty.getCache(GunProperties.ARMOR_IGNORE);
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.ArmorIgnore.getCurrent] 获取当前护甲穿透失败: {}", e.getMessage());
                return null;
            }
        }

        /**
         * 获取原始护甲穿透
         *
         * @param gun 枪械物品
         * @return 原始护甲穿透，如果未保存返回 null
         */
        public static Float getOriginal(ItemStack gun) {
            CompoundTag tag = gun.getOrCreateTag();
            if (tag.contains(ORIGINAL_ARMOR_IGNORE_TAG)) {
                return tag.getFloat(ORIGINAL_ARMOR_IGNORE_TAG);
            }
            return null;
        }
    }

    /**
     * 击退管理内部类
     */
    public static class Knockback {

        /** NBT存储键：原始击退 **/
        private static final String ORIGINAL_KNOCKBACK_TAG = "TBZ_OriginalKnockback";

        /**
         * 更新击退
         * <p>
         * 根据激活状态和参数计算新的击退，并更新到缓存
         * <p>
         * 计算公式：
         * <ul>
         *   <li>激活时：新击退 = 原始击退 × (1 + 每级倍率 × 等级)</li>
         *   <li>未激活时：恢复原始击退</li>
         * </ul>
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         * @param isActive 是否激活效果（如瞄准状态）
         * @param level 附魔等级或效果等级
         * @param knockbackBonusPerLevel 每级的击退提升倍率（0.2 表示提升20%击退）
         */
        public static void update(Player player, ItemStack gun, boolean isActive, int level, double knockbackBonusPerLevel) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                Float currentKnockback = cacheProperty.getCache(GunProperties.KNOCKBACK);
                if (currentKnockback == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();

                if (isActive) {
                    if (!tag.contains(ORIGINAL_KNOCKBACK_TAG)) {
                        tag.putFloat(ORIGINAL_KNOCKBACK_TAG, currentKnockback);
                    }

                    float originalKnockback = tag.getFloat(ORIGINAL_KNOCKBACK_TAG);
                    float newKnockback = originalKnockback * (1.0f + (float)(knockbackBonusPerLevel * level));

                    cacheProperty.setCache(GunProperties.KNOCKBACK, newKnockback);
                } else {
                    if (tag.contains(ORIGINAL_KNOCKBACK_TAG)) {
                        float originalKnockback = tag.getFloat(ORIGINAL_KNOCKBACK_TAG);
                        cacheProperty.setCache(GunProperties.KNOCKBACK, originalKnockback);
                    }
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Knockback.update] 更新击退失败: {}", e.getMessage());
            }
        }

        /**
         * 重置击退到原始值
         * <p>
         * 强制恢复枪械的原始击退，清除所有修改
         *
         * @param player 玩家对象
         * @param gun 枪械物品
         */
        public static void reset(Player player, ItemStack gun) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return;
                }

                CompoundTag tag = gun.getOrCreateTag();
                if (tag.contains(ORIGINAL_KNOCKBACK_TAG)) {
                    float originalKnockback = tag.getFloat(ORIGINAL_KNOCKBACK_TAG);
                    cacheProperty.setCache(GunProperties.KNOCKBACK, originalKnockback);
                    tag.remove(ORIGINAL_KNOCKBACK_TAG);
                }
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Knockback.reset] 重置击退失败: {}", e.getMessage());
            }
        }

        /**
         * 获取当前击退
         *
         * @param player 玩家对象
         * @return 当前击退，如果获取失败返回 null
         */
        public static Float getCurrent(Player player) {
            try {
                IGunOperator operator = IGunOperator.fromLivingEntity(player);
                AttachmentCacheProperty cacheProperty = operator.getCacheProperty();
                if (cacheProperty == null) {
                    return null;
                }

                return cacheProperty.getCache(GunProperties.KNOCKBACK);
            } catch (Exception e) {
                TBZMod.LOGGER.warn("[GunPropertyHelper.Knockback.getCurrent] 获取当前击退失败: {}", e.getMessage());
                return null;
            }
        }

        /**
         * 获取原始击退
         *
         * @param gun 枪械物品
         * @return 原始击退，如果未保存返回 null
         */
        public static Float getOriginal(ItemStack gun) {
            CompoundTag tag = gun.getOrCreateTag();
            if (tag.contains(ORIGINAL_KNOCKBACK_TAG)) {
                return tag.getFloat(ORIGINAL_KNOCKBACK_TAG);
            }
            return null;
        }
    }
}