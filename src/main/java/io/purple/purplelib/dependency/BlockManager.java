package io.purple.purplelib.dependency;

import io.purple.purplelib.Collections;
import io.purple.purplelib.block.BasicBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;

public class BlockManager {

    public final DependMod parent;
    public final DeferredRegister.Blocks BLOCKS;


    public BlockManager(DependMod parent) {
        this.parent = parent;
        BLOCKS = DeferredRegister.createBlocks(parent.getModID());
    }

    // Main Way to add Basic Blocks
    public void addBasicBlock(String name){
        addBasicBlock(name, BlockBehaviour.Properties.of());
    }

    // Main Way to add
    public void addBasicBlock(String name, BlockBehaviour.Properties properties){
        // Ensure the outer map entry for the source mod exists
        Collections.MODBLOCKS.putIfAbsent(parent, new HashMap<>());
        Collections.MODITEMS.putIfAbsent(parent, new HashMap<>()); // Needed for Block Items

        DeferredBlock<Block> block = this.BLOCKS.register(name, ()-> new BasicBlock(name, properties));
        Collections.MODBLOCKS.get(parent).put(name, block);
        parent.getIManager().addSimpleBlockItem(name,block);



    }

}
