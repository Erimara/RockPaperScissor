package org.example.logic;

import org.example.data.History;
import org.example.entities.Opponent;
import org.example.entities.player.PlayerMethods;
import org.example.moves.Move;
import org.example.utils.ReturnToMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissor implements StartGame {
    private Opponent opponent;
    private PlayerMethods currentPlayer;
    private int opponentWins = 0;
    private int playerWins = 0;
    private List<Move> playerMoves = new ArrayList<>();
    private List<Move> opponentMoves = new ArrayList<>();

    public RockPaperScissor(Opponent opponent, PlayerMethods currentPlayer) {
        this.opponent = opponent;
        this.currentPlayer = currentPlayer;
    }

    private void rockPaperScissor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Make your move!
                1: Rock
                2: Paper
                3: Scissor""");
        int choice = scanner.nextInt();

        Move playerMove = currentPlayer.doMove(choice);
        Move opponentMove = opponent.doMove();
        opponentMoves.add(opponentMove);
        playerMoves.add(playerMove);
        determineWinner(playerMove,opponentMove);
    }
    public void determineWinner(Move playerMove, Move opponentMove) {
        if (playerMove.equals(opponentMove)) {
            System.out.println("Draw");
        } else if ((playerMove == Move.ROCK && opponentMove == Move.SCISSOR) ||
                (playerMove == Move.PAPER && opponentMove == Move.ROCK) ||
                (playerMove == Move.SCISSOR && opponentMove == Move.PAPER)) {
            playerWins++;
            currentPlayer.getName();
        } else if ((opponentMove == Move.ROCK && playerMove == Move.SCISSOR) ||
                (opponentMove == Move.PAPER && playerMove == Move.ROCK) ||
                (opponentMove == Move.SCISSOR && playerMove == Move.PAPER)) {
            opponentWins++;
            opponent.getName();
        }

    }
    @Override
    public void calculateWinner() {
        Scanner scanner = new Scanner(System.in);
        String opponentName = opponent.getName();
        String playerName = currentPlayer.getName();

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

                rockPaperScissor(); // Calling RPS rules

                if (i == numOfRounds) {

                    if (opponentWins > playerWins) {
                        System.out.println("Computer wins: " + opponentWins + "-" + playerWins);
                        opponentScore++;
                        History.getInstance().addTotalScore(opponentName, opponentScore);
                        History.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins > opponentWins) {
                        System.out.println("Player wins: " + playerWins + "-" + opponentWins);
                        playerScore++;
                        History.getInstance().addTotalScore(playerName, playerScore);
                        History.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
                        History.getInstance().playerWinsAgainstOpponent(playerName, opponentName);
                        ReturnToMenu.returnToMainMenu();
                    }
                    if (playerWins == opponentWins) {
                        System.out.println("DRAW : " + playerWins + "-" + opponentWins);
                        History.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
                        History.getInstance().addTotalScore("Draw".toUpperCase(), 0);
                        ReturnToMenu.returnToMainMenu();
                    }
                }
            }
        } else if (confirmRounds == 2) {
            ReturnToMenu.returnToMainMenu();
        }
    }

}
