package net.mxb_683.better_end_lite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.custom.EnderiumSpikesBlock;
import net.mxb_683.better_end_lite.block.custom.ModFlammableRotatedPillarBlock;
import net.mxb_683.better_end_lite.items.ModItems;
import net.mxb_683.better_end_lite.worldgen.tree.ModTreeGrowers;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, BetterEndLiteMod.MOD_ID);


	public static final RegistryObject<Block> ENDERIUM_ORE = registerBlock("enderium_ore",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

	public static final RegistryObject<Block> ENDERIUM_CLUMP_BLOCK = registerBlock("enderium_clump_block",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(4.5F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

	public static final RegistryObject<Block> ENDERIUM_SPIKES = registerBlock("enderium_spikes",
			() -> new EnderiumSpikesBlock(BlockBehaviour.Properties.of()
					.strength(1.0f, 0.5f).requiresCorrectToolForDrops()
					.sound(SoundType.STONE).noCollission().noOcclusion().randomTicks()));


	// Enderium Brick Set
	public static final RegistryObject<Block> ENDERIUM_BRICKS = registerBlock("enderium_bricks",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<Block> CHISELED_ENDERIUM_BRICKS = registerBlock("chiseled_enderium_bricks",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<StairBlock> ENDERIUM_BRICK_STAIRS = registerBlock("enderium_brick_stairs",
			() -> new StairBlock(ModBlocks.ENDERIUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<SlabBlock> ENDERIUM_BRICK_SLAB = registerBlock("enderium_brick_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<WallBlock> ENDERIUM_BRICK_WALL = registerBlock("enderium_brick_wall",
			() -> new WallBlock(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_BRICKS)));

	// Chorus wood set
	public static final RegistryObject<RotatedPillarBlock> CHORUS_LOG = registerBlock("chorus_log",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistryObject<RotatedPillarBlock> CHORUS_WOOD = registerBlock("chorus_wood",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHORUS_WOOD = registerBlock("stripped_chorus_wood",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

	public static final RegistryObject<Block> CHORUS_PLANKS = registerBlock("chorus_planks",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
				@Override
				public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
					return 60;
				}

				@Override
				public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
					return 20;
				}
			});
	public static final RegistryObject<Block> CHORUS_LEAVES = registerBlock("chorus_leaves",
			() -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
				@Override
				public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
					return 120;
				}

				@Override
				public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
					return 50;
				}
			});

	public static final RegistryObject<Block> CHORUS_SAPLING = registerBlock("chorus_sapling",
			() -> new SaplingBlock(ModTreeGrowers.CHORUS,
					BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(state -> 14)) {
				@Override
				protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
					Block block = pLevel.getBlockState(pPos).getBlock();
					return block == Blocks.END_STONE;
				}


			});

	// Chorus wood misc blocks set
	public static final RegistryObject<StairBlock> CHORUS_STAIRS = registerBlock("chorus_stairs",
			() -> new StairBlock(ModBlocks.ENDERIUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD)));
	public static final RegistryObject<SlabBlock> CHORUS_SLAB = registerBlock("chorus_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD)));

	public static final RegistryObject<FenceBlock> CHORUS_FENCE = registerBlock("chorus_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD)));
	public static final RegistryObject<FenceGateBlock> CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
			() -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD)));

	public static final RegistryObject<TrapDoorBlock> CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor",
			() -> new TrapDoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD).noOcclusion()));
	public static final RegistryObject<DoorBlock> CHORUS_DOOR = registerBlock("chorus_door",
			() -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD).noOcclusion()));

	public static final RegistryObject<PressurePlateBlock> CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
			() -> new PressurePlateBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD).noCollission()));
	public static final RegistryObject<ButtonBlock> CHORUS_BUTTON = registerBlock("chorus_button",
			() -> new ButtonBlock(BlockSetType.ACACIA, 30, BlockBehaviour.Properties.of()
					.strength(3F, 5F).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_WOOD).noCollission()) {
				@Override
				public void press(BlockState pState, Level pLevel, BlockPos pPos, @Nullable Player pPlayer) {
					pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.TRUE), 3);
					pLevel.scheduleTick(pPos, this, new Random().nextInt(29) + 2);
					this.playSound(pPlayer, pLevel, pPos, true);
					pLevel.gameEvent(pPlayer, GameEvent.BLOCK_ACTIVATE, pPos);
				}
			});

	public static final RegistryObject<Block> ENDERIUM_ENCHANTER = registerBlock("enderium_enchanter",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(20F, 100F).requiresCorrectToolForDrops()
					.sound(SoundType.SMALL_AMETHYST_BUD).noOcclusion().noTerrainParticles().lightLevel(state -> 7)));


	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
