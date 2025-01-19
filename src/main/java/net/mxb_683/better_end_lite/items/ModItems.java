package net.mxb_683.better_end_lite.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<Item> ENDERIUM_CLUMP = ITEMS.register("enderium_clump",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDERIUM_SHARD = ITEMS.register("enderium_shard",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDERIUM_BRICK = ITEMS.register("enderium_brick",
			() -> new Item(new Item.Properties()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
