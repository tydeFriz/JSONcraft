package network.eden.jsoncraft.utils;

import java.util.function.Supplier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import network.eden.jsoncraft.init.ModItemGroups;
import network.eden.jsoncraft.init.Registor;

public class BlockItemSupplier implements Supplier<Item> {

	private String name;

	public BlockItemSupplier(String name) {
		this.name = name;
	}

	@Override
	public Item get() {
		return new BlockItem(
				Registor.BLOCK_LIST.get(name).get(),
				new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)
		);
	}
}