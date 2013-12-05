package com.brainwatt.service;

import com.brainwatt.model.shape.MathEquation;
import com.brainwatt.util.LevelDifficulty;
import com.brainwatt.util.MathParameter;
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
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.EASY, MathParameter.ADD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() + mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size",
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + "  + " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.MEDIUM, MathParameter.ADD);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() + mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size",
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + "  + " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getAddResult(LevelDifficulty.HARD, MathParameter.ADD);
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
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.EASY, MathParameter.SUB);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.MEDIUM, MathParameter.SUB);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getSubResult(LevelDifficulty.HARD, MathParameter.SUB);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() - mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.HARD.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() && -1 * LevelDifficulty.HARD.getRandomSeedSize() <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " - " + mathEquation.getY() + " = " + mathEquation.getResult());
        }
    }

    @Test
    public void testGetMulResult() {

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.EASY, MathParameter.MUL);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() * mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " * " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.MEDIUM, MathParameter.MUL);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() * mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " * " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getMulResult(LevelDifficulty.HARD, MathParameter.MUL);
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
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.EASY, MathParameter.DIV);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.EASY.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.EASY.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.MEDIUM, MathParameter.DIV);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.MEDIUM.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.MEDIUM.getRandomSeedSize() >= mathEquation.getResult() && 0 <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            MathEquation mathEquation = mathService.getDivResult(LevelDifficulty.HARD, MathParameter.DIV);
            Assert.assertEquals("Correct Result", (Integer) (mathEquation.getX() / mathEquation.getY()), mathEquation.getResult());
            Assert.assertTrue("Result under level seed size (" + LevelDifficulty.HARD.getRandomSeedSize() + "), Result: " + mathEquation.getResult(),
                    LevelDifficulty.HARD.getRandomSeedSize() >= mathEquation.getResult() &&
                            -1 * LevelDifficulty.HARD.getRandomSeedSize() <= mathEquation.getResult());
//            System.out.println(mathEquation.getX() + " / " + mathEquation.getY() + " = " + mathEquation.getResult());
        }

    }
}
