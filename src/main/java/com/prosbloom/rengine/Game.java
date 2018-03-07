package com.prosbloom.rengine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import com.prosbloom.rengine.mod.Mod;
import com.prosbloom.rengine.mod.Player;
import com.prosbloom.rengine.base.BaseCreature;
import com.prosbloom.rengine.map.Map;
import com.prosbloom.rengine.base.BaseMod;
import com.prosbloom.rengine.registry.EntityRegistry;
import com.prosbloom.rengine.registry.ItemRegistry;
import com.prosbloom.rengine.actions.IAction;

import org.apache.log4j.Logger;
import lombok.Getter;

import com.prosbloom.ghost.GhostMod;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Game implements Runnable {
    final static Logger log = Logger.getLogger(Game.class.getName());
    private Mod[] mods;
    @Getter private Player player;
    @Getter private Map map;
    @Getter private int tick = 0;

    @Getter private BlockingQueue<IAction> stack;

    public Game() {
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

    private void preinit(){
        player = Player.builder()
            .setHp(10)
            .setMaxHp(10)
            .setName("player")
            .build();
        // initialize registries
        ItemRegistry.init();
        EntityRegistry.init();
        stack = new LinkedBlockingQueue<IAction>();

        for (Mod mod : mods)
            mod.preinit();
    }
    private void init(){
        map = new Map();
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
            testEntities();
            // world server actions tick
            for (IAction action : stack) {
                action.onTick();
            }

            // world server entities tick
            // updateTrackedEntities - dead/alive, gc, etc
            // sync??
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info("Interrupt caught!");
            }
        }
    }
    private void testEntities() {
        if (!map.getEntities().stream()
                .anyMatch(e->e.getName().equals("testCreatureOne"))){
            log.info("Creating testCreatureOne");
            BaseCreature creatureOne = BaseCreature.builder()
                .setXp(2)
                .setLevel(2)
                .setStrength(11)
                .setConstitution(12)
                .setDexterity(13)
                .setIntelligence(14)
                .setWisdom(15)
                .setCharisma(16)
                .setName("testCreatureOne")
                .setHp(20)
                .build();
            map.setEntityAtSlot(0,1, creatureOne);
                }
    }
}
