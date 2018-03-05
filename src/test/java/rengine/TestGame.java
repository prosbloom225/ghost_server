package rengine;

import com.prosbloom.rengine.Game;
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
        Game game = new Game();
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
            gameThread.join(1000);
        } while (game.getTick() < 3);

        // game.loader();
        // assertEquals("testItem", item.getName());
    }
}
