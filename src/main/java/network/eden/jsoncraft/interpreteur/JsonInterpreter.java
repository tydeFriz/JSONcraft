package network.eden.jsoncraft.interpreteur;

import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.ItemDefinition;

import java.util.ArrayList;
import java.util.List;

public class JsonInterpreter {

    public static List<ItemDefinition> itemDefinitions = new ArrayList<>();
    public static List<BlockDefinition> blockDefinitions = new ArrayList<>();

    public static void makeAll(List<String> definitions){
        //TODO

        //i have the responsability to make the names correct
        //also compile the en_us

        //TODO: just testing
        blockDefinitions.add(new BlockDefinition("block", "test_block", 1.0F, 1.0F, 1));
    }
}
