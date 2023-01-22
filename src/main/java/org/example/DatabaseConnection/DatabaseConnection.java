package org.example.DatabaseConnection;

import org.example.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private DatabaseConnection() {
    }

    public static Connection connect(DataSource dataSource) {
        String url = dataSource.getDriver();
        String user = dataSource.getUserName();
        String password = dataSource.getPassword();

        if (connection == null) {

            try {
                connection =  DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
