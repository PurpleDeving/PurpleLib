package io.purple.purplelib.datagen;

import io.purple.purplelib.Collections;
import io.purple.purplelib.dependency.DependMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStatesProvider extends BlockStateProvider {

    private final DependMod dependMod;

    public ModBlockStatesProvider(PackOutput output, DependMod dependMod, ExistingFileHelper exFileHelper) {
        super(output, dependMod.getModID(), exFileHelper);
        this.dependMod = dependMod;
    }

    @Override //TODO - Add functionality for Block to not get Datagen > Does also need change in BasicBlock class
    protected void registerStatesAndModels() {
        for(DeferredBlock<Block> block: Collections.MODBLOCKS.get(dependMod).values()){
            blockWithItem(block);
        };
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }



}
