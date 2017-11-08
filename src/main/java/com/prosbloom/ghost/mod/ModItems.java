package com.prosbloom.ghost.mod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.registry.ItemRegistry;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItems {
    final static Logger log = Logger.getLogger(ModItems.class.getName());

    public static void register(ModItem item) {
        ItemRegistry.addItem(item);
    }
    public static void registerItems(){
        // add all items to the registry
    }

    private static void loadItems() {

        try {
            File f = new File(ModItems.class.getClassLoader().getResource("ghost/item/Uniques.json").getPath());
            ObjectMapper om = new ObjectMapper();
            Map<String, String> json = om.readValue(f, HashMap.class);
        } catch (IOException  e)  {
        }
    }

    private static ModItem loadItemFromJson(Map<String, String> json) {
        // handle nonjava backed items first
        ModItem item = new ModItem("", 0);
        return item;
    }
}
