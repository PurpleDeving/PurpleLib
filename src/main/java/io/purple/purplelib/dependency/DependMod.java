package io.purple.purplelib.dependency;

import io.purple.purplelib.item.BasicItem;

import java.util.ArrayList;
import java.util.HashMap;

public class DependMod {

    public static final ArrayList<DependMod> dependMods = new ArrayList<>();

    public final String modID;



    public DependMod(String modID) {
        this.modID = modID;
        dependMods.add(this);
    }
}
