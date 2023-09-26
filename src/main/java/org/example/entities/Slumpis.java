package org.example.entities;

import org.example.moves.Move;

public class Slumpis implements EntityMove{

    public String name;
    public int wins;

    private EntityMove move;
    public Slumpis(String name, EntityMove move) {
        this.name = name;
        this.wins = 0;
        this.move = move;
    }


    @Override
    public int doMove() {
        return move.doMove();
    }
}
