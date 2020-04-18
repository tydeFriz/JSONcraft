package network.eden.jsoncraft.utils;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.Registor;

public class BlockSupplier implements IRegistrableSupplier<net.minecraft.block.Block> {

	private final BlockDefinition definition;

	public BlockSupplier(BlockDefinition definition) {
		this.definition = definition;
	}

	@Nonnull
	@Override
	public Supplier<Block> makeSupplier(@Nonnull Registor registrar) {
		return () -> new Block(Block.Properties.create(Material.EARTH)
				.hardnessAndResistance(definition.hardness, definition.resistance)
				.harvestLevel(definition.harvestLevel)
		);
	}
}
