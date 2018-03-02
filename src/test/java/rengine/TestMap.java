package rengine;

import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.map.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

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

    @DisplayName("Test Map entity dump")
    @Test
    void testMapDump() {
        Map map = new Map();
        BaseEntity entityOne = BaseEntity.builder()
            .setName("entityOne")
            .build();

        map.setEntityAtSlot(1,1,entityOne);
        List<BaseEntity> entities = map.getEntities();

        assertEquals(1, entities.size());
        assertEquals("entityOne", entities.get(0).getName());


        BaseEntity entityTwo = BaseEntity.builder()
            .setName("entityTwo")
            .build();
        map.setEntityAtSlot(1,2,entityOne);
        entities = map.getEntities();
        assertEquals(2, entities.size());

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
    @DisplayName("Test moving entity")
    @Test
    void testMovingEntity() {
        Map map = new Map();
        BaseEntity entityOne = BaseEntity.builder()
            .setName("entityOne")
            .build();
        BaseEntity entityTwo = BaseEntity.builder()
            .setName("entityTwo")
            .build();

        map.setEntityAtSlot(0,0,entityOne);
        map.setEntityAtSlot(0,1,entityTwo);
        // negative test 
        assertEquals(false, map.moveEntity(0,0,0,1));
        assertEquals(false, map.moveEntity(0,0,111,111));
        // positive test
        assertEquals(true, map.moveEntity(0,0,1,1));

    }
}
