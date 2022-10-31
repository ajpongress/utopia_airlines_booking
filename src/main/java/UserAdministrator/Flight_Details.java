package UserAdministrator;

import Flights_pckg.Flight_DetailsDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Flight_Details {

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
    // --              Flight Details               --
    // -----------------------------------------------
    public boolean flightDetailsMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        boolean flightDetailsAddMenu = false;

        // Flight Details loop
        while (true) {

            System.out.println("ADMINISTRATOR - FLIGHT DETAILS MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Flight Detail");
            System.out.println("2) Update Flight Detail");
            System.out.println("3) Delete Flight Detail");
            System.out.println("4) View Flight Details");
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
                // --                                      Add Flight Detail                                          --
                // -----------------------------------------------------------------------------------------------------
                if (Integer.parseInt(userInput) == 1) {

                    flightDetailsAddMenu = true;
                    statusMessage = "";
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                    // Add flight details loop
                    while (flightDetailsAddMenu) {
                        // Locals
                        String storedflightNumber = null;
                        String storedDepartCityId = null;
                        String storedArriveCityId = null;
                        int inputCounter = 1;

                        System.out.println("ADMINISTRATOR - ADD FLIGHT DETAILS\n");

                        System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                        System.out.println("(Type \"goback\" to return to previous menu)\n");

                        System.out.println("Input in order: Flight Number, Departure Airport Id, Arrival Airport Id:\n");

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
                                flightDetailsAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks

                            storedflightNumber = userInput;
                            statusMessage = "Flight Number - " + storedflightNumber + " - was accepted";
                            inputCounter++; // Increase to 2

                        }

                        // Get input of depart airport id 2nd
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
                                flightDetailsAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedDepartCityId = userInput;
                            statusMessage = "Departure Airport Id - " + storedDepartCityId + " - was accepted";
                            inputCounter++; // Increase to 3
                        }

                        // Get input of arrive airport id 3rd
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
                                flightDetailsAddMenu = false;
                                statusMessage = "";
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                                break;
                            }

                            // Input checks
                            storedArriveCityId = userInput;

                            // Connect to SQL database
                            Flight_DetailsDAO objFlight_DetailsDAO = new Flight_DetailsDAO();
                            if(objFlight_DetailsDAO.addFlightDetails(storedflightNumber, storedDepartCityId, storedArriveCityId)) {
                                statusMessage = "Flight details successfully added";
                            }
                            else {
                                statusMessage = "Something went wrong. Flight details were not added";
                            }
                            break;
                        }

                    }
                }

                // -----------------------------------------------------------------------------------------------------
                // --                                    Update Flight Detail                                         --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 2) {

                    }
                }

                // -----------------------------------------------------------------------------------------------------
                // --                                    Delete Flight Detail                                         --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 3) {

                        // Delete flight details loop
                        while (true) {
                            // Locals
                            String storedFlightNumber = null;

                            System.out.println("ADMINISTRATOR - DELETE FLIGHT DETAILS\n");

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
                            Flight_DetailsDAO objFlight_DetailsDAO = new Flight_DetailsDAO();
                            if (objFlight_DetailsDAO.deleteFlight_Details(storedFlightNumber)) {
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
                // --                                     View Flight Details                                         --
                // -----------------------------------------------------------------------------------------------------
                if (isNumeric(userInput)) {
                    if (Integer.parseInt(userInput) == 4) {
                        statusMessage = "";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                        Flight_DetailsDAO objFlight_DetailsDAO = new Flight_DetailsDAO();
                        System.out.println("\n");
                        objFlight_DetailsDAO.viewFlight_Details();
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
