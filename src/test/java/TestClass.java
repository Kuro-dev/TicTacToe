import logic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClass {

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
        game.set(0, 0, PlayerSymbol.XSymbol);
        game.set(1, 0, PlayerSymbol.XSymbol);
        game.set(2, 0, PlayerSymbol.OSymbol);
        //row 2
        game.set(0, 1, PlayerSymbol.OSymbol);
        game.set(1, 1, PlayerSymbol.XSymbol);
        game.set(2, 1, PlayerSymbol.XSymbol);
        //row 3
        game.set(0, 2, PlayerSymbol.XSymbol);
        game.set(1, 2, PlayerSymbol.OSymbol);
        game.set(2, 2, PlayerSymbol.OSymbol);
        //then
        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void  testGameResetMethod(){
        //given
        game.set(0, 0, PlayerSymbol.XSymbol);
        game.set(1, 0, PlayerSymbol.XSymbol);
        game.set(2, 0, PlayerSymbol.XSymbol);
        //when
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        //then
        Assertions.assertTrue(game.checkGameRunning());
    }
    @Test
    public void checkGameRunningHorizontalWin() {
        //given
        game.set(0, 0, PlayerSymbol.XSymbol);
        game.set(1, 0, PlayerSymbol.XSymbol);
        game.set(2, 0, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.set(0, 1, PlayerSymbol.XSymbol);
        game.set(1, 1, PlayerSymbol.XSymbol);
        game.set(2, 1, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.set(0, 2, PlayerSymbol.XSymbol);
        game.set(1, 2, PlayerSymbol.XSymbol);
        game.set(2, 2, PlayerSymbol.XSymbol);

        //then
        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void checkGameRunningVerticalWin() {
        //given
        game.set(0, 0, PlayerSymbol.XSymbol);
        game.set(0, 1, PlayerSymbol.XSymbol);
        game.set(0, 2, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.set(1, 0, PlayerSymbol.XSymbol);
        game.set(1, 1, PlayerSymbol.XSymbol);
        game.set(1, 2, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.set(2, 0, PlayerSymbol.XSymbol);
        game.set(2, 1, PlayerSymbol.XSymbol);
        game.set(2, 2, PlayerSymbol.XSymbol);

        //then
        Assertions.assertFalse(game.checkGameRunning());
    }

    @Test
    public void checkGameRunningDiagonalWin() {
        //given
        game.set(0, 0, PlayerSymbol.XSymbol);
        game.set(1, 1, PlayerSymbol.XSymbol);
        game.set(2, 2, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();

        game.set(2, 0, PlayerSymbol.XSymbol);
        game.set(1, 1, PlayerSymbol.XSymbol);
        game.set(0, 2, PlayerSymbol.XSymbol);
        Assertions.assertFalse(game.checkGameRunning());
        game.reset();
    }
}
