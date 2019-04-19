package main.java.rengine.mod;

import main.java.rengine.base.BaseCreature;
import main.java.rengine.actions.IAttacker;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by prosbloom on 11/4/17.
 */
public class Player extends BaseCreature implements IAttacker {

    @Getter @Setter protected int maxMp;
    @Getter @Setter protected int mp;

    @Override
    public String toString() {
        return "BaseCreature{" + 
            "name=" + name + 
            "level=" + level +
            "stats={" + strength + "," + constitution + "," + dexterity + "," + intelligence + "," + wisdom + "," + charisma + "}" + 
            '}';
    }
    public void setModName(){
        this.modName = "base";
    }

    // IAttacker
    public double getAp() {
        return 10;
    }

    // Builder code and constructor
    public static abstract class Builder<T extends Player> extends BaseCreature.Builder<T> {
        private int mp;
        private int maxMp;

        public Builder<T> setMp(int mp) {
            this.mp= mp;
            return this;
        }
        public Builder<T> setMaxMp(int maxMp) {
            this.maxMp= maxMp;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<Player>()
        {
            @Override
            public Player build()
            {
                return new Player(this);
            }
        };
    }

    protected Player(Builder<?> builder) {
        super(builder);
        this.mp = builder.mp;
        this.maxMp = builder.maxMp;
    }

}
