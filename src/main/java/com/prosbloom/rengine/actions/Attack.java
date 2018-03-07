package com.prosbloom.rengine.actions;

import com.prosbloom.rengine.base.BaseEntity;
import org.apache.log4j.Logger;
import java.util.Random;


public class Attack implements IAction {
    final static Logger log = Logger.getLogger(Attack.class.getName());
    IAttacker attacker;
    BaseEntity defender;
    int tick = 0;

    public Attack(IAttacker attacker, BaseEntity defender){
        this.attacker = attacker;
        this.defender = defender;
        log.debug("Attack constructed");
    }
    public void onTick(){
        if (++tick == 1) {
            this.execute();
        }
    }
    public void execute(){
        double dmg = 0;
        // process full mititation rolls
        Random rng = new Random();
        if (rng.nextInt(100) == 0) {
            dmg = 0;
            log.info("Attack dodged");
        } else {
        // welp we took some damage, how much
        // dmg = attacker.getAp() - (attacker.getAp() * (defender.getPv() / 100));
        dmg = attacker.getAp() * (1 - ((double)defender.getPv()/100));
         }
        // execute
        log.debug(this);
        log.debug("Attacking for: " + dmg);
        defender.setHp(defender.getHp() - dmg);
        log.info("Attack executed: " + defender.getName() + " now has " + defender.getHp() + " hp");
    }

    @Override
    public String toString() {
        return "attacker: " + attacker + " - defender: " + defender;
    }

}
