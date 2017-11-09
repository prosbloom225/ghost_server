package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.RandomItemFactory;

/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemGenerator extends RandomItemFactory {

    private ModItem createItem(int ilvl){
        ModItem item = ModItem.builder()
                .setIlvl(ilvl)
                .setName("rngModItem")
                .build();
        return item;
    }

    // overloads
    public ModItem generate(int ilvl){
        ModItem item = createItem(ilvl);
        return item;
    }
    public ModItem generate(int ilvl, LibMisc.ITYPE type) {
        ModItem item = generate(ilvl);
        switch (type) {
            case weapon:
                break;
            case armor:
                break;
            default:
                // other
                break;
        }
        return item;
    }

}
