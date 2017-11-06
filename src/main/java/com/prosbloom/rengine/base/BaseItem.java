package com.prosbloom.rengine.base;

import java.io.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseItem extends BaseEntity {


    private String name;

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
    public void setModName(){
        this.modName = "base";
    }

    public BaseItem(String name) {
        super(name);
        this.name = name;
    }

}
