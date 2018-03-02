package com.prosbloom.rengine.base;

import org.apache.log4j.Logger;

import java.io.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseItem extends BaseEntity {
    final static Logger log = Logger.getLogger(BaseItem.class.getName());

    @Getter @Setter protected int ilvl = 0;
    @Getter @Setter protected int weight =0;

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
        private int weight;

        public Builder<T> setIlvl(int ilvl) {
            this.ilvl= ilvl;
            return this;
        }
        public Builder<T> setWeight(int weight) {
            this.weight = weight;
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
        this.weight = builder.weight;
    }
}


