package org.example.entities.opponent;

import org.example.entities.Opponent;

public class Namnis implements Opponent {

    public String name;
private Opponent move;
    public Namnis(String name, Opponent move) {
        this.name = name;
        this.move = move;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int doMove() {
      return move.doMove();
    }
}
