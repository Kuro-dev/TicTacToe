import logic.ComputerPlayer;
import logic.HumanPlayer;
import logic.Player;
import logic.TicTacToeGame;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void test() {
        Player human = new HumanPlayer();
        Player computer = new ComputerPlayer();
        TicTacToeGame game = new TicTacToeGame(human, computer);
        game.checkGameRunning();
    }
}
