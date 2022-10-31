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

    // Delete flight details
    public boolean deleteFlight_Details(String flightNumber) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        Flight_DetailsDTO objFlight_DetailsDTO = new Flight_DetailsDTO(flightNumber, "", "");

        String query = "DELETE FROM tbl_flight_details WHERE flightNumber=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objFlight_DetailsDTO.getFlightNumber());
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

    // View flight details in database
    public boolean viewFlight_Details() throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();

        String query = "SELECT * FROM tbl_flight_details";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            ResultSet resultSet = prepstmt.executeQuery();
            conn.commit();
            conn.setAutoCommit(true);

            String column1Format = "%-20.20s";
            String column2Format = "%-25.25s";
            String column3Format = "%-25.25s";
            String formatInfo = column1Format + " " + column2Format + " " + column3Format;

            System.out.format(formatInfo, "Flight Number", "Departure Airport", "Arrival Airport");
            System.out.println();
            System.out.println("---------------------------------------------------------------");

            while (resultSet.next()) {

                String flightNumber = resultSet.getString("flightNumber");
                String departCityId = resultSet.getString("departCityId");
                String arriveCityId = resultSet.getString("arriveCityId");

                System.out.format(formatInfo, flightNumber, departCityId, arriveCityId);
                System.out.println();
            }

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
