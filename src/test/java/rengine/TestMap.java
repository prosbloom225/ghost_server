package rengine;

import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.map.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestMap {

    @DisplayName("Test Map construction")
    @Test
    void testMapConstruction() {
        Map map = new Map();
        BaseEntity entityOne = BaseEntity.builder()
            .setName("entityOne")
            .build();

        map.setEntityAtSlot(1,1,entityOne);

        assertEquals("entityOne", map.getEntityAtSlot(1,1).getName());
    }

    @DisplayName("Test Map entity collision")
    @Test
    void testMapOverwrite() {
        Map map = new Map();
        BaseEntity entityOne = BaseEntity.builder()
            .setName("entityOne")
            .build();
        BaseEntity entityTwo = BaseEntity.builder()
            .setName("entityTwo")
            .build();

        map.setEntityAtSlot(1,1,entityOne);
        map.setEntityAtSlot(1,1,entityTwo);

        assertEquals("entityTwo", map.getEntityAtSlot(1,1).getName());
    }
}
