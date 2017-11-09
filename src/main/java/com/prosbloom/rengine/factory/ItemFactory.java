package com.prosbloom.rengine.factory;

import com.prosbloom.rengine.base.BaseItem;

/**
 * Created by prosbloom on 11/9/17.
 */
public class ItemFactory {
    public static ItemBuilder build(String name) {
        // factory sets default item class ... maybe should throw Itembuilder exceptions here?
        return new ItemBuilder(BaseItem.class)
                .setName(name);
    }
}
