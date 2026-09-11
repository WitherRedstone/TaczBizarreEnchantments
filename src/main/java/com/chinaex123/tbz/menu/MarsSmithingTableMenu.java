package com.chinaex123.tbz.menu;

import com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity;
import com.chinaex123.tbz.init.TBZItemTags;
import com.chinaex123.tbz.init.TBZMenuTypes;
import com.tacz.guns.api.item.IGun;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

/**
 * 火星锻造台菜单容器
 * <p>
 * 功能：管理锻造台GUI的槽位布局和物品交互逻辑
 * <p>
 * 槽位布局：
 * <ol>
 *   <li>槽位 0：武器槽（44, 22）- 放入枪械</li>
 *   <li>槽位 1：材料槽（44, 48）- 放入随机Perk材料或刷新Perk材料</li>
 *   <li>槽位 2：输出槽（116, 35）- 生成附魔后的枪械，不可手动放入</li>
 * </ol>
 */
public class MarsSmithingTableMenu extends AbstractContainerMenu {

    /** 方块实体引用 */
    private final MarsSmithingTableBlockEntity blockEntity;
    /** 玩家背包物品栏处理器 */
    private final IItemHandler playerInventory;
    /** 容器世界访问器 */
    private final ContainerLevelAccess access;

    /**
     * 构造锻造台菜单
     * 初始化菜单容器，并布局方块槽位和玩家背包槽位
     *
     * @param id              菜单窗口的唯一标识ID
     * @param playerInventory 玩家的背包物品栏
     * @param blockEntity     火星锻造台方块实体
     */
    public MarsSmithingTableMenu(int id, Inventory playerInventory, MarsSmithingTableBlockEntity blockEntity) {
        super(TBZMenuTypes.MARS_SMITHING_TABLE.get(), id);
        this.blockEntity = blockEntity;
        this.playerInventory = new InvWrapper(playerInventory);
        this.access = blockEntity.getLevel() != null ? 
            ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()) :
            ContainerLevelAccess.NULL;

