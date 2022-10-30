package UserAdministrator;

import Airport_pckg.AirportDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Airports {

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

    // ----------------------------------------------
    // --                 Airports                 --
    // ----------------------------------------------
    public boolean airportsMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        boolean airportMenu = true;
        boolean airportAddMenu = false;
        boolean airportUpdateMenu = false;

        // Airports loop
        while (airportMenu) {

            System.out.println("ADMINISTRATOR - AIRPORTS MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Airport");
            System.out.println("2) Update Airport");
            System.out.println("3) Delete Airport");
            System.out.println("4) View Airports");
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
                // --                                          Add Airport                                            --
                // -----------------------------------------------------------------------------------------------------
                if (Integer.parseInt(userInput) == 1) {
                    airportAddMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    // Add airport loop
                    while (airportAddMenu) {
                        // Locals
                        String storedICAOcode = null;
                        String storedCity = null;
                        String storedName = null;
                        int storedAirportID = -1;
                        int inputCounter = 1;

                        System.out.println("ADMINISTRATOR - ADD AIRPORT\n");

                        System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                        System.out.println("(Type \"goback\" to return to previous menu)\n");

                        System.out.println("Input in order: ICAO code, city name, airport name, and airport ID:\n");

                        // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                        // Get input of ICAO first
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
                                airportAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // ICAO input checks
                            // Check if input is null
                            if (userInput == null) {
                                statusMessage = "Invalid input. Cannot be null";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check ICAO code input length - must be 4 characters long
                            else if (userInput.length() != 4) {
                                statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if ICAO code contains numbers
                            else if (hasNumbers(userInput)) {
                                statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if ICAO code contains special characters
                            else if (hasSpecialChars(userInput)) {
                                statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // ICAO code passed all input checks - store input
                            else {
                                storedICAOcode = userInput;
                                statusMessage = "ICAO code - " + storedICAOcode + " - was accepted";
                                inputCounter++; // Increase to 2
                            }
                        }

                        // Get city name input second
                        while (inputCounter == 2) {

                            System.out.println(statusMessage);
                            System.out.print("> "); // User prompt
                            userInput = objBuffRead.readLine(); // Get input for city name

                            // Check if "quit" or "exit" was typed
                            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                System.out.println("Now exiting.");
                                System.exit(0);
                            }
                            // Check if "goback" was typed
                            if (Objects.equals(userInput, "goback")) {
                                airportAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // City name input checks
                            // Check if input is null
                            if (userInput == null) {
                                statusMessage = "Invalid input. Cannot be null";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if city name contains numbers
                            else if (hasNumbers(userInput)) {
                                statusMessage = "Invalid input. City name cannot contain numbers";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if city name contains special characters
                            else if (hasSpecialChars(userInput)) {
                                statusMessage = "Invalid input. City name cannot contain special characters";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // City name input passed all checks - store input
                            else {
                                storedCity = userInput;
                                statusMessage = "City name - " + storedCity + " - was accepted";
                                inputCounter++; // Increase to 3
                            }
                        }

                        // Get airport name input third
                        while (inputCounter == 3) {

                            System.out.println(statusMessage);
                            System.out.print("> "); // User prompt
                            userInput = objBuffRead.readLine(); // Get input for airport name

                            // Check if "quit" or "exit" was typed
                            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                System.out.println("Now exiting.");
                                System.exit(0);
                            }
                            // Check if "goback" was typed
                            if (Objects.equals(userInput, "goback")) {
                                airportAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Airport name input checks
                            // Check if input is null
                            if (userInput == null) {
                                statusMessage = "Invalid input. Cannot be null";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if airport name contains numbers
                            else if (hasNumbers(userInput)) {
                                statusMessage = "Invalid input. Airport name cannot contain numbers";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if city name contains special characters
                            else if (hasSpecialChars(userInput)) {
                                statusMessage = "Invalid input. Airport name cannot contain special characters";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Airport name input passed all checks - store input
                            else {
                                storedName = userInput;
                                statusMessage = "Airport name - " + storedName + " - was accepted";
                                inputCounter++; // Increase to 4
                            }
                        }

                        // Get airport ID input fourth
                        while (inputCounter == 4) {

                            System.out.println(statusMessage);
                            System.out.print("> "); // User prompt
                            userInput = objBuffRead.readLine(); // Get input for airport name

                            // Check if "quit" or "exit" was typed
                            if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                System.out.println("Now exiting.");
                                System.exit(0);
                            }
                            // Check if "goback" was typed
                            if (Objects.equals(userInput, "goback")) {
                                airportAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // AirportID input checks
                            // Check for non numeric input
                            else if(!isNumeric(userInput)) {
                                statusMessage = "Invalid input. Airport ID must be a number";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // All checks passed ------ add airport to SQL database
                            else {
                                storedAirportID = Integer.parseInt(userInput); // store input

                                // Connect to SQL database and add airport
                                AirportDAO objAirportDAO = new AirportDAO();
                                if(objAirportDAO.addAirport(storedICAOcode, storedCity,storedName, storedAirportID)) {
                                    statusMessage = "Airport successfully added";
                                }
                                else {
                                    statusMessage = "Something went wrong. Airport was not added";
                                }
                                break;
                            }
                        }

                    }//END add airport while loop

                }//END option 1 (add airport)

                // -----------------------------------------------------------------------------------------------------
                // --                                        Update Airport                                           --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 2) {
                        airportUpdateMenu = true;
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        // Update airport loop - choices
                        while (airportUpdateMenu) {
                            System.out.println("ADMINISTRATOR - UPDATE AIRPORTS MENU\n");

                            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
                            System.out.println("1) Update ICAO Code");
                            System.out.println("2) Update City");
                            System.out.println("3) Update Airport Name");
                            System.out.println("4) Update Airport ID");
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

                                // ------------------------------------------------------------------
                                // --                       Update ICAO                            --
                                // ------------------------------------------------------------------
                                if (isNumeric(userInput)) {

                                    if (Integer.parseInt(userInput) == 1) {
                                        airportUpdateMenu = true;
                                        statusMessage = "";
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                                        // Update airport - ICAO loop
                                        while (airportUpdateMenu) {
                                            // Locals
                                            String storedICAOcodeOLD = null;
                                            String storedICAOcodeNEW = null;
                                            int inputCounter = 1;

                                            System.out.println("ADMINISTRATOR - UPDATE AIRPORT - ICAO\n");

                                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                                            System.out.println("Input in order: old ICAO code, new ICAO code:\n");

                                            // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                                            // Get input of old ICAO first
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
                                                    airportUpdateMenu = false;
                                                    userInput = "";
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // ICAO input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check ICAO code input length - must be 4 characters long
                                                else if (userInput.length() != 4) {
                                                    statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // ICAO code passed all input checks - store input
                                                else {
                                                    storedICAOcodeOLD = userInput;
                                                    statusMessage = "Old ICAO code - " + storedICAOcodeOLD + " - was accepted";
                                                    inputCounter++; // Increase to 2
                                                }

                                            }//END get input - old ICAO code loop

                                            // Get input of new ICAO code second
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
                                                    airportUpdateMenu = false;
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // ICAO input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check ICAO code input length - must be 4 characters long
                                                else if (userInput.length() != 4) {
                                                    statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // ICAO code passed all input checks - store input
                                                else {
                                                    storedICAOcodeNEW = userInput;

                                                    // Connect to SQL database and update airport
                                                    AirportDAO objAirportDAO = new AirportDAO();
                                                    if(objAirportDAO.updateAirportICAO(storedICAOcodeOLD, storedICAOcodeNEW)) {
                                                        statusMessage = "Airport ICAO code successfully updated";
                                                    }
                                                    else {
                                                        statusMessage = "Something went wrong. Airport was not updated";
                                                    }
                                                    break;
                                                }

                                            }//END get input - new ICAO code loop

                                        }//END update ICAO loop

                                    }//END update ICAO (input 1)
                                }


                                // ------------------------------------------------------------------
                                // --                         Update City                          --
                                // ------------------------------------------------------------------
                                if (isNumeric(userInput)) {

                                    if (Integer.parseInt(userInput) == 2) {
                                        airportUpdateMenu = true;
                                        statusMessage = "";
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                                        // Update airport - city loop
                                        while (airportUpdateMenu) {
                                            // Locals
                                            String storedICAOcode = null;
                                            String storedCity = null;
                                            int inputCounter = 1;

                                            System.out.println("ADMINISTRATOR - UPDATE AIRPORT - CITY\n");

                                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                                            System.out.println("Input in order: ICAO code (airport to update), city to update to:\n");

                                            // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                                            // Get input of ICAO first
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
                                                    airportUpdateMenu = false;
                                                    userInput = "";
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // ICAO input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check ICAO code input length - must be 4 characters long
                                                else if (userInput.length() != 4) {
                                                    statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // ICAO code passed all input checks - store input
                                                else {
                                                    storedICAOcode = userInput;
                                                    statusMessage = "ICAO code - " + storedICAOcode + " - was accepted";
                                                    inputCounter++; // Increase to 2
                                                }

                                            }//END get input - ICAO code loop

                                            // Get input of city second
                                            while (inputCounter == 2) {

                                                System.out.println(statusMessage);
                                                System.out.print("> "); // User prompt
                                                userInput = objBuffRead.readLine(); // Get input for city name

                                                // Check if "quit" or "exit" was typed
                                                if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                                    System.out.println("Now exiting.");
                                                    System.exit(0);
                                                }
                                                // Check if "goback" was typed
                                                if (Objects.equals(userInput, "goback")) {
                                                    airportUpdateMenu = false;
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // City name input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if city name contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. City name cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if city name contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. City name cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // City name input passed all checks - store input
                                                else {
                                                    storedCity = userInput;

                                                    // Connect to SQL database and update airport
                                                    AirportDAO objAirportDAO = new AirportDAO();
                                                    if(objAirportDAO.updateAirportCity(storedICAOcode, storedCity)) {
                                                        statusMessage = "Airport city successfully updated";
                                                    }
                                                    else {
                                                        statusMessage = "Something went wrong. Airport was not updated";
                                                    }
                                                    break;
                                                }

                                            }//END input - city

                                        }//END update city loop

                                    }//END update city (input 2)
                                }


                                // ------------------------------------------------------------------
                                // --                      Update Airport Name                     --
                                // ------------------------------------------------------------------
                                if (isNumeric(userInput)) {

                                    if (Integer.parseInt(userInput) == 3) {
                                        airportUpdateMenu = true;
                                        statusMessage = "";
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                                        // Update airport - airport name loop
                                        while (airportUpdateMenu) {
                                            // Locals
                                            String storedICAOcode = null;
                                            String storedName = null;
                                            int inputCounter = 1;

                                            System.out.println("ADMINISTRATOR - UPDATE AIRPORT - AIRPORT NAME\n");

                                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                                            System.out.println("Input in order: ICAO code (airport to update), airport name to update to:\n");

                                            // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                                            // Get input of ICAO first
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
                                                    airportUpdateMenu = false;
                                                    userInput = "";
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // ICAO input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check ICAO code input length - must be 4 characters long
                                                else if (userInput.length() != 4) {
                                                    statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // ICAO code passed all input checks - store input
                                                else {
                                                    storedICAOcode = userInput;
                                                    statusMessage = "ICAO code - " + storedICAOcode + " - was accepted";
                                                    inputCounter++; // Increase to 2
                                                }

                                            }//END get input - ICAO code loop

                                            // Get input of airport name second
                                            while (inputCounter == 2) {

                                                System.out.println(statusMessage);
                                                System.out.print("> "); // User prompt
                                                userInput = objBuffRead.readLine(); // Get input for airport name

                                                // Check if "quit" or "exit" was typed
                                                if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                                    System.out.println("Now exiting.");
                                                    System.exit(0);
                                                }
                                                // Check if "goback" was typed
                                                if (Objects.equals(userInput, "goback")) {
                                                    airportUpdateMenu = false;
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // Airport name input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if airport name contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. Airport name cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if city name contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. Airport name cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Airport name input passed all checks - store input
                                                else {
                                                    storedName = userInput;

                                                    // Connect to SQL database and update airport
                                                    AirportDAO objAirportDAO = new AirportDAO();
                                                    if(objAirportDAO.updateAirportName(storedICAOcode, storedName)) {
                                                        statusMessage = "Airport name successfully updated";
                                                    }
                                                    else {
                                                        statusMessage = "Something went wrong. Airport was not updated";
                                                    }
                                                    break;

                                                }

                                            }//END input - airport name

                                        }//END update airport name loop

                                    }//END update airport name (input 3)
                                }


                                // ------------------------------------------------------------------
                                // --                      Update Airport ID                       --
                                // ------------------------------------------------------------------
                                if (isNumeric(userInput)) {

                                    if (Integer.parseInt(userInput) == 4) {
                                        airportUpdateMenu = true;
                                        statusMessage = "";
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                                        // Update airport - airport ID loop
                                        while (airportUpdateMenu) {
                                            // Locals
                                            String storedICAOcode = null;
                                            int storedAirportID = -1;
                                            int inputCounter = 1;

                                            System.out.println("ADMINISTRATOR - UPDATE AIRPORT - AIRPORT ID\n");

                                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                                            System.out.println("Input in order: ICAO code (airport to update), airport ID to update to:\n");

                                            // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                                            // Get input of ICAO first
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
                                                    airportUpdateMenu = false;
                                                    userInput = "";
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // ICAO input checks
                                                // Check if input is null
                                                if (userInput == null) {
                                                    statusMessage = "Invalid input. Cannot be null";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check ICAO code input length - must be 4 characters long
                                                else if (userInput.length() != 4) {
                                                    statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains numbers
                                                else if (hasNumbers(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // Check if ICAO code contains special characters
                                                else if (hasSpecialChars(userInput)) {
                                                    statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // ICAO code passed all input checks - store input
                                                else {
                                                    storedICAOcode = userInput;
                                                    statusMessage = "ICAO code - " + storedICAOcode + " - was accepted";
                                                    inputCounter++; // Increase to 2
                                                }

                                            }//END get input - ICAO code loop

                                            // Get input of airport ID second
                                            while (inputCounter == 2) {

                                                System.out.println(statusMessage);
                                                System.out.print("> "); // User prompt
                                                userInput = objBuffRead.readLine(); // Get input for airport ID

                                                // Check if "quit" or "exit" was typed
                                                if (Objects.equals(userInput, "exit") || Objects.equals(userInput, "quit")) {
                                                    System.out.println("Now exiting.");
                                                    System.exit(0);
                                                }
                                                // Check if "goback" was typed
                                                if (Objects.equals(userInput, "goback")) {
                                                    airportUpdateMenu = false;
                                                    statusMessage = "";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                    break;
                                                }

                                                // AirportID input checks
                                                // Check for non numeric input
                                                else if(!isNumeric(userInput)) {
                                                    statusMessage = "Invalid input. Airport ID must be a number";
                                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                                }
                                                // All checks passed ------ update airport ID to SQL database
                                                else {
                                                    storedAirportID = Integer.parseInt(userInput); // store input

                                                    // Connect to SQL database and add airport
                                                    AirportDAO objAirportDAO = new AirportDAO();
                                                    if(objAirportDAO.updateAirportID(storedICAOcode, storedAirportID)) {
                                                        statusMessage = "Airport ID successfully updated";
                                                    }
                                                    else {
                                                        statusMessage = "Something went wrong. Airport was not updated";
                                                    }
                                                    break;
                                                }

                                            }//END input - airport ID

                                        }//END update airport ID loop

                                    }//END update airport ID (input 4)
                                }


                                // Return to previous menu
                                if (isNumeric(userInput)) {
                                    if (Integer.parseInt(userInput) == 5) {
                                        statusMessage = "";
                                        userInput = "";
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                        airportUpdateMenu = false;
                                        //break;
                                    }
                                }

                            }//END else (input 1-5)

                        }//END update airports menu loop

                    }//END option 2 (update airport)

                }//END update airport main menu

                // -----------------------------------------------------------------------------------------------------
                // --                                        Delete Airport                                           --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 3) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        // Delete airport loop
                        while (true) {
                            // Locals
                            String storedICAOcode = null;

                            System.out.println("ADMINISTRATOR - DELETE AIRPORT\n");

                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                            System.out.println("Input ICAO code:");

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

                            // ICAO input checks
                            // Check if input is null
                            if (userInput == null) {
                                statusMessage = "Invalid input. Cannot be null";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check ICAO code input length - must be 4 characters long
                            else if (userInput.length() != 4) {
                                statusMessage = "Invalid input. ICAO code must be 4 characters long";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if ICAO code contains numbers
                            else if (hasNumbers(userInput)) {
                                statusMessage = "Invalid input. ICAO code cannot contain numbers";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // Check if ICAO code contains special characters
                            else if (hasSpecialChars(userInput)) {
                                statusMessage = "Invalid input. ICAO code cannot contain special characters";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            }
                            // ICAO code passed all input checks - store input
                            else {
                                storedICAOcode = userInput;
                                statusMessage = "ICAO code - " + storedICAOcode + " - was accepted";

                                // All checks passed ------ delete airport to SQL database
                                AirportDAO objAirportDAO = new AirportDAO();
                                if (objAirportDAO.deleteAirport(storedICAOcode)) {
                                    statusMessage = "Airport successfully deleted";
                                }
                                else {
                                    statusMessage = "Something went wrong. Airport was not deleted";
                                }
                                break;
                            }

                        }//END delete airport while loop

                    }//END option 3 (delete airport)
                }//END option 3 (delete airport)

                // -----------------------------------------------------------------------------------------------------
                // --                                         View Airports                                           --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 4) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        // View airports
                        AirportDAO objAirportDAOview = new AirportDAO();
                        System.out.println("\n");
                        objAirportDAOview.viewAirports();
                        System.out.println("\n");

                    }//END option 4 (view airports)
                }

                // Return to previous menu
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 5) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                        //break;
                        airportMenu = false;
                    }
                }

            }//END final else for airports input (for Options 1-5)

        }//END airports while loop

        return true;
    }

}
