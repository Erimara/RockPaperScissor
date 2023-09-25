package org.example.logic;

import org.example.entities.Klockis;
import org.example.entities.Namnis;
import org.example.entities.Slumpis;

import java.util.Scanner;

public class SelectOpponent {

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Select an opponent:
                1: Klockis
                2: Namnis
                3: Slumpis""");
        int choice = scanner.nextInt();
        if (choice == 1){
            Game game = new Game(new Klockis());
            game.rockPaperScissor();
        } else if (choice == 2) {
            Game game = new Game(new Namnis());
            game.rockPaperScissor();
        } else if (choice == 3) {
            Game game = new Game(new Slumpis());
            game.rockPaperScissor();
        }

    }
}
