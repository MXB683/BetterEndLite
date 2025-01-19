package net.mxb_683.better_end_lite.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class EnderiumSpikesBlock extends DirectionalBlock {
	public static final MapCodec<EnderiumSpikesBlock> CODEC = simpleCodec(EnderiumSpikesBlock::new);
	public static final IntegerProperty POWER = IntegerProperty.create("power", 0, 15);

	public EnderiumSpikesBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected MapCodec<? extends DirectionalBlock> codec() {
		return CODEC;
	}

	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getClickedFace()).setValue(POWER, 0);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
		pBuilder.add(POWER);
	}

	@Override
	protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (!pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity) {
			pEntity.hurt(pLevel.damageSources().cramming(), 4.0F);
			if (!pLevel.isClientSide()) {
				int power = (int) (14 - ((LivingEntity) pEntity).getHealth() / ((LivingEntity) pEntity).getMaxHealth() * 15);
				if (power < 0) power = 0;
				if (power > 15) power = 15;
				pLevel.setBlock(pPos, pState.setValue(POWER, power), 3);
				pLevel.scheduleTick(pPos, this, 10);
			}
		}

		super.entityInside(pState, pLevel, pPos, pEntity);
	}

	@Override
	protected boolean isSignalSource(BlockState pState) {
		return true;
	}

	@Override
	protected int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return pState.getValue(POWER);
	}

	@Override
	protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pState.getValue(POWER) > 0) {
			pLevel.setBlock(pPos, pState.setValue(POWER, 0), 3);
		}
	}
}
