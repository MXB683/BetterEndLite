package net.mxb_683.better_end_lite.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
	public static final TreeGrower CHORUS = new TreeGrower(BetterEndLiteMod.MOD_ID + ":chorus",
			Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUS_TREE_KEY), Optional.empty()
			);
}
