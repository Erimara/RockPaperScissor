package org.example.entities;

import org.example.moves.Move;

public class SlumpisBehaviour implements EntityMove{
    @Override
    public int doMove() {
        int random = (int)(Math.floor(Math.random() * 3)) + 1;
        if (random == 1){
            System.out.println("Slumpis used " + Move.ROCK);
            return 1;
        } else if (random == 2) {
            System.out.println("Slumpis used " + Move.PAPER);
            return 2;
        } else if (random == 3) {
            System.out.println("Slumpis used " + Move.SCISSOR);
            return 3;
        }
        return 0;
    }
}
