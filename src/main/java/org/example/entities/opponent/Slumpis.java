package org.example.entities.opponent;

import org.example.entities.Opponent;
import org.example.moves.Move;

public class Slumpis implements Opponent {
    private String name;
    private Opponent move;
    @Override
    public String getName() {
        return name;
    }
    public Slumpis(String name, Opponent move) {
        this.name = name;
        this.move = move;
    }


    @Override
    public Move doMove() {
        return move.doMove();
    }
}
