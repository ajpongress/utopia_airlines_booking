import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static boolean isNumeric(String stringNum) {

        if (stringNum == null) {
            return false;
        }
        try {
            Integer num = Integer.parseInt(stringNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // main - run commands
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {

        // Globals
        Scanner objScanner = new Scanner(System.in);
        String userInput = "";
        boolean mainMenu = true;
        boolean employeeMenu = false;
        boolean administratorMenu = false;
        boolean travellerMenu = false;

        // MAIN Loop - loop until user types valid numeric input
        while (mainMenu) {

            System.out.println("MAIN MENU\n");

            System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Employee/Agent");
            System.out.println("2) Administrator");
            System.out.println("3) Traveler\n");

            System.out.print("> "); // User prompt
            userInput = objScanner.next();

            // Check if "quit" or "exit" was typed
            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                System.out.println("Now exiting.");
                System.exit(0);
            }

            // Check for non numeric input
            else if (!isNumeric(userInput)) {
                System.out.println("Invalid input. Please type a valid number:\n");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }

            // Check for input outside scope of 1-3
            else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 3) {
                System.out.println("Invalid input. Please type a valid number:\n");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }

            // Logic for input 1-3
            else {
                // Go to employee menu 1
                if (Integer.parseInt(userInput) == 1) {
                    mainMenu = false;
                    employeeMenu = true;
                    System.out.println("PLACEHOLDER 1");
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }
                // Go to administrator menu 1
                if (Integer.parseInt(userInput) == 2) {
                    mainMenu = false;
                    administratorMenu = true;
                    System.out.println("PLACEHOLDER 2");
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }
                // Go to traveller menu 1
                if (Integer.parseInt(userInput) == 3) {
                    mainMenu = false;
                    travellerMenu = true;
                    System.out.println("PLACEHOLDER 3");
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }
            }

        }//END MAIN while loop

        // Employee Loop - loop until user types valid numeric input
//        while (employeeMenu) {
//
//            System.out.println("EMPLOYEE MAIN MENU\n");
//
//            System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
//            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
//            System.out.println("1) Employee/Agent");
//            System.out.println("2) Administrator");
//            System.out.println("3) Traveler\n");
//        }

    }//END main

}//END Main