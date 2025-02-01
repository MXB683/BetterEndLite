package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;
import net.mxb_683.better_end_lite.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
	public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
		super(pOutput, pRegistries);
	}

	@Override
	protected void buildRecipes(RecipeOutput pRecipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERIUM_BRICK.get())
				.pattern("##")
				.pattern("##")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BRICKS.get())
				.pattern("##")
				.pattern("##")
				.define('#', ModItems.ENDERIUM_BRICK.get())
				.unlockedBy(getHasName(ModItems.ENDERIUM_BRICK.get()), has(ModItems.ENDERIUM_BRICK.get())).save(pRecipeOutput);

		stairBuilder(ModBlocks.ENDERIUM_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.ENDERIUM_BRICKS.get())).group(
				"enderium_brick_stairs").unlockedBy(getHasName(ModBlocks.ENDERIUM_BRICKS.get()),
				has(ModBlocks.ENDERIUM_BRICKS.get())).save(pRecipeOutput);
		slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BRICK_SLAB.get(), ModBlocks.ENDERIUM_BRICKS.get());
		wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BRICK_WALL.get(), ModBlocks.ENDERIUM_BRICKS.get());
		chiseled(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ENDERIUM_BRICKS.get(),
				ModBlocks.ENDERIUM_BRICK_SLAB.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.pattern("###")
				.pattern("###")
				.pattern("###")
				.define('#', ModItems.ENDERIUM_CLUMP.get())
				.unlockedBy(getHasName(ModItems.ENDERIUM_CLUMP.get()), has(ModItems.ENDERIUM_CLUMP.get())).save(pRecipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_CLUMP.get(), 9)
				.requires(ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.unlockedBy(getHasName(ModBlocks.ENDERIUM_CLUMP_BLOCK.get()), has(ModBlocks.ENDERIUM_CLUMP_BLOCK.get())).save(pRecipeOutput);


		oreSmelting(pRecipeOutput, List.of(ModItems.ENDERIUM_CLUMP.get(), ModBlocks.ENDERIUM_CLUMP_BLOCK.get()),
				RecipeCategory.MISC, ModItems.ENDERIUM_SHARD.get(), 50f, 500, "enderium_shard");
		oreBlasting(pRecipeOutput, List.of(ModItems.ENDERIUM_CLUMP.get(), ModBlocks.ENDERIUM_CLUMP_BLOCK.get()),
				RecipeCategory.MISC, ModItems.ENDERIUM_SHARD.get(), 100f, 200, "enderium_shard");


		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERIUM_SPIKES.get())
				.pattern("###")
				.pattern("#_#")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('_', ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);

		stairBuilder(ModBlocks.CHORUS_STAIRS.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_stairs")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);
		slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_SLAB.get(), ModBlocks.CHORUS_PLANKS.get());
		fenceBuilder(ModBlocks.CHORUS_FENCE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_fence")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);
		fenceGateBuilder(ModBlocks.CHORUS_FENCE_GATE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_fence_gate")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);
		buttonBuilder(ModBlocks.CHORUS_BUTTON.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_button")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);
		pressurePlate(pRecipeOutput, ModBlocks.CHORUS_PRESSURE_PLATE.get(), ModBlocks.CHORUS_PLANKS.get());
		trapdoorBuilder(ModBlocks.CHORUS_TRAPDOOR.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_trapdoor")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);
		doorBuilder(ModBlocks.CHORUS_DOOR.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group(
						"wooden_door")
				.unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(pRecipeOutput);

		woodFromLogs(pRecipeOutput, ModBlocks.CHORUS_WOOD.get(), ModBlocks.CHORUS_LOG.get());
		woodFromLogs(pRecipeOutput, ModBlocks.STRIPPED_CHORUS_WOOD.get(), ModBlocks.STRIPPED_CHORUS_LOG.get());
		planksFromLogs(pRecipeOutput, ModBlocks.CHORUS_PLANKS.get(), ModTags.Items.CHORUS_LOGS, 4);

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_SWORD.get())
				.pattern("#")
				.pattern("#")
				.pattern("|")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('|', Items.STICK)
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PICKAXE.get())
				.pattern("###")
				.pattern(" | ")
				.pattern(" | ")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('|', Items.STICK)
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_SHOVEL.get())
				.pattern("#")
				.pattern("|")
				.pattern("|")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('|', Items.STICK)
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_AXE.get())
				.pattern("##")
				.pattern("|#")
				.pattern("| ")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('|', Items.STICK)
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HOE.get())
				.pattern("##")
				.pattern(" |")
				.pattern(" |")
				.define('#', ModItems.ENDERIUM_SHARD.get())
				.define('|', Items.STICK)
				.unlockedBy(getHasName(ModItems.ENDERIUM_SHARD.get()), has(ModItems.ENDERIUM_SHARD.get())).save(pRecipeOutput);

	}


	protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory,
																		ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
		oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
				pExperience, pCookingTIme, pGroup, "_from_smelting");
	}

	protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory,
																		ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
		oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
				pExperience, pCookingTime, pGroup, "_from_blasting");
	}

	protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput,
																																		 RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients,
																																		 RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup,
																																		 String pRecipeName) {
		for (ItemLike itemlike : pIngredients) {
			SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
					.save(recipeOutput, BetterEndLiteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
		}
	}
}