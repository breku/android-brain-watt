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

}
