package main.java.rengine.actions;


public interface IAction {
    void onTick();
    void execute();
    boolean isDone();

    String getName();
}
