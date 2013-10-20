package com.brekol.model.scene;

import com.brekol.manager.ResourcesManager;
import com.brekol.manager.SceneManager;
import com.brekol.matcher.ClassTouchAreaMacher;
import com.brekol.model.shape.GameButton;
import com.brekol.model.shape.MathEquationText;
import com.brekol.pool.MathEquationPool;
import com.brekol.util.ConstantsUtil;
import com.brekol.util.LevelDifficulty;
import com.brekol.util.MathParameter;
import com.brekol.util.SceneType;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.sprite.Sprite;

import java.util.ArrayDeque;

/**
 * User: Breku
 * Date: 21.09.13
 */
public class GameScene extends BaseScene {

    private HUD gameHUD;

    private LevelDifficulty levelDifficulty;
    private MathParameter mathParameter;
    private MathEquationPool pool;

    private GameButton redButton;
    private GameButton greenButton;

    // Head of the queue is on the bottom
    private ArrayDeque<MathEquationText> mathEquationTextQueue;

    /**
     * @param objects objects[0] - GameType
     */
    public GameScene(Object... objects) {
        super(objects);
    }


    @Override
    public void createScene(Object... objects) {
        init(objects);
        createBackground();
        initAfterBackgroundCreation();
        createHUD();
    }


    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAME);
    }

    private void init(Object... objects) {
        clearUpdateHandlers();
        clearTouchAreas();

        levelDifficulty = (LevelDifficulty) objects[0];
        mathParameter = (MathParameter) objects[1];

        pool = new MathEquationPool(levelDifficulty, mathParameter);
        pool.batchAllocatePoolItems(ConstantsUtil.INITIAL_POOL_SIZE);

    }

    private void initAfterBackgroundCreation() {
        mathEquationTextQueue = getEquationsTexts();
    }


    private void createHUD() {
        gameHUD = new HUD();
        camera.setHUD(gameHUD);
    }

    private void createBackground() {
        unregisterTouchAreas(new ClassTouchAreaMacher(Sprite.class));
        clearChildScene();
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2,
                ResourcesManager.getInstance().getBackgroundGameTextureRegion(), vertexBufferObjectManager));
        createInitialEquations();
        createGreenButton();
        createRedButton();
    }

    private void createInitialEquations() {
        for (int i = 0; i < 5; i++) {
            attachChild(new MathEquationText(400, i * 80 + 100, pool.obtainPoolItem()));
        }
    }

    private void createRedButton() {
        redButton = new GameButton(100, 100, ResourcesManager.getInstance().getButtonNoTextureRegion());
        registerTouchArea(redButton);
        attachChild(redButton);
    }

    private void createGreenButton() {
        greenButton = new GameButton(700, 100, ResourcesManager.getInstance().getButtonOkTextureRegion());
        registerTouchArea(greenButton);
        attachChild(greenButton);
    }

    private ArrayDeque<MathEquationText> getEquationsTexts() {
        ArrayDeque<MathEquationText> result = new ArrayDeque<MathEquationText>();
        for (IEntity entity : mChildren) {
            if (entity instanceof MathEquationText) {
                result.add((MathEquationText) entity);
            }
        }
        return result;
    }


    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        if (greenButton.isClicked()) {
            greenButton.clearState();
            moveAllElements();
            removeBottomElement();
            addNewTopElement();
        }
        super.onManagedUpdate(pSecondsElapsed);
    }

    private void moveAllElements() {
        // Starts from head - bottom
        for (MathEquationText text : mathEquationTextQueue) {
            text.registerEntityModifier(new MoveYModifier(ConstantsUtil.TEXT_MOVE_TIME, text.getY(), text.getY() - 80));
        }
    }

    private void removeBottomElement() {
        MathEquationText bottomElement = mathEquationTextQueue.poll();
        detachChild(bottomElement);
    }

    private void addNewTopElement() {
        MathEquationText text = new MathEquationText(400, 500, pool.obtainPoolItem());
        text.registerEntityModifier(new MoveYModifier(ConstantsUtil.TEXT_MOVE_TIME, text.getY(), text.getY() - 80));
        mathEquationTextQueue.add(text);
        attachChild(text);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.GAME;
    }

    @Override
    public void disposeScene() {
        gameHUD.clearChildScene();
        camera.setHUD(null);
        camera.setCenter(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2);
        camera.setChaseEntity(null);
    }
}
