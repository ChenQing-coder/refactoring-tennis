package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.*;

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;


    public void wonPoint(String playerName) {
        if (playerName == "player1")
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (score1 == score2) {
            score = calculateScoreStateWhenScoreEqual();
        } else if (score1 >= 4 || score2 >= 4) {
            score = calculateScoreStateWhenScoreMoreThanFour();
        } else {
            score = calculateScoreStateForOther(score);
        }
        return score;
    }

    protected String calculateScoreStateForOther(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = score1;
            else {
                score += "-";
                tempScore = score2;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    protected String calculateScoreStateWhenScoreMoreThanFour() {
        String score;
        int minusResult = score1 - score2;
        if (minusResult == 1) score = ADVANTAGE + " player1";
        else if (minusResult == -1) score = ADVANTAGE + " player2";
        else if (minusResult >= 2) score = WIN + " for player1";
        else score = WIN + " for player2";
        return score;
    }

    protected String calculateScoreStateWhenScoreEqual() {
        String score;
        switch (score1) {
            case 0:
                score = LOVE + "-All";
                break;
            case 1:
                score = FIFTEEN + "-All";
                break;
            case 2:
                score = THIRTY + "-All";
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }
}