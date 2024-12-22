package com.barcelita;

import java.util.*; // Scanner and ArrayList
import com.barcelita.model.*; // Model Classes
public class Main {
	// Admin and Game Phase objects as attributes
	private AdminPhase adminPhase;
	private GamePhase gamePhase;
	private Word[] wordList;
	private Scanner sc;
	
	// ANSI color codes for console text color
	public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";

	/*
	 * Notes:
	 * - Game board should be at least 3x3 and at most 10x10, and could be not a square (i.e., 3x4, 4x5, etc.)
	 * - The game board should be randomly generated based on the loaded JSON file (whose contents is loaded into the array/arraylist), 
	 * 	 and the words should be randomly placed on the board
	 * - There exists an array/arraylist of entries to be used for the game (since this is used in GP and can be modified in AP, it should be in Main)
	 * - Said array/arraylist should be loaded from a JSON file, and should be saved to the same JSON file after modifications
	 * - Said array/arraylist has a max size of 150 entries, and each entry should have a word and its corresponding trivias
	 * - Each entry is composed of a word (max length 20 + 1 for null terminator), and its corresponding trivias (at least 1, and a max of 10)
	 * - Each trivia is composed of a relation and its relation value (i.e., for the word Table, the Relation is "Kind of", 
	 * 	 and the Relation Value is "Furniture")
	 * - Both relation and relation value CAN be phrases and should be limited to 30 characters + 1 for null terminator
	 */

	public Main(Scanner sc) {
		adminPhase = new AdminPhase(sc);
		gamePhase = new GamePhase(sc);
		this.sc = sc;
		this.wordList = new Word[150];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Main app = new Main(sc);
		app.run();
		sc.close();
	}

	private void run() {
		// This is a CLI application, and instead of learning how to parse .txt files, we would use JSON files
		int choice = -1;
		String input;
		
		while (choice != 0) {
			System.out.println();
			System.out.println(ORANGE + "================");
			System.out.println("WORD TRIVIA GAME");
			System.out.println("================" + RESET);
			System.out.println();
			System.out.println("Main Menu:");
			System.out.println("[1] Enter the Game Phase.");
			System.out.println("[2] Enter the Admin Phase.");
			System.out.println("[0] Exit the Application.");
			System.out.println();
			System.out.print("Enter choice: ");
			input = sc.nextLine();
			try {
				choice = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println(RED + "Invalid input type. Please enter a valid integer." +  RESET);
				continue; // Skip the rest of the loop and start again
			}
			
			switch(choice) {
				case 1: 
					System.out.println(ORANGE + "Entering Game Phase (WIP)." + RESET);
					gamePhase.run();
					break;
				case 2:
					System.out.println(ORANGE + "Entering Admin Phase (WIP)." + RESET);
					adminPhase.run();
					break;
				case 0:
					System.out.println(RED + "Exiting the application." + RESET);
					break;
				default:
					System.out.println(RED + "Invalid choice. Please enter a valid choice." + RESET);
					break;
			}
		}
	}
}
