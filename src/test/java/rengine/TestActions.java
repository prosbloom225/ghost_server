package rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.mod.Player;
import com.prosbloom.rengine.base.BaseCreature;
import com.prosbloom.rengine.actions.Attack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
            .setName("creature")
            .build();

        new Attack(player, creature).execute();

        assertEquals("player", player.getName());
        assertEquals(10, player.getHp());
        assertEquals(10, creature.getHp());
    }

}
