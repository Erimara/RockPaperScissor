package org.example.logic;

import org.example.entities.AddOpponent;
import org.example.entities.Entity;
import org.example.entities.Klockis;
import org.example.moves.Move;

import java.util.Scanner;

public class Game implements StartGame {
    private Entity entity;

    public Game(Entity entity) {
        this.entity = entity;
    }

    @Override
        public void rockPaperScissor() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
            Make your move!
            1: Rock
            2: Paper
            3: Scissor""");
            int playerChoice = scanner.nextInt();

            int computerMove = entity.doMove();

            if (playerChoice == computerMove) {
                System.out.println("Draw");
            } else if ((playerChoice == 1 && computerMove == 2) ||
                    (playerChoice == 2 && computerMove == 3) ||
                    (playerChoice == 3 && computerMove == 1)) {
                System.out.println("Computer wins");
            } else {
                System.out.println("Player wins");
            }
        }



    }
