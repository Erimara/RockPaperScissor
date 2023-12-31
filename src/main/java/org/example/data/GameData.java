package org.example.data;

import org.example.moves.Move;
import java.time.LocalDateTime;
import java.util.*;

public class GameData implements IGameData {

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
    @Override
    public List<LocalDateTime>  getCurrentMatchDate(){
        return currentMatchDates;
    }
    @Override
    public List<HashMap<String, List<Move>>> getgameHistory(){return  gameHistory;}
    @Override
   public HashMap<String, List<Integer>> getTotalWins(){
        return totalWins;
   }
}


