package com.chinaex123.tbz.utils;

import com.chinaex123.tbz.TBZMod;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 附魔冲突解析器
 * <p>
 * 功能：管理所有附魔之间的冲突关系，硬编码规则
 * <p>
 * 机制：
 * <ol>
 *   <li>使用Map存储冲突关系</li>
 *   <li>支持双向冲突和单向冲突</li>
 *   <li>自动构建附魔到RegistryObject的映射</li>
 *   <li>提供冲突检查方法</li>
 * </ol>
 */
public class EnchantmentConflictResolver {

    /** 存储冲突关系的Map（RegistryObject → 冲突的RegistryObject集合） **/
    private static final Map<RegistryObject<? extends Enchantment>, Set<RegistryObject<? extends Enchantment>>> CONFLICT_MAP = new HashMap<>();

    /** 附魔到RegistryObject的映射 **/
    private static final Map<Enchantment, RegistryObject<? extends Enchantment>> ENCHANTMENT_TO_REGISTRY_MAP = new HashMap<>();

    static {
        initializeConflicts();
        buildReverseMappingAutomatically();
    }

    /**
     * 初始化所有附魔冲突关系
     */
    private static void initializeConflicts() {
//        addConflict(TBZEnchantments.HEAL_CLIP, TBZEnchantments.WELLSPRING);

        addMutualConflict(TBZEnchantments.ADAGIO, TBZEnchantments.ONSLAUGHT);
    }

    /**
     * 自动构建反向映射
     * 遍历所有已注册的TBZ附魔，建立Enchantment到RegistryObject的映射
     */
    private static void buildReverseMappingAutomatically() {
        for (Enchantment enchantment : ForgeRegistries.ENCHANTMENTS) {
            if (isTBZEnchantment(enchantment)) {
                RegistryObject<? extends Enchantment> registryObject = findRegistryObject(enchantment);
                if (registryObject != null) {
                    ENCHANTMENT_TO_REGISTRY_MAP.put(enchantment, registryObject);
                }
            }
        }
    }

    /**
     * 检查是否是TBZ模组的附魔
     *
     * @param enchantment 附魔对象
     * @return true表示是TBZ附魔
     */
    private static boolean isTBZEnchantment(Enchantment enchantment) {
        ResourceLocation registryName = ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
        return registryName != null && registryName.getNamespace().equals(TBZMod.MOD_ID);
    }

