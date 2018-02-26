package com.prosbloom.rengine.base;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseItem extends BaseEntity {
    final static Logger log = Logger.getLogger(BaseItem.class.getName());

    protected int ilvl = 0;

    public String getModName() {
        return modName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setModName() {
        this.modName = "base";
    }

    public int getIlvl() {
        return ilvl;
    }

    public void setIlvl(int ilvl) {
        this.ilvl = ilvl;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "name=" + name + "," +
                "ilvl=" + ilvl +
                '}';
    }


    // Builder code and constructor
    public static abstract class Builder<T extends BaseItem> extends BaseEntity.Builder<T> {
        private int ilvl;

        public Builder<T> setIlvl(int ilvl) {
            this.ilvl= ilvl;
            return this;
        }
    }
    public static Builder<?> builder() {
        return new Builder<BaseItem>()
        {
            @Override
            public BaseItem build()
            {
                return new BaseItem(this);
            }
        };
    }

    protected BaseItem(Builder<?> builder) {
        super(builder);
        this.ilvl= builder.ilvl;
    }
}


