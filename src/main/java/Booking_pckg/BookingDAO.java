package Booking_pckg;

import Flights_pckg.FlightDTO;
import Utility.SQLConnect_Singleton;
import java.sql.*;

public class BookingDAO {

    // Add booking
    public boolean addBooking(int isActive, String stripeId, int bookerId) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        BookingDTO objBookingDTO = new BookingDTO(isActive, stripeId, bookerId);

        String query = "INSERT INTO tbl_booking (isActive, stripeId, bookerId) VALUES ( ?, ?, ?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setInt(1, objBookingDTO.getIsActive());
            prepstmt.setString(2, objBookingDTO.getStripeId());
            prepstmt.setInt(3, objBookingDTO.getBookerId());
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
