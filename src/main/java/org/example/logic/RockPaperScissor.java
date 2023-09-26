package org.example.logic;

import org.example.entities.EntityMove;
import org.example.player.AddPlayer;
import org.example.player.Player;
import org.example.utils.ReturnToMenu;
import org.example.utils.data.PlayerPoints;

import java.util.Scanner;

public class RockPaperScissor implements StartGame {
    private EntityMove entityMove;
    private Player player;
    private int computerWins = 0;
    private int playerWins = 0;
    private Rounds rounds = new Rounds();
    AddPlayer addPlayer = new AddPlayer();

    public RockPaperScissor(EntityMove entityMove) {
        this.entityMove = entityMove;
        this.player = player;
    }

    private int addPoints() {
        return 1;
    }

    @Override
    public void rockPaperScissor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rounds would you like to play?");
        int numOfRounds = scanner.nextInt();
        System.out.println("You have chosen " + numOfRounds + " number of rounds\n" +
                "1: Confirm\n" +
                "2: Return");
        int confirmRounds = scanner.nextInt();
        if (confirmRounds == 1) {
            for (int i = 1; i <= numOfRounds; i++) {
                System.out.println("ROUND " + i + "!!!");
                rockPaperScissorLogic();
                if (i == numOfRounds) {
                    if (computerWins > playerWins) {
                        System.out.println("Computer wins: " + computerWins + "-" + playerWins);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins > computerWins) {
                        System.out.println("Player wins: " + playerWins + "-" + computerWins);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins == computerWins) {
                        System.out.println("DRAW : " + playerWins + "-" + computerWins);
                        ReturnToMenu.returnToMainMenu();
                    }
                    System.out.println("Total wins ");
                }
            }
        } else if (confirmRounds == 2) {
            ReturnToMenu.returnToMainMenu();
        }
    }

    public void rockPaperScissorLogic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Make your move!
                1: Rock
                2: Paper
                3: Scissor""");
        int choice = scanner.nextInt();
        int playerMove = Player.move(choice);

        int computerMove = entityMove.doMove();

        if (playerMove == computerMove) {
            System.out.println("Draw");
        } else if ((playerMove == 1 && computerMove == 2) ||
                (playerMove == 2 && computerMove == 3) ||
                (playerMove == 3 && computerMove == 1)) {
            System.out.println("Computer wins the round");
            computerWins++;
            // Increment computer points
        } else {
            PlayerPoints playerList = new PlayerPoints();
            playerList.getPlayerName(addPlayer.getPlayerList());
            System.out.println("Player wins the round");
            playerWins++;
            // Increment player - <<< Does NOT work ATM
        }
    }
}
