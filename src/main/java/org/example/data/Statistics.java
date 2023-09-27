package org.example.data;

import org.example.entities.player.Player;

import java.util.List;

public class Statistics implements ShowStats{

    @Override
    public void showStats(List<Player> playerList){
        //playerList.stream()
                //.map(Player::getPoints)
                //.forEach(System.out::println);
    }
}
