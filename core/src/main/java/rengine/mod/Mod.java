package main.java.rengine.mod;

/**
 * Created by prosbloom on 11/4/17.
 */
public abstract class Mod {
    // loader lifecycle
    public abstract void preinit();
    public abstract void init();
    public abstract void postinit();
}
