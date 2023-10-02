package org.example.logic;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;
import org.example.entities.player.HandlePlayer;
import org.example.entities.player.PlayerMethods;

import java.util.Scanner;

public class SelectOpponent {
    private AllOpponents allOpponents = new AllOpponents();
    public void opponentSelection() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Select an opponent:
                1: Klockis
                2: Namnis
                3: Slumpis""");

        int choice = scanner.nextInt();

        Opponent selectedOpponent = null;
        PlayerMethods currentPlayer = HandlePlayer.getInstance().getCurrentPlayer();

        if (choice == 1) {
            selectedOpponent = allOpponents.getOpponents().get(0);
        } else if (choice == 2) {
            selectedOpponent = allOpponents.getOpponents().get(1);
        } else if (choice == 3) {
            selectedOpponent = allOpponents.getOpponents().get(2);
        }

        if (selectedOpponent != null) {
            RockPaperScissor rockPaperScissor = new RockPaperScissor(selectedOpponent, currentPlayer);
            rockPaperScissor.calculateWinner();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
