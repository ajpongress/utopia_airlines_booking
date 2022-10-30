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
        AirportDTO objAirportDTOadd = new AirportDTO(iataIdent, city, name, airportId);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "INSERT INTO tbl_airport(iataIdent, city, name, airportId) VALUES ( ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTOadd.getIataIdent());
            prepstmt.setString(2, objAirportDTOadd.getCity());
            prepstmt.setString(3, objAirportDTOadd.getName());
            prepstmt.setInt(4, objAirportDTOadd.getAirportId());
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

    // Delete Airport based on iataIdent
    public boolean deleteAirport(String iataIdent) throws SQLException, ClassNotFoundException {

        // Check for null input
        if (iataIdent == null) {
            return false;
        }
        boolean success = false;
        Connection conn = null;
        AirportDTO objAirportDTOdelete = new AirportDTO(iataIdent, "", "", 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "DELETE FROM tbl_airport WHERE iataIdent=? OR airportId=?";

            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTOdelete.getIataIdent());
            prepstmt.setInt(2, objAirportDTOdelete.getAirportId());
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
