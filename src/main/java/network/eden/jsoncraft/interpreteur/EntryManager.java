package network.eden.jsoncraft.interpreteur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.ItemDefinition;
import network.eden.jsoncraft.init.Registor;
import network.eden.jsoncraft.utils.BlockItemSupplier;
import network.eden.jsoncraft.utils.BlockSupplier;

public class EntryManager {

	public static final Map<String, BlockDefinition> BLOCK_DEFINITIONS = new HashMap<>();
	public static final Map<String, ItemDefinition> ITEM_DEFINITIONS = new HashMap<>();
	public static final Map<String, Supplier<Block>> BLOCK_FACTORIES = new HashMap<>();
	public static final Map<String, Supplier<Item>> ITEM_FACTORIES = new HashMap<>();

	public static void makeAll(List<String> definitions) {
		//TODO

		//i have the responsability to make the names correct

		String name = "example_block";
		//TODO: just testing
		EntryManager.BLOCK_DEFINITIONS.put(name, new BlockDefinition("block", name, 1.0F, 1.0F, 1));
		EntryManager.BLOCK_FACTORIES.put(name, new BlockSupplier(name));
		EntryManager.ITEM_FACTORIES.put(name, new BlockItemSupplier(name));

		new Registor().compile();
	}
}
