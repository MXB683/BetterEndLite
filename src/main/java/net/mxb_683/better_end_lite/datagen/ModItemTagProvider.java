package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;
import net.mxb_683.better_end_lite.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
	public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
														CompletableFuture<TagLookup<Block>> pBlockTags,
														@Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, pLookupProvider, pBlockTags, BetterEndLiteMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		tag(ItemTags.LOGS_THAT_BURN)
				.add(ModBlocks.CHORUS_LOG.get().asItem())
				.add(ModBlocks.CHORUS_WOOD.get().asItem())
				.add(ModBlocks.STRIPPED_CHORUS_LOG.get().asItem())
				.add(ModBlocks.STRIPPED_CHORUS_WOOD.get().asItem());

		tag(ItemTags.PLANKS).add(ModBlocks.CHORUS_PLANKS.get().asItem());

		tag(ItemTags.SWORDS).add(ModItems.ENDERIUM_SWORD.get());
		tag(ItemTags.PICKAXES).add(ModItems.ENDERIUM_PICKAXE.get());
		tag(ItemTags.SHOVELS).add(ModItems.ENDERIUM_SHOVEL.get());
		tag(ItemTags.AXES).add(ModItems.ENDERIUM_AXE.get());
		tag(ItemTags.HOES).add(ModItems.ENDERIUM_HOE.get());

		copy(ModTags.Blocks.CHORUS_LOGS, ModTags.Items.CHORUS_LOGS);
	}
}
