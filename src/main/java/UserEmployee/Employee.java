package UserEmployee;

import java.io.IOException;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

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
    // --                   Employee Loop - loop until user types valid numeric input                  --
    // --------------------------------------------------------------------------------------------------
    public boolean employeeMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException {

        while (true) {

            System.out.println("EMPLOYEE MAIN MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Manage flights");
            System.out.println("2) Return to Main Menu\n");

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
            // Check for input outside scope of 1-2
            else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 2) {
                statusMessage = "Invalid input. Please type a valid number:";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }
            // Logic for Employee input 1-2
            else {

                // Go to flight management
                if (Integer.parseInt(userInput) == 1) {
                    //employeeMenu = false;
                    System.out.println("PLACEHOLDER FLIGHT MANAGEMENT");
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                }//END option 1 (flight management)

                // Return to Main Menu
                if (Integer.parseInt(userInput) == 2) {
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                    break;
                }

            }//END final else for employee menu input (for Options 1-2)

        }//END Employee while loop

        return true; // Return to main menu
    }
}
