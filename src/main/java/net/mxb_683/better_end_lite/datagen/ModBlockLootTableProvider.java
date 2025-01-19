package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
	protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
	}

	@Override
	protected void generate() {
		dropSelf(ModBlocks.ENDERIUM_CLUMP_BLOCK.get());
		dropSelf(ModBlocks.ENDERIUM_SPIKES.get());
		dropSelf(ModBlocks.ENDERIUM_BRICKS.get());
		dropSelf(ModBlocks.CHISELED_ENDERIUM_BRICKS.get());
		dropSelf(ModBlocks.ENDERIUM_BRICK_STAIRS.get());
		dropSelf(ModBlocks.ENDERIUM_BRICK_SLAB.get());
		dropSelf(ModBlocks.ENDERIUM_BRICK_WALL.get());
		dropSelf(ModBlocks.CHORUS_LOG.get());
		dropSelf(ModBlocks.CHORUS_WOOD.get());
		dropSelf(ModBlocks.STRIPPED_CHORUS_LOG.get());
		dropSelf(ModBlocks.STRIPPED_CHORUS_WOOD.get());
		dropSelf(ModBlocks.CHORUS_PLANKS.get());
		dropSelf(ModBlocks.CHORUS_SAPLING.get());
		dropSelf(ModBlocks.CHORUS_STAIRS.get());
		dropSelf(ModBlocks.CHORUS_FENCE.get());
		dropSelf(ModBlocks.CHORUS_FENCE_GATE.get());
		dropSelf(ModBlocks.CHORUS_BUTTON.get());
		dropSelf(ModBlocks.CHORUS_PRESSURE_PLATE.get());
		dropSelf(ModBlocks.CHORUS_TRAPDOOR.get());

		this.add(ModBlocks.CHORUS_SLAB.get(),
				block -> createSlabItemTable((ModBlocks.CHORUS_SLAB.get())));
		this.add(ModBlocks.CHORUS_DOOR.get(),
				block -> createDoorTable((ModBlocks.CHORUS_DOOR.get())));

		this.add(ModBlocks.CHORUS_LEAVES.get(), block ->
				createLeavesDrops(block, ModBlocks.CHORUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

		this.add(ModBlocks.ENDERIUM_BRICK_SLAB.get(),
				block -> createSlabItemTable((ModBlocks.ENDERIUM_BRICK_SLAB.get())));
		this.add(ModBlocks.ENDERIUM_ORE.get(),
				block -> createMultipleOreDrops(ModBlocks.ENDERIUM_ORE.get(), ModItems.ENDERIUM_CLUMP.get(), 2.0F, 4.0F));

	}

	protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
		HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		return this.createSilkTouchDispatchTable(
				pBlock, this.applyExplosionDecay(
						pBlock,
						LootItem.lootTableItem(item)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
								.apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
				)
		);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
