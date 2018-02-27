package com.prosbloom.ghost.item;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.item.IItemWeapon;
import org.apache.log4j.Logger;


/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemWeapon extends ModItem implements IItemWeapon {
    final static Logger log = Logger.getLogger(GhostItemWeapon.class.getName());
    int ap = 0;


    public double getWeaponAp() {
        return this.ap;
    }

    @Override
    public String toString() {
        return "ModItem{" +
                "name=" + name +
                "ilvl=" + ilvl +
                "isVirtual=" + isVirtual +
                '}';
    }

    // Builder code and constructor
    public static abstract class Builder<T extends GhostItemWeapon> extends ModItem.Builder<T> {
        private boolean isVirtual;

        public Builder<T> setVirtual(boolean isVirtual) {
            this.isVirtual= isVirtual;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<GhostItemWeapon>()
        {
            @Override
            public GhostItemWeapon build()
            {
                return new GhostItemWeapon(this);
            }
        };
    }

    protected GhostItemWeapon(Builder<?> builder) {
        super(builder);
        this.isVirtual= builder.isVirtual;
    }

}
