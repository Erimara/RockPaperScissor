package org.example.logic;

import org.example.data.GameData;
import org.example.data.SpecificStats;
import org.example.entities.Opponent;
import org.example.entities.player.HandlePlayer;
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
    private String originalName = ""; // Saves original name to history/stats
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

        gameRules(playerMove,opponentMove);
    }
    public void gameRules(Move playerMove, Move opponentMove) {

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
    public void setRounds() {
        Scanner scanner = new Scanner(System.in);
        String resetPlayerName = currentPlayer.getName();
        originalName = resetPlayerName;

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
                    calculateWinner();
                    currentPlayer.setName(resetPlayerName);
                }
            }
        } else if (confirmRounds == 2) {
            ReturnToMenu.returnToMainMenu();
        }
    }
    private void calculateWinner() {
        String opponentName = opponent.getName();

        int playerScore = 0;
        int opponentScore = 0;
        if (opponentWins > playerWins) {
            System.out.println("Computer wins: " + opponentWins + "-" + playerWins);
            addData(2, originalName, playerScore,opponentName,opponentScore);
            ReturnToMenu.returnToMainMenu();
        }
        if (playerWins > opponentWins) {
            System.out.println("Player wins: " + playerWins + "-" + opponentWins);
            addData(1, originalName, playerScore,opponentName,opponentScore);
            ReturnToMenu.returnToMainMenu();
        }
        if (playerWins == opponentWins) {
            addData(3, originalName, playerScore,opponentName,opponentScore);
            ReturnToMenu.returnToMainMenu();
        }
    }

    private void addData(int playerOrOpponent, String playerName, int playerScore, String opponentName, int opponentScore){
        if (playerOrOpponent == 1){
            playerScore++;
            GameData.getInstance().addTotalWins(playerName, playerScore);
            GameData.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
            SpecificStats.getInstance().addPlayerWins(playerName, opponentName);
        } else if (playerOrOpponent == 2) {
            opponentScore++;
            GameData.getInstance().addTotalWins(opponentName, opponentScore);
            GameData.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
        } else if (playerOrOpponent == 3) {
            System.out.println("DRAW : " + playerWins + "-" + opponentWins);
            GameData.getInstance().startNewGame(opponentName, playerName, opponentMoves, playerMoves);
            GameData.getInstance().addTotalWins("Draw".toUpperCase(), 0);
        }
    }
}
