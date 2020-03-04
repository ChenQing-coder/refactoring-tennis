package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constants.*;

public class TennisGame3 implements TennisGame {

    private int p1Score;
    private int p2Score;
    private String personName1;
    private String personName2;

    public TennisGame3(String personName1, String personName2) {
        this.personName1 = personName1;
        this.personName2 = personName2;
    }

    public String getScore() {
        String s;
        if (p2Score < 4 && p1Score < 4 && !(p2Score + p1Score == 6)) {
            String[] p = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};
            s = p[p2Score];
            return (p2Score == p1Score) ? s + ALL : s + "-" + p[p1Score];
        } else {
            if (p2Score == p1Score)
                return DEUCE;
            s = p2Score > p1Score ? personName1 : personName2;
            return ((p2Score - p1Score) * (p2Score - p1Score) == 1) ? ADVANTAGE + " " + s : WIN + " for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == PLAYER_1)
            this.p2Score += 1;
        else
            this.p1Score += 1;

    }

}