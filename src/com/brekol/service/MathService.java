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

    public String getMathEquation(LevelDifficulty levelDifficulty, MathParameter mathParameter) {

        // 60% for correct equation
        boolean correctEquation = (random.nextInt(100) + 1) > 40;

        MathEquation result = getCorrectResultFor(mathParameter, levelDifficulty);

        if (!correctEquation) {
            result = makeResultIncorrectFor(result);
        }

        return result.toString();

    }

    private MathEquation makeResultIncorrectFor(MathEquation mathEquation) {
        while (mathEquation.isCorrect()) {
            mathEquation.setY(random.nextInt(mathEquation.getY()));
        }
        return mathEquation;
    }

    private MathEquation getCorrectResultFor(MathParameter mathParameter, LevelDifficulty levelDifficulty) {
        MathEquation mathEquation = null;
        switch (mathParameter) {
            case ADD:
                mathEquation.setMathParameter(MathParameter.ADD);
                return getAddResult(levelDifficulty);
            case SUB:
                mathEquation.setMathParameter(MathParameter.SUB);
                return getSubResult(levelDifficulty);
            case MUL:
                mathEquation.setMathParameter(MathParameter.MUL);
                return getMulResult(levelDifficulty);
            case DIV:
                mathEquation.setMathParameter(MathParameter.DIV);
                return getDivResult(levelDifficulty);
            case ALL:
                switch (random.nextInt(4)) {
                    case 0:
                        mathEquation.setMathParameter(MathParameter.ADD);
                        return getAddResult(levelDifficulty);
                    case 1:
                        mathEquation.setMathParameter(MathParameter.SUB);
                        return getSubResult(levelDifficulty);
                    case 2:
                        mathEquation.setMathParameter(MathParameter.MUL);
                        return getMulResult(levelDifficulty);
                    case 3:
                        mathEquation.setMathParameter(MathParameter.DIV);
                        return getDivResult(levelDifficulty);
                    default:
                        throw new UnsupportedOperationException();
                }
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MathEquation getAddResult(LevelDifficulty levelDifficulty) {
        MathEquation mathEquation = new MathEquation();

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

    public MathEquation getSubResult(LevelDifficulty levelDifficulty) {
        MathEquation mathEquation = new MathEquation();

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

    public MathEquation getMulResult(LevelDifficulty levelDifficulty) {
        MathEquation mathEquation = new MathEquation();

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

    public MathEquation getDivResult(LevelDifficulty levelDifficulty) {
        MathEquation mathEquation = new MathEquation();

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
