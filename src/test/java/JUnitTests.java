import Airport_pckg.AirportDAO;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("myCustomTag")
public class JUnitTests {

    // Test add and delete airport methods
    @Test
    public void addAirport_should_add_KFAT_Fresno_FresnoYosemiteInternationalAirport_1_to_utopia_tbl_airport_and_deleteAirport_should_remove_it() throws SQLException, ClassNotFoundException {

        AirportDAO testAirportDAO = new AirportDAO();
        assertTrue(testAirportDAO.addAirport("TST1", "Test City", "Test name", 999));
        assertTrue(testAirportDAO.deleteAirport("TST1", 999));
    }
}
