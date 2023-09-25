package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddPlayer {

    List<Player> playerList = new ArrayList<>();
    public void createPlayer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create your player");

        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("You have chosen " + name + " as your battlename.\n " +
                "1: Confirm\n" +
                "2: Return ");
        int confirm = scanner.nextInt();

        if (confirm == 1){
            Player player = new Player(name);
            playerList.add(player);
            System.out.println("Player: " + player.name + " created");
            System.out.println("num of players" + playerList.size());
        } else if (confirm == 2) {
            createPlayer();
        }
    }
    public List<Player> getPlayerList(){
        return playerList;
    }

}
