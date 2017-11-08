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
        return new builder();
    }

    public final class builder{
        private BaseItem item;

        public builder() {
            item = new BaseItem();
        }

        public BaseItem execute() {
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
