package rengine;

import main.java.rengine.Server;
import main.java.rengine.actions.Attack;
import main.java.rengine.actions.Teleport;
import main.java.rengine.base.BaseCreature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestGame {
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
        server.tickForever = false;
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

    @DisplayName("Test Game construction")
    @Test
    void testGameConstruction() {
        assertEquals("player", server.getPlayer().getName());
    }

    @DisplayName("Test Game basic actions")
    @Test
    void testGameLoader() throws InterruptedException {
        // put attack action on stack
        server.getStack().add(
                new Attack(server.getPlayer(),
                    server.getMap().getEntityAtSlot(0,1)));
        waitTick(1);
        server.getStack().add(new Attack(
                    server.getPlayer(),
                    server.getMap().getEntityAtSlot(0,1)));

        waitTick(1);
        // put move action on stack
        server.getStack().add(
                new Teleport(server.getMap().getSlot(0,0), 1, 0, server.getMap()));

        // wait till end
        gameThread.join();

        assertEquals(80, server.getMap().getEntityAtSlot(0,1).getHp());
        assertEquals("player", server.getMap().getEntityAtSlot(1,0).getName());

    }
    @DisplayName("Test GameManager")
    @Test
    void testGameManager() throws InterruptedException {
        server.getMap().getEntityAtSlot(0,0).setHp(0);

        // wait till end
        gameThread.join();

        assertEquals(null, server.getMap().getEntityAtSlot(1,0));

    }
}
