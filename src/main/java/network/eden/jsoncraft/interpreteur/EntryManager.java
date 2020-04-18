package network.eden.jsoncraft.interpreteur;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import network.eden.jsoncraft.init.BlockDefinition;
import network.eden.jsoncraft.init.ItemDefinition;
import network.eden.jsoncraft.utils.BlockItemSupplierMaker;
import network.eden.jsoncraft.utils.BlockSupplierMaker;
import network.eden.jsoncraft.utils.IRegistrableSupplierMaker;

public class EntryManager {

	private static final Gson jsonParser = new GsonBuilder().create();

	private final Map<String, BlockDefinition> blockDefinitions;
	private final Map<String, ItemDefinition> itemDefinitions;
	private final Map<String, IRegistrableSupplierMaker<Block>> blockFactories;
	private final Map<String, IRegistrableSupplierMaker<Item>> itemFactories;

	public EntryManager() {
		blockDefinitions = new HashMap<>();
		itemDefinitions = new HashMap<>();
		blockFactories = new HashMap<>();
		itemFactories = new HashMap<>();
	}

	public void parseDefinitions(Iterable<String> definitions) {
		//TODO

		for (String definition : definitions) {
			JsonObject jsonObject = jsonParser.fromJson(definition, JsonObject.class);
			if (!jsonObject.has("name") || !jsonObject.get("name").isJsonPrimitive()) {
				System.err.println("A definition doesn't have 'name' property");
			} else {
				String name = jsonObject.get("name").getAsString();

				if (!jsonObject.has("type") || !jsonObject.get("type").isJsonPrimitive()) {
					System.err.format("The definition '%s' doesn't have 'type' property", name);
				} else {
					String type = jsonObject.get("type").getAsString();
					try {
						switch (type) {
							case "block":
								BlockDefinition blockDefinition = jsonParser.fromJson(jsonObject, BlockDefinition.class);
								blockDefinitions.put(name, blockDefinition);
								blockFactories.put(name, new BlockSupplierMaker(blockDefinition));
								itemFactories.put(name, new BlockItemSupplierMaker(blockDefinition));
								break;
							case "mineral":
								BlockDefinition mineralDefinition = jsonParser.fromJson(jsonObject, BlockDefinition.class);
								blockDefinitions.put(name, mineralDefinition);
								blockFactories.put(name, new BlockSupplierMaker(mineralDefinition));
								itemFactories.put(name, new BlockItemSupplierMaker(mineralDefinition));
								break;
							default:
								System.err.format("The definition '%s' is of the unknown type '%s'", name, type);
						}
					} catch (JsonSyntaxException parseException) {
						System.err.format("The definition '%s' can't be parsed", name);
						parseException.printStackTrace();
					}
				}
			}
		}

		//i have the responsability to make the names correct

	}

	@Nonnull
	public Map<String, BlockDefinition> getBlockDefinitions() {
		return Collections.unmodifiableMap(blockDefinitions);
	}

	@Nullable
	public BlockDefinition getBlockDefinition(String name) {
		return blockDefinitions.get(name);
	}

	@Nullable
	public IRegistrableSupplierMaker<Block> getBlockFactory(String name) {
		return blockFactories.get(name);
	}

	@Nonnull
	public Map<String, ItemDefinition> getItemDefinitions() {
		return Collections.unmodifiableMap(itemDefinitions);
	}

	@Nullable
	public ItemDefinition getItemDefinition(String name) {
		return itemDefinitions.get(name);
	}

	@Nullable
	public IRegistrableSupplierMaker<Item> getItemFactory(String name) {
		return itemFactories.get(name);
	}
}
