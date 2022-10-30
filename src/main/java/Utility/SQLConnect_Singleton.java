package Utility;

import java.sql.*;

public class SQLConnect_Singleton {
    private volatile static SQLConnect_Singleton instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/utopia";
    private String username = "sstack";
    private String password = "password";
    private SQLConnect_Singleton() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection error: " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static SQLConnect_Singleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new SQLConnect_Singleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new SQLConnect_Singleton();
        }
        return instance;
    }

}
