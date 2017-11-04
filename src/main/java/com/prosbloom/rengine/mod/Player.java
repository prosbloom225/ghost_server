package com.prosbloom.rengine.mod;

import com.prosbloom.rengine.base.BaseEntity;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Player extends BaseEntity{

    private int maxhp;
    private int maxmp;

    private int hp;
    private int mp;

    public Player(String name, int maxhp, int maxmp) {
        super(name);
        this.maxhp = maxhp;
        this.maxmp = maxmp;
    }

}
