package org.example.entities;

import org.example.moves.Move;

public interface Opponent {
    Move doMove();
    String getName();
}
