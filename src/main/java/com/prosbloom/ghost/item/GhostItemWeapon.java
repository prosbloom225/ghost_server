package com.prosbloom.ghost.item;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.item.IItemWeapon;
import org.apache.log4j.Logger;


/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemWeapon extends ModItem implements IItemWeapon {
    final static Logger log = Logger.getLogger(GhostItemWeapon.class.getName());
    double ap = 1;


    public double getAp() {
        return this.ap;
    }
    public void setAp(double ap) {
        this.ap = ap;
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
        private double ap;

        public Builder<T> setAp(double ap) {
            this.ap= ap;
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
        this.ap = builder.ap;
    }

}
