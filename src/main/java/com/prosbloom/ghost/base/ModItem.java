package com.prosbloom.ghost.base;

import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseItem;
import com.prosbloom.rengine.item.ITickable;

/**
 * Created by prosbloom on 11/4/17.
 */
public class ModItem extends BaseItem {
    private boolean isVirtual;


    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean virtual) {
        isVirtual = virtual;
    }

    public void setModName() {
        this.modName = LibMisc.MODNAME;
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
    public static abstract class Builder<T extends ModItem> extends BaseItem.Builder<T> {
        private boolean isVirtual;

        public Builder<T> setVirtual(boolean isVirtual) {
            this.isVirtual= isVirtual;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<ModItem>()
        {
            @Override
            public ModItem build()
            {
                return new ModItem(this);
            }
        };
    }

    protected ModItem(Builder<?> builder) {
        super(builder);
        this.isVirtual= builder.isVirtual;
    }

}
