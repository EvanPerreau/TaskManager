package fr.evanperreau.dao;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.SQLException;

public class SqliteScriptRunner {

    private static ScriptRunner getScriptRunner() throws SQLException {
        if (SqliteConnection.connection == null) {
            SqliteConnection.Open();
        }

        return new ScriptRunner(SqliteConnection.connection);
    }

    public static void runScript(String scriptPath) throws SQLException, FileNotFoundException {
        SqliteConnection.Open();

        Reader scriptReader = new BufferedReader(new FileReader(scriptPath));

        getScriptRunner().runScript(scriptReader);

        SqliteConnection.Close();
    }
}