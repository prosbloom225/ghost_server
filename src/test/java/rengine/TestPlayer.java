package rengine;

import com.prosbloom.rengine.base.BaseCreature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestPlayer {

    @DisplayName("Test Creature construction")
    @Test
    void testCreatureConstruction() {
        BaseCreature creatureOne = BaseCreature.builder()
            .setXp(2)
            .setLevel(2)
            .setStrength(11)
            .setConstitution(12)
            .setDexterity(13)
            .setIntelligence(14)
            .setWisdom(15)
            .setCharisma(16)
            .setName("creatureOne")
            .build();
        System.out.println(creatureOne);

        assertEquals(2, creatureOne.getXp());
        assertEquals(2, creatureOne.getLevel());
        assertEquals("creatureOne", creatureOne.getName());
        assertEquals(11, creatureOne.getStrength());
        assertEquals(12, creatureOne.getConstitution());
        assertEquals(13, creatureOne.getDexterity());
        assertEquals(14, creatureOne.getIntelligence());
        assertEquals(15, creatureOne.getWisdom());
        assertEquals(16, creatureOne.getCharisma());
    }

}
