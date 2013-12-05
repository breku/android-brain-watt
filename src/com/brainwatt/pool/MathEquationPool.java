package com.brainwatt.pool;

import com.brainwatt.model.shape.MathEquation;
import com.brainwatt.service.MathService;
import com.brainwatt.util.LevelDifficulty;
import com.brainwatt.util.MathParameter;
import org.andengine.util.adt.pool.GenericPool;

/**
 * User: Breku
 * Date: 20.10.13
 */
public class MathEquationPool extends GenericPool<MathEquation> {


    private MathService mathService = new MathService();
    private LevelDifficulty levelDifficulty;
    private MathParameter mathParameter;

    public MathEquationPool(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        super();
        this.levelDifficulty = levelDifficulty;
        this.mathParameter = mathParameter;
    }

    /**
     * Called when a Bullet is required but there isn't one in the pool
     */
    @Override
    protected MathEquation onAllocatePoolItem() {
        return mathService.getMathEquation(levelDifficulty, mathParameter);
    }

    /**
     * Called when a Bullet is sent to the pool
     */
    @Override
    protected void onHandleRecycleItem(MathEquation pItem) {
        super.onHandleRecycleItem(pItem);
    }


    /**
     * Called just before a Bullet is returned to the caller, this is where you write your initialize code
     * i.e. set location, rotation, etc.
     */
    @Override
    protected void onHandleObtainItem(MathEquation pItem) {
        super.onHandleObtainItem(pItem);
    }
}
