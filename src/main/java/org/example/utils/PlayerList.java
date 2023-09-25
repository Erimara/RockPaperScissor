package org.example.utils;

import org.example.entities.AddPlayer;
import org.example.entities.Player;

import java.util.List;

public class PlayerList {

    public void getPlayerName(List<Player> playerList){
        System.out.println("All players: ");
        if (playerList.isEmpty()){
            System.out.println("No added players");
        }
        for (Player player : playerList){
            System.out.println("Name: " + player.name);
        }
    }
}
