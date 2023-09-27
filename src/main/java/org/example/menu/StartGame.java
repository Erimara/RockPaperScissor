package org.example.menu;

import org.example.logic.SelectOpponent;
import org.example.entities.player.Player;
import org.example.utils.ReturnToMenu;

import java.util.List;
public class StartGame {
    public static void checkIfExist(List<Player> playerList){
            if (playerList.isEmpty()){
                System.out.println("You have not created a player, please do so before starting the game");
                ReturnToMenu.returnToMainMenu();
            } else {
                SelectOpponent selectOpponent = new SelectOpponent();
                selectOpponent.opponentSelection();
            }
    }
}
