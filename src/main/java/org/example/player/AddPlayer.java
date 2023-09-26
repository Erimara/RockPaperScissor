package org.example.player;

import org.example.utils.ReturnToMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddPlayer {

    List<Player> playerList = new ArrayList<>();

    public void createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create your player");

        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("You have chosen " + name + " as your battlename.\n" +
                "1: Confirm\n" +
                "2: Return ");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            if (!playerList.isEmpty()) {
                System.out.println("You are about to create a new player, this means your already created player will be removed\n" +
                        "1: Confirm\n" +
                        "2: Return");
                int confirmRemoval = scanner.nextInt();
                if (confirmRemoval == 1){
                    playerList.remove(playerList.remove(0));
                    Player player = new Player(name, 0);
                    playerList.add(player);
                    System.out.println("New player: " + player.name + " created");
                } else if (confirmRemoval == 2) {
                    ReturnToMenu.returnToMainMenu();
                }
            } else {
                Player player = new Player(name, 0);
                playerList.add(player);
                System.out.println("Player: " + player.name + " created");
                System.out.println("num of players" + playerList.size());
            }

             if (confirm == 2) {
                ReturnToMenu.returnToMainMenu();
            }
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

}
