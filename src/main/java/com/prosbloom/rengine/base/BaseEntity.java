package com.prosbloom.rengine.base;

import java.io.*;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseEntity implements Serializable{

    protected String name;
    protected String modName;

    public String getModName() {
        return modName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseEntity(String name) {
        this.name = name;
        setModName();
    }

    public void setModName() {
        this.modName = "";
    };

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


    public static abstract class Builder<T extends BaseEntity> {
        private String name;

        public Builder<T> setName(String name) {
            this.name= name;
            return this;
        }
        public abstract T build();
    }

    public static Builder<?> builder() {
        return new Builder<BaseEntity>()
        {
            @Override
            public BaseEntity build()
            {
                return new BaseEntity(this);
            }
        };
    }

    protected BaseEntity(Builder<?> builder) {
        this.name = builder.name;
        setModName();
    }
}
