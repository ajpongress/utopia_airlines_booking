import Airport_pckg.*;
import UserAdministrator.Administrator;
import UserEmployee.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

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

    // main - run commands
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException, SQLException, ClassNotFoundException {

        // ---------------------- DEBUG -------------------------

        // ---------------------- DEBUG -------------------------


        // Globals
        BufferedReader objBuffRead = new BufferedReader(new InputStreamReader(System.in));
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
            userInput = objBuffRead.readLine();

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
            // Logic for Main Menu input 1-3
            else {

                // Option 1) Go to traveller menu 1
                if (Integer.parseInt(userInput) == 1) {
                    //mainMenu = false;
                    //travellerMenu = true;
                    System.out.println("PLACEHOLDER 1");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    // --------------------------------------------------------------------------------------------------
                    // --                  Traveler Loop - loop until user types valid numeric input                  --
                    // --------------------------------------------------------------------------------------------------

                    //END Traveler while loop
                    // --------------------------------------------------------------------------------------------------
                    // --                                   END Traveler Loop                                         --
                    // --------------------------------------------------------------------------------------------------
                }//END main loop Option 1 if statement

                // Option 2) Go to employee menu 1
                if (Integer.parseInt(userInput) == 2) {

                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    Employee objEmployee = new Employee();
                    mainMenu = ( objEmployee.employeeMenus(userInput, statusMessage, objBuffRead) ); // Method returns true to keep user in main menu while loop

                }

                // Option 3) Go to administrator menu 1
                if (Integer.parseInt(userInput) == 3) {
                    mainMenu = false;
                    administratorMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    Administrator objAdministrator = new Administrator();
                    mainMenu = ( objAdministrator.administratorMenus(userInput, statusMessage, objBuffRead) );

                }

            }//END final else for main menu input (for Options 1-3)

        }//END MAIN while loop

    }//END main

}//END Main