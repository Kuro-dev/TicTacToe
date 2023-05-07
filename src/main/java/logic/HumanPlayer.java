package logic;

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
        FieldPosition desiredPosition = getPositionFromInput(userInput);

        //TODO handle null values for invalid inputs
        while (!playField.isSpotFree(desiredPosition)) {
            System.out.println("Spot is unavailable, please choose another. :(");
            userInput = input.nextLine().trim();
            desiredPosition = getPositionFromInput(userInput);
        }

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
