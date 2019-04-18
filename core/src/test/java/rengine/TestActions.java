package rengine;

import main.java.rengine.actions.Attack;
import main.java.rengine.actions.Move;
import main.java.rengine.base.BaseCreature;
import main.java.rengine.map.Map;
import main.java.rengine.mod.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by prosbloom on 11/7/17.
 */
public class TestActions {

    @DisplayName("Test Attack")
    @Test
    void testAttack () {
        Player player = Player.builder()
            .setHp(10)
            .setMaxHp(10)
            .setName("player")
            .build();
        BaseCreature creature = BaseCreature.builder()
            .setHp(20)
            .setMaxHp(20)
            .setPv(20)
            .setName("creature")
            .build();

        new Attack(player, creature).execute();

        assertEquals("player", player.getName());
        assertEquals(10, player.getHp());
        assertEquals(12, creature.getHp());
    }

    @DisplayName("Test Move")
    @Test
    void testMove() {
        Map map = new Map();
        Player player = Player.builder()
            .setHp(10)
            .setMaxHp(10)
            .setName("player")
            .build();
        map.setEntityAtSlot(0,0, player);
        new Move(map.getSlot(0,0), 1, 0, map).execute();

        assertEquals(player, map.getSlot(1,0).getEntity());
    }


}
