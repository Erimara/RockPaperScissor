package org.example.data;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.player.AddPlayer;
import org.example.entities.player.Player;
import org.example.moves.Move;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class History {

    private static final History instance = new History();
    private List<HashMap<String, List<Move>>> gameHistory = new ArrayList<>();
    private HashMap<String, List<Integer>> totalScore = new HashMap<>();

    private List<LocalDateTime> currentMatchDates = new ArrayList<>();

    private HashMap<String, HashMap<String, Integer>> playerWinsAgainstOpponent = new HashMap<>();


    private HashMap<String, Integer> winner = new HashMap<>();

    public static History getInstance() {
        return instance;
    }

    public void addTotalScore(String name, int score) {
        totalScore.computeIfAbsent(name, x -> new ArrayList<>()).add(score);
    }

    public void startNewGame(String opponentName, String playerName, List<Move> opponentMoves, List<Move> playerMoves) {
        HashMap<String, List<Move>> newGameHistory = new HashMap<>();
        newGameHistory.put(opponentName, opponentMoves);
        newGameHistory.put(playerName, playerMoves);
        gameHistory.add(newGameHistory);
        currentMatchDates.add(LocalDateTime.now());
    }


    public void displayHistory() {
        for (int i = 0; i < gameHistory.size(); i++) {
            HashMap<String, List<Move>> gameData = gameHistory.get(i);
            LocalDateTime matchDate = currentMatchDates.get(i);
            System.out.println("Matchdate " + matchDate + " Game data:" + gameData);
        }

        IntStream.range(0, gameHistory.size())
                .forEach(matchNumber -> {
                    System.out.println("Match: " + (matchNumber + 1));
                    HashMap<String, List<Move>> gameData = gameHistory.get(matchNumber);
                    System.out.println("Game data:" + gameData);
                    System.out.println();
                });
        displayWinners();
    }

    private void displayWinners() {
        System.out.println("LIST OF WINNERS: ");
        totalScore.forEach((key, value) -> {
            if (key.contains("Draw".toUpperCase())) {
                System.out.println("Draw: " + value.size());
            } else System.out.println(key + " has won " + value.size() + " times");
        });
    }

    public void displayAllStats(){
        displayStatsByPlayer();
        //whoWon(winner);
        displayStatsByOpponent();
    }

    public void displayStatsByPlayer() {
        Player currentPlayer = AddPlayer.getInstance().getCurrentPlayer();
        if (currentPlayer != null) {
            String currentPlayerName = currentPlayer.getName();

            List<Integer> playerWins = totalScore.get(currentPlayerName);
            int totalNumOfGames = totalScore.values().stream().mapToInt(List::size).sum();

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
    public void displayStatsByOpponent() {
        String currentPlayer = AddPlayer.getInstance().getCurrentPlayer().getName();
        displayPlayerWinsAgainstOpponents(currentPlayer);
    }


    public void playerWinsAgainstOpponent(String playerName, String opponentName) {
        playerWinsAgainstOpponent
                .computeIfAbsent(playerName, x -> new HashMap<>())
                .merge(opponentName, 1, Integer::sum);
    }
    public void displayPlayerWinsAgainstOpponents(String playerName) {
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


