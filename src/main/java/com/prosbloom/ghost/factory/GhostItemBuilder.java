package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.factory.ItemBuilder;
import org.apache.log4j.Logger;

/**
 * Created by prosbloom on 11/9/17.
 */
public class GhostItemBuilder <T extends ModItem> extends ItemBuilder <T>{
    final static Logger log = Logger.getLogger(GhostItemBuilder.class.getName());

    public GhostItemBuilder(Class<T> t){
        super(t);
    }

    // add in mod props
    public GhostItemBuilder setVirtual(boolean isVirtual) {
        item.setVirtual(isVirtual);
        return this;
    }

}
