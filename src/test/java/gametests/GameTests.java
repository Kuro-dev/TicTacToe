package gametests;

import logic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTests {
    TicTacToeGame game;

    @BeforeEach
    public void setup() {
        Player human = new HumanPlayer(null);
        Player computer = new ComputerPlayer();
        game = new TicTacToeGame(human, computer);
    }

    //check if the elements are full
    //check if the rows are the same
    //check if the columns are the same
    //

    @Test
    public void checkGameRunning() {
        //then
        Assertions.assertTrue(game.checkGameRunning());
    }

    /**
     * X X O
     * O X X
     * X O O
     */
    @Test
    public void checkGameRunningWhenFieldIsFull() {
        //given
        //row 1
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        game.getField().placeSymbol(PlayerSymbol.OSymbol, FieldPosition.BOTTOM_LEFT);
        //row 2
        game.getField().placeSymbol(PlayerSymbol.OSymbol, FieldPosition.TOP_MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_MIDDLE);
        //row 3
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_RIGHT);
        game.getField().placeSymbol(PlayerSymbol.OSymbol, FieldPosition.MIDDLE_RIGHT);
        game.getField().placeSymbol(PlayerSymbol.OSymbol, FieldPosition.BOTTOM_RIGHT);
        //then

        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void testGameResetMethod() {
        //given
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        //when
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        //then
        Assertions.assertTrue(game.checkGameRunning());
    }

    @Test
    public void checkGameRunningHorizontalWin() {
        //given
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_MIDDLE);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_RIGHT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_RIGHT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_RIGHT);

        //then
        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void checkGameRunningVerticalWin() {
        //given
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_RIGHT);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_RIGHT);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_RIGHT);

        //then
        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void checkGameRunningDiagonalWin() {
        //given
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_RIGHT);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        game.getField().placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_RIGHT);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();
    }
}
