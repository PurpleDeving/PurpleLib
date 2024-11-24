package io.purple.purplelib.datagen;

import io.purple.purplelib.Collections;
import io.purple.purplelib.dependency.DependMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    private final DependMod dependMod;

    public ModItemModelProvider(PackOutput output, DependMod dependMod, ExistingFileHelper existingFileHelper) {
        super(output, dependMod.getModID(), existingFileHelper);
        this.dependMod = dependMod;
    }

    @Override
    protected void registerModels() {
        for(DeferredItem<Item> item: Collections.MODITEMS.get(dependMod).values()){
            basicItem(item.get());
        };
    }
}
