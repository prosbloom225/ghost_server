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
    void testGameLoader() {
        Game game = new Game();
        game.loader();
        // assertEquals("testItem", item.getName());
    }
}
