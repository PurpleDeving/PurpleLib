package io.purple.purplelib.dependency;

import java.util.ArrayList;

// Goal: Handle the aspects of all dependency Mods
public class DependMod {

    public static final ArrayList<DependMod> dependMods = new ArrayList<>();

    private final String modID;

    private final ItemManager IManager;
    private final CreativeTabManager ctManager;
    private final BlockManager BManager;


    public DependMod(String modID) {
        this.modID = modID;
        dependMods.add(this);
        IManager = new ItemManager(this);
        ctManager = new CreativeTabManager(this);
        BManager = new BlockManager(this);
    }


    /***************************************
    *
    *  GETTER
    *
    * *************************************/

    public String getModID() {
        return modID;
    }

    public ItemManager getIManager() {
        return IManager;
    }

    public CreativeTabManager getCtManager() {
        return ctManager;
    }

    public BlockManager getBManager() {
        return BManager;
    }
}
