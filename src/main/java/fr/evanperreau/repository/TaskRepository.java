package fr.evanperreau.repository;

import fr.evanperreau.dao.SqliteConnection;
import fr.evanperreau.error.SqlQueryError;
import fr.evanperreau.model.Priorities;
import fr.evanperreau.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {

    /**
     * Get all tasks from the database
     * @return List of tasks
     * @throws SQLException if an error occurs while executing the query
     */
    public List<Task> getTasks() throws SQLException {

        List<Task> result = new ArrayList<Task>();

        try {
            SqliteConnection.Open();

            // the query to get all tasks from the database
            String query = "SELECT * FROM task";

            // execute the query
            ResultSet queryResult = SqliteConnection.connection.prepareStatement(query).executeQuery();

            // iterate over the result set and add each task to the list
            while (queryResult.next()) {
                Timestamp timestamp = queryResult.getTimestamp("dead_line");
                LocalDateTime dateTime = timestamp.toLocalDateTime();

                result.add(new Task(
                        UUID.fromString(queryResult.getString("uuid")),
                        queryResult.getString("title"),
                        queryResult.getString("description"),
                        dateTime,
                        Priorities.valueOf(queryResult.getString("priority"))
                ));
            }
        } catch (Error e) {
            throw new SqlQueryError(e);
        } finally {
            SqliteConnection.Close();
        }

        return result;
    }
}
