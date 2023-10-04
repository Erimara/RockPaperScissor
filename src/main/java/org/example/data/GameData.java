package org.example.data;

import org.example.entities.player.HandlePlayer;
import org.example.moves.Move;
import org.example.utils.ReturnToMenu;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
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

    public List<LocalDateTime>  getCurrentMatchDate(){
        return currentMatchDates;
    }

    public List<HashMap<String, List<Move>>> getgameHistory(){return  gameHistory;}

   public HashMap<String, List<Integer>> getTotalWins(){
        return totalWins;
   }
}


