/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import static com.github.blh0021.TicTacToe.*;

public class TicTacToeTest {
    @Test
    public void createNewBoardMethod() {
        ///tictactoe.TicTacToe ttt = new tictactoe.TicTacToe();
        assertEquals("new board should be *********", createNewBoard(), "*********");
    }

    @Test
    public void minMaxMethod() {
        //"*********"
        char[] board = "xo*x****o".toCharArray();
        int a = minMax(board, 'x', 'x', 1);
        assertEquals("a = ", a, 6);

        board = "xo*x*****".toCharArray();
        a = minMax(board, 'o', 'o', 1);
        assertEquals("a = ", a, 6);
    }

    @Test
    public void scoreBoardMethod() {
        char[] board = "xo*x*****".toCharArray();
        int a = scoreBoard(board, 'x');
        assertEquals("a = ", a, 11);
    }

    @Test public void playGame() {
        char[] board = "*********".toCharArray();
        for (int i=0; i<6; i++) {
            if (i%2 == 0) {
                board = play(board, 'x');
            } else {
                board = play(board, 'o');
            }
        }
        assertEquals("b=", String.valueOf(board), "**ooxxx*o");
    }
}
