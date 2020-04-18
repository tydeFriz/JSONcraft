package network.eden.jsoncraft.utils;

import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import network.eden.jsoncraft.interpreteur.EntryManager;

public class BlockSupplier implements Supplier<net.minecraft.block.Block> {

	private String name;

	public BlockSupplier(String name) {
		this.name = name;
	}

	@Override
	public Block get() {
		return new Block(Block.Properties.create(Material.EARTH)
				.hardnessAndResistance(
						EntryManager.BLOCK_DEFINITIONS.get(name).hardness,
						EntryManager.BLOCK_DEFINITIONS.get(name).resistance)
				.harvestLevel(EntryManager.BLOCK_DEFINITIONS.get(name).harvestLevel)
		);
	}
}
