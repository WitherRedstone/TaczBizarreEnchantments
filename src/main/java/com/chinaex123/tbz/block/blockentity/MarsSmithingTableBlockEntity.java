package com.chinaex123.tbz.block.blockentity;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZBlockEntities;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.init.TBZItemTags;
import com.chinaex123.tbz.menu.MarsSmithingTableMenu;
import com.chinaex123.tbz.utils.EnchantmentTypeUtils;
import com.tacz.guns.api.item.IGun;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * 火星锻造台方块实体
 * <p>
 * 功能：为枪械随机附加附魔
 * <p>
 * 机制：
 * <ol>
 *   <li>武器槽：放入枪械</li>
 *   <li>材料槽：放入随机Perk材料或刷新Perk材料</li>
 *   <li>输出槽：生成附魔后的枪械</li>
 *   <li>随机Perk材料：为枪械随机添加附魔</li>
 *   <li>刷新Perk材料：清除所有附魔并重置</li>
 * </ol>
 */
public class MarsSmithingTableBlockEntity extends BlockEntity implements MenuProvider {

    /** 武器槽 */
    private static final int WEAPON_SLOT = 0;
    /** 材料槽 */
    private static final int MATERIAL_SLOT = 1;
    /** 输出槽 */
    private static final int OUTPUT_SLOT = 2;
    /** 槽位总数 */
    private static final int SLOT_COUNT = 3;

    /** NBT键名：是否拥有随机Perk */
    public static final String RANDOM_PERK_TRUE_TAG = "tbz:random_perk_true";
    /** NBT键名：随机Perk次数 */
    public static final String RANDOM_PERK_COUNT_TAG = "tbz:random_perk_count";

    private final ItemStackHandler itemHandler = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                /* 武器槽只接受枪械 */
                case WEAPON_SLOT -> IGun.getIGunOrNull(stack) != null;
                /* 材料槽只接受随机Perk材料或刷新Perk材料 */
                case MATERIAL_SLOT -> stack.is(TBZItemTags.RANDOM_PERK_MATERIAL)   // 随机Perk材料
                        || stack.is(TBZItemTags.REFRESH_PERK_MATERIAL);    // 刷新Perk材料
                default -> false;
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Random random = new Random();

    public MarsSmithingTableBlockEntity(BlockPos pos, BlockState state) {
        super(TBZBlockEntities.MARS_SMITHING_TABLE.get(), pos, state);
    }

