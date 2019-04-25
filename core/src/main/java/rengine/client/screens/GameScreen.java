package main.java.rengine.client.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.java.rengine.client.RengineClient;
import main.java.rengine.client.stage.GameStage;

public class GameScreen implements Screen  {
    public static float w;
    public static float h;

    private GameStage gameStage;
    private Stage UIStage;
    private Game game;

    private Slider slider;
    public static InputMultiplexer multiplexer;


    public GameScreen(Game aGame) {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        game = aGame;
        gameStage = new GameStage(new ScreenViewport());
        UIStage = new Stage(new ScreenViewport());

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(UIStage);
        multiplexer.addProcessor((gameStage));


        //tileMap = new TileMap(32,32);

        slider = new Slider(1,2,0.01f,true, RengineClient.skin);
        slider.setAnimateInterpolation(Interpolation.smooth);
        //slider.setAnimateDuration(0.1f);
        slider.setHeight(Gdx.graphics.getHeight()*0.8f);
        slider.setPosition(Gdx.graphics.getWidth()/12,Gdx.graphics.getHeight()/10);
        slider.setValue(1.55f);
        UIStage.addActor(slider);

    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        UIStage.act();
        gameStage.act();

        gameStage.draw();
        UIStage.draw();
    }


    @Override
    public void resize(int width, int height) {
        w = width;
        h = height;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        UIStage.dispose();
        gameStage.dispose();
    }
}

