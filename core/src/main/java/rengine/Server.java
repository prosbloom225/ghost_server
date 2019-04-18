package main.java.rengine;

import main.java.rengine.actions.IAction;
import main.java.rengine.base.BaseMod;
import main.java.rengine.map.Map;
import main.java.rengine.mod.Mod;
import main.java.rengine.mod.Player;
import main.java.rengine.registry.EntityRegistry;
import main.java.rengine.registry.ItemRegistry;
import lombok.Getter;
import org.apache.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Server implements Runnable {
    final static Logger log = Logger.getLogger(Server.class.getName());
    public boolean tickForever = true;
    @Getter private Mod[] mods;
    @Getter private Player player;
    @Getter private Map map;
    @Getter private int tick = 0;

    @Getter private BlockingQueue<IAction> stack;

    public Server() {
        // TODO - load mods as generics
        // for now hardcoding
        mods = new Mod[1];
        mods[0] = new BaseMod();
        //mods[1] = new GhostMod();

        // loader phases
        preinit();
        init();
        postinit();

        // menu
    }

    private void preinit(){
        player = Player.builder()
            .setHp(10)
            .setMaxHp(10)
            .setName("player")
                .setSpriteNum(1795)
            .build();
        // initialize registries
        ItemRegistry.init();
        EntityRegistry.init();
        stack = new LinkedBlockingQueue<IAction>();

        for (Mod mod : mods)
            mod.preinit();
    }
    private void init(){
        map = new Map(16,16);
        map.setEntityAtSlot(0, 0, player);
        for (Mod mod : mods)
            mod.init();
    }
    private void postinit(){
        for (Mod mod : mods)
            mod.postinit();
    }

    public void run(){
        int maxTicks = 10;
        // main game loop
        while (++tick < maxTicks) {
            log.info("Tick: " + tick);
            // world server tick
            // TODO - remove testing entites 
            // testEntities();
            // world server actions tick
            for (IAction action : stack) {
                action.onTick();
            }

            // world server entities tick
            // updateTrackedEntities - dead/alive, gc, etc
            GameManager.collect(this);
            // sync??
            try {
            Thread.sleep(100);
            } catch (InterruptedException e) {
                log.info("Interrupt caught!");
            }
            if (tickForever)
                maxTicks++;
        }
    }
}
