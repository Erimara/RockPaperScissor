package org.example.logic;

import org.example.entities.Entity;
import org.example.entities.Klockis;
import org.example.entities.Namnis;
import org.example.entities.Slumpis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectOpponent {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        List<Entity> entities = new ArrayList<>();

        System.out.println("""
                Select an opponent:
                1: Klockis
                2: Namnis
                3: Slumpis""");

        int choice = scanner.nextInt();

        if (choice == 1) {
            Entity entity = new Klockis("Klockis");
            entities.add(entity);
        } else if (choice == 2) {
            Entity entity = new Namnis("Namnis");
            entities.add(entity);
        } else if (choice == 3) {
            Entity entity = new Slumpis("Slumpis");
            entities.add(entity);
        }

        for (Entity entity : entities) {
            RockPaperScissor rockPaperScissor = new RockPaperScissor(entity);
            rockPaperScissor.rockPaperScissor();
        }
    }
}
