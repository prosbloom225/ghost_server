package com.prosbloom.rengine.map;

import com.prosbloom.rengine.base.BaseEntity;

public class Slot {
    private BaseEntity entity;

    public Slot() {
        // System.out.println("Slot created");
    }
    public BaseEntity getEntity() {
        return entity;
    }
    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }

    public boolean isEmpty() {
        return (entity == null);
    }
}
