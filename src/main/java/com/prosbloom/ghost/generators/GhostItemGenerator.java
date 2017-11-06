package com.prosbloom.ghost.generators;

import com.prosbloom.ghost.item.ModItem;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.generators.RandomItemGenerator;

/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemGenerator extends RandomItemGenerator {

    @Override
    public BaseItem generate(){
        BaseItem item = new ModItem("rng");
        return item;
    }

}
