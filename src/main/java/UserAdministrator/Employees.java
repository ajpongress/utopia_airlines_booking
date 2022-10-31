package UserAdministrator;

import Airport_pckg.AirportDAO;
import Employees_pckg.EmployeeDAO;
import Traveler_pckg.TravelerDAO;

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
            // Check for non numeric input
            else if (!isNumeric(userInput)) {
                statusMessage = "Invalid input. Please type a valid number:";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }
            // Check for input outside scope of 1-5
            else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 5) {
                statusMessage = "Invalid input. Please type a valid number:";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
            }
            // Logic for Airports input 1-5
            else {

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
                        String storedPassword = null;
                        String storedEmail = null;
                        String storedFirstName = null;
                        String storedLastName = null;
                        int storedEnabled = -1;
                        int storedLocked = -1;
                        int storedUserRole = -1;
                        int inputCounter = 1;

                        System.out.println("ADMINISTRATOR - ADD EMPLOYEE\n");

                        System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                        System.out.println("(Type \"goback\" to return to previous menu)\n");

                        System.out.println("Input in order: First name, last name, email, password, enabled, locked, user role:\n");

                        // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                        // Get input of first name 1st
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

                            // Input checks

                            storedFirstName = userInput;
                            statusMessage = "First name - " + storedFirstName + " - was accepted";
                            inputCounter++; // Increase to 2
                        }

                        // Get input of last name 2nd
                        while(inputCounter == 2) {

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

                            // Input checks
                            storedLastName = userInput;
                            statusMessage = "Last name - " + storedLastName + " - was accepted";
                            inputCounter++; // Increase to 3
                        }

                        // Get input of email 3rd
                        while(inputCounter == 3) {

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

                            // Input checks
                            storedEmail = userInput;
                            statusMessage = "Email - " + storedEmail + " - was accepted";
                            inputCounter++; // Increase to 4
                        }

                        // Get input of password 4th
                        while(inputCounter == 4) {

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

                            // Input checks
                            storedPassword = userInput;
                            statusMessage = "Password - " + storedPassword + " - was accepted";
                            inputCounter++; // Increase to 5
                        }

                        // Get input of enabled 5th
                        while(inputCounter == 5) {

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

                            // Input checks
                            storedEnabled = Integer.parseInt(userInput);
                            statusMessage = "Enabled value - " + storedEnabled + " - was accepted";
                            inputCounter++; // Increase to 6
                        }

                        // Get input of locked 6th
                        while(inputCounter == 6) {

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

                            // Input checks
                            storedLocked = Integer.parseInt(userInput);
                            statusMessage = "Locked value - " + storedLocked + " - was accepted";
                            inputCounter++; // Increase to 7
                        }

                        // Get input of user role 7th
                        while(inputCounter == 7) {

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

                            // Input checks
                            storedUserRole = Integer.parseInt(userInput);

                            // Connect to SQL database
                            EmployeeDAO objEmployeeDAO = new EmployeeDAO();
                            if(objEmployeeDAO.addEmployee(storedPassword, storedEmail, storedFirstName, storedLastName, storedEnabled, storedLocked, storedUserRole)) {
                                statusMessage = "Employee successfully added";
                            }
                            else {
                                statusMessage = "Something went wrong. Employee was not added";
                            }
                            break;
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

                        // Delete employee loop
                        while (true) {
                            // Locals
                            String storedLastName = null;

                            System.out.println("ADMINISTRATOR - DELETE EMPLOYEE\n");

                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                            System.out.println("Input last name:");

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
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            storedLastName = userInput;

                            // Connect to database
                            EmployeeDAO objEmployeeDAO = new EmployeeDAO();
                            if (objEmployeeDAO.deleteEmployee(storedLastName)) {
                                statusMessage = "Airport successfully deleted";
                            }
                            else {
                                statusMessage = "Something went wrong. Airport was not deleted";
                            }
                            break;

                        }//END delete airport while loop
                    }
                }

                // -----------------------------------------------------------------------------------------------------
                // --                                        View Employees                                           --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 4) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        EmployeeDAO objEmployeeDAO = new EmployeeDAO();
                        System.out.println("\n");
                        objEmployeeDAO.viewEmployees();
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



        }

        return true;
    }
}
