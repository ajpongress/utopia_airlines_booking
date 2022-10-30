package UserAdministrator;

import Employees_pckg.EmployeeDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employees {

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
    // --                Employees                  --
    // -----------------------------------------------
    public boolean employeesMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        // Employees loop
        while (true) {

            System.out.println("ADMINISTRATOR - EMPLOYEES MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Delete Employee");
            System.out.println("4) View Employees");
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
            // --                                        Add Employee                                             --
            // -----------------------------------------------------------------------------------------------------

            if (Integer.parseInt(userInput) == 1) {


            }

            // -----------------------------------------------------------------------------------------------------
            // --                                       Update Employee                                           --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 2) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                       Delete Employee                                           --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 3) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                        View Employees                                           --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 4) {

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
