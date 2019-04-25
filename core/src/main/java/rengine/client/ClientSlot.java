package main.java.rengine.client;

import main.java.rengine.base.BaseEntity;
import main.java.rengine.model.Entity;

public class ClientSlot {
    private Entity entity;
    private int spriteNum;
    public int x;
    public int y;

    public ClientSlot() {
        new ClientSlot(0,0);
    }
    public ClientSlot(int x, int y) {
        this.x = x;
        this.y = y;
        spriteNum = 0;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    public int getSpriteNum() {
        return (entity == null) ? spriteNum : entity.getSpriteNum();
    }
    public void setSprite(int spriteNum){
        this.spriteNum = spriteNum;
    }

    @Override
    public String toString() {
        return "E" + this.getSpriteNum();
    }
}
