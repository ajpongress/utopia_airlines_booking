package Airport_pckg;

import java.sql.*;

public class AirportDAO {

    // Add airport
    public boolean addAirport(String iataIdent, String city, String name, int airportId) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null || city == null || name == null || airportId == -1) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTO = new AirportDTO(iataIdent, city, name, airportId);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "INSERT INTO tbl_airport(iataIdent, city, name, airportId) VALUES ( ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTO.getIataIdent());
            prepstmt.setString(2, objAirportDTO.getCity());
            prepstmt.setString(3, objAirportDTO.getName());
            prepstmt.setInt(4, objAirportDTO.getAirportId());
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


    // Update Airport - ICAO code - (finds airport based on ICAO code)
    public boolean updateAirportICAO(String iataIdentOLD, String iataIdentNEW) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdentOLD == null || iataIdentNEW == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTOupdateOLD = new AirportDTO(iataIdentOLD, "", "", 0);
        AirportDTO objAirportDTOupdateNEW = new AirportDTO(iataIdentNEW, "", "", 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "UPDATE tbl_airport SET iataIdent=? WHERE iataIdent=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTOupdateNEW.getIataIdent());
            prepstmt.setString(2, objAirportDTOupdateOLD.getIataIdent());
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

    // Update Airport - city - (finds airport based on ICAO code)
    public boolean updateAirportCity(String iataIdent, String city) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null || city == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTO = new AirportDTO(iataIdent, city, "", 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "UPDATE tbl_airport SET city=? WHERE iataIdent=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTO.getCity());
            prepstmt.setString(2, objAirportDTO.getIataIdent());
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

    // Update Airport - airport name - (finds airport based on ICAO code)
    public boolean updateAirportName(String iataIdent, String name) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null || name == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTO = new AirportDTO(iataIdent, "", name, 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "UPDATE tbl_airport SET name=? WHERE iataIdent=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTO.getName());
            prepstmt.setString(2, objAirportDTO.getIataIdent());
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

    // Update Airport - airport ID - (finds airport based on ICAO code)
    public boolean updateAirportID(String iataIdent, int airportID) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTO = new AirportDTO(iataIdent, "", "", airportID);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "UPDATE tbl_airport SET airportId=? WHERE iataIdent=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setInt(1, objAirportDTO.getAirportId());
            prepstmt.setString(2, objAirportDTO.getIataIdent());
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

    // Delete Airport based on ICAO code
    public boolean deleteAirport(String iataIdent) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTO = new AirportDTO(iataIdent, "", "", 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "DELETE FROM tbl_airport WHERE iataIdent=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTO.getIataIdent());
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

    // View airports in database
    public boolean viewAirports() throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = null;


        return success;
    }

}
