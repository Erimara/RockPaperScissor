package org.example.utils;

import java.util.Scanner;

public class ReturnToMenu {
    public static void returnToMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To return to the main menu, press 'c' ");
        scanner.nextLine();
    }
}
