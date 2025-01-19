package net.mxb_683.better_end_lite.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, BetterEndLiteMod.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithItem(ModBlocks.ENDERIUM_ORE);
		blockWithItem(ModBlocks.ENDERIUM_CLUMP_BLOCK);
		blockWithItem(ModBlocks.ENDERIUM_BRICKS);
		blockWithItem(ModBlocks.CHISELED_ENDERIUM_BRICKS);

		logBlock(ModBlocks.CHORUS_LOG.get());
		logBlock(ModBlocks.STRIPPED_CHORUS_LOG.get());

		axisBlock(ModBlocks.CHORUS_WOOD.get(), blockTexture(ModBlocks.CHORUS_LOG.get()),
				blockTexture(ModBlocks.CHORUS_LOG.get()));
		axisBlock(ModBlocks.STRIPPED_CHORUS_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CHORUS_LOG.get()),
				blockTexture(ModBlocks.STRIPPED_CHORUS_LOG.get()));

		blockItem(ModBlocks.CHORUS_LOG);
		blockItem(ModBlocks.CHORUS_WOOD);
		blockItem(ModBlocks.STRIPPED_CHORUS_LOG);
		blockItem(ModBlocks.STRIPPED_CHORUS_WOOD);

		blockWithItem(ModBlocks.CHORUS_PLANKS);

		saplingBlock(ModBlocks.CHORUS_SAPLING);
		leavesBlock(ModBlocks.CHORUS_LEAVES);

		stairsBlock(ModBlocks.ENDERIUM_BRICK_STAIRS.get(), blockTexture(ModBlocks.ENDERIUM_BRICKS.get()));
		blockItem(ModBlocks.ENDERIUM_BRICK_STAIRS);

		slabBlock(ModBlocks.ENDERIUM_BRICK_SLAB.get(), blockTexture(ModBlocks.ENDERIUM_BRICKS.get()),
				blockTexture(ModBlocks.ENDERIUM_BRICKS.get()));
		blockItem(ModBlocks.ENDERIUM_BRICK_SLAB);

		wallBlock(ModBlocks.ENDERIUM_BRICK_WALL.get(), blockTexture(ModBlocks.ENDERIUM_BRICKS.get()));

		stairsBlock(ModBlocks.CHORUS_STAIRS.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		slabBlock(ModBlocks.CHORUS_SLAB.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()),
				blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		fenceBlock(ModBlocks.CHORUS_FENCE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		fenceGateBlock(ModBlocks.CHORUS_FENCE_GATE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		buttonBlock(ModBlocks.CHORUS_BUTTON.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		pressurePlateBlock(ModBlocks.CHORUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
		trapdoorBlockWithRenderType(ModBlocks.CHORUS_TRAPDOOR.get(), modLoc("block/chorus_trapdoor"), true, "cutout");
		doorBlockWithRenderType(ModBlocks.CHORUS_DOOR.get(), modLoc("block/chorus_door_bottom"),
				modLoc("block/chorus_door_top"), "cutout");

		blockItem(ModBlocks.CHORUS_STAIRS);
		blockItem(ModBlocks.CHORUS_SLAB);
		blockItem(ModBlocks.CHORUS_FENCE_GATE);
		blockItem(ModBlocks.CHORUS_PRESSURE_PLATE);
		blockItem(ModBlocks.CHORUS_TRAPDOOR, "_bottom");
	}

	private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
		simpleBlock(blockRegistryObject.get(),
				models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
	}

	private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(),
				models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
						"all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
	}

	private void blockWithItem(RegistryObject<? extends Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}

	private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
		simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(BetterEndLiteMod.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
	}

	private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
		simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(BetterEndLiteMod.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
	}
}
