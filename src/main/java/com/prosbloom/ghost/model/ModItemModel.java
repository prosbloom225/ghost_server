package com.prosbloom.ghost.model;

/**
 * Created by prosbloom on 11/8/17.
 */
public class ModItemModel {
    private String name;
    private int ilvl;
    private boolean virtual;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIlvl() {
        return ilvl;
    }

    public void setIlvl(int ilvl) {
        this.ilvl = ilvl;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }
}
