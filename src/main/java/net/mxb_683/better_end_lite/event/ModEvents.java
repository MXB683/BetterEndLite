package net.mxb_683.better_end_lite.event;

import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mxb_683.better_end_lite.block.ModBlocks;
import net.mxb_683.better_end_lite.items.ModItems;
import net.mxb_683.better_end_lite.villager.ModVillagers;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ModEvents {
	@SubscribeEvent
	public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
		if (event.getType() == ModVillagers.ENDER_CLERIC.get()) {
			var trades = event.getTrades();
			trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 3),
					new ItemStack(Items.FIREWORK_ROCKET, 8),
					8, 2, 0.05F));
			trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 1),
					Optional.of(new ItemCost(ModItems.ENDERIUM_CLUMP.get(), 3)),
					new ItemStack(ModItems.ENDERIUM_SHARD.get(), 3),
					6, 1, 0.05F));
			trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.EMERALD, 5),
					new ItemStack(Items.DIAMOND, 3),
					6, 1, 0.05F)));

			trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(ModBlocks.CHORUS_PLANKS.get(), 32),
					new ItemStack(Items.DIAMOND, 2),
					24, 18, 0.05F));
			trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(ModItems.ENDERIUM_SHARD.get(), 8),
					new ItemStack(Items.DIAMOND, 1),
					8, 10, 0.05F));
			trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 3),
					new ItemStack(ModBlocks.ENDERIUM_SPIKES.get(), 1),
					6, 12, 0.05F));

			trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 5),
					new ItemStack(Items.DRAGON_BREATH, 3),
					12, 12, 0.05F));
			trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DRAGON_HEAD, 1),
					new ItemStack(Items.DIAMOND, 2),
					6, 16, 0.05F));

			trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 2),
					new ItemStack(Items.ENDER_PEARL, 3),
					12, 28, 0.05F));
			trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 3),
					new ItemStack(Items.ENDER_EYE, 3),
					12, 28, 0.05F));
			trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 1),
					new ItemStack(Items.BLAZE_ROD, 1),
					12, 28, 0.05F));

			trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
					new ItemCost(Items.DIAMOND, 48),
					Optional.of(new ItemCost(Items.PHANTOM_MEMBRANE, 8)),
					new ItemStack(Items.ELYTRA, 1),
					1, 96, 0.05F));
		}
	}
}
