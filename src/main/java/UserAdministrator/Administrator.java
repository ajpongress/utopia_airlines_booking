package UserAdministrator;

import Airport_pckg.AirportDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrator {

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

    // Check if string has special characters
    public static boolean hasSpecialChars(String stringInput) {

        Pattern p = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(stringInput);
        boolean res = m.find();
        if (res) {
            return true;
        }
        return false;
    }

    // Check if string contains numbers
    public static boolean hasNumbers(String stringInput) {

        char[] ch = stringInput.toCharArray();
        StringBuilder strbuild = new StringBuilder();
        for(char c : ch) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------------
    // --                     Admin Loop - loop until user types valid numeric input                   --
    // --------------------------------------------------------------------------------------------------
    public boolean administratorMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        while (true) {

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
            userInput = objBuffRead.readLine();

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
            // Logic for Administrator input 1-8
            else {

                // Flights
                if (Integer.parseInt(userInput) == 1) {
                    System.out.println("PLACEHOLDER FLIGHTS");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 1 (flights)

                // Seats
                if (Integer.parseInt(userInput) == 2) {
                    System.out.println("PLACEHOLDER SEATS");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 2 (seats)

                // Tickets and Passengers
                if (Integer.parseInt(userInput) == 3) {
                    System.out.println("PLACEHOLDER TICKETS AND PASSENGERS");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 3 (tickets and passengers)

                // ----------------------------------------------
                // --                 Airports                 --
                // ----------------------------------------------
                if (Integer.parseInt(userInput) == 4) {
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    Airports objAirports = new Airports();
                    objAirports.airportsMenus(userInput, statusMessage, objBuffRead);
                }

                // Travellers
                if (Integer.parseInt(userInput) == 5) {
                    System.out.println("PLACEHOLDER TRAVELLERS");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 5 (travellers)

                // Employees
                if (Integer.parseInt(userInput) == 6) {
                    System.out.println("PLACEHOLDER EMPLOYEES");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 6 (employees)

                // Ticket Cancellation
                if (Integer.parseInt(userInput) == 7) {
                    System.out.println("PLACEHOLDER TICKET CANCELLATION");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 7 (ticket cancellation)

                // Return to Main Menu
                if (Integer.parseInt(userInput) == 8) {
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    break;
                }

            }//END final else for administrator menu input (for Options 1-8)

        }//END Admin while loop
        // --------------------------------------------------------------------------------------------------
        // --                                      END Admin Loop                                          --
        // --------------------------------------------------------------------------------------------------

        return true;
    }

}