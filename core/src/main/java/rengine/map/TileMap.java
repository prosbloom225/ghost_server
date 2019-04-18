package main.java.rengine.map;

import main.java.rengine.client.Slot;
import main.java.rengine.model.Entity;

public class TileMap {
    Slot[][] slotMap;

    public TileMap(int w, int h) {

        slotMap = new Slot[w][h];

        for (int xx = 0; xx < slotMap.length; xx++) {
            for (int yy = 0; yy < slotMap[xx].length; yy++) {
                slotMap[xx][yy] = new Slot();
            }
        }
        slotMap[3][3].setEntity(new Entity(0001));
        for(int i=0; i < getHeight();i++) {
            slotMap[i][i].setEntity(new Entity(i));
        }
    }

    public int getHeight() {
        return slotMap[0].length;
    }
    public int getWidth() {
        return slotMap.length;
    }
    public Slot getSlot(int x, int y) {
        return slotMap[x][y];
    }

    public String toString() {
        String ret = "";
        for (int y = 0; y < slotMap.length; y++) {
            ret += "|";
            for (int x = 0; x < slotMap[y].length; x++) {
                if (slotMap[x][y] != null) {
                    ret += slotMap[x][y].toString();
                }
            }
            ret += "|\n";
        }
        ret += "********************************\n";
        return ret;
    }
}
