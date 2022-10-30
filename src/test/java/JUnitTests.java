import Airport_pckg.AirportDAO;

import Traveler_pckg.TravelerDAO;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
