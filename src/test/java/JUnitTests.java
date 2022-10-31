import Airport_pckg.AirportDAO;

import Booking_pckg.BookingDAO;
import Employees_pckg.EmployeeDAO;
import Flights_pckg.FlightDAO;
import Flights_pckg.Flight_DetailsDAO;
import Traveler_pckg.TravelerDAO;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("myCustomTag")
public class JUnitTests {

    // Test airport add, update ICAO, update city, update airport name, update airport ID, delete methods
    @Test
    public void adds_TSTA_airport_updates_TSTA_to_TSTB_updates_TestCityA_to_TestCityB_updates_TestnameA_to_TestnameB_updates_999_to_998_deletes_TSTB() throws SQLException, ClassNotFoundException {

        AirportDAO testAirportDAO = new AirportDAO();
        assertTrue(testAirportDAO.addAirport("TSTA", "Test City A", "Test name A", 999));
        assertTrue(testAirportDAO.updateAirportICAO("TSTA", "TSTB"));
        assertTrue(testAirportDAO.updateAirportCity("TSTB", "Test City B"));
        assertTrue(testAirportDAO.updateAirportName("TSTB", "Test name B"));
        assertTrue(testAirportDAO.updateAirportID("TSTB", 998));
        assertTrue(testAirportDAO.deleteAirport("TSTB"));
    }

    // Test airport view (print)
    @Test
    public void should_connect_and_print_tbl_airport() throws SQLException, ClassNotFoundException {

        AirportDAO testAirportDAO = new AirportDAO();
        testAirportDAO.viewAirports();
    }

    // Test traveler add, update name, update address, update phone, update email, update dob, delete methods
    @Test
    public void adds_Bob_Smith_updates_Bob_Smith_to_Steve_Green_updates_111_Bit_Lane_to_222_Bit_Lane_updates_111_111_1111_to_222_222_2222_updates_bobsmith_at_sstack_to_stevesmith_at_sstack_updates_1_1_11_to_2_2_22_deletes_steve_green() throws SQLException, ClassNotFoundException {

        TravelerDAO testTravelerDAO = new TravelerDAO();
        assertTrue(testTravelerDAO.addTraveler("Bob Smith", "111 Bit Lane", "111-111-1111", "bobsmith@sstack.com", "1-1-11"));
        assertTrue(testTravelerDAO.updateTravelerName("Bob Smith", "Steve Green"));
        assertTrue(testTravelerDAO.updateTravelerAddress("Steve Green", "222 Bit Lane"));
        assertTrue(testTravelerDAO.updateTravelerPhone("Steve Green", "222-222-2222"));
        assertTrue(testTravelerDAO.updateTravelerEmail("Steve Green", "stevegreen@sstack.com"));
        assertTrue(testTravelerDAO.updateTravelerDob("Steve Green", "2-2-22"));
        assertTrue(testTravelerDAO.deleteTraveler("Steve Green"));
    }

    // Test traveler view (print)
    @Test
    public void should_connect_and_print_tbl_traveler() throws SQLException, ClassNotFoundException {

        TravelerDAO testTravelerDAO = new TravelerDAO();
        testTravelerDAO.viewTravelers();
    }

    // Test flight details add/delete methods
    @Test
    public void adds_flight_detail_900_from_KSEA_to_KJFK_and_deletes_flight_900() throws SQLException, ClassNotFoundException {

        Flight_DetailsDAO testFlight_DetailsDAO = new Flight_DetailsDAO();
        testFlight_DetailsDAO.addFlightDetails("900", "KSEA","KJFK");
        testFlight_DetailsDAO.deleteFlight_Details("900");
    }

    // Test flight details view (print)
    @Test
    public void should_connect_and_print_tbl_flight_details() throws SQLException, ClassNotFoundException {

        Flight_DetailsDAO testFlight_DetailsDAO = new Flight_DetailsDAO();
        testFlight_DetailsDAO.viewFlight_Details();
    }

    // Test flight add/delete methods
    @Test
    public void adds_flight_100_departing_2000_1_1_arriving_2000_1_1_78_seatsavailable_price_454_19_and_deletes_based_on_flight_100() throws SQLException, ClassNotFoundException {

        FlightDAO testFlightDAO = new FlightDAO();
        testFlightDAO.addFlight("2000/01/01", 78, 454.19, "2000/01/01", "100");
        testFlightDAO.deleteFlight("100");
    }

    // Test flights view (print)
    @Test
    public void should_connect_and_print_tbl_flight() throws SQLException, ClassNotFoundException {

        FlightDAO testFlightDAO = new FlightDAO();
        testFlightDAO.viewFlights();
    }

    // Test employee add/delete methods
    @Test
    public void adds_employee_Michael_Scott_with_email_michaelscott_at_sstack_with_password_bestbossinworld_enabled1_locked0_userRole23_and_deletes_Michael_Scott() throws SQLException, ClassNotFoundException {

        EmployeeDAO testEmployeeDAO = new EmployeeDAO();
        testEmployeeDAO.addEmployee("bestbossinworld", "michaelscott@dundermifflin.com", "Michael", "Scott", 1, 0, 23);
        testEmployeeDAO.deleteEmployee("Scott");
    }

    // Test employee view (print)
    @Test
    public void should_connect_and_print_tbl_users() throws SQLException, ClassNotFoundException {

        EmployeeDAO testEmployeeDAO = new EmployeeDAO();
        testEmployeeDAO.viewEmployees();
    }

    // Test booking add/delete methods (dependent on foreign key userId from tbl_users)
    @Test
    public void adds_booking_active_1_stripeId_66_bookerId_103_and_deletes_based_on_stripeId_66() throws SQLException, ClassNotFoundException {

        BookingDAO testBookingDAO = new BookingDAO();
        testBookingDAO.addBooking(1, "66", 103);
        testBookingDAO.deleteBooking("66");
    }

    // Test bookings view (print)
    @Test
    public void should_connect_and_print_tbl_booking() throws SQLException, ClassNotFoundException {

        BookingDAO testBookingDAO = new BookingDAO();
        testBookingDAO.viewBookings();
    }



}
