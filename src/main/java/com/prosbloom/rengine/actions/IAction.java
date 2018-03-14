package com.prosbloom.rengine.actions;


public interface IAction {
    public void onTick();
    public void execute();
    public boolean isDone();

    public String getName();
}