        layoutBlockEntitySlots();
        layoutPlayerInventorySlots(8, 84);
    }

    /**
     * 构造锻造台菜单（网络数据包版本）
     * 从网络数据包中读取方块位置并获取对应的方块实体
     *
     * @param id              菜单窗口的唯一标识ID
     * @param playerInventory 玩家的背包物品栏
     * @param data            网络数据包，包含方块位置信息
     */
    public MarsSmithingTableMenu(int id, Inventory playerInventory, FriendlyByteBuf data) {
        this(id, playerInventory, getBlockEntity(playerInventory, data));
    }

    /**
     * 从网络数据包获取方块实体
     * 读取方块位置并验证该位置的方块实体类型是否正确
     *
     * @param playerInventory 玩家的背包物品栏
     * @param data            网络数据包
     * @return 火星锻造台方块实体
     * @throws IllegalStateException 如果方块实体类型不匹配
     */
    private static MarsSmithingTableBlockEntity getBlockEntity(Inventory playerInventory, FriendlyByteBuf data) {
        BlockPos pos = data.readBlockPos();
        Level level = playerInventory.player.level();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MarsSmithingTableBlockEntity) {
            return (MarsSmithingTableBlockEntity) blockEntity;
        }
        throw new IllegalStateException("Block entity is not correct type at " + pos);
    }

    /**
     * 布局方块实体的物品槽位
     * 添加武器槽、材料槽和输出槽
     */
    private void layoutBlockEntitySlots() {
        IItemHandler handler = blockEntity.getItemHandler();

        // 武器槽：用于放入枪械
        addSlot(new SlotItemHandler(handler, 0, 44, 22));
        // 材料槽：用于放入随机Perk材料或刷新Perk材料
        addSlot(new SlotItemHandler(handler, 1, 44, 48));
        // 输出槽：只用于取出，不可手动放入物品
        addSlot(new SlotItemHandler(handler, 2, 116, 35) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }
        });
    }

    /**
     * 布局玩家背包槽位
     * 包括主背包（3行 × 9列）和快捷栏（1行 × 9列）
     *
     * @param leftCol 起始列X坐标
     * @param topRow  起始行Y坐标
     */
    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // 主背包槽位（行 0-2，列 0-8）
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new SlotItemHandler(playerInventory, col + row * 9 + 9, leftCol + col * 18, topRow + row * 18));
            }
        }

        // 快捷栏槽位（行 3，列 0-8）
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new SlotItemHandler(playerInventory, col, leftCol + col * 18, topRow + 58));
        }
    }

    /**
     * 快速移动物品（Shift + 点击）
     * 根据物品类型自动分配到对应的槽位：
     * <ul>
     *   <li>枪械 → 武器槽（槽位 0）</li>
     *   <li>随机Perk材料或刷新Perk材料 → 材料槽（槽位 1）</li>
     *   <li>输出槽 → 玩家背包</li>
     *   <li>其他物品 → 无法移动</li>
     * </ul>
     *
     * @param player 操作玩家
     * @param index  被操作的槽位索引
     * @return 移动后剩余的物品栈，若无剩余则为空物品栈
     */
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (!slot.hasItem()) {
            return itemstack;
        }

        ItemStack original = slot.getItem();
        itemstack = original.copy();

        if (index < 3) {
            // 从GUI槽位（武器槽、材料槽、输出槽）移动到玩家背包
            if (!this.moveItemStackTo(original, 3, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else {
            // 从玩家背包移动到GUI
            IItemHandler handler = blockEntity.getItemHandler();
            boolean moved = false;

            // 根据物品类型选择目标槽位
            if (IGun.getIGunOrNull(original) != null) {
                // 是枪械，尝试放入武器槽（槽位 0）
                if (handler.getStackInSlot(0).isEmpty()) {
                    ItemStack toInsert = original.copy();
                    ItemStack remaining = handler.insertItem(0, toInsert, false);

                    if (remaining.isEmpty() || remaining.getCount() < toInsert.getCount()) {
                        original.setCount(remaining.getCount());
                        moved = true;
                    }
                }
            } else if (original.is(TBZItemTags.RANDOM_PERK_MATERIAL) || original.is(TBZItemTags.REFRESH_PERK_MATERIAL)) {
                // 是材料，尝试放入材料槽（槽位 1）
                if (handler.getStackInSlot(1).isEmpty()) {
                    ItemStack toInsert = original.copy();
                    ItemStack remaining = handler.insertItem(1, toInsert, false);

                    if (remaining.isEmpty() || remaining.getCount() < toInsert.getCount()) {
                        original.setCount(remaining.getCount());
                        moved = true;
                    }
                }
            } else {
                // 不支持的物品类型，无法移动
                return ItemStack.EMPTY;
            }

            if (!moved) {
                return ItemStack.EMPTY;
            }

            // 触发方块实体更新
            blockEntity.setChanged();
            if (blockEntity.getLevel() != null) {
                blockEntity.getLevel().sendBlockUpdated(
                        blockEntity.getBlockPos(),
                        blockEntity.getBlockState(),
                        blockEntity.getBlockState(),
                        3
                );
            }
        }

        // 更新槽位状态
        if (original.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        // 广播变化到客户端
        this.broadcastChanges();

        return itemstack;
    }

    /**
     * 检查玩家是否能继续使用该菜单
     * 验证玩家是否在方块的可交互范围内
     *
     * @param player 操作玩家
     * @return true表示玩家仍可使用该菜单
     */
    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.access, player, blockEntity.getBlockState().getBlock());
    }

    /**
     * 获取关联的方块实体
     *
     * @return 火星锻造台方块实体
     */
    public MarsSmithingTableBlockEntity getBlockEntity() {
        return blockEntity;
    }
}