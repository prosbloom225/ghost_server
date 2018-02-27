package com.prosbloom.ghost.item;

import com.prosbloom.ghost.base.ModItem;
import com.prosbloom.rengine.item.IItemArmor;
import org.apache.log4j.Logger;


/**
 * Created by prosbloom on 11/6/17.
 */
public class GhostItemArmor extends ModItem implements IItemArmor {
    final static Logger log = Logger.getLogger(GhostItemArmor.class.getName());
    double dv = 0;
    double pv = 0;


    public double getDv() {
        return this.dv;
    }
    public void setDv(double dv) {
        this.dv = dv;
    }
    public double getPv() {
        return this.pv;
    }
    public void setPv(double pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "ModItem{" +
                "name=" + name +
                "ilvl=" + ilvl +
                "isVirtual=" + isVirtual +
                "dv=" + dv +
                "pv=" + pv +
                '}';
    }

    // Builder code and constructor
    public static abstract class Builder<T extends GhostItemArmor> extends ModItem.Builder<T> {
        private double dv;
        private double pv;

        public Builder<T> setDv(double dv) {
            this.dv= dv;
            return this;
        }
        public Builder<T> setPv(double pv) {
            this.pv= pv;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<GhostItemArmor>()
        {
            @Override
            public GhostItemArmor build()
            {
                return new GhostItemArmor(this);
            }
        };
    }

    protected GhostItemArmor(Builder<?> builder) {
        super(builder);
        this.dv = builder.dv;
        this.pv = builder.pv;
    }

}
