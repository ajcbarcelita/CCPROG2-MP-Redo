package com.barcelita.model;

import java.util.Scanner;

public class AdminPhase {
    // Scanner object as attribute
    private Scanner sc;

    // ANSI color codes for console text color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";

    public AdminPhase(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int choice = -1;
        String input;

        while (choice != 0) {
            System.out.println();
            System.out.println(ORANGE + "===========");
            System.out.println("ADMIN PHASE");
            System.out.println("===========" + RESET);
            System.out.println();
            System.out.println("Admin Menu:");
            System.out.println("[1] Add a new word to JSON file.");
            System.out.println("[2] Add a new trivia to an existing word in JSON file.");
            System.out.println("[3] Modify an entry in JSON file.");
            System.out.println("[4] Delete a word from JSON file.");
            System.out.println("[5] Delete a trivia from an existing word in JSON file.");
            System.out.println("[6] View all words, one-by-one, from JSON file.");
            System.out.println("[7] Export all loaded data into a new JSON file.");
            System.out.println("[8] Import data from an existing JSON file.");
            System.out.println("[0] Exit the Admin Phase.");
            System.out.println();
            System.out.print("Enter choice: ");
            input = sc.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input type. Please enter a valid integer." + RESET);
                continue; // Skip the rest of the loop and prompt again
            }

            switch(choice) {
                case 1:
                    System.out.println("Adding a new word to JSON file (WIP).");
                    break;
                case 2:
                    System.out.println("Adding a new trivia to an existing word in JSON file (WIP).");
                    break;
                case 3:
                    System.out.println("Modifying an entry in JSON file (WIP).");
                    break;
                case 4:
                    System.out.println("Deleting a word from JSON file (WIP).");
                    break;
                case 5:
                    System.out.println("Deleting a trivia from an existing word in JSON file (WIP).");
                    break;
                case 6:
                    System.out.println("Viewing all words, one-by-one, from JSON file (WIP).");
                    break;
                case 7:
                    System.out.println("Exporting all loaded data into a new JSON file (WIP).");
                    break;
                case 8:
                    System.out.println("Importing data from an existing JSON file (WIP).");
                    break;
                case 0:
                    System.out.println(ORANGE + "Exiting the Admin Phase." + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Please enter a valid choice." + RESET);
                    break;
            }
        }
    }
}