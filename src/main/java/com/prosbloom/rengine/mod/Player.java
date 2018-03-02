package com.prosbloom.rengine.mod;

import com.prosbloom.rengine.base.BaseEntity;
import com.prosbloom.rengine.actions.IAttacker;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Player extends BaseEntity implements IAttacker{

    private int maxhp;
    private int maxmp;

    private int hp;
    private int mp;

    public void setModName(){
        this.modName = "base";
    }

    public Player(String name, int maxhp, int maxmp) {
        super(name);
        this.maxhp = maxhp;
        this.maxmp = maxmp;
    }

    public double getAp() {
        return 0;
    }

}
