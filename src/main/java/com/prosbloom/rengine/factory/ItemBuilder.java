package com.prosbloom.rengine.factory;

import com.prosbloom.rengine.base.BaseItem;
import org.apache.log4j.Logger;

/**
 * Created by prosbloom on 11/7/17.
 */
public class ItemBuilder <T extends BaseItem>{
    final static Logger log = Logger.getLogger(ItemBuilder.class.getName());

    protected T item;

    public ItemBuilder(Class<T> type){
        try {
            item = type.newInstance();
        } catch (InstantiationException e) {
            log.warn(("Could not instance object of type: " + type.getName()));
        } catch (IllegalAccessException e) {
            log.warn(("Could not access object of type: " + type.getName()));
        }
    }

    public T create () {
        log.debug("Creating item of type: " + item.getClass().getName() + " - " + item.getName());
        return item;
    }

    // all properties have to be mapped here as setters and return the builder object
    public ItemBuilder setName(String name) {
        item.setName(name);
        return this;
    }
    public ItemBuilder setIlvl(int ilvl) {
        item.setIlvl(ilvl);
        return this;
    }
}
