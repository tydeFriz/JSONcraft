package network.eden.jsoncraft.init;

import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import network.eden.jsoncraft.JSONCraft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, JSONCraft.MODID);
    public static final Map<String, SwordItem> SWORD_DICT = new HashMap<>();
    public static final Map<String, PickaxeItem> PICKAXE_DICT = new HashMap<>();
    public static final Map<String, AxeItem> AXE_DICT = new HashMap<>();
    public static final Map<String, ShovelItem> SHOVEL_DICT = new HashMap<>();
    public static final Map<String, HoeItem> HOE_DICT = new HashMap<>();

    public static void register(List<ItemDefinition> definitions, IEventBus bus){

    }
}
