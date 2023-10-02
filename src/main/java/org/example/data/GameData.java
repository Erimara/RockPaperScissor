package org.example.data;

import org.example.moves.Move;
import org.example.utils.ReturnToMenu;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class GameData {

    private static final GameData instance = new GameData();
    private List<HashMap<String, List<Move>>> gameHistory = new ArrayList<>();
    private HashMap<String, List<Integer>> totalWins = new HashMap<>();
    private List<LocalDateTime> currentMatchDates = new ArrayList<>();
    public static GameData getInstance() {
        return instance;
    }

    public void addTotalWins(String name, int score) {
        totalWins.computeIfAbsent(name, x -> new ArrayList<>()).add(score);
    }

    public void startNewGame(String opponentName, String playerName, List<Move> opponentMoves, List<Move> playerMoves) {
        HashMap<String, List<Move>> newGameHistory = new HashMap<>();
        newGameHistory.put(opponentName, opponentMoves);
        newGameHistory.put(playerName, playerMoves);
        gameHistory.add(newGameHistory);
        currentMatchDates.add(LocalDateTime.now());
    }
    public void displayHistory() {
        IntStream.range(0, gameHistory.size())
                .forEach(matchNumber -> {
                    System.out.println("GAME: " + (matchNumber + 1));
                    System.out.println("DATE: " + currentMatchDates.get(matchNumber) );
                    System.out.println("USED MOVES: " + gameHistory.get(matchNumber));
                });
        displayWinners();
        ReturnToMenu.returnToMainMenu();
    }
    private void displayWinners() {
        System.out.println("WINNERS & DRAWS: ");
        totalWins.forEach((key, value) -> {
            if (key.contains("Draw".toUpperCase())) {
                System.out.println("Draw: " + value.size());
            } else System.out.println(key + " has won " + value.size() + " times");
        });
    }

   public HashMap<String, List<Integer>> getTotalWins(){
        return totalWins;
   }




}


