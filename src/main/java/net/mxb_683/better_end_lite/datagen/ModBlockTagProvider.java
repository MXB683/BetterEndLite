package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
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
				.add(ModBlocks.ENDERIUM_SPIKES.get());

		tag(BlockTags.NEEDS_DIAMOND_TOOL)
				.add(ModBlocks.ENDERIUM_ORE.get())
				.add(ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.add(ModBlocks.ENDERIUM_SPIKES.get());
	}
}
