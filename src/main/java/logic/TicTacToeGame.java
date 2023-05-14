package logic;

public class TicTacToeGame {

    /**
     * y|x
     * <p>
     * 0 * 0|0 0|1 0|2
     * 1 * 1|0 1|1 1|2
     * 2 * 2|0 2|1 2|2
     */
    PlayField playField = new PlayField();
    Player player1;
    Player player2;

    Player winner = null;

    public TicTacToeGame(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
    }

    private boolean checkAnyPlayerHasWon() {
        for (int i = 0; i < playField.length; i++) {
            boolean resultRow = checkSameSymbolRow(i);
            if (resultRow) return true;
            boolean resultColumn = checkSameSymbolColumn(i);
            if (resultColumn) return true;
        }
        boolean diagonalWin = checkSameSymbolDiagonal();
        if (diagonalWin) return true;

        return false;
    }

    /**
     * @return true if the game field is not full, and nobody won
     */
    public boolean checkGameRunning() {
        if (checkAnyPlayerHasWon())
            return false;
        //nobody won
        //return whether or not the field has space left
        return !playField.isFull();
    }

    public PlayField getField() {
        return playField;
    }

    private boolean checkSameSymbolDiagonal() {

        PlayerSymbol topLeft = playField.get(FieldPosition.TOP_LEFT);
        PlayerSymbol middle = playField.get(FieldPosition.MIDDLE);
        PlayerSymbol bottomRight = playField.get(FieldPosition.BOTTOM_RIGHT);

        PlayerSymbol bottomLeft = playField.get(FieldPosition.BOTTOM_LEFT);
        PlayerSymbol topRight = playField.get(FieldPosition.TOP_RIGHT);

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
        PlayerSymbol first = playField.get(x, 0);
        PlayerSymbol second = playField.get(x, 1);
        PlayerSymbol third = playField.get(x, 2);

        if (first == null || second == null || third == null) {
            return false;
        }

        if (first == second) {
            return first == third;
        }
        return false;
    }

    private boolean checkSameSymbolRow(int y) {
        PlayerSymbol first = playField.get(0, y);
        PlayerSymbol second = playField.get(1, y);
        PlayerSymbol third = playField.get(2, y);

        if (first == null || second == null || third == null) {
            return false;
        }

        if (first == second) {
            return first == third;
        }
        return false;
    }


    public void start() {
        player1.setSymbol(PlayerSymbol.XSymbol);
        player2.setSymbol(PlayerSymbol.OSymbol);
        boolean player1Turn = true;
        while (checkGameRunning()) {
            if (player1Turn) {
                player1.doMove(playField);
            } else {
                player2.doMove(playField);
            }
            player1Turn = !player1Turn;
        }
        //Game is done

        System.out.println(playField);

        if (checkAnyPlayerHasWon()) {
            if (!player1Turn) {
                //player 2 would be the next to make his move, but game is already over. Means player 1 has won
                System.out.println("player 1 has won!");
                winner = player1;
            } else {
                //player 1 would be the next to make his move, but game is already over. Means player 2 has won
                System.out.println("player 2 has won!");
                winner = player2;
            }
        }
    }

    public Player getWinner() {
        return winner;
    }

    public void reset() {
        winner = null;
        FieldPosition[] positions = FieldPosition.values();

        for (int i = 0; i < positions.length; i++) {
            FieldPosition position = positions[i];
            playField.placeSymbol(null, position);
        }
    }
}
