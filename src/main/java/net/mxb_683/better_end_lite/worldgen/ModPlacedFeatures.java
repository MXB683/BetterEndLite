package net.mxb_683.better_end_lite.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
	public static final ResourceKey<PlacedFeature> ENDERIUM_ORE_PLACED_KEY = registerKey("enderium_ore_placed");
	public static final ResourceKey<PlacedFeature> CHORUS_TREE_PLACED_KEY = registerKey("chrous_tree_placed");

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		register(context, ENDERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDERIUM_ORE_KEY),
				ModOrePlacement.commonOrePlacement(10,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(72))));

		register(context, CHORUS_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_TREE_KEY),
				VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05f, 1),
						ModBlocks.CHORUS_SAPLING.get()));
	}

	private static ResourceKey<PlacedFeature> registerKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, name));
	}

	private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
															 List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}
}