package gametests;

import logic.FieldPosition;
import logic.PlayField;
import logic.PlayerSymbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGameRunning {
    @Test
    public void testFieldPrintLine1() {
        PlayField field = new PlayField();
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        field.placeSymbol(PlayerSymbol.OSymbol, FieldPosition.TOP_MIDDLE);
        field.placeSymbol(PlayerSymbol.OSymbol, FieldPosition.TOP_RIGHT);

        String expected = """
                |X|O|O|
                | | | |
                | | | |
                """.trim();
        Assertions.assertEquals(expected, field.toString().trim());
    }

    @Test
    public void testFieldPrintLine2() {
        PlayField field = new PlayField();
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        field.placeSymbol(PlayerSymbol.OSymbol, FieldPosition.MIDDLE_RIGHT);
        String expected = """
                | | | |
                |X|X|O|
                | | | |
                """.trim();
        Assertions.assertEquals(expected, field.toString().trim());
    }

    @Test
    public void testFieldPrintLine3() {
        PlayField field = new PlayField();
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        field.placeSymbol(PlayerSymbol.OSymbol, FieldPosition.BOTTOM_MIDDLE);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_RIGHT);
        String expected = """
                | | | |
                | | | |
                |X|O|X|
                """.trim();
        Assertions.assertEquals(expected, field.toString().trim());

    }

}
