package main.java.rengine.base;

import main.java.rengine.mod.Mod;
import main.java.rengine.actions.Move;
import main.java.rengine.actions.Attack;
import main.java.rengine.mod.PlayerActions;
import org.apache.log4j.Logger;


public class BaseMod extends Mod {
    final static Logger log = Logger.getLogger(BaseMod.class.getName());

    // loader lifecycle
    public void preinit(){ 
        log.info("BaseMod preInit called");
        PlayerActions.init();
    }
    public void init() {
        log.info("BaseMod Init called");
        PlayerActions.register(Move.class);
        PlayerActions.register(Attack.class);
    }
    public void postinit() {
        log.info("BaseMod postInit called");
        log.info("Player Actions: " + PlayerActions.count());
    }
}
