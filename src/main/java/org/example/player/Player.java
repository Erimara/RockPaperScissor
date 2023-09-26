package org.example.player;

import org.example.moves.Move;

import java.util.List;
import java.util.Scanner;

public class Player {

    public String name;
    public int wins;

    public static int move(int move) {
        Scanner scanner = new Scanner(System.in);
        if (move == 1){
            System.out.println("Player used " + Move.ROCK);
            return 1;
        } else if (move == 2) {
            System.out.println("Player used " + Move.PAPER);
            return 2;
        } else if (move == 3) {
            System.out.println("Player used " + Move.SCISSOR);
            return 3;
        }
        return 0;
    }

    public Player(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }




    public static void updatePoints(List<Player> player, int points){
        for (Player value : player) {
            value.incrementPoints(points);
        }

    }
    public void incrementPoints(int pointsToAdd) {
        this.wins += pointsToAdd;
    }

    // Method to get the player's current points
    public int getWins() {
        return this.wins;
    }

    public String getName(){
        return this.name;
    }
}
