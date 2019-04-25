package main.java.rengine.client.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import main.java.rengine.actions.IAction;
import main.java.rengine.client.ClientSlot;
import main.java.rengine.client.RengineClient;
import main.java.rengine.client.stage.GameStage;
import main.java.rengine.map.Slot;

public class SelectorScreen implements InputProcessor {
    private GameStage gameStage;
    private int numSlotsToSelect;
    private int SELECTORSPRITE = 608;
    private ClientSlot curr;

    public <T extends IAction> void getSingleSlot(GameStage gameStage, Slot start)  {
        numSlotsToSelect = 1;
        this.gameStage = gameStage;
        //this.curr = gameStage.map.getSlot(start.x, start.y);  //recast..this is confusing
        this.curr = new ClientSlot(start.x, start.y);
        GameScreen.multiplexer.removeProcessor(gameStage);
        GameScreen.multiplexer.addProcessor(this);
        gameStage.map.getSlot(curr.x, curr.y).setSprite(SELECTORSPRITE);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keyCode) {
        System.out.println("Key pressed: " + keyCode);
        if(keyCode == Input.Keys.Q) {
            GameScreen.multiplexer.removeProcessor(this);
            gameStage.postAction();
        } else if (keyCode == Input.Keys.J && curr.y > 0) {
            gameStage.map.getSlot(curr.x, curr.y).setSprite(0);
            curr = gameStage.map.getSlot(curr.x, curr.y-1);
            curr.setSprite(SELECTORSPRITE);
        } else if (keyCode == Input.Keys.K && curr.y < gameStage.map.getHeight()) {
            gameStage.map.getSlot(curr.x, curr.y).setSprite(0);
            curr = gameStage.map.getSlot(curr.x, curr.y+1);
            curr.setSprite(SELECTORSPRITE);
        } else if (keyCode == Input.Keys.L && curr.x < gameStage.map.getHeight()) {
            gameStage.map.getSlot(curr.x, curr.y).setSprite(0);
            curr = gameStage.map.getSlot(curr.x+1, curr.y);
            curr.setSprite(SELECTORSPRITE);
        } else if (keyCode == Input.Keys.H && curr.x > 0) {
            gameStage.map.getSlot(curr.x, curr.y).setSprite(0);
            curr = gameStage.map.getSlot(curr.x-1, curr.y);
            curr.setSprite(SELECTORSPRITE);
        } else if (keyCode == Input.Keys.ENTER) {
            gameStage.map.getSlot(curr.x, curr.y).setSprite(0);
            gameStage.teleportPlayer(RengineClient.server.getMap().getSlot(curr.x, curr.y));
            GameScreen.multiplexer.removeProcessor(this);
            gameStage.postAction();
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
