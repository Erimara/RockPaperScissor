package org.example.menu;

import org.example.data.GameData;
import org.example.data.History;
import org.example.data.SpecificStats;
import org.example.entities.player.HandlePlayer;
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
                    4: See statistics""");
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
            case 1 -> StartGame.checkIfExist();

            case 2 -> HandlePlayer.getInstance().createPlayer();

            case 3 -> History.getInstance().displayHistory(
                    GameData.getInstance().getCurrentMatchDate(),
                    GameData.getInstance().getgameHistory(),
                    GameData.getInstance().getTotalWins()
            );

            case 4 -> {
                SpecificStats.getInstance().displayStatsByPlayer(GameData.getInstance().getTotalWins());
                SpecificStats.getInstance().displayStatsByOpponent();
            }

            default -> System.out.println("Invalid choice");
        }
    }
}
