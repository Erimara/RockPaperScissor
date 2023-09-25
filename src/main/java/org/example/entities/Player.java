package org.example.entities;

public class Player implements Entity{

    public String name;

    public Player(String name) {
        this.name = name;
    }
    @Override
    public int doMove() {
        return 0;
    }
}
