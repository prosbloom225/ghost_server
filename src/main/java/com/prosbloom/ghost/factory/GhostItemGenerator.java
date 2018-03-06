package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.item.GhostItemWeapon;
import com.prosbloom.ghost.item.GhostItemArmor;
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

    public ModItem generate(int ilvl) {
        return createItem(ilvl);
    }
    public ModItem generate(int ilvl, LibMisc.ITYPE type) {
        ModItem item = createItem(ilvl);
        switch (type) {
            case weapon:
                item = GhostItemWeapon.builder()
                    .setAp(1.0)
                    .setIlvl(ilvl)
                    .setName("rngItem")
                    .build();
                break;
            case armor:
                item = GhostItemArmor.builder()
                    .setVirtual(false)
                    .setIlvl(ilvl)
                    .setDv(1)
                    .setPv(1)
                    .setName("rngItem")
                    .build();
                break;
            default:
                // other
                break;
        }
        return item;
    }

}
