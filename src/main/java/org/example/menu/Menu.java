package org.example.menu;

import org.example.data.History;
import org.example.entities.player.AddPlayer;

import java.util.Scanner;
public class Menu {

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
                StartGame.checkIfExist(AddPlayer.getInstance().getPlayerList());
            }

            case 2 -> {
                AddPlayer.getInstance().createPlayer();
            }

            case 3 -> {
               History.getInstance().displayHistory();
            }
            case 4 -> {

            }
            case 5 -> {

            }
            default -> System.out.println("Invalid choice");
        }
    }
}
