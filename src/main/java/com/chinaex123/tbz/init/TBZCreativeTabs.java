package com.chinaex123.tbz.init;

import com.chinaex123.tbz.TBZMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TBZCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TBZMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TBZ_TAB =
            CREATIVE_MODE_TAB.register("tbz_tab", () -> CreativeModeTab.builder()
                    .icon(() -> createEnchantedBookStack(TBZEnchantments.BORPAL_WEAPON.get(), 1))
                    .title(Component.translatable("itemGroup.tbz"))
                    .displayItems((parameters, output) -> {
                        // ==================== [异域]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.PROTECTIVE_WEAVE.get());

                        // ==================== [增伤]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.BORPAL_WEAPON.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.PRECISION_INSTRUMENT.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.TARGET_LOCK.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.GUTSHOT_STRAIGHT.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.THERMAL_ATOMIZATION.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.COOLING_BAUBLES.get());

                        // ==================== [回子弹]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.SUBSISTENCE.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.AMBITIOUS_ASSASSIN.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.RECONSTRUCTION.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.TRIPLE_TAP.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.FOURTH_TIME_THE_CHARM.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.REWIND_ROUNDS.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.MULLIGAN.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.TRICKLE_CHARGE.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.SUPERCHARGED_MAGAZINE.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.REVERSAL_OF_FORTUNE.get());

                        // ==================== [应用效果]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.HEAL_CLIP.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.ROLLING_STORM.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.DESTABILIZING_ROUNDS.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.INCANDESCENT.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.CHILL_CLIP.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.RIMESTEALER.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.SLICE.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.WITHERING_GAZE.get());

                        // ==================== [爆炸]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.BUTTERFLY.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.EXPLOSIVE_PAYLOAD.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.FIREFLY.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.DRAGONFLY.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.MEGANEURA.get());

                        // ==================== [配件数值]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.SNAPSHOT_SIGHTS.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.FIRMLY_PLANTED.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.ADAGIO.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.ONSLAUGHT.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.EYE_OF_STORM_EYE.get());

                        // ==================== [持续伤害]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.ATTRITION_ORBS.get());

                        // ==================== [填装]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.OUTLAW.get());

                        // ==================== [其他]类型附魔 ====================
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.WELLSPRING.get());
                        addAllLevelEnchantmentBooks(output, TBZEnchantments.SHOOT_TP_LOOT.get());
                    })
                    .build());

    /**
     * 创建指定等级的附魔书物品栈
     */
    private static ItemStack createEnchantedBookStack(Enchantment enchantment, int level) {
        return EnchantedBookItem.createForEnchantment(
                new EnchantmentInstance(enchantment, level)
        );
    }

    /** 向创造模式物品栏添加所有等级的附魔书 **/
    private static void addAllLevelEnchantmentBooks(CreativeModeTab.Output output, Enchantment enchantment) {
        for (int level = 1; level <= enchantment.getMaxLevel(); level++) {
            output.accept(createEnchantedBookStack(enchantment, level));
        }
    }
}