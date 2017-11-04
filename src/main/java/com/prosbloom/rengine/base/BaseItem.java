package com.prosbloom.rengine.base;

import java.io.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseItem implements Serializable{


    private String name;
    protected String modName = "base";

    public String getModName() {
        return modName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseItem(String name) {
        this.name = name;
    }

    public BaseItem clone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (BaseItem) ois.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
