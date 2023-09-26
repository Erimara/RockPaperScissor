package org.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Klockis implements EntityMove{
    private LocalDate date;
    public String name;
    public int wins;

    private EntityMove move;
    public Klockis(String name, EntityMove move) {
        this.name = name;
        this.wins = 0;
        this.move = move;
    }


    @Override
    public int doMove() {
        return move.doMove();
    }
}