    /**
     * 获取方块的显示名称
     * 使用本地化键名进行翻译，支持多语言环境（如中文、英文等）
     *
     * @return 包含本地化翻译文本的组件，内容对应语言文件中 "block.tbz.mars_smithing_table" 的翻译值，保证不为 null
     */
    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.tbz.mars_smithing_table");
    }

    /**
     * 创建锻造台的功能菜单
     * 将玩家背包和方块实体数据传入菜单容器，用于合成交互界面的逻辑处理
     *
     * @param id              菜单窗口的唯一标识ID
     * @param playerInventory 玩家的背包物品栏
     * @param player          操作该方块的玩家对象
     * @return 火星锻造台的菜单容器实例，若创建失败可能返回 null
     */
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new MarsSmithingTableMenu(id, playerInventory, this);
    }

    /**
     * 获取方块实体的能力
     * 返回物品栏处理器，用于外部系统（如管道、漏斗）与方块进行物品交互
     *
     * @param cap 请求的能力类型
     * @param side 请求的方向，可为 null
     * @return 物品栏能力的惰性包装器，若请求的能力不是物品栏则返回父类结果
     */
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    /**
     * 方块实体加载完成时的回调
     * 初始化物品栏能力的惰性包装器，确保外部系统能够正确访问物品栏
     */
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    /**
     * 方块实体的能力失效时的回调
     * 使物品栏能力的惰性包装器失效，防止内存泄漏
     */
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    /**
     * 保存额外的数据到NBT标签
     * 将物品栏数据序列化并存储，用于方块实体的持久化存档
     *
     * @param tag 要写入的NBT标签
     */
    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("Inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    /**
     * 从NBT标签加载数据
     * 反序列化并恢复物品栏数据，用于方块实体的持久化还原
     *
     * @param tag 包含存档数据的NBT标签
     */
    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("Inventory"));
    }

    /**
     * 获取物品栏处理器
     *
     * @return 当前方块实体的物品栏处理器实例
     */
    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    /**
     * 按钮按下事件处理
     * 根据材料类型执行随机Perk或刷新Perk操作
     *
     * @param player 操作玩家
     */
    public void onButtonPress(Player player) {
        if (level == null || level.isClientSide) return;

        ItemStack weapon = itemHandler.getStackInSlot(WEAPON_SLOT);
        ItemStack material = itemHandler.getStackInSlot(MATERIAL_SLOT);

        if (weapon.isEmpty() || material.isEmpty()) return;

        // 检查材料类型
        boolean isRandomMaterial = material.is(TBZItemTags.RANDOM_PERK_MATERIAL);
        boolean isRefreshMaterial = material.is(TBZItemTags.REFRESH_PERK_MATERIAL);

        if (!isRandomMaterial && !isRefreshMaterial) return;

        // 获取材料消耗数量
        int materialCost = isRandomMaterial ? 
            TBZServerConfig.MARS_SMITHING_RANDOM_PERK_MATERIAL_COST.get() :
            TBZServerConfig.MARS_SMITHING_REFRESH_PERK_MATERIAL_COST.get();

        // 检查材料数量是否足够
        if (material.getCount() < materialCost) return;

        boolean success = false;

        // 执行对应操作
        if (isRandomMaterial) {
            success = applyRandomPerk(weapon, player);
        } else {
            success = refreshPerk(weapon, player);
        }

        // 成功则消耗材料
        if (success) {
            material.shrink(materialCost);
            setChanged();
        }
    }

    /**
     * 应用随机Perk
     * 为枪械随机添加附魔
     *
     * @param weapon 武器物品
     * @param player 玩家
     * @return 是否成功
     */
    private boolean applyRandomPerk(ItemStack weapon, Player player) {
        CompoundTag tag = weapon.getOrCreateTag();

        // 检查最大随机Perk次数限制
        int maxRandomPerks = TBZServerConfig.MARS_SMITHING_MAX_RANDOM_PERKS.get();
        if (maxRandomPerks == 0) return false;

        int currentRandomPerkCount = tag.getInt(RANDOM_PERK_COUNT_TAG);
        if (maxRandomPerks > 0 && currentRandomPerkCount >= maxRandomPerks) return false;

        boolean hasRandomPerk = tag.getBoolean(RANDOM_PERK_TRUE_TAG);

        // 如果已有随机Perk，先清除旧附魔
        if (hasRandomPerk) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(weapon);
            enchantments.clear();
            weapon.removeTagKey("Enchantments");
        }

        // 获取可用的附魔列表
        List<Enchantment> availableEnchantments = TBZEnchantments.ENCHANTMENTS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(enchantment -> canApplyEnchantment(weapon, enchantment))
                .toList();

        if (availableEnchantments.isEmpty()) return false;

        // 应用附魔
        int maxEnchantments = TBZServerConfig.MAX_ENCHANTMENTS_PER_GUN.get();
        Set<Enchantment> appliedEnchantments = new HashSet<>();

        for (int i = 0; i < maxEnchantments; i++) {
            if (appliedEnchantments.size() >= maxEnchantments) break;

            // 过滤剩余可用的附魔
            List<Enchantment> remainingEnchantments = availableEnchantments.stream()
                    .filter(e -> !appliedEnchantments.contains(e))
                    .filter(e -> !hasConflictWithEnchantment(e, appliedEnchantments))
                    .toList();

            if (remainingEnchantments.isEmpty()) break;

            // 按稀有度权重选择附魔
            Enchantment randomEnchantment = selectEnchantmentByRarity(remainingEnchantments);
            if (randomEnchantment == null) continue;

            // 检查异域附魔数量限制
            Set<Enchantment> testEnchantments = new HashSet<>(appliedEnchantments);
            testEnchantments.add(randomEnchantment);
            if (EnchantmentTypeUtils.countExoticEnchantments(testEnchantments) > TBZServerConfig.MAX_EXOTIC_ENCHANTMENTS.get()) {
                continue;
            }

            // 应用附魔
            int level = random.nextInt(randomEnchantment.getMaxLevel()) + 1;
            weapon.enchant(randomEnchantment, level);
            appliedEnchantments.add(randomEnchantment);
        }

        // 标记随机Perk状态
        tag.putBoolean(RANDOM_PERK_TRUE_TAG, true);
        tag.putInt(RANDOM_PERK_COUNT_TAG, currentRandomPerkCount + 1);

        // 移动到输出槽
        moveWeaponToOutput();
        return true;
    }

    /**
     * 按稀有度权重选择附魔
     *
     * @param enchantments 可用附魔列表
     * @return 选中的附魔
     */
    private Enchantment selectEnchantmentByRarity(List<Enchantment> enchantments) {
        if (enchantments.isEmpty()) return null;

        // 读取各稀有度的权重配置
        double commonChance = TBZServerConfig.MARS_SMITHING_COMMON_RARITY_CHANCE.get();
        double uncommonChance = TBZServerConfig.MARS_SMITHING_UNCOMMON_RARITY_CHANCE.get();
        double rareChance = TBZServerConfig.MARS_SMITHING_RARE_RARITY_CHANCE.get();
        double veryRareChance = TBZServerConfig.MARS_SMITHING_VERY_RARE_RARITY_CHANCE.get();

        double totalChance = commonChance + uncommonChance + rareChance + veryRareChance;

        // 如果总权重为0，随机选择一个
        if (totalChance <= 0) {
            return enchantments.get(random.nextInt(enchantments.size()));
        }

        // 按权重随机选择稀有度
        double roll = random.nextDouble() * totalChance;
        Enchantment.Rarity selectedRarity;

        if (roll < commonChance) {
            selectedRarity = Enchantment.Rarity.COMMON;
        } else if (roll < commonChance + uncommonChance) {
            selectedRarity = Enchantment.Rarity.UNCOMMON;
        } else if (roll < commonChance + uncommonChance + rareChance) {
            selectedRarity = Enchantment.Rarity.RARE;
        } else {
            selectedRarity = Enchantment.Rarity.VERY_RARE;
        }

        // 获取选中稀有度的附魔列表
        List<Enchantment> rarityEnchantments = enchantments.stream()
                .filter(e -> e.getRarity() == selectedRarity)
                .toList();

        if (rarityEnchantments.isEmpty()) {
            return enchantments.get(random.nextInt(enchantments.size()));
        }

        return rarityEnchantments.get(random.nextInt(rarityEnchantments.size()));
    }

    /**
     * 刷新Perk
     * 清除所有附魔并重置随机Perk状态
     *
     * @param weapon 武器物品
     * @param player 玩家
     * @return 是否成功
     */
    private boolean refreshPerk(ItemStack weapon, Player player) {
        CompoundTag tag = weapon.getOrCreateTag();

        // 检查是否有随机Perk
        if (!tag.getBoolean(RANDOM_PERK_TRUE_TAG)) return false;

        // 清除所有附魔
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(weapon);
        enchantments.clear();
        weapon.removeTagKey("Enchantments");

        // 移除随机Perk标记
        tag.remove(RANDOM_PERK_TRUE_TAG);
        tag.remove(RANDOM_PERK_COUNT_TAG);

        // 移动到输出槽
        moveWeaponToOutput();
        return true;
    }

    /**
     * 检查附魔是否与已有附魔冲突
     *
     * @param enchantment 要检查的附魔
     * @param otherEnchantments 已有附魔集合
     * @return true表示有冲突
     */
    private boolean hasConflictWithEnchantment(Enchantment enchantment, Set<Enchantment> otherEnchantments) {
        if (enchantment == null || otherEnchantments == null || otherEnchantments.isEmpty()) {
            return false;
        }

        for (Enchantment other : otherEnchantments) {
            if (other == null) continue;

            // 检查两个附魔是否兼容
            if (enchantment.isCompatibleWith(other) && other.isCompatibleWith(enchantment)) {
                continue;
            }

            return true;
        }

        return false;
    }

    /**
     * 检查附魔是否可以应用到武器上
     *
     * @param weapon 武器物品
     * @param enchantment 附魔
     * @return true表示可以应用
     */
    private boolean canApplyEnchantment(ItemStack weapon, Enchantment enchantment) {
        return enchantment.canEnchant(weapon) && enchantment.isDiscoverable();
    }

    /**
     * 将武器移动到输出槽
     */
    private void moveWeaponToOutput() {
        ItemStack weapon = itemHandler.getStackInSlot(WEAPON_SLOT).copy();
        itemHandler.setStackInSlot(WEAPON_SLOT, ItemStack.EMPTY);
        itemHandler.setStackInSlot(OUTPUT_SLOT, weapon);
    }
}