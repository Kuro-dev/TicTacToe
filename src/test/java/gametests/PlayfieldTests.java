package gametests;

import logic.FieldPosition;
import logic.PlayField;
import logic.PlayerSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayfieldTests {

    private PlayField field;

    @BeforeEach
    public void setup() {
        field = new PlayField();
    }

    @Test
    public void isSpotFree() {
        //then
        assertTrue(field.isSpotFree(FieldPosition.TOP_LEFT));

        //given
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        //then
        assertFalse(field.isSpotFree(FieldPosition.TOP_LEFT));
    }

    @Test
    public void isFieldFull() {
        //then
        assertFalse(field.isFull());

        //given
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_LEFT);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_MIDDLE);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.TOP_RIGHT);

        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_LEFT);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.MIDDLE_RIGHT);

        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_LEFT);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_MIDDLE);
        field.placeSymbol(PlayerSymbol.XSymbol, FieldPosition.BOTTOM_RIGHT);

        //then
        assertTrue(field.isFull());
    }
}
