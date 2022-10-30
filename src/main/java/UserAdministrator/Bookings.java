package UserAdministrator;

import Booking_pckg.BookingDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bookings {

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
    // --                 Bookings                  --
    // -----------------------------------------------
    public boolean bookingsMenus(String userInput, String statusMessage, BufferedReader objBuffRead) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        boolean bookingAddMenu = false;

        // Bookings loop
        while (true) {

            System.out.println("ADMINISTRATOR - BOOKINGS MENU\n");

            System.out.println("(Type a valid number, or type \"quit\" or \"exit\" to quit program at any time)\n");
            System.out.println("1) Add Booking");
            System.out.println("2) Update Booking");
            System.out.println("3) Delete Booking");
            System.out.println("4) View Bookings");
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
            // --                                         Add Booking                                             --
            // -----------------------------------------------------------------------------------------------------
            if (Integer.parseInt(userInput) == 1) {

                bookingAddMenu = true;
                statusMessage = "";
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen

                // Add booking loop
                while (bookingAddMenu) {
                    // Locals
                    int storedIsActive = -1;
                    String storedStripeId = null;
                    int storedBookerId = -1;
                    int inputCounter = 1;

                    System.out.println("ADMINISTRATOR - ADD BOOKING\n");

                    System.out.println("(Type \"quit\" or \"exit\" to quit program at any time)");
                    System.out.println("(Type \"goback\" to return to previous menu)\n");

                    System.out.println("Input in order: Is Active flag, Stripe Id, Booker Id:\n");

                    // Use int counters and loops to keep track of proper input sequence and store values only with proper input

                    // Get input of is active flag 1st
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
                            bookingAddMenu = false;
                            statusMessage = "";
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear screen
                            break;
                        }


                    }

                    // Get input of stripe Id 2nd
                    while(inputCounter == 2) {

                    }

                    // Get input of booker Id 3rd
                    while(inputCounter == 3) {

                    }

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                       Update Booking                                            --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 2) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                       Delete Booking                                            --
            // -----------------------------------------------------------------------------------------------------
            if (isNumeric(userInput)) {
                if (Integer.parseInt(userInput) == 3) {

                }
            }

            // -----------------------------------------------------------------------------------------------------
            // --                                        View Bookings                                            --
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
