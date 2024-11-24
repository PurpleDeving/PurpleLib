package io.purple.purplelib;

import io.purple.purplelib.block.BasicBlock;
import io.purple.purplelib.dependency.DependMod;
import io.purple.purplelib.item.BasicItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.function.Supplier;

public class Collections {

    // The "storage" of the Objects registered in the managers

    public static final HashMap<DependMod, HashMap<String, DeferredItem<Item>>> MODITEMS = new HashMap<>();

    public static final HashMap<DependMod, HashMap<String, DeferredBlock<Block>>> MODBLOCKS = new HashMap<>();
    public static final HashMap<DependMod, HashMap<String, DeferredItem<Item>>> MODBLOCKITEMS = new HashMap<>();

    public static final HashMap<DependMod, Supplier<CreativeModeTab>> CREATIVE_MODE_TABS = new HashMap<>();
}
