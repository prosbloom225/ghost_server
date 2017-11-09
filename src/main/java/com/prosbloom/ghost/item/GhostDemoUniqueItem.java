package com.prosbloom.ghost.item;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.base.BaseSalience;
import com.prosbloom.rengine.item.ITickable;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostDemoUniqueItem extends BaseSalience implements ITickable{
    final static Logger log = Logger.getLogger(GhostDemoUniqueItem.class.getName());

    public void tick() {
        log.debug("TICK!");
    }

    public GhostDemoUniqueItem() {
    }
}
