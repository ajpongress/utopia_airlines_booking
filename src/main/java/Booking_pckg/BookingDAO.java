package Booking_pckg;

import Employees_pckg.EmployeeDTO;
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

    // Delete booking
    public boolean deleteBooking(String stripeId) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        BookingDTO objBookingDTO = new BookingDTO(0, stripeId, 0);

        String query = "DELETE FROM tbl_booking WHERE stripeId=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objBookingDTO.getStripeId());
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
