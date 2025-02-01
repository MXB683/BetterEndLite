package net.mxb_683.better_end_lite.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mxb_683.better_end_lite.BetterEndLiteMod;

public class ModTags {
	public static class Blocks {
		public static final TagKey<Block> END_ORE_REPLACEABLES = createTag("end_ore_replaceables");
		public static final TagKey<Block> NEEDS_ENDERIUM_TOOL = createTag("needs_enderium_tool");
		public static final TagKey<Block> INCORRECT_FOR_ENDERIUM_TOOL = createTag("incorrect_for_enderium_tool");
		public static final TagKey<Block> CHORUS_LOGS = createTag("chorus_logs");

		private static TagKey<Block> createTag(String name) {
			return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, name));
		}
	}

	public static class Items {
		public static final TagKey<Item> CHORUS_LOGS = createTag("chorus_logs");

		private static TagKey<Item> createTag(String name) {
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, name));
		}
	}
}
