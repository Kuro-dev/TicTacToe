package logic;

public enum FieldPosition {
    TOP_LEFT(0, 0),
    TOP_MIDDLE(1, 0),
    TOP_RIGHT(2, 0),
    MIDDLE_LEFT(0, 1),
    MIDDLE(1, 1),
    MIDDLE_RIGHT(2, 1),
    BOTTOM_LEFT(0, 2),
    BOTTOM_MIDDLE(1, 2),
    BOTTOM_RIGHT(2, 2);

    private final int x;
    private final int y;

    FieldPosition(int x, int y) {
        this.x = x;

        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
