package main.java.rengine.map;

import main.java.rengine.base.BaseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import lombok.Getter;

public class Map {

    @Getter private int height;
    @Getter private int width;
    private Slot[][] map;

    public Map() {
        this(10, 10);
    }
    public Map(int w, int h) {
        height = h;
        width = w;
        map = new Slot[width][height];
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++) {
                map[i][j] = new Slot(i, j);
            }
        }
    }

    public BaseEntity getEntityAtSlot(int x, int y) {
        return map[x][y].getEntity();
    }

    public void setEntityAtSlot(int x, int y, BaseEntity entity) {
        map[x][y].setEntity(entity);
    }

    public boolean canMove(int x, int y, int xx, int yy) {
        try {
            return map[xx][yy].isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean moveEntity(int x, int y, int xx, int yy) {
        if (canMove(x, y, xx, yy)) {
            map[xx][yy].setEntity(map[x][y].getEntity());
            map[x][y].setEntity(null);
            return true;
        } else {
            return false;
        }
    }

    public String dumpMap() {
        return Arrays.deepToString(map); 
    }

    public Slot getSlot(int x, int y) {
        return map[x][y];
    }

    public List<BaseEntity> getEntities() {
        List<BaseEntity> entities = new ArrayList<BaseEntity>();
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++) {
                if (!map[i][j].isEmpty()){
                    entities.add(map[i][j].getEntity());
                }
            }
        }
        return entities;
    }
}
