package rengine;

import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.RandomItemFactory;
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
        BaseItem item = BaseItem.builder()
                .setName("testItem")
                .build();

        assertEquals("testItem", item.getName());
    }

    @DisplayName("Generate basic item")
    @Test
    void testBasicItem() {
        BaseItem item = BaseItem.builder()
                .setIlvl(1)
                .setName("testItem1")
                .build();
        assertEquals("testItem1", item.getName());
        assertEquals("base", item.getModName());
    }
    @DisplayName("Generate multiple basic items")
    @Test
    void testBasicItems() {
        BaseItem item1 = BaseItem.builder()
                .setIlvl(1)
                .setName("testItem1")
                .build();
        BaseItem item2 = BaseItem.builder()
                .setIlvl(2)
                .setName("testItem2")
                .build();
        assertEquals("testItem1", item1.getName());
        assertEquals("testItem2", item2.getName());
    }
    @DisplayName("Test basic item generation")
    @Test
    void TestRNGItem() {
        RandomItemFactory factory = new RandomItemFactory();
        BaseItem item = factory.generate(17);
        assertEquals(17, item.getIlvl());
        assertEquals("base", item.getModName());
    }

}
