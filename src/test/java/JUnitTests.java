import Airport_pckg.AirportDAO;

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


}
