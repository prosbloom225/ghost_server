package com.prosbloom.rengine;

import com.prosbloom.rengine.Game;
import com.prosbloom.rengine.actions.IAction;
import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.map.Map;

import org.apache.log4j.Logger;

public class GameManager{
    final static Logger log = Logger.getLogger(GameManager.class.getName());

    public static void collect (Game game) {
        Map map = game.getMap();
        // hp
        for (int x=0;x<map.getWidth();x++){
            for (int y=0;y<map.getHeight();y++) {
                if (!map.getSlot(x,y).isEmpty()){
                    BaseEntity entity = map.getEntityAtSlot(x,y);
                    if (entity.getHp() <= 0){
                        log.info("Entity has died: " + entity.getName());
                        entity.death();
                        map.setEntityAtSlot(x,y,null);
                    }
                }
            }
            // stack
            for (IAction action : game.getStack()) {
                if (action.isDone()) {
                    game.getStack().remove(action);
                    log.info("Action complete: " + action);
                }
            }
        }
    }
}
