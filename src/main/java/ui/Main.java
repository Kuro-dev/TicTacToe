package ui;

import logic.HumanPlayer;
import logic.Player;
import logic.TicTacToeGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1 = new HumanPlayer(input);
        Player player2 = new HumanPlayer(input);
        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.start();
    }
}
