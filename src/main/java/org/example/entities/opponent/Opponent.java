package org.example.entities.opponent;

import org.example.moves.Move;

public interface Opponent {
    Move doMove();
    String getName();
}