    /**
     * 通过反射查找附魔对应的RegistryObject
     *
     * @param enchantment 附魔对象
     * @return 对应的RegistryObject，未找到返回null
     */
    private static RegistryObject<? extends Enchantment> findRegistryObject(Enchantment enchantment) {
        ResourceLocation registryName = ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
        if (registryName == null) return null;

        String enchantmentName = registryName.getPath();

        try {
            // 遍历TBZEnchantments类的所有静态字段
            java.lang.reflect.Field[] fields = TBZEnchantments.class.getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                if (field.getType() == RegistryObject.class) {
                    @SuppressWarnings("unchecked")
                    RegistryObject<? extends Enchantment> registryObject = (RegistryObject<? extends Enchantment>) field.get(null);

                    if (registryObject != null && registryObject.isPresent()) {
                        ResourceLocation roKey = ForgeRegistries.ENCHANTMENTS.getKey(registryObject.get());
                        if (roKey != null && roKey.getPath().equals(enchantmentName)) {
                            return registryObject;
                        }
                    }
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }

        return null;
    }

    /**
     * 添加双向冲突关系（多个附魔之间两两冲突）
     *
     * @param enchantments 附魔RegistryObject数组
     */
    @SafeVarargs
    private static void addMutualConflict(RegistryObject<? extends Enchantment>... enchantments) {
        for (int i = 0; i < enchantments.length; i++) {
            for (int j = i + 1; j < enchantments.length; j++) {
                addConflict(enchantments[i], enchantments[j]);
            }
        }
    }

    /**
     * 添加双向冲突关系
     *
     * @param enchantment1 附魔1
     * @param enchantment2 附魔2
     */
    private static void addConflict(RegistryObject<? extends Enchantment> enchantment1,
                                    RegistryObject<? extends Enchantment> enchantment2) {
        CONFLICT_MAP.computeIfAbsent(enchantment1, k -> new HashSet<>()).add(enchantment2);
        CONFLICT_MAP.computeIfAbsent(enchantment2, k -> new HashSet<>()).add(enchantment1);
    }

    /**
     * 获取附魔对应的RegistryObject
     *
     * @param enchantment 附魔对象
     * @return 对应的RegistryObject
     */
    public static RegistryObject<? extends Enchantment> getRegistryObject(Enchantment enchantment) {
        return ENCHANTMENT_TO_REGISTRY_MAP.get(enchantment);
    }

    /**
     * 检查两个附魔是否冲突
     *
     * @param enchantment1 附魔1的RegistryObject
     * @param enchantment2 附魔2的RegistryObject
     * @return true表示存在冲突
     */
    public static boolean isConflict(RegistryObject<? extends Enchantment> enchantment1,
                                     RegistryObject<? extends Enchantment> enchantment2) {
        if (enchantment1 == null || enchantment2 == null) return false;
        if (enchantment1.equals(enchantment2)) return false;

        Set<RegistryObject<? extends Enchantment>> conflicts = CONFLICT_MAP.get(enchantment1);
        return conflicts != null && conflicts.contains(enchantment2);
    }

    /**
     * 检查一个附魔是否与集合中的任何附魔冲突
     *
     * @param enchantment 要检查的附魔
     * @param otherEnchantments 其他附魔集合
     * @return true表示存在冲突
     */
    public static boolean hasConflictWithAny(RegistryObject<? extends Enchantment> enchantment,
                                             Collection<RegistryObject<? extends Enchantment>> otherEnchantments) {
        if (enchantment == null || otherEnchantments == null || otherEnchantments.isEmpty()) {
            return false;
        }

        for (RegistryObject<? extends Enchantment> other : otherEnchantments) {
            if (isConflict(enchantment, other)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定附魔的所有冲突附魔
     *
     * @param enchantment 附魔的RegistryObject
     * @return 冲突附魔的集合
     */
    public static Set<RegistryObject<? extends Enchantment>> getConflicts(RegistryObject<? extends Enchantment> enchantment) {
        return CONFLICT_MAP.getOrDefault(enchantment, Collections.emptySet());
    }

    /**
     * 检查附魔集合内部是否存在冲突
     *
     * @param enchantments 附魔RegistryObject集合
     * @return true表示存在内部冲突
     */
    public static boolean hasInternalConflict(Collection<RegistryObject<? extends Enchantment>> enchantments) {
        if (enchantments == null || enchantments.size() < 2) {
            return false;
        }

        List<RegistryObject<? extends Enchantment>> enchantmentList = new ArrayList<>(enchantments);
        for (int i = 0; i < enchantmentList.size(); i++) {
            for (int j = i + 1; j < enchantmentList.size(); j++) {
                if (isConflict(enchantmentList.get(i), enchantmentList.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查一组附魔中异域类附魔数量是否超过配置限制
     * @param enchantments 附魔集合
     * @return true表示超过限制
     */
    public static boolean exceedsExoticLimit(Collection<RegistryObject<? extends Enchantment>> enchantments) {
        int maxExotic = TBZServerConfig.MAX_EXOTIC_ENCHANTMENTS.get();
        if (maxExotic <= 0) {
            return false; // 0表示不限制
        }

        Collection<Enchantment> enchantmentInstances = enchantments.stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
        int exoticCount = EnchantmentTypeUtils.countExoticEnchantments(enchantmentInstances);

        return exoticCount > maxExotic;
    }

    /**
     * 检查添加新附魔后是否会导致异域类附魔数量超过限制
     * @param existingEnchantments 现有附魔集合
     * @param newEnchantment 要添加的新附魔
     * @return true表示会超过限制
     */
    public static boolean wouldExceedExoticLimit(Collection<RegistryObject<? extends Enchantment>> existingEnchantments,
                                                  RegistryObject<? extends Enchantment> newEnchantment) {
        int maxExotic = TBZServerConfig.MAX_EXOTIC_ENCHANTMENTS.get();
        if (maxExotic <= 0) {
            return false; // 0表示不限制
        }

        // 如果新附魔不是异域类，则不会影响限制
        if (!EnchantmentTypeUtils.isExoticEnchantment(newEnchantment.get())) {
            return false;
        }

        // 计算现有异域类附魔数量
        Collection<Enchantment> enchantmentInstances = existingEnchantments.stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
        int exoticCount = EnchantmentTypeUtils.countExoticEnchantments(enchantmentInstances);


        // 检查添加后是否会超过限制
        return exoticCount >= maxExotic;
    }


}