package net.mxb_683.better_end_lite;

import com.mojang.logging.LogUtils;
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
import net.mxb_683.better_end_lite.component.ModDataComponentTypes;
import net.mxb_683.better_end_lite.effect.ModEffects;
import net.mxb_683.better_end_lite.enchantment.ModEnchantmentEffects;
import net.mxb_683.better_end_lite.event.ModEvents;
import net.mxb_683.better_end_lite.items.ModCreativeModeTabs;
import net.mxb_683.better_end_lite.items.ModItems;
import net.mxb_683.better_end_lite.villager.ModVillagers;
import org.slf4j.Logger;

@Mod(BetterEndLiteMod.MOD_ID)
public class BetterEndLiteMod {
	public static final String MOD_ID = "better_end_lite";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BetterEndLiteMod(FMLJavaModLoadingContext context) {
		IEventBus modEventBus = context.getModEventBus();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(ModEvents.class);

		ModCreativeModeTabs.register(modEventBus);

		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModEffects.register(modEventBus);
		ModEnchantmentEffects.register(modEventBus);
		ModVillagers.register(modEventBus);
		ModDataComponentTypes.register(modEventBus);

		modEventBus.addListener(this::addCreative);

		context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {

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
