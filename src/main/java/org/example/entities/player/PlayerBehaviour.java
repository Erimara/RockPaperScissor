package org.example.entities.player;

import org.example.moves.Move;

public class PlayerBehaviour implements PlayerMethods {
    @Override
    public int doMove(int move) {
        String name = AddPlayer.getInstance().getPlayerList().get(0).getName();
        if (move == 1){
            System.out.println( name + " used " + Move.ROCK);
            return 1;
        } else if (move == 2) {
            System.out.println(name + " used " + Move.PAPER);
            return 2;
        } else if (move == 3) {
            System.out.println( name + " used " + Move.SCISSOR);
            return 3;
        }
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
