package com.chinaex123.tbz.event;

import com.chinaex123.tbz.utils.EnchantmentConflictResolver;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.GrindstoneEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Objects;

import java.util.List;
import java.util.stream.Collectors;

import static com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity.RANDOM_PERK_TRUE_TAG;

/**
 * 附魔冲突事件处理器
 * <p>
 * 功能：监听附魔相关事件，阻止冲突附魔的组合
 * <p>
 * 机制：
 * <ol>
 *   <li>监听铁砧更新事件</li>
 *   <li>检查左右物品的附魔是否冲突</li>
 *   <li>如果存在冲突则取消铁砧操作</li>
 * </ol>
 */
@Mod.EventBusSubscriber
public class EnchantmentConflictEventHandler {

    /**
     * 铁砧更新事件处理
     * 阻止冲突附魔的组合和异域类附魔数量超限
     *
     * @param event 铁砧更新事件
     */
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left.isEmpty()) return;
        // 检查左边物品是否有random_perk_true标签
        if (hasRandomPerkTag(left)) {
            event.setCanceled(true);
            return;
        }
        if (right.isEmpty()) return;

        // 获取左边物品的现有附魔
        Map<Enchantment, Integer> leftEnchants = EnchantmentHelper.getEnchantments(left);

        // 检查右边物品的附魔是否与左边冲突
        for (Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.getEnchantments(right).entrySet()) {
            Enchantment rightEnchant = entry.getKey();

            // 检查这个附魔是否与左边任何附魔冲突
            for (Enchantment leftEnchant : leftEnchants.keySet()) {
                if (isConflict(leftEnchant, rightEnchant)) {
                    event.setCanceled(true); // 取消附魔操作
                    return;
                }
            }
        }

        // 检查异域类附魔数量限制
        if (exceedsExoticLimit(leftEnchants, EnchantmentHelper.getEnchantments(right))) {
            event.setCanceled(true); // 取消附魔操作
        }
    }

    /**
     * 铁砧修复事件处理
     * 阻止有random_perk_true标签的武器进行修复操作
     *
     * @param event 铁砧修复事件
     */
    @SubscribeEvent
    public static void onAnvilRepair(AnvilRepairEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        ItemStack output = event.getOutput();

        // 检查输入或输出物品是否有random_perk_true标签
        if (hasRandomPerkTag(left) || hasRandomPerkTag(right) || hasRandomPerkTag(output)) {
            event.setCanceled(true);
        }
    }

    /**
     * 砂轮事件处理
     * 阻止有random_perk_true标签的武器在砂轮中清除附魔
     *
     * @param event 砂轮事件
     */
    @SubscribeEvent
    public static void onGrindstone(GrindstoneEvent event) {
        ItemStack top = event.getTopItem();
        ItemStack bottom = event.getBottomItem();
        // 检查上下槽位物品是否有random_perk_true标签
        if (hasRandomPerkTag(top) || hasRandomPerkTag(bottom)) {
            event.setCanceled(true);
        }
    }

    /**
     * 检查两个附魔是否冲突
     *
     * @param enchant1 附魔1
     * @param enchant2 附魔2
     * @return true表示存在冲突
     */
    private static boolean isConflict(Enchantment enchant1, Enchantment enchant2) {
        var ro1 = EnchantmentConflictResolver.getRegistryObject(enchant1);
        var ro2 = EnchantmentConflictResolver.getRegistryObject(enchant2);

        return ro1 != null && ro2 != null && EnchantmentConflictResolver.isConflict(ro1, ro2);
    }

    /**
     * 检查合并后的附魔是否会超过异域类附魔数量限制
     *
     * @param leftEnchants 左边物品的附魔
     * @param rightEnchants 右边物品的附魔
     * @return true表示会超过限制
     */
    private static boolean exceedsExoticLimit(Map<Enchantment, Integer> leftEnchants,
                                              Map<Enchantment, Integer> rightEnchants) {
        // 转换为RegistryObject集合
        List<RegistryObject<? extends Enchantment>> existingEnchantments = leftEnchants.keySet().stream()
            .map(EnchantmentConflictResolver::getRegistryObject)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        // 检查右边每个附魔是否会导致超限
        for (Enchantment rightEnchant : rightEnchants.keySet()) {
            var newEnchantment = EnchantmentConflictResolver.getRegistryObject(rightEnchant);
            if (newEnchantment != null &&
                EnchantmentConflictResolver.wouldExceedExoticLimit(existingEnchantments, newEnchantment)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查物品是否有random_perk_true标签
     *
     * @param stack 要检查的物品
     * @return true表示有random_perk_true标签
     */
    private static boolean hasRandomPerkTag(ItemStack stack) {
        if (stack.isEmpty()) return false;
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(RANDOM_PERK_TRUE_TAG);
    }
}