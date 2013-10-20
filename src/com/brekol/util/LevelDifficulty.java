package com.brekol.util;

/**
 * User: Breku
 * Date: 18.10.13
 */
public enum LevelDifficulty {
    EASY(20, false),
    MEDIUM(100, false),
    HARD(100, true);

    private Integer randomSeedSize;
    private Boolean minusAllowed;

    private LevelDifficulty(Integer randomSeedSize, Boolean minusAllowed) {
        this.randomSeedSize = randomSeedSize;
        this.minusAllowed = minusAllowed;
    }

    public Integer getRandomSeedSize() {
        return randomSeedSize;
    }

    public Boolean isMinusAllowed() {
        return minusAllowed;
    }
}
