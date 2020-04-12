package network.eden.jsoncraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import network.eden.jsoncraft.JSONCraft;

import java.util.function.Supplier;


public class ModItemGroups {

    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(JSONCraft.MODID, () -> new ItemStack(Items.LIGHT_BLUE_BANNER)); //TODO: set decent item here


    public static class ModItemGroup extends ItemGroup{

        private final Supplier<ItemStack> iconSupplier;


        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }

}


