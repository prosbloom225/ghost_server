package com.prosbloom.rengine.map;

import com.prosbloom.rengine.base.BaseEntity;
import java.util.Arrays;

public class Map {

    private int height = 10;
    private int width = 10;
    private Slot[][] map;

    public Map() {
        map = new Slot[width][height];
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++) {
                map[i][j] = new Slot();
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
        return map[xx][yy].isEmpty();
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
}
