package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
	public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
														 @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, BetterEndLiteMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(ModBlocks.ENDERIUM_ORE.get())
				.add(ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.add(ModBlocks.ENDERIUM_SPIKES.get())
				.add(ModBlocks.ENDERIUM_BRICKS.get())
				.add(ModBlocks.CHISELED_ENDERIUM_BRICKS.get())
				.add(ModBlocks.ENDERIUM_BRICK_WALL.get())
				.add(ModBlocks.ENDERIUM_BRICK_SLAB.get())
				.add(ModBlocks.ENDERIUM_BRICK_STAIRS.get());

		tag(BlockTags.NEEDS_DIAMOND_TOOL)
				.add(ModBlocks.ENDERIUM_ORE.get())
				.add(ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.add(ModBlocks.ENDERIUM_SPIKES.get())
				.add(ModBlocks.ENDERIUM_BRICKS.get())
				.add(ModBlocks.CHISELED_ENDERIUM_BRICKS.get())
				.add(ModBlocks.ENDERIUM_BRICK_WALL.get())
				.add(ModBlocks.ENDERIUM_BRICK_SLAB.get())
				.add(ModBlocks.ENDERIUM_BRICK_STAIRS.get());

		tag(BlockTags.WALLS).add(ModBlocks.ENDERIUM_BRICK_WALL.get());
		tag(BlockTags.FENCES).add(ModBlocks.CHORUS_FENCE.get());
		tag(BlockTags.FENCE_GATES).add(ModBlocks.CHORUS_FENCE_GATE.get());

		tag(ModTags.Blocks.END_ORE_REPLACEABLES).add(Blocks.END_STONE);

		tag(BlockTags.LOGS_THAT_BURN)
				.add(ModBlocks.CHORUS_LOG.get())
				.add(ModBlocks.CHORUS_WOOD.get())
				.add(ModBlocks.STRIPPED_CHORUS_LOG.get())
				.add(ModBlocks.STRIPPED_CHORUS_WOOD.get());
	}
}
