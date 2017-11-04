package ghost;

import com.prosbloom.ghost.item.ModItem;
import com.prosbloom.ghost.mod.ModItems;
import com.prosbloom.rengine.registry.ItemRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class TestGhostItems {
    @BeforeEach
    void initModItems() {
        ItemRegistry.init();

        // initialize mod items
        //ModItems.registerItems();
    }

    @DisplayName("Test mod item")
    @Test
    void testItem() {
        ModItem testItem0 = new ModItem("testModItem0");
        ModItems.register(testItem0);
        assertEquals("testModItem0", ItemRegistry.getItem("ghost:testModItem0").getName());
    }
}



