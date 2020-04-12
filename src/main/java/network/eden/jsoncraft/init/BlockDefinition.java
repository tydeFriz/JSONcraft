package network.eden.jsoncraft.init;

public class BlockDefinition {
    public String type;
    public String name;
    public float hardness;
    public float resistance;
    public int harvestLevel;

    public BlockDefinition(String type, String name, float hardness, float resistance, int harvestLevel){
        this.type = type;
        this.name = name;
        this.hardness = hardness;
        this.resistance = resistance;
        this.harvestLevel = harvestLevel;
    }
}
