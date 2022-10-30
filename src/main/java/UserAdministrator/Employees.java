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

        boolean employeeAddMenu = false;

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

               employeeAddMenu = true;
                statusMessage = "";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                // Add employee loop
                while (employeeAddMenu) {
                    // Locals
                    int storedRoleId = -1;
                    String storedFirstName = null;
                    String storedLastName = null;
                    String storedUserName = null;
                    String storedEmail = null;
                    String storedPassword = null;
                    String storedPhone = null;
                    int inputCounter = 1;

                    System.out.println("ADMINISTRATOR - ADD EMPLOYEE\n");

                    System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                    System.out.println("(Type \"goback\" to return to previous menu)\n");

                    System.out.println("Input in order: Role Id, First Name, Last Name, Phone Number, Email, Username, Password:\n");

                    // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                    // Get input of Role Id 1st
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
                            employeeAddMenu = false;
                            statusMessage = "";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            break;
                        }


                    }

                    // Get input of first name 2nd
                    while(inputCounter == 2) {

                    }

                    // Get input of last name 3rd
                    while(inputCounter == 3) {

                    }

                    // Get input of phone number 4th
                    while(inputCounter == 4) {

                    }

                    // Get input of email 5th
                    while(inputCounter == 5) {

                    }

                    // Get input of username 6th
                    while(inputCounter == 6) {

                    }

                    // Get input of password 7th
                    while(inputCounter == 7) {

                    }
                }
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
