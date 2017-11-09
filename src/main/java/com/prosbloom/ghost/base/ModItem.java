package com.prosbloom.ghost.base;

import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseItem;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItem extends BaseItem {

    public ModItem(String name, int ilvl) {
        super(name, ilvl);
    }

    // all baseitem extends have to have a base constructor
    public ModItem() {
       super();
    }

    public void setModName() {
        this.modName = LibMisc.MODNAME;
    }
}
