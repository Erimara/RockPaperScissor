package org.example.entities.opponent;

import org.example.entities.Opponent;

public class Slumpis implements Opponent {
    public String name;
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
    public int doMove() {
        return move.doMove();
    }
}
