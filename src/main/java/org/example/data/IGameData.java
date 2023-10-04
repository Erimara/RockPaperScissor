package org.example.data;

import org.example.moves.Move;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public interface IGameData {

     List<LocalDateTime> getCurrentMatchDate();

     List<HashMap<String, List<Move>>> getgameHistory();

     HashMap<String, List<Integer>> getTotalWins();
}
