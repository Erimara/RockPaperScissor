package org.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Klockis implements Entity{
    private LocalDate date;
    public String name;
    public int points;

    public Klockis(String name) {
        this.name = name;
        this.points = 0;
    }

    @Override
    public int calculatePoints() {
        return 0;
    }

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

    @Override
    public String getName() {
      return this.name;
    }
}
