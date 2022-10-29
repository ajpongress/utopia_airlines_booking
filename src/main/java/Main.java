import Airport_pckg.*;

import java.io.IOException;
import java.sql.SQLException;
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
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException, SQLException, ClassNotFoundException {

        // ---------------------- DEBUG -------------------------

        // ---------------------- DEBUG -------------------------


        // Globals
        Scanner objScanner = new Scanner(System.in);
        String userInput = "";
        String statusMessage = "";
        boolean mainMenu = true;
        boolean employeeMenu = false;
        boolean administratorMenu = false;
        boolean travellerMenu = false;

        // --------------------------------------------------------------------------------------------------
        // --                   MAIN MENU Loop - loop until user types valid numeric input                 --
        // --------------------------------------------------------------------------------------------------
        while (mainMenu) {

            System.out.println("MAIN MENU\n");

            System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Traveler");
            System.out.println("2) Employee/Agent");
            System.out.println("3) Administrator\n");

            System.out.println(statusMessage);
            System.out.print("> "); // User prompt
            userInput = objScanner.next();

            // Check if "quit" or "exit" was typed
            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                System.out.println("Now exiting.");
                System.exit(0);
            }

            // Check for non numeric input
            else if (!isNumeric(userInput)) {
                //System.out.println("Invalid input. Please type a valid number:\n");
                statusMessage = "Invalid input. Please type a valid number:";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }

            // Check for input outside scope of 1-3
            else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 3) {
                //System.out.println("Invalid input. Please type a valid number:\n");
                statusMessage = "Invalid input. Please type a valid number:";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }

            // Logic for input 1-3
            else {

                // Option 1) Go to traveller menu 1
                if (Integer.parseInt(userInput) == 1) {
                    mainMenu = false;
                    travellerMenu = true;
                    System.out.println("PLACEHOLDER 1");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                }//END main loop Option 1 if statement

                // Option 2) Go to employee menu 1
                if (Integer.parseInt(userInput) == 2) {
                    mainMenu = false;
                    employeeMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    // --------------------------------------------------------------------------------------------------
                    // --                   Employee Loop - loop until user types valid numeric input                  --
                    // --------------------------------------------------------------------------------------------------
                    while (employeeMenu) {

                        System.out.println("EMPLOYEE MAIN MENU\n");

                        System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
                        System.out.println("1) Manage flights");
                        System.out.println("2) Return to Main Menu\n");

                        System.out.println(statusMessage);
                        System.out.print("> "); // User prompt
                        userInput = objScanner.next();

                        // Check if "quit" or "exit" was typed
                        if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                            System.out.println("Now exiting.");
                            System.exit(0);
                        }

                        // Check for non numeric input
                        else if (!isNumeric(userInput)) {
                            statusMessage = "Invalid input. Please type a valid number:";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                        }

                        // Check for input outside scope of 1-2
                        else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 2) {
                            statusMessage = "Invalid input. Please type a valid number:";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                        }

                        // Logic for input 1-2
                        else {
                            // Go to flight management
                            if (Integer.parseInt(userInput) == 1) {
                                //employeeMenu = false;
                                System.out.println("PLACEHOLDER FLIGHT MANAGEMENT");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Return to Main Menu
                            if (Integer.parseInt(userInput) == 2) {
                                employeeMenu = false;
                                mainMenu = true;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                        }

                    }//END Employee while loop
                    // --------------------------------------------------------------------------------------------------
                    // --                                   END Employee Loop                                          --
                    // --------------------------------------------------------------------------------------------------

                }//END main loop Option 2 if statement

                // Option 3) Go to administrator menu 1
                if (Integer.parseInt(userInput) == 3) {
                    mainMenu = false;
                    administratorMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    // --------------------------------------------------------------------------------------------------
                    // --                     Admin Loop - loop until user types valid numeric input                   --
                    // --------------------------------------------------------------------------------------------------
                    while (administratorMenu) {

                        System.out.println("ADMINISTRATOR MAIN MENU\n");

                        System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
                        System.out.println("1) Add/Update/Delete/View Flights");
                        System.out.println("2) Add/Update/Delete/View Seats");
                        System.out.println("3) Add/Update/Delete/View Tickets and Passengers");
                        System.out.println("4) Add/Update/Delete/View Airports");
                        System.out.println("5) Add/Update/Delete/View Travelers");
                        System.out.println("6) Add/Update/Delete/View Employees");
                        System.out.println("7) Override Ticket Cancellation");
                        System.out.println("8) Return to Main Menu\n");

                        System.out.println(statusMessage);
                        System.out.print("> "); // User prompt
                        userInput = objScanner.next();

                        // Check if "quit" or "exit" was typed
                        if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                            System.out.println("Now exiting.");
                            System.exit(0);
                        }

                        // Check for non numeric input
                        else if (!isNumeric(userInput)) {
                            statusMessage = "Invalid input. Please type a valid number:";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                        }

                        // Check for input outside scope of 1-8
                        else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 8) {
                            statusMessage = "Invalid input. Please type a valid number:";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                        }

                        // Logic for input 1-8
                        else {

                            // Flights
                            if (Integer.parseInt(userInput) == 1) {
                                System.out.println("PLACEHOLDER FLIGHTS");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Seats
                            if (Integer.parseInt(userInput) == 2) {
                                System.out.println("PLACEHOLDER SEATS");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Tickets and Passengers
                            if (Integer.parseInt(userInput) == 3) {
                                System.out.println("PLACEHOLDER TICKETS AND PASSENGERS");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Airports
                            if (Integer.parseInt(userInput) == 4) {
                                System.out.println("PLACEHOLDER AIRPORTS");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Travellers
                            if (Integer.parseInt(userInput) == 5) {
                                System.out.println("PLACEHOLDER TRAVELLERS");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Employees
                            if (Integer.parseInt(userInput) == 6) {
                                System.out.println("PLACEHOLDER EMPLOYEES");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Ticket Cancellation
                            if (Integer.parseInt(userInput) == 7) {
                                System.out.println("PLACEHOLDER TICKET CANCELLATION");
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                            // Return to Main Menu
                            if (Integer.parseInt(userInput) == 8) {
                                administratorMenu = false;
                                mainMenu = true;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }

                        }

                    }//END Admin while loop
                    // --------------------------------------------------------------------------------------------------
                    // --                                      END Admin Loop                                          --
                    // --------------------------------------------------------------------------------------------------

                }//END main loop Option 3 if statement

            }//END final else for main menu input (goes to Options 1-3)

        }//END MAIN while loop

    }//END main

}//END Main