package com.prosbloom.rengine.registry;

import com.prosbloom.rengine.base.BaseItem;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ItemRegistry {
    final static Logger log = Logger.getLogger(ItemRegistry.class);

    // itemId, item
    private static Map<String, BaseItem> items;

    public static void init() {
        items = new LinkedHashMap<String, BaseItem>();
    }

    public static BaseItem getItem(String key) {
        try {
            return items.get(key).clone();
        } catch (IndexOutOfBoundsException e) {
            log.warn("Tried to get nonexistent item with key: " + key);
            return null;
        }
    }

    public static String addItem(String key, BaseItem item) {
        log.debug("Adding item: " + key);
        items.put(key, item);
        return key;
    }
    public static String addItem(BaseItem item) {
        return addItem(item.getModName() + ":" + item.getName(), item);
    }
}
