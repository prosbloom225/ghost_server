package rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.base.BaseCreature;
import com.prosbloom.rengine.actions.Attack;
import com.prosbloom.rengine.actions.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestGame {
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

    @DisplayName("Test Game construction")
    @Test
    void testGameConstruction() {
        assertEquals("player", game.getPlayer().getName());
    }

    @DisplayName("Test Game basic actions")
    @Test
    void testGameLoader() throws InterruptedException {
        // put attack action on stack
        game.getStack().add(
                new Attack(game.getPlayer(), 
                    game.getMap().getEntityAtSlot(0,1)));
        waitTick(1);
        game.getStack().add(new Attack(
                    game.getPlayer(), 
                    game.getMap().getEntityAtSlot(0,1)));

        waitTick(1);
        // put move action on stack
        game.getStack().add(
                new Move(game.getMap().getSlot(0,0), 1, 0, game.getMap()));

        // wait till end
        gameThread.join();

        assertEquals(80, game.getMap().getEntityAtSlot(0,1).getHp());
        assertEquals("player", game.getMap().getEntityAtSlot(1,0).getName());

    }
    @DisplayName("Test GameManager")
    @Test
    void testGameManager() throws InterruptedException {
        game.getMap().getEntityAtSlot(0,0).setHp(0);

        // wait till end
        gameThread.join();

        assertEquals(null, game.getMap().getEntityAtSlot(1,0));

    }
}
