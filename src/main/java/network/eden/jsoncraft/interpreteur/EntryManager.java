package network.eden.jsoncraft.interpreteur;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.ItemDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntryManager {

    public static final Map<String, BlockDefinition> BLOCK_DEFINITIONS = new HashMap<>();
    public static final Map<String, ItemDefinition> ITEM_DEFINITIONS = new HashMap<>();
    public static final Map<String, Supplier<Block>> BLOCK_FACTORIES = new HashMap<>();
    public static final Map<String, Supplier<Item>> ITEM_FACTORIES = new HashMap<>();

}
