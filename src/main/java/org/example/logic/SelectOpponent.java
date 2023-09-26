package org.example.logic;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectOpponent {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        List<EntityMove> entities = new ArrayList<>();

        System.out.println("""
                Select an opponent:
                1: Klockis
                2: Namnis
                3: Slumpis""");

        int choice = scanner.nextInt();

        if (choice == 1) {
            EntityMove entityMove = new Klockis("Klockis", new KlockisBehaviour());
            entities.add(entityMove);
        } else if (choice == 2) {
            EntityMove entityMove = new Namnis("Namnis", new NamnisBehaviour());
            entities.add(entityMove);
        } else if (choice == 3) {
            EntityMove entityMove = new Slumpis("Slumpis", new SlumpisBehaviour());
            entities.add(entityMove);
        }

        for (EntityMove entityMove : entities) {
            RockPaperScissor rockPaperScissor = new RockPaperScissor(entityMove);
            rockPaperScissor.rockPaperScissor();
        }
    }
}
