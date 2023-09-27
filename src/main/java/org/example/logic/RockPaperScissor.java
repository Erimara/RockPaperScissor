package org.example.logic;

import org.example.data.History;
import org.example.entities.Opponent;
import org.example.entities.player.PlayerMethods;
import org.example.utils.ReturnToMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissor implements StartGame {
    private Opponent opponent;
    private PlayerMethods currentPlayer;
    private int opponentWins = 0;
    private int playerWins = 0;
    private List<Integer> playerMoves = new ArrayList<>();
    private List<Integer> opponentMoves = new ArrayList<>();

    public RockPaperScissor(Opponent opponent, PlayerMethods currentPlayer) {
        this.opponent = opponent;
        this.currentPlayer = currentPlayer;
    }


    public void rockPaperScissorLogic() {
        Scanner scanner = new Scanner(System.in);
        String opponentName = opponent.getName();
        String playerName = currentPlayer.getName();


        System.out.println("""
                Make your move!
                1: Rock
                2: Paper
                3: Scissor""");
        int choice = scanner.nextInt();

        int playerMove = currentPlayer.doMove(choice);

        int opponentMove = opponent.doMove();
        opponentMoves.add(opponentMove);
        playerMoves.add(playerMove);
        History.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
        // opponentMove, playerMove
        if (playerMove == opponentMove) {
            System.out.println("Draw");
        }

        if ((playerMove == 1 && opponentMove == 2) ||
                (playerMove == 2 && opponentMove == 3) ||
                (playerMove == 3 && opponentMove == 1)) {
            System.out.println(opponentName + "wins the round");
            History.getInstance().history();
            opponentWins++;
        } else {
            System.out.println("Player wins the round");
            History.getInstance().history();
            playerWins++;
        }
    }
    @Override
    public void calculateWinner() {
        Scanner scanner = new Scanner(System.in);
        String opponentName = opponent.getName();
        int playerScore = 0;
        int opponentScore = 0;
        System.out.println("How many rounds would you like to play?");
        int numOfRounds = scanner.nextInt();
        System.out.println("You have chosen " + numOfRounds + " number of rounds\n" +
                "1: Confirm\n" +
                "2: Return");
        int confirmRounds = scanner.nextInt();
        if (confirmRounds == 1) {
            for (int i = 1; i <= numOfRounds; i++) {
                System.out.println("ROUND " + i + "!");
                rockPaperScissorLogic();
                if (i == numOfRounds) {
                    if (opponentWins > playerWins) {
                        System.out.println("Computer wins: " + opponentWins + "-" + playerWins);
                        opponentScore++;
                        History.getInstance().addTotalScore(opponentName, opponentScore);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins > opponentWins) {
                        System.out.println("Player wins: " + playerWins + "-" + opponentWins);
                        playerScore++;
                        History.getInstance().addTotalScore("Player", playerScore);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins == opponentWins) {
                        System.out.println("DRAW : " + playerWins + "-" + opponentWins);
                        ReturnToMenu.returnToMainMenu();
                    }
                    System.out.println("Total wins ");
                }
            }
        } else if (confirmRounds == 2) {
            ReturnToMenu.returnToMainMenu();
        }
    }
}
