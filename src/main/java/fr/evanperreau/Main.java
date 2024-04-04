package fr.evanperreau;
import fr.evanperreau.dao.SqliteInitializer;
import fr.evanperreau.repository.TaskRepository;

import java.sql.SQLException;

public class Main {

    static TaskRepository taskRepository = new TaskRepository();
    public static void main(String[] args) throws SQLException {
//        TasksManagerService tasksManagerService = new TasksManagerService();
//        Task task = new Task(UUID.randomUUID(), "Test task", "test description", LocalDateTime.of(2025, 9, 20, 12, 52, 30), Priorities.LOW);
//
//        tasksManagerService.addTask(task);
//
//        System.out.println(tasksManagerService.getTask(0));
        try {
            SqliteInitializer.Initialize();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        taskRepository.getTasks().forEach(System.out::println);
    }
}