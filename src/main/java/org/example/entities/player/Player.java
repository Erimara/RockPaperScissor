package org.example.entities.player;

import org.example.moves.Move;

public class Player implements PlayerMethods {

    PlayerBehaviour playerBehaviour;
    private String name;
    public Player(String name, PlayerBehaviour playerBehaviour) {
        this.name = name;
        this.playerBehaviour = playerBehaviour;
    }
    @Override
    public Move doMove(int move) {
     return playerBehaviour.doMove(move);
    }
    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
