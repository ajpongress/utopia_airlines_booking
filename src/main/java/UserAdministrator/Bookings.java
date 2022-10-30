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
