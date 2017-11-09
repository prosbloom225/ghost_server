package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.factory.ItemFactory;

/**
 * Created by prosbloom on 11/9/17.
 */
public class GhostItemFactory extends ItemFactory{
    public static GhostItemBuilder build(String name) {
        // factory sets default item class ... maybe should throw Itembuilder exceptions here?
        GhostItemBuilder builder = new GhostItemBuilder(ModItem.class);
        builder.setName(name);
        return builder;
    }
}
