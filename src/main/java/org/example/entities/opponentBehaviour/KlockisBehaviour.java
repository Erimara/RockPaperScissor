package org.example.entities.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;

import java.time.LocalTime;

public class KlockisBehaviour implements Opponent {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int doMove() {
        LocalTime time = java.time.LocalTime.now(); // current time
        long milis = System.currentTimeMillis(); // curent time in milli
        String name = AllOpponents.getInstance().getOpponents().get(0).getName();
        System.out.println(milis);
        System.out.println("I make my move depending on my date");
        // if (){

        //} else if () {

        //} else if () {

        // }
        return 0;
    }
}
