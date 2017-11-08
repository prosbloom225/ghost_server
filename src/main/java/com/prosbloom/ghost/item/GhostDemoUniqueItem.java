package com.prosbloom.ghost.item;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosbloom.ghost.base.ModItem;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostDemoUniqueItem extends ModItem{
    final static Logger log = Logger.getLogger(GhostDemoUniqueItem.class.getName());

    public GhostDemoUniqueItem(int ilvl) {
        super("", ilvl);
        try {
        JsonFactory factory = new JsonFactory();
        ObjectMapper om = new ObjectMapper();
        Map<String, String> json = om.readValue(getClass().getClassLoader().getResource("ghost/item/Uniques.json"), HashMap.class);
        log.debug("Map: "  + json.toString());
        log.debug("Item: " + this.toString());
        } catch (IOException e) {
            log.warn("Could not parse item: " + this.getName());
        }
    }
}
