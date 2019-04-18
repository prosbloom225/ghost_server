package main.java.rengine.client;

import main.java.rengine.model.Entity;

public class Slot {
    private Entity entity;

    public Slot() {
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    public int getSpriteNum() {
        return (entity == null) ? 0 : entity.getSpriteNum();
    }

    @Override
    public String toString() {
        return "E" + this.getSpriteNum();
    }
}
