package network.eden.jsoncraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import network.eden.jsoncraft.init.Registor;
import network.eden.jsoncraft.interpreteur.EntryManager;
import network.eden.jsoncraft.interpreteur.FileLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JSONCraft.MODID)
public class JSONCraft
{
    //public static JSONCraft instance;
    public static final String MODID = "jsoncraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public JSONCraft() {
        //instance = this;

        EntryManager.makeAll(FileLoader.getAll());
        Registor.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registor.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
/*
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::modSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);*/
    }

    private void modSetup(final FMLCommonSetupEvent event)
    {
        //OreGenerator.setupOregen();
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        //BlockRenders.defineRenders();
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }
}
