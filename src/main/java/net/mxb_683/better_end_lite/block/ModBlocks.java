package net.mxb_683.better_end_lite.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.items.ModItems;

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
