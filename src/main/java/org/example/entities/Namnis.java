package org.example.entities;

import org.example.player.AddPlayer;
import org.example.player.Player;

import java.util.List;

public class Namnis implements Entity{

    AddPlayer addPlayer = new AddPlayer();
    public String name;
    public  int points;

    public Namnis(String name) {
        this.name = name;
        this.points = 0;
    }
    @Override
    public int doMove() {
        System.out.println("I make my move depending on your name");
        getPlayerName(addPlayer.getPlayerList());
        return 0;
    }
    public int getPlayerName(List<Player> playerList){
        for (Player player : playerList){
            System.out.println(player.name);
        }
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int calculatePoints() {
        return 0;
    }
}
