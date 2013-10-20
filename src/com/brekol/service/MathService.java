package com.brekol.service;

import com.brekol.model.shape.MathEquation;
import com.brekol.util.LevelDifficulty;
import com.brekol.util.MathParameter;

import java.util.Random;

/**
 * User: Breku
 * Date: 18.10.13
 */
public class MathService extends BaseService {

    private Random random = new Random();

    public MathEquation getMathEquation(LevelDifficulty levelDifficulty, MathParameter mathParameter) {

        // 60% for correct equation
        boolean correctEquation = (random.nextInt(100) + 1) > 40;

        MathEquation result = getCorrectResultFor(mathParameter, levelDifficulty);

        if (!correctEquation) {
            result = makeResultIncorrectFor(result);
        }

        return result;

    }

    private MathEquation makeResultIncorrectFor(MathEquation mathEquation) {
        while (mathEquation.isCorrect()) {
            if (mathEquation.getY() == 0) {
                mathEquation.setY(1);
                return mathEquation;
            } else {

            }
            mathEquation.setY(random.nextInt(Math.abs(mathEquation.getY())));
        }
        return mathEquation;
    }

    private MathEquation getCorrectResultFor(MathParameter mathParameter, LevelDifficulty levelDifficulty) {
        switch (mathParameter) {
            case ADD:
                return getAddResult(levelDifficulty, mathParameter);
            case SUB:
                return getSubResult(levelDifficulty, mathParameter);
            case MUL:
                return getMulResult(levelDifficulty, mathParameter);
            case DIV:
                return getDivResult(levelDifficulty, mathParameter);
            case ALL:
                switch (random.nextInt(4)) {
                    case 0:
                        return getAddResult(levelDifficulty, mathParameter);
                    case 1:
                        return getSubResult(levelDifficulty, mathParameter);
                    case 2:
                        return getMulResult(levelDifficulty, mathParameter);
                    case 3:
                        return getDivResult(levelDifficulty, mathParameter);
                    default:
                        throw new UnsupportedOperationException();
                }
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MathEquation getAddResult(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        MathEquation mathEquation = new MathEquation();
        mathEquation.setMathParameter(mathParameter);

        if (levelDifficulty.isMinusAllowed()) {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize()) {
                mathEquation.setX(random.nextInt() % levelDifficulty.getRandomSeedSize());
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() + mathEquation.getY());
            }
        } else {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize()) {
                mathEquation.setX(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() + mathEquation.getY());
            }
        }

        return mathEquation;
    }

    public MathEquation getSubResult(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        MathEquation mathEquation = new MathEquation();
        mathEquation.setMathParameter(mathParameter);

        if (levelDifficulty.isMinusAllowed()) {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize()) {
                mathEquation.setX(random.nextInt() % levelDifficulty.getRandomSeedSize());
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() - mathEquation.getY());
            }
        } else {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize() ||
                    mathEquation.getResult() < 0) {
                mathEquation.setX(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() - mathEquation.getY());
            }
        }

        return mathEquation;

    }

    public MathEquation getMulResult(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        MathEquation mathEquation = new MathEquation();
        mathEquation.setMathParameter(mathParameter);

        if (levelDifficulty.isMinusAllowed()) {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize()) {
                mathEquation.setX(random.nextInt() % levelDifficulty.getRandomSeedSize());
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() * mathEquation.getY());
            }
        } else {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize() ||
                    mathEquation.getResult() < 0) {
                mathEquation.setX(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setResult(mathEquation.getX() * mathEquation.getY());
            }
        }

        return mathEquation;

    }

    public MathEquation getDivResult(LevelDifficulty levelDifficulty, MathParameter mathParameter) {
        MathEquation mathEquation = new MathEquation();
        mathEquation.setMathParameter(mathParameter);

        if (levelDifficulty.isMinusAllowed()) {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize() ||
                    mathEquation.getX() % mathEquation.getY() != 0) {
                mathEquation.setX(random.nextInt() % levelDifficulty.getRandomSeedSize());
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()) + 1);
                mathEquation.setResult(mathEquation.getX() / mathEquation.getY());
            }
        } else {
            while (mathEquation.getResult() == null || Math.abs(mathEquation.getResult()) > levelDifficulty.getRandomSeedSize() ||
                    mathEquation.getResult() < 0 || mathEquation.getX() % mathEquation.getY() != 0) {
                mathEquation.setX(random.nextInt(levelDifficulty.getRandomSeedSize()));
                mathEquation.setY(random.nextInt(levelDifficulty.getRandomSeedSize()) + 1);
                mathEquation.setResult(mathEquation.getX() / mathEquation.getY());
            }
        }

        return mathEquation;

    }


}
