package com.prosbloom.rengine.base;

import com.prosbloom.ghost.lib.LibMisc;
import com.prosbloom.rengine.base.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public class BaseCreature extends BaseEntity {
    // Core
    @Getter @Setter protected int xp;
    @Getter @Setter protected int level;

    // Stats
    @Getter @Setter protected int strength;
    @Getter @Setter protected int constitution;
    @Getter @Setter protected int dexterity;
    @Getter @Setter protected int intelligence;
    @Getter @Setter protected int wisdom;
    @Getter @Setter protected int charisma;

    @Override
    public String toString() {
        return "BaseCreature{" + 
            "name=" + name + 
            "level=" + level +
            "stats={" + strength + "," + constitution + "," + dexterity + "," + intelligence + "," + wisdom + "," + charisma + "}" + 
            '}';
    }


    // Builder code and constructor
    public static abstract class Builder<T extends BaseCreature> extends BaseEntity.Builder<T> {
    // Core
    private int xp;
    private int level;

    // Stats
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;

        public Builder<T> setStrength(int strength) {
            this.strength = strength;
            return this;
        }
        public Builder<T> setLevel(int level) {
            this.level= level;
            return this;
        }
        public Builder<T> setXp(int xp) {
            this.xp= xp;
            return this;
        }
        public Builder<T> setConstitution(int constitution) {
            this.constitution= constitution;
            return this;
        }
        public Builder<T> setDexterity(int dexterity) {
            this.dexterity= dexterity;
            return this;
        }
        public Builder<T> setIntelligence(int intelligence) {
            this.intelligence= intelligence;
            return this;
        }
        public Builder<T> setWisdom(int wisdom) {
            this.wisdom = wisdom;
            return this;
        }
        public Builder<T> setCharisma(int charisma) {
            this.charisma= charisma;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<BaseCreature>()
        {
            @Override
            public BaseCreature build()
            {
                return new BaseCreature(this);
            }
        };
    }

    protected BaseCreature(Builder<?> builder) {
        super(builder);
        this.xp = builder.xp;
        this.level = builder.level;
        this.strength = builder.strength;
        this.constitution = builder.constitution;
        this.dexterity = builder.dexterity;
        this.intelligence = builder.intelligence;
        this.wisdom = builder.wisdom;
        this.charisma = builder.charisma;
    }

}
