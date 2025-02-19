package net.mxb_683.better_end_lite.component;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
			DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<DataComponentType<Vec3>> NEXT_ENDER_BLADE_RELATIVE_TELEPORT_POSITION = register(
			"next_ender_blade_teleport_position",
			builder -> builder.persistent(Vec3.CODEC));


	private static <T> RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
		return DATA_COMPONENT_TYPES.register(name, () -> builder.apply(DataComponentType.builder()).build());
	}

	public static void register(IEventBus eventBus) {
		DATA_COMPONENT_TYPES.register(eventBus);
	}
}
