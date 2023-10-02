package org.example.entities.player;

import org.example.moves.Move;

public interface PlayerMethods {

    Move doMove(int move);
    String getName();

    void setName(String name);

}
