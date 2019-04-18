package main.java.rengine;


public class ServerMain {
    public static void main(String[] args) 
    throws InterruptedException {
        System.out.println("Begin!");
        Thread mainLoop = new Thread(new Server());
        mainLoop.start();
        while (mainLoop.isAlive()){
            mainLoop.join();
        }
        System.out.println("Complete!");
    }
}
