package network.eden.jsoncraft.utils;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.ModItemGroups;
import network.eden.jsoncraft.init.Registor;

public class BlockItemSupplierMaker implements IRegistrableSupplierMaker<Item> {

	private final BlockDefinition definition;

	public BlockItemSupplierMaker(BlockDefinition definition) {
		this.definition = definition;
	}

	@Nonnull
	@Override
	public Supplier<Item> makeSupplier(@Nonnull Registor registrar) {
		return () -> new BlockItem(
				registrar.getBlockRegistry(definition.name)
						.orElseThrow(() -> new NullPointerException("Block registry '" + definition.name + "' not found!"))
						.get(),
				new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)
		);
	}
}