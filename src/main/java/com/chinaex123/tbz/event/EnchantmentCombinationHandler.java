package com.chinaex123.tbz.event;

import com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.item.IGun;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

/**
 * 附魔组合事件处理器
 * <p>
 * 功能：处理特定附魔组合的tooltip显示和属性加成
 * <p>
 * 机制：
 * <ol>
 *   <li>监听物品tooltip事件，检测特定附魔组合并显示tooltip</li>
 *   <li>监听玩家tick事件，当手持特定附魔组合的武器时给予移动速度加成</li>
 *   <li>仅对拥有随机Perk标记的枪械生效</li>
 * </ol>
 */
@Mod.EventBusSubscriber
public class EnchantmentCombinationHandler {

    /**
     * 附魔组合配置
     *
     * @param enchantments 附魔集合
     * @param minRequired 最少需要数量
     * @param tooltipKeys tooltip键列表
     * @param attributeBonus 属性加成配置
     */
    private record EnchantmentComboConfig(
            Set<RegistryObject<? extends Enchantment>> enchantments,
            int minRequired,
            List<String> tooltipKeys,
            AttributeBonusConfig attributeBonus
    ) {}

    /**
     * 属性加成配置
     *
     * @param attribute 属性类型
     * @param value 加成值
     * @param operation 操作类型
     * @param uuid 修改器UUID
     */
    private record AttributeBonusConfig(
            Attribute attribute,
            double value,
            AttributeModifier.Operation operation,
            UUID uuid
    ) {}

