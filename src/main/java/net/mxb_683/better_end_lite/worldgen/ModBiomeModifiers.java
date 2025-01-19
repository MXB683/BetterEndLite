package net.mxb_683.better_end_lite.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_ENDERIUM_ORE = registerKey("add_enderium_ore");
	public static final ResourceKey<BiomeModifier> ADD_CHORUS_TREE = registerKey("add_chorus_tree");

	public static void bootstrap(BootstrapContext<BiomeModifier> context) {
		var placedFeature = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);

		context.register(ADD_ENDERIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_END),
				HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.ENDERIUM_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES
		));
		context.register(ADD_CHORUS_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				HolderSet.direct(biomes.getOrThrow(Biomes.END_BARRENS), biomes.getOrThrow(Biomes.END_MIDLANDS)),
				HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CHORUS_TREE_PLACED_KEY)),
				GenerationStep.Decoration.VEGETAL_DECORATION
		));
	}

	private static ResourceKey<BiomeModifier> registerKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
				ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, name));
	}
}