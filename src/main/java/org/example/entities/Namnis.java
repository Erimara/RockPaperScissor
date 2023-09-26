package org.example.entities;

import org.example.player.AddPlayer;
import org.example.player.Player;

import java.util.List;

public class Namnis implements EntityMove{

    public String name;
    public  int wins;
private EntityMove move;
    public Namnis(String name, EntityMove move) {
        this.name = name;
        this.wins = 0;
        this.move = move;
    }

    @Override
    public int doMove() {
      return move.doMove();
    }
}
