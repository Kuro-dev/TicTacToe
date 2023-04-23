package logic;

public class TicTacToeGame {

    /**
     * y|x
     * <p>
     * 0 * 0|0 0|1 0|2
     * 1 * 1|0 1|1 1|2
     * 2 * 2|0 2|1 2|2
     */
    PlayerSymbol[][] playField = new PlayerSymbol[3][3];
    Player player1;
    Player player2;

    public TicTacToeGame(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
    }

    PlayerSymbol get(int x, int y) {
        return playField[y][x];
    }

    void set(int x, int y, PlayerSymbol symbol) {
        playField[y][x] = symbol;
    }

    /**
     * @return true if the game field is not full, and nobody won
     */
    public boolean checkGameRunning() {
        //TODO simplify this later on to only check first row/column
        for (int y = 0; y < playField.length; y++) {
            for (int x = 0; x < playField.length; x++) {
                checkSameSymbolRows(x, y);
            }
        }
        return true;
    }

    private void checkSameSymbolRows(int x, int y) {

    }


    public void start() {
        player1.setSymbol(PlayerSymbol.XSymbol);
        player2.setSymbol(PlayerSymbol.OSymbol);
        boolean player1Turn = true;
        while (checkGameRunning()) {
            if (player1Turn) {
                player1.doMove();
            } else {
                player2.doMove();
            }
            player1Turn = !player1Turn;
        }
    }
}