    /**
     * 获取附魔组合配置列表
     *
     * @return 附魔组合配置列表
     */
    private static List<EnchantmentComboConfig> getEnchantmentCombinationConfigs() {
        List<EnchantmentComboConfig> configs = new ArrayList<>();


        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.SWASHBUCKLER,
                        TBZEnchantments.ONE_FOR_ALL,
                        TBZEnchantments.MASTER_OF_ARMS
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("55e8b83a-fcba-48c6-88af-7ef9199eb4d6")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.TRIPLE_TAP,
                        TBZEnchantments.FOURTH_TIME_THE_CHARM,
                        TBZEnchantments.REWIND_ROUNDS
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("a8d6e1f2-3b4c-4d5e-6f7a-8b9c0d1e2f3a")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.PRECISION_INSTRUMENT,
                        TBZEnchantments.BOX_BREATHING
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("a82ccf31-45c5-4de8-aff4-e395c1fe021b")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.TRICKLE_CHARGE,
                        TBZEnchantments.SUPERCHARGED_MAGAZINE,
                        TBZEnchantments.ROLLING_STORM
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("108bc19f-295e-4262-95d5-26819b525b89")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.DESTABILIZING_ROUNDS,
                        TBZEnchantments.REPULSOR_BRACE
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("a09325b5-827c-4fa9-9675-a6b5f65361af")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.CHILL_CLIP,
                        TBZEnchantments.RIMESTEALER
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.077,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("35f2f323-2187-431e-8e11-0e7ba10e15f9")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.BURNING_AMBITION,
                        TBZEnchantments.INCANDESCENT,
                        TBZEnchantments.HEAL_CLIP
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("01b85ffa-a63f-4d0d-905f-a0770f12db1e")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.DRAGONFLY,
                        TBZEnchantments.MEGANEURA,
                        TBZEnchantments.FIREFLY
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("6742f762-8b5a-425f-aba1-a0118c555bd3")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.FIRMLY_PLANTED,
                        TBZEnchantments.EYE_OF_STORM_EYE,
                        TBZEnchantments.RANGEFINDER,
                        TBZEnchantments.KEEP_AWAY
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.ATTACK_DAMAGE,
                        0.077,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("c1c9d1d8-8100-4d82-aec5-d18cfa057d6e")
                )
        ));

        configs.add(new EnchantmentComboConfig(
                Set.of(
                        TBZEnchantments.ATTRITION_ORBS,
                        TBZEnchantments.WELLSPRING
                ),
                2,
                List.of("tooltip.tbz.combination_1"),
                new AttributeBonusConfig(
                        Attributes.MOVEMENT_SPEED,
                        0.177,
                        AttributeModifier.Operation.MULTIPLY_TOTAL,
                        UUID.fromString("bc43a954-5476-49d7-be2b-3922c5cf86d3")
                )
        ));

        return configs;
    }

    /**
     * 物品Tooltip事件处理
     * 检测特定附魔组合并显示tooltip
     *
     * @param event 物品Tooltip事件
     */
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        // 仅处理枪械
        if (!(stack.getItem() instanceof IGun)) {
            return;
        }

        // 获取匹配的tooltip键并添加
        List<String> tooltipKeys = getMatchingCombinationTooltipKeys(stack);
        for (String tooltipKey : tooltipKeys) {
            event.getToolTip().add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GOLD));
        }
    }

    /**
     * 玩家Tick事件处理
     * 当手持特定附魔组合的武器时给予属性加成
     *
     * @param event 玩家Tick事件
     */
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.side != LogicalSide.SERVER) return;

        Player player = event.player;
        ItemStack mainHand = player.getMainHandItem();

        // 移除所有现有的附魔组合属性修改器
        removeAllCombinationModifiers(player);

        // 检查并应用匹配的附魔组合属性加成
        if (!mainHand.isEmpty()) {
            var enchantments = EnchantmentHelper.getEnchantments(mainHand);

            // 仅对拥有随机Perk标记的武器生效
            if (hasRandomPerkTag(mainHand)) {
                for (EnchantmentComboConfig config : getEnchantmentCombinationConfigs()) {
                    if (hasRequiredEnchantments(enchantments, config) && config.attributeBonus() != null) {
                        applyAttributeBonus(player, config.attributeBonus());
                    }
                }
            }
        }
    }

    /**
     * 移除所有附魔组合的属性修改器
     *
     * @param player 玩家
     */
    private static void removeAllCombinationModifiers(Player player) {
        // 收集所有配置中的修改器UUID
        Set<UUID> modifierUUIDs = new HashSet<>();
        for (EnchantmentComboConfig config : getEnchantmentCombinationConfigs()) {
            if (config.attributeBonus() != null) {
                modifierUUIDs.add(config.attributeBonus().uuid());
            }
        }

        // 从所有相关属性中移除修改器
        for (UUID uuid : modifierUUIDs) {
            for (Attribute attribute : getAllConfiguredAttributes()) {
                AttributeInstance attributeInstance = player.getAttribute(attribute);
                if (attributeInstance != null) {
                    AttributeModifier modifier = attributeInstance.getModifier(uuid);
                    if (modifier != null) {
                        attributeInstance.removeModifier(modifier);
                    }
                }
            }
        }
    }

    /**
     * 获取所有配置的属性类型
     *
     * @return 属性类型集合
     */
    private static Set<Attribute> getAllConfiguredAttributes() {
        Set<Attribute> attributes = new HashSet<>();
        for (EnchantmentComboConfig config : getEnchantmentCombinationConfigs()) {
            if (config.attributeBonus() != null) {
                attributes.add(config.attributeBonus().attribute());
            }
        }
        return attributes;
    }

    /**
     * 应用属性加成
     *
     * @param player 玩家
     * @param bonus 属性加成配置
     */
    private static void applyAttributeBonus(Player player, AttributeBonusConfig bonus) {
        AttributeInstance attributeInstance = player.getAttribute(bonus.attribute());
        if (attributeInstance == null) return;

        // 避免重复添加修改器
        AttributeModifier existingModifier = attributeInstance.getModifier(bonus.uuid());
        if (existingModifier == null) {
            AttributeModifier modifier = new AttributeModifier(
                    bonus.uuid(),
                    "TBZ Enchantment Combination Bonus",
                    bonus.value(),
                    bonus.operation()
            );
            attributeInstance.addPermanentModifier(modifier);
        }
    }

    /**
     * 获取匹配的附魔组合的tooltip键列表
     *
     * @param stack 物品堆
     * @return 匹配的tooltip键列表
     */
    private static List<String> getMatchingCombinationTooltipKeys(ItemStack stack) {
        List<String> tooltipKeys = new ArrayList<>();

        if (stack.isEmpty()) return tooltipKeys;

        // 仅对拥有随机Perk标记的武器生效
        if (!hasRandomPerkTag(stack)) {
            return tooltipKeys;
        }

        var enchantments = EnchantmentHelper.getEnchantments(stack);
        Random random = new Random();

        for (EnchantmentComboConfig config : getEnchantmentCombinationConfigs()) {
            if (hasRequiredEnchantments(enchantments, config)) {
                // 从tooltipKeys列表中随机选择一个
                if (!config.tooltipKeys().isEmpty()) {
                    String randomTooltipKey = config.tooltipKeys().get(random.nextInt(config.tooltipKeys().size()));
                    tooltipKeys.add(randomTooltipKey);
                }
            }
        }

        return tooltipKeys;
    }

    /**
     * 检测物品是否拥有任何有效的附魔组合
     *
     * @param stack 物品堆
     * @return 是否拥有任何有效的附魔组合
     */
    private static boolean hasAnyValidCombination(ItemStack stack) {
        return !getMatchingCombinationTooltipKeys(stack).isEmpty();
    }

    /**
     * 检测物品是否拥有指定配置所需的附魔数量
     *
     * @param enchantments 物品的附魔集合
     * @param config 附魔组合配置
     * @return 是否满足要求
     */
    private static boolean hasRequiredEnchantments(Map<Enchantment, Integer> enchantments, EnchantmentComboConfig config) {
        int count = 0;
        for (RegistryObject<? extends Enchantment> enchantmentRO : config.enchantments) {
            if (enchantmentRO.isPresent() && enchantments.containsKey(enchantmentRO.get())) {
                count++;
                if (count >= config.minRequired) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检测物品是否拥有随机附魔标签
     *
     * @param stack 物品堆
     * @return 是否拥有随机附魔标签
     */
    private static boolean hasRandomPerkTag(ItemStack stack) {
        if (stack.isEmpty()) return false;
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(MarsSmithingTableBlockEntity.RANDOM_PERK_TRUE_TAG);
    }
}