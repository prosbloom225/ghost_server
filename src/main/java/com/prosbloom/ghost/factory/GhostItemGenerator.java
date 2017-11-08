package com.prosbloom.ghost.factory;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.factory.RandomItemFactory;

/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemGenerator extends RandomItemFactory {

    @Override
    public BaseItem generate(){
        BaseItem item = new ModItem("rng", 1);
        return item;
    }
    public BaseItem generate(int ilvl){
        BaseItem item = generate();
        item.setIlvl(ilvl);
        return item;
    }
    public BaseItem generate(int ilvl, LibMisc.ITYPE type) {
        BaseItem item = generate(ilvl);
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
