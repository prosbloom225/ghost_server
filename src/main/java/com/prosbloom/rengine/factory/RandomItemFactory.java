package com.prosbloom.rengine.factory;

import com.prosbloom.rengine.base.BaseItem;

/**
 * Created by prosbloom on 11/6/17.
 */
public class RandomItemFactory {
    public BaseItem generate() {
        BaseItem item = BaseItem.builder()
                .setIlvl(0)
                .setName("rngItem")
                .build();
        return item;
    }
}
