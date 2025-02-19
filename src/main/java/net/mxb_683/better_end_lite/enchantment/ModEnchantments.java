package net.mxb_683.better_end_lite.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.enchantment.custom.EnderBladeEnchantmentEffect;

public class ModEnchantments {
	public static final ResourceKey<Enchantment> ENDER_BLADE = ResourceKey.create(Registries.ENCHANTMENT,
			ResourceLocation.fromNamespaceAndPath(BetterEndLiteMod.MOD_ID, "ender_blade"));

	public static void bootstrap(BootstrapContext<Enchantment> context) {
		var enchantments = context.lookup(Registries.ENCHANTMENT);
		var items = context.lookup(Registries.ITEM);

		register(context, ENDER_BLADE, Enchantment.enchantment(Enchantment.definition(
						items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
						items.getOrThrow(ItemTags.SHARP_WEAPON_ENCHANTABLE),
						2,
						3,
						Enchantment.dynamicCost(5, 15),
						Enchantment.dynamicCost(30, 15),
						8,
						EquipmentSlotGroup.HAND))
				.exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
				.withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM,
						new EnderBladeEnchantmentEffect()));
	}

	public static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
															Enchantment.Builder builder) {
		registry.register(key, builder.build(key.location()));
	}
}
