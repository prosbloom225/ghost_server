package com.prosbloom.rengine;

import com.prosbloom.rengine.mod.Mod;
import com.prosbloom.rengine.mod.Player;
import com.prosbloom.rengine.registry.EntityRegistry;
import com.prosbloom.rengine.registry.ItemRegistry;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Game {
    private static Mod[] mods;
    private static Player player;

    public static void main(String[] args) {
       lifecycle();
   }

   private static void lifecycle() {
       // initialize registries
       ItemRegistry.init();
       EntityRegistry.init();

       // loader phases
       preinit();
       init();
       postinit();

       // menu
   }

   private static void preinit(){
        player = new Player("Player", 10, 10);
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
}
