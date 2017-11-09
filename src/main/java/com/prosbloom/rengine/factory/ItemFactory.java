package com.prosbloom.rengine.factory;

import com.prosbloom.rengine.base.BaseItem;
import org.apache.log4j.Logger;

/**
 * Created by prosbloom on 11/7/17.
 */
public class ItemFactory {
    final static Logger log = Logger.getLogger(ItemFactory.class.getName());

    // subclass allows for multiple builders to run at same time
    public builder build() {
        try {
            return new builder(BaseItem.class);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }

    public builder build(Class type) {
        try {
            return new builder(type);
            // TODO - real exception handling
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }

    public class builder<T extends BaseItem> {

        private T item;

        public builder(Class<T> type)
        throws IllegalAccessException, InstantiationException {
            item = type.newInstance();
        }

        public T create () {
            log.debug("Creating item of type: " + item.getClass().getName() + " - " + item.getName());
            return item;
        }

        // all properties have to be mapped here as setters and return the builder object
        public builder setName(String name) {
            item.setName(name);
            return this;
        }
        public builder setIlvl(int ilvl) {
            item.setIlvl(ilvl);
            return this;
        }
    }
}
