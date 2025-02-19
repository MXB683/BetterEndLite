package net.mxb_683.better_end_lite.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.mxb_683.better_end_lite.util.ModTags;

public class ModToolTiers {
	public static final Tier ENDERIUM = new ForgeTier(3146, 25F, 9.0F, 20,
			ModTags.Blocks.NEEDS_ENDERIUM_TOOL, () -> Ingredient.of(ModItems.ENDERIUM_SHARD.get()),
			ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL);
}
