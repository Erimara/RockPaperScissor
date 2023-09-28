package org.example.data;

import org.example.entities.Opponent;
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
    private HashMap<String,List<Integer>> totalScore = new HashMap<>();

    private List<LocalDateTime> currentMatchDates = new ArrayList<>();
    public static History getInstance(){
        return instance;
    }
    public void addTotalScore(String name, int score){
        totalScore.computeIfAbsent(name, x-> new ArrayList<>()).add(score);
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

        System.out.println("LIST OF WINNERS: ");
        totalScore.forEach((key, value) -> {
            if (key.contains("Draw".toUpperCase())){
                System.out.println("There has been " + value.size() + " draws");
            } else System.out.println(key + " has won " + value.size() + " times");
        });
}

 public void displayStatistics() {
        Player currentPlayer = AddPlayer.getInstance().getCurrentPlayer();
        if (currentPlayer != null) {
            String currentPlayerName = currentPlayer.getName();

            List<Integer> playerWins = totalScore.get(currentPlayerName);
            int totalNumOfGames = totalScore.values().stream().mapToInt(List::size).sum();

            if (playerWins != null) {
                int numPlayerWins = playerWins.size();
                float winPercentage = (float) numPlayerWins / totalNumOfGames * 100;

                System.out.println(currentPlayerName + " has won " + numPlayerWins + " times");
                System.out.println("You have played " + totalNumOfGames + " games.");
                System.out.println("Your win percentage is: " + winPercentage + "%");
            } else {
                System.out.println(currentPlayerName + " has not won any games yet.");
            }
        } else {
            System.out.println("No available data");
        }
    }
    public void displayStatsByOpponent(){
        String klockis = AllOpponents.getInstance().getOpponents().get(0).getName();
        String namnis = AllOpponents.getInstance().getOpponents().get(1).getName();
        String slumpis = AllOpponents.getInstance().getOpponents().get(2).getName();

        List<Integer> klockisWins = totalScore.get(klockis);
        List<Integer> namnisWins = totalScore.get(namnis);
        List<Integer> slumpisWins = totalScore.get(slumpis);
        int totalNumOfGames = totalScore.values().stream().mapToInt(List::size).sum();

        //int totalGamesSKlockis = totalScore.values().stream().filter(x ->).mapToInt(List::size).sum();
    }
}