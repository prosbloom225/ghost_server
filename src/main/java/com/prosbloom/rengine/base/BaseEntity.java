package com.prosbloom.rengine.base;

import java.io.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by prosbloom on 11/4/17.
 */
public class BaseEntity implements Serializable{

    @Getter @Setter protected String name;
    @Getter protected String modName;

    @Getter @Setter private double maxHp;
    @Getter @Setter private double hp;

    public void setModName() {
        this.modName = "";
    }

    public BaseEntity(String name) {
        this.name = name;
        setModName();
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


    public static abstract class Builder<T extends BaseEntity> {
        private String name;
        private double hp;
        private double maxHp;

        public Builder<T> setName(String name) {
            this.name= name;
            return this;
        }
        public Builder<T> setHp(double hp) {
            this.hp= hp;
            return this;
        }
        public Builder<T> setMaxHp(double maxHp) {
            this.maxHp = maxHp;
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
        this.hp = builder.hp;
        this.maxHp = builder.maxHp;
        setModName();
    }
}
