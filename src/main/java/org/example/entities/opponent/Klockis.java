package org.example.entities.opponent;

import org.example.entities.Opponent;
import org.example.moves.Move;

import java.time.LocalDate;

public class Klockis implements Opponent {
    private LocalDate date;
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
