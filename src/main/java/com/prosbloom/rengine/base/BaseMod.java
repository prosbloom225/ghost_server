package com.prosbloom.rengine.base;

import com.prosbloom.rengine.mod.Mod;
import org.apache.log4j.Logger;


public class BaseMod extends Mod {
    final static Logger log = Logger.getLogger(BaseMod.class.getName());

    // loader lifecycle
    public void preinit(){ 
        log.info("BaseMod preInit called");
    }
    public void init() {
        log.info("BaseMod Init called");
    }
    public void postinit() {
        log.info("BaseMod postInit called");
    }
}
