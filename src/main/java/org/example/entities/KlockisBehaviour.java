package org.example.entities;

import java.time.LocalTime;

public class KlockisBehaviour implements EntityMove{

    @Override
    public int doMove() {
        LocalTime time = java.time.LocalTime.now(); // current time
        long milis = System.currentTimeMillis(); // curent time in milli

        System.out.println(milis);
        System.out.println("I make my move depending on my date");
        // if (){

        //} else if () {

        //} else if () {

        // }
        return 0;
    }
}
