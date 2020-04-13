package network.eden.jsoncraft.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import network.eden.jsoncraft.JSONCraft;
import network.eden.jsoncraft.interpreteur.EntryManager;

import java.util.HashMap;
import java.util.Map;

public class Registor {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, JSONCraft.MODID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, JSONCraft.MODID);

    public static final Map<String, RegistryObject<Block>> BLOCK_LIST = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> ITEM_LIST = new HashMap<>();

    public void compile(){
        for(Map.Entry<String, BlockDefinition> entry: EntryManager.BLOCK_DEFINITIONS.entrySet()){
            String name = entry.getValue().name;
            BLOCK_LIST.put(name, BLOCKS.register(name, EntryManager.BLOCK_FACTORIES.get(name)));
            ITEM_LIST.put(name, ITEMS.register(name, EntryManager.ITEM_FACTORIES.get(name)));
        }
        for(Map.Entry<String, ItemDefinition> entry: EntryManager.ITEM_DEFINITIONS.entrySet()){
            String name = entry.getValue().name;
            ITEM_LIST.put(name, ITEMS.register(name, EntryManager.ITEM_FACTORIES.get(name)));
        }
    }
}
