package rengine;

import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.ItemBuilder;
import com.prosbloom.rengine.factory.ItemFactory;
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

    @DisplayName("Test single item")
    @Test
    void testAddSingleItem() {
       BaseItem item = ItemFactory.build("testItem1").create();
        assertEquals(ItemRegistry.addItem(item), "base:testItem1");
    }

    @DisplayName("Add multiple items")
    @Test
    void testMultiItem() {
        int size = 100;
        BaseItem[] items = new BaseItem[size];
        for (int i=0;i<size;i++) {
            items[i] = ItemFactory.build("testItem" + i)
                    .create();
            ItemRegistry.addItem(items[i]);
        }
        for (int i=0;i<size;i++)
            assertEquals(ItemRegistry.getItem("base:testItem" + i).getName(), items[i].getName());
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
