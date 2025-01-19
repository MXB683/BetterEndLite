package net.mxb_683.better_end_lite.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;

public class ModCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BETTER_END_LITE_ITEMS_TAB = CREATIVE_MODE_TABS.register(
			"better_end_lite_items_tab", () -> CreativeModeTab.builder()
					.icon(() -> new ItemStack(ModItems.ENDERIUM_CLUMP.get()))
					.title(Component.translatable("creativetab.better_end_lite.better_end_lite_items_tab"))
					.displayItems((parameters, output) -> {
						output.accept(ModItems.ENDERIUM_CLUMP.get());
						output.accept(ModItems.ENDERIUM_SHARD.get());
						output.accept(ModItems.ENDERIUM_BRICK.get());
						output.accept(ModBlocks.ENDERIUM_ORE.get());
						output.accept(ModBlocks.ENDERIUM_CLUMP_BLOCK.get());
						output.accept(ModBlocks.ENDERIUM_SPIKES.get());
						output.accept(ModBlocks.ENDERIUM_BRICKS.get());
						output.accept(ModBlocks.CHISELED_ENDERIUM_BRICKS.get());
						output.accept(ModBlocks.ENDERIUM_BRICK_STAIRS.get());
						output.accept(ModBlocks.ENDERIUM_BRICK_SLAB.get());
						output.accept(ModBlocks.ENDERIUM_BRICK_WALL.get());
						output.accept(ModBlocks.CHORUS_LOG.get());
						output.accept(ModBlocks.CHORUS_WOOD.get());
						output.accept(ModBlocks.STRIPPED_CHORUS_LOG.get());
						output.accept(ModBlocks.STRIPPED_CHORUS_WOOD.get());
						output.accept(ModBlocks.CHORUS_PLANKS.get());
						output.accept(ModBlocks.CHORUS_LEAVES.get());
						output.accept(ModBlocks.CHORUS_SAPLING.get());
						output.accept(ModBlocks.CHORUS_STAIRS.get());
						output.accept(ModBlocks.CHORUS_SLAB.get());
						output.accept(ModBlocks.CHORUS_FENCE.get());
						output.accept(ModBlocks.CHORUS_FENCE_GATE.get());
						output.accept(ModBlocks.CHORUS_BUTTON.get());
						output.accept(ModBlocks.CHORUS_PRESSURE_PLATE.get());
						output.accept(ModBlocks.CHORUS_TRAPDOOR.get());
						output.accept(ModBlocks.CHORUS_DOOR.get());
					})
					.build());

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
