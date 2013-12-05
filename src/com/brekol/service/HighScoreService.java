package com.brekol.service;

import com.brekol.util.LevelDifficulty;
import com.brekol.util.MathParameter;

/**
 * User: Breku
 * Date: 03.12.13
 */
public class HighScoreService extends BaseService {

    DatabaseHelper databaseHelper = new DatabaseHelper(activity);

    public Integer getHighScoresFor(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        return databaseHelper.getHighScoresFor(levelDifficulty, mathParameter);
    }

    public boolean isHighScore(LevelDifficulty levelDifficulty, MathParameter mathParameter, Integer currentScore) {
        Integer databaseScore = databaseHelper.getHighScoresFor(levelDifficulty, mathParameter);
        if (currentScore > databaseScore) {
            return true;
        }
        return false;
    }

    public void createNewRecordFor(LevelDifficulty levelDifficulty, MathParameter mathParameter, Integer score) {
        databaseHelper.removeScoreFor(levelDifficulty, mathParameter);
        databaseHelper.saveRecord(levelDifficulty, mathParameter, score);
    }
}
