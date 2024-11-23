package io.purple.purplelib.item;

import io.purple.purplelib.dependency.DependMod;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.HashMap;

import static io.purple.purplelib.registry.PLRegistry.ITEMS;

/*
    Default Vanilla item, extended by some variables
*/

public class BasicItem extends Item {

    public static final HashMap<DependMod, HashMap<String, DeferredItem<BasicItem>>> MODITEMS = new HashMap<>();

    public BasicItem(String name, Item.Properties properties) {
        super(properties);
        //ITEMLIST.add(ITEMS.register(name, () -> this));
    }

    public static void addBasicItem(DependMod SourceMod, String name, Properties properties){
        // Ensure the outer map entry for the source mod exists
        MODITEMS.putIfAbsent(SourceMod, new HashMap<>());

        MODITEMS.get(SourceMod).put(name, ITEMS.register(name, ()-> new BasicItem(name, properties)));
    }


}
