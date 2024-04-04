package fr.evanperreau.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.UUID;

@Data
public class Task {

    private UUID uuid;
    private String title;
    private String description;
    private LocalDateTime deadLine;
    private Priorities priority;

    public Task(UUID uuid, String title, String description, LocalDateTime deadLine, Priorities priority) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.priority = priority;
    }

    /**
     * @return True if the task is expired, false otherwise
     */
    public boolean isExpired(){
        boolean result = LocalDateTime.now().isAfter(deadLine);

        return result;
    }

    /**
     * @return True if the task expired in 1 day or less, false otherwise
     */
    public boolean isComing(){
        boolean result = LocalDateTime.now().plusDays(1).isAfter(deadLine) && LocalDateTime.now().isBefore(deadLine);

        return result;
    }

    @Override
    public String toString(){
        String result = "";

        result += "title : " + getTitle() + "\n";
        result += "description : " + getDescription() + "\n";
        result += "deadline : " + getDeadLine().format(new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yyyy HH:mm:ss")
                .toFormatter())
                + "\n";
        result += "priority : " + getPriority() + "\n";

        return result;
    }
}
