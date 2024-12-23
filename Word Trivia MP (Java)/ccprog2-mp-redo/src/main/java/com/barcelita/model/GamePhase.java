package com.barcelita.model;

import java.util.Scanner;

public class GamePhase {
    // Scanner object as attribute
    private Scanner sc;

    // ANSI color codes for console text color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";

    public GamePhase(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("Entering Game Phase (WIP).");
        
    }
}
