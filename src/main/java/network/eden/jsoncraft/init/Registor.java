package network.eden.jsoncraft.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import network.eden.jsoncraft.JSONCraft;
import network.eden.jsoncraft.interpreteur.EntryManager;

/**
 * The "Registor" is a registrar that register all the entries defined in JSON into forge, and keeps the references of
 * the registered object by name
 *
 * @author @Cavallium
 * @author @tydeFriz
 */
public class Registor {

	private final EntryManager entryManager;

	public final DeferredRegister<Block> blockRegister = new DeferredRegister<>(ForgeRegistries.BLOCKS, JSONCraft.MODID);
	public final DeferredRegister<Item> itemRegister = new DeferredRegister<>(ForgeRegistries.ITEMS, JSONCraft.MODID);

	public final Map<String, RegistryObject<Block>> blockRegistries = new HashMap<>();
	public final Map<String, RegistryObject<Item>> itemRegistries = new HashMap<>();

	/**
	 * @param entryManager the {@link EntryManager} from which the definitions are loaded during the compilation
	 */
	public Registor(EntryManager entryManager) {
		this.entryManager = entryManager;
	}

	/**
	 * Compile the definitions parsed by the {@link EntryManager} and register them
	 *
	 * @param modEventBus Forge mod event bus
	 */
	public void compile(IEventBus modEventBus) {
		// Register the event bus
		blockRegister.register(modEventBus);
		itemRegister.register(modEventBus);

		// Compile blocks
		entryManager.getBlockDefinitions().forEach((name, definition) -> {
			registerBlock(name, Objects.requireNonNull(entryManager.getBlockFactory(name)).makeSupplier(this));
			registerItem(name, Objects.requireNonNull(entryManager.getItemFactory(name)).makeSupplier(this));
		});

		// Compile items
		entryManager.getItemDefinitions().forEach((name, definition) ->
				registerItem(name, Objects.requireNonNull(entryManager.getItemFactory(name)).makeSupplier(this))
		);
	}

	/**
	 * Register a block by passing a block supplier
	 *
	 * @param name          Block name
	 * @param blockSupplier Block supplier
	 * @return true if the block has been registered successfully
	 */
	private boolean registerBlock(@Nonnull String name, @Nonnull Supplier<Block> blockSupplier) {
		if (!blockRegistries.containsKey(name)) {
			blockRegistries.put(name, blockRegister.register(name, blockSupplier));
			return true;
		} else {
			System.err.format("Block '%s' registered twice!", name);
			return false;
		}
	}

	/**
	 * Register an item by passing a block supplier
	 *
	 * @param name         Item name
	 * @param itemSupplier Item supplier
	 * @return true if the item has been registered successfully
	 */
	private boolean registerItem(@Nonnull String name, @Nonnull Supplier<Item> itemSupplier) {
		if (!itemRegistries.containsKey(name)) {
			itemRegistries.put(name, itemRegister.register(name, itemSupplier));
			return true;
		} else {
			System.err.format("Item '%s' registered twice!", name);
			return false;
		}
	}

	/**
	 * Get the block {@link RegistryObject} if present
	 *
	 * @param name Block name
	 * @return The block associated {@link RegistryObject}, or <code>empty</code> if not found
	 */
	@Nonnull
	public Optional<RegistryObject<Block>> getBlockRegistry(String name) {
		return Optional.ofNullable(blockRegistries.get(name));
	}

	/**
	 * Get the item {@link RegistryObject} if present
	 *
	 * @param name Item name
	 * @return The item associated {@link RegistryObject}, or <code>empty</code> if not found
	 */
	@Nonnull
	public Optional<RegistryObject<Item>> getItemRegistry(String name) {
		return Optional.ofNullable(itemRegistries.get(name));
	}
}
