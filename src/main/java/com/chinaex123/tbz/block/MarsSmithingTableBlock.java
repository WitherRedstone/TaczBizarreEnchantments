package com.chinaex123.tbz.block;

import com.chinaex123.tbz.block.blockentity.MarsSmithingTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * 火星锻造台方块
 * <p>
 * 功能：为枪械随机附加附魔的交互方块
 * <p>
 * 特性：
 * <ol>
 *   <li>可水平旋转方向（朝向玩家放置时的相反方向）</li>
 *   <li>右键打开锻造台GUI，用于枪械附魔操作</li>
 *   <li>绑定火星锻造台方块实体，处理物品槽位和附魔逻辑</li>
 * </ol>
 */
public class MarsSmithingTableBlock extends HorizontalDirectionalBlock implements EntityBlock {

    /** 方块朝向属性 */
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    /**
     * 构造火星锻造台方块
     * 设置默认朝向为北方
     *
     * @param properties 方块属性（硬度、抗爆性等）
     */
    public MarsSmithingTableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    /**
     * 注册方块状态属性
     * 将朝向属性添加到方块状态定义中
     *
     * @param builder 方块状态定义构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * 获取方块放置时的状态
     * 根据玩家的水平方向设置方块的朝向（朝玩家方向的相反方向）
     *
     * @param context 方块放置上下文
     * @return 配置好朝向的方块状态
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    /**
     * 方块右键交互事件处理
     * 服务端打开锻造台GUI，客户端直接返回成功
     *
     * @param state 方块状态
     * @param level 世界
     * @param pos   方块位置
     * @param player 操作玩家
     * @param hand  交互手部
     * @param hit   点击结果
     * @return 交互结果
     */
    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MarsSmithingTableBlockEntity) {
            NetworkHooks.openScreen((ServerPlayer) player, (MarsSmithingTableBlockEntity) blockEntity, buf -> buf.writeBlockPos(pos));
        }
        return InteractionResult.CONSUME;
    }

    /**
     * 创建方块实体
     * 绑定火星锻造台方块实体，用于管理物品槽位和附魔逻辑
     *
     * @param pos   方块位置
     * @param state 方块状态
     * @return 火星锻造台方块实体实例
     */
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MarsSmithingTableBlockEntity(pos, state);
    }
}