package rengine;

import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.ItemFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestItem {

    @DisplayName("Test generic item factory")
    @Test
    void testGenericItemFactory() {
        ItemFactory factory = new ItemFactory();
        BaseItem item = factory.build(BaseItem.class)
                .setName("testItem")
                .create();
        assertEquals("testItem", item.getName());
    }

    @DisplayName("Generate basic item")
    @Test
    void testBasicItem() {
        BaseItem item = new ItemFactory().build()
                .setName("testItem1")
                .setIlvl(1)
                .create();
        assertEquals("testItem1", item.getName());
    }
    @DisplayName("Generate multiple basic items")
    @Test
    void testBasicItems() {
        BaseItem item1 = new ItemFactory().build()
                .setName("testItem1")
                .setIlvl(1)
                .create();
        BaseItem item2 = new ItemFactory().build()
                .setName("testItem2")
                .setIlvl(2)
                .create();
        assertEquals("testItem1", item1.getName());
        assertEquals("testItem2", item2.getName());
    }

}
