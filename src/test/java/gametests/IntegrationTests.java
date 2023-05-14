package gametests;

import logic.Player;
import logic.TicTacToeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTests {
    @Test
    public void testGameWonByColumn() {
        Player player1 = new TestPlayer("top_left\nmiddle_left\nbottom_left\n");
        Player player2 = new TestPlayer("top_middle\nmiddle\nbottom_middle\n");
        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.start();
        //game is over, check game state
        Assertions.assertEquals(player1, game.getWinner());

        //check if game resets accordingly
        game.reset();
        Assertions.assertNull(game.getWinner(), "The previous games winner was not reset properly");
    }
    @Test
    public void testGameWonByRow() {
        Player player1 = new TestPlayer("top_left\ntop_middle\ntop_right\n");
        Player player2 = new TestPlayer("middle_right\nmiddle\nmiddle_right\n");
        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.start();
        //game is over, check game state
        Assertions.assertEquals(player1, game.getWinner());
    }
    @Test
    public void testGameWonByTopLeftDiagonal() {
        Player player1 = new TestPlayer("top_left\nmiddle\nbottom_right\n");
        Player player2 = new TestPlayer("middle_left\ntop_right\nbottom_left\n");
        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.start();
        //game is over, check game state
        Assertions.assertEquals(player1, game.getWinner());
    }
    @Test
    public void testGameWonByBottomLeftDiagonal() {
        Player player1 = new TestPlayer("bottom_left\nmiddle\ntop_right\n");
        Player player2 = new TestPlayer("middle_left\nbottom_right\ntop_left\n");
        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.start();
        //game is over, check game state
        Assertions.assertEquals(player1, game.getWinner());
    }
}
