package org.example.data;

import org.example.entities.player.HandlePlayer;
import org.example.entities.player.Player;
import org.example.utils.ReturnToMenu;

import java.util.HashMap;
import java.util.List;

public class SpecificStats {

    private HashMap<String, HashMap<String, Integer>> playerWinsAgainstOpponent = new HashMap<>();
    private static final SpecificStats instance = new SpecificStats();
    public static SpecificStats getInstance() {
        return instance;
    }
    public void displayStatsByPlayer(HashMap<String, List<Integer>> totalWins) {
        Player currentPlayer = HandlePlayer.getInstance().getCurrentPlayer();
        if (currentPlayer != null) {
            String currentPlayerName = currentPlayer.getName();

            List<Integer> playerWins = totalWins.get(currentPlayerName);
            int totalNumOfGames = totalWins.values().stream().mapToInt(List::size).sum();

            if (playerWins != null) {
                int numPlayerWins = playerWins.size();
                float winPercentage = (float) numPlayerWins / totalNumOfGames * 100;

                System.out.println("Player " + currentPlayerName + " has won " + numPlayerWins + " times.");
                System.out.println(currentPlayerName + " has played " + totalNumOfGames + " games.");
                System.out.println("Your win percentage is: " + winPercentage + "%.");
            } else {
                System.out.println(currentPlayerName + " has not won any games yet.\n" +
                        "Games played: " + totalNumOfGames);
            }
        } else {
            System.out.println("No available data");
        }
    }
    public void addPlayerWins(String playerName, String opponentName) {
        playerWinsAgainstOpponent
                .computeIfAbsent(playerName, x -> new HashMap<>())
                .merge(opponentName, 1, Integer::sum);
    }
    public void displayStatsByOpponent() {
        Player player = HandlePlayer.getInstance().getCurrentPlayer();
        if (player != null) {
            String currentPlayer = HandlePlayer.getInstance().getCurrentPlayer().getName();
            playerVersusOpponent(currentPlayer);
            ReturnToMenu.returnToMainMenu();
        }
    }
    public void playerVersusOpponent(String playerName) {
        HashMap<String, Integer> playerWins = playerWinsAgainstOpponent.get(playerName);
        if (playerWins != null) {
            System.out.println("Wins by " + playerName + " against opponents:");
            playerWins.forEach((opponent, wins) -> {
                System.out.println(opponent + ": " + wins + " times");
            });
        } else {
            System.out.println(playerName + " has not won against any opponents.");
        }
    }
}
