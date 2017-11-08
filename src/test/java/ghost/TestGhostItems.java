package ghost;

import com.prosbloom.ghost.factory.GhostItemGenerator;
import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.item.GhostDemoUniqueItem;
import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.ghost.mod.ModItems;
import com.prosbloom.rengine.base.BaseItem;
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
        ModItem testItem0 = new ModItem("testModItem0", 0);
        ModItems.register(testItem0);
        assertEquals("testModItem0", ItemRegistry.getItem("ghost:testModItem0").getName());
    }

    @DisplayName("Test random mod item")
    @Test
    void testRandomItem() {
        GhostItemGenerator gig = new GhostItemGenerator();
        BaseItem item = gig.generate(17);
        // check all properties
        assertEquals(LibMisc.MODNAME, item.getModName());
        assertEquals(17, item.getIlvl());
    }

    @DisplayName("Test random weapon")
    @Test
    void testRandomWeapon() {
        GhostItemGenerator gig = new GhostItemGenerator();
        BaseItem item = gig.generate(17, LibMisc.ITYPE.weapon);
        // check weapon properties
        assertEquals(17, item.getIlvl());
        // TODO - add weapon properties
    }

    @DisplayName("Test random armor")
    @Test
    void testRandomArmor() {
        GhostItemGenerator gig = new GhostItemGenerator();
        BaseItem item = gig.generate(17, LibMisc.ITYPE.armor);
        // check weapon properties
        assertEquals(17, item.getIlvl());
        // TODO - add armor properties
    }

    @DisplayName("Test unique weapon")
    @Test
    void testUniqueWeapon() {
        GhostDemoUniqueItem item = new GhostDemoUniqueItem(17);
        // check weapon properties
        assertEquals(17, item.getIlvl());
    }
    @DisplayName("Test bulk loader from json - no java backed")
    @Test
    void testBasicBulkItemLoad() {
        ModItems.registerItems();
    }
}
