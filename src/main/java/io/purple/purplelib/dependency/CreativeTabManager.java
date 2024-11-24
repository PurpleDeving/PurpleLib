package io.purple.purplelib.dependency;

import io.purple.purplelib.Collections;
import io.purple.purplelib.creativetab.CreativeTab;
import io.purple.purplelib.item.BasicItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabManager {


    public final DependMod parent;

    public final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB;

    // Icon of the creative Tab of this mod
    private DeferredItem<? extends Item> creativeTabIcon;

    public CreativeTabManager(DependMod parent) {
        this.parent = parent;

        CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, parent.getModID());
    }

    public void addCreativeTabIcon(DeferredItem<Item> item){
        creativeTabIcon = item;
        // When the creativeTab doesnt exist, you might as well create it now
        if(Collections.CREATIVE_MODE_TABS.get(parent) == null){
            setCreativeTab();
        }
    }

    private void setCreativeTab(){
        Collections.CREATIVE_MODE_TABS.put(parent,CREATIVE_MODE_TAB.register(parent.getModID() + "_tab",
                ()-> CreativeTab.builder().icon(()->new ItemStack((Item) creativeTabIcon.asItem()))
                        .title(Component.translatable(parent.getModID() + "_tab"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            // The creative tab should accept all items from that mod
                            for (DeferredItem<? extends Item> item: Collections.MODITEMS.get(parent).values()){
                                output.accept(item);
                            }
                            for (DeferredItem<? extends Item> item: Collections.MODBLOCKITEMS.get(parent).values()){
                                output.accept(item);
                            }
                        })).build()));
    }


}
