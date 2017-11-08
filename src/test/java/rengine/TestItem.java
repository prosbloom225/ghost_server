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

    @DisplayName("Generate basic item")
    @Test
    void testBasicItem() {
        BaseItem item = new ItemFactory().build()
                .setName("testItem1")
                .setIlvl(1)
                .execute();
        assertEquals("testItem1", item.getName());
    }
    @DisplayName("Generate multiple basic items")
    @Test
    void testBasicItems() {
        BaseItem item1 = new ItemFactory().build()
                .setName("testItem1")
                .setIlvl(1)
                .execute();
        BaseItem item2 = new ItemFactory().build()
                .setName("testItem2")
                .setIlvl(2)
                .execute();
        assertEquals("testItem1", item1.getName());
        assertEquals("testItem2", item2.getName());
    }

}
