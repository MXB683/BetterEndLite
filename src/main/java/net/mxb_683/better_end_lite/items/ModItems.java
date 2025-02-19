package net.mxb_683.better_end_lite.items;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mxb_683.better_end_lite.BetterEndLiteMod;
import net.mxb_683.better_end_lite.component.ModDataComponentTypes;
import net.mxb_683.better_end_lite.effect.ModEffects;
import net.mxb_683.better_end_lite.enchantment.ModEnchantments;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static net.mxb_683.better_end_lite.enchantment.custom.EnderBladeEnchantmentEffect.getValidYPosInColumn;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, BetterEndLiteMod.MOD_ID);

	public static final RegistryObject<Item> ENDERIUM_CLUMP = ITEMS.register("enderium_clump",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDERIUM_SHARD = ITEMS.register("enderium_shard",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDERIUM_BRICK = ITEMS.register("enderium_brick",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
			() -> new SwordItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(SwordItem.createAttributes(ModToolTiers.ENDERIUM, 3, -2.4f))) {
				@Override
				public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
					if (player.getItemInHand(InteractionHand.MAIN_HAND) != stack) return;
					if (!stack.isEnchanted()) return;
					int enchantmentLevel = stack.getEnchantments().getLevel(ModEnchantments.ENDER_BLADE.getOrThrow(level));
					if (enchantmentLevel == 0) return;

					Vec3 relativePos = stack.get(ModDataComponentTypes.NEXT_ENDER_BLADE_RELATIVE_TELEPORT_POSITION.get());
					if (relativePos == null) return;
					Vec3 pos = player.position().add(relativePos);
					pos = getValidYPosInColumn(level, pos);
					if (enchantmentLevel >= 2) {
						for (double i = 0; i < 360; i += 22.5) {
							double x = pos.x + Math.cos(Math.toRadians(i)) * 0.5;
							double z = pos.z + Math.sin(Math.toRadians(i)) * 0.5;
							level.addParticle(ParticleTypes.CRIT, x, pos.y + 0.1f, z, 0, 0, 0);
						}
					}
					if (enchantmentLevel >= 3) {
						for (double i = 0.15; i <= 0.9; i += 0.05) {
							Vec3 eyePos = player.getEyePosition().add(0, -0.5f, 0);
							Vec3 interpolatedPos = eyePos.add(pos.subtract(eyePos).scale(i));
							level.addParticle(ParticleTypes.CRIT, interpolatedPos.x, interpolatedPos.y, interpolatedPos.z, 0, 0, 0);
						}
					}

					super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
				}

				@Override
				public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
					if (entity instanceof LivingEntity) {
						if (stack.isEnchanted() && stack.getEnchantments().getLevel(ModEnchantments.ENDER_BLADE.getOrThrow(entity)) > 0) {
							Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									stack.set(ModDataComponentTypes.NEXT_ENDER_BLADE_RELATIVE_TELEPORT_POSITION.get(),
											new Vec3(new Random().nextDouble() * 10 - 5, 0, new Random().nextDouble() * 10 - 5));
								}
							}, 50);
							((LivingEntity) entity).addEffect(new MobEffectInstance(Holder.direct(ModEffects.ENDER_BLEEDING.get()),
									150 * stack.getEnchantments().getLevel(ModEnchantments.ENDER_BLADE.getOrThrow(entity)), 0));
						} else {
							((LivingEntity) entity).addEffect(new MobEffectInstance(Holder.direct(ModEffects.BLEEDING.get()),
									100, 0));
						}
					}
					return super.onLeftClickEntity(stack, player, entity);
				}
			});

	public static final RegistryObject<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
			() -> new PickaxeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(PickaxeItem.createAttributes(ModToolTiers.ENDERIUM, 1, -2.8f))));
	public static final RegistryObject<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
			() -> new ShovelItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(ShovelItem.createAttributes(ModToolTiers.ENDERIUM, 1.5f, -3.0f))));
	public static final RegistryObject<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
			() -> new AxeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(AxeItem.createAttributes(ModToolTiers.ENDERIUM, 6, -3.2f))));
	public static final RegistryObject<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
			() -> new HoeItem(ModToolTiers.ENDERIUM, new Item.Properties()
					.attributes(HoeItem.createAttributes(ModToolTiers.ENDERIUM, 0, -3.0f))));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
