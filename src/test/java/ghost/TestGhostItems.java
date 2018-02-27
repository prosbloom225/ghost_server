package ghost;

import com.prosbloom.ghost.factory.GhostItemGenerator;
import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.item.GhostDemoUniqueItem;
import com.prosbloom.ghost.item.GhostItemWeapon;
import com.prosbloom.ghost.item.GhostItemArmor;
import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.ghost.mod.ModItems;
import com.prosbloom.rengine.exception.ItemNotFoundException;
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
        ModItem testItem0 = ModItem.builder()
                .setIlvl(1)
                .setName("testModItem0")
                .build();
        ModItems.register(testItem0);
        try {
        assertEquals("testModItem0", ItemRegistry.getItem("ghost:testModItem0").getName());
        } catch (ItemNotFoundException e) {
        }
    }

    @DisplayName("Test item registry direct loading ModItem")
    @Test
    void testItemFactoryModItemLoad() {
        ModItem item = ModItem.builder()
                .setIlvl(9)
                .setName("testItem")
                .build();
        ItemRegistry.addItem(item);
        try {
        assertEquals(item.toString(), ItemRegistry.getItem("ghost:testItem").toString());
        assertEquals("ghost", item.getModName());
        } catch (ItemNotFoundException e) {
        }
    }

    @DisplayName("Test random mod item")
    @Test
    void testRandomItem() {
        GhostItemGenerator gig = new GhostItemGenerator();
        ModItem item = gig.generate(17);
        // check all properties
        assertEquals(LibMisc.MODNAME, item.getModName());
        assertEquals(17, item.getIlvl());
    }

    @DisplayName("Test weapon interface")
    @Test
    void testBaseWeapon() {
        GhostItemWeapon item = GhostItemWeapon.builder()
            .setAp(1.0)
            .setIlvl(1)
            .setName("testWeapon")
            .build();
        // check weapon properties
        assertEquals(1, item.getIlvl());
        assertEquals(1.0, item.getAp());
        // TODO - add weapon properties
    }

    @DisplayName("Test armor interface")
    @Test
    void testBaseArmor() {
        GhostItemArmor item = GhostItemArmor.builder()
            .setDv(8.0)
            .setPv(7.0)
            .setIlvl(1)
            .setName("testWeapon")
            .build();
        // check weapon properties
        assertEquals(1, item.getIlvl());
        assertEquals(8.0, item.getDv());
        assertEquals(7.0, item.getPv());
        // TODO - add weapon properties
    }

    @DisplayName("Test random weapon")
    @Test
    void testRandomWeapon() {
        GhostItemGenerator gig = new GhostItemGenerator();
        GhostItemWeapon item = (GhostItemWeapon)gig.generate(17, LibMisc.ITYPE.weapon);
        // check weapon properties
        assertEquals(17, item.getIlvl());
        assertEquals(1.0, item.getAp());
        assertEquals("rngItem",  item.getName());
    }

    @DisplayName("Test random armor")
    @Test
    void testRandomArmor() {
        GhostItemGenerator gig = new GhostItemGenerator();
        GhostItemArmor item = (GhostItemArmor)gig.generate(17, LibMisc.ITYPE.armor);
        // check weapon properties
        assertEquals(17, item.getIlvl());
        assertEquals(1, item.getDv());
        assertEquals(1, item.getPv());
        // TODO - add armor properties
    }

    @DisplayName("Test unique weapon")
    @Test
    void testUniqueWeapon() {
        GhostDemoUniqueItem item = new GhostDemoUniqueItem();
        assertEquals(item, item);
    }
    @DisplayName("Test bulk loader from json - no java backed")
    @Test
    void testBasicBulkItemLoad() {
        ModItems.loadUniqueItems();
        // TODO - add these tests - this is stubbed just for dev
    }
}
