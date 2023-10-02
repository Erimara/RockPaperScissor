package org.example.entities.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.Opponent;
import org.example.entities.player.HandlePlayer;
import org.example.moves.Move;

import java.util.Arrays;
import java.util.Timer;

public class NamnisBehaviour implements Opponent {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Move doMove() {

        String name = AllOpponents.getInstance().getOpponents().get(1).getName();
        String playerName = HandlePlayer.getInstance().getCurrentPlayer().getName();
        if (playerName.length() < 4) {
            System.out.println(name + " used " + Move.ROCK);
            return Move.ROCK;
        } else if (playerName.startsWith("s")) {
            System.out.println(name + " used " + Move.PAPER);
            return Move.PAPER;
        } else if (playerName.contains("z")) {
            System.out.println(name + " used " + Move.SCISSOR);
            return Move.SCISSOR;
        } else {

            StringBuilder secondLetter = new StringBuilder();
            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                secondLetter.append(alphabet);
            }

            String newName =  playerName.replace("a", secondLetter.toString());
            HandlePlayer.getInstance().getCurrentPlayer().setName(newName);
        }
        return null;
    }
}