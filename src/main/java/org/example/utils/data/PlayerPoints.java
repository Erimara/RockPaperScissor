package org.example.utils.data;

import org.example.player.Player;

import java.util.List;

public class PlayerPoints {
    private int addPoint(){
        return 1;
    }
    public void getPlayerName(List<Player> playerList){
        int incrementByOne = addPoint();
        for (Player player : playerList){
            player.incrementPoints(incrementByOne);
        }
    }
}
