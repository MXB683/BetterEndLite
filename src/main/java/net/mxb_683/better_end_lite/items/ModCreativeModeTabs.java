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
						//output.accept(ModItems.ANCIENT_RELIC.get());

						output.accept(ModBlocks.ENDERIUM_ORE.get());
						output.accept(ModBlocks.ENDERIUM_CLUMP_BLOCK.get());
						output.accept(ModBlocks.ENDERIUM_SPIKES.get());
					})
					.build());

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
