package main.java.rengine.client.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import main.java.rengine.map.TileMap;
import main.java.rengine.client.screens.GameScreen;

public class GameStage extends Stage {
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;
    SpriteBatch batch;

    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    TileMap map;

    // Entities
    Sprite playerSprite;
    Texture playerTexture;
    Sprite sprite;

    public GameStage(Viewport viewport) {
        super(viewport);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameScreen.w, GameScreen.h);
        camera.update();

        tiledMap = new TmxMapLoader().load("tilemap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        textureAtlas = new TextureAtlas(Gdx.files.internal("data/Shockbolt_64x64_01.atlas"));
        //textureRegion = textureAtlas.findRegion("0001");
        textureRegion = textureAtlas.getRegions().get(1794);
        playerSprite = new Sprite(textureRegion);
        map = new TileMap(16,16);
    }
    private void renderMap(){
        // TODO - only render visible tiles
        // call to NetworkService.getMap(x,y,w,h) to query server for the spriteNums at each slot
        for (int x = 0; x < map.getWidth(); x++)
            for (int y = 0; y < map.getHeight(); y++) {
                if (!map.getSlot(x, y).equals(" ")) {
                    //System.out.println("Slot (" + x + "," + y + ") - " + map.getSlot(x, y).toString());
                    TextureRegion region = textureAtlas.getRegions().get(map.getSlot(x, y).getSpriteNum());
                    Sprite sprite = new Sprite(region);
                    sprite.setPosition(x*64, y*64);
                    sprite.draw(batch);
                }
            }
    }

    @Override
    public void draw() {
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        playerSprite.draw(batch);
        //sprite.draw(batch);
        renderMap();
        batch.end();
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            camera.translate(-64,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(64,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,64);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,-64);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        // cardinal player moves
        if(keycode == Input.Keys.H)
            playerSprite.setPosition(playerSprite.getX()-64, playerSprite.getY());
        if(keycode == Input.Keys.J)
            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY()-64);
        if(keycode == Input.Keys.K)
            playerSprite.setPosition(playerSprite.getX(), playerSprite.getY()+64);
        if(keycode == Input.Keys.L)
            playerSprite.setPosition(playerSprite.getX()+64, playerSprite.getY());
        // diagonal player moves
        if(keycode == Input.Keys.Y)
            playerSprite.setPosition(playerSprite.getX()-64, playerSprite.getY()+64);
        if(keycode == Input.Keys.U)
            playerSprite.setPosition(playerSprite.getX()+64, playerSprite.getY()+64);
        if(keycode == Input.Keys.N)
            playerSprite.setPosition(playerSprite.getX()-64, playerSprite.getY()-64);
        if(keycode == Input.Keys.M)
            playerSprite.setPosition(playerSprite.getX()+64, playerSprite.getY()-64);
        return false;
    }

}
