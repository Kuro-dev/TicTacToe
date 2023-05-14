package logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Scanner input;
    private PlayerSymbol symbol;

    public HumanPlayer(Scanner input) {

        this.input = input;
    }

    @Override
    public void setSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public void doMove(PlayField playField) {
        System.out.println(playField);
        System.out.println("Where do you want to place your symbol?");
        String userInput = input.nextLine().trim();
        FieldPosition desiredPosition = getPositionFromInput(userInput); //nullable

        //TODO handle null values for invalid input
        while (!playField.isPositionValid(desiredPosition)) {
            if (desiredPosition == null) {
                System.out.println("Please enter a valid position (not case sensitive):");
                System.out.println("top_left, top_middle, top_right, " +
                        "middle_left, middle, middle_right, bottom_left, " +
                        "bottom_middle and bottom_right");
            } else {
                System.out.println("Spot is unavailable, please choose another. :(");
            }
            userInput = input.nextLine().trim();
            desiredPosition = getPositionFromInput(userInput);
        }
        assert desiredPosition != null;
        //Player has inputted a valid position to put their symbol in
        playField.placeSymbol(symbol, desiredPosition);
    }

    private FieldPosition getPositionFromInput(String userInput) {
        for (FieldPosition position : FieldPosition.values()) {
            if (position.name().equalsIgnoreCase(userInput)) {
                return position;
            }
        }
        return null;
    }
}
