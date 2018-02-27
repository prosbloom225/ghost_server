package com.prosbloom.ghost;

import org.apache.log4j.Logger;
import com.prosbloom.ghost.mod.ModItems;
import com.prosbloom.rengine.mod.Mod;

/**
 * Created by prosbloom on 11/4/17.
 */
public class GhostMod extends Mod {
    final static Logger log = Logger.getLogger(GhostMod.class.getName());

    @Override
    public void preinit() {
        log.info("GhostMod preInit called");
    }

    @Override
    public void init() {
        log.info("GhostMod Init called");
        // load items
        ModItems.registerItems();
    }

    @Override
    public void postinit() {
        log.info("GhostMod postInit called");
    }
}
