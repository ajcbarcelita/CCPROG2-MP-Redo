package com.barcelita;

import java.util.*; // Scanner 
import com.barcelita.model.*; // Model Classes

public class Main {
	// Admin and Game Phase objects as attributes
	private AdminPhase adminPhase;
	private GamePhase gamePhase;
	private Scanner sc;

	// ANSI color codes for console text color
	public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";

	public Main(Scanner sc) {
		adminPhase = new AdminPhase(sc);
		gamePhase = new GamePhase(sc);
		this.sc = sc;
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
