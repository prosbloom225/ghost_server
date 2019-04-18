package main.java.rengine.registry;

import main.java.rengine.base.BaseEntity;
import main.java.rengine.base.BaseItem;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by prosbloom on 11/4/17.
 */
public class EntityRegistry {
    final static Logger log = Logger.getLogger(EntityRegistry.class);

    // itemId, entity
    private static Map<String, BaseEntity> entities;

    public static void init() {
        entities = new LinkedHashMap<String, BaseEntity>();
    }

    public static BaseItem getEntity(String key) {
        try {
            return entities.get(key).clone();
        } catch (IndexOutOfBoundsException e) {
            log.warn("Tried to get nonexistent item with key: " + key);
            return null;
        }
    }

    public static String addEntity(String key, BaseEntity entity) {
        entities.put(key, entity);
        return key;
    }
    public static String addEntity(BaseEntity entity) {
        return addEntity(entity.getModName() + ":" + entity.getName(), entity);
    }
}
