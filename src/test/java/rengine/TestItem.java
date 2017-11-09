package rengine;

import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.ItemBuilder;
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
        BaseItem item = ItemFactory.build("testItem").create();
        assertEquals("testItem", item.getName());
    }

    @DisplayName("Generate basic item")
    @Test
    void testBasicItem() {
        BaseItem item = ItemFactory.build("testItem1")
                .setIlvl(1)
                .create();
        assertEquals("testItem1", item.getName());
    }
    @DisplayName("Generate multiple basic items")
    @Test
    void testBasicItems() {
        BaseItem item1 = ItemFactory.build("testItem1")
                .setIlvl(1)
                .create();
        BaseItem item2 = ItemFactory.build("testItem2")
                .setIlvl(2)
                .create();
        assertEquals("testItem1", item1.getName());
        assertEquals("testItem2", item2.getName());
    }

}
