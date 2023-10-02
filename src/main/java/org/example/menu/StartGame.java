package org.example.menu;

import org.example.entities.player.HandlePlayer;
import org.example.logic.SelectOpponent;
import org.example.entities.player.Player;
import org.example.utils.ReturnToMenu;

import java.util.List;
public class StartGame {
    public static void checkIfExist(){
        Player player = HandlePlayer.getInstance().getCurrentPlayer();
            if (player == null){
                System.out.println("You have not created a player, please do so before starting the game");
                ReturnToMenu.returnToMainMenu();
            } else {
                SelectOpponent selectOpponent = new SelectOpponent();
                selectOpponent.opponentSelection();
            }
    }
}
