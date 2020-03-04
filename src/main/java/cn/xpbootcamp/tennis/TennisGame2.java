package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.*;

public class TennisGame2 implements TennisGame {
    public int p1Point = 0;
    public int p2Point = 0;

    public String p1Result = "";
    public String p2Result = "";

    public String getScore() {
        String score = "";
        if (p1Point == p2Point) {
            score = calculatePointWhenPointEqual(p1Point);
        }

        if (p2Point == 0 || p1Point == 0) {
            score = calculatePointWhenPointEqualZero(score);

        }
        if (p1Point > p2Point && p1Point < 4) {
            score = calculatePointWhenPointLessFour();
        }
        if (p2Point > p1Point && p2Point < 4) {
            if (p2Point == 2)
                p2Result = THIRTY;
            if (p2Point == 3)
                p2Result = FORTY;
            if (p1Point == 1)
                p1Result = FIFTEEN;
            if (p1Point == 2)
                p1Result = THIRTY;
            score = p1Result + "-" + p2Result;
        }

        if (p1Point > p2Point && p2Point >= 3) {
            score = ADVANTAGE + " player1";
        }

        if (p2Point > p1Point && p1Point >= 3) {
            score = ADVANTAGE + " player2";
        }

        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) {
            score = WIN + " for player1";
        }
        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) {
            score = WIN + " for player2";
        }
        return score;
    }

    protected String calculatePointWhenPointLessFour() {
        String score;
        if (p1Point == 2)
            p1Result = THIRTY;
        if (p1Point == 3)
            p1Result = FORTY;
        if (p2Point == 1)
            p2Result = FIFTEEN;
        if (p2Point == 2)
            p2Result = THIRTY;
        score = p1Result + "-" + p2Result;
        return score;
    }

    protected String calculatePointWhenPointEqualZero(String score) {
        if (p1Point > 0) {
            p1Result = getPointLevelAboutPoint(p1Point);
            p2Result = "Love";
            score = p1Result + "-" + LOVE;
        }
        if (p2Point > 0) {
            p2Result = getPointLevelAboutPoint(p2Point);
            p1Result = "Love";
            score = LOVE + "-" + p2Result;
        }
        return score;
    }

    protected String getPointLevelAboutPoint(int point) {
        String result;
        switch (point) {
            case 1:
                result = FIFTEEN;
                break;
            case 2:
                result = THIRTY;
                break;
            case 3:
                result = FORTY;
                break;
            default:
                result = null;
        }
        return result;
    }

    protected String calculatePointWhenPointEqual(int point) {
        String pointText = "";
        switch (point) {
            case 0:
                pointText = LOVE;
                break;
            case 1:
                pointText = FIFTEEN;
                break;
            case 2:
                pointText = THIRTY;
                break;
            default:
                pointText = null;
                break;

        }
        if (pointText == null) {
            pointText = "Deuce";
        } else {
            pointText += ALL;
        }
        return pointText;
    }

    public void wonPoint(String player) {
        if (player == PLAYER_1)
            p1Point++;
        else
            p2Point++;
    }
}