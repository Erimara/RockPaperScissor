package org.example.entities.player;

import org.example.utils.ReturnToMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandlePlayer {
    private static HandlePlayer instance = new HandlePlayer();
    Player currentPlayer;
    List<Player> playerList = new ArrayList<>();
    public void createPlayer() {
        Scanner scanner = new Scanner(System.in);
        PlayerBehaviour playerBehaviour = new PlayerBehaviour();
        System.out.println("Create your player");

        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("You have chosen " + name + " as your battlename.\n" +
                "1: Confirm\n" +
                "2: Return ");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            if (currentPlayer != null) {
                System.out.println("You already have a player. Do you want to replace it? (1: Yes / 2: No)");
                int replaceChoice = scanner.nextInt();

                if (replaceChoice == 1) {
                    playerList.remove(currentPlayer);
                    currentPlayer = new Player(name, playerBehaviour);
                    playerList.add(currentPlayer);
                    System.out.println("New player: " + currentPlayer.getName() + " created");
                } else if (replaceChoice == 2) {
                    System.out.println("Player creation canceled.");
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                currentPlayer = new Player(name,playerBehaviour);
                playerList.add(currentPlayer);
                System.out.println("Player: " + currentPlayer.getName() + " created");
            }

            if (confirm == 2) {
                ReturnToMenu.returnToMainMenu();
            }
        }
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public static HandlePlayer getInstance(){
        return instance;
    }

}
