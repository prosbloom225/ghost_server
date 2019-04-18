package main.java.rengine.inventory;

import lombok.Getter;
import lombok.Setter;
import main.java.rengine.item.IItemArmor;

public class Equipment {
    @Getter @Setter private IItemArmor headSlot;
    @Getter @Setter private IItemArmor chestSlot;
    @Getter @Setter private IItemArmor handSlot;

    public Equipment() {
    }
}
