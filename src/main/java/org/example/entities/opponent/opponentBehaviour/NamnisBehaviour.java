package org.example.entities.opponent.opponentBehaviour;

import org.example.entities.opponent.AllOpponents;
import org.example.entities.opponent.Klockis;
import org.example.entities.opponent.Namnis;
import org.example.entities.opponent.Opponent;
import org.example.entities.player.HandlePlayer;
import org.example.menu.StartGame;
import org.example.moves.Move;

public class NamnisBehaviour implements Opponent {
    @Override
    public Move doMove() {
        String playerName = HandlePlayer.getInstance().getCurrentPlayer().getName();
        String opponentName = getName();
        changeName(playerName);
        System.out.println(opponentName + " changed your name");

        if (playerName.length() < 5) {
            System.out.println(opponentName + " used " + Move.ROCK);
            return Move.ROCK;
        } else if (playerName.startsWith("s") || playerName.endsWith("s")) {
            if (playerName.endsWith("e")){
                System.out.println(opponentName + " used " + Move.ROCK);
                return Move.ROCK;
            }
            System.out.println(opponentName + " used " + Move.PAPER);
            return Move.PAPER;

        } else if (playerName.contains("z") || playerName.contains("a")) {
            if (playerName.length() > 6){
                System.out.println(opponentName + " used " + Move.ROCK);
                return Move.ROCK;
            }
            System.out.println(opponentName + " used " + Move.SCISSOR);
            return Move.SCISSOR;

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
        return AllOpponents.getInstance().getOpponents().get(1).getName();
    }
}