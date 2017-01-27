package com.github.blh0021;

public class TicTacToe {
    public static String hello() {
        return "hello";
    }

    public static final int boardMatrix[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
            { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

    public static char otherPiece(char p) {
        if (p == 'x')
            return 'o';
        else
            return 'x';
    }

    public static String createNewBoard() {
        return "*********";
    }

    public static int scoreBoard(char[] b, char p) {

        int score = 0;
        for (int i = 0; i < boardMatrix.length; i++) {
            int x = 0;
            int o = 0;
            int s = 0;
            for (int j = 0; j < 3; j++) {
                if (b[boardMatrix[i][j]] == p)
                    x++;
                if (b[boardMatrix[i][j]] == otherPiece(p))
                    o++;
                if (b[boardMatrix[i][j]] == '*')
                    s++;
            }
            if (x == 3)
                score += 100;
            if (o == 3)
                score += 100;
            if (x == 2 && s == 1)
                score += 10;
            if (o == 2 && s == 1)
                score += -10;
            if (o == 2 && x == 1)
                score += 100;
            if (x == 1 && s == 2)
                score += 1;
            if (o == 1 && s == 2)
                score += -1;

        }

        return score;
    }

    public static int minMax(char[] b, char p, char t, int depth) {
        int bestScore = (t == p) ? -100 : 100;
        int currentScore;
        int move = -1;

        //bestScore = scoreBoard(b, p);

        for (int i = 0; i < b.length; i++) {
            if (b[i] == '*') {
                b[i] = t;
                currentScore = scoreBoard(b, p);
                if (currentScore >= bestScore) {
                    bestScore = currentScore;
                    move = i;
                }
                b[i] = '*';
            }
        }
        //if (depth == 1)
        return move;
        //else
       //     return bestScore;
    }

    public static char[] play(char[] b, char p) {
        int m = minMax(b, p, p, 1);
        b[m] = p;
        return b;
    }

    public static String nextMove(String board, char p) {
        char[] b = board.toCharArray();
        int m = minMax(b, p, p, 1);
        b[m] = p;
        return String.valueOf(b);
    }
}
