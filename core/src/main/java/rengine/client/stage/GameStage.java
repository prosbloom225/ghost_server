package main.java.rengine.client.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import main.java.rengine.actions.Attack;
import main.java.rengine.actions.Move;
import main.java.rengine.actions.Teleport;
import main.java.rengine.base.BaseCreature;
import main.java.rengine.client.RengineClient;
import main.java.rengine.client.screens.SelectorScreen;
import main.java.rengine.map.Slot;
import main.java.rengine.map.TileMap;
import main.java.rengine.client.screens.GameScreen;
import main.java.rengine.mod.Player;

import java.util.UUID;

public class GameStage extends Stage {
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;
    SpriteBatch batch;

    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    public TileMap map;

    // Entities
    // Game obj
    UUID playerID;

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
        playerID = RengineClient.server.getPlayer().getId();
        map = new TileMap(RengineClient.server.getMap().getWidth(), RengineClient.server.getMap().getHeight());
    }
    private void renderMap(){
        // TODO - only render visible tiles
        // call to NetworkService.getMap(x,y,w,h) to query server for the spriteNums at each slot
        for (int x = 0; x < map.getWidth(); x++)
            for (int y = 0; y < map.getHeight(); y++) {
                // render the server sprites
                if (!map.getSlot(x, y).equals(" ")) {
                    //System.out.println("Slot (" + x + "," + y + ") - " + map.getSlot(x, y).toString());
                    TextureRegion region = textureAtlas.getRegions().get(
                            RengineClient.server.getMap().getSlot(x, y).getEntity() != null ?
                            RengineClient.server.getMap().getSlot(x, y).getEntity().getSpriteNum() : 0);
                    Sprite sprite = new Sprite(region);
                    sprite.setPosition(x*64, y*64);
                    sprite.draw(batch);
                }
                // render the client sprites
                if (map.getSlot(x, y) != null) {
                    Sprite sprite2 = new Sprite(textureAtlas.getRegions().get(map.getSlot(x,y).getSpriteNum()));
                    sprite2.setPosition(x*64, y*64);
                    sprite2.draw(batch);
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
        renderMap();
        batch.end();
    }

    public void postAction(){
        GameScreen.multiplexer.addProcessor(this);
    }

    public void teleportPlayer(Slot to) {
        RengineClient.server.getStack().add(new Teleport(RengineClient.server.getMap().findEntity(playerID), to.x, to.y, RengineClient.server.getMap()));
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.A) {
            Slot s = RengineClient.server.getMap().findEntity(playerID);
            RengineClient.server.getStack().add(new Attack(
                    (Player)RengineClient.server.getMap().findEntity(playerID).getEntity(),
                    RengineClient.server.getMap().getEntityAtSlot(s.x-1, s.y)));
        }
        if(keycode == Input.Keys.T) {
            SelectorScreen selector = new SelectorScreen();
            GameScreen.multiplexer.removeProcessor(this);
            selector.getSingleSlot(this, RengineClient.server.getMap().findEntity(playerID));
        }
        if(keycode == Input.Keys.S) {
            BaseCreature creatureOne = BaseCreature.builder()
                    .setXp(2)
                    .setLevel(2)
                    .setStrength(11)
                    .setConstitution(12)
                    .setDexterity(13)
                    .setIntelligence(14)
                    .setWisdom(15)
                    .setCharisma(16)
                    .setName("creatureOne")
                    .setSpriteNum(512)
                    .setHp(30)
                    .setMaxHp(30)
                    .build();
            RengineClient.server.getMap().setEntityAtSlot(1, 1, creatureOne);
        }
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
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), -1, 0, RengineClient.server.getMap()));
        if(keycode == Input.Keys.J)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), 0, -1, RengineClient.server.getMap()));
        if(keycode == Input.Keys.K)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), 0, 1, RengineClient.server.getMap()));
        if(keycode == Input.Keys.L)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), 1, 0, RengineClient.server.getMap()));
        // diagonal player moves
        if(keycode == Input.Keys.Y)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), -1, 1, RengineClient.server.getMap()));
        if(keycode == Input.Keys.U)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), 1, 1, RengineClient.server.getMap()));
        if(keycode == Input.Keys.N)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), -1, -1, RengineClient.server.getMap()));
        if(keycode == Input.Keys.M)
            RengineClient.server.getStack().add(new Move(RengineClient.server.getMap().findEntity(playerID), 1, -1, RengineClient.server.getMap()));
        return false;
    }

}
