package com.barcelita.model;

import com.google.gson.*;

import java.io.*;
import java.util.*;

public class AdminPhase {
    // Scanner object as attribute
    private Scanner sc;
    private ArrayList<Word> wordList;

    // ANSI color codes for console text color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String BLUE = "\u001B[94m";

    public AdminPhase(Scanner sc, ArrayList<Word> wordList) {
        this.sc = sc;
        this.wordList = wordList;
    }

    public void viewEachWord(ArrayList<Word> wordList) {
        int i = 0;
    
        while (true) {
            // Display the word and its trivia
            if (i >= 0 && i < wordList.size()) {
                System.out.println();
                System.out.println(BLUE + "Word " + (i + 1) + " of " + wordList.size() + RESET);
                System.out.println(BLUE + "Word: " + wordList.get(i).getWord() + RESET);
                for (int j = 0; j < wordList.get(i).getTrivias().size(); j++) {
                    System.out.println("Trivia " + (j + 1) + ": " + wordList.get(i).getTrivias().get(j).getRelation() + " - " + wordList.get(i).getTrivias().get(j).getRelationValue());
                }
            } else {
                System.out.println("No more words to display.");
            }
            
            // Prompt the user for the next action
            System.out.println();
            System.out.println("Press 'D' to view the next word, 'A' to view the previous word, 'X' to exit.");
            String input = sc.nextLine().trim().toUpperCase();
            
            if (input.equals("D")) { // Move to the next word
                if (i < wordList.size() - 1) {
                    i++;
                } else {
                    System.out.println("You are at the last word.");
                }
            } else if (input.equals("A")) { // Move to the previous word
                if (i > 0) {
                    i--;
                } else {
                    System.out.println("You are at the first word.");
                }
            } else if (input.equals("X")) { // Exit the loop
                break;
            } else {
                System.out.println("Invalid input. Please press 'D' for next word, 'A' for previous word, or 'X' to exit.");
            }
        }
    }


    // Method to import contents of a JSON file into an ArrayList of Word objects in Main
    public boolean importFromJson(String filePath, List<Word> wordList) {
        Gson gson = new Gson();
    
        // Read the JSON file
        try (Reader reader = new FileReader(filePath)) {
            // Convert JSON to Java Object
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
    
            // Clear the existing wordList
            wordList.clear();
    
            // Iterate through the JSON array
            for (JsonElement element : jsonArray) {
                try {
                    JsonObject jsonObject = element.getAsJsonObject();
    
                    // Extract the "Object" field for the Word
                    if (!jsonObject.has("Object")) {
                        System.out.println("Skipping element: Missing 'Object' field.");
                        continue;
                    }
    
                    String word = jsonObject.get("Object").getAsString();
                    Word wordObject = new Word(word);
    
                    // Process other fields as Trivia
                    for (String key : jsonObject.keySet()) {
                        if (!key.equals("Object")) {
                            String value = jsonObject.get(key).getAsString();
                            if (wordObject.getTrivias().size() < 10) {
                                Trivia trivia = new Trivia(key, value);
                                wordObject.getTrivias().add(trivia);
                            }
                        }
                    }
    
                    // Add the word object to the list, even if it has no trivia
                    wordList.add(wordObject);
                } catch (Exception e) {
                    System.out.println("Error importing word: " + element.toString());
                    System.out.println("Reason: " + e.getMessage());
                    continue; // Skip the problematic element and continue with the next one
                }
            }
            return true; // Indicate success
        } catch (IOException e) {
            System.out.println("Failed to read the JSON file: " + e.getMessage());
            return false; // Indicate failure
        }
    }
    

    public void run() {
        int choice = -1;
        String input;
        boolean success = false;

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
                    System.out.println(ORANGE + "Viewing all words, one-by-one, from JSON file (WIP)." + RESET);
                    viewEachWord(wordList);
                    break;
                case 7:
                    System.out.println("Exporting all loaded data into a new JSON file (WIP).");
                    break;
                case 8:
                    System.out.println(ORANGE + "Importing data from an existing JSON file (WIP)." + RESET);
                    System.out.println();
                    System.out.print("Enter the file path: ");
                    String filePath = sc.nextLine();
                    success = importFromJson(filePath, wordList);
                    if (success) {
                        System.out.println(GREEN + "Data successfully imported." + RESET);
                    } else {
                        System.out.println(RED + "Data import failed." + RESET);
                    }
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