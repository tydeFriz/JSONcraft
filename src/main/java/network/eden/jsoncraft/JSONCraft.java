package network.eden.jsoncraft;

import java.util.HashSet;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import network.eden.jsoncraft.init.Registor;
import network.eden.jsoncraft.interpreteur.EntryManager;
import network.eden.jsoncraft.interpreteur.ResourcesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JSONCraft.MODID)
public class JSONCraft {

	//public static JSONCraft instance;
	public static final String MODID = "jsoncraft";

	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	// Entry manager
	public static final EntryManager entryManager = new EntryManager();

	public static final Registor registrar = new Registor(entryManager);

	public JSONCraft() {

		entryManager.parseDefinitions(ResourcesReader.readDefinitions().orElse(new HashSet<>()));

		registrar.compile(FMLJavaModLoadingContext.get().getModEventBus());

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::modSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
	}

	private void modSetup(final FMLCommonSetupEvent event) {
		//OreGenerator.setupOregen();
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		//BlockRenders.defineRenders();
	}

	private void serverSetup(final FMLDedicatedServerSetupEvent event) {

	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}
}
