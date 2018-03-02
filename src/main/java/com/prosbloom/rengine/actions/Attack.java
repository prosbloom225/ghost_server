package com.prosbloom.rengine.actions;

import com.prosbloom.rengine.base.BaseEntity;


public class Attack implements IAction {
    IAttacker attacker;
    BaseEntity defender;

    public Attack(IAttacker attacker, BaseEntity defender){}
    public void onTick(){}

    public void execute(){
        defender.setHp(defender.getHp() - attacker.getAp());
    }

}
