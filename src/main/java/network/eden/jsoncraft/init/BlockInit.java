package network.eden.jsoncraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import network.eden.jsoncraft.JSONCraft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, JSONCraft.MODID);
    public static final Map<String, OreBlock> ORE_DICT = new HashMap<>();
    public static final Map<String, Block> BLOCK_DICT = new HashMap<>();

    public static void register(List<BlockDefinition> definitions, IEventBus bus){
        for(BlockDefinition definition: definitions){
            if(definition.type.equals("ore")){
                Block sample = Blocks.IRON_ORE;
                OreBlock block = new OreBlock(
                        Block.Properties.from(sample) //TODO: in definition
                                .hardnessAndResistance(definition.hardness, definition.resistance)
                                .harvestTool(ToolType.PICKAXE) //TODO: in definition
                                .harvestLevel(definition.harvestLevel)
                                .sound(SoundType.STONE) //TODO: in definition
                );
                ORE_DICT.put(definition.name, block);
                BLOCKS.register(definition.name, () -> block);
            }else if(definition.type.equals("block")){
                Block sample = Blocks.IRON_BLOCK;
                Block block = new Block(
                        Block.Properties.from(sample) //TODO: in definition
                                .hardnessAndResistance(definition.hardness, definition.resistance)
                                .sound(SoundType.STONE) //TODO: in definition
                );
                BLOCK_DICT.put(definition.name, block);
                BLOCKS.register(definition.name, () -> block);
            }
        }

        BLOCKS.register(bus);
    }

}
