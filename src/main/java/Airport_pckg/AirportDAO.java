package Airport_pckg;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class AirportDAO {

    // Add airport
    public boolean addAirport(String iataIdent, String city, String name, int airportId) throws SQLException, ClassNotFoundException {

        AirportDTO objAirportDTOadd = new AirportDTO(iataIdent, city, name, airportId);
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "INSERT INTO tbl_airport(iataIdent, city, name, airportId) VALUES ( ?, ?, ?, ?)";
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTOadd.getIataIdent());
            prepstmt.setString(2, objAirportDTOadd.getCity());
            prepstmt.setString(3, objAirportDTOadd.getName());
            prepstmt.setInt(4, objAirportDTOadd.getAirportId());
            prepstmt.executeUpdate();
            return true;

        } finally {
            if (conn != null) conn.close();
        }
    }

    // Delete Airport based on iataIdent or airportId
    public boolean deleteAirport(String iataIdent,int airportId) throws SQLException, ClassNotFoundException {

        AirportDTO objAirportDTOdelete = new AirportDTO(iataIdent, "", "", airportId);
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/utopia";
            conn = DriverManager.getConnection(url, "sstack", "password");

            String query = "DELETE FROM tbl_airport WHERE iataIdent=? OR airportId=?";
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objAirportDTOdelete.getIataIdent());
            prepstmt.setInt(2, objAirportDTOdelete.getAirportId());
            prepstmt.executeUpdate();
            return true;

        } finally {
            if (conn != null) conn.close();
        }
    }


}
