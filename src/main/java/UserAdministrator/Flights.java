package UserAdministrator;

import Flights_pckg.FlightDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Flights {

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
    // --                  Flights                  --
    // -----------------------------------------------
    public boolean flightsMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        boolean flightAddMenu = false;

        // Flights loop
        while (true) {

            System.out.println("ADMINISTRATOR - FLIGHTS MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Flight");
            System.out.println("2) Update Flight");
            System.out.println("3) Delete Flight");
            System.out.println("4) View Flights");
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
                // --                                          Add Flight                                             --
                // -----------------------------------------------------------------------------------------------------
                if (Integer.parseInt(userInput) == 1) {

                    flightAddMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    // Add flight loop
                    while (flightAddMenu) {
                        // Locals
                        String storedDepartTime = null;
                        int storedSeatsAvail = -1;
                        double storedPrice = 0;
                        String storedArrivalTime = null;
                        String storedFlightNumber = null;

                        int inputCounter = 1;

                        System.out.println("ADMINISTRATOR - ADD FLIGHT\n");

                        System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                        System.out.println("(Type \"goback\" to return to previous menu)\n");

                        System.out.println("Input in order: Flight Number, Departure Time, Arrival Time, Seats Available, Price:\n");

                        // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                        // Get input of flight number 1st
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
                                flightAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks

                            storedFlightNumber = userInput;
                            statusMessage = "Flight Number - " + storedFlightNumber + " - was accepted";
                            inputCounter++; // Increase to 2

                        }

                        // Get input of departure time 2nd
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
                                flightAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedDepartTime = userInput;
                            statusMessage = "Departure Time - " + storedDepartTime + " - was accepted";
                            inputCounter++; // Increase to 3
                        }

                        // Get input of arrival time 3rd
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
                                flightAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedArrivalTime = userInput;
                            statusMessage = "Arrival time - " + storedArrivalTime + " - was accepted";
                            inputCounter++; // Increase to 4
                        }

                        // Get input of seats available 4th
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
                                flightAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedSeatsAvail = Integer.parseInt(userInput);
                            statusMessage = "Seats Available - " + storedSeatsAvail + " - was accepted";
                            inputCounter++; // Increase to 5
                        }

                        // Get input of price 5th
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
                                flightAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedPrice = Double.parseDouble(userInput);

                            // Connect to SQL database
                            FlightDAO objFlightDAO = new FlightDAO();
                            if(objFlightDAO.addFlight(storedDepartTime, storedSeatsAvail, storedPrice, storedArrivalTime, storedFlightNumber)) {
                                statusMessage = "Flight successfully added";
                            }
                            else {
                                statusMessage = "Something went wrong. Flight was not added";
                            }
                            break;

                        }
                    }
                }

                // -----------------------------------------------------------------------------------------------------
                // --                                        Update Flight                                            --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 2) {

                    }
                }

                // -----------------------------------------------------------------------------------------------------
                // --                                        Delete Flight                                            --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 3) {

                        // Delete flight loop
                        while (true) {
                            // Locals
                            String storedFlightNumber = null;

                            System.out.println("ADMINISTRATOR - DELETE FLIGHT\n");

                            System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                            System.out.println("(Type \"goback\" to return to previous menu)\n");

                            System.out.println("Input flight number:");

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

                            storedFlightNumber = userInput;

                            // Connect to database
                            FlightDAO objFlightDAO = new FlightDAO();
                            if (objFlightDAO.deleteFlight(storedFlightNumber)) {
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
                // --                                         View Flights                                            --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 4) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        FlightDAO objFlightDAO = new FlightDAO();
                        System.out.println("\n");
                        objFlightDAO.viewFlights();
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
