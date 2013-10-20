package com.brekol.service;

import com.brekol.model.shape.MathEquation;
import com.brekol.util.LevelDifficulty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * User: Breku
 * Date: 19.10.13
 */
@RunWith(JUnit4.class)
public class MathServiceTest {

    private MathService mathService;
    private final Integer NUMBER_OF_LOOPS = 1000;

    @Before
    public void init() {
        mathService = new MathService();

    }

    @Test
    public void testGetAddResult() throws Exception {

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.EASY);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() + mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size",
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + "  + " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.MEDIUM);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() + mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size",
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + "  + " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.HARD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() + mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size",
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() &&
                            -1 * LevelDifficulty.HARD.getRandomSeedSize() < mathEquation.getResult());
//            System.out.println(mathEquation.getX() + "  + " + mathEquation.getY() + " = " + mathEquation.getResult());
        }
    }

    @Test
    public void testGetSubResult() throws Exception {

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.EASY);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.MEDIUM);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.HARD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.HARD.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() && -1 * LevelDifficulty.HARD.getRandomSeedSize() <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }
    }

    @Test
    public void testGetMulResult() {

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.EASY);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() * mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " * " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.MEDIUM);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() * mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " * " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.HARD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() * mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.HARD.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() &&
                            -1 * LevelDifficulty.HARD.getRandomSeedSize() <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " * " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

    }

    @Test
    public void testGetDivResult() {

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.EASY);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.MEDIUM);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.HARD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.HARD.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() &&
                            -1 * LevelDifficulty.HARD.getRandomSeedSize() <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

    }
}
