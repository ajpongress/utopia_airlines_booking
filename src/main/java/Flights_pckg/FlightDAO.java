package Flights_pckg;

import Utility.SQLConnect_Singleton;
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

    // View flights in database
    public boolean viewFlights() throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();

        String query = "SELECT * FROM tbl_flight";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            ResultSet resultSet = prepstmt.executeQuery();
            conn.commit();
            conn.setAutoCommit(true);

            String column1Format = "%-12.12s";
            String column2Format = "%-15.15s";
            String column3Format = "%-30.30s";
            String column4Format = "%-15.10s";
            String column5Format = "%-15.10s";
            String column6Format = "%-10.10s";
            String formatInfo = column1Format + " " + column2Format + " " + column3Format + " " + column4Format + " " + column5Format + " " + column6Format;

            System.out.format(formatInfo, "Flight ID", "Flight Number", "Dep Time", "Arr Time", "Seats", "Price");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------");

            while (resultSet.next()) {

                int flightId = resultSet.getInt("flightId");
                String flightNumber = resultSet.getString("flightNumber");
                String deptime = resultSet.getString("departTime");
                String arrtime = resultSet.getString("arrivalTime");
                String seats = resultSet.getString("seatsAvailable");
                String price = resultSet.getString("price");

                System.out.format(formatInfo, flightId, flightNumber, deptime, arrtime, seats, price);
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
