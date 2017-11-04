package rengine;

import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.registry.ItemRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class TestItemRegistry {

    @BeforeEach
    void initItemRegistry() {
        ItemRegistry.init();
    }

    @DisplayName("Add single item")
    @Test
    void testAddSingleItem() {
        BaseItem item = new BaseItem("testItem1");
        assertEquals(ItemRegistry.addItem(item), "base:testItem1");
    }

    @DisplayName("Add multiple items")
    @Test
    void testMultiItem() {
        BaseItem item0 = new BaseItem("testItem0");
        BaseItem item1 = new BaseItem("testItem1");
        BaseItem item2 = new BaseItem("testItem2");
        ItemRegistry.addItem(item0);
        ItemRegistry.addItem(item1);
        ItemRegistry.addItem(item2);
        assertEquals(ItemRegistry.getItem("base:testItem0").getName(), item0.getName());
        assertEquals(ItemRegistry.getItem("base:testItem1").getName(), item1.getName());
        assertEquals(ItemRegistry.getItem("base:testItem2").getName(), item2.getName());
    }

    @DisplayName("Overwrite item at id")
    @Test
    void testOverwrite() {
        BaseItem item0 = new BaseItem("testItem0");
        BaseItem item1 = new BaseItem("NEWtestItem0");
        ItemRegistry.addItem("base:testItem0", item0);
        ItemRegistry.addItem("base:testItem0", item1);
        assertEquals(ItemRegistry.getItem("base:testItem0").getName(), item1.getName());
    }

    @DisplayName("Check item instancing")
    @Test
    void testInstance() {
        // add default item
        BaseItem item0 = new BaseItem("testItem0");
        ItemRegistry.addItem(item0);
        // get item and modify
        BaseItem item1 = ItemRegistry.getItem("base:testItem0");
        item1.setName("test");
        // check for unmodified
        assertEquals("testItem0", ItemRegistry.getItem("base:testItem0").getName());
    }
}
