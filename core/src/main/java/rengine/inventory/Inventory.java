package main.java.rengine.inventory;

import java.util.List;
import java.util.ArrayList;
import main.java.rengine.base.BaseItem;

public class Inventory {
    private List<BaseItem> inventory;
    private Equipment equipment;

    public Inventory() {
        new Inventory(false);
    }
    public Inventory(boolean hasEquipment){
        inventory = new ArrayList<BaseItem>();
        if (hasEquipment)
            equipment = new Equipment();
    }
    public boolean hasEquipment() {
        return (equipment != null);
    }

	public void addItem(BaseItem item) {
		inventory.add(item);
	}
    public double getWeight() {
        double weight = inventory.stream().mapToDouble(i->i.getWeight()).sum();
		// double weight = 0;
		// for (BaseItem item : inventory){
		// 	System.out.println(item.getWeight());
		// 	weight += item.getWeight();
		// }
        return weight;
        // return 0;
    }
    public BaseItem getItemAtIndex(int index) {
        return inventory.get(index);
    }
    public BaseItem getItem(String name) {
        for (BaseItem item : inventory) {
            if (name.equals(item.getName()))
                    return item;
        }
        return null;
    }
}
