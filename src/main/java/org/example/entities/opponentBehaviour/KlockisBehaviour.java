package org.example.entities.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;
import org.example.moves.Move;

import java.time.LocalTime;

public class KlockisBehaviour implements Opponent {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Move doMove() {
        LocalTime time = java.time.LocalTime.now(); // current time
        long milis = System.currentTimeMillis(); // curent time in milli
        System.out.println(milis);
        System.out.println("I make my move depending on my date");
            int random = (int)(Math.floor(Math.random() * 3)) + 1;
            String name = AllOpponents.getInstance().getOpponents().get(0).getName();
            if (random == 1){
                System.out.println(name + " used " + Move.ROCK);
                return Move.ROCK;
            } else if (random == 2) {
                System.out.println(name + " used " + Move.PAPER);
                return Move.PAPER;
            } else if (random == 3) {
                System.out.println(name + " used " + Move.SCISSOR);
                return Move.SCISSOR;
            }
            return null;
    }
}
