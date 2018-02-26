package com.prosbloom.ghost.mod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.model.ModItemModel;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.registry.ItemRegistry;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItems {
    final static Logger log = Logger.getLogger(ModItems.class.getName());

    public static void register(ModItem item) {
        log.info("Registering item: " + item.toString());
        ItemRegistry.addItem(item);
    }
    // TODO - no overloads should be required for register
    public static void register(BaseItem item) {
        log.info("Registering item: " + item.toString());
        ItemRegistry.addItem(item);
    }
    public static void registerItems(){
        // add all items to the registry
    }

    public  static void loadUniqueItems() {

        try {
            File f = new File(ModItems.class.getClassLoader().getResource("ghost/item/Uniques.json").getPath());
            ObjectMapper om = new ObjectMapper();
            // not sure how to deserialize w/o a constructor, maybe delegate?
            // using factory with hardcoded properties for now
            // TODO - this should really be generic and moved to base engine
             ModItemModel[] json = om.readValue(f, ModItemModel[].class);
             for (ModItemModel model : json) {
                 log.debug("model loaded from json: " + model.getName());
                 ModItem item = ModItem.builder()
                         .setVirtual(model.isVirtual())
                         .setIlvl(model.getIlvl())
                         .setName(model.getName())
                         .build();
                 register(item);
             }
        } catch (IOException  e)  {
            log.error(e.toString());
        }
    }
}

