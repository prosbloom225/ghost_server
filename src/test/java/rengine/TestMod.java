package rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.base.BaseCreature;
import com.prosbloom.rengine.mod.PlayerActions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestMod {
    private int waitMs = 100;
    private Game game;
    private Thread gameThread;

    private void waitTick(int ticks) {
        ticks += game.getTick();
        try {
        do {
            gameThread.join(waitMs);
        } while (game.getTick() < ticks);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
        }
    }
    @BeforeEach
    public  void init() {
        game = new Game();
        gameThread = new Thread(game);
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
        game.getMap().setEntityAtSlot(0,1, creatureOne);
        gameThread.start();
        // wait for initialization
        waitTick(1);
    }

    @DisplayName("Test BaseMod construction")
    @Test
    void testGameConstruction() {
        System.out.println(PlayerActions.dumpActions());
        assertEquals("player", game.getPlayer().getName());
        assertEquals(PlayerActions.isRegisteredAction("Attack"), true);
    }
}
