package Employees_pckg;

import Flights_pckg.FlightDTO;
import Flights_pckg.Flight_DetailsDTO;
import Utility.SQLConnect_Singleton;
import java.sql.*;

public class EmployeeDAO {

    // Add employee
    public boolean addEmployee(String password, String email, String firstName, String lastName, int enabled, int locked, int userRole) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        EmployeeDTO objEmployeeDTO = new EmployeeDTO(password, email, firstName, lastName, enabled, locked, userRole);

        String query = "INSERT INTO tbl_users (password, email, firstName, lastName, enabled, locked, userRole) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objEmployeeDTO.getPassword());
            prepstmt.setString(2, objEmployeeDTO.getEmail());
            prepstmt.setString(3, objEmployeeDTO.getFirstName());
            prepstmt.setString(4, objEmployeeDTO.getLastName());
            prepstmt.setInt(5, objEmployeeDTO.getEnabled());
            prepstmt.setInt(6, objEmployeeDTO.getLocked());
            prepstmt.setInt(7, objEmployeeDTO.getUserRole());
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

    // Delete employee
    public boolean deleteEmployee(String lastName) throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();
        EmployeeDTO objEmployeeDTO = new EmployeeDTO("", "", "", lastName, 0, 0, 0);

        String query = "DELETE FROM tbl_users WHERE lastName=?";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setString(1, objEmployeeDTO.getLastName());
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

    // View employees in database
    public boolean viewEmployees() throws SQLException, ClassNotFoundException {

        boolean success = false;
        Connection conn = SQLConnect_Singleton.getInstance().getConnection();

        String query = "SELECT * FROM tbl_users";

        try {
            conn.setAutoCommit(false);
            PreparedStatement prepstmt = conn.prepareStatement(query);
            ResultSet resultSet = prepstmt.executeQuery();
            conn.commit();
            conn.setAutoCommit(true);

            String column1Format = "%-12.12s";
            String column2Format = "%-15.15s";
            String column3Format = "%-15.15s";
            String column4Format = "%-15.10s";
            String column5Format = "%-10.10s";
            String column6Format = "%-10.10s";
            String column7Format = "%-10.10s";
            String column8Format = "%-10.10s";
            String formatInfo = column1Format + " " + column2Format + " " + column3Format + " " + column4Format + " " + column5Format + " " + column6Format + " " + column7Format + " " + column8Format;

            System.out.format(formatInfo, "User Id", "First Name", "Last Name", "Email", "Password", "Enabled", "Locked", "userRole");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------");

            while (resultSet.next()) {

                int userId = resultSet.getInt("userId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int enabled = resultSet.getInt("enabled");
                int locked = resultSet.getInt("locked");
                int userRole = resultSet.getInt("userRole");

                System.out.format(formatInfo, userId, firstName, lastName, email, password, enabled, locked, userRole);
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
