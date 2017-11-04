package com.prosbloom.ghost.mod;

import com.prosbloom.ghost.item.ModItem;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.registry.ItemRegistry;

import java.lang.reflect.Modifier;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItems {

    public static void register(ModItem item) {
        ItemRegistry.addItem(item);
    }
    public static void registerItems(){
        // add all items to the registry
    }
}
