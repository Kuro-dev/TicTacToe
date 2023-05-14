package logic;

public class PlayField {

    private final PlayerSymbol[][] field = new PlayerSymbol[3][3];
    public final int length = field.length;

    public PlayerSymbol get(int x, int y) {
        return field[y][x];
    }

    public PlayerSymbol get(FieldPosition position) {
        return get(position.getX(), position.getY());
    }

    public void placeSymbol(PlayerSymbol symbol, FieldPosition position) {
        field[position.getY()][position.getX()] = symbol;
    }

    /**
     * Checks if a given position is an empty field
     *
     * @param position the position to check
     * @return true if its free, false otherwise
     */
    public boolean isPositionValid(FieldPosition position) {
        return position != null && isPositionValid(position.getX(), position.getY());
    }

    private boolean isPositionValid(int x, int y) {
        PlayerSymbol symbolAtPosition = get(x, y);
        return symbolAtPosition == null;
    }

    public boolean isFull() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (isPositionValid(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                PlayerSymbol symbol = get(x, y);
                String str = " ";
                if (symbol == PlayerSymbol.XSymbol) {
                    str = "X";
                } else if (symbol == PlayerSymbol.OSymbol) {
                    str = "O";
                }
                out.append("|").append(str);
            }
            out.append("|").append("\n");
        }
        return out.toString();
    }
}
