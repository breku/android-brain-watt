package com.brekol.model.scene;

import com.brekol.manager.ResourcesManager;
import com.brekol.manager.SceneManager;
import com.brekol.service.HighScoreService;
import com.brekol.util.ConstantsUtil;
import com.brekol.util.LevelDifficulty;
import com.brekol.util.MathParameter;
import com.brekol.util.SceneType;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

/**
 * User: Breku
 * Date: 06.10.13
 */
public class HighScoreScene extends BaseScene implements IOnSceneTouchListener {

    private HighScoreService highScoreService;

    /**
     * Constructor
     *
     * @param objects object[0] - HighScore
     */
    public HighScoreScene(Object... objects) {
        super(objects);
    }

    @Override
    public void createScene(Object... objects) {
        init();
        createBackground();
        createRecordsTable(objects);
        setOnSceneTouchListener(this);
    }

    private void init() {
        highScoreService = new HighScoreService();
    }

    private void createRecordsTable(Object... objects) {
        Integer scorePositionX = 220;
        Integer scorePositionY = 340;

        if (objects.length == 0) {
            for (LevelDifficulty levelDifficulty : LevelDifficulty.values()) {
                scorePositionY = 380;
                for (MathParameter mathParameter : MathParameter.values()) {
                    Integer score = highScoreService.getHighScoresFor(levelDifficulty, mathParameter);
                    createScoreItem(scorePositionX, scorePositionY, score);
                    scorePositionY -= 60;
                }
                scorePositionX += 200;
            }

        }
    }

    private void createScoreItem(Integer scorePositionX, Integer scorePositionY, Integer score) {
        attachChild(new Text(scorePositionX, scorePositionY, ResourcesManager.getInstance().getBlackFont(),
                score.toString(), vertexBufferObjectManager));
    }

    private void createBackground() {
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2,
                ResourcesManager.getInstance().getRecordBackgroundTextureRegion(), vertexBufferObjectManager));

    }

    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.RECORDS);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.RECORDS;
    }

    @Override
    public void disposeScene() {
    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        if (pSceneTouchEvent.isActionUp()) {
            SceneManager.getInstance().loadMenuSceneFrom(SceneType.RECORDS);
        }
        return false;
    }
}
