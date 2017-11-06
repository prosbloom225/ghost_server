package com.prosbloom.ghost.item;

import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseItem;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItem extends BaseItem {

    public ModItem(String name) {
        super(name);
    }
    @Override
    public void setModName() {
        this.modName = LibMisc.MODNAME;
    }
}
