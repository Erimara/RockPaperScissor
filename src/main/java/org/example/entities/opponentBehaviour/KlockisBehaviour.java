package org.example.entities.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;
import org.example.moves.Move;

import java.time.LocalTime;
import java.util.Calendar;

public class KlockisBehaviour implements Opponent {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Move doMove() {
        String name = AllOpponents.getInstance().getOpponents().get(0).getName();
        Calendar calendar = Calendar.getInstance();
        int seconds = calendar.get(Calendar.SECOND);
        if(seconds == 55 || seconds == 15){
            System.out.println(name + " used " + Move.ROCK);
            return Move.ROCK;
        }
        for(int i = 1; i < 60; i++){
            if (i % 2 == 0){
                if (i == seconds){
                    System.out.println(name + " used " + Move.PAPER);
                    return Move.PAPER;
                }
            }  else {
                if (i == seconds){
                    System.out.println(name + " used " + Move.SCISSOR);
                    return Move.SCISSOR;
                }

            }
        }
            return null;
    }
}
