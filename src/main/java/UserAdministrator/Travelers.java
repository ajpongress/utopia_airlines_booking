package UserAdministrator;

import Traveler_pckg.TravelerDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Travelers {

    // Check if a string is numeric
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

    // -----------------------------------------------
    // --                 Travelers                 --
    // -----------------------------------------------
    public boolean travelersMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        //boolean travelerMenu = true;
        boolean travelerAddMenu = false;

        // Travelers loop
        while (true) {

            System.out.println("ADMINISTRATOR - TRAVELERS MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Traveler");
            System.out.println("2) Update Traveler");
            System.out.println("3) Delete Traveler");
            System.out.println("4) View Travelers");
            System.out.println("5) Return to previous menu\n");

            System.out.println(statusMessage);
            System.out.print("> "); // User prompt
            userInput = objBuffRead.readLine();

            // Check if "quit" or "exit" was typed
            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                System.out.println("Now exiting.");
                System.exit(0);
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                          Add Traveler                                           --
            // -----------------------------------------------------------------------------------------------------

            if (Integer.parseInt(userInput) == 1) {

                travelerAddMenu = true;
                statusMessage = "";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                // Add traveler loop
                while (travelerAddMenu) {
                    // Locals
                    String storedName = null;
                    String storedAddress = null;
                    String storedPhone = null;
                    String storedEmail = null;
                    String storedDob = null;
                    int inputCounter = 1;

                    System.out.println("ADMINISTRATOR - ADD TRAVELER\n");

                    System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                    System.out.println("(Type \"goback\" to return to previous menu)\n");

                    System.out.println("Input in order: Name, Address, Phone Number, Email, DOB:\n");

                    // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                    // Get input of name 1st
                    while(inputCounter == 1) { // Input counter starts at 1

                        System.out.println(statusMessage);
                        System.out.print("> "); // User prompt
                        userInput = objBuffRead.readLine();

                        // Check if "quit" or "exit" was typed
                        if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                            System.out.println("Now exiting.");
                            System.exit(0);
                        }
                        // Check if "goback" was typed
                        if (Objects.equals(userInput, "goback")) {
                            travelerAddMenu = false;
                            statusMessage = "";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            break;
                        }


                    }

                    // Get input of address 2nd
                    while(inputCounter == 2) {

                    }

                    // Get input of phone 3rd
                    while(inputCounter == 3) {

                    }

                    // Get input of email 4th
                    while(inputCounter == 4) {

                    }

                    // Get input of DOB 5th
                    while(inputCounter == 5) {

                    }
                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                        Update Traveler                                          --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 2) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                        Delete Traveler                                          --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 3) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                         View Travelers                                          --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 4) {
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    TravelerDAO objTravelerDAOview = new TravelerDAO();
                    System.out.println("\n");
                    objTravelerDAOview.viewTravelers();
                    System.out.println("\n");
                }
            }

            // Return to previous menu
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 5) {
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    break;
                }
            }

        }

        return true;
    }
}
