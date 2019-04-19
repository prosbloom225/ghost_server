package main.java.rengine.actions;

import main.java.rengine.map.Map;
import main.java.rengine.map.Slot;
import org.apache.log4j.Logger;


public class Move implements IAction {
    final static Logger log = Logger.getLogger(Move.class.getName());
    private int tick = 0;
    private Slot slot;
    private Map map;
    private int x, y;
    private boolean done = false;

    // TODO - should probably track the initiating entity
    // if it dies, we will be moving whatever is in the slot instead
    public Move(Slot slot, int x, int y, Map map){
        this.slot = slot;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public void onTick(){
        if (++tick == 1) {
            this.execute();
        }
    }
    public void execute() {
        log.info("Moving entity from: " + slot.x + "," + slot.y + "to: " + x + "," + y);
        if (map.canMove(slot.x, slot.y, x, y)) {
            map.moveEntity(slot.x, slot.y, x, y);
            done = true;
        } 
        // TODO - handle failed moves
    }
    public boolean isDone() {
        return done;
    }

    public String getName() {
        return this.getClass().getName();
    }
}
