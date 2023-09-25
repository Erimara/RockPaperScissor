package org.example.menu;

import org.example.entities.AddPlayer;
import org.example.entities.Player;
import org.example.logic.SelectOpponent;
import org.example.utils.PlayerList;

import java.util.Scanner;
public class Menu {

    AddPlayer addPlayer = new AddPlayer();
    PlayerList playerList = new PlayerList();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome, what would you like to do today?");
            System.out.println("""
                    1: Play game
                    2: Create your player
                    3: See history
                    4: See statistics
                    5: Show player list""");
            System.out.println("Enter your choice. Press 0 to exit ");
            int choice = scanner.nextInt();
            if(choice == 0){
                break;
            }
            options(choice);
        }
    }

    public void options(int choice){
        switch (choice) {
            case 1 -> {
                SelectOpponent selectOpponent = new SelectOpponent();
                selectOpponent.startGame();
            }

            case 2 -> {
                addPlayer.createPlayer();
            }

            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {
                playerList.getPlayerName(addPlayer.getPlayerList());

            }
            default -> System.out.println("Invalid choice");
        }
    }
}
