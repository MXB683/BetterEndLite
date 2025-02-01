package net.mxb_683.better_end_lite.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, BetterEndLiteMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		basicItem(ModItems.ENDERIUM_CLUMP.get());
		basicItem(ModItems.ENDERIUM_SHARD.get());
		basicItem(ModItems.ENDERIUM_BRICK.get());

		wallItem(ModBlocks.ENDERIUM_BRICK_WALL, ModBlocks.ENDERIUM_BRICKS);
		fenceItem(ModBlocks.CHORUS_FENCE, ModBlocks.CHORUS_PLANKS);
		buttonItem(ModBlocks.CHORUS_BUTTON, ModBlocks.CHORUS_PLANKS);
		simpleBlockItem(ModBlocks.CHORUS_DOOR);

		saplingItem(ModBlocks.CHORUS_SAPLING);

		handheldItem(ModItems.ENDERIUM_SWORD);
		handheldItem(ModItems.ENDERIUM_PICKAXE);
		handheldItem(ModItems.ENDERIUM_SHOVEL);
		handheldItem(ModItems.ENDERIUM_AXE);
		handheldItem(ModItems.ENDERIUM_HOE);
	}

	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/handheld")).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, "block/" + item.getId().getPath()));
	}

	public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
				.texture("texture", ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
				.texture("texture", ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
				.texture("wall", ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, "item/" + item.getId().getPath()));
	}
}
