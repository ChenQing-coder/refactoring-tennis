package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.*;

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;

    public void wonPoint(String playerName) {
        if (playerName == PLAYER_1)
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (score1 == score2) {
            score = calculateScoreWhenScoreEqual();
        } else if (score1 >= 4 || score2 >= 4) {
            score = calculateScoreStateWhenScoreMoreThanFour();
        } else {
            score = calculateScoreStateForOther(score);
        }
        return score;
    }

    String calculateScoreWhenScoreEqual() {
        String score;
        score = getScoreTextAboutScore(score1);
        if (score == null) {
            score = DEUCE;
        } else {
            score += ALL;
        }
        return score;
    }

    String calculateScoreStateForOther(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = score1;
            else {
                score += "-";
                tempScore = score2;
            }
            String scoreTextAboutScore = getScoreTextAboutScore(tempScore);
            if (scoreTextAboutScore == null) {
                score += FORTY;
            } else {
                score += scoreTextAboutScore;
            }
        }
        return score;
    }

    String calculateScoreStateWhenScoreMoreThanFour() {
        String score;
        int minusResult = score1 - score2;
        if (minusResult == 1) score = ADVANTAGE + " " + PLAYER_1;
        else if (minusResult == -1) score = ADVANTAGE + " " + PLAYER_2;
        else if (minusResult >= 2) score = WIN + " for " + PLAYER_1;
        else score = WIN + " for " + PLAYER_2;
        return score;
    }

    String getScoreTextAboutScore(int score) {
        String scoreText;
        switch (score) {
            case 0:
                scoreText = LOVE;
                break;
            case 1:
                scoreText = FIFTEEN;
                break;
            case 2:
                scoreText = THIRTY;
                break;
            default:
                scoreText = null;
                break;

        }
        return scoreText;
    }
}