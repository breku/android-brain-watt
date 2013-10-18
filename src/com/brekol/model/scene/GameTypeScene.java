package com.brekol.model.scene;

import com.brekol.manager.SceneManager;
import com.brekol.model.shape.GameTypeMenuItem;
import com.brekol.util.ConstantsUtil;
import com.brekol.util.LevelDifficulty;
import com.brekol.util.MathParameter;
import com.brekol.util.SceneType;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.sprite.Sprite;

/**
 * User: Breku
 * Date: 08.10.13
 */
public class GameTypeScene extends BaseScene implements MenuScene.IOnMenuItemClickListener {

    private MenuScene menuScene;

    @Override
    public void createScene(Object... objects) {
        createBackground();
        createButtons();
    }

    private void createBackground() {
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2, resourcesManager.getBackgroundGameTypeTextureRegion(), vertexBufferObjectManager));
    }

    private void createButtons() {
        menuScene = new MenuScene(camera);
        menuScene.setPosition(0, 0);
        menuScene.setBackgroundEnabled(false);
        menuScene.buildAnimations();

        menuScene.addMenuItem(new GameTypeMenuItem(1, LevelDifficulty.EASY, MathParameter.ADD, 200, 300));
        menuScene.addMenuItem(new GameTypeMenuItem(2, LevelDifficulty.EASY, MathParameter.SUB, 300, 300));
        menuScene.addMenuItem(new GameTypeMenuItem(3, LevelDifficulty.EASY, MathParameter.MUL, 400, 300));
        menuScene.addMenuItem(new GameTypeMenuItem(4, LevelDifficulty.EASY, MathParameter.DIV, 500, 300));
        menuScene.addMenuItem(new GameTypeMenuItem(5, LevelDifficulty.EASY, MathParameter.ALL, 600, 300));

        menuScene.addMenuItem(new GameTypeMenuItem(6, LevelDifficulty.EASY, MathParameter.ADD, 200, 200));
        menuScene.addMenuItem(new GameTypeMenuItem(7, LevelDifficulty.EASY, MathParameter.SUB, 300, 200));
        menuScene.addMenuItem(new GameTypeMenuItem(8, LevelDifficulty.EASY, MathParameter.MUL, 400, 200));
        menuScene.addMenuItem(new GameTypeMenuItem(9, LevelDifficulty.EASY, MathParameter.DIV, 500, 200));
        menuScene.addMenuItem(new GameTypeMenuItem(10, LevelDifficulty.EASY, MathParameter.ALL, 600, 200));

        menuScene.addMenuItem(new GameTypeMenuItem(11, LevelDifficulty.EASY, MathParameter.ADD, 200, 100));
        menuScene.addMenuItem(new GameTypeMenuItem(12, LevelDifficulty.EASY, MathParameter.SUB, 300, 100));
        menuScene.addMenuItem(new GameTypeMenuItem(13, LevelDifficulty.EASY, MathParameter.MUL, 400, 100));
        menuScene.addMenuItem(new GameTypeMenuItem(14, LevelDifficulty.EASY, MathParameter.DIV, 500, 100));
        menuScene.addMenuItem(new GameTypeMenuItem(15, LevelDifficulty.EASY, MathParameter.ALL, 600, 100));


        menuScene.setOnMenuItemClickListener(this);

        setChildScene(menuScene);

    }


    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAMETYPE);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.GAMETYPE;
    }

    @Override
    public void disposeScene() {
    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
        SceneManager.getInstance().loadGameScene(((GameTypeMenuItem) pMenuItem).getLevelDifficulty(), ((GameTypeMenuItem) pMenuItem).getMathParameter());
        return true;
    }
}
