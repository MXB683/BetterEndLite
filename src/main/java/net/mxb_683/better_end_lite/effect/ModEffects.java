package net.mxb_683.better_end_lite.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;

public class ModEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS =
			DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
			() -> new BleedingEffect(MobEffectCategory.HARMFUL, 0xFF6347));
	public static final RegistryObject<MobEffect> ENDER_BLEEDING = MOB_EFFECTS.register("ender_bleeding",
			() -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x8610c5));


	public static final void register(IEventBus eventBus) {
		MOB_EFFECTS.register(eventBus);
	}
}
