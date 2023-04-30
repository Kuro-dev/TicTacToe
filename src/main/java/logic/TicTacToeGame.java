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

    public void set(int x, int y, PlayerSymbol symbol) {
        playField[y][x] = symbol;
    }

    /**
     * @return true if the game field is not full, and nobody won
     */
    public boolean checkGameRunning() {
        for (int i = 0; i < playField.length; i++) {
            boolean resultRow = checkSameSymbolRow(i);
            if (resultRow) return false;
            boolean resultColumn = checkSameSymbolColumn(i);
            if (resultColumn) return false;
        }
        boolean diagonalWin = checkSameSymbolDiagonal();
        if (diagonalWin) return false;

        for (PlayerSymbol[] row : playField) {
            for (PlayerSymbol item : row) {
                if (item == null) return true;
            }
        }

        //nobody won
        //no field is empty
        return false;
    }

    private boolean checkSameSymbolDiagonal() {

        PlayerSymbol topLeft = get(0, 0);
        PlayerSymbol middle = get(1, 1);
        PlayerSymbol bottomRight = get(2, 2);

        PlayerSymbol bottomLeft = get(0, 2);
        PlayerSymbol topRight = get(2, 0);

        if (middle == null) {
            return false;
        }

        if (topLeft == middle) {
            return topLeft == bottomRight;
        }

        if (bottomLeft == middle) {
            return bottomLeft == topRight;
        }

        return false;

    }

    /**
     * y|x
     * <p>
     * 0 * 0|0 0|1 0|2
     * 1 * 1|0 1|1 1|2
     * 2 * 2|0 2|1 2|2
     */
    private boolean checkSameSymbolColumn(int x) {
        PlayerSymbol first = get(x, 0);
        PlayerSymbol second = get(x, 1);
        PlayerSymbol third = get(x, 2);

        if (first == null || second == null || third == null) {
            return false;
        }

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
