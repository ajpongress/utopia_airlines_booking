package Flights_pckg;

import Traveler_pckg.TravelerDTO;
import Utility.SQLConnect_Singleton;

import java.math.BigDecimal;
import java.sql.*;

public class FlightDAO {

    // Add flight
    public boolean addFlight(String departTime, int seatsAvailable, double price, String arrivalTime, String flightNumber) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        FlightDTO objFlightDTO = new FlightDTO(departTime, seatsAvailable, price, arrivalTime, flightNumber);

        String query = "INSERT INTO tbl_flight(departTime, seatsAvailable, price, arrivalTime, flightNumber) VALUES ( ?, ?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objFlightDTO.getDepartTime());
            prepstmt.setInt(2, objFlightDTO.getSeatsAvailable());
            prepstmt.setDouble(3, objFlightDTO.getPrice());
            prepstmt.setString(4, objFlightDTO.getArrivalTime());
            prepstmt.setString(5, objFlightDTO.getFlightNumber());
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

    // Delete flight
    public boolean deleteFlight(String flightNumber) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        FlightDTO objFlightDTO = new FlightDTO("",0,0,"", flightNumber);

        String query = "DELETE FROM tbl_flight WHERE flightNumber=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objFlightDTO.getFlightNumber());
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
