package net.mxb_683.better_end_lite.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.block.ModBlocks;

public class ModVillagers {
	public static final DeferredRegister<PoiType> POI_TYPES =
			DeferredRegister.create(ForgeRegistries.POI_TYPES, BetterEndLiteMod.MOD_ID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
			DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<PoiType> ENDER_CLERIC_POI = POI_TYPES.register("ender_cleric",
			() -> new PoiType(ImmutableSet.copyOf(ModBlocks.ENDERIUM_ENCHANTER.get().getStateDefinition().getPossibleStates()),
					1, 1));
	public static final RegistryObject<VillagerProfession> ENDER_CLERIC = VILLAGER_PROFESSIONS.register("ender_cleric",
			() -> new VillagerProfession("ender_cleric", holder -> holder.value() == ENDER_CLERIC_POI.get(),
					holder -> holder.value() == ENDER_CLERIC_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
					SoundEvents.ENDER_EYE_LAUNCH));

	public static void register(IEventBus eventBus) {
		POI_TYPES.register(eventBus);
		VILLAGER_PROFESSIONS.register(eventBus);
	}
}
