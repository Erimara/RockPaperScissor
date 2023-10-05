package org.example.logic;

import org.example.entities.player.PlayerName;
import org.example.entities.opponent.Opponent;
import org.example.entities.player.PlayerMoves;
import org.example.moves.Move;
import org.example.utils.ReturnToMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissor {
    private final Opponent opponent;
    private final PlayerMoves currentPlayer;
    private final PlayerName currentPlayerName;
    private int opponentWins = 0;
    private int playerWins = 0;
    private List<Move> playerMoves = new ArrayList<>();
    private List<Move> opponentMoves = new ArrayList<>();
    private String originalName = ""; // Saves original name to history/stats
    public RockPaperScissor(Opponent opponent, PlayerMoves currentPlayer, PlayerName currentPlayerName) {
        this.opponent = opponent;
        this.currentPlayer = currentPlayer;
        this.currentPlayerName = currentPlayerName;
    }
    private void chooseMove() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        Move playerMove = null;
        int choice;
        while (!validInput) {
            System.out.println("""
                    Make your move!
                    1: Rock
                    2: Paper
                    3: Scissor""");
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 3) {
                playerMove = currentPlayer.doMove(choice);
                validInput = true;
            } else {
                System.out.println("Invalid choice. Please choose a valid option");
            }
        }
        Move opponentMove = opponent.doMove();
        opponentMoves.add(opponentMove);
        playerMoves.add(playerMove);

        gameRules(playerMove, opponentMove);
    }
    public void setRounds() {
        Scanner scanner = new Scanner(System.in);
        originalName = currentPlayerName.getName();

        System.out.println("How many rounds would you like to play?");
        int numOfRounds = scanner.nextInt();
        System.out.println("You have chosen " + numOfRounds + " number of rounds\n" +
                "1: Confirm\n" +
                "2: Return");
        int confirmRounds = scanner.nextInt();
        if (confirmRounds == 1) {
            for (int i = 1; i <= numOfRounds; i++) {
                System.out.println("ROUND " + i + "!");

                chooseMove(); // Starts game

                if (i == numOfRounds) {
                    WinnerData winnerData = new WinnerData(
                            opponent,
                            originalName,
                            opponentMoves,
                            playerMoves,
                            playerWins,
                            opponentWins
                    );
                    winnerData.calculateWinner();
                    currentPlayerName.setName(originalName);
                }
            }
        } else if (confirmRounds == 2) {
            ReturnToMenu.returnToMainMenu();
        }
    }
    private void gameRules(Move playerMove, Move opponentMove) {
        if (playerMove != null) {
        if (playerMove.equals(opponentMove)) {
            System.out.println("Draw");
        } else if ((playerMove == Move.ROCK && opponentMove == Move.SCISSOR) ||
                (playerMove == Move.PAPER && opponentMove == Move.ROCK) ||
                (playerMove == Move.SCISSOR && opponentMove == Move.PAPER)) {
            playerWins++;
        } else if ((opponentMove == Move.ROCK && playerMove == Move.SCISSOR) ||
                (opponentMove == Move.PAPER && playerMove == Move.ROCK) ||
                (opponentMove == Move.SCISSOR && playerMove == Move.PAPER)) {
            opponentWins++;
        }
    }
    }
}
