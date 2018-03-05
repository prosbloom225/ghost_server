package com.prosbloom.rengine.inventory;

import lombok.Getter;
import lombok.Setter;
import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.item.IItemArmor;
import com.prosbloom.rengine.item.IItemWeapon;

public class Equipment {
    @Getter @Setter private IItemArmor headSlot;
    @Getter @Setter private IItemArmor chestSlot;
    @Getter @Setter private IItemArmor handSlot;

    public Equipment() {
    }
}
