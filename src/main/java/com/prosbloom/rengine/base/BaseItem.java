package com.prosbloom.rengine.base;

import java.io.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseItem extends BaseEntity {

    private int ilvl = 0;

    public String getModName() {
        return modName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setModName(){
        this.modName = "base";
    }

    public int getIlvl() {
        return ilvl;
    }

    public void setIlvl(int ilvl) {
        this.ilvl = ilvl;
    }

    public BaseItem(String name, int ilvl) {
        super(name);
        this.ilvl = ilvl;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "name=" + name + "," +
                "ilvl=" + ilvl +
                '}';
    }

    public BaseItem(String name) {
        super(name);
        this.ilvl = 0;
    }
    public BaseItem() {
        // this should only be called by the factory,
        // TODO - really should remove all constructors for BaseItem since factory
        super("");
        this.ilvl = 0;
    }
}
