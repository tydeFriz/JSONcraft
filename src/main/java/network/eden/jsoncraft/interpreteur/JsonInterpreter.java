package network.eden.jsoncraft.interpreteur;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import network.eden.jsoncraft.JSONCraft;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.Registor;
import network.eden.jsoncraft.utils.BlockItemSupplier;
import network.eden.jsoncraft.utils.BlockSupplier;

import java.util.List;

public class JsonInterpreter {

    public static void makeAll(List<String> definitions){
        //TODO

        //i have the responsability to make the names correct
        //also compile the en_us

        String name = "example_block";
        //TODO: just testing
        EntryManager.BLOCK_DEFINITIONS.put(name, new BlockDefinition("block", name, 1.0F, 1.0F, 1));
        EntryManager.BLOCK_FACTORIES.put(name, new BlockSupplier(name));
        EntryManager.ITEM_FACTORIES.put(name, new BlockItemSupplier(name));

        new Registor().compile();
    }
}
