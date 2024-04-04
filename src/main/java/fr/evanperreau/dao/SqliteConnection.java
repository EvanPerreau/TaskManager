package fr.evanperreau.dao;

import fr.evanperreau.error.DatabaseNotFoundError;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
    public static Connection connection = null;

    private static Connection connect(String databaseUrl) throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
    }

    public static void Open() throws SQLException {
        if(connection == null || connection.isClosed()){
            URL resourceUrl = ClassLoader.getSystemClassLoader().getResource("database/db.db");

            if(resourceUrl == null){
                throw new DatabaseNotFoundError("Database file not found");
            }

            connection = connect(resourceUrl.getPath());

            // Check if connection is established
            if (connection == null) {
                throw new SQLException("Failed to establish a connection to the database");
            }
        }
    }

    public static void Close() throws SQLException {
        if((connection != null) && !connection.isClosed()) {
            connection.close();
        }
    }

}
