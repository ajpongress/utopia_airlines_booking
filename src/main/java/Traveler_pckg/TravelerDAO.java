package Traveler_pckg;

import Utility.SQLConnect_Singleton;
import java.sql.*;

public class TravelerDAO {

    // Add traveler
    public boolean addTraveler(String name, String address, String phone, String email, String dob) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, address, phone, email, dob);

        String query = "INSERT INTO tbl_traveler(name, address, phone, email, dob) VALUES ( ?, ?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getName());
            prepstmt.setString(2, objTravelerDTO.getAddress());
            prepstmt.setString(3, objTravelerDTO.getPhone());
            prepstmt.setString(4, objTravelerDTO.getEmail());
            prepstmt.setString(5, objTravelerDTO.getDob());
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

    // Delete traveler
    public boolean deleteTraveler(String name) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, "", "", "", "");

        String query = "DELETE FROM tbl_traveler WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getName());
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

    // Update Traveler - name - (finds traveler based on name)
    public boolean updateTravelerName(String nameOLD, String nameNEW) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTOold = new TravelerDTO(nameOLD, "", "", "", "");
        TravelerDTO objTravelerDTOnew = new TravelerDTO(nameNEW, "", "", "", "");

        String query = "UPDATE tbl_traveler SET name=? WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTOnew.getName());
            prepstmt.setString(2, objTravelerDTOold.getName());
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

    // Update Traveler - address - (finds traveler based on name)
    public boolean updateTravelerAddress(String name, String address) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, address, "", "", "");

        String query = "UPDATE tbl_traveler SET address=? WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getAddress());
            prepstmt.setString(2, objTravelerDTO.getName());
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

    // Update Traveler - phone - (finds traveler based on name)
    public boolean updateTravelerPhone(String name, String phone) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, "", phone, "", "");

        String query = "UPDATE tbl_traveler SET phone=? WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getPhone());
            prepstmt.setString(2, objTravelerDTO.getName());
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

    // Update Traveler - email - (finds traveler based on name)
    public boolean updateTravelerEmail(String name, String email) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, "", "", email, "");

        String query = "UPDATE tbl_traveler SET email=? WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getEmail());
            prepstmt.setString(2, objTravelerDTO.getName());
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

    // Update Traveler - dob - (finds traveler based on name)
    public boolean updateTravelerDob(String name, String dob) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        TravelerDTO objTravelerDTO = new TravelerDTO(name, "", "", "", dob);

        String query = "UPDATE tbl_traveler SET dob=? WHERE name=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objTravelerDTO.getDob());
            prepstmt.setString(2, objTravelerDTO.getName());
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

    // View travelers in database
    public boolean viewTravelers() throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();

        String query = "SELECT * FROM tbl_traveler";

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

            System.out.format(formatInfo, "TravelerId", "Name", "Address", "Phone", "Email", "DOB");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------");

            while (resultSet.next()) {

                int travelerId = resultSet.getInt("travelerId");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");

                System.out.format(formatInfo, travelerId, name, address, phone, email, dob);
                System.out.println();
            }

            success = true;

        } catch (SQLException sqle) {
            //conn.rollback();
            System.out.println("Invalid SQL query: " + sqle);
        } finally {
            if (conn != null) conn.close();
        }
        return success;
    }
}
