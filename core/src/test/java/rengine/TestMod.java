package rengine;

import main.java.rengine.Server;
import main.java.rengine.base.BaseCreature;
import main.java.rengine.mod.PlayerActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestMod {
    private int waitMs = 100;
    private Server server;
    private Thread gameThread;

    private void waitTick(int ticks) {
        ticks += server.getTick();
        try {
        do {
            gameThread.join(waitMs);
        } while (server.getTick() < ticks);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
        }
    }
    @BeforeEach
    public  void init() {
        server = new Server();
        gameThread = new Thread(server);
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
            .setHp(100)
            .build();
        server.getMap().setEntityAtSlot(0,1, creatureOne);
        gameThread.start();
        // wait for initialization
        waitTick(1);
    }

    @DisplayName("Test BaseMod construction")
    @Test
    void testGameConstruction() {
        System.out.println(PlayerActions.dumpActions());
        assertEquals("player", server.getPlayer().getName());
        assertEquals(PlayerActions.isRegisteredAction("Attack"), true);
    }
}
