package org.example.entities.player;

import org.example.moves.Move;

public class PlayerBehaviour implements PlayerMoves {
    @Override
    public Move doMove(int move) {
        String name = HandlePlayer.getInstance().getCurrentPlayer().getName();
            if (move == 1) {
                System.out.println(name + " used " + Move.ROCK);
                return Move.ROCK;
            } else if (move == 2) {
                System.out.println(name + " used " + Move.PAPER);
                return Move.PAPER;
            } else if (move == 3) {
                System.out.println(name + " used " + Move.SCISSOR);
                return Move.SCISSOR;
            }
        return null;
    }
}
