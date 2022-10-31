package Flights_pckg;

import Utility.SQLConnect_Singleton;
import java.sql.*;

public class Flight_DetailsDAO {

    // Add flight details
    public boolean addFlightDetails(String flightNumber, String departCityId, String arriveCityId) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        Flight_DetailsDTO objFlight_DetailsDTO = new Flight_DetailsDTO(flightNumber, departCityId, arriveCityId);

        String query = "INSERT INTO tbl_flight_details (flightNumber, departCityId, arriveCityId) VALUES ( ?, ?, ?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objFlight_DetailsDTO.getFlightNumber());
            prepstmt.setString(2, objFlight_DetailsDTO.getDepartCityId());
            prepstmt.setString(3, objFlight_DetailsDTO.getArriveCityId());
            prepstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            success = true;

        } catch (SQLException sqle) {
            conn.rollback();
            System.out.println("Invalid SQL query: " + sqle);
        } finally {
            if (conn != null) conn.close();
        }
        return success;
    }
}
