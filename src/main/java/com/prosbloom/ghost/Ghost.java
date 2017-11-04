package com.prosbloom.ghost;

import com.prosbloom.ghost.mod.ModItems;
import com.prosbloom.rengine.mod.Mod;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Ghost extends Mod {

    @Override
    public void preinit() {

    }

    @Override
    public void init() {
        // load items
        ModItems.registerItems();

    }

    @Override
    public void postinit() {

    }
}
