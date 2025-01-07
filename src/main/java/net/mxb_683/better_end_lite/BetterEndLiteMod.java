package net.mxb_683.better_end_lite;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModCreativeModeTabs;
import net.mxb_683.better_end_lite.items.ModItems;
import org.slf4j.Logger;

@Mod(BetterEndLiteMod.MOD_ID)
public class BetterEndLiteMod {
	public static final String MOD_ID = "better_end_lite";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BetterEndLiteMod(FMLJavaModLoadingContext context) {
		IEventBus modEventBus = context.getModEventBus();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

		ModCreativeModeTabs.register(modEventBus);

		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);

		modEventBus.addListener(this::addCreative);

		context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.ENDERIUM_CLUMP);
			event.accept(ModItems.ENDERIUM_SHARD);
		}

		if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			event.accept(ModBlocks.ENDERIUM_ORE);
		}

		if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(ModBlocks.ENDERIUM_CLUMP_BLOCK);
		}
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {

	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}
	}
}
