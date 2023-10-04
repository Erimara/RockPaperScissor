package org.example.entities.opponent.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.opponent.Klockis;
import org.example.entities.opponent.Namnis;
import org.example.entities.opponent.Opponent;
import org.example.entities.player.HandlePlayer;
import org.example.menu.StartGame;
import org.example.moves.Move;

public class NamnisBehaviour implements Opponent {
    private int callCount = 0;
    @Override
    public Move doMove() {
        String opponentName = AllOpponents.getInstance().getOpponents().get(1).getName();
        String playerName = HandlePlayer.getInstance().getCurrentPlayer().getName();
        callCount++;
        if (playerName.length() < 6) {
            System.out.println(opponentName + " used " + Move.ROCK);
            return Move.ROCK;

        } else if (playerName.startsWith("s") || playerName.endsWith("s")) {
            System.out.println(opponentName + " used " + Move.PAPER);
            return Move.PAPER;

        } else if (playerName.contains("z") || playerName.contains("a")) {
            if (playerName.length() > 6){
                System.out.println(opponentName + " used " + Move.ROCK);
                return Move.ROCK;
            }
            System.out.println(opponentName + " used " + Move.SCISSOR);
            return Move.SCISSOR;

        } else {
            System.out.println(opponentName + " changed your name");
            changeName(playerName);
        }

        return Move.SCISSOR;

    }
    private void changeName(String playerName){
        String tempName = "";
        int randomNumber = (int)(Math.floor(Math.random() * 26)) + 1;
        char randomLetter = (char) ('a' + randomNumber);

        for (int i = 0; i<playerName.length(); i++){
            char letter = playerName.charAt(i);
            tempName =  playerName.replace(letter, randomLetter);
        }
        HandlePlayer.getInstance().getCurrentPlayer().setName(tempName);
    }

    @Override
    public String getName() {
        return null;
    }
}