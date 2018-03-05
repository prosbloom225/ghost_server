package rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.actions.Attack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestGame {

    @DisplayName("Test Game construction")
    @Test
    void testGameConstruction() {
        // Game game = new Game();
        // assertEquals("testItem", item.getName());
    }

    @DisplayName("Test Game loader")
    @Test
    void testGameLoader() throws InterruptedException {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
        // wait for initialization
        do {
            gameThread.join(100);
        } while (game.getTick() < 3);
        // put attack action on stack
        Attack attack = new Attack(game.getPlayer(), game.getMap().getEntityAtSlot(0,1));
        Attack attackTwo = new Attack(game.getPlayer(), game.getMap().getEntityAtSlot(0,1));
        game.getStack().add(attack);
        game.getStack().add(attackTwo);

        // wait till end
        gameThread.join();

        assertEquals(0, game.getMap().getEntityAtSlot(0,1).getHp());

    }
}
