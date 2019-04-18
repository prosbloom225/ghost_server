package main.java.rengine.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import main.java.rengine.Server;
import main.java.rengine.client.screens.TitleScreen;

public class RengineClient extends Game {
    public static Skin skin;
    public static Server server;
    public static Thread serverThread;

    @Override
    public void create () {
        skin = new Skin(Gdx.files.internal("data/skin/uiskin.json"));
        startServer();
        this.setScreen(new TitleScreen(this));
    }

    @Override
    public void render () {
        super.render();

    }

    public void dispose () {
        skin.dispose();

    }


    public void startServer() {
        System.out.println("Begin Server thread!");
        server = new Server();
        serverThread = new Thread(new Server());
        serverThread.start();
        /*
        while (mainLoop.isAlive()){
            mainLoop.join();
        }
        */
        System.out.println("Complete Server thread!");
    }
}
