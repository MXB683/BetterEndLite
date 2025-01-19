package net.mxb_683.better_end_lite.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.util.ModTags;

import java.util.List;

public class ModConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERIUM_ORE_KEY = registerKey("enderium_ore");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_TREE_KEY = registerKey("chorus_tree");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		RuleTest endStoneReplaceables = new TagMatchTest(ModTags.Blocks.END_ORE_REPLACEABLES);

		register(context, ENDERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
				ModBlocks.ENDERIUM_ORE.get().defaultBlockState(), 3));

		register(context, CHORUS_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.CHORUS_LOG.get()),
				new ForkingTrunkPlacer(4, 4, 2),

				BlockStateProvider.simple(ModBlocks.CHORUS_LEAVES.get()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 3),

				new TwoLayersFeatureSize(1, 0, 2))
						.decorators(List.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.END_STONE))))
						.build());
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID,
				name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
																																												ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}