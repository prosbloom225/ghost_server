package com.prosbloom.rengine.actions;

import com.prosbloom.rengine.base.BaseEntity;
import org.apache.log4j.Logger;


public class Attack implements IAction {
    final static Logger log = Logger.getLogger(Attack.class.getName());
    IAttacker attacker;
    BaseEntity defender;
    int tick = 0;

    public Attack(IAttacker attacker, BaseEntity defender){
        this.attacker = attacker;
        this.defender = defender;
        log.info("Attack constructed");
    }
    public void onTick(){
        if (++tick == 1) {
            this.execute();
        }
    }

    public void execute(){
        defender.setHp(defender.getHp() - attacker.getAp());
        log.info("Attack executed: " + defender.getName() + " now has " + defender.getHp() + " hp");
    }

}
