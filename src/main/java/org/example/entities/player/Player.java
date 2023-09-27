package org.example.entities.player;

public class Player implements PlayerMethods {

    PlayerBehaviour playerBehaviour;
    public String name;


    public Player(String name, PlayerBehaviour playerBehaviour) {
        this.name = name;
        this.playerBehaviour = playerBehaviour;
    }

    @Override
    public int doMove(int move) {
     return playerBehaviour.doMove(move);
    }
    public Player(String name) {
        this.name = name;
    }


    @Override
    public String getName(){
        return this.name;
    }
}
