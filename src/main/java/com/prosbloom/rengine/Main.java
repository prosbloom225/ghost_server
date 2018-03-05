package com.prosbloom.rengine;


public class Main {
    public static void main(String[] args) 
    throws InterruptedException {
        System.out.println("Begin!");
        Thread mainLoop = new Thread(new Game());
        mainLoop.start();
        while (mainLoop.isAlive()){
            mainLoop.join();
        }
        System.out.println("Complete!");
    }
}
