package org.example.data;

import org.example.entities.player.Player;
import org.example.moves.Move;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class History {

    private static final History instance = new History();
    private List<HashMap<String, List<Integer>>> gameHistory = new ArrayList<>();
    private HashMap<String,List<Integer>> currentGameHistory = new HashMap<>();
    private HashMap<String,List<Integer>> totalScore = new HashMap<>();
    private int currentMatch = 1;
    private int currentRound = 1;


    public static History getInstance(){
        return instance;
    }
    public void addTotalScore(String name, int score){
        totalScore.computeIfAbsent(name, x-> new ArrayList<>()).add(score);
    }
    public void history(){
        gameHistory.add(currentGameHistory);
    }

    public void startNewGame(String opponentName, String playerName, List<Integer> opponentMoves, List<Integer> playerMoves) {
        currentMatch++;
        currentGameHistory = new HashMap<>();
        currentGameHistory.put(opponentName, opponentMoves);
        currentGameHistory.put(playerName, playerMoves);
        System.out.println("Match " + currentMatch + ": Round " + currentRound);
        System.out.println(currentGameHistory);
    }

    public void displayHistory() {
        IntStream.range(0, currentGameHistory.size())
                .forEach(match -> {
                    HashMap<String, List<Integer>> game = gameHistory.get(match);
                    System.out.println("MATCH " + (match + 1) + ":");

                    game.forEach((name, moves) -> {
                        String moveHistory = moves.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", "));

                        System.out.println(name + " used " + moveHistory);
                    });
                });
        totalScore.forEach((key, value) -> System.out.println(key + " has won " + value.size() + " times"));
        //Optional<HashMap<String,Integer>> checkWins
    }
}
