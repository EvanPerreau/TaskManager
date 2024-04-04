package fr.evanperreau.dao;

import fr.evanperreau.error.SqlFileNotFoundError;

import java.net.URL;
import java.sql.SQLException;

public class SqliteInitializer {

    public static void Initialize() throws SQLException {

        URL schemaUrl = ClassLoader.getSystemClassLoader().getResource("database/schema.sql");

        if (schemaUrl == null) {
            throw new SqlFileNotFoundError("Schema file not found");
        }

        try {
            SqliteScriptRunner.runScript(schemaUrl.getPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
