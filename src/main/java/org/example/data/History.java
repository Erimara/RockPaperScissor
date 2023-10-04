package org.example.data;

import org.example.moves.Move;
import org.example.utils.ReturnToMenu;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class History {
    private static final History instance = new History();
    public static History getInstance(){
        return instance;
    }
    public void displayHistory(List<LocalDateTime> currentMatchDates,
                               List<HashMap<String, List<Move>>> gameHistory,
                               HashMap<String, List<Integer>> totalWins
                               ) {
        IntStream.range(0, gameHistory.size())
                .forEach(matchNumber -> {
                    System.out.println("GAME: " + (matchNumber + 1));
                    System.out.println("DATE: " + currentMatchDates.get(matchNumber) );
                    System.out.println("USED MOVES: " + gameHistory.get(matchNumber));
                });
        System.out.println();
        displayWinners(totalWins);
        ReturnToMenu.returnToMainMenu();
    }
    private void displayWinners(HashMap<String, List<Integer>> totalWins) {
        System.out.println("WINNERS & DRAWS: ");
        totalWins.forEach((key, value) -> {
            if (key.contains("Draw".toUpperCase())) {
                System.out.println("Draw: " + value.size());
            } else System.out.println(key + " has won " + value.size() + " times");
        });
    }
}
