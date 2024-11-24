package io.purple.purplelib.dependency;

import io.purple.purplelib.item.BasicItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;

import static io.purple.purplelib.Collections.MODBLOCKITEMS;
import static io.purple.purplelib.Collections.MODITEMS;

public class ItemManager {


    public final DependMod parent;
    public final DeferredRegister.Items ITEMS;

    public ItemManager(DependMod parent) {
        this.parent = parent;
        ITEMS = DeferredRegister.createItems(parent.getModID());

    }

    // Main Way to add
    public void addBasicItem(String name, Item.Properties properties){
        // Ensure the outer map entry for the source mod exists
        MODITEMS.putIfAbsent(parent, new HashMap<>());

        MODITEMS.get(parent).put(name, this.ITEMS.register(name, ()-> new BasicItem(name, properties)));
    }

    public void addSimpleBlockItem(String name, DeferredBlock<Block> block){
        MODBLOCKITEMS.putIfAbsent(parent, new HashMap<>());

        MODBLOCKITEMS.get(parent).put(name, this.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties())));
    }

    /*
    *
    *  Utility Methods
    *
    * */

    public DeferredItem<Item> getItem(String name){
        return MODITEMS.get(parent).get(name);
    }

}
