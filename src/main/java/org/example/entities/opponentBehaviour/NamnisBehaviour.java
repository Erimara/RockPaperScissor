package org.example.entities.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;
import org.example.entities.player.AddPlayer;
import org.example.entities.player.Player;
import org.example.moves.Move;

import java.util.List;

public class NamnisBehaviour implements Opponent {


    @Override
    public String getName() {
        return null;
    }

    @Override
    public int doMove() {
        int random = (int)(Math.floor(Math.random() * 3)) + 1;
        String name = AllOpponents.getInstance().getOpponents().get(1).getName();
        if (random == 1){
            System.out.println(name + " used " + Move.ROCK);
            return 1;
        } else if (random == 2) {
            System.out.println(name + " used " + Move.PAPER);
            return 2;
        } else if (random == 3) {
            System.out.println(name + " used " + Move.SCISSOR);
            return 3;
        }
        return 0;
    }
    public int getPlayerName(List<Player> playerList){
        for (Player player : playerList){
            System.out.println(player.name);
        }
        return 0;
    }
}
