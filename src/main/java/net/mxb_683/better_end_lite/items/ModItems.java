package net.mxb_683.better_end_lite.items;

import net.minecraft.world.item.*;
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

	public static final RegistryObject<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
			() -> new SwordItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(SwordItem.createAttributes(ModToolTiers.ENDERIUM, 3, -2.4f))));
	public static final RegistryObject<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
			() -> new PickaxeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(PickaxeItem.createAttributes(ModToolTiers.ENDERIUM, 1, -2.8f))));
	public static final RegistryObject<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
			() -> new ShovelItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(ShovelItem.createAttributes(ModToolTiers.ENDERIUM, 1.5f, -3.0f))));
	public static final RegistryObject<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
			() -> new AxeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(AxeItem.createAttributes(ModToolTiers.ENDERIUM, 6, -3.2f))));
	public static final RegistryObject<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
			() -> new HoeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(HoeItem.createAttributes(ModToolTiers.ENDERIUM, 0, -3.0f))));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
