package com.prosbloom.rengine.map;

import com.prosbloom.rengine.base.BaseEntity;

public class Slot {
    private BaseEntity entity;
    public int x, y;

    public Slot(int x, int y) {
        this.x = x;
        this.y = y;
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
