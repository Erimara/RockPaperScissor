package org.example.menu;

import org.example.player.AddPlayer;
import org.example.utils.data.PlayerPoints;
import org.example.utils.data.Statistics;

import java.util.Scanner;
public class Menu {

    AddPlayer addPlayer = new AddPlayer();
    PlayerPoints playerList = new PlayerPoints();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option");
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
                StartGame.checkIfExist(addPlayer.getPlayerList());
            }

            case 2 -> {
                addPlayer.createPlayer();
            }

            case 3 -> {

            }
            case 4 -> {
                Statistics.showPoints(addPlayer.getPlayerList());
            }
            case 5 -> {
                playerList.getPlayerName(addPlayer.getPlayerList());

            }
            default -> System.out.println("Invalid choice");
        }
    }
}
