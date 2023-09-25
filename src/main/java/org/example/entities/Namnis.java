package org.example.entities;

import org.example.moves.Move;

import java.util.List;

public class Namnis implements Entity{
    AddPlayer addPlayer = new AddPlayer();
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

}
