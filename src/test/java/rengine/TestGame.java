package rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.actions.Attack;
import com.prosbloom.rengine.actions.Move;
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

    @DisplayName("Test Game basic actions")
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

        do {
            gameThread.join(100);
        } while (game.getTick() < 6);
        // put move action on stack
        Move move = new Move(game.getMap().getSlot(0,0), 1, 0, game.getMap());
        game.getStack().add(move);

        // wait till end
        gameThread.join();

        assertEquals(80, game.getMap().getEntityAtSlot(0,1).getHp());
        assertEquals("player", game.getMap().getEntityAtSlot(1,0).getName());

    }
    @DisplayName("Test GameManager")
    @Test
    void testGameManager() throws InterruptedException {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
        // wait for initialization
        do {
            gameThread.join(100);
        } while (game.getTick() < 3);

        game.getMap().getEntityAtSlot(0,0).setHp(0);

        // wait till end
        gameThread.join();

        assertEquals(null, game.getMap().getEntityAtSlot(1,0));

    }
}
