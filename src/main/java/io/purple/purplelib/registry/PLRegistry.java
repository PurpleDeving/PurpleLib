package io.purple.purplelib.registry;

import io.purple.purplelib.Collections;
import io.purple.purplelib.dependency.DependMod;
import io.purple.purplelib.item.BasicItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.purple.purplelib.PurpleLib.MODID;
import static io.purple.purplelib.dependency.DependMod.dependMods;

public class PLRegistry {


/*


    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));
*/



    public static void register(IEventBus modEventBus){

        // Register the Deferred Register to the mod event bus so items get registered
        for(DependMod dependMod : dependMods){

            // Check if there are Blocks to register
            if(!dependMod.getBManager().BLOCKS.getEntries().isEmpty()){
                dependMod.getBManager().BLOCKS.register(modEventBus);

            }

            // Check if there are Items to register
            if(!dependMod.getIManager().ITEMS.getEntries().isEmpty()){
                // Register the item Registry
                dependMod.getIManager().ITEMS.register(modEventBus);
                // Make sure a Creative Tab exist
                if(Collections.CREATIVE_MODE_TABS.get(dependMod) != null){
                    dependMod.getCtManager().CREATIVE_MODE_TAB.register(modEventBus);
                }
            }
        }
    }


    // Used to make this existing
    public static void init() {

    }


}
