package net.mxb_683.better_end_lite.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
	public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
		super(pOutput, pRegistries);
	}

	@Override
	protected void buildRecipes(RecipeOutput pRecipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERIUM_CLUMP_BLOCK.get())
				.pattern("###")
				.pattern("###")
				.pattern("###")
				.define('#', ModItems.ENDERIUM_CLUMP.get())
				.unlockedBy(getHasName(ModItems.ENDERIUM_CLUMP.get()), has(ModItems.ENDERIUM_CLUMP.get())).save(pRecipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_CLUMP.get(), 9)
				.requires(ModBlocks.ENDERIUM_ORE.get())
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
																																		 RecipeSerializer<T> pCookingSerializer,
																																		 AbstractCookingRecipe.Factory<T> factory,
																																		 List<ItemLike> pIngredients,
																																		 RecipeCategory pCategory, ItemLike pResult,
																																		 float pExperience, int pCookingTime,
																																		 String pGroup, String pRecipeName) {
		for (ItemLike itemlike : pIngredients) {
			SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
					.save(recipeOutput, BetterEndLiteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
		}
	}
}