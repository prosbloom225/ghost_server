package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.ItemFactory;
import org.apache.log4j.Logger;

/**
 * Created by prosbloom on 11/9/17.
 */
public class GhostItemFactory extends ItemFactory{
    final static Logger log = Logger.getLogger(GhostItemFactory.class.getName());

    /*
    @Override
    public GhostItemFactory.builder build() {
        try {
            return new GhostItemFactory.builder<ModItem>(ModItem.class);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }
    */

    public class builder <T extends ModItem> extends ItemFactory.builder<T> {

        public builder(Class<T> t)
        throws InstantiationException, IllegalAccessException {
            super(t);
        }

        public builder setVirtual(boolean isVirtual) {
            item.setVirtual(isVirtual);
            return this;
        }

    }

}
