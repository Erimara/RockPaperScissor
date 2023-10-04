package org.example.entities.opponent.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.opponent.Opponent;
import org.example.entities.opponent.Slumpis;
import org.example.moves.Move;

public class SlumpisBehaviour implements Opponent {

    @Override
    public Move doMove() {
        int random = (int)(Math.floor(Math.random() * 3)) + 1;
        String name = AllOpponents.getInstance().getOpponents().get(2).getName();
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

    @Override
    public String getName() {
        return null;
    }
}
