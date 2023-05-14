package gametests;

import logic.HumanPlayer;

import java.util.Scanner;

public class TestPlayer extends HumanPlayer {
    public TestPlayer(String input) {
        super(new Scanner(input));
    }
}
