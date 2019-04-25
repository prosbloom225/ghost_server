package main.java.rengine.map;

import main.java.rengine.client.ClientSlot;
import main.java.rengine.model.Entity;

public class TileMap {
    ClientSlot[][] clientSlotMap;

    public TileMap(int w, int h) {

        clientSlotMap = new ClientSlot[w][h];

        for (int xx = 0; xx < clientSlotMap.length; xx++) {
            for (int yy = 0; yy < clientSlotMap[xx].length; yy++) {
                clientSlotMap[xx][yy] = new ClientSlot(xx,yy);
            }
        }
        clientSlotMap[3][3].setEntity(new Entity(0001));
        for(int i=0; i < getHeight();i++) {
            clientSlotMap[i][i].setEntity(new Entity(i));
        }
    }

    public int getHeight() {
        return clientSlotMap[0].length;
    }
    public int getWidth() {
        return clientSlotMap.length;
    }
    public ClientSlot getSlot(int x, int y) {
        return clientSlotMap[x][y];
    }

    public String toString() {
        String ret = "";
        for (int y = 0; y < clientSlotMap.length; y++) {
            ret += "|";
            for (int x = 0; x < clientSlotMap[y].length; x++) {
                if (clientSlotMap[x][y] != null) {
                    ret += clientSlotMap[x][y].toString();
                }
            }
            ret += "|\n";
        }
        ret += "********************************\n";
        return ret;
    }
}
