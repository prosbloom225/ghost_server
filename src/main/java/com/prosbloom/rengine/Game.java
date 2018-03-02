package com.prosbloom.rengine;

import java.util.ArrayList;
import java.util.List;
import com.prosbloom.rengine.mod.Mod;
import com.prosbloom.rengine.mod.Player;
import com.prosbloom.rengine.base.BaseMod;
import com.prosbloom.rengine.registry.EntityRegistry;
import com.prosbloom.rengine.registry.ItemRegistry;
import com.prosbloom.rengine.actions.IAction;

import org.apache.log4j.Logger;

import com.prosbloom.ghost.GhostMod;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Game {
    final static Logger log = Logger.getLogger(Game.class.getName());
    private static Mod[] mods;
    private static Player player;

    private static List<IAction> stack;

    public static void main(String[] args) {
       loader();
       lifecycle();
   }

   public static void loader() {
       // TODO - load mods as generics
       // for now hardcoding
       mods = new Mod[2];
       mods[0] = new BaseMod();
       mods[1] = new GhostMod();

       // loader phases
       preinit();
       init();
       postinit();

       // menu
   }

   private static void preinit(){
        player = new Player("Player", 10, 10);
        // initialize registries
        ItemRegistry.init();
        EntityRegistry.init();
        stack = new ArrayList<IAction>();

        for (Mod mod : mods)
            mod.preinit();
   }
    private static void init(){
        for (Mod mod : mods)
            mod.init();
    }
    private static void postinit(){
        for (Mod mod : mods)
            mod.postinit();
    }

    public static void lifecycle(){
        int tick = 0;
        int maxTicks = 10;
        // main game loop
        while (++tick < maxTicks) {
            log.info("Tick: " + tick);
            // world server tick
            // world server actions tick
            for (IAction action : stack) {
            }

            // world server entities tick
            // updateTrackedEntities - dead/alive, gc, etc
            // sync??
        }
    }
}
