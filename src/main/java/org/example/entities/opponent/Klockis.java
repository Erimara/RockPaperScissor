package org.example.entities.opponent;

import org.example.moves.Move;

public class Klockis implements Opponent {
    private String name;
    private Opponent move;
    public Klockis(String name, Opponent move) {
        this.name = name;
        this.move = move;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Move doMove() {
        return move.doMove();
    }
}
