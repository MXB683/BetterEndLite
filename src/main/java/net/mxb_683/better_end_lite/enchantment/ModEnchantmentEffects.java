package net.mxb_683.better_end_lite.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.enchantment.custom.EnderBladeEnchantmentEffect;

public class ModEnchantmentEffects {
	public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
			DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> ENDER_BLADE_EFFECT = ENTITY_ENCHANTMENT_EFFECTS.register(
			"ender_blade_effect", () -> EnderBladeEnchantmentEffect.CODEC);

	public static void register(IEventBus eventBus) {
		ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
	}
}
