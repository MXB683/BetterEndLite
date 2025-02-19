package net.mxb_683.better_end_lite.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.mxb_683.better_end_lite.component.ModDataComponentTypes;
import org.jetbrains.annotations.NotNull;

public record EnderBladeEnchantmentEffect() implements EnchantmentEntityEffect {
	public static final MapCodec<EnderBladeEnchantmentEffect> CODEC = MapCodec.unit(EnderBladeEnchantmentEffect::new);

	@Override
	public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
		if (pItem.owner() == null) return;
		pEntity.hurt(pLevel.damageSources().magic(), 3 * pEnchantmentLevel);
		Vec3 relativePos = pItem.itemStack().get(ModDataComponentTypes.NEXT_ENDER_BLADE_RELATIVE_TELEPORT_POSITION.get());
		Vec3 randomPos = pItem.owner().position().add(relativePos == null ? Vec3.ZERO : relativePos);
		randomPos.add(0, pItem.owner().position().y, 0);
		randomPos = getValidYPosInColumn(pLevel, randomPos);
		pEntity.teleportTo(randomPos.x(), randomPos.y(), randomPos.z());
	}

	@Override
	public MapCodec<? extends EnchantmentEntityEffect> codec() {
		return CODEC;
	}

	@NotNull
	public static Vec3 getValidYPosInColumn(Level level, Vec3 pos) {
		boolean foundY = true;
		int tries = 0;
		while (level.getBlockState(new BlockPos((int) pos.x, (int) pos.y, (int) pos.z)).isCollisionShapeFullBlock(level,
				new BlockPos((int) pos.x, (int) pos.y, (int) pos.z))) {
			pos = pos.add(0, 1, 0);
			if (tries >= 5) {
				foundY = false;
				break;
			}
			tries++;
		}
		if (!foundY) {
			tries = 0;
			while (level.getBlockState(new BlockPos((int) pos.x, (int) pos.y, (int) pos.z)).isCollisionShapeFullBlock(level,
					new BlockPos((int) pos.x, (int) pos.y, (int) pos.z))) {
				pos = pos.add(0, -1, 0);
				if (tries >= 10) break;
				tries++;
			}
		}
		tries = 0;
		while (!level.getBlockState(new BlockPos((int) pos.x, (int) pos.y - 1, (int) pos.z)).isCollisionShapeFullBlock(level,
				new BlockPos((int) pos.x, (int) pos.y, (int) pos.z))) {
			pos = pos.add(0, -1, 0);
			if (tries >= 10) break;
			tries++;
		}
		return pos;
	}
}
