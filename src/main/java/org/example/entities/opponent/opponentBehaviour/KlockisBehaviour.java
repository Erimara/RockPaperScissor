package org.example.entities.opponent.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.opponent.Opponent;
import org.example.moves.Move;

import java.util.Calendar;

public class KlockisBehaviour implements Opponent {
    @Override
    public Move doMove() {
        String opponentName = getName();
        Calendar calendar = Calendar.getInstance();
        int seconds = calendar.get(Calendar.SECOND);

        if(seconds == 55 || seconds == 15){
            System.out.println(opponentName + " used " + Move.ROCK);
            return Move.ROCK;
        }

        for(int i = 1; i < 60; i++){
            if (i % 2 == 0){
                if (i == seconds){
                    System.out.println(opponentName + " used " + Move.PAPER);
                    return Move.PAPER;
                }
            }  else {
                if (i == seconds){
                    System.out.println(opponentName + " used " + Move.SCISSOR);
                    return Move.SCISSOR;
                }
            }
        }

        return null;

    }
    @Override
    public String getName() {
        return AllOpponents.getInstance().getOpponents().get(0).getName();
    }
}
